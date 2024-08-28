@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2020, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 
 #include <io.h>
 #include <fcntl.h>
+#include <stdlib.h>
 #include <windows.h>
 
 #include "AppLauncher.h"
@@ -180,11 +181,7 @@ void launchApp() {
                                                         GetExitCodeProcess));
         }
 
-        if (exitCode != 0) {
-            JP_THROW(tstrings::any() << "Child process exited with code "
-                                                                << exitCode);
-        }
-
+        exit(exitCode);
         return;
     }
 