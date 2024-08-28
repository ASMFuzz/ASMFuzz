@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -581,33 +581,6 @@ void nsk_jvmti_agentFailed() {
     agentFailed = NSK_TRUE;
 }
 
-int isThreadExpected(jvmtiEnv *jvmti, jthread thread) {
-    static const char *vm_jfr_buffer_thread_name = "VM JFR Buffer Thread";
-    static const char *jfr_request_timer_thread_name = "JFR request timer";
-    static const char *graal_management_bean_registration_thread_name =
-                                            "HotSpotGraalManagement Bean Registration";
-    static const char *graal_compiler_thread_name_prefix = "JVMCI CompilerThread";
-    static const size_t prefixLength = strlen(graal_compiler_thread_name_prefix);
-
-    jvmtiThreadInfo threadinfo;
-    NSK_JVMTI_VERIFY(jvmti->GetThreadInfo(thread, &threadinfo));
-
-    if (strcmp(threadinfo.name, vm_jfr_buffer_thread_name) == 0)
-        return 0;
-
-    if (strcmp(threadinfo.name, jfr_request_timer_thread_name) == 0)
-        return 0;
-
-    if (strcmp(threadinfo.name, graal_management_bean_registration_thread_name) == 0)
-        return 0;
-
-    if ((strlen(threadinfo.name) > prefixLength) &&
-         strncmp(threadinfo.name, graal_compiler_thread_name_prefix, prefixLength) == 0)
-        return 0;
-
-    return 1;
-}
-
 #define SLEEP_DELAY 10L
 
 int suspendThreadAtMethod(jvmtiEnv *jvmti, jclass cls, jobject thread, jmethodID testMethod) {