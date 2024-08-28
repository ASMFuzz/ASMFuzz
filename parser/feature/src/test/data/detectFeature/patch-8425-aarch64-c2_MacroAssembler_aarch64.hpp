@@ -105,4 +105,20 @@
                         FloatRegister tmp2, PRegister ptmp,
                         SIMD_RegVariant T);
 
+  // Pack active elements of src, under the control of mask, into the
+  // lowest-numbered elements of dst. Any remaining elements of dst will
+  // be filled with zero.
+  void sve_compress_byte(FloatRegister dst, FloatRegister src, PRegister mask,
+                         FloatRegister vtmp1, FloatRegister vtmp2,
+                         FloatRegister vtmp3, FloatRegister vtmp4,
+                         PRegister ptmp, PRegister pgtmp);
+
+  void sve_compress_short(FloatRegister dst, FloatRegister src, PRegister mask,
+                          FloatRegister vtmp1, FloatRegister vtmp2,
+                          PRegister pgtmp);
+
+  void neon_reverse_bits(FloatRegister dst, FloatRegister src, BasicType bt, bool isQ);
+
+  void neon_reverse_bytes(FloatRegister dst, FloatRegister src, BasicType bt, bool isQ);
+
 #endif // CPU_AARCH64_C2_MACROASSEMBLER_AARCH64_HPP