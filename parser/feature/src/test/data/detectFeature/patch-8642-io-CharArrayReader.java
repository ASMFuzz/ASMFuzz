@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -196,7 +196,7 @@ public long skip(long n) throws IOException {
             if (n < 0) {
                 return 0;
             }
-            pos += n;
+            pos += (int) n;
             return n;
         }
     }