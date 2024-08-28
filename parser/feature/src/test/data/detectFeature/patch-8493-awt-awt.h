@@ -85,6 +85,9 @@ extern void awt_output_flush();
 
 #define AWT_LOCK_IMPL() \
     do { \
+        if ((*env)->ExceptionCheck(env)) { \
+            (*env)->ExceptionClear(env); \
+        } \
         (*env)->CallStaticVoidMethod(env, tkClass, awtLockMID); \
         if ((*env)->ExceptionCheck(env)) { \
             (*env)->ExceptionClear(env); \