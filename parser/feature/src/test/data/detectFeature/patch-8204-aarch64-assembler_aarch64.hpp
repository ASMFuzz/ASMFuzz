@@ -306,14 +306,6 @@ class Instruction_aarch64 {
     assert_cond((bits & mask) == mask);
     return (insn & mask) >> lsb;
   }
-
-  void fixed(unsigned value, unsigned mask) {
-    assert_cond ((mask & bits) == 0);
-#ifdef ASSERT
-    bits |= mask;
-#endif
-    insn |= value;
-  }
 };
 
 #define starti Instruction_aarch64 current_insn(this);
@@ -698,7 +690,6 @@ class Assembler : public AbstractAssembler {
 #define zrf current_insn.zrf
 #define prf current_insn.prf
 #define pgrf current_insn.pgrf
-#define fixed current_insn.fixed
 
   typedef void (Assembler::* uncond_branch_insn)(address dest);
   typedef void (Assembler::* compare_and_branch_insn)(Register Rt, address dest);
@@ -1085,7 +1076,7 @@ class Assembler : public AbstractAssembler {
 
   // A more convenient access to dmb for our purposes
   enum Membar_mask_bits {
-    // We can use ISH for a barrier because the ARM ARM says "This
+    // We can use ISH for a barrier because the Arm ARM says "This
     // architecture assumes that all Processing Elements that use the
     // same operating system or hypervisor are in the same Inner
     // Shareable shareability domain."
@@ -2082,46 +2073,55 @@ void mvnw(Register Rd, Register Rm,
 #undef INSN
 
    // Floating-point<->integer conversions
-  void float_int_convert(unsigned op31, unsigned type,
+  void float_int_convert(unsigned sflag, unsigned ftype,
                          unsigned rmode, unsigned opcode,
                          Register Rd, Register Rn) {
     starti;
-    f(op31, 31, 29);
+    f(sflag, 31);
+    f(0b00, 30, 29);
     f(0b11110, 28, 24);
-    f(type, 23, 22), f(1, 21), f(rmode, 20, 19);
+    f(ftype, 23, 22), f(1, 21), f(rmode, 20, 19);
     f(opcode, 18, 16), f(0b000000, 15, 10);
     zrf(Rn, 5), zrf(Rd, 0);
   }
 
-#define INSN(NAME, op31, type, rmode, opcode)                           \
-  void NAME(Register Rd, FloatRegister Vn) {                            \
-    float_int_convert(op31, type, rmode, opcode, Rd, as_Register(Vn));  \
+#define INSN(NAME, sflag, ftype, rmode, opcode)                          \
+  void NAME(Register Rd, FloatRegister Vn) {                             \
+    float_int_convert(sflag, ftype, rmode, opcode, Rd, as_Register(Vn)); \
   }
 
-  INSN(fcvtzsw, 0b000, 0b00, 0b11, 0b000);
-  INSN(fcvtzs,  0b100, 0b00, 0b11, 0b000);
-  INSN(fcvtzdw, 0b000, 0b01, 0b11, 0b000);
-  INSN(fcvtzd,  0b100, 0b01, 0b11, 0b000);
+  INSN(fcvtzsw, 0b0, 0b00, 0b11, 0b000);
+  INSN(fcvtzs,  0b1, 0b00, 0b11, 0b000);
+  INSN(fcvtzdw, 0b0, 0b01, 0b11, 0b000);
+  INSN(fcvtzd,  0b1, 0b01, 0b11, 0b000);
+
+  // RoundToNearestTiesAway
+  INSN(fcvtassw, 0b0, 0b00, 0b00, 0b100);  // float -> signed word
+  INSN(fcvtasd,  0b1, 0b01, 0b00, 0b100);  // double -> signed xword
 
-  INSN(fmovs, 0b000, 0b00, 0b00, 0b110);
-  INSN(fmovd, 0b100, 0b01, 0b00, 0b110);
+  // RoundTowardsNegative
+  INSN(fcvtmssw, 0b0, 0b00, 0b10, 0b000);  // float -> signed word
+  INSN(fcvtmsd,  0b1, 0b01, 0b10, 0b000);  // double -> signed xword
 
-  INSN(fmovhid, 0b100, 0b10, 0b01, 0b110);
+  INSN(fmovs, 0b0, 0b00, 0b00, 0b110);
+  INSN(fmovd, 0b1, 0b01, 0b00, 0b110);
+
+  INSN(fmovhid, 0b1, 0b10, 0b01, 0b110);
 
 #undef INSN
 
-#define INSN(NAME, op31, type, rmode, opcode)                           \
+#define INSN(NAME, sflag, type, rmode, opcode)                           \
   void NAME(FloatRegister Vd, Register Rn) {                            \
-    float_int_convert(op31, type, rmode, opcode, as_Register(Vd), Rn);  \
+    float_int_convert(sflag, type, rmode, opcode, as_Register(Vd), Rn);  \
   }
 
-  INSN(fmovs, 0b000, 0b00, 0b00, 0b111);
-  INSN(fmovd, 0b100, 0b01, 0b00, 0b111);
+  INSN(fmovs, 0b0, 0b00, 0b00, 0b111);
+  INSN(fmovd, 0b1, 0b01, 0b00, 0b111);
 
-  INSN(scvtfws, 0b000, 0b00, 0b00, 0b010);
-  INSN(scvtfs,  0b100, 0b00, 0b00, 0b010);
-  INSN(scvtfwd, 0b000, 0b01, 0b00, 0b010);
-  INSN(scvtfd,  0b100, 0b01, 0b00, 0b010);
+  INSN(scvtfws, 0b0, 0b00, 0b00, 0b010);
+  INSN(scvtfs,  0b1, 0b00, 0b00, 0b010);
+  INSN(scvtfwd, 0b0, 0b01, 0b00, 0b010);
+  INSN(scvtfd,  0b1, 0b01, 0b00, 0b010);
 
   // INSN(fmovhid, 0b100, 0b10, 0b01, 0b111);
 
@@ -2510,6 +2510,7 @@ void mvnw(Register Rd, Register Rm,
 
 #undef INSN
 
+// Advanced SIMD modified immediate
 #define INSN(NAME, op0, cmode0) \
   void NAME(FloatRegister Vd, SIMD_Arrangement T, unsigned imm8, unsigned lsl = 0) {   \
     unsigned cmode = cmode0;                                                           \
@@ -2537,7 +2538,22 @@ void mvnw(Register Rd, Register Rm,
 
 #undef INSN
 
-#define INSN(NAME, op1, op2, op3) \
+#define INSN(NAME, op, cmode)                                           \
+  void NAME(FloatRegister Vd, SIMD_Arrangement T, double imm) {         \
+    unsigned imm8 = pack(imm);                                          \
+    starti;                                                             \
+    f(0, 31), f((int)T & 1, 30), f(op, 29), f(0b0111100000, 28, 19);    \
+    f(imm8 >> 5, 18, 16), f(cmode, 15, 12), f(0x01, 11, 10), f(imm8 & 0b11111, 9, 5); \
+    rf(Vd, 0);                                                          \
+  }
+
+  INSN(fmovs, 0, 0b1111);
+  INSN(fmovd, 1, 0b1111);
+
+#undef INSN
+
+// Advanced SIMD three same
+#define INSN(NAME, op1, op2, op3)                                                       \
   void NAME(FloatRegister Vd, SIMD_Arrangement T, FloatRegister Vn, FloatRegister Vm) { \
     starti;                                                                             \
     assert(T == T2S || T == T4S || T == T2D, "invalid arrangement");                    \
@@ -2984,7 +3000,9 @@ void mvnw(Register Rd, Register Rm,
   INSN(frintn, 0, 0b00, 0b01, 0b11000);
   INSN(frintm, 0, 0b00, 0b01, 0b11001);
   INSN(frintp, 0, 0b10, 0b01, 0b11000);
+  INSN(fcvtas, 0, 0b00, 0b01, 0b11100);
   INSN(fcvtzs, 0, 0b10, 0b01, 0b11011);
+  INSN(fcvtms, 0, 0b00, 0b01, 0b11011);
 #undef ASSERTION
 
 #define ASSERTION (T == T8B || T == T16B || T == T4H || T == T8H || T == T2S || T == T4S)
@@ -3154,6 +3172,7 @@ void mvnw(Register Rd, Register Rm,
   INSN(sve_fneg,    0b00000100, 0b011101101);
   INSN(sve_frintm,  0b01100101, 0b000010101); // floating-point round to integral value, toward minus infinity
   INSN(sve_frintn,  0b01100101, 0b000000101); // floating-point round to integral value, nearest with ties to even
+  INSN(sve_frinta,  0b01100101, 0b000100101); // floating-point round to integral value, nearest with ties to away
   INSN(sve_frintp,  0b01100101, 0b000001101); // floating-point round to integral value, toward plus infinity
   INSN(sve_fsqrt,   0b01100101, 0b001101101);
   INSN(sve_fsub,    0b01100101, 0b000001100);
@@ -3449,8 +3468,9 @@ void mvnw(Register Rd, Register Rm,
     pgrf(Pg, 10), srf(Rn, 5), rf(Zd, 0);
   }
 
-  // SVE copy signed integer immediate to vector elements (predicated)
-  void sve_cpy(FloatRegister Zd, SIMD_RegVariant T, PRegister Pg, int imm8, bool isMerge) {
+private:
+  void sve_cpy(FloatRegister Zd, SIMD_RegVariant T, PRegister Pg, int imm8,
+               bool isMerge, bool isFloat) {
     starti;
     assert(T != Q, "invalid size");
     int sh = 0;
@@ -3464,7 +3484,17 @@ void mvnw(Register Rd, Register Rm,
     }
     int m = isMerge ? 1 : 0;
     f(0b00000101, 31, 24), f(T, 23, 22), f(0b01, 21, 20);
-    prf(Pg, 16), f(0b0, 15), f(m, 14), f(sh, 13), sf(imm8, 12, 5), rf(Zd, 0);
+    prf(Pg, 16), f(isFloat ? 1 : 0, 15), f(m, 14), f(sh, 13), sf(imm8, 12, 5), rf(Zd, 0);
+  }
+
+public:
+  // SVE copy signed integer immediate to vector elements (predicated)
+  void sve_cpy(FloatRegister Zd, SIMD_RegVariant T, PRegister Pg, int imm8, bool isMerge) {
+    sve_cpy(Zd, T, Pg, imm8, isMerge, /*isFloat*/false);
+  }
+  // SVE copy floating-point immediate to vector elements (predicated)
+  void sve_cpy(FloatRegister Zd, SIMD_RegVariant T, PRegister Pg, double d) {
+    sve_cpy(Zd, T, Pg, checked_cast<int8_t>(pack(d)), /*isMerge*/true, /*isFloat*/true);
   }
 
   // SVE conditionally select elements from two vectors
@@ -3528,6 +3558,29 @@ void sve_cmp(Condition cond, PRegister Pd, SIMD_RegVariant T,
   f(cond_op & 0x1, 4), prf(Pd, 0);
 }
 
+// SVE Floating-point compare vector with zero
+void sve_fcm(Condition cond, PRegister Pd, SIMD_RegVariant T,
+             PRegister Pg, FloatRegister Zn, double d) {
+  starti;
+  assert(T != Q, "invalid size");
+  guarantee(d == 0.0, "invalid immediate");
+  int cond_op;
+  switch(cond) {
+    case EQ: cond_op = 0b100; break;
+    case GT: cond_op = 0b001; break;
+    case GE: cond_op = 0b000; break;
+    case LT: cond_op = 0b010; break;
+    case LE: cond_op = 0b011; break;
+    case NE: cond_op = 0b110; break;
+    default:
+      ShouldNotReachHere();
+  }
+  f(0b01100101, 31, 24), f(T, 23, 22), f(0b0100, 21, 18),
+  f((cond_op >> 1) & 0x3, 17, 16), f(0b001, 15, 13),
+  pgrf(Pg, 10), rf(Zn, 5);
+  f(cond_op & 0x1, 4), prf(Pd, 0);
+}
+
 // SVE unpack vector elements
 #define INSN(NAME, op) \
   void NAME(FloatRegister Zd, SIMD_RegVariant T, FloatRegister Zn) { \