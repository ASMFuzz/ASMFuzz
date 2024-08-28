@@ -417,9 +417,9 @@ void os::Aix::init_thread_fpu_state(void) {
 
 // Minimum usable stack sizes required to get to user code. Space for
 // HotSpot guard pages is added later.
-size_t os::Posix::_compiler_thread_min_stack_allowed = 192 * K;
-size_t os::Posix::_java_thread_min_stack_allowed = 64 * K;
-size_t os::Posix::_vm_internal_thread_min_stack_allowed = 64 * K;
+size_t os::_compiler_thread_min_stack_allowed = 192 * K;
+size_t os::_java_thread_min_stack_allowed = 64 * K;
+size_t os::_vm_internal_thread_min_stack_allowed = 64 * K;
 
 // Return default stack size for thr_type.
 size_t os::Posix::default_stack_size(os::ThreadType thr_type) {