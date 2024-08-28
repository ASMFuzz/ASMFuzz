@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -1542,9 +1542,7 @@ public boolean equals(Object o) {
 
             try {
                 return containsAll(c);
-            } catch (ClassCastException unused)   {
-                return false;
-            } catch (NullPointerException unused) {
+            } catch (ClassCastException | NullPointerException unused) {
                 return false;
             }
         }