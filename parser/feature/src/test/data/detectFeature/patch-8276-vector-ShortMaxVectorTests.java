@@ -2325,7 +2325,7 @@ static void ASHRShortMaxVectorTestsMasked(IntFunction<short[]> fa, IntFunction<s
 
 
     static short LSHR(short a, short b) {
-        return (short)(((a & 0xFFFF) >>> (b & 0xF)));
+        return (short)((a >>> (b & 0xF)));
     }
 
     @Test(dataProvider = "shortBinaryOpProvider")
@@ -2419,7 +2419,7 @@ static void LSHLShortMaxVectorTestsScalarShiftMasked(IntFunction<short[]> fa, In
 
 
     static short LSHR_unary(short a, short b) {
-        return (short)(((a & 0xFFFF) >>> (b & 15)));
+        return (short)((a >>> (b & 15)));
     }
 
     @Test(dataProvider = "shortBinaryOpProvider")
@@ -2683,7 +2683,7 @@ static void ROLShortMaxVectorTestsScalarShiftMasked(IntFunction<short[]> fa, Int
 
 
     static short LSHR_binary_const(short a) {
-        return (short)(((a & 0xFFFF) >>> CONST_SHIFT));
+        return (short)((a >>> CONST_SHIFT));
     }
 
     @Test(dataProvider = "shortUnaryOpProvider")