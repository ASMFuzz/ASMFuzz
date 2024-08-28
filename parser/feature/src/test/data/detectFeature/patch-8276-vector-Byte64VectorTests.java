@@ -2328,7 +2328,7 @@ static void ASHRByte64VectorTestsMasked(IntFunction<byte[]> fa, IntFunction<byte
 
 
     static byte LSHR(byte a, byte b) {
-        return (byte)(((a & 0xFF) >>> (b & 0x7)));
+        return (byte)((a >>> (b & 0x7)));
     }
 
     @Test(dataProvider = "byteBinaryOpProvider")
@@ -2422,7 +2422,7 @@ static void LSHLByte64VectorTestsScalarShiftMasked(IntFunction<byte[]> fa, IntFu
 
 
     static byte LSHR_unary(byte a, byte b) {
-        return (byte)(((a & 0xFF) >>> (b & 7)));
+        return (byte)((a >>> (b & 7)));
     }
 
     @Test(dataProvider = "byteBinaryOpProvider")
@@ -2686,7 +2686,7 @@ static void ROLByte64VectorTestsScalarShiftMasked(IntFunction<byte[]> fa, IntFun
 
 
     static byte LSHR_binary_const(byte a) {
-        return (byte)(((a & 0xFF) >>> CONST_SHIFT));
+        return (byte)((a >>> CONST_SHIFT));
     }
 
     @Test(dataProvider = "byteUnaryOpProvider")