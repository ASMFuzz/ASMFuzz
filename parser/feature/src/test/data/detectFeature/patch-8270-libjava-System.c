@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -160,8 +160,8 @@ Java_jdk_internal_util_SystemProps_00024Raw_platformProperties(JNIEnv *env, jcla
     /*
      * file encoding for stdout and stderr
      */
-    PUTPROP(propArray, _sun_stdout_encoding_NDX, sprops->sun_stdout_encoding);
-    PUTPROP(propArray, _sun_stderr_encoding_NDX, sprops->sun_stderr_encoding);
+    PUTPROP(propArray, _stdout_encoding_NDX, sprops->stdout_encoding);
+    PUTPROP(propArray, _stderr_encoding_NDX, sprops->stderr_encoding);
 
     /* unicode_encoding specifies the default endianness */
     PUTPROP(propArray, _sun_io_unicode_encoding_NDX, sprops->unicode_encoding);