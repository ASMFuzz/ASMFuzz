@@ -2328,7 +2328,7 @@ static void ASHRByte256VectorTestsMasked(IntFunction<byte[]> fa, IntFunction<byt
 
 
     static byte LSHR(byte a, byte b) {
-        return (byte)(((a & 0xFF) >>> (b & 0x7)));
+        return (byte)((a >>> (b & 0x7)));
     }
 
     @Test(dataProvider = "byteBinaryOpProvider")
@@ -2422,7 +2422,7 @@ static void LSHLByte256VectorTestsScalarShiftMasked(IntFunction<byte[]> fa, IntF
 
 
     static byte LSHR_unary(byte a, byte b) {
-        return (byte)(((a & 0xFF) >>> (b & 7)));
+        return (byte)((a >>> (b & 7)));
     }
 
     @Test(dataProvider = "byteBinaryOpProvider")
@@ -2686,7 +2686,7 @@ static void ROLByte256VectorTestsScalarShiftMasked(IntFunction<byte[]> fa, IntFu
 
 
     static byte LSHR_binary_const(byte a) {
-        return (byte)(((a & 0xFF) >>> CONST_SHIFT));
+        return (byte)((a >>> CONST_SHIFT));
     }
 
     @Test(dataProvider = "byteUnaryOpProvider")