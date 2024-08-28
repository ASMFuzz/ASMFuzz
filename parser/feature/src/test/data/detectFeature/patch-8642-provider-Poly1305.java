@@ -246,9 +246,9 @@ private void setRSVals() {
         keyBytes[7] &= 15;
         keyBytes[11] &= 15;
         keyBytes[15] &= 15;
-        keyBytes[4] &= 252;
-        keyBytes[8] &= 252;
-        keyBytes[12] &= 252;
+        keyBytes[4] &= (byte)252;
+        keyBytes[8] &= (byte)252;
+        keyBytes[12] &= (byte)252;
 
         // Create IntegerModuloP elements from the r and s values
         r = ipl1305.getElement(keyBytes, 0, RS_LENGTH, (byte)0);