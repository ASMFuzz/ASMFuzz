@@ -3134,6 +3134,7 @@ void mvnw(Register Rd, Register Rm,
   INSN(sve_andv, 0b00000100, 0b011010001); // bitwise and reduction to scalar
   INSN(sve_asr,  0b00000100, 0b010000100); // vector arithmetic shift right
   INSN(sve_bic,  0b00000100, 0b011011000); // vector bitwise clear
+  INSN(sve_clz,  0b00000100, 0b011001101); // vector count leading zero bits
   INSN(sve_cnt,  0b00000100, 0b011010101); // count non-zero bits
   INSN(sve_cpy,  0b00000101, 0b100000100); // copy scalar to each active vector element
   INSN(sve_eor,  0b00000100, 0b011001000); // vector eor
@@ -3793,6 +3794,19 @@ void sve_fcm(Condition cond, PRegister Pd, SIMD_RegVariant T,
   INSN(sve_lastb, 0b1);
 #undef INSN
 
+// SVE reverse within elements
+#define INSN(NAME, opc, cond)                                                        \
+  void NAME(FloatRegister Zd, SIMD_RegVariant T, PRegister Pg,  FloatRegister Zn) {  \
+    starti;                                                                          \
+    assert(cond, "invalid size");                                                    \
+    f(0b00000101, 31, 24), f(T, 23, 22), f(0b1001, 21, 18), f(opc, 17, 16);          \
+    f(0b100, 15, 13), pgrf(Pg, 10), rf(Zn, 5), rf(Zd, 0);                            \
+  }
+
+  INSN(sve_revb, 0b00, T == H || T == S || T == D);
+  INSN(sve_rbit, 0b11, T != Q);
+#undef INSN
+
   // SVE Create index starting from general-purpose register and incremented by immediate
   void sve_index(FloatRegister Zd, SIMD_RegVariant T, Register Rn, int imm) {
     starti;
@@ -3819,6 +3833,23 @@ void sve_fcm(Condition cond, PRegister Pd, SIMD_RegVariant T,
     f(0b001100, 15, 10), rf(Zn, 5), rf(Zd, 0);
   }
 
+  // Shuffle active elements of vector to the right and fill with zero
+  void sve_compact(FloatRegister Zd, SIMD_RegVariant T, FloatRegister Zn, PRegister Pg) {
+    starti;
+    assert(T == S || T == D, "invalid size");
+    f(0b00000101, 31, 24), f(T, 23, 22), f(0b100001100, 21, 13);
+    pgrf(Pg, 10), rf(Zn, 5), rf(Zd, 0);
+  }
+
+  // SVE2 Count matching elements in vector
+  void sve_histcnt(FloatRegister Zd, SIMD_RegVariant T, PRegister Pg,
+                   FloatRegister Zn, FloatRegister Zm) {
+    starti;
+    assert(T == S || T == D, "invalid size");
+    f(0b01000101, 31, 24), f(T, 23, 22), f(0b1, 21), rf(Zm, 16);
+    f(0b110, 15, 13), pgrf(Pg, 10), rf(Zn, 5), rf(Zd, 0);
+  }
+
 // SVE2 bitwise permute
 #define INSN(NAME, opc)                                                                  \
   void NAME(FloatRegister Zd, SIMD_RegVariant T, FloatRegister Zn,  FloatRegister Zm) {  \