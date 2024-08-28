@@ -800,15 +800,6 @@ void MacroAssembler::warn(const char* msg) {
   pop(rbp);
 }
 
-void MacroAssembler::_assert_asm(Assembler::Condition cc, const char* msg) {
-#ifdef ASSERT
-  Label OK;
-  jcc(cc, OK);
-  stop(msg);
-  bind(OK);
-#endif
-}
-
 void MacroAssembler::print_state() {
   address rip = pc();
   pusha();            // get regs on stack