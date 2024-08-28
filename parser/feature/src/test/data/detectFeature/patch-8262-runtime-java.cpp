@@ -431,7 +431,7 @@ void before_exit(JavaThread* thread) {
 
 #if INCLUDE_JVMCI
   if (EnableJVMCI) {
-    JVMCI::shutdown();
+    JVMCI::shutdown(thread);
   }
 #endif
 