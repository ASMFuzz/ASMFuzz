@@ -7429,192 +7429,199 @@ address generate_avx_ghash_processBlocks() {
   RuntimeStub* generate_cont_doYield() {
     if (!Continuations::enabled()) return nullptr;
 
-    const char *name = "cont_doYield";
-
     enum layout {
       rbp_off,
       rbpH_off,
       return_off,
       return_off2,
       framesize // inclusive of return address
     };
-    // assert(is_even(framesize/2), "sp not 16-byte aligned");
 
-    int insts_size = 512;
-    int locs_size  = 64;
-    CodeBuffer code(name, insts_size, locs_size);
-    OopMapSet* oop_maps  = new OopMapSet();
-    MacroAssembler* masm = new MacroAssembler(&code);
-    MacroAssembler* _masm = masm;
+    CodeBuffer code("cont_doYield", 512, 64);
+    MacroAssembler* _masm = new MacroAssembler(&code);
 
     address start = __ pc();
-
     __ enter();
-
-    __ movptr(c_rarg1, rsp);
-
-    int frame_complete = __ pc() - start;
     address the_pc = __ pc();
 
-    __ post_call_nop(); // this must be exactly after the pc value that is pushed into the frame info, we use this nop for fast CodeBlob lookup
+    int frame_complete = the_pc - start;
+
+    // This nop must be exactly at the PC we push into the frame info.
+    // We use this nop for fast CodeBlob lookup, associate the OopMap
+    // with it right away.
+    __ post_call_nop();
+    OopMapSet* oop_maps = new OopMapSet();
+    OopMap* map = new OopMap(framesize, 1);
+    oop_maps->add_gc_map(frame_complete, map);
 
-    __ movptr(c_rarg0, r15_thread);
     __ set_last_Java_frame(rsp, rbp, the_pc);
+    __ movptr(c_rarg0, r15_thread);
+    __ movptr(c_rarg1, rsp);
     __ call_VM_leaf(Continuation::freeze_entry(), 2);
     __ reset_last_Java_frame(true);
 
-    Label pinned;
+    Label L_pinned;
 
-    __ testq(rax, rax);
-    __ jcc(Assembler::notZero, pinned);
+    __ testptr(rax, rax);
+    __ jcc(Assembler::notZero, L_pinned);
 
     __ movptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset()));
-    continuation_enter_cleanup(masm);
+    continuation_enter_cleanup(_masm);
     __ pop(rbp);
     __ ret(0);
 
-    __ bind(pinned); // pinned -- return to caller
+    __ bind(L_pinned);
 
+    // Pinned, return to caller
     __ leave();
     __ ret(0);
 
-    OopMap* map = new OopMap(framesize, 1);
-    oop_maps->add_gc_map(the_pc - start, map);
-
-    RuntimeStub* stub = // codeBlob framesize is in words (not VMRegImpl::slot_size)
-    RuntimeStub::new_runtime_stub(name,
-                                  &code,
-                                  frame_complete,
-                                  (framesize >> (LogBytesPerWord - LogBytesPerInt)),
-                                  oop_maps, false);
+    RuntimeStub* stub =
+      RuntimeStub::new_runtime_stub(code.name(),
+                                    &code,
+                                    frame_complete,
+                                    (framesize >> (LogBytesPerWord - LogBytesPerInt)),
+                                    oop_maps,
+                                    false);
     return stub;
   }
 
-  address generate_cont_thaw(Continuation::thaw_kind kind) {
+  address generate_cont_thaw(const char* label, Continuation::thaw_kind kind) {
+    if (!Continuations::enabled()) return nullptr;
+
     bool return_barrier = Continuation::is_thaw_return_barrier(kind);
     bool return_barrier_exception = Continuation::is_thaw_return_barrier_exception(kind);
 
+    StubCodeMark mark(this, "StubRoutines", label);
     address start = __ pc();
 
     // TODO: Handle Valhalla return types. May require generating different return barriers.
 
     if (!return_barrier) {
-      __ pop(c_rarg3); // pop return address. if we don't do this, we get a drift, where the bottom-most frozen frame continuously grows
+      // Pop return address. If we don't do this, we get a drift,
+      // where the bottom-most frozen frame continuously grows.
+      __ pop(c_rarg3);
     } else {
       __ movptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset()));
     }
