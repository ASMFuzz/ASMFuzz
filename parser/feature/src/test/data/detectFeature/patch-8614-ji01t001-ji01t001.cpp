@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -45,6 +45,9 @@ static jrawMonitorID eventLock;
 static jvmtiEventCallbacks callbacks;
 static jint result = NSK_STATUS_PASSED;
 
+// test thread
+static jthread testThread = NULL;
+
 /* the original JNI function table */
 static jniNativeInterface *orig_jni_functions = NULL;
 
@@ -54,10 +57,27 @@ static jniNativeInterface *redir_jni_functions = NULL;
 /* number of the redirected JNI function calls */
 static volatile int fnd_calls = 0;
 
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
 /* ====================================================================== */
 /** redirected JNI functions **/
 jclass JNICALL MyFindClass(JNIEnv *env, const char *name) {
-    if (isThreadExpected(jvmti, NULL)) {
+    if (isOnTestThread(env) && strcmp(name, classSig) == 0) {
         fnd_calls++;
 
         NSK_DISPLAY1("MyFindClass: the function was called successfully: number of calls so far =  %d\n", fnd_calls);
@@ -192,6 +212,9 @@ static void checkCall(JNIEnv *env
 {
     jclass cls;
 
+    setTestThread(env);
+    fnd_calls = 0;
+
     NSK_TRACE(
         (cls = env->FindClass(classSig))
         );
@@ -200,23 +223,18 @@ static void checkCall(JNIEnv *env
         env->ExceptionClear()
         );
 
-    // The check should pass if the actual number of invocations is not less that the expected number (fnd_calls >= exFndCalls).
+    resetTestThread(env);
+
+    // The check should pass if the actual number of invocations is the same as the expected number (fnd_calls == exFndCalls).
     // If the invocation is not expected (exFndCalls == 0), fnd_calls should be also == 0.
-    if ((exFndCalls > 0 && fnd_calls >= exFndCalls) || (fnd_calls == exFndCalls)) {
+    if (fnd_calls == exFndCalls) {
             NSK_DISPLAY5("CHECK PASSED: %s: the %s JNI function FindClass() has been %s during %s phase\n\t%d intercepted call(s) as expected\n"
                         , callBackFunc
                         , (step == 1) ? "tested" : "original"
                         , (step == 1) ? "redirected" : "restored"
                         , msg
                         , fnd_calls
                         );
-
-            if (fnd_calls != exFndCalls) {
-                NSK_COMPLAIN2("WARNING: the number of occured calls (%d) exceeds the expected number of calls (%d).\n"
-                             , fnd_calls
-                             , exFndCalls
-                             );
-            }
     } else {
         result = NSK_STATUS_FAILED;
 
@@ -244,12 +262,10 @@ VMInit(jvmtiEnv *jvmti, JNIEnv *env, jthread thread) {
                 );
 
     // check JNI function table interception
-    fnd_calls = 0;
     NSK_TRACE(doRedirect(jvmti, phase));
     NSK_TRACE(checkCall(env, 1, "VMInit", TranslatePhase(phase), 1));
 
     // check restored JNI function table
-    fnd_calls = 0;
     NSK_TRACE(doRestore(jvmti));
     NSK_TRACE(checkCall(env, 2, "VMInit", TranslatePhase(phase), 0));
 
@@ -268,12 +284,10 @@ VMDeath(jvmtiEnv *jvmti, JNIEnv *env) {
                 );
 
     // check JNI function table interception
-    fnd_calls = 0;
     NSK_TRACE(doRedirect(jvmti, phase));
     NSK_TRACE(checkCall(env, 1, "VMDeath", TranslatePhase(phase), 1));
 
     // check restored JNI function table
-    fnd_calls = 0;
     NSK_TRACE(doRestore(jvmti));
     NSK_TRACE(checkCall(env, 2, "VMDeath", TranslatePhase(phase), 0));
 