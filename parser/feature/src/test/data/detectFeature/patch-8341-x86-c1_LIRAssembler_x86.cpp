@@ -398,13 +398,6 @@ int LIR_Assembler::initial_frame_size_in_bytes() const {
 
 
 int LIR_Assembler::emit_exception_handler() {
-  // if the last instruction is a call (typically to do a throw which
-  // is coming at the end after block reordering) the return address
-  // must still point into the code area in order to avoid assertion
-  // failures when searching for the corresponding bci => add a nop
-  // (was bug 5/14/1999 - gri)
-  __ nop();
-
   // generate code for exception handler
   address handler_base = __ start_a_stub(exception_handler_size());
   if (handler_base == NULL) {
@@ -499,13 +492,6 @@ int LIR_Assembler::emit_unwind_handler() {
 
 
 int LIR_Assembler::emit_deopt_handler() {
-  // if the last instruction is a call (typically to do a throw which
-  // is coming at the end after block reordering) the return address
-  // must still point into the code area in order to avoid assertion
-  // failures when searching for the corresponding bci => add a nop
-  // (was bug 5/14/1999 - gri)
-  __ nop();
-
   // generate code for exception handler
   address handler_base = __ start_a_stub(deopt_handler_size());
   if (handler_base == NULL) {