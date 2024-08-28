@@ -3809,6 +3809,19 @@ void sve_fcm(Condition cond, PRegister Pd, SIMD_RegVariant T,
     f(0b001100, 15, 10), rf(Zn, 5), rf(Zd, 0);
   }
 
+// SVE2 bitwise permute
+#define INSN(NAME, opc)                                                                  \
+  void NAME(FloatRegister Zd, SIMD_RegVariant T, FloatRegister Zn,  FloatRegister Zm) {  \
+    starti;                                                                              \
+    assert(T != Q, "invalid size");                                                      \
+    f(0b01000101, 31, 24), f(T, 23, 22), f(0b0, 21);                                     \
+    rf(Zm, 16), f(0b1011, 15, 12), f(opc, 11, 10);                                       \
+    rf(Zn, 5), rf(Zd, 0);                                                                \
+  }
+
+  INSN(sve_bext, 0b00);
+#undef INSN
+
   Assembler(CodeBuffer* code) : AbstractAssembler(code) {
   }
 