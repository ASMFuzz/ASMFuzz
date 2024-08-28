@@ -37,18 +37,19 @@
 #include "runtime/atomic.hpp"
 #include "utilities/events.hpp"
 
-JVMCIRuntime* JVMCI::_compiler_runtime = NULL;
-JVMCIRuntime* JVMCI::_java_runtime = NULL;
+JVMCIRuntime* JVMCI::_compiler_runtimes = nullptr;
+JVMCIRuntime* JVMCI::_java_runtime = nullptr;
+JVMCIRuntime* JVMCI::_shutdown_compiler_runtime = nullptr;
 volatile bool JVMCI::_is_initialized = false;
 bool JVMCI::_box_caches_initialized = false;
-void* JVMCI::_shared_library_handle = NULL;
-char* JVMCI::_shared_library_path = NULL;
+void* JVMCI::_shared_library_handle = nullptr;
+char* JVMCI::_shared_library_path = nullptr;
 volatile bool JVMCI::_in_shutdown = false;
-StringEventLog* JVMCI::_events = NULL;
-StringEventLog* JVMCI::_verbose_events = NULL;
+StringEventLog* JVMCI::_events = nullptr;
+StringEventLog* JVMCI::_verbose_events = nullptr;
 volatile intx JVMCI::_fatal_log_init_thread = -1;
 volatile int JVMCI::_fatal_log_fd = -1;
-const char* JVMCI::_fatal_log_filename = NULL;
+const char* JVMCI::_fatal_log_filename = nullptr;
 
 void jvmci_vmStructs_init() NOT_DEBUG_RETURN;
 
@@ -70,7 +71,7 @@ void* JVMCI::get_shared_library(char*& path, bool load) {
     path = _shared_library_path;
     return sl_handle;
   }
-  assert(JVMCI_lock->owner() == Thread::current(), "must be");
+  MutexLocker locker(JVMCI_lock);
   path = NULL;
   if (_shared_library_handle == NULL) {
     char path[JVM_MAXPATHLEN];
@@ -103,8 +104,13 @@ void JVMCI::initialize_compiler(TRAPS) {
     JNIJVMCI::initialize_ids(NULL);
     ShouldNotReachHere();
   }
-
-  JVMCI::compiler_runtime()->call_getCompiler(CHECK);
+  JVMCIRuntime* runtime;
+  if (UseJVMCINativeLibrary) {
+      runtime = JVMCI::compiler_runtime((JavaThread*) THREAD);
+  } else {
+      runtime = JVMCI::java_runtime();
+  }
+  runtime->call_getCompiler(CHECK);
 }
 
 void JVMCI::initialize_globals() {
@@ -122,13 +128,9 @@ void JVMCI::initialize_globals() {
       }
     }
   }
-  if (UseJVMCINativeLibrary) {
-    // There are two runtimes.
-    _compiler_runtime = new JVMCIRuntime(0);
-    _java_runtime = new JVMCIRuntime(-1);
-  } else {
-    // There is only a single runtime
-    _java_runtime = _compiler_runtime = new JVMCIRuntime(0);
+  _java_runtime = new JVMCIRuntime(nullptr, -1, false);
+  if (using_singleton_shared_library_runtime()) {
+    JVMCI::_compiler_runtimes = new JVMCIRuntime(nullptr, 0, true);
   }
 }
 
@@ -158,6 +160,16 @@ void JVMCI::ensure_box_caches_initialized(TRAPS) {
   _box_caches_initialized = true;
 }
 
