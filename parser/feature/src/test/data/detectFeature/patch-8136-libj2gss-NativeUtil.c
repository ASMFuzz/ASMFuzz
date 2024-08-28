@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -81,6 +81,7 @@ jmethodID MID_InetAddress_getAddr;
 jmethodID MID_GSSNameElement_ctor;
 jmethodID MID_GSSCredElement_ctor;
 jmethodID MID_NativeGSSContext_ctor;
+jmethodID MID_NativeGSSContext_setContext;
 jfieldID FID_GSSLibStub_pMech;
 jfieldID FID_NativeGSSContext_pContext;
 jfieldID FID_NativeGSSContext_srcName;
@@ -290,6 +291,15 @@ DEF_JNI_OnLoad(JavaVM *jvm, void *reserved) {
     printf("Couldn't find NativeGSSContext(long, GSSLibStub) constructor\n");
     return JNI_ERR;
   }
+
+  MID_NativeGSSContext_setContext =
+    (*env)->GetMethodID(env, CLS_NativeGSSContext, "setContext",
+                        "(J)V");
+  if (MID_NativeGSSContext_setContext == NULL) {
+    printf("Couldn't find NativeGSSContext.setContext(long) method\n");
+    return JNI_ERR;
+  }
+
   /* Compute and cache the field ID */
   cls = (*env)->FindClass(env, "sun/security/jgss/wrapper/GSSLibStub");
   if (cls == NULL) {