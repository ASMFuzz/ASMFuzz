@@ -165,13 +165,6 @@ address LIR_Assembler::emit_call_c(address a) {
 }
 
 int LIR_Assembler::emit_exception_handler() {
-  // If the last instruction is a call (typically to do a throw which
-  // is coming at the end after block reordering) the return address
-  // must still point into the code area in order to avoid assertion
-  // failures when searching for the corresponding bci. => Add a nop.
-  // (was bug 5/14/1999 - gri)
-  __ nop();
-
   // Generate code for exception handler.
   address handler_base = __ start_a_stub(exception_handler_size());
   if (handler_base == NULL) {
@@ -263,13 +256,6 @@ int LIR_Assembler::emit_unwind_handler() {
 }
 
 int LIR_Assembler::emit_deopt_handler() {
-  // If the last instruction is a call (typically to do a throw which
-  // is coming at the end after block reordering) the return address
-  // must still point into the code area in order to avoid assertion
-  // failures when searching for the corresponding bci. => Add a nop.
-  // (was bug 5/14/1999 - gri)
-  __ nop();
-
   // Generate code for exception handler.
   address handler_base = __ start_a_stub(deopt_handler_size());
   if (handler_base == NULL) {