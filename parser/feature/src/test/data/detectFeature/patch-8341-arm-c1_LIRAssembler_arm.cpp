@@ -199,9 +199,6 @@ int LIR_Assembler::initial_frame_size_in_bytes() const {
 
 
 int LIR_Assembler::emit_exception_handler() {
-  // TODO: ARM
-  __ nop(); // See comments in other ports
-
   address handler_base = __ start_a_stub(exception_handler_size());
   if (handler_base == NULL) {
     bailout("exception handler overflow");