-    assert_asm(_masm, cmpptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset())), Assembler::equal, "incorrect rsp");
+
+#ifdef ASSERT
+    {
+      Label L_good_sp;
+      __ cmpptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset()));
+      __ jcc(Assembler::equal, L_good_sp);
+      __ stop("Incorrect rsp at thaw entry");
+      __ BIND(L_good_sp);
+    }
+#endif
 
     if (return_barrier) {
-      __ push(rax); __ push_d(xmm0); // preserve possible return value from a method returning to the return barrier
+      // Preserve possible return value from a method returning to the return barrier.
+      __ push(rax);
+      __ push_d(xmm0);
     }
 
-    __ movl(c_rarg1, (return_barrier ? 1 : 0));
-    __ call_VM_leaf(CAST_FROM_FN_PTR(address, Continuation::prepare_thaw), r15_thread, c_rarg1);
-    __ movptr(rbx, rax); // rax contains the size of the frames to thaw, 0 if overflow or no more frames
+    __ movptr(c_rarg0, r15_thread);
+    __ movptr(c_rarg1, (return_barrier ? 1 : 0));
+    __ call_VM_leaf(CAST_FROM_FN_PTR(address, Continuation::prepare_thaw), 2);
+    __ movptr(rbx, rax);
 
     if (return_barrier) {
-      __ pop_d(xmm0); __ pop(rax); // restore return value (no safepoint in the call to thaw, so even an oop return value should be OK)
+      // Restore return value from a method returning to the return barrier.
+      // No safepoint in the call to thaw, so even an oop return value should be OK.
+      __ pop_d(xmm0);
+      __ pop(rax);
     }
-    assert_asm(_masm, cmpptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset())), Assembler::equal, "incorrect rsp");
 
-    Label thaw_success;
-    __ testq(rbx, rbx);           // rbx contains the size of the frames to thaw, 0 if overflow or no more frames
-    __ jcc(Assembler::notZero, thaw_success);
+#ifdef ASSERT
+    {
+      Label L_good_sp;
+      __ cmpptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset()));
+      __ jcc(Assembler::equal, L_good_sp);
+      __ stop("Incorrect rsp after prepare thaw");
+      __ BIND(L_good_sp);
+    }
+#endif
+
+    // rbx contains the size of the frames to thaw, 0 if overflow or no more frames
+    Label L_thaw_success;
+    __ testptr(rbx, rbx);
+    __ jccb(Assembler::notZero, L_thaw_success);
     __ jump(ExternalAddress(StubRoutines::throw_StackOverflowError_entry()));
-    __ bind(thaw_success);
+    __ bind(L_thaw_success);
 
-    __ subq(rsp, rbx);             // make room for the thawed frames
-    __ andptr(rsp, -16);           // align
+    // Make room for the thawed frames and align the stack.
+    __ subptr(rsp, rbx);
+    __ andptr(rsp, -StackAlignmentInBytes);
 
     if (return_barrier) {
-      __ push(rax); __ push_d(xmm0); // save original return value -- again
+      // Preserve possible return value from a method returning to the return barrier. (Again.)
+      __ push(rax);
+      __ push_d(xmm0);
     }
 
-    // If we want, we can templatize thaw by kind, and have three different entries
-    __ movl(c_rarg1, (int32_t) kind);
-
-    __ call_VM_leaf(Continuation::thaw_entry(), r15_thread, c_rarg1);
-    __ movptr(rbx, rax); // rax is the sp of the yielding frame
+    // If we want, we can templatize thaw by kind, and have three different entries.
+    __ movptr(c_rarg0, r15_thread);
+    __ movptr(c_rarg1, kind);
+    __ call_VM_leaf(Continuation::thaw_entry(), 2);
+    __ movptr(rbx, rax);
 
     if (return_barrier) {
-      __ pop_d(xmm0); __ pop(rax); // restore return value (no safepoint in the call to thaw, so even an oop return value should be OK)
+      // Restore return value from a method returning to the return barrier. (Again.)
+      // No safepoint in the call to thaw, so even an oop return value should be OK.
+      __ pop_d(xmm0);
+      __ pop(rax);
     } else {
-      __ movl(rax, 0); // return 0 (success) from doYield
+      // Return 0 (success) from doYield.
+      __ xorptr(rax, rax);
     }
 
