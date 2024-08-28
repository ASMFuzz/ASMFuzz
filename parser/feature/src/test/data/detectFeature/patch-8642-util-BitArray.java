@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -142,9 +142,9 @@ public void set(int index, boolean value)
         int bit = position(index);
 
         if (value) {
-            repn[idx] |= bit;
+            repn[idx] |= (byte) bit;
         } else {
-            repn[idx] &= ~bit;
+            repn[idx] &= (byte) ~bit;
         }
     }
 