@@ -992,6 +992,7 @@ void JavaThread::check_for_valid_safepoint_state() {
 JavaThread::JavaThread() :
   // Initialize fields
 
+  _in_asgct(false),
   _on_thread_list(false),
   DEBUG_ONLY(_java_call_counter(0) COMMA)
   _entry_point(nullptr),