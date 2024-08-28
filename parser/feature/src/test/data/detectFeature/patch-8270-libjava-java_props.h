@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -65,8 +65,8 @@ typedef struct {
     char *display_variant;
     char *encoding;
     char *sun_jnu_encoding;
-    char *sun_stdout_encoding;
-    char *sun_stderr_encoding;
+    char *stdout_encoding;
+    char *stderr_encoding;
 
     char *unicode_encoding;     /* The default endianness of unicode
                                     i.e. UnicodeBig or UnicodeLittle   */