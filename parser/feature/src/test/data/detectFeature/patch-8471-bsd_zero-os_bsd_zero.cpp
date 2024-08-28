@@ -161,9 +161,9 @@ void os::Bsd::init_thread_fpu_state(void) {
 ///////////////////////////////////////////////////////////////////////////////
 // thread stack
 
-size_t os::Posix::_compiler_thread_min_stack_allowed = 64 * K;
-size_t os::Posix::_java_thread_min_stack_allowed = 64 * K;
-size_t os::Posix::_vm_internal_thread_min_stack_allowed = 64 * K;
+size_t os::_compiler_thread_min_stack_allowed = 64 * K;
+size_t os::_java_thread_min_stack_allowed = 64 * K;
+size_t os::_vm_internal_thread_min_stack_allowed = 64 * K;
 
 size_t os::Posix::default_stack_size(os::ThreadType thr_type) {
 #ifdef _LP64