@@ -271,7 +271,7 @@ void RegisterSaver::restore_live_registers(MacroAssembler* masm) {
   __ pop_CPU_state(_save_vectors);
 #endif
   __ ldp(rfp, lr, Address(__ post(sp, 2 * wordSize)));
-
+  __ authenticate_return_address();
 }
 
 // Is vector's size (in bytes) bigger than a size saved by default?