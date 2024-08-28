@@ -103,4 +103,12 @@
     sve_lastb(dst, size, pg, src);
   }
 
+  // java.lang.Math::round intrinsics
+  void vector_round_neon(FloatRegister dst, FloatRegister src, FloatRegister tmp1,
+                         FloatRegister tmp2, FloatRegister tmp3,
+                         SIMD_Arrangement T);
+  void vector_round_sve(FloatRegister dst, FloatRegister src, FloatRegister tmp1,
+                        FloatRegister tmp2, PRegister ptmp,
+                        SIMD_RegVariant T);
+
 #endif // CPU_AARCH64_C2_MACROASSEMBLER_AARCH64_HPP