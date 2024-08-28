@@ -62,10 +62,6 @@ class VMError : public AllStatic {
   // used by reporting about OOM
   static size_t      _size;
 
-  // used by fatal error handler
-  static int         _current_step;
-  static const char* _current_step_info;
-
   // Thread id of the first error. We must be able to handle native thread,
   // so use thread id instead of Thread* to identify thread.
   static volatile intptr_t _first_error_tid;
@@ -78,17 +74,6 @@ class VMError : public AllStatic {
   // no core/minidump has been written to disk
   static char coredump_message[O_BUFLEN];
 
-  // Timeout handling:
-  // Timestamp at which error reporting started; -1 if no error reporting in progress.
-  static volatile jlong _reporting_start_time;
-  // Whether or not error reporting did timeout.
-  static volatile bool _reporting_did_timeout;
-  // Timestamp at which the last error reporting step started; -1 if no error reporting
-  //   in progress.
-  static volatile jlong _step_start_time;
-  // Whether or not the last error reporting step did timeout.
-  static volatile bool _step_did_timeout;
-
   // Install secondary signal handler to handle secondary faults during error reporting
   // (see VMError::crash_handler)
   static void install_secondary_signal_handler();
@@ -126,16 +111,6 @@ class VMError : public AllStatic {
   static void reporting_started();
   static void interrupt_reporting_thread();
 
-  // Helper function to get the current timestamp.
-  static jlong get_current_timestamp();
-
-  // Accessors to get/set the start times for step and total timeout.
-  static void record_reporting_start_time();
-  static jlong get_reporting_start_time();
-  static void record_step_start_time();
-  static jlong get_step_start_time();
-  static void clear_step_start_time();
-
 public:
 
   // return a string to describe the error