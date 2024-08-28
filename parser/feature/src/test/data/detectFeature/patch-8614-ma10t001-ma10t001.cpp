@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -41,8 +41,39 @@ static jlong timeout = 0;
 static int ExceptionEventsCount = 0;
 static int ExceptionCatchEventsCount = 0;
 
+// test thread
+static const char *testThreadName = "Debuggee Thread";
+
 /* ========================================================================== */
 
+void releaseThreadInfo(jvmtiEnv *jvmti_env, JNIEnv *jni_env, jvmtiThreadInfo *info) {
+    jvmti_env->Deallocate((unsigned char *)info->name);
+    if (info->thread_group != NULL) {
+        jni_env->DeleteLocalRef(info->thread_group);
+    }
+    if (info->context_class_loader != NULL) {
+        jni_env->DeleteLocalRef(info->context_class_loader);
+    }
+}
+
+static bool isTestThread(const char *msg, jvmtiEnv *jvmti_env, JNIEnv *jni_env, jthread thread) {
+    jvmtiThreadInfo inf;
+    jvmtiError err = jvmti_env->GetThreadInfo(thread, &inf);
+    if (err != JVMTI_ERROR_NONE) {
+        printf("%s: Failed to get thread info: %s (%d)\n", msg, TranslateError(err), err);
+        return false;
+    }
+
+    bool result = strcmp(testThreadName, inf.name) == 0;
+    if (!result) {
+        NSK_DISPLAY2("%s: event on unexpected thread %s\n", msg, inf.name);
+    }
+
+    releaseThreadInfo(jvmti_env, jni_env, &inf);
+
+    return result;
+}
+
 /** callback functions **/
 
 static void JNICALL
@@ -52,7 +83,7 @@ Exception(jvmtiEnv *jvmti_env, JNIEnv *jni_env, jthread thread,
     jclass klass = NULL;
     char *signature = NULL;
 
-    if (!isThreadExpected(jvmti_env, thread)) {
+    if (!isTestThread("Exception", jvmti_env, jni_env, thread)) {
         return;
     }
 
@@ -77,7 +108,7 @@ ExceptionCatch(jvmtiEnv *jvmti_env, JNIEnv *jni_env, jthread thread,
     jclass klass = NULL;
     char *signature = NULL;
 
-    if (!isThreadExpected(jvmti_env, thread)) {
+    if (!isTestThread("ExceptionCatch", jvmti_env, jni_env, thread)) {
         return;
     }
 