+JVMCIRuntime* JVMCI::compiler_runtime(JavaThread* thread, bool create) {
+  assert(thread->is_Java_thread(), "must be") ;
+  assert(UseJVMCINativeLibrary, "must be");
+  JVMCIRuntime* runtime = thread->libjvmci_runtime();
+  if (runtime == nullptr && create) {
+    runtime = JVMCIRuntime::for_thread(thread);
+  }
+  return runtime;
+}
+
 JavaThread* JVMCI::compilation_tick(JavaThread* thread) {
   if (thread->is_Compiler_thread()) {
     CompileTask *task = CompilerThread::cast(thread)->task();
@@ -172,21 +184,27 @@ JavaThread* JVMCI::compilation_tick(JavaThread* thread) {
 }
 
 void JVMCI::metadata_do(void f(Metadata*)) {
-  if (_java_runtime != NULL) {
+  if (_java_runtime != nullptr) {
     _java_runtime->_metadata_handles->metadata_do(f);
   }
-  if (_compiler_runtime != NULL && _compiler_runtime != _java_runtime) {
-    _compiler_runtime->_metadata_handles->metadata_do(f);
+  for (JVMCIRuntime* runtime = _compiler_runtimes; runtime != nullptr; runtime = runtime->_next) {
+    runtime->_metadata_handles->metadata_do(f);
+  }
+  if (_shutdown_compiler_runtime != nullptr) {
+    _shutdown_compiler_runtime->_metadata_handles->metadata_do(f);
   }
 }
 
 void JVMCI::do_unloading(bool unloading_occurred) {
   if (unloading_occurred) {
-    if (_java_runtime != NULL) {
+    if (_java_runtime != nullptr) {
       _java_runtime->_metadata_handles->do_unloading();
     }
-    if (_compiler_runtime != NULL && _compiler_runtime != _java_runtime) {
-      _compiler_runtime->_metadata_handles->do_unloading();
+    for (JVMCIRuntime* runtime = _compiler_runtimes; runtime != nullptr; runtime = runtime->_next) {
+      runtime->_metadata_handles->do_unloading();
+    }
+    if (_shutdown_compiler_runtime != nullptr) {
+      _shutdown_compiler_runtime->_metadata_handles->do_unloading();
     }
   }
 }
@@ -195,19 +213,74 @@ bool JVMCI::is_compiler_initialized() {
   return _is_initialized;
 }
 
-void JVMCI::shutdown() {
+void JVMCI::vlog(int level, const char* format, va_list ap) {
+  if (LogEvents && JVMCIEventLogLevel >= level) {
+    StringEventLog* events = level == 1 ? _events : _verbose_events;
+    guarantee(events != nullptr, "JVMCI event log not yet initialized");
+    Thread* thread = Thread::current_or_null_safe();
+    if (thread != nullptr) {
+      events->logv(thread, format, ap);
+    }
+  }
+}
+
+void JVMCI::vtrace(int level, const char* format, va_list ap) {
+  if (JVMCITraceLevel >= level) {
+    Thread* thread = Thread::current_or_null_safe();
+    if (thread != nullptr) {
+      ResourceMark rm;
+      tty->print("JVMCITrace-%d[%s]:%*c", level, thread->name(), level, ' ');
+    } else {
+      tty->print("JVMCITrace-%d[?]:%*c", level, level, ' ');
+    }
+    tty->vprint_cr(format, ap);
+  }
+}
+
+#define LOG_TRACE(level) { va_list ap; \
+  va_start(ap, format); vlog(level, format, ap); va_end(ap); \
+  va_start(ap, format); vtrace(level, format, ap); va_end(ap); \
+}
+
+void JVMCI::event(int level, const char* format, ...) LOG_TRACE(level)
+void JVMCI::event1(const char* format, ...) LOG_TRACE(1)
+void JVMCI::event2(const char* format, ...) LOG_TRACE(2)
+void JVMCI::event3(const char* format, ...) LOG_TRACE(3)
+void JVMCI::event4(const char* format, ...) LOG_TRACE(4)
+
+#undef LOG_TRACE
+
+void JVMCI::shutdown(JavaThread* thread) {
   ResourceMark rm;
   {
     MutexLocker locker(JVMCI_lock);
     _in_shutdown = true;
     JVMCI_event_1("shutting down JVMCI");
   }
   JVMCIRuntime* java_runtime = _java_runtime;
-  if (java_runtime != compiler_runtime()) {
+  if (java_runtime != nullptr) {
     java_runtime->shutdown();
   }
-  if (compiler_runtime() != NULL) {
-    compiler_runtime()->shutdown();
+  JVMCIRuntime* runtime = thread->libjvmci_runtime();
+  if (runtime != nullptr) {
+    runtime->detach_thread(thread, "JVMCI shutdown");
+  }
+  {
+    // Attach to JVMCI initialized runtimes that are not already shutting down
+    // and shut them down. This ensures HotSpotJVMCIRuntime.shutdown() is called
+    // for each JVMCI runtime.
+    MutexLocker locker(JVMCI_lock);
+    for (JVMCIRuntime* rt = JVMCI::_compiler_runtimes; rt != nullptr; rt = rt->_next) {
+      if (rt->is_HotSpotJVMCIRuntime_initialized() && rt->_num_attached_threads != JVMCIRuntime::cannot_be_attached) {
+        rt->_num_attached_threads++;
+        {
+          MutexUnlocker unlocker(JVMCI_lock);
+          rt->attach_thread(thread);
+          rt->shutdown();
+          rt->detach_thread(thread, "JVMCI shutdown");
+        }
+      }
+    }
   }
 }
 
@@ -253,40 +326,3 @@ void JVMCI::fatal_log(const char* buf, size_t count) {
   log.write(buf, count);
   log.flush();
 }
-
-void JVMCI::vlog(int level, const char* format, va_list ap) {
-  if (LogEvents && JVMCIEventLogLevel >= level) {
-    StringEventLog* events = level == 1 ? _events : _verbose_events;
-    guarantee(events != NULL, "JVMCI event log not yet initialized");
-    Thread* thread = Thread::current_or_null_safe();
-    if (thread != NULL) {
-      events->logv(thread, format, ap);
-    }
-  }
-}
-
-void JVMCI::vtrace(int level, const char* format, va_list ap) {
-  if (JVMCITraceLevel >= level) {
-    Thread* thread = Thread::current_or_null_safe();
-    if (thread != NULL) {
-      ResourceMark rm;
-      tty->print("JVMCITrace-%d[%s]:%*c", level, thread->name(), level, ' ');
-    } else {
-      tty->print("JVMCITrace-%d[?]:%*c", level, level, ' ');
-    }
-    tty->vprint_cr(format, ap);
-  }
-}
-
-#define LOG_TRACE(level) { va_list ap; \
-  va_start(ap, format); vlog(level, format, ap); va_end(ap); \
-  va_start(ap, format); vtrace(level, format, ap); va_end(ap); \
-}
-
-void JVMCI::event(int level, const char* format, ...) LOG_TRACE(level)
-void JVMCI::event1(const char* format, ...) LOG_TRACE(1)
-void JVMCI::event2(const char* format, ...) LOG_TRACE(2)
-void JVMCI::event3(const char* format, ...) LOG_TRACE(3)
-void JVMCI::event4(const char* format, ...) LOG_TRACE(4)
-
-#undef LOG_TRACE