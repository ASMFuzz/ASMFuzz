@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  */
 
 /* Copyright  (c) 2002 Graz University of Technology. All rights reserved.
@@ -416,7 +416,6 @@ CK_RV callJUnlockMutex(CK_VOID_PTR pMutex);
 #endif /* NO_CALLBACKS */
 
 void putModuleEntry(JNIEnv *env, jobject pkcs11Implementation, ModuleData *moduleData);
-ModuleData * removeModuleEntry(JNIEnv *env, jobject pkcs11Implementation);
 CK_FUNCTION_LIST_PTR getFunctionList(JNIEnv *env, jobject pkcs11Implementation);
 CK_FUNCTION_LIST_3_0_PTR getFunctionList30(JNIEnv *env, jobject
         pkcs11Implementation);