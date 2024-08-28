@@ -1671,6 +1671,7 @@ class InstallAsyncExceptionHandshake : public HandshakeClosure {
   InstallAsyncExceptionHandshake(AsyncExceptionHandshake* aeh) :
     HandshakeClosure("InstallAsyncException"), _aeh(aeh) {}
   ~InstallAsyncExceptionHandshake() {
+    // If InstallAsyncExceptionHandshake was never executed we need to clean up _aeh.
     delete _aeh;
   }
   void do_thread(Thread* thr) {