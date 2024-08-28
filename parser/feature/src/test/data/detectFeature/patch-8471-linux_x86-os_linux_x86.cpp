@@ -499,12 +499,12 @@ juint os::cpu_microcode_revision() {
 
 // Minimum usable stack sizes required to get to user code. Space for
 // HotSpot guard pages is added later.
-size_t os::Posix::_compiler_thread_min_stack_allowed = 48 * K;
-size_t os::Posix::_java_thread_min_stack_allowed = 40 * K;
+size_t os::_compiler_thread_min_stack_allowed = 48 * K;
+size_t os::_java_thread_min_stack_allowed = 40 * K;
 #ifdef _LP64
-size_t os::Posix::_vm_internal_thread_min_stack_allowed = 64 * K;
+size_t os::_vm_internal_thread_min_stack_allowed = 64 * K;
 #else
-size_t os::Posix::_vm_internal_thread_min_stack_allowed = (48 DEBUG_ONLY(+ 4)) * K;
+size_t os::_vm_internal_thread_min_stack_allowed = (48 DEBUG_ONLY(+ 4)) * K;
 #endif // _LP64
 
 // return default stack size for thr_type