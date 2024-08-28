@@ -433,7 +433,7 @@ int LIR_Assembler::emit_unwind_handler() {
     __ mov(r19, r0);  // Preserve the exception
   }
 
-  // Preform needed unlocking
+  // Perform needed unlocking
   MonitorExitStub* stub = NULL;
   if (method()->is_synchronized()) {
     monitor_address(0, FrameMap::r0_opr);