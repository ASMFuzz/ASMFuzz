@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -51,6 +51,8 @@
  */
 
 
+#include <assert.h>
+
 #include "java.h"
 #include "jni.h"
 
@@ -1626,7 +1628,8 @@ TranslateApplicationArgs(int jargc, const char **jargv, int *pargc, char ***parg
     for (i = 0; i < jargc; i++) {
         const char *arg = jargv[i];
         if (arg[0] == '-' && arg[1] == 'J') {
-            *nargv++ = ((arg + 2) == NULL) ? NULL : JLI_StringDup(arg + 2);
+            assert(arg[2] != '\0' && "Invalid JAVA_ARGS or EXTRA_JAVA_ARGS defined by build");
+            *nargv++ = JLI_StringDup(arg + 2);
         }
     }
 