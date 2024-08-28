@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -398,9 +398,6 @@ public static boolean regionMatchesCI(byte[] value, int toffset,
             if (u1 == u2) {
                 continue;
             }
-            if (Character.toLowerCase(u1) == Character.toLowerCase(u2)) {
-                continue;
-            }
             return false;
         }
         return true;