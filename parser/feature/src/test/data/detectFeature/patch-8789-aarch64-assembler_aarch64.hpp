@@ -3861,6 +3861,7 @@ void sve_fcm(Condition cond, PRegister Pd, SIMD_RegVariant T,
   }
 
   INSN(sve_bext, 0b00);
+  INSN(sve_bdep, 0b01);
 #undef INSN
 
   Assembler(CodeBuffer* code) : AbstractAssembler(code) {