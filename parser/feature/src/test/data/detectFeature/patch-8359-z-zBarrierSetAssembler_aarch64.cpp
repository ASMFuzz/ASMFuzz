@@ -252,7 +252,7 @@ void ZBarrierSetAssembler::generate_c1_load_barrier_stub(LIR_Assembler* ce,
   __ far_call(stub->runtime_stub());
 
   // Verify result
-  __ verify_oop(r0, "Bad oop");
+  __ verify_oop(r0);
 
   // Move result into place
   if (ref != r0) {