@@ -91,7 +91,7 @@ define_pd_global(intx, InlineSmallCode,          1000);
   product(bool, UseSIMDForArrayEquals, true,                            \
           "Use SIMD instructions in generated array equals code")       \
   product(bool, UseSimpleArrayEquals, false,                            \
-          "Use simpliest and shortest implementation for array equals") \
+          "Use simplest and shortest implementation for array equals")  \
   product(bool, UseSIMDForBigIntegerShiftIntrinsics, true,              \
           "Use SIMD instructions for left/right shift of BigInteger")   \
   product(bool, AvoidUnalignedAccesses, false,                          \