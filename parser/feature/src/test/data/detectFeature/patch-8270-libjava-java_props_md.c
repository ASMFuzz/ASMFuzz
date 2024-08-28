@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -709,15 +709,15 @@ GetJavaProperties(JNIEnv* env)
             hStdOutErr = GetStdHandle(STD_OUTPUT_HANDLE);
             if (hStdOutErr != INVALID_HANDLE_VALUE &&
                 GetFileType(hStdOutErr) == FILE_TYPE_CHAR) {
-                sprops.sun_stdout_encoding = getConsoleEncoding();
+                sprops.stdout_encoding = getConsoleEncoding();
             }
             hStdOutErr = GetStdHandle(STD_ERROR_HANDLE);
             if (hStdOutErr != INVALID_HANDLE_VALUE &&
                 GetFileType(hStdOutErr) == FILE_TYPE_CHAR) {
-                if (sprops.sun_stdout_encoding != NULL)
-                    sprops.sun_stderr_encoding = sprops.sun_stdout_encoding;
+                if (sprops.stdout_encoding != NULL)
+                    sprops.stderr_encoding = sprops.stdout_encoding;
                 else
-                    sprops.sun_stderr_encoding = getConsoleEncoding();
+                    sprops.stderr_encoding = getConsoleEncoding();
             }
         }
     }