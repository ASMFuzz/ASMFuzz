@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -224,7 +224,7 @@ public boolean equals(Object obj) {
             if (objBytes.length != other.objBytes.length)
                 return false;
 
-            //!! There is talk about adding an array comparision method
+            //!! There is talk about adding an array comparison method
             //!! at 1.2 -- if so, this should be rewritten.  -arnold
             for (int i = 0; i < objBytes.length; ++i) {
                 if (objBytes[i] != other.objBytes[i])