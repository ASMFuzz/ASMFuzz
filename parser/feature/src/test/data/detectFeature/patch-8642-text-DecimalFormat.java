@@ -1532,7 +1532,7 @@ private void localizeDigits(char[] digitsBuffer) {
              cursor--) {
             if (digitsCounter != 0) {
                 // This is a digit char, we must localize it.
-                digitsBuffer[cursor] += fastPathData.zeroDelta;
+                digitsBuffer[cursor] += (char)fastPathData.zeroDelta;
                 digitsCounter--;
             } else {
                 // Decimal separator or grouping char. Reinit counter only.