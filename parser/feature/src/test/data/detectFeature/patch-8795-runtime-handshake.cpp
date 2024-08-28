@@ -502,6 +502,16 @@ bool HandshakeState::has_async_exception_operation(bool ThreadDeath_only) {
   }
 }
 
+void HandshakeState::clean_async_exception_operation() {
+  while (has_async_exception_operation(/* ThreadDeath_only */ false)) {
+    MutexLocker ml(&_lock, Mutex::_no_safepoint_check_flag);
+    HandshakeOperation* op;
+    op = _queue.peek(async_exception_filter);
+    remove_op(op);
+    delete op;
+  }
+}
+
 bool HandshakeState::have_non_self_executable_operation() {
   assert(_handshakee != Thread::current(), "Must not be called by self");
   assert(_lock.owned_by_self(), "Lock must be held");