@@ -382,8 +382,8 @@ void VMThread::wait_until_executed(VM_Operation* op) {
 
 static void self_destruct_if_needed() {
   // Support for self destruction
-  if ((SelfDestructTimer != 0) && !VMError::is_error_reported() &&
-      (os::elapsedTime() > (double)SelfDestructTimer * 60.0)) {
+  if ((SelfDestructTimer != 0.0) && !VMError::is_error_reported() &&
+      (os::elapsedTime() > SelfDestructTimer * 60.0)) {
     tty->print_cr("VM self-destructed");
     exit(-1);
   }