@@ -720,7 +720,7 @@ private static byte[] randomBits(int numBits, Random rnd) {
         if (numBytes > 0) {
             rnd.nextBytes(randomBits);
             int excessBits = 8*numBytes - numBits;
-            randomBits[0] &= (1 << (8-excessBits)) - 1;
+            randomBits[0] &= (byte)((1 << (8-excessBits)) - 1);
         }
         return randomBits;
     }
@@ -3389,7 +3389,7 @@ private BigInteger mod2(int p) {
 
         // Mask out any excess bits
         int excessBits = (numInts << 5) - p;
-        mag[0] &= (1L << (32-excessBits)) - 1;
+        mag[0] &= (int)((1L << (32-excessBits)) - 1);
 
         return (mag[0] == 0 ? new BigInteger(1, mag) : new BigInteger(mag, 1));
     }