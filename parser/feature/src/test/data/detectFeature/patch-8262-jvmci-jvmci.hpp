@@ -51,8 +51,15 @@ class JVMCI : public AllStatic {
   friend class JVMCIEnv;
 
  private:
-  // Access to the HotSpotJVMCIRuntime used by the CompileBroker.
-  static JVMCIRuntime* _compiler_runtime;
+  // List of libjvmci based JVMCIRuntimes.
+  // Should only be accessed under JVMCI_lock.
+  static JVMCIRuntime* _compiler_runtimes;
+
+  // Special libjvmci based JVMCIRuntime reserved for
+  // threads trying to attach when in JVMCI shutdown.
+  // This preserves the invariant that JVMCIRuntime::for_thread()
+  // never returns nullptr.
+  static JVMCIRuntime* _shutdown_compiler_runtime;
 
   // True when at least one JVMCIRuntime::initialize_HotSpotJVMCIRuntime()
   // execution has completed successfully.
@@ -95,6 +102,7 @@ class JVMCI : public AllStatic {
   static Thread* current_thread_or_null();
 
  public:
+
   enum CodeInstallResult {
      ok,
      dependencies_failed,
@@ -104,10 +112,19 @@ class JVMCI : public AllStatic {
      first_permanent_bailout = code_too_large
   };
 
+  // Returns true iff JVMCIThreadsPerNativeLibraryRuntime == 0.
+  static bool using_singleton_shared_library_runtime() {
+    return JVMCIThreadsPerNativeLibraryRuntime == 0;
+  }
+
+  // Returns true iff there is a new shared library JavaVM per compilation.
+  static bool one_shared_library_javavm_per_compilation() {
+    return JVMCIThreadsPerNativeLibraryRuntime == 1 && JVMCICompilerIdleDelay == 0;
+  }
+
   // Gets the handle to the loaded JVMCI shared library, loading it
   // first if not yet loaded and `load` is true. The path from
-  // which the library is loaded is returned in `path`. If
-  // `load` is true then JVMCI_lock must be locked.
+  // which the library is loaded is returned in `path`.
   static void* get_shared_library(char*& path, bool load);
 
   // Logs the fatal crash data in `buf` to the appropriate stream.
@@ -121,7 +138,7 @@ class JVMCI : public AllStatic {
 
   static void metadata_do(void f(Metadata*));
 
-  static void shutdown();
+  static void shutdown(JavaThread* thread);
 
   // Returns whether JVMCI::shutdown has been called.
   static bool in_shutdown();
@@ -145,11 +162,16 @@ class JVMCI : public AllStatic {
   // Returns `thread`.
   static JavaThread* compilation_tick(JavaThread* thread);
 
-  static JVMCIRuntime* compiler_runtime() { return _compiler_runtime; }
   // Gets the single runtime for JVMCI on the Java heap. This is the only
   // JVMCI runtime available when !UseJVMCINativeLibrary.
   static JVMCIRuntime* java_runtime()     { return _java_runtime; }
 
+  // Gets the JVMCI shared library runtime associated with `thread`.
+  // This must only be called when UseJVMCINativeLibrary is true.
+  // If `create` is true and there is no runtime currently associated with
+  // `thread`, this method creates one.
+  static JVMCIRuntime* compiler_runtime(JavaThread* thread, bool create=true);
+
   // Appends an event to the JVMCI event log if JVMCIEventLogLevel >= `level`
   static void vlog(int level, const char* format, va_list ap) ATTRIBUTE_PRINTF(2, 0);
 