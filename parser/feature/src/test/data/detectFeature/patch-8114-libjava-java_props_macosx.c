@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -212,14 +212,16 @@ const char * convertToPOSIXLocale(const char* src) {
     return src;
 }
 
+/**
+ * Return locale from Posix if it is defined and non-empty,
+ * with a fallback to macOS language environment.
+ */
 char *setupMacOSXLocale(int cat) {
-    char * ret = getMacOSXLocale(cat);
-
-    if (ret == NULL) {
-        return getPosixLocale(cat);
-    } else {
+    char * ret = getPosixLocale(cat);
+    if (ret != NULL && strlen(ret) > 0) {
         return ret;
     }
+    return getMacOSXLocale(cat);
 }
 
 // 10.9 SDK does not include the NSOperatingSystemVersion struct.