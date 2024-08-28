@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -579,7 +579,7 @@ public int read(char[] cbuf, int offset, int length)
         if (istty) {
             String csname = encoding();
             if (csname == null) {
-                csname = GetPropertyAction.privilegedGetProperty("sun.stdout.encoding");
+                csname = GetPropertyAction.privilegedGetProperty("stdout.encoding");
             }
             if (csname != null) {
                 cs = Charset.forName(csname, null);