-    __ movptr(rsp, rbx); // we're now on the yield frame (which is in an address above us b/c rsp has been pushed down)
-    __ subptr(rsp, 2*wordSize); // now pointing to rbp spill
+    // After thawing, rbx is the SP of the yielding frame.
+    // Move there, and then to saved RBP slot.
+    __ movptr(rsp, rbx);
+    __ subptr(rsp, 2*wordSize);
 
     if (return_barrier_exception) {
+      __ movptr(c_rarg0, r15_thread);
       __ movptr(c_rarg1, Address(rsp, wordSize)); // return address
-      __ push(rax); // save return value contaning the exception oop
-      __ call_VM_leaf(CAST_FROM_FN_PTR(address, SharedRuntime::exception_handler_for_return_address), r15_thread, c_rarg1);
-      __ movptr(rbx, rax); // the exception handler
-      __ pop(rax); // restore return value contaning the exception oop
+
+      // rax still holds the original exception oop, save it before the call
+      __ push(rax);
+
+      __ call_VM_leaf(CAST_FROM_FN_PTR(address, SharedRuntime::exception_handler_for_return_address), 2);
+      __ movptr(rbx, rax);
+
+      // rbx now holds the exception handler.
+      // Prepare for its invocation; see OptoRuntime::generate_exception_blob.
+      __ pop(rax); // exception oop
       __ pop(rbp);
-      __ pop(rdx); // rdx must contain the original pc in the case of exception; see OptoRuntime::generate_exception_blob
-      __ jmp(rbx); // the exception handler
+      __ pop(rdx); // exception pc
+      __ jmp(rbx);
     }
 
-    // We're "returning" into the topmost thawed frame; see Thaw::push_return_frame
+    // We are "returning" into the topmost thawed frame; see Thaw::push_return_frame
     __ pop(rbp);
     __ ret(0);
 
     return start;
   }
 
   address generate_cont_thaw() {
-    if (!Continuations::enabled()) return nullptr;
-
-    StubCodeMark mark(this, "StubRoutines", "Cont thaw");
-    address start = __ pc();
-    generate_cont_thaw(Continuation::thaw_top);
-    return start;
+    return generate_cont_thaw("Cont thaw", Continuation::thaw_top);
   }
 
