@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -218,14 +218,14 @@ class PathBuffer: public PathBufferBase {
       char* q = strchr(p, ';');
       if (q != NULL) {
         if (len == (q - p)) {
-          if (strnicmp(p, directory, len) == 0) {
+          if (_strnicmp(p, directory, len) == 0) {
             return true;
           }
         }
         p = q + 1;
       } else {
         // tail
-        return stricmp(p, directory) == 0 ? true : false;
+        return _stricmp(p, directory) == 0;
       }
     }
     return false;