@@ -363,9 +363,14 @@ public static LocalDate ofEpochDay(long epochDay) {
 
         // convert march-based values back to january-based
         int marchMonth0 = (marchDoy0 * 5 + 2) / 153;
-        int month = (marchMonth0 + 2) % 12 + 1;
+        int month = marchMonth0 + 3;
+        if (month > 12) {
+            month -= 12;
+        }
         int dom = marchDoy0 - (marchMonth0 * 306 + 5) / 10 + 1;
-        yearEst += marchMonth0 / 10;
+        if (marchDoy0 >= 306) {
+            yearEst++;
+        }
 
         return new LocalDate((int)yearEst, month, dom);
     }