-  address generate_cont_returnBarrier() {
-    if (!Continuations::enabled()) return nullptr;
+  // TODO: will probably need multiple return barriers depending on return type
 
-    // TODO: will probably need multiple return barriers depending on return type
-    StubCodeMark mark(this, "StubRoutines", "cont return barrier");
-    address start = __ pc();
-
-    generate_cont_thaw(Continuation::thaw_return_barrier);
-
-    return start;
+  address generate_cont_returnBarrier() {
+    return generate_cont_thaw("Cont thaw return barrier", Continuation::thaw_return_barrier);
   }
 
   address generate_cont_returnBarrier_exception() {
-    if (!Continuations::enabled()) return nullptr;
-
-    StubCodeMark mark(this, "StubRoutines", "cont return barrier exception handler");
-    address start = __ pc();
-
-    generate_cont_thaw(Continuation::thaw_return_barrier_exception);
-
-    return start;
+    return generate_cont_thaw("Cont thaw return barrier exception", Continuation::thaw_return_barrier_exception);
   }
 
 #if INCLUDE_JFR
 
-  static void jfr_prologue(address the_pc, MacroAssembler* _masm) {
-    __ set_last_Java_frame(rsp, rbp, the_pc);
-    __ movptr(c_rarg0, r15_thread);
-  }
-
-  // The handle is dereferenced through a load barrier.
-  static void jfr_epilogue(MacroAssembler* _masm) {
-    __ reset_last_Java_frame(true);
-    Label null_jobject;
-    __ testq(rax, rax);
-    __ jcc(Assembler::zero, null_jobject);
-    DecoratorSet decorators = ACCESS_READ | IN_NATIVE;
-    BarrierSetAssembler* bs = BarrierSet::barrier_set()->barrier_set_assembler();
-    bs->load_at(_masm, decorators, T_OBJECT, rax, Address(rax, 0), c_rarg0, r15_thread);
-    __ bind(null_jobject);
-  }
-
   // For c2: c_rarg0 is junk, call to runtime to write a checkpoint.
   // It returns a jobject handle to the event writer.
   // The handle is dereferenced and the return value is the event writer oop.
@@ -7627,30 +7634,44 @@ address generate_avx_ghash_processBlocks() {
       framesize // inclusive of return address
     };
 
-    int insts_size = 512;
-    int locs_size = 64;
-    CodeBuffer code("jfr_write_checkpoint", insts_size, locs_size);
-    OopMapSet* oop_maps = new OopMapSet();
-    MacroAssembler* masm = new MacroAssembler(&code);
-    MacroAssembler* _masm = masm;
+    CodeBuffer code("jfr_write_checkpoint", 512, 64);
+    MacroAssembler* _masm = new MacroAssembler(&code);
 
     address start = __ pc();
     __ enter();
-    int frame_complete = __ pc() - start;
     address the_pc = __ pc();
-    jfr_prologue(the_pc, _masm);
+
+    int frame_complete = the_pc - start;
+
+    __ set_last_Java_frame(rsp, rbp, the_pc);
+    __ movptr(c_rarg0, r15_thread);
     __ call_VM_leaf(CAST_FROM_FN_PTR(address, JfrIntrinsicSupport::write_checkpoint), 1);
-    jfr_epilogue(_masm);
+    __ reset_last_Java_frame(true);
+
+    // rax is jobject handle result, unpack and process it through a barrier.
+    Label L_null_jobject;
+    __ testptr(rax, rax);
+    __ jcc(Assembler::zero, L_null_jobject);
+
+    BarrierSetAssembler* bs = BarrierSet::barrier_set()->barrier_set_assembler();
+    bs->load_at(_masm, ACCESS_READ | IN_NATIVE, T_OBJECT, rax, Address(rax, 0), c_rarg0, r15_thread);
+
+    __ bind(L_null_jobject);
+
     __ leave();
     __ ret(0);
 
-    OopMap* map = new OopMap(framesize, 1); // rbp
-    oop_maps->add_gc_map(the_pc - start, map);
+    OopMapSet* oop_maps = new OopMapSet();
+    OopMap* map = new OopMap(framesize, 1);
+    oop_maps->add_gc_map(frame_complete, map);
 
-    RuntimeStub* stub = // codeBlob framesize is in words (not VMRegImpl::slot_size)
-      RuntimeStub::new_runtime_stub("jfr_write_checkpoint", &code, frame_complete,
+    RuntimeStub* stub =
+      RuntimeStub::new_runtime_stub(code.name(),
+                                    &code,
+                                    frame_complete,
                                     (framesize >> (LogBytesPerWord - LogBytesPerInt)),
-                                    oop_maps, false);
+                                    oop_maps,
+                                    false);
     return stub;
   }
 
