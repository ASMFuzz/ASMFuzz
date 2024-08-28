@@ -237,7 +237,7 @@ void ZBarrierSetAssembler::generate_c1_load_barrier_stub(LIR_Assembler* ce,
   assert_different_registers(ref, ref_addr, noreg);
 
   // Save r0 unless it is the result or tmp register
-  // Set up SP to accomodate parameters and maybe r0..
+  // Set up SP to accommodate parameters and maybe r0..
   if (ref != r0 && tmp != r0) {
     __ sub(sp, sp, 32);
     __ str(r0, Address(sp, 16));