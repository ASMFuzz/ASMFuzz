@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -187,7 +187,6 @@ static bool register_callbacks(JavaThread* jt) {
   jvmtiEventCallbacks callbacks;
   /* Set callbacks */
   memset(&callbacks, 0, sizeof(callbacks));
-  callbacks.ClassFileLoadHook = jfr_on_class_file_load_hook;
   const jvmtiError jvmti_ret_code = jfr_jvmti_env->SetEventCallbacks(&callbacks, sizeof(callbacks));
   check_jvmti_error(jfr_jvmti_env, jvmti_ret_code, "SetEventCallbacks");
   return jvmti_ret_code == JVMTI_ERROR_NONE;