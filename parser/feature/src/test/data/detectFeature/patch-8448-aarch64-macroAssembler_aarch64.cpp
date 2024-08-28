@@ -2192,35 +2192,35 @@ void MacroAssembler::unimplemented(const char* what) {
 
 // If a constant does not fit in an immediate field, generate some
 // number of MOV instructions and then perform the operation.
-void MacroAssembler::wrap_add_sub_imm_insn(Register Rd, Register Rn, unsigned imm,
+void MacroAssembler::wrap_add_sub_imm_insn(Register Rd, Register Rn, uint64_t imm,
                                            add_sub_imm_insn insn1,
                                            add_sub_reg_insn insn2) {
   assert(Rd != zr, "Rd = zr and not setting flags?");
-  if (operand_valid_for_add_sub_immediate((int)imm)) {
+  if (operand_valid_for_add_sub_immediate(imm)) {
     (this->*insn1)(Rd, Rn, imm);
   } else {
     if (uabs(imm) < (1 << 24)) {
        (this->*insn1)(Rd, Rn, imm & -(1 << 12));
        (this->*insn1)(Rd, Rd, imm & ((1 << 12)-1));
     } else {
        assert_different_registers(Rd, Rn);
-       mov(Rd, (uint64_t)imm);
+       mov(Rd, imm);
        (this->*insn2)(Rd, Rn, Rd, LSL, 0);
     }
   }
 }
 
 // Separate vsn which sets the flags. Optimisations are more restricted
 // because we must set the flags correctly.
-void MacroAssembler::wrap_adds_subs_imm_insn(Register Rd, Register Rn, unsigned imm,
+void MacroAssembler::wrap_adds_subs_imm_insn(Register Rd, Register Rn, uint64_t imm,
                                            add_sub_imm_insn insn1,
                                            add_sub_reg_insn insn2) {
-  if (operand_valid_for_add_sub_immediate((int)imm)) {
+  if (operand_valid_for_add_sub_immediate(imm)) {
     (this->*insn1)(Rd, Rn, imm);
   } else {
     assert_different_registers(Rd, Rn);
     assert(Rd != zr, "overflow in immediate operand");
-    mov(Rd, (uint64_t)imm);
+    mov(Rd, imm);
     (this->*insn2)(Rd, Rn, Rd, LSL, 0);
   }
 }