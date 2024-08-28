@@ -5183,6 +5183,56 @@ void MacroAssembler::char_array_compress(Register src, Register dst, Register le
   csel(res, res, zr, EQ);
 }
 
+// java.math.round(double a)
+// Returns the closest long to the argument, with ties rounding to
+// positive infinity.  This requires some fiddling for corner
+// cases. We take care to avoid double rounding in e.g. (jlong)(a + 0.5).
+void MacroAssembler::java_round_double(Register dst, FloatRegister src,
+                                       FloatRegister ftmp) {
+  Label DONE;
+  BLOCK_COMMENT("java_round_double: { ");
+  fmovd(rscratch1, src);
+  // Use RoundToNearestTiesAway unless src small and -ve.
+  fcvtasd(dst, src);
+  // Test if src >= 0 || abs(src) >= 0x1.0p52
+  eor(rscratch1, rscratch1, UCONST64(1) << 63); // flip sign bit
+  mov(rscratch2, julong_cast(0x1.0p52));
+  cmp(rscratch1, rscratch2);
+  br(HS, DONE); {
+    // src < 0 && abs(src) < 0x1.0p52
+    // src may have a fractional part, so add 0.5
+    fmovd(ftmp, 0.5);
+    faddd(ftmp, src, ftmp);
+    // Convert double to jlong, use RoundTowardsNegative
+    fcvtmsd(dst, ftmp);
+  }
+  bind(DONE);
+  BLOCK_COMMENT("} java_round_double");
+}
+
+void MacroAssembler::java_round_float(Register dst, FloatRegister src,
+                                      FloatRegister ftmp) {
+  Label DONE;
+  BLOCK_COMMENT("java_round_float: { ");
+  fmovs(rscratch1, src);
+  // Use RoundToNearestTiesAway unless src small and -ve.
+  fcvtassw(dst, src);
+  // Test if src >= 0 || abs(src) >= 0x1.0p23
+  eor(rscratch1, rscratch1, 0x80000000); // flip sign bit
+  mov(rscratch2, jint_cast(0x1.0p23f));
+  cmp(rscratch1, rscratch2);
+  br(HS, DONE); {
+    // src < 0 && |src| < 0x1.0p23
+    // src may have a fractional part, so add 0.5
+    fmovs(ftmp, 0.5f);
+    fadds(ftmp, src, ftmp);
+    // Convert float to jint, use RoundTowardsNegative
+    fcvtmssw(dst, ftmp);
+  }
+  bind(DONE);
+  BLOCK_COMMENT("} java_round_float");
+}
+
 // get_thread() can be called anywhere inside generated code so we
 // need to save whatever non-callee save context might get clobbered
 // by the call to JavaThread::aarch64_get_thread_helper() or, indeed,