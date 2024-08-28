@@ -822,7 +822,7 @@ static void object_move(MacroAssembler* masm,
     __ bind(notZero1);
   } else {
 
-    // Oop is in an a register we must store it to the space we reserve
+    // Oop is in a register we must store it to the space we reserve
     // on the stack for oop_handles and pass a handle if oop is non-NULL
 
     const Register rOop = src.first()->as_Register();
@@ -1898,7 +1898,7 @@ void SharedRuntime::generate_deopt_blob() {
 
   // -------------
   // This code enters when returning to a de-optimized nmethod.  A return
-  // address has been pushed on the the stack, and return values are in
+  // address has been pushed on the stack, and return values are in
   // registers.
   // If we are doing a normal deopt then we were called from the patched
   // nmethod from the point we returned to the nmethod. So the return
@@ -2591,7 +2591,7 @@ RuntimeStub* SharedRuntime::generate_resolve_blob(address destination, const cha
   __ sd(x10, Address(sp, reg_saver.reg_offset_in_bytes(t0)));
   reg_saver.restore_live_registers(masm);
 
-  // We are back the the original state on entry and ready to go.
+  // We are back to the original state on entry and ready to go.
 
   __ jr(t0);
 