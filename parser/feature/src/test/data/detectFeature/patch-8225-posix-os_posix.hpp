@@ -107,8 +107,8 @@ class Posix {
 };
 
 /*
- * Crash protection for the JfrSampler thread. Wrap the callback
- * with a sigsetjmp and in case of a SIGSEGV/SIGBUS we siglongjmp
+ * Crash protection for the JfrSampler thread (but also used for AsyncGetCallTrace).
+ * Wrap the callback with a sigsetjmp and in case of a SIGSEGV/SIGBUS we siglongjmp
  * back.
  * To be able to use this - don't take locks, don't rely on destructors,
  * don't make OS library calls, don't allocate memory, don't print,
@@ -118,18 +118,21 @@ class Posix {
 class ThreadCrashProtection : public StackObj {
 public:
   static bool is_crash_protected(Thread* thr) {
-    return _crash_protection != NULL && _protected_thread == thr;
+    return _crash_protection != NULL && _crash_protection->_protected_thread == thr;
   }
 
   ThreadCrashProtection();
   bool call(os::CrashProtectionCallback& cb);
 
   static void check_crash_protection(int signal, Thread* thread);
 private:
-  static Thread* _protected_thread;
+
   static ThreadCrashProtection* _crash_protection;
+  ThreadCrashProtection* _outer_protection;
+  Thread* _protected_thread;
   void restore();
   sigjmp_buf _jmpbuf;
+  static sigset_t _saved_sig_mask;
 };
 
 /*