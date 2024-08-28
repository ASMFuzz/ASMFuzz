@@ -1267,3 +1267,74 @@ void C2_MacroAssembler::sve_ptrue_lanecnt(PRegister dst, SIMD_RegVariant size, i
       ShouldNotReachHere();
   }
 }
+
+// java.lang.Math::round intrinsics
+
+void C2_MacroAssembler::vector_round_neon(FloatRegister dst, FloatRegister src, FloatRegister tmp1,
+                                       FloatRegister tmp2, FloatRegister tmp3, SIMD_Arrangement T) {
+  assert_different_registers(tmp1, tmp2, tmp3, src, dst);
+  switch (T) {
+    case T2S:
+    case T4S:
+      fmovs(tmp1, T, 0.5f);
+      mov(rscratch1, jint_cast(0x1.0p23f));
+      break;
+    case T2D:
+      fmovd(tmp1, T, 0.5);
+      mov(rscratch1, julong_cast(0x1.0p52));
+      break;
+    default:
+      assert(T == T2S || T == T4S || T == T2D, "invalid arrangement");
+  }
+  fadd(tmp1, T, tmp1, src);
+  fcvtms(tmp1, T, tmp1);
+  // tmp1 = floor(src + 0.5, ties to even)
+
+  fcvtas(dst, T, src);
+  // dst = round(src), ties to away
+
+  fneg(tmp3, T, src);
+  dup(tmp2, T, rscratch1);
+  cmhs(tmp3, T, tmp3, tmp2);
+  // tmp3 is now a set of flags
+
+  bif(dst, T16B, tmp1, tmp3);
+  // result in dst
+}
+
+void C2_MacroAssembler::vector_round_sve(FloatRegister dst, FloatRegister src, FloatRegister tmp1,
+                                      FloatRegister tmp2, PRegister ptmp, SIMD_RegVariant T) {
+  assert_different_registers(tmp1, tmp2, src, dst);
+
+  switch (T) {
+    case S:
+      mov(rscratch1, jint_cast(0x1.0p23f));
+      break;
+    case D:
+      mov(rscratch1, julong_cast(0x1.0p52));
+      break;
+    default:
+      assert(T == S || T == D, "invalid arrangement");
+  }
+
+  sve_frinta(dst, T, ptrue, src);
+  // dst = round(src), ties to away
+
+  Label none;
+
+  sve_fneg(tmp1, T, ptrue, src);
+  sve_dup(tmp2, T, rscratch1);
+  sve_cmp(HS, ptmp, T, ptrue, tmp2, tmp1);
+  br(EQ, none);
+  {
+    sve_cpy(tmp1, T, ptmp, 0.5);
+    sve_fadd(tmp1, T, ptmp, src);
+    sve_frintm(dst, T, ptmp, tmp1);
+    // dst = floor(src + 0.5, ties to even)
+  }
+  bind(none);
+
+  sve_fcvtzs(dst, T, ptrue, dst, T);
+  // result in dst
+}
+