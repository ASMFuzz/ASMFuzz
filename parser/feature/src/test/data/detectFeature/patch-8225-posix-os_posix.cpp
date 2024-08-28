@@ -1150,12 +1150,12 @@ bool os::Posix::matches_effective_uid_and_gid_or_root(uid_t uid, gid_t gid) {
     return is_root(uid) || (geteuid() == uid && getegid() == gid);
 }
 
-Thread* os::ThreadCrashProtection::_protected_thread = NULL;
 os::ThreadCrashProtection* os::ThreadCrashProtection::_crash_protection = NULL;
+sigset_t os::ThreadCrashProtection::_saved_sig_mask;
+
 
 os::ThreadCrashProtection::ThreadCrashProtection() {
   _protected_thread = Thread::current();
-  assert(_protected_thread->is_JfrSampler_thread(), "should be JFRSampler");
 }
 
 /*
@@ -1165,26 +1165,27 @@ os::ThreadCrashProtection::ThreadCrashProtection() {
  * The callback is supposed to provide the method that should be protected.
  */
 bool os::ThreadCrashProtection::call(os::CrashProtectionCallback& cb) {
-  sigset_t saved_sig_mask;
-
   // we cannot rely on sigsetjmp/siglongjmp to save/restore the signal mask
   // since on at least some systems (OS X) siglongjmp will restore the mask
   // for the process, not the thread
-  pthread_sigmask(0, NULL, &saved_sig_mask);
+  if (_outer_protection == NULL) { // only for the outer most crash protection
+    pthread_sigmask(0, NULL, &_saved_sig_mask);
+  }
   if (sigsetjmp(_jmpbuf, 0) == 0) {
+    // store the currently active crash protection
+    // this happens if crash protections are nested
+    _outer_protection = _crash_protection;
     // make sure we can see in the signal handler that we have crash protection
     // installed
     _crash_protection = this;
     cb.call();
-    // and clear the crash protection
-    _crash_protection = NULL;
-    _protected_thread = NULL;
+    // and reset the crash protection
+    _crash_protection = _outer_protection;
     return true;
   }
   // this happens when we siglongjmp() back
-  pthread_sigmask(SIG_SETMASK, &saved_sig_mask, NULL);
-  _crash_protection = NULL;
-  _protected_thread = NULL;
+  pthread_sigmask(SIG_SETMASK, &_saved_sig_mask, NULL);
+  _crash_protection = _outer_protection;
   return false;
 }
 
@@ -1195,11 +1196,7 @@ void os::ThreadCrashProtection::restore() {
 
 void os::ThreadCrashProtection::check_crash_protection(int sig,
     Thread* thread) {
-
-  if (thread != NULL &&
-      thread == _protected_thread &&
-      _crash_protection != NULL) {
-
+  if (thread != NULL && is_crash_protected(thread)) {
     if (sig == SIGSEGV || sig == SIGBUS) {
       _crash_protection->restore();
     }