@@ -103,6 +103,7 @@ class JVMCINMethodData {
 // There is one instance of this class per HotSpotJVMCIRuntime object.
 class JVMCIRuntime: public CHeapObj<mtJVMCI> {
   friend class JVMCI;
+  friend class JavaVMRefsInitialization;
  public:
   // Constants describing whether JVMCI wants to be able to adjust the compilation
   // level selected for a method by the VM compilation policy and if so, based on
@@ -124,24 +125,61 @@ class JVMCIRuntime: public CHeapObj<mtJVMCI> {
   // Initialization state of this JVMCIRuntime.
   InitState _init_state;
 
+  // Initialization state of the references to classes, methods
+  // and fields in the JVMCI shared library.
+  static InitState _shared_library_javavm_refs_init_state;
+
+  // Initialization state of the references to classes, methods
+  // and fields in HotSpot metadata.
+  static InitState _hotspot_javavm_refs_init_state;
+
   // A wrapper for a VM scoped JNI global handle (i.e. JVMCIEnv::make_global)
   // to a HotSpotJVMCIRuntime instance. This JNI global handle must never
   // be explicitly destroyed as it can be accessed in a racy way during
   // JVMCI shutdown. Furthermore, it will be reclaimed when
   // the VM or shared library JavaVM managing the handle dies.
   JVMCIObject _HotSpotJVMCIRuntime_instance;
 
+  // Lock for operations that may be performed by
+  // any thread attached this runtime. To avoid deadlock,
+  // this lock must always be acquired before JVMCI_lock.
+  Monitor* _lock;
+
   // Result of calling JNI_CreateJavaVM in the JVMCI shared library.
-  // Must only be modified under JVMCI_lock.
-  volatile JavaVM* _shared_library_javavm;
+  // Must only be mutated under _lock.
+  JavaVM* _shared_library_javavm;
 
+  // Id for _shared_library_javavm.
+  int _shared_library_javavm_id;
+
+  // Position and link in global list of JVMCI shared library runtimes.
   // The HotSpot heap based runtime will have an id of -1 and the
-  // JVMCI shared library runtime will have an id of 0.
+  // runtime reserved for threads attaching during JVMCI shutdown
+  // will have an id of -2.
   int _id;
+  JVMCIRuntime* _next;
 
   // Handles to Metadata objects.
   MetadataHandles* _metadata_handles;
 
+  // List of oop handles allocated via make_oop_handle. This is to support
+  // destroying remaining oop handles when the JavaVM associated
+  // with this runtime is shutdown.
+  GrowableArray<oop*> _oop_handles;
+
+  // Number of threads attached or about to be attached to this runtime.
+  // Must only be mutated under JVMCI_lock to facilitate safely moving
+  // threads between JVMCI runtimes. A value of -1 implies this runtime is
+  // not available to be attached to another thread because it is in the
+  // process of shutting down and destroying its JavaVM.
+  int _num_attached_threads;
+  static const int cannot_be_attached = -1;
+
+  // Is this runtime for threads managed by the CompileBroker?
+  // Examples of non-CompileBroker threads are CompileTheWorld threads
+  // or Truffle compilation threads.
+  bool _for_compile_broker;
+
   JVMCIObject create_jvmci_primitive_type(BasicType type, JVMCI_TRAPS);
 
   // Implementation methods for loading and constant pool access.
@@ -168,18 +206,51 @@ class JVMCIRuntime: public CHeapObj<mtJVMCI> {
                                   Bytecodes::Code bc,
                                   constantTag     tag);
 
+  // Helpers for `for_thread`.
+
+  // Selects an existing runtime (except for `skip`) that has
+  // fewer than JVMCI::max_threads_per_runtime() attached threads.
+  // If such a runtime exists, its _num_attached_threads is incremented
+  // and the caller must subsequently attach `thread` to it.
+  // JVMCI_lock must be held by current thread.
+  // If nullptr is returned, then `*count` contains the number of JVMCIRuntimes
+  // currently allocated.
+  static JVMCIRuntime* select_runtime(JavaThread* thread, JVMCIRuntime* skip, int* count);
+
+  // Selects an existing runtime for `thread` or creates a new one if
+  // no applicable runtime exists.
+  // JVMCI_lock must be held by current thread
+  static JVMCIRuntime* select_or_create_runtime(JavaThread* thread);
+
+  // Selects an existing runtime for `thread` when in JVMCI shutdown.
+  // JVMCI_lock must be held by current thread
+  static JVMCIRuntime* select_runtime_in_shutdown(JavaThread* thread);
+
+  // Helpers for destroy_oop_handle
+  int _last_found_oop_handle_index;
+  bool probe_oop_handle(jlong handle, int index);
+  int find_oop_handle(jlong handle);
+
+  // Releases all the non-null entries in _oop_handles and then clears
+  // the list. Returns the number of non-null entries prior to clearing.
+  int release_and_clear_globals();
+
  public:
-  JVMCIRuntime(int id);
+  JVMCIRuntime(JVMCIRuntime* next, int id, bool for_compile_broker);
 
   int id() const        { return _id;   }
+  Monitor* lock() const { return _lock; }
 
   // Ensures that a JVMCI shared library JavaVM exists for this runtime.
   // If the JavaVM was created by this call, then the thread-local JNI
-  // interface pointer for the JavaVM is returned otherwise NULL is returned.
+  // interface pointer for the JavaVM is returned otherwise nullptr is returned.
   JNIEnv* init_shared_library_javavm();
 
   // Determines if the JVMCI shared library JavaVM exists for this runtime.
-  bool has_shared_library_javavm() { return _shared_library_javavm != NULL; }
+  bool has_shared_library_javavm() { return _shared_library_javavm != nullptr; }
+
+  // Gets an ID for the JVMCI shared library JavaVM associated with this runtime.
+  int get_shared_library_javavm_id() { return _shared_library_javavm_id; }
 
   // Copies info about the JVMCI shared library JavaVM associated with this
   // runtime into `info` as follows:
@@ -202,21 +273,53 @@ class JVMCIRuntime: public CHeapObj<mtJVMCI> {
   // Compute offsets and construct any state required before executing JVMCI code.
   void initialize(JVMCIEnv* jvmciEnv);
 
-  // Allocation and management of JNI global object handles
-  // whose lifetime is scoped by this JVMCIRuntime. The lifetime
+  // Allocation and management of handles to HotSpot heap objects
+  // whose lifetime is scoped by this JVMCIRuntime. The max lifetime
   // of these handles is the same as the JVMCI shared library JavaVM
   // associated with this JVMCIRuntime. These JNI handles are
-  // used when creating a IndirectHotSpotObjectConstantImpl in the
+  // used when creating an IndirectHotSpotObjectConstantImpl in the
   // shared library JavaVM.
-  jobject make_global(const Handle& obj);
-  void destroy_global(jobject handle);
-  bool is_global_handle(jobject handle);
+  jlong make_oop_handle(const Handle& obj);
+  bool is_oop_handle(jlong handle);
+
+  // Called from IndirectHotSpotObjectConstantImpl.clear(Object)
+  void destroy_oop_handle(jlong handle);
 
   // Allocation and management of metadata handles.
   jmetadata allocate_handle(const methodHandle& handle);
   jmetadata allocate_handle(const constantPoolHandle& handle);
   void release_handle(jmetadata handle);
 
+  // Finds a JVMCI runtime for `thread`. A new JVMCI runtime is created if
+  // there are none currently available with JVMCI::max_threads_per_runtime()
+  // or fewer attached threads.
+  static JVMCIRuntime* for_thread(JavaThread* thread);
+
+  // Finds the JVMCI runtime owning `javavm` and attaches `thread` to it.
+  // Returns an error message if attaching fails.
+  static const char* attach_shared_library_thread(JavaThread* thread, JavaVM* javaVM);
+
+  // Reserves a slot in this runtime for `thread` to prevent it being
+  // shutdown before `thread` is attached. JVMCI_lock must be held
+  // and the caller must call `attach_thread` upon releasing it.
+  void pre_attach_thread(JavaThread* thread);
+
+  // Attaches `thread` to this runtime.
+  void attach_thread(JavaThread* thread);
+
+  // Detaches `thread` from this runtime.
+  // Returns whether DestroyJavaVM was called on the JavaVM associated
+  // with this runtime as a result of detaching.
+  // The `can_destroy_javavm` is false when in the scope of
+  // a down call from the JVMCI shared library JavaVM. Since the scope
+  // will return to the shared library JavaVM, the JavaVM must not be destroyed.
+  bool detach_thread(JavaThread* thread, const char* reason, bool can_destroy_javavm=true);
+
+  // If `thread` is the last thread attached to this runtime,
+  // move it to another runtime with an existing JavaVM and available capacity
+  // if possible, thus allowing this runtime to release its JavaVM.
+  void repack(JavaThread* thread);
+
   // Gets the HotSpotJVMCIRuntime instance for this runtime,
   // initializing it first if necessary.
   JVMCIObject get_HotSpotJVMCIRuntime(JVMCI_TRAPS);
@@ -240,8 +343,15 @@ class JVMCIRuntime: public CHeapObj<mtJVMCI> {
   void call_getCompiler(TRAPS);
 
   // Shuts down this runtime by calling HotSpotJVMCIRuntime.shutdown().
+  // If this is the last thread attached to this runtime, then
+  // `_HotSpotJVMCIRuntime_instance` is set to nullptr and `_init_state`
+  // to uninitialized.
   void shutdown();
 
+  // Destroys the JVMCI shared library JavaVM attached to this runtime.
+  // Return true iff DestroyJavaVM was called on the JavaVM.
+  bool destroy_shared_library_javavm();
+
   void bootstrap_finished(TRAPS);
 
   // Look up a klass by name from a particular class loader (the accessor's).
@@ -311,6 +421,10 @@ class JVMCIRuntime: public CHeapObj<mtJVMCI> {
                        char*                     speculations,
                        int                       speculations_len);
 
+  // Detach `thread` from this runtime and destroy this runtime's JavaVM
+  // if using one JavaVM per JVMCI compilation .
+  void post_compile(JavaThread* thread);
+
   // Reports an unexpected exception and exits the VM with a fatal error.
   static void fatal_exception(JVMCIEnv* JVMCIENV, const char* message);
 