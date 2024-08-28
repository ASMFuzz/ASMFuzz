@@ -167,13 +167,6 @@ void LIR_Assembler::osr_entry() {
 
 
 int LIR_Assembler::emit_exception_handler() {
-  // If the last instruction is a call (typically to do a throw which
-  // is coming at the end after block reordering) the return address
-  // must still point into the code area in order to avoid assertion
-  // failures when searching for the corresponding bci => add a nop
-  // (was bug 5/14/1999 - gri).
-  __ nop();
-
   // Generate code for the exception handler.
   address handler_base = __ start_a_stub(exception_handler_size());
 
@@ -247,13 +240,6 @@ int LIR_Assembler::emit_unwind_handler() {
 
 
 int LIR_Assembler::emit_deopt_handler() {
-  // If the last instruction is a call (typically to do a throw which
-  // is coming at the end after block reordering) the return address
-  // must still point into the code area in order to avoid assertion
-  // failures when searching for the corresponding bci => add a nop
-  // (was bug 5/14/1999 - gri).
-  __ nop();
-
   // Generate code for deopt handler.
   address handler_base = __ start_a_stub(deopt_handler_size());
 