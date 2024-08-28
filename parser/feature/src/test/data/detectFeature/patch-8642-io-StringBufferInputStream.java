@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -145,7 +145,7 @@ public synchronized long skip(long n) {
         if (n > count - pos) {
             n = count - pos;
         }
-        pos += n;
+        pos += (int) n;
         return n;
     }
 