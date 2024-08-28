@@ -162,7 +162,7 @@ inline JavaThreadState JavaThread::thread_state() const    {
 inline void JavaThread::set_thread_state(JavaThreadState s) {
   assert(current_or_null() == NULL || current_or_null() == this,
          "state change should only be called by the current thread");
-#if defined(PPC64) || defined (AARCH64)
+#if defined(PPC64) || defined (AARCH64) || defined(RISCV64)
   // Use membars when accessing volatile _thread_state. See
   // Threads::create_vm() for size checks.
   Atomic::release_store((volatile jint*)&_thread_state, (jint)s);