@@ -50,6 +50,7 @@
 #include "runtime/frame.inline.hpp"
 #include "runtime/java.hpp"
 #include "runtime/jniHandles.inline.hpp"
+#include "runtime/mutex.hpp"
 #include "runtime/reflectionUtils.hpp"
 #include "runtime/sharedRuntime.hpp"
 #if INCLUDE_G1GC
@@ -827,62 +828,116 @@ void JVMCINMethodData::invalidate_nmethod_mirror(nmethod* nm) {
   }
 }
 
-JVMCIRuntime::JVMCIRuntime(int id) {
-  _init_state = uninitialized;
-  _shared_library_javavm = NULL;
-  _id = id;
-  _metadata_handles = new MetadataHandles();
-  JVMCI_event_1("created new JVMCI runtime %d (" PTR_FORMAT ")", id, p2i(this));
-}
-
 // Handles to objects in the Hotspot heap.
 static OopStorage* object_handles() {
   return Universe::vm_global();
 }
 
-jobject JVMCIRuntime::make_global(const Handle& obj) {
+jlong JVMCIRuntime::make_oop_handle(const Handle& obj) {
   assert(!Universe::heap()->is_gc_active(), "can't extend the root set during GC");
   assert(oopDesc::is_oop(obj()), "not an oop");
   oop* ptr = object_handles()->allocate();
-  jobject res = NULL;
-  if (ptr != NULL) {
-    assert(*ptr == NULL, "invariant");
+  jlong res = 0;
+  if (ptr != nullptr) {
+    assert(*ptr == nullptr, "invariant");
     NativeAccess<>::oop_store(ptr, obj());
-    res = reinterpret_cast<jobject>(ptr);
+    res = (jlong) ptr;
   } else {
     vm_exit_out_of_memory(sizeof(oop), OOM_MALLOC_ERROR,
                           "Cannot create JVMCI oop handle");
   }
-  MutexLocker ml(JVMCI_lock);
+  MutexLocker ml(_lock);
+  _oop_handles.append(ptr);
   return res;
 }
 
-void JVMCIRuntime::destroy_global(jobject handle) {
+bool JVMCIRuntime::probe_oop_handle(jlong handle, int index) {
+  oop* key = (oop*) handle;
+  if (key == _oop_handles.at(index)) {
+    _last_found_oop_handle_index = index;
+    return true;
+  }
+  return false;
+}
+
+int JVMCIRuntime::find_oop_handle(jlong handle) {
+  int len = _oop_handles.length();
+  int next = _last_found_oop_handle_index + 1;
+  int prev = MAX2(_last_found_oop_handle_index, 0) - 1;
+
+  // Search "outwards" from the index of the last found
+  // entry. Experimentation shows that this significantly
+  // reduces the amount of searching performed.
+  do {
+    if (next < len) {
+      if (probe_oop_handle(handle, next)) {
+        return next;
+      }
+      next++;
+    }
+    if (prev >= 0) {
+      if (probe_oop_handle(handle, prev)) {
+        return prev;
+      }
+      prev--;
+    }
+  } while (next - (prev + 1) < len);
+  return -1;
+}
+
+int JVMCIRuntime::release_and_clear_globals() {
+  int released = 0;
+  if (_oop_handles.length() != 0) {
+    // Squash non-null JNI handles to front of _oop_handles for
+    // the bulk release operation
+    for (int i = 0; i < _oop_handles.length(); i++) {
+      oop* oop_ptr = _oop_handles.at(i);
+      if (oop_ptr != nullptr) {
+        // Satisfy OopHandles::release precondition that all
+        // handles being released are null.
+        NativeAccess<>::oop_store(oop_ptr, (oop) NULL);
+
+        _oop_handles.at_put(released++, oop_ptr);
+      }
+    }
+    // Do the bulk release
+    object_handles()->release(_oop_handles.adr_at(0), released);
+  }
+  _oop_handles.clear();
+  _last_found_oop_handle_index = -1;
+  return released;
+}
+
+void JVMCIRuntime::destroy_oop_handle(jlong handle) {
   // Assert before nulling out, for better debugging.
-  assert(is_global_handle(handle), "precondition");
-  oop* oop_ptr = reinterpret_cast<oop*>(handle);
-  NativeAccess<>::oop_store(oop_ptr, (oop)NULL);
+  assert(is_oop_handle(handle), "precondition");
+  oop* oop_ptr = (oop*) handle;
+  NativeAccess<>::oop_store(oop_ptr, (oop) nullptr);
   object_handles()->release(oop_ptr);
-  MutexLocker ml(JVMCI_lock);
+
+  MutexLocker ml(_lock);
+  int index = find_oop_handle(handle);
+  guarantee(index != -1, "global not allocated in JVMCI runtime %d: " INTPTR_FORMAT, id(), handle);
+  _oop_handles.at_put(index, nullptr);
 }
 
-bool JVMCIRuntime::is_global_handle(jobject handle) {
-  const oop* ptr = reinterpret_cast<oop*>(handle);
+bool JVMCIRuntime::is_oop_handle(jlong handle) {
+  const oop* ptr = (oop*) handle;
   return object_handles()->allocation_status(ptr) == OopStorage::ALLOCATED_ENTRY;
 }
 
 jmetadata JVMCIRuntime::allocate_handle(const methodHandle& handle) {
-  MutexLocker ml(JVMCI_lock);
+  MutexLocker ml(_lock);
   return _metadata_handles->allocate_handle(handle);
 }
 
 jmetadata JVMCIRuntime::allocate_handle(const constantPoolHandle& handle) {
-  MutexLocker ml(JVMCI_lock);
+  MutexLocker ml(_lock);
   return _metadata_handles->allocate_handle(handle);
 }
 
 void JVMCIRuntime::release_handle(jmetadata handle) {
-  MutexLocker ml(JVMCI_lock);
+  MutexLocker ml(_lock);
   _metadata_handles->chain_free_list(handle);
 }
 
@@ -904,27 +959,247 @@ static void _flush_log() {
 
 // Function for shared library JavaVM to exit HotSpot on a fatal error
 static void _fatal() {
+  Thread* thread = Thread::current_or_null_safe();
+  if (thread != nullptr && thread->is_Java_thread()) {
+    JavaThread* jthread = (JavaThread*) thread;
+    JVMCIRuntime* runtime = jthread->libjvmci_runtime();
+    if (runtime != nullptr) {
+      int javaVM_id = runtime->get_shared_library_javavm_id();
+      fatal("Fatal error in JVMCI shared library JavaVM[%d] owned by JVMCI runtime %d", javaVM_id, runtime->id());
+    }
+  }
   intx current_thread_id = os::current_thread_id();
   fatal("thread " INTX_FORMAT ": Fatal error in JVMCI shared library", current_thread_id);
 }
 
-JNIEnv* JVMCIRuntime::init_shared_library_javavm() {
-  JavaVM* javaVM = (JavaVM*) _shared_library_javavm;
-  if (javaVM == NULL) {
+JVMCIRuntime::JVMCIRuntime(JVMCIRuntime* next, int id, bool for_compile_broker) :
+  _init_state(uninitialized),
+  _shared_library_javavm(nullptr),
+  _shared_library_javavm_id(0),
+  _id(id),
+  _next(next),
+  _metadata_handles(new MetadataHandles()),
+  _oop_handles(100, mtJVMCI),
+  _num_attached_threads(0),
+  _for_compile_broker(for_compile_broker),
+  _last_found_oop_handle_index(-1)
+{
+  if (id == -1) {
+    _lock = JVMCIRuntime_lock;
+  } else {
+    stringStream lock_name;
+    lock_name.print("%s@%d", JVMCIRuntime_lock->name(), id);
+    Mutex::Rank lock_rank = DEBUG_ONLY(JVMCIRuntime_lock->rank()) NOT_DEBUG(Mutex::safepoint);
+    _lock = new PaddedMonitor(lock_rank, lock_name.as_string(/*c_heap*/true));
+  }
+  JVMCI_event_1("created new %s JVMCI runtime %d (" PTR_FORMAT ")",
+      id == -1 ? "Java" : for_compile_broker ? "CompileBroker" : "Compiler", id, p2i(this));
+}
+
+JVMCIRuntime* JVMCIRuntime::select_runtime_in_shutdown(JavaThread* thread) {
+  assert(JVMCI_lock->owner() == thread, "must be");
+  // When shutting down, use the first available runtime.
+  for (JVMCIRuntime* runtime = JVMCI::_compiler_runtimes; runtime != nullptr; runtime = runtime->_next) {
+    if (runtime->_num_attached_threads != cannot_be_attached) {
+      runtime->pre_attach_thread(thread);
+      JVMCI_event_1("using pre-existing JVMCI runtime %d in shutdown", runtime->id());
+      return runtime;
+    }
+  }
+  // Lazily initialize JVMCI::_shutdown_compiler_runtime. Safe to
+  // do here since JVMCI_lock is locked.
+  if (JVMCI::_shutdown_compiler_runtime == nullptr) {
+    JVMCI::_shutdown_compiler_runtime = new JVMCIRuntime(nullptr, -2, true);
+  }
+  JVMCIRuntime* runtime = JVMCI::_shutdown_compiler_runtime;
+  JVMCI_event_1("using reserved shutdown JVMCI runtime %d", runtime->id());
+  return runtime;
+}
+
+JVMCIRuntime* JVMCIRuntime::select_runtime(JavaThread* thread, JVMCIRuntime* skip, int* count) {
+  assert(JVMCI_lock->owner() == thread, "must be");
+  bool for_compile_broker = thread->is_Compiler_thread();
+  for (JVMCIRuntime* runtime = JVMCI::_compiler_runtimes; runtime != nullptr; runtime = runtime->_next) {
+    if (count != nullptr) {
+      (*count)++;
+    }
+    if (for_compile_broker == runtime->_for_compile_broker) {
+      int count = runtime->_num_attached_threads;
+      if (count == cannot_be_attached || runtime == skip) {
+        // Cannot attach to rt
+        continue;
+      }
+      // If selecting for repacking, ignore a runtime without an existing JavaVM
+      if (skip != nullptr && !runtime->has_shared_library_javavm()) {
+        continue;
+      }
+
+      // Select first runtime with sufficient capacity
+      if (count < (int) JVMCIThreadsPerNativeLibraryRuntime) {
+        runtime->pre_attach_thread(thread);
+        return runtime;
+      }
+    }
+  }
+  return nullptr;
+}
+
+JVMCIRuntime* JVMCIRuntime::select_or_create_runtime(JavaThread* thread) {
+  assert(JVMCI_lock->owner() == thread, "must be");
+  int id = 0;
+  JVMCIRuntime* runtime;
+  if (JVMCI::using_singleton_shared_library_runtime()) {
+    runtime = JVMCI::_compiler_runtimes;
+    guarantee(runtime != nullptr, "must be");
+    while (runtime->_num_attached_threads == cannot_be_attached) {
+      // Since there is only a singleton JVMCIRuntime, we
+      // need to wait for it to be available for attaching.
+      JVMCI_lock->wait();
+    }
+    runtime->pre_attach_thread(thread);
+  } else {
+    runtime = select_runtime(thread, nullptr, &id);
+  }
+  if (runtime == nullptr) {
+    runtime = new JVMCIRuntime(JVMCI::_compiler_runtimes, id, thread->is_Compiler_thread());
+    JVMCI::_compiler_runtimes = runtime;
+    runtime->pre_attach_thread(thread);
+  }
+  return runtime;
+}
+
+JVMCIRuntime* JVMCIRuntime::for_thread(JavaThread* thread) {
+  assert(thread->libjvmci_runtime() == nullptr, "must be");
+  // Find the runtime with fewest attached threads
+  JVMCIRuntime* runtime = nullptr;
+  {
     MutexLocker locker(JVMCI_lock);
-    // Check again under JVMCI_lock
-    javaVM = (JavaVM*) _shared_library_javavm;
-    if (javaVM != NULL) {
-      return NULL;
+    runtime = JVMCI::in_shutdown() ? select_runtime_in_shutdown(thread) : select_or_create_runtime(thread);
+  }
+  runtime->attach_thread(thread);
+  return runtime;
+}
+
+const char* JVMCIRuntime::attach_shared_library_thread(JavaThread* thread, JavaVM* javaVM) {
+  MutexLocker locker(JVMCI_lock);
+  for (JVMCIRuntime* runtime = JVMCI::_compiler_runtimes; runtime != nullptr; runtime = runtime->_next) {
+    if (runtime->_shared_library_javavm == javaVM) {
+      if (runtime->_num_attached_threads == cannot_be_attached) {
+        return "Cannot attach to JVMCI runtime that is shutting down";
+      }
+      runtime->pre_attach_thread(thread);
+      runtime->attach_thread(thread);
+      return nullptr;
+    }
+  }
+  return "Cannot find JVMCI runtime";
+}
+
+void JVMCIRuntime::pre_attach_thread(JavaThread* thread) {
+  assert(JVMCI_lock->owner() == thread, "must be");
+  _num_attached_threads++;
+}
+
+void JVMCIRuntime::attach_thread(JavaThread* thread) {
+  assert(thread->libjvmci_runtime() == nullptr, "must be");
+  thread->set_libjvmci_runtime(this);
+  guarantee(this == JVMCI::_shutdown_compiler_runtime ||
+            _num_attached_threads > 0,
+            "missing reservation in JVMCI runtime %d: _num_attached_threads=%d", _id, _num_attached_threads);
+  JVMCI_event_1("attached to JVMCI runtime %d%s", _id, JVMCI::in_shutdown() ? " [in JVMCI shutdown]" : "");
+}
+
+void JVMCIRuntime::repack(JavaThread* thread) {
+  JVMCIRuntime* new_runtime = nullptr;
+  {
+    MutexLocker locker(JVMCI_lock);
+    if (JVMCI::using_singleton_shared_library_runtime() || _num_attached_threads != 1 || JVMCI::in_shutdown()) {
+      return;
+    }
+    new_runtime = select_runtime(thread, this, nullptr);
+  }
+  if (new_runtime != nullptr) {
+    JVMCI_event_1("Moving thread from JVMCI runtime %d to JVMCI runtime %d (%d attached)", _id, new_runtime->_id, new_runtime->_num_attached_threads - 1);
+    detach_thread(thread, "moving thread to another JVMCI runtime");
+    new_runtime->attach_thread(thread);
+  }
+}
+
+bool JVMCIRuntime::detach_thread(JavaThread* thread, const char* reason, bool can_destroy_javavm) {
+  if (this == JVMCI::_shutdown_compiler_runtime || JVMCI::in_shutdown()) {
+    // Do minimal work when shutting down JVMCI
+    thread->set_libjvmci_runtime(nullptr);
+    return false;
+  }
+  bool should_shutdown;
+  bool destroyed_javavm = false;
+  {
+    MutexLocker locker(JVMCI_lock);
+    _num_attached_threads--;
+    JVMCI_event_1("detaching from JVMCI runtime %d: %s (%d other threads still attached)", _id, reason, _num_attached_threads);
+    should_shutdown = _num_attached_threads == 0 && !JVMCI::in_shutdown();
+    if (should_shutdown && !can_destroy_javavm) {
+      // If it's not possible to destroy the JavaVM on this thread then the VM must
+      // not be shutdown. This can happen when a shared library thread is the last
+      // thread to detach from a shared library JavaVM (e.g. GraalServiceThread).
+      JVMCI_event_1("Cancelled shut down of JVMCI runtime %d", _id);
+      should_shutdown = false;
+    }
+    if (should_shutdown) {
+      // Prevent other threads from attaching to this runtime
+      // while it is shutting down and destroying its JavaVM
+      _num_attached_threads = cannot_be_attached;
     }
+  }
+  if (should_shutdown) {
+    // Release the JavaVM resources associated with this
+    // runtime once there are no threads attached to it.
+    shutdown();
+    if (can_destroy_javavm) {
+      destroyed_javavm = destroy_shared_library_javavm();
+      if (destroyed_javavm) {
+        // Can release all handles now that there's no code executing
+        // that could be using them. Handles for the Java JVMCI runtime
+        // are never released as we cannot guarantee all compiler threads
+        // using it have been stopped.
+        int released = release_and_clear_globals();
+        JVMCI_event_1("releasing handles for JVMCI runtime %d: oop handles=%d, metadata handles={total=%d, live=%d, blocks=%d}",
+            _id,
+            released,
+            _metadata_handles->num_handles(),
+            _metadata_handles->num_handles() - _metadata_handles->num_free_handles(),
+            _metadata_handles->num_blocks());
+
+        // No need to acquire _lock since this is the only thread accessing this runtime
+        _metadata_handles->clear();
+      }
+    }
+    // Allow other threads to attach to this runtime now
+    MutexLocker locker(JVMCI_lock);
+    _num_attached_threads = 0;
+    if (JVMCI::using_singleton_shared_library_runtime()) {
+      // Notify any thread waiting to attach to the
+      // singleton JVMCIRuntime
+      JVMCI_lock->notify();
+    }
+  }
+  thread->set_libjvmci_runtime(nullptr);
+  JVMCI_event_1("detached from JVMCI runtime %d", _id);
+  return destroyed_javavm;
+}
+
+JNIEnv* JVMCIRuntime::init_shared_library_javavm() {
+  MutexLocker locker(_lock);
+  JavaVM* javaVM = _shared_library_javavm;
+  if (javaVM == nullptr) {
     char* sl_path;
     void* sl_handle = JVMCI::get_shared_library(sl_path, true);
 
     jint (*JNI_CreateJavaVM)(JavaVM **pvm, void **penv, void *args);
     typedef jint (*JNI_CreateJavaVM_t)(JavaVM **pvm, void **penv, void *args);
 
     JNI_CreateJavaVM = CAST_TO_FN_PTR(JNI_CreateJavaVM_t, os::dll_lookup(sl_handle, "JNI_CreateJavaVM"));
-    if (JNI_CreateJavaVM == NULL) {
+    if (JNI_CreateJavaVM == nullptr) {
       fatal("Unable to find JNI_CreateJavaVM in %s", sl_path);
     }
 
@@ -954,27 +1229,28 @@ JNIEnv* JVMCIRuntime::init_shared_library_javavm() {
     vm_args.options = options;
     vm_args.nOptions = sizeof(options) / sizeof(JavaVMOption);
 
-    JNIEnv* env = NULL;
+    JNIEnv* env = nullptr;
     int result = (*JNI_CreateJavaVM)(&javaVM, (void**) &env, &vm_args);
     if (result == JNI_OK) {
-      guarantee(env != NULL, "missing env");
+      guarantee(env != nullptr, "missing env");
+      _shared_library_javavm_id = javaVM_id;
       _shared_library_javavm = javaVM;
       JVMCI_event_1("created JavaVM[%ld]@" PTR_FORMAT " for JVMCI runtime %d", javaVM_id, p2i(javaVM), _id);
       return env;
     } else {
       fatal("JNI_CreateJavaVM failed with return value %d", result);
     }
   }
-  return NULL;
+  return nullptr;
 }
 
 void JVMCIRuntime::init_JavaVM_info(jlongArray info, JVMCI_TRAPS) {
-  if (info != NULL) {
+  if (info != nullptr) {
     typeArrayOop info_oop = (typeArrayOop) JNIHandles::resolve(info);
     if (info_oop->length() < 4) {
       JVMCI_THROW_MSG(ArrayIndexOutOfBoundsException, err_msg("%d < 4", info_oop->length()));
     }
-    JavaVM* javaVM = (JavaVM*) _shared_library_javavm;
+    JavaVM* javaVM = _shared_library_javavm;
     info_oop->long_at_put(0, (jlong) (address) javaVM);
     info_oop->long_at_put(1, (jlong) (address) javaVM->functions->reserved0);
     info_oop->long_at_put(2, (jlong) (address) javaVM->functions->reserved1);
@@ -983,9 +1259,9 @@ void JVMCIRuntime::init_JavaVM_info(jlongArray info, JVMCI_TRAPS) {
 }
 
 #define JAVAVM_CALL_BLOCK                                             \
-  guarantee(thread != NULL && _shared_library_javavm != NULL, "npe"); \
+  guarantee(thread != nullptr && _shared_library_javavm != nullptr, "npe"); \
   ThreadToNativeFromVM ttnfv(thread);                                 \
-  JavaVM* javavm = (JavaVM*) _shared_library_javavm;
+  JavaVM* javavm = _shared_library_javavm;
 
 jint JVMCIRuntime::AttachCurrentThread(JavaThread* thread, void **penv, void *args) {
   JAVAVM_CALL_BLOCK
@@ -1027,21 +1303,64 @@ void JVMCIRuntime::initialize_HotSpotJVMCIRuntime(JVMCI_TRAPS) {
   JVMCI::_is_initialized = true;
 }
 
+JVMCIRuntime::InitState JVMCIRuntime::_shared_library_javavm_refs_init_state = JVMCIRuntime::uninitialized;
+JVMCIRuntime::InitState JVMCIRuntime::_hotspot_javavm_refs_init_state = JVMCIRuntime::uninitialized;
+
+class JavaVMRefsInitialization: public StackObj {
+  JVMCIRuntime::InitState *_state;
+  int _id;
+ public:
+  JavaVMRefsInitialization(JVMCIRuntime::InitState *state, int id) {
+    _state = state;
+    _id = id;
+    // All classes, methods and fields in the JVMCI shared library
+    // are in the read-only part of the image. As such, these
+    // values (and any global handle derived from them via NewGlobalRef)
+    // are the same for all JavaVM instances created in the
+    // shared library which means they only need to be initialized
+    // once. In non-product mode, we check this invariant.
+    // See com.oracle.svm.jni.JNIImageHeapHandles.
+    // The same is true for Klass* and field offsets in HotSpotJVMCI.
+    if (*state == JVMCIRuntime::uninitialized DEBUG_ONLY( || true)) {
+      *state = JVMCIRuntime::being_initialized;
+      JVMCI_event_1("initializing JavaVM references in JVMCI runtime %d", id);
+    } else {
+      while (*state != JVMCIRuntime::fully_initialized) {
+        JVMCI_event_1("waiting for JavaVM references initialization in JVMCI runtime %d", id);
+        JVMCI_lock->wait();
+      }
+      JVMCI_event_1("done waiting for JavaVM references initialization in JVMCI runtime %d", id);
+    }
+  }
+
+  ~JavaVMRefsInitialization() {
+    if (*_state == JVMCIRuntime::being_initialized) {
+      *_state = JVMCIRuntime::fully_initialized;
+      JVMCI_event_1("initialized JavaVM references in JVMCI runtime %d", _id);
+      JVMCI_lock->notify_all();
+    }
+  }
+
+  bool should_init() {
+    return *_state == JVMCIRuntime::being_initialized;
+  }
+};
+
 void JVMCIRuntime::initialize(JVMCIEnv* JVMCIENV) {
-  // Check first without JVMCI_lock
+  // Check first without _lock
   if (_init_state == fully_initialized) {
     return;
   }
 
-  MutexLocker locker(JVMCI_lock);
-  // Check again under JVMCI_lock
+  MutexLocker locker(_lock);
+  // Check again under _lock
   if (_init_state == fully_initialized) {
     return;
   }
 
   while (_init_state == being_initialized) {
     JVMCI_event_1("waiting for initialization of JVMCI runtime %d", _id);
-    JVMCI_lock->wait();
+    _lock->wait();
     if (_init_state == fully_initialized) {
       JVMCI_event_1("done waiting for initialization of JVMCI runtime %d", _id);
       return;
@@ -1052,20 +1371,32 @@ void JVMCIRuntime::initialize(JVMCIEnv* JVMCIENV) {
   _init_state = being_initialized;
 
   {
-    MutexUnlocker unlock(JVMCI_lock);
+    MutexUnlocker unlock(_lock);
 
-    JavaThread* THREAD = JavaThread::current(); // For exception macros.
+    JavaThread* THREAD = JavaThread::current();
     HandleMark hm(THREAD);
     ResourceMark rm(THREAD);
-    if (JVMCIENV->is_hotspot()) {
-      HotSpotJVMCI::compute_offsets(CHECK_EXIT);
-    } else {
-      JNIAccessMark jni(JVMCIENV);
-
-      JNIJVMCI::initialize_ids(jni.env());
-      if (jni()->ExceptionCheck()) {
-        jni()->ExceptionDescribe();
-        fatal("JNI exception during init");
+    {
+      MutexLocker lock_jvmci(JVMCI_lock);
+      if (JVMCIENV->is_hotspot()) {
+        JavaVMRefsInitialization initialization(&_hotspot_javavm_refs_init_state, _id);
+        if (initialization.should_init()) {
+          MutexUnlocker unlock_jvmci(JVMCI_lock);
+          HotSpotJVMCI::compute_offsets(CHECK_EXIT);
+        }
+      } else {
+        JavaVMRefsInitialization initialization(&_shared_library_javavm_refs_init_state, _id);
+        if (initialization.should_init()) {
+          MutexUnlocker unlock_jvmci(JVMCI_lock);
+          JNIAccessMark jni(JVMCIENV, THREAD);
+
+          JNIJVMCI::initialize_ids(jni.env());
+          if (jni()->ExceptionCheck()) {
+            jni()->ExceptionDescribe();
+            fatal("JNI exception during init");
+          }
+          // _lock is re-locked at this point
+        }
       }
     }
 
@@ -1090,7 +1421,7 @@ void JVMCIRuntime::initialize(JVMCIEnv* JVMCIENV) {
 
   _init_state = fully_initialized;
   JVMCI_event_1("initialized JVMCI runtime %d", _id);
-  JVMCI_lock->notify_all();
+  _lock->notify_all();
 }
 
 JVMCIObject JVMCIRuntime::create_jvmci_primitive_type(BasicType type, JVMCI_TRAPS) {
@@ -1122,6 +1453,7 @@ void JVMCIRuntime::initialize_JVMCI(JVMCI_TRAPS) {
   if (!is_HotSpotJVMCIRuntime_initialized()) {
     initialize(JVMCI_CHECK);
     JVMCIENV->call_JVMCI_getRuntime(JVMCI_CHECK);
+    guarantee(_HotSpotJVMCIRuntime_instance.is_non_null(), "NPE in JVMCI runtime %d", _id);
   }
 }
 
@@ -1172,8 +1504,46 @@ void JVMCIRuntime::shutdown() {
     JVMCIEnv __stack_jvmci_env__(JavaThread::current(), _HotSpotJVMCIRuntime_instance.is_hotspot(), __FILE__, __LINE__);
     JVMCIEnv* JVMCIENV = &__stack_jvmci_env__;
     JVMCIENV->call_HotSpotJVMCIRuntime_shutdown(_HotSpotJVMCIRuntime_instance);
-    JVMCI_event_1("shut down HotSpotJVMCIRuntime for JVMCI runtime %d", _id);
+    if (_num_attached_threads == cannot_be_attached) {
+      // Only when no other threads are attached to this runtime
+      // is it safe to reset these fields.
+      _HotSpotJVMCIRuntime_instance = JVMCIObject();
+      _init_state = uninitialized;
+      JVMCI_event_1("shut down JVMCI runtime %d", _id);
+    }
+  }
+}
+
+bool JVMCIRuntime::destroy_shared_library_javavm() {
+  guarantee(_num_attached_threads == cannot_be_attached,
+      "cannot destroy JavaVM for JVMCI runtime %d with %d attached threads", _id, _num_attached_threads);
+  JavaVM* javaVM;
+  int javaVM_id = _shared_library_javavm_id;
+  {
+    // Exactly one thread can destroy the JavaVM
+    // and release the handle to it.
+    MutexLocker only_one(_lock);
+    javaVM = _shared_library_javavm;
+    if (javaVM != nullptr) {
+      _shared_library_javavm = nullptr;
+      _shared_library_javavm_id = 0;
+    }
+  }
+  if (javaVM != nullptr) {
+    int result;
+    {
+      // Must transition into native before calling into libjvmci
+      ThreadToNativeFromVM ttnfv(JavaThread::current());
+      result = javaVM->DestroyJavaVM();
+    }
+    if (result == JNI_OK) {
+      JVMCI_event_1("destroyed JavaVM[%d]@" PTR_FORMAT " for JVMCI runtime %d", javaVM_id, p2i(javaVM), _id);
+    } else {
+      warning("Non-zero result (%d) when calling JNI_DestroyJavaVM on JavaVM[%d]@" PTR_FORMAT, result, javaVM_id, p2i(javaVM));
+    }
+    return true;
   }
+  return false;
 }
 
 void JVMCIRuntime::bootstrap_finished(TRAPS) {
@@ -1587,6 +1957,12 @@ void JVMCIRuntime::compile_method(JVMCIEnv* JVMCIENV, JVMCICompiler* compiler, c
     return;
   }
   if (JVMCI::in_shutdown()) {
+    if (UseJVMCINativeLibrary) {
+      JVMCIRuntime *runtime = JVMCI::compiler_runtime(thread, false);
+      if (runtime != nullptr) {
+        runtime->detach_thread(thread, "JVMCI shutdown pre-empted compilation");
+      }
+    }
     compile_state->set_failure(false, "Avoiding compilation during shutdown");
     return;
   }
@@ -1616,7 +1992,7 @@ void JVMCIRuntime::compile_method(JVMCIEnv* JVMCIENV, JVMCICompiler* compiler, c
         bool retryable = JVMCIENV->get_HotSpotCompilationRequestResult_retry(result_object) != 0;
         compile_state->set_failure(retryable, failure_reason, true);
       } else {
-        if (compile_state->task()->code() == NULL) {
+        if (compile_state->task()->code() == nullptr) {
           compile_state->set_failure(true, "no nmethod produced");
         } else {
           compile_state->task()->set_num_inlined_bytecodes(JVMCIENV->get_HotSpotCompilationRequestResult_inlinedBytecodes(result_object));
@@ -1839,3 +2215,13 @@ JVMCI::CodeInstallResult JVMCIRuntime::register_method(JVMCIEnv* JVMCIENV,
 
   return result;
 }
+
+void JVMCIRuntime::post_compile(JavaThread* thread) {
+  if (UseJVMCINativeLibrary && JVMCI::one_shared_library_javavm_per_compilation()) {
+    if (thread->libjvmci_runtime() != nullptr) {
+      detach_thread(thread, "single use JavaVM");
+    } else {
+      // JVMCI shutdown may have already detached the thread
+    }
+  }
+}