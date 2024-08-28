@@ -1607,11 +1607,11 @@ private int computeFields(int fieldMask, int tzMask) {
         fixedDate += time / ONE_DAY;
         timeOfDay += (int) (time % ONE_DAY);
         if (timeOfDay >= ONE_DAY) {
-            timeOfDay -= ONE_DAY;
+            timeOfDay -= (int) ONE_DAY;
             ++fixedDate;
         } else {
             while (timeOfDay < 0) {
-                timeOfDay += ONE_DAY;
+                timeOfDay += (int) ONE_DAY;
                 --fixedDate;
             }
         }