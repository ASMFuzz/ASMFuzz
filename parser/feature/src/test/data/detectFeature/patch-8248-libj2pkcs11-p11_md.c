@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 
 /* Copyright  (c) 2002 Graz University of Technology. All rights reserved.
@@ -275,19 +275,21 @@ JNIEXPORT jobject JNICALL Java_sun_security_pkcs11_wrapper_PKCS11_connect
 /*
  * Class:     sun_security_pkcs11_wrapper_PKCS11
  * Method:    disconnect
- * Signature: ()V
+ * Signature: (J)V
  */
-JNIEXPORT void JNICALL Java_sun_security_pkcs11_wrapper_PKCS11_disconnect
-    (JNIEnv *env, jobject obj)
-{
-    ModuleData *moduleData;
+JNIEXPORT void JNICALL Java_sun_security_pkcs11_wrapper_PKCS11_disconnect(
+        JNIEnv *env, jclass thisClass, jlong ckpNativeData) {
+
     TRACE0("DEBUG: disconnecting module...");
-    moduleData = removeModuleEntry(env, obj);
+    if (ckpNativeData != 0L) {
+        ModuleData *moduleData = jlong_to_ptr(ckpNativeData);
 
-    if (moduleData != NULL) {
-        FreeLibrary(moduleData->hModule);
+        if (moduleData->hModule != NULL) {
+            FreeLibrary(moduleData->hModule);
+        }
+
+        free(moduleData);
     }
 
-    free(moduleData);
     TRACE0("FINISHED\n");
 }