@@ -681,6 +681,7 @@ class JavaThread: public Thread {
   friend class ThreadsSMRSupport; // to access _threadObj for exiting_threads_oops_do
   friend class HandshakeState;
  private:
+  bool           _in_asgct;                      // Is set when this JavaThread is handling ASGCT call
   bool           _on_thread_list;                // Is set when this JavaThread is added to the Threads list
   OopHandle      _threadObj;                     // The Java level thread object
 
@@ -1645,6 +1646,10 @@ class JavaThread: public Thread {
   // Helper function to do vm_exit_on_initialization for osthread
   // resource allocation failure.
   static void vm_exit_on_osthread_failure(JavaThread* thread);
+
+  // AsyncGetCallTrace support
+  inline bool in_asgct(void) {return _in_asgct;}
+  inline void set_in_asgct(bool value) {_in_asgct = value;}
 };
 
 inline JavaThread* JavaThread::current_or_null() {