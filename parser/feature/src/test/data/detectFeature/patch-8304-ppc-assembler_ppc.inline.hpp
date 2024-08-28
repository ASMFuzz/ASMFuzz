@@ -128,6 +128,8 @@ inline void Assembler::divd(   Register d, Register a, Register b) { emit_int32(
 inline void Assembler::divd_(  Register d, Register a, Register b) { emit_int32(DIVD_OPCODE   | rt(d) | ra(a) | rb(b) | oe(0) | rc(1)); }
 inline void Assembler::divw(   Register d, Register a, Register b) { emit_int32(DIVW_OPCODE   | rt(d) | ra(a) | rb(b) | oe(0) | rc(0)); }
 inline void Assembler::divw_(  Register d, Register a, Register b) { emit_int32(DIVW_OPCODE   | rt(d) | ra(a) | rb(b) | oe(0) | rc(1)); }
+inline void Assembler::divdu(  Register d, Register a, Register b) { emit_int32(DIVDU_OPCODE  | rt(d) | ra(a) | rb(b) | oe(0) | rc(0)); }
+inline void Assembler::divdu_( Register d, Register a, Register b) { emit_int32(DIVDU_OPCODE  | rt(d) | ra(a) | rb(b) | oe(0) | rc(1)); }
 inline void Assembler::divwu(  Register d, Register a, Register b) { emit_int32(DIVWU_OPCODE  | rt(d) | ra(a) | rb(b) | oe(0) | rc(0)); }
 inline void Assembler::divwu_( Register d, Register a, Register b) { emit_int32(DIVWU_OPCODE  | rt(d) | ra(a) | rb(b) | oe(0) | rc(1)); }
 