@@ -59,6 +59,7 @@
 #include "utilities/defaultStream.hpp"
 #include "utilities/events.hpp"
 #include "utilities/vmError.hpp"
+#include "utilities/vmErrorStepper.hpp"
 #include "utilities/macros.hpp"
 #if INCLUDE_JFR
 #include "jfr/jfr.hpp"
@@ -73,12 +74,6 @@
 
 bool              VMError::coredump_status;
 char              VMError::coredump_message[O_BUFLEN];
-int               VMError::_current_step;
-const char*       VMError::_current_step_info;
-volatile jlong    VMError::_reporting_start_time = -1;
-volatile bool     VMError::_reporting_did_timeout = false;
-volatile jlong    VMError::_step_start_time = -1;
-volatile bool     VMError::_step_did_timeout = false;
 volatile intptr_t VMError::_first_error_tid = -1;
 int               VMError::_id;
 const char*       VMError::_message;
@@ -465,35 +460,6 @@ bool VMError::is_error_reported_in_current_thread() {
   return _first_error_tid == os::current_thread_id();
 }
 
-// Helper, return current timestamp for timeout handling.
-jlong VMError::get_current_timestamp() {
-  return os::javaTimeNanos();
-}
-// Factor to translate the timestamp to seconds.
-#define TIMESTAMP_TO_SECONDS_FACTOR (1000 * 1000 * 1000)
-
-void VMError::record_reporting_start_time() {
-  const jlong now = get_current_timestamp();
-  Atomic::store(&_reporting_start_time, now);
-}
-
-jlong VMError::get_reporting_start_time() {
-  return Atomic::load(&_reporting_start_time);
-}
-
-void VMError::record_step_start_time() {
-  const jlong now = get_current_timestamp();
-  Atomic::store(&_step_start_time, now);
-}
-
-jlong VMError::get_step_start_time() {
-  return Atomic::load(&_step_start_time);
-}
-
-void VMError::clear_step_start_time() {
-  return Atomic::store(&_step_start_time, (jlong)0);
-}
-
 // This is the main function to report a fatal error. Only one thread can
 // call this function, so we don't need to worry about MT-safety. But it's
 // possible that the error handler itself may crash or die on an internal
@@ -522,10 +488,23 @@ void VMError::clear_step_start_time() {
 // segment.
 void VMError::report(outputStream* st, bool _verbose) {
 
-# define BEGIN if (_current_step == 0) { _current_step = __LINE__;
-# define STEP(s) } if (_current_step < __LINE__) { _current_step = __LINE__; _current_step_info = s; \
-  record_step_start_time(); _step_did_timeout = false;
-# define END clear_step_start_time(); }
+#define BEGIN                       \
+{
+
+# define STEP(s)                    \
+}                                   \
+VMErrorStepper::mark(s);            \
+if (VMErrorStepper::step())         \
+{
+
+# define STEP_INTO(s)               \
+}                                   \
+VMErrorStepper::mark(s);            \
+{
+
+# define END                        \
+}                                   \
+VMErrorStepper::clear_step_start_time();
 
   // don't allocate large buffer on stack
   static char buf[O_BUFLEN];
@@ -581,16 +560,16 @@ void VMError::report(outputStream* st, bool _verbose) {
       // care about the time spent executing TIMEOUT_TEST_STEP and not
       // about the time it took us to get here.
       tty->print_cr("Recording reporting_start_time for TestUnresponsiveErrorHandler.");
-      record_reporting_start_time();
+      VMErrorStepper::record_reporting_start_time();
     }
 
-  #define TIMEOUT_TEST_STEP STEP("test unresponsive error reporting step") \
+  #define TIMEOUT_TEST_STEP(s) STEP("test unresponsive error reporting step " s) \
     if (_verbose && TestUnresponsiveErrorHandler) { os::infinite_sleep(); }
-  TIMEOUT_TEST_STEP
-  TIMEOUT_TEST_STEP
-  TIMEOUT_TEST_STEP
-  TIMEOUT_TEST_STEP
-  TIMEOUT_TEST_STEP
+  TIMEOUT_TEST_STEP("1")
+  TIMEOUT_TEST_STEP("2")
+  TIMEOUT_TEST_STEP("3")
+  TIMEOUT_TEST_STEP("4")
+  TIMEOUT_TEST_STEP("5")
 
   STEP("test safefetch in error handler")
     // test whether it is safe to use SafeFetch32 in Crash Handler. Test twice
@@ -879,24 +858,25 @@ void VMError::report(outputStream* st, bool _verbose) {
        st->cr();
      }
 
-  STEP("printing register info")
+  STEP("printing registers")
 
-     // decode register contents if possible
+     // registers
      if (_verbose && _context && _thread && Universe::is_fully_initialized()) {
        ResourceMark rm(_thread);
        os::print_register_info(st, _context);
        st->cr();
      }
 
-  STEP("printing registers, top of stack, instructions near pc")
+  STEP_INTO("printing register info, top of stack, instructions near pc")
 
-     // registers, top of stack, instructions near pc
+     // decode register contents if possible
+     // top of stack, instructions near pc
      if (_verbose && _context) {
        os::print_context(st, _context);
        st->cr();
      }
 
-  STEP("inspecting top of stack")
+  STEP_INTO("inspecting top of stack")
 
      // decode stack contents if possible
      if (_verbose && _context && _thread && Universe::is_fully_initialized()) {
@@ -905,11 +885,15 @@ void VMError::report(outputStream* st, bool _verbose) {
        const intptr_t *start = fr.sp();
        const intptr_t *end = start + slots;
        if (is_aligned(start, sizeof(intptr_t)) && os::is_readable_range(start, end)) {
-         st->print_cr("Stack slot to memory mapping:");
+         if (VMErrorStepper::step()) {
+           st->print_cr("Stack slot to memory mapping:");
+         }
          for (int i = 0; i < slots; ++i) {
-           st->print("stack at sp + %d slots: ", i);
-           ResourceMark rm(_thread);
-           os::print_location(st, *(start + i));
+           if (VMErrorStepper::step()) {
+             st->print("stack at sp + %d slots: ", i);
+             ResourceMark rm(_thread);
+             os::print_location(st, *(start + i));
+           }
          }
        }
        st->cr();
@@ -1203,6 +1187,7 @@ void VMError::report(outputStream* st, bool _verbose) {
   END
 
 # undef BEGIN
+# undef MARK
 # undef STEP
 # undef END
 }
@@ -1516,7 +1501,7 @@ void VMError::report_and_die(int id, const char* message, const char* detail_fmt
       // Record reporting_start_time unless we're running the
       // TestUnresponsiveErrorHandler test. For that test we record
       // reporting_start_time at the beginning of the test.
-      record_reporting_start_time();
+      VMErrorStepper::record_reporting_start_time();
     } else {
       out.print_raw_cr("Delaying recording reporting_start_time for TestUnresponsiveErrorHandler.");
     }
@@ -1576,19 +1561,16 @@ void VMError::report_and_die(int id, const char* message, const char* detail_fmt
       st->cr();
 
       // Timeout handling.
-      if (_step_did_timeout) {
+      if (VMErrorStepper::step_did_timeout()) {
         // The current step had a timeout. Lets continue reporting with the next step.
         st->print_raw("[timeout occurred during error reporting in step \"");
-        st->print_raw(_current_step_info);
-        st->print_cr("\"] after " INT64_FORMAT " s.",
-                     (int64_t)
-                     ((get_current_timestamp() - _step_start_time) / TIMESTAMP_TO_SECONDS_FACTOR));
-      } else if (_reporting_did_timeout) {
+        st->print_raw(VMErrorStepper::identify());
+        st->print_cr("\"] after " INT64_FORMAT " s.", VMErrorStepper::step_timeout());
+      } else if (VMErrorStepper::reporting_did_timeout()) {
         // We hit ErrorLogTimeout. Reporting will stop altogether. Let's wrap things
         // up, the process is about to be stopped by the WatcherThread.
         st->print_cr("------ Timeout during error reporting after " INT64_FORMAT " s. ------",
-                     (int64_t)
-                     ((get_current_timestamp() - _reporting_start_time) / TIMESTAMP_TO_SECONDS_FACTOR));
+                     VMErrorStepper::reporting_timeout());
         st->flush();
         // Watcherthread is about to call os::die. Lets just wait.
         os::infinite_sleep();
@@ -1598,7 +1580,7 @@ void VMError::report_and_die(int id, const char* message, const char* detail_fmt
         // Note: this string does get parsed by a number of jtreg tests,
         // see hotspot/jtreg/runtime/ErrorHandling.
         ss.print("[error occurred during error reporting (%s), id 0x%x",
-                   _current_step_info, id);
+                 VMErrorStepper::identify(), id);
         char signal_name[64];
         if (os::exception_name(id, signal_name, sizeof(signal_name))) {
           ss.print(", %s (0x%x) at pc=" PTR_FORMAT, signal_name, id, p2i(pc));
@@ -1627,9 +1609,7 @@ void VMError::report_and_die(int id, const char* message, const char* detail_fmt
     }
 
     out_done = true;
-
-    _current_step = 0;
-    _current_step_info = "";
+    VMErrorStepper::reset();
   }
 
   // Part 2: print a full error log file (optionally to stdout or stderr).
@@ -1658,8 +1638,7 @@ void VMError::report_and_die(int id, const char* message, const char* detail_fmt
 
     report(&log, true);
     log_done = true;
-    _current_step = 0;
-    _current_step_info = "";
+    VMErrorStepper::reset();
 
     if (fd_log > 3) {
       ::close(fd_log);
@@ -1836,37 +1815,17 @@ bool VMError::check_timeout() {
     return false;
   }
 
-  const jlong reporting_start_time_l = get_reporting_start_time();
-  const jlong now = get_current_timestamp();
-  // Timestamp is stored in nanos.
-  if (reporting_start_time_l > 0) {
-    const jlong end = reporting_start_time_l + (jlong)ErrorLogTimeout * TIMESTAMP_TO_SECONDS_FACTOR;
-    if (end <= now && !_reporting_did_timeout) {
-      // We hit ErrorLogTimeout and we haven't interrupted the reporting
-      // thread yet.
-      _reporting_did_timeout = true;
-      interrupt_reporting_thread();
-      return true; // global timeout
-    }
+  if (VMErrorStepper::check_reporting_timeout((jlong)ErrorLogTimeout)) {
+    interrupt_reporting_thread();
+    return true; // global timeout
   }
 
-  const jlong step_start_time_l = get_step_start_time();
-  if (step_start_time_l > 0) {
-    // A step times out after a quarter of the total timeout. Steps are mostly fast unless they
-    // hang for some reason, so this simple rule allows for three hanging step and still
-    // hopefully leaves time enough for the rest of the steps to finish.
-    const jlong end = step_start_time_l + (jlong)ErrorLogTimeout * TIMESTAMP_TO_SECONDS_FACTOR / 4;
-    if (end <= now && !_step_did_timeout) {
-      // The step timed out and we haven't interrupted the reporting
-      // thread yet.
-      _step_did_timeout = true;
-      interrupt_reporting_thread();
-      return false; // (Not a global timeout)
-    }
+  if (VMErrorStepper::check_step_timeout((jlong)ErrorLogTimeout)) {
+    interrupt_reporting_thread();
+    return false; // (Not a global timeout)
   }
 
   return false;
-
 }
 
 #ifdef ASSERT