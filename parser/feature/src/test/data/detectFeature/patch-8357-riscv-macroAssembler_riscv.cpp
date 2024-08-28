@@ -530,7 +530,7 @@ void MacroAssembler::resolve_jobject(Register value, Register thread, Register t
 
 void MacroAssembler::stop(const char* msg) {
   address ip = pc();
-  pusha();
+  push_reg(0xffffffff, sp);
   // The length of the instruction sequence emitted should be independent
   // of the values of msg and ip so that the size of mach nodes for scratch
   // emit and normal emit matches.