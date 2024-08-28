@@ -388,8 +388,51 @@ class Assembler : public AbstractAssembler {
     emit_int32((jint)insn);
   }
 
-  void _halt() {
-    emit_int32(0);
+  enum csr {
+    cycle = 0xc00,
+    time,
+    instret,
+    hpmcounter3,
+    hpmcounter4,
+    hpmcounter5,
+    hpmcounter6,
+    hpmcounter7,
+    hpmcounter8,
+    hpmcounter9,
+    hpmcounter10,
+    hpmcounter11,
+    hpmcounter12,
+    hpmcounter13,
+    hpmcounter14,
+    hpmcounter15,
+    hpmcounter16,
+    hpmcounter17,
+    hpmcounter18,
+    hpmcounter19,
+    hpmcounter20,
+    hpmcounter21,
+    hpmcounter22,
+    hpmcounter23,
+    hpmcounter24,
+    hpmcounter25,
+    hpmcounter26,
+    hpmcounter27,
+    hpmcounter28,
+    hpmcounter29,
+    hpmcounter30,
+    hpmcounter31 = 0xc1f
+  };
+
+  // Emit an illegal instruction that's known to trap, with 32 read-only CSR
+  // to choose as the input operand.
+  // According to the RISC-V Assembly Programmer's Manual, a de facto implementation
+  // of this instruction is the UNIMP pseduo-instruction, 'CSRRW x0, cycle, x0',
+  // attempting to write zero to a read-only CSR 'cycle' (0xC00).
+  // RISC-V ISAs provide a set of up to 32 read-only CSR registers 0xC00-0xC1F,
+  // and an attempt to write into any read-only CSR (whether it exists or not)
+  // will generate an illegal instruction exception.
+  void illegal_instruction(csr csr_reg) {
+    csrrw(x0, (unsigned)csr_reg, x0);
   }
 
 // Register Instruction
@@ -2854,20 +2897,6 @@ enum Nf {
 
 #undef INSN
 
-#define INSN(NAME)                                                      \
-  void NAME() {                                                         \
-    /* The illegal instruction in RVC is presented by a 16-bit 0. */    \
-    if (do_compress()) {                                                \
-      emit_int16(0);                                                    \
-      return;                                                           \
-    }                                                                   \
-    _halt();                                                            \
-  }
-
-  INSN(halt);
-
-#undef INSN
-
 // --------------------------
 // Immediate Instructions
 // --------------------------