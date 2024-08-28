@@ -376,9 +376,9 @@ void os::Linux::set_fpu_control_word(int fpu_control) {
 
 // Minimum usable stack sizes required to get to user code. Space for
 // HotSpot guard pages is added later.
-size_t os::Posix::_compiler_thread_min_stack_allowed = (52 DEBUG_ONLY(+ 32)) * K;
-size_t os::Posix::_java_thread_min_stack_allowed = (32 DEBUG_ONLY(+ 8)) * K;
-size_t os::Posix::_vm_internal_thread_min_stack_allowed = 32 * K;
+size_t os::_compiler_thread_min_stack_allowed = (52 DEBUG_ONLY(+ 32)) * K;
+size_t os::_java_thread_min_stack_allowed = (32 DEBUG_ONLY(+ 8)) * K;
+size_t os::_vm_internal_thread_min_stack_allowed = 32 * K;
 
 // Return default stack size for thr_type.
 size_t os::Posix::default_stack_size(os::ThreadType thr_type) {