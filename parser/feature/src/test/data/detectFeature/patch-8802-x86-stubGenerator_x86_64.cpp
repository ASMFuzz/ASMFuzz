@@ -7666,11 +7666,14 @@ address generate_avx_ghash_processBlocks() {
       __ call_VM_leaf(CAST_FROM_FN_PTR(address, SharedRuntime::exception_handler_for_return_address), 2);
       __ movptr(rbx, rax);
 
-      // rbx now holds the exception handler.
-      // Prepare for its invocation; see OptoRuntime::generate_exception_blob.
-      __ pop(rax); // exception oop
-      __ pop(rbp);
-      __ pop(rdx); // exception pc
+      // Continue at exception handler:
+      //   rax: exception oop
+      //   rbx: exception handler
+      //   rdx: exception pc
+      __ pop(rax);
+      __ verify_oop(rax);
+      __ pop(rbp); // pop out RBP here too
+      __ pop(rdx);
       __ jmp(rbx);
     }
 
@@ -8309,20 +8312,22 @@ OopMap* continuation_enter_setup(MacroAssembler* masm, int& stack_slots) {
 //
 // Arguments:
 //   rsp: pointer to blank Continuation entry
-//   c_rarg1: pointer to the continuation
-//   c_rarg3: flags
+//   reg_cont_obj: pointer to the continuation
+//   reg_flags: flags
 //
 // Results:
 //   rsp: pointer to filled out ContinuationEntry
 //
 // Kills:
 //   rax
 //
-void fill_continuation_entry(MacroAssembler* masm) {
+void fill_continuation_entry(MacroAssembler* masm, Register reg_cont_obj, Register reg_flags) {
+  assert_different_registers(rax, reg_cont_obj, reg_flags);
+
   DEBUG_ONLY(__ movl(Address(rsp, ContinuationEntry::cookie_offset()), ContinuationEntry::cookie_value());)
 
-  __ movptr(Address(rsp, ContinuationEntry::cont_offset()), c_rarg1);
-  __ movl  (Address(rsp, ContinuationEntry::flags_offset()), c_rarg3);
+  __ movptr(Address(rsp, ContinuationEntry::cont_offset()), reg_cont_obj);
+  __ movl  (Address(rsp, ContinuationEntry::flags_offset()), reg_flags);
   __ movptr(Address(rsp, ContinuationEntry::chunk_offset()), 0);
   __ movl(Address(rsp, ContinuationEntry::argsize_offset()), 0);
   __ movl(Address(rsp, ContinuationEntry::pin_count_offset()), 0);