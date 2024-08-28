@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -2323,11 +2323,11 @@ private int computeFields(int fieldMask, int tzMask) {
         fixedDate += time / ONE_DAY;
         timeOfDay += (int) (time % ONE_DAY);
         if (timeOfDay >= ONE_DAY) {
-            timeOfDay -= ONE_DAY;
+            timeOfDay -= (int)ONE_DAY;
             ++fixedDate;
         } else {
             while (timeOfDay < 0) {
-                timeOfDay += ONE_DAY;
+                timeOfDay += (int)ONE_DAY;
                 --fixedDate;
             }
         }