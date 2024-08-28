@@ -133,6 +133,7 @@ class HandshakeState {
   bool has_operation() { return !_queue.is_empty(); }
   bool has_operation(bool allow_suspend, bool check_async_exception);
   bool has_async_exception_operation(bool ThreadDeath_only);
+  void clean_async_exception_operation();
 
   bool operation_pending(HandshakeOperation* op);
 