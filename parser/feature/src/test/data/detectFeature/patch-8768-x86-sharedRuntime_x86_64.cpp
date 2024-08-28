@@ -1813,7 +1813,7 @@ nmethod* SharedRuntime::generate_native_wrapper(MacroAssembler* masm,
   }
 
   // Change state to native (we save the return address in the thread, since it might not
-  // be pushed on the stack when we do a a stack traversal). It is enough that the pc()
+  // be pushed on the stack when we do a stack traversal). It is enough that the pc()
   // points into the right code segment. It does not have to be the correct return pc.
   // We use the same pc/oopMap repeatedly when we call out
 
@@ -2251,7 +2251,7 @@ void SharedRuntime::generate_deopt_blob() {
 
   // -------------
   // This code enters when returning to a de-optimized nmethod.  A return
-  // address has been pushed on the the stack, and return values are in
+  // address has been pushed on the stack, and return values are in
   // registers.
   // If we are doing a normal deopt then we were called from the patched
   // nmethod from the point we returned to the nmethod. So the return
@@ -3001,7 +3001,7 @@ RuntimeStub* SharedRuntime::generate_resolve_blob(address destination, const cha
 
   RegisterSaver::restore_live_registers(masm);
 
-  // We are back the the original state on entry and ready to go.
+  // We are back to the original state on entry and ready to go.
 
   __ jmp(rax);
 