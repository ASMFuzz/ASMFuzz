@@ -1108,7 +1108,7 @@ static void object_move(MacroAssembler* masm,
       *receiver_offset = (offset_in_older_frame + framesize_in_slots) * VMRegImpl::stack_slot_size;
     }
   } else {
-    // Oop is in an a register we must store it to the space we reserve
+    // Oop is in a register we must store it to the space we reserve
     // on the stack for oop_handles
     const Register rOop = src.first()->as_Register();
     const Register rHandle = rax;
@@ -1653,7 +1653,7 @@ nmethod* SharedRuntime::generate_native_wrapper(MacroAssembler* masm,
   }
 
   // Change state to native (we save the return address in the thread, since it might not
-  // be pushed on the stack when we do a a stack traversal). It is enough that the pc()
+  // be pushed on the stack when we do a stack traversal). It is enough that the pc()
   // points into the right code segment. It does not have to be the correct return pc.
   // We use the same pc/oopMap repeatedly when we call out
 
@@ -2107,7 +2107,7 @@ void SharedRuntime::generate_deopt_blob() {
 
   // -------------
   // This code enters when returning to a de-optimized nmethod.  A return
-  // address has been pushed on the the stack, and return values are in
+  // address has been pushed on the stack, and return values are in
   // registers.
   // If we are doing a normal deopt then we were called from the patched
   // nmethod from the point we returned to the nmethod. So the return
@@ -2835,7 +2835,7 @@ RuntimeStub* SharedRuntime::generate_resolve_blob(address destination, const cha
 
   RegisterSaver::restore_live_registers(masm);
 
-  // We are back the the original state on entry and ready to go.
+  // We are back to the original state on entry and ready to go.
 
   __ jmp(rax);
 