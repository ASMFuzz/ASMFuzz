@@ -1364,6 +1364,7 @@ static bool is_daemon(oop threadObj) {
 // cleanup_failed_attach_current_thread as well.
 void JavaThread::exit(bool destroy_vm, ExitType exit_type) {
   assert(this == JavaThread::current(), "thread consistency check");
+  assert(!is_exiting(), "should not be exiting or terminated already");
 
   elapsedTimer _timer_exit_phase1;
   elapsedTimer _timer_exit_phase2;
@@ -1425,18 +1426,23 @@ void JavaThread::exit(bool destroy_vm, ExitType exit_type) {
     if (JvmtiExport::should_post_thread_life()) {
       JvmtiExport::post_thread_end(this);
     }
-
-    // The careful dance between thread suspension and exit is handled here.
-    // Since we are in thread_in_vm state and suspension is done with handshakes,
-    // we can just put in the exiting state and it will be correctly handled.
-    set_terminated(_thread_exiting);
-
-    ThreadService::current_thread_exiting(this, is_daemon(threadObj()));
   } else {
-    assert(!is_terminated() && !is_exiting(), "must not be exiting");
     // before_exit() has already posted JVMTI THREAD_END events
   }
 
+  // Cleanup any pending async exception now since we cannot access oops after
+  // BarrierSet::barrier_set()->on_thread_detach() has been executed.
+  if (has_async_exception_condition()) {
+    handshake_state()->clean_async_exception_operation();
+  }
+
+  // The careful dance between thread suspension and exit is handled here.
+  // Since we are in thread_in_vm state and suspension is done with handshakes,
+  // we can just put in the exiting state and it will be correctly handled.
+  // Also, no more async exceptions will be added to the queue after this point.
+  set_terminated(_thread_exiting);
+  ThreadService::current_thread_exiting(this, is_daemon(threadObj()));
+
   if (log_is_enabled(Debug, os, thread, timer)) {
     _timer_exit_phase1.stop();
     _timer_exit_phase2.start();
@@ -1528,7 +1534,8 @@ void JavaThread::exit(bool destroy_vm, ExitType exit_type) {
   }
 #endif // INCLUDE_JVMCI
 
-  // Remove from list of active threads list, and notify VM thread if we are the last non-daemon thread
+  // Remove from list of active threads list, and notify VM thread if we are the last non-daemon thread.
+  // We call BarrierSet::barrier_set()->on_thread_detach() here so no touching of oops after this point.
   Threads::remove(this, daemon);
 
   if (log_is_enabled(Debug, os, thread, timer)) {
@@ -1698,8 +1705,9 @@ void JavaThread::handle_async_exception(oop java_throwable) {
 }
 
 void JavaThread::install_async_exception(AsyncExceptionHandshake* aeh) {
-  // Do not throw asynchronous exceptions against the compiler thread.
-  if (!can_call_java()) {
+  // Do not throw asynchronous exceptions against the compiler thread
+  // or if the thread is already exiting.
+  if (!can_call_java() || is_exiting()) {
     delete aeh;
     return;
   }