@@ -420,8 +420,8 @@ protected void decode(long[] v, byte[] dst, int offset, int length) {
                 int bitsAdded = bitsPerLimb - bitPos;
                 int bitsLeft = 8 - bitsAdded;
 
-                dst[dstIndex] += (curLimbValue & (0xFF >> bitsAdded))
-                    << bitsAdded;
+                dst[dstIndex] += (byte) ((curLimbValue & (0xFF >> bitsAdded))
+                    << bitsAdded);
                 curLimbValue >>= bitsLeft;
                 bitPos = bitsLeft;
             } else {