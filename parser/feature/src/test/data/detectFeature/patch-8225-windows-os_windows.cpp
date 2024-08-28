@@ -5311,7 +5311,6 @@ os::ThreadCrashProtection* os::ThreadCrashProtection::_crash_protection = NULL;
 
 os::ThreadCrashProtection::ThreadCrashProtection() {
   _protected_thread = Thread::current();
-  assert(_protected_thread->is_JfrSampler_thread(), "should be JFRSampler");
 }
 
 // See the caveats for this class in os_windows.hpp