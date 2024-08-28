@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 
 /* Copyright  (c) 2002 Graz University of Technology. All rights reserved.
@@ -165,21 +165,6 @@ int isModulePresent(JNIEnv *env, jobject pkcs11Implementation) {
     return present ;
 }
 
-
-/*
- * Removes the entry for the given pkcs11Implementation from the list. Returns
- * the module's data, after the node was removed. If this function returns NULL
- * the pkcs11Implementation was not in the list.
- */
-ModuleData * removeModuleEntry(JNIEnv *env, jobject pkcs11Implementation) {
-    ModuleData *moduleData = getModuleEntry(env, pkcs11Implementation);
-    if (moduleData == NULL) {
-        return NULL;
-    }
-    (*env)->SetLongField(env, pkcs11Implementation, pNativeDataID, 0);
-    return moduleData;
-}
-
 /*
  * Removes all present entries from the list of modules and frees all
  * associated resources. This function is used for clean-up.