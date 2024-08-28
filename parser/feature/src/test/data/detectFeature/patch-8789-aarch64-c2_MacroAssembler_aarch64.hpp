@@ -64,6 +64,11 @@
   void sve_vmask_tolong(Register dst, PRegister src, BasicType bt, int lane_cnt,
                         FloatRegister vtmp1, FloatRegister vtmp2);
 
+  // Unpack the mask, a long value in src, into predicate register dst based on the
+  // corresponding data type. Note that dst can support at most 64 lanes.
+  void sve_vmask_fromlong(PRegister dst, Register src, BasicType bt, int lane_cnt,
+                          FloatRegister vtmp1, FloatRegister vtmp2);
+
   // SIMD&FP comparison
   void neon_compare(FloatRegister dst, BasicType bt, FloatRegister src1,
                     FloatRegister src2, int cond, bool isQ);