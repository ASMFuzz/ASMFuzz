@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -251,7 +251,7 @@ public long skip(long n) throws IOException {
             int avail = buf.length - pos;
             if (avail > 0) {
                 if (n <= avail) {
-                    pos += n;
+                    pos += (int)n;
                     return n;
                 } else {
                     pos = buf.length;