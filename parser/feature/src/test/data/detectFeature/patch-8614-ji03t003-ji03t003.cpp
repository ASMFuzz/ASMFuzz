@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,6 +39,8 @@ extern "C" {
 static jvmtiEnv *jvmti = NULL;
 static jint result = PASSED;
 static int verbose = 0;
+// test thread
+static jthread testThread = NULL;
 
 static const char *javaField = "exc";
 static const char *excClassSig =
@@ -55,14 +57,37 @@ int throw_calls = 0;
 int thrownew_calls = 0;
 int excoccur_calls = 0;
 
+void setTestThread(JNIEnv *env) {
+    jthread curThread = NULL;
+    NSK_JVMTI_VERIFY(jvmti->GetCurrentThread(&curThread));
+    testThread = env->NewGlobalRef(curThread);
+}
+
+void resetTestThread(JNIEnv *env) {
+     env->DeleteGlobalRef(testThread);
+     testThread = NULL;
+}
+
+bool isOnTestThread(JNIEnv *env) {
+    jthread curThread = NULL;
+    NSK_JVMTI_VERIFY(jvmti->GetCurrentThread(&curThread));
+    return env->IsSameObject(testThread, curThread);
+}
+
 /** redirected JNI functions **/
 jint JNICALL MyThrow(JNIEnv *env, jthrowable thrw) {
     jint res;
 
-    throw_calls++;
-    if (verbose)
-        printf("\nMyThrow: the function called successfully: number of calls=%d\n",
-            throw_calls);
+    if (isOnTestThread(env)) {
+        throw_calls++;
+        if (verbose) {
+            printf("\nMyThrow: the function called successfully: number of calls=%d\n", throw_calls);
+        }
+    } else {
+        if (verbose) {
+            printf("\nMyThrow: the function called on non-test thread, ignoring\n");
+        }
+    }
 
     res = orig_jni_functions->Throw(env, thrw);
 
@@ -74,10 +99,16 @@ jint JNICALL MyThrow(JNIEnv *env, jthrowable thrw) {
 jint JNICALL MyThrowNew(JNIEnv *env, jclass cls, const char *msg) {
     jint res;
 
-    thrownew_calls++;
-    if (verbose)
-        printf("\nMyThrowNew: the function called successfully: number of calls=%d\n",
-            thrownew_calls);
+    if (isOnTestThread(env)) {
+        thrownew_calls++;
+        if (verbose) {
+            printf("\nMyThrowNew: the function called successfully: number of calls=%d\n", thrownew_calls);
+        }
+    } else {
+        if (verbose) {
+            printf("\nMyThrowNew: the function called on non-test thread, ignoring\n");
+        }
+    }
 
     res = orig_jni_functions->ThrowNew(env, cls, msg);
 
@@ -87,11 +118,15 @@ jint JNICALL MyThrowNew(JNIEnv *env, jclass cls, const char *msg) {
 }
 
 jthrowable JNICALL MyExceptionOccurred(JNIEnv *env) {
-    if (isThreadExpected(jvmti, NULL)) {
+    if (isOnTestThread(env)) {
         excoccur_calls++;
-        if (verbose)
-            printf("\nMyExceptionOccurred: the function called successfully: number of calls=%d\n",
-                   excoccur_calls);
+        if (verbose) {
+            printf("\nMyExceptionOccurred: the function called successfully: number of calls=%d\n", excoccur_calls);
+        }
+    } else {
+        if (verbose) {
+            printf("\nMyExceptionOccurred: the function called on non-test thread, ignoring\n");
+        }
     }
 
     return orig_jni_functions->ExceptionOccurred(env);
@@ -284,6 +319,8 @@ Java_nsk_jvmti_scenarios_jni_1interception_JI03_ji03t003_check(JNIEnv *env, jobj
            javaField);
     thrw = env->GetObjectClass(thrwObj);
 
+    setTestThread(env);
+
     /* 1: check the JNI function table interception */
     if (verbose)
         printf("\na) Checking the JNI function table interception ...\n");
@@ -301,6 +338,8 @@ Java_nsk_jvmti_scenarios_jni_1interception_JI03_ji03t003_check(JNIEnv *env, jobj
     env->DeleteLocalRef(thrw);
     env->DeleteLocalRef(thrwObj);
 
+    resetTestThread(env);
+
     return result;
 }
 