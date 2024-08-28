@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 
 #include <stdio.h>
 #include <string.h>
+#include <stddef.h>
 #include <stdlib.h>
 #include <errno.h>
 #include <linux/limits.h>
@@ -123,6 +124,7 @@ static int popenCommand(const char* cmdlineFormat, const char* arg,
     int callbackMode = POPEN_CALLBACK_USE;
     int exitCode = -1;
     int c;
+    ptrdiff_t char_offset;
 
     cmdline = malloc(cmdlineLenth + 1 /* \0 */);
     if (!cmdline) {
@@ -171,13 +173,14 @@ static int popenCommand(const char* cmdlineFormat, const char* arg,
         if (strBufNextChar == strBufEnd) {
             /* Double buffer size */
             strBufCapacity = strBufCapacity * 2 + 1;
+            char_offset = strBufNextChar - strBufBegin;
             strNewBufBegin = realloc(strBufBegin, strBufCapacity);
             if (!strNewBufBegin) {
                 JP_LOG_ERRNO;
                 goto cleanup;
             }
 
-            strBufNextChar = strNewBufBegin + (strBufNextChar - strBufBegin);
+            strBufNextChar = strNewBufBegin + char_offset;
             strBufEnd = strNewBufBegin + strBufCapacity;
             strBufBegin = strNewBufBegin;
         }