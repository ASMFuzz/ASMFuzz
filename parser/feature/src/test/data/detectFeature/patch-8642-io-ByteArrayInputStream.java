@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -228,7 +228,7 @@ public synchronized long skip(long n) {
             k = n < 0 ? 0 : n;
         }
 
-        pos += k;
+        pos += (int) k;
         return k;
     }
 