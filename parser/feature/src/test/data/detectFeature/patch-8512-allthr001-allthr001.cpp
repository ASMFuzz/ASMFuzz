@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,27 +39,45 @@ typedef struct {
     const char **thrNames;
 } info;
 
+typedef struct  {
+    info expected;
+    info unexpected;
+} threadInfo;
+
 static jvmtiEnv *jvmti;
 static jrawMonitorID lock1;
 static jrawMonitorID lock2;
 static jboolean printdump = JNI_FALSE;
 static jint result = PASSED;
-static jvmtiThreadInfo inf;
-static int sys_cnt;
-static const char *names0[] = { "main" };
-static const char *names1[] = { "main", "thread1" };
-static const char *names2[] = { "main", "Thread-" };
-static info thrInfo[] = {
-    { 1, names0 }, { 1, names0 }, { 2, names1 }, { 1, names0 }, { 2, names2 }
+
+static const char main_name[] = "main";
+static const char thread1_name[] = "thread1";
+static const char sys_thread_name[] = "SysThread";
+
+static const char *main_only[] = { main_name };
+static const char *thr1_only[] = { thread1_name };
+static const char *sys_only[] = { sys_thread_name };
+static const char *main_thr1[] = { main_name, thread1_name };
+static const char *main_sys[] = { main_name, sys_thread_name };
+static const char *thr1_sys[] = { thread1_name, sys_thread_name };
+
+static threadInfo thrInfo[] = {
+    {{1, main_only},    {2, thr1_sys}},
+    {{1, main_only},    {2, thr1_sys}},
+    {{2, main_thr1},    {1, sys_only}},
+    {{1, main_only},    {2, thr1_sys}},
+    {{2, main_sys},     {1, thr1_only}}
 };
 
 jthread jthr(JNIEnv *env) {
     jclass thrClass;
     jmethodID cid;
     jthread res;
     thrClass = env->FindClass("java/lang/Thread");
-    cid = env->GetMethodID(thrClass, "<init>", "()V");
-    res = env->NewObject(thrClass, cid);
+    cid = env->GetMethodID(thrClass, "<init>", "(Ljava/lang/String;)V");
+    jstring thread_name = env->NewStringUTF(sys_thread_name);
+    res = env->NewObject(thrClass, cid, thread_name);
+    env->DeleteLocalRef(thread_name);
     return res;
 }
 
@@ -149,12 +167,22 @@ jint  Agent_Initialize(JavaVM *jvm, char *options, void *reserved) {
     return JNI_OK;
 }
 
+void releaseThreadInfo(JNIEnv *env, jvmtiThreadInfo *info) {
+    jvmti->Deallocate((unsigned char *)info->name);
+    if (info->thread_group != NULL) {
+        env->DeleteLocalRef(info->thread_group);
+    }
+    if (info->context_class_loader != NULL) {
+        env->DeleteLocalRef(info->context_class_loader);
+    }
+}
+
 JNIEXPORT void checkInfo(JNIEnv *env, int ind) {
     jint threadsCount = -1;
     jthread *threads;
-    int i, j, found;
     jvmtiError err;
-    int num_unexpected = 0;
+    int expected = 0;
+    jvmtiThreadInfo inf;
 
     if (printdump == JNI_TRUE) {
         printf(" >>> Check: %d\n", ind);
@@ -196,42 +224,49 @@ JNIEXPORT void checkInfo(JNIEnv *env, int ind) {
         return;
     }
 
-    for (i = 0; i < threadsCount; i++) {
-        if (!isThreadExpected(jvmti, threads[i])) {
-            num_unexpected++;
+    // check unexpected threads
+    for (int i = 0; i < threadsCount; i++) {
+        err = jvmti->GetThreadInfo(threads[i], &inf);
+        if (err != JVMTI_ERROR_NONE) {
+            printf("Failed to get thread info: %s (%d)\n",
+                   TranslateError(err), err);
+            result = STATUS_FAILED;
+            return;
+        }
+        if (printdump == JNI_TRUE) {
+            printf(" >>> %s", inf.name);
+        }
+        bool found = false;
+        for (int j = 0; j < thrInfo[ind].unexpected.cnt && !found; j++) {
+            found = (inf.name != NULL && strcmp(inf.name, thrInfo[ind].unexpected.thrNames[j]) == 0);
         }
+        if (found) {
+            printf("Point %d: detected unexpected thread %s\n", ind, inf.name);
+            result = STATUS_FAILED;
+        }
+        releaseThreadInfo(env, &inf);
     }
-
-    if (threadsCount - num_unexpected != thrInfo[ind].cnt + sys_cnt) {
-        printf("Point %d: number of threads expected: %d, got: %d\n",
-            ind, thrInfo[ind].cnt + sys_cnt, threadsCount - num_unexpected);
-        result = STATUS_FAILED;
-        return;
+    if (printdump == JNI_TRUE) {
+        printf("\n");
     }
 
-    for (i = 0; i < thrInfo[ind].cnt; i++) {
-        for (j = 0, found = 0; j < threadsCount && !found; j++) {
+    // verify all expected threads are present
+    for (int i = 0; i < thrInfo[ind].expected.cnt; i++) {
+        bool found = false;
+        for (int j = 0; j < threadsCount && !found; j++) {
             err = jvmti->GetThreadInfo(threads[j], &inf);
             if (err != JVMTI_ERROR_NONE) {
                 printf("Failed to get thread info: %s (%d)\n",
                        TranslateError(err), err);
                 result = STATUS_FAILED;
                 return;
             }
-            if (printdump == JNI_TRUE) {
-                printf(" >>> %s", inf.name);
-            }
-            found = (inf.name != NULL &&
-                     strstr(inf.name, thrInfo[ind].thrNames[i]) == inf.name &&
-                     (ind == 4 || strlen(inf.name) ==
-                      strlen(thrInfo[ind].thrNames[i])));
-        }
-        if (printdump == JNI_TRUE) {
-            printf("\n");
+            found = (inf.name != NULL && strcmp(inf.name, thrInfo[ind].expected.thrNames[j]) == 0);
+            releaseThreadInfo(env, &inf);
         }
         if (!found) {
             printf("Point %d: thread %s not detected\n",
-                   ind, thrInfo[ind].thrNames[i]);
+                   ind, thrInfo[ind].expected.thrNames[i]);
             result = STATUS_FAILED;
         }
     }
@@ -265,33 +300,6 @@ JNIEXPORT void checkInfo(JNIEnv *env, int ind) {
     }
 }
 
-JNIEXPORT void JNICALL Java_nsk_jvmti_GetAllThreads_allthr001_setSysCnt(JNIEnv *env, jclass cls) {
-    jint threadsCount = -1;
-    jthread *threads;
-    jvmtiError err;
-    int i;
-
-    err = jvmti->GetAllThreads(&threadsCount, &threads);
-    if (err != JVMTI_ERROR_NONE) {
-        printf("Failed to get all threads (count): %s (%d)\n",
-               TranslateError(err), err);
-        result = STATUS_FAILED;
-        return;
-    }
-
-    sys_cnt = threadsCount - 1;
-
-    for (i = 0; i < threadsCount; i++) {
-        if (!isThreadExpected(jvmti, threads[i])) {
-            sys_cnt--;
-        }
-    }
-
-    if (printdump == JNI_TRUE) {
-        printf(" >>> number of system threads: %d\n", sys_cnt);
-    }
-}
-
 JNIEXPORT void JNICALL
 Java_nsk_jvmti_GetAllThreads_allthr001_checkInfo(JNIEnv *env, jclass cls, jint ind) {
     checkInfo(env, ind);