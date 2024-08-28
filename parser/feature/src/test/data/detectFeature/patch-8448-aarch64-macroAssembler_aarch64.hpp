@@ -212,7 +212,7 @@ class MacroAssembler: public Assembler {
 
   inline void movw(Register Rd, Register Rn) {
     if (Rd == sp || Rn == sp) {
-      addw(Rd, Rn, 0U);
+      Assembler::addw(Rd, Rn, 0U);
     } else {
       orrw(Rd, zr, Rn);
     }
@@ -221,7 +221,7 @@ class MacroAssembler: public Assembler {
     assert(Rd != r31_sp && Rn != r31_sp, "should be");
     if (Rd == Rn) {
     } else if (Rd == sp || Rn == sp) {
-      add(Rd, Rn, 0U);
+      Assembler::add(Rd, Rn, 0U);
     } else {
       orr(Rd, zr, Rn);
     }
@@ -1144,16 +1144,16 @@ class MacroAssembler: public Assembler {
 
   // If a constant does not fit in an immediate field, generate some
   // number of MOV instructions and then perform the operation
-  void wrap_add_sub_imm_insn(Register Rd, Register Rn, unsigned imm,
+  void wrap_add_sub_imm_insn(Register Rd, Register Rn, uint64_t imm,
                              add_sub_imm_insn insn1,
                              add_sub_reg_insn insn2);
   // Separate vsn which sets the flags
-  void wrap_adds_subs_imm_insn(Register Rd, Register Rn, unsigned imm,
+  void wrap_adds_subs_imm_insn(Register Rd, Register Rn, uint64_t imm,
                              add_sub_imm_insn insn1,
                              add_sub_reg_insn insn2);
 
 #define WRAP(INSN)                                                      \
-  void INSN(Register Rd, Register Rn, unsigned imm) {                   \
+  void INSN(Register Rd, Register Rn, uint64_t imm) {                   \
     wrap_add_sub_imm_insn(Rd, Rn, imm, &Assembler::INSN, &Assembler::INSN); \
   }                                                                     \
                                                                         \
@@ -1175,7 +1175,7 @@ class MacroAssembler: public Assembler {
 
 #undef WRAP
 #define WRAP(INSN)                                                      \
-  void INSN(Register Rd, Register Rn, unsigned imm) {                   \
+  void INSN(Register Rd, Register Rn, uint64_t imm) {                   \
     wrap_adds_subs_imm_insn(Rd, Rn, imm, &Assembler::INSN, &Assembler::INSN); \
   }                                                                     \
                                                                         \