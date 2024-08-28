@@ -3875,7 +3875,6 @@ int    os::win32::_processor_type            = 0;
 // Processor level is not available on non-NT systems, use vm_version instead
 int    os::win32::_processor_level           = 0;
 julong os::win32::_physical_memory           = 0;
-size_t os::win32::_default_stack_size        = 0;
 
 intx          os::win32::_os_thread_limit    = 0;
 volatile intx os::win32::_os_thread_count    = 0;
@@ -3925,11 +3924,6 @@ void os::win32::initialize_system_info() {
   default: fatal("Unknown platform");
   }
 
-  _default_stack_size = os::current_stack_size();
-  assert(_default_stack_size > (size_t) _vm_page_size, "invalid stack size");
-  assert((_default_stack_size & (_vm_page_size - 1)) == 0,
-         "stack size not a multiple of page size");
-
   initialize_performance_counter();
 }
 
@@ -4250,6 +4244,21 @@ extern "C" {
 
 static jint initSock();
 
+// Minimum usable stack sizes required to get to user code. Space for
+// HotSpot guard pages is added later.
+size_t os::_compiler_thread_min_stack_allowed = 48 * K;
+size_t os::_java_thread_min_stack_allowed = 40 * K;
+#ifdef _LP64
+size_t os::_vm_internal_thread_min_stack_allowed = 64 * K;
+#else
+size_t os::_vm_internal_thread_min_stack_allowed = (48 DEBUG_ONLY(+ 4)) * K;
+#endif // _LP64
+
+// If stack_commit_size is 0, windows will reserve the default size,
+// but only commit a small portion of it.  This stack size is the size of this
+// current thread but is larger than we need for Java threads.
+// If -Xss is given to the launcher, it will pick 64K as default stack size and pass that.
+size_t os::_os_min_stack_allowed = 64 * K;
 
 // this is called _after_ the global arguments have been parsed
 jint os::init_2(void) {
@@ -4275,38 +4284,18 @@ jint os::init_2(void) {
   __asm { fldcw fp_control_word }
 #endif
 
-  // If stack_commit_size is 0, windows will reserve the default size,
-  // but only commit a small portion of it.
-  size_t stack_commit_size = align_up(ThreadStackSize*K, os::vm_page_size());
-  size_t default_reserve_size = os::win32::default_stack_size();
-  size_t actual_reserve_size = stack_commit_size;
-  if (stack_commit_size < default_reserve_size) {
-    // If stack_commit_size == 0, we want this too
-    actual_reserve_size = default_reserve_size;
-  }
-
-  // Check minimum allowable stack size for thread creation and to initialize
-  // the java system classes, including StackOverflowError - depends on page
-  // size.  Add two 4K pages for compiler2 recursion in main thread.
-  // Add in 4*BytesPerWord 4K pages to account for VM stack during
-  // class initialization depending on 32 or 64 bit VM.
-  size_t min_stack_allowed =
-            (size_t)(StackOverflow::stack_guard_zone_size() +
-                     StackOverflow::stack_shadow_zone_size() +
-                     (4*BytesPerWord COMPILER2_PRESENT(+2)) * 4 * K);
-
-  min_stack_allowed = align_up(min_stack_allowed, os::vm_page_size());
-
-  if (actual_reserve_size < min_stack_allowed) {
-    tty->print_cr("\nThe Java thread stack size specified is too small. "
-                  "Specify at least %dk",
-                  min_stack_allowed / K);
+  // Check and sets minimum stack sizes against command line options
+  if (set_minimum_stack_sizes() == JNI_ERR) {
     return JNI_ERR;
   }
 
-  JavaThread::set_stack_size_at_create(stack_commit_size);
+  size_t actual_reserve_size = JavaThread::stack_size_at_create();
+  if (actual_reserve_size == 0) {
+    // -Xss or -XX:ThreadStackSize were not given, use the current stack size.
+    actual_reserve_size = current_stack_size();
+  }
 
-  // Calculate theoretical max. size of Threads to guard gainst artificial
+  // Calculate theoretical max. size of Threads to guard against artificial
   // out-of-memory situations, where all available address-space has been
   // reserved by thread stacks.
   assert(actual_reserve_size != 0, "Must have a stack");