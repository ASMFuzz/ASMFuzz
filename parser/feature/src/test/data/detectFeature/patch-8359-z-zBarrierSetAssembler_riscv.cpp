@@ -397,7 +397,7 @@ void ZBarrierSetAssembler::generate_c1_load_barrier_stub(LIR_Assembler* ce,
   __ far_call(stub->runtime_stub());
 
   // Verify result
-  __ verify_oop(x10, "Bad oop");
+  __ verify_oop(x10);
 
 
   // Move result into place