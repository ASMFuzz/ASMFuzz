@@ -127,10 +127,7 @@ protected List<String> getValidValues() {
             validValues.add(formatValue(min));
         }
         if (testMaxRange) {
-            if (!name.equals("CompileThresholdScaling")) {
-                // See JDK-8283807: Max range for -XX:CompileThresholdScaling is too large
-                validValues.add(formatValue(max));
-            }
+            validValues.add(formatValue(max));
         }
 
         if (testMinRange) {