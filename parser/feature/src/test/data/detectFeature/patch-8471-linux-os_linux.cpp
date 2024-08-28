@@ -4483,7 +4483,7 @@ jint os::init_2(void) {
   }
 
   // Check and sets minimum stack sizes against command line options
-  if (Posix::set_minimum_stack_sizes() == JNI_ERR) {
+  if (set_minimum_stack_sizes() == JNI_ERR) {
     return JNI_ERR;
   }
 