@@ -142,8 +142,9 @@ class win32 {
 };
 
 /*
- * Crash protection for the JfrSampler thread. Wrap the callback
- * with a __try { call() }
+ * Crash protection for the JfrSampler thread (but also used for AsyncGetCallTrace).
+ * Wrap the callback with a sigsetjmp and in case of a SIGSEGV/SIGBUS we siglongjmp
+ * back.
  * To be able to use this - don't take locks, don't rely on destructors,
  * don't make OS library calls, don't allocate memory, don't print,
  * don't call code that could leave the heap / memory in an inconsistent state,