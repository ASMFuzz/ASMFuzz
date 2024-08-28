@@ -2333,7 +2333,7 @@ static void ASHRByteMaxVectorTestsMasked(IntFunction<byte[]> fa, IntFunction<byt
 
 
     static byte LSHR(byte a, byte b) {
-        return (byte)(((a & 0xFF) >>> (b & 0x7)));
+        return (byte)((a >>> (b & 0x7)));
     }
 
     @Test(dataProvider = "byteBinaryOpProvider")
@@ -2427,7 +2427,7 @@ static void LSHLByteMaxVectorTestsScalarShiftMasked(IntFunction<byte[]> fa, IntF
 
 
     static byte LSHR_unary(byte a, byte b) {
-        return (byte)(((a & 0xFF) >>> (b & 7)));
+        return (byte)((a >>> (b & 7)));
     }
 
     @Test(dataProvider = "byteBinaryOpProvider")
@@ -2691,7 +2691,7 @@ static void ROLByteMaxVectorTestsScalarShiftMasked(IntFunction<byte[]> fa, IntFu
 
 
     static byte LSHR_binary_const(byte a) {
-        return (byte)(((a & 0xFF) >>> CONST_SHIFT));
+        return (byte)((a >>> CONST_SHIFT));
     }
 
     @Test(dataProvider = "byteUnaryOpProvider")