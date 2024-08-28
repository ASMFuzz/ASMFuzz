@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -937,7 +937,7 @@ Java_sun_security_jgss_wrapper_GSSLibStub_initContext(JNIEnv *env,
   // this is to work with both MIT and Solaris. Former deletes half-built
   // context if error occurs
   if (contextHdl != contextHdlSave) {
-    (*env)->SetLongField(env, jcontextSpi, FID_NativeGSSContext_pContext,
+    (*env)->CallVoidMethod(env, jcontextSpi, MID_NativeGSSContext_setContext,
                          ptr_to_jlong(contextHdl));
     TRACE1("[GSSLibStub_initContext] set pContext=%" PRIuPTR "", (uintptr_t)contextHdl);
   }
@@ -1057,7 +1057,7 @@ Java_sun_security_jgss_wrapper_GSSLibStub_acceptContext(JNIEnv *env,
   // this is to work with both MIT and Solaris. Former deletes half-built
   // context if error occurs
   if (contextHdl != contextHdlSave) {
-    (*env)->SetLongField(env, jcontextSpi, FID_NativeGSSContext_pContext,
+    (*env)->CallVoidMethod(env, jcontextSpi, MID_NativeGSSContext_setContext,
                          ptr_to_jlong(contextHdl));
     TRACE1("[GSSLibStub_acceptContext] set pContext=%" PRIuPTR "", (uintptr_t)contextHdl);
   }