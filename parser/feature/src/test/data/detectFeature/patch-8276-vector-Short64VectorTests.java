@@ -2320,7 +2320,7 @@ static void ASHRShort64VectorTestsMasked(IntFunction<short[]> fa, IntFunction<sh
 
 
     static short LSHR(short a, short b) {
-        return (short)(((a & 0xFFFF) >>> (b & 0xF)));
+        return (short)((a >>> (b & 0xF)));
     }
 
     @Test(dataProvider = "shortBinaryOpProvider")
@@ -2414,7 +2414,7 @@ static void LSHLShort64VectorTestsScalarShiftMasked(IntFunction<short[]> fa, Int
 
 
     static short LSHR_unary(short a, short b) {
-        return (short)(((a & 0xFFFF) >>> (b & 15)));
+        return (short)((a >>> (b & 15)));
     }
 
     @Test(dataProvider = "shortBinaryOpProvider")
@@ -2678,7 +2678,7 @@ static void ROLShort64VectorTestsScalarShiftMasked(IntFunction<short[]> fa, IntF
 
 
     static short LSHR_binary_const(short a) {
-        return (short)(((a & 0xFFFF) >>> CONST_SHIFT));
+        return (short)((a >>> CONST_SHIFT));
     }
 
     @Test(dataProvider = "shortUnaryOpProvider")