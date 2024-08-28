@@ -1259,99 +1259,129 @@ static void verify_oop_args(MacroAssembler* masm,
 
 // defined in stubGenerator_x86_64.cpp
 OopMap* continuation_enter_setup(MacroAssembler* masm, int& stack_slots);
-void fill_continuation_entry(MacroAssembler* masm);
+void fill_continuation_entry(MacroAssembler* masm, Register reg_cont_obj, Register reg_flags);
 void continuation_enter_cleanup(MacroAssembler* masm);
 
-// enterSpecial(Continuation c, boolean isContinue, boolean isVirtualThread)
-// On entry: c_rarg1 -- the continuation object
-//           c_rarg2 -- isContinue
-//           c_rarg3 -- isVirtualThread
+static void check_continuation_enter_argument(VMReg actual_vmreg,
+                                              Register expected_reg,
+                                              const char* name) {
+  assert(!actual_vmreg->is_stack(), "%s cannot be on stack", name);
+  assert(actual_vmreg->as_Register() == expected_reg,
+         "%s is in unexpected register: %s instead of %s",
+         name, actual_vmreg->as_Register()->name(), expected_reg->name());
+}
+
 static void gen_continuation_enter(MacroAssembler* masm,
-                                 const methodHandle& method,
-                                 const BasicType* sig_bt,
                                  const VMRegPair* regs,
                                  int& exception_offset,
-                                 OopMapSet*oop_maps,
+                                 OopMapSet* oop_maps,
                                  int& frame_complete,
                                  int& stack_slots) {
-  //verify_oop_args(masm, method, sig_bt, regs);
-  AddressLiteral resolve(SharedRuntime::get_resolve_static_call_stub(),
-                         relocInfo::static_call_type);
 
-  stack_slots = 2; // will be overwritten
-  address start = __ pc();
+  // enterSpecial(Continuation c, boolean isContinue, boolean isVirtualThread)
+  int pos_cont_obj   = 0;
+  int pos_is_cont    = 1;
+  int pos_is_virtual = 2;
+
+  // The platform-specific calling convention may present the arguments in various registers.
+  // To simplify the rest of the code, we expect the arguments to reside at these known
+  // registers, and we additionally check the placement here in case calling convention ever
+  // changes.
+  Register reg_cont_obj   = c_rarg1;
+  Register reg_is_cont    = c_rarg2;
+  Register reg_is_virtual = c_rarg3;
+
+  check_continuation_enter_argument(regs[pos_cont_obj].first(),   reg_cont_obj,   "Continuation object");
+  check_continuation_enter_argument(regs[pos_is_cont].first(),    reg_is_cont,    "isContinue");
+  check_continuation_enter_argument(regs[pos_is_virtual].first(), reg_is_virtual, "isVirtualThread");
 
-  Label call_thaw, exit;
+  // Utility methods kill rax, make sure there are no collisions
+  assert_different_registers(rax, reg_cont_obj, reg_is_cont, reg_is_virtual);
+
+  address start = __ pc();
 
   __ enter();
 
-  //BarrierSetAssembler* bs = BarrierSet::barrier_set()->barrier_set_assembler();
-  //bs->nmethod_entry_barrier(masm);
-  OopMap* map = continuation_enter_setup(masm, stack_slots);  // kills rax
+  stack_slots = 2; // will be adjusted in setup
+  OopMap* map = continuation_enter_setup(masm, stack_slots);
 
   // Frame is now completed as far as size and linkage.
-  frame_complete =__ pc() - start;
-  // if isContinue == 0
-  //   _enterSP = sp
-  // end
+  frame_complete = __ pc() - start;
+
+  __ verify_oop(reg_cont_obj);
+
+  fill_continuation_entry(masm, reg_cont_obj, reg_is_virtual);
+
+  Label L_thaw, L_exit;
 
-  fill_continuation_entry(masm); // kills rax
+  // If continuation, call to thaw. Otherwise, resolve the call and exit.
+  __ testptr(reg_is_cont, reg_is_cont);
+  __ jccb(Assembler::notZero, L_thaw);
 
-  __ cmpl(c_rarg2, 0);
-  __ jcc(Assembler::notEqual, call_thaw);
+  // --- Resolve path
 
-  int up = align_up((intptr_t) __ pc() + 1, 4) - (intptr_t) (__ pc() + 1);
-  if (up > 0) {
-    __ nop(up);
+  // Make sure the call is patchable
+  __ align(BytesPerWord, __ offset() + NativeCall::displacement_offset);
+
+  // Emit stub for static call
+  CodeBuffer* cbuf = masm->code_section()->outer();
+  address stub = CompiledStaticCall::emit_to_interp_stub(*cbuf, __ pc());
+  if (stub == nullptr) {
+    fatal("CodeCache is full at gen_continuation_enter");
   }
 
-  address mark = __ pc();
+  // Call the resolve stub
+  AddressLiteral resolve(SharedRuntime::get_resolve_static_call_stub(),
+                         relocInfo::static_call_type);
   __ call(resolve);
+
   oop_maps->add_gc_map(__ pc() - start, map);
   __ post_call_nop();
 
-  __ jmp(exit);
+  __ jmpb(L_exit);
 
-  __ bind(call_thaw);
+  // --- Thawing path
+
+  __ bind(L_thaw);
+
+  __ call(RuntimeAddress(StubRoutines::cont_thaw()));
 
-  __ movptr(rbx, (intptr_t) StubRoutines::cont_thaw());
-  __ call(rbx);
-  oop_maps->add_gc_map(__ pc() - start, map->deep_copy());
   ContinuationEntry::_return_pc_offset = __ pc() - start;
+  oop_maps->add_gc_map(__ pc() - start, map->deep_copy());
   __ post_call_nop();
 
-  __ bind(exit);
+  // --- Normal exit (resolve/thawing)
+
+  __ bind(L_exit);
+
   continuation_enter_cleanup(masm);
   __ pop(rbp);
   __ ret(0);
 
-  /// exception handling
+  // --- Exception handling path
 
   exception_offset = __ pc() - start;
 
   continuation_enter_cleanup(masm);
   __ pop(rbp);
 
-  __ movptr(rbx, rax); // save the exception
-  __ movptr(c_rarg0, Address(rsp, 0));
+  __ movptr(c_rarg0, r15_thread);
+  __ movptr(c_rarg1, Address(rsp, 0)); // return address
 
-  __ call_VM_leaf(CAST_FROM_FN_PTR(address,
-        SharedRuntime::exception_handler_for_return_address),
-      r15_thread, c_rarg0);
-  __ mov(rdi, rax);
-  __ movptr(rax, rbx);
-  __ mov(rbx, rdi);
-  __ pop(rdx);
+  // rax still holds the original exception oop, save it before the call
+  __ push(rax);
+
+  __ call_VM_leaf(CAST_FROM_FN_PTR(address, SharedRuntime::exception_handler_for_return_address), 2);
+  __ movptr(rbx, rax);
 
-  // continue at exception handler (return address removed)
-  // rax: exception
-  // rbx: exception handler
-  // rdx: throwing pc
+  // Continue at exception handler:
+  //   rax: exception oop
+  //   rbx: exception handler
+  //   rdx: exception pc
+  __ pop(rax);
   __ verify_oop(rax);
+  __ pop(rdx);
   __ jmp(rbx);
-
-  CodeBuffer* cbuf = masm->code_section()->outer();
-  address stub = CompiledStaticCall::emit_to_interp_stub(*cbuf, mark);
 }
 
 static void gen_special_dispatch(MacroAssembler* masm,
@@ -1447,8 +1477,6 @@ nmethod* SharedRuntime::generate_native_wrapper(MacroAssembler* masm,
     int stack_slots = 0;
     OopMapSet* oop_maps =  new OopMapSet();
     gen_continuation_enter(masm,
-                         method,
-                         in_sig_bt,
                          in_regs,
                          exception_offset,
                          oop_maps,