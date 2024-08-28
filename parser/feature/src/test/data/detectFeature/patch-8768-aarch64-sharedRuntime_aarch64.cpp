@@ -1978,7 +1978,7 @@ void SharedRuntime::generate_deopt_blob() {
 
   // -------------
   // This code enters when returning to a de-optimized nmethod.  A return
-  // address has been pushed on the the stack, and return values are in
+  // address has been pushed on the stack, and return values are in
   // registers.
   // If we are doing a normal deopt then we were called from the patched
   // nmethod from the point we returned to the nmethod. So the return
@@ -2729,7 +2729,7 @@ RuntimeStub* SharedRuntime::generate_resolve_blob(address destination, const cha
   __ str(r0, Address(sp, reg_save.rscratch1_offset_in_bytes()));
   reg_save.restore_live_registers(masm);
 
-  // We are back the the original state on entry and ready to go.
+  // We are back to the original state on entry and ready to go.
 
   __ br(rscratch1);
 
@@ -2892,4 +2892,3 @@ void OptoRuntime::generate_exception_blob() {
 }
 
 #endif // COMPILER2
-