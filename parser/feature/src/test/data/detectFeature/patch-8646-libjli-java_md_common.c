@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -126,10 +126,13 @@ ProgramExists(char *name)
 static char *
 Resolve(char *indir, char *cmd)
 {
-    char name[PATH_MAX + 2], *real;
+    char name[PATH_MAX + 1], *real;
+    int snprintf_result;
 
-    if ((JLI_StrLen(indir) + JLI_StrLen(cmd) + 1)  > PATH_MAX) return 0;
-    JLI_Snprintf(name, sizeof(name), "%s%c%s", indir, FILE_SEPARATOR, cmd);
+    snprintf_result = JLI_Snprintf(name, sizeof(name), "%s%c%s", indir, FILE_SEPARATOR, cmd);
+    if ((snprintf_result < 0) || (snprintf_result >= (int)sizeof(name))) {
+      return NULL;
+    }
     if (!ProgramExists(name)) return 0;
     real = JLI_MemAlloc(PATH_MAX + 2);
     if (!realpath(name, real))