@@ -8174,17 +8195,27 @@ void StubGenerator_generate(CodeBuffer* code, int phase) {
 #undef __
 #define __ masm->
 
-// on exit, rsp points to the ContinuationEntry
-// kills rax
+//---------------------------- continuation_enter_setup ---------------------------
+//
+// Arguments:
+//   None.
+//
+// Results:
+//   rsp: pointer to blank ContinuationEntry
+//
+// Kills:
+//   rax
+//
 OopMap* continuation_enter_setup(MacroAssembler* masm, int& stack_slots) {
   assert(ContinuationEntry::size() % VMRegImpl::stack_slot_size == 0, "");
   assert(in_bytes(ContinuationEntry::cont_offset())  % VMRegImpl::stack_slot_size == 0, "");
   assert(in_bytes(ContinuationEntry::chunk_offset()) % VMRegImpl::stack_slot_size == 0, "");
 
-  stack_slots += (int)ContinuationEntry::size()/wordSize;
-  __ subptr(rsp, (int32_t)ContinuationEntry::size()); // place Continuation metadata
+  stack_slots += checked_cast<int>(ContinuationEntry::size()) / wordSize;
+  __ subptr(rsp, checked_cast<int32_t>(ContinuationEntry::size()));
 
-  OopMap* map = new OopMap(((int)ContinuationEntry::size() + wordSize)/ VMRegImpl::stack_slot_size, 0 /* arg_slots*/);
+  int frame_size = (checked_cast<int>(ContinuationEntry::size()) + wordSize) / VMRegImpl::stack_slot_size;
+  OopMap* map = new OopMap(frame_size, 0);
   ContinuationEntry::setup_oopmap(map);
 
   __ movptr(rax, Address(r15_thread, JavaThread::cont_entry_offset()));
@@ -8194,18 +8225,27 @@ OopMap* continuation_enter_setup(MacroAssembler* masm, int& stack_slots) {
   return map;
 }
 
-// on entry c_rarg1 points to the continuation
-//          rsp points to ContinuationEntry
-//          c_rarg3 -- isVirtualThread
-// kills rax
+//---------------------------- fill_continuation_entry ---------------------------
+//
+// Arguments:
+//   rsp: pointer to blank Continuation entry
+//   c_rarg1: pointer to the continuation
+//   c_rarg3: flags
+//
+// Results:
+//   rsp: pointer to filled out ContinuationEntry
+//
+// Kills:
+//   rax
+//
 void fill_continuation_entry(MacroAssembler* masm) {
   DEBUG_ONLY(__ movl(Address(rsp, ContinuationEntry::cookie_offset()), 0x1234);)
 
   __ movptr(Address(rsp, ContinuationEntry::cont_offset()), c_rarg1);
   __ movl  (Address(rsp, ContinuationEntry::flags_offset()), c_rarg3);
-  __ movptr(Address(rsp, ContinuationEntry::chunk_offset()), (int32_t)0);
-  __ movl(Address(rsp, ContinuationEntry::argsize_offset()), (int32_t)0);
-  __ movl(Address(rsp, ContinuationEntry::pin_count_offset()), (int32_t)0);
+  __ movptr(Address(rsp, ContinuationEntry::chunk_offset()), 0);
+  __ movl(Address(rsp, ContinuationEntry::argsize_offset()), 0);
+  __ movl(Address(rsp, ContinuationEntry::pin_count_offset()), 0);
 
   __ movptr(rax, Address(r15_thread, JavaThread::cont_fastpath_offset()));
   __ movptr(Address(rsp, ContinuationEntry::parent_cont_fastpath_offset()), rax);
@@ -8216,25 +8256,33 @@ void fill_continuation_entry(MacroAssembler* masm) {
   __ reset_held_monitor_count(r15_thread);
 }
 
-// on entry, rsp points to the ContinuationEntry
-// on exit, rsp points to the spilled rbp in the entry frame
-// kills rbx, rcx
+//---------------------------- continuation_enter_cleanup ---------------------------
+//
+// Arguments:
+//   rsp: pointer to the ContinuationEntry
+//
+// Results:
+//   rsp: pointer to the spilled rbp in the entry frame
+//
+// Kills:
+//   rbx
+//
 void continuation_enter_cleanup(MacroAssembler* masm) {
-#ifndef PRODUCT
-  Label OK;
+#ifdef ASSERT
+  Label L_good_sp;
   __ cmpptr(rsp, Address(r15_thread, JavaThread::cont_entry_offset()));
-  __ jcc(Assembler::equal, OK);
-  __ stop("incorrect rsp1");
-  __ bind(OK);
+  __ jcc(Assembler::equal, L_good_sp);
+  __ stop("Incorrect rsp at continuation_enter_cleanup");
+  __ bind(L_good_sp);
 #endif
 
   __ movptr(rbx, Address(rsp, ContinuationEntry::parent_cont_fastpath_offset()));
   __ movptr(Address(r15_thread, JavaThread::cont_fastpath_offset()), rbx);
   __ movl(rbx, Address(rsp, ContinuationEntry::parent_held_monitor_count_offset()));
   __ movl(Address(r15_thread, JavaThread::held_monitor_count_offset()), rbx);
 
-  __ movptr(rcx, Address(rsp, ContinuationEntry::parent_offset()));
-  __ movptr(Address(r15_thread, JavaThread::cont_entry_offset()), rcx);
+  __ movptr(rbx, Address(rsp, ContinuationEntry::parent_offset()));
+  __ movptr(Address(r15_thread, JavaThread::cont_entry_offset()), rbx);
   __ addptr(rsp, (int32_t)ContinuationEntry::size());
 }
 