@@ -4501,6 +4501,87 @@ class StubGenerator: public StubCodeGenerator {
 
 #endif // VM_LITTLE_ENDIAN
 
+  RuntimeStub* generate_cont_doYield() {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+  address generate_cont_thaw(bool return_barrier, bool exception) {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+  address generate_cont_thaw() {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+  address generate_cont_returnBarrier() {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+  address generate_cont_returnBarrier_exception() {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+#if INCLUDE_JFR
+
+  // For c2: c_rarg0 is junk, call to runtime to write a checkpoint.
+  // It returns a jobject handle to the event writer.
+  // The handle is dereferenced and the return value is the event writer oop.
+  RuntimeStub* generate_jfr_write_checkpoint() {
+    Register tmp1 = R10_ARG8;
+    Register tmp2 = R9_ARG7;
+    int insts_size = 512;
+    int locs_size = 64;
+    CodeBuffer code("jfr_write_checkpoint", insts_size, locs_size);
+    OopMapSet* oop_maps = new OopMapSet();
+    MacroAssembler* masm = new MacroAssembler(&code);
+    MacroAssembler* _masm = masm;
+
+    int framesize = frame::abi_reg_args_size / VMRegImpl::stack_slot_size;
+    address start = __ pc();
+    __ mflr(tmp1);
+    __ std(tmp1, _abi0(lr), R1_SP);  // save return pc
+    __ push_frame_reg_args(0, tmp1);
+    int frame_complete = __ pc() - start;
+    __ set_last_Java_frame(R1_SP, noreg);
+    __ call_VM_leaf(CAST_FROM_FN_PTR(address, JfrIntrinsicSupport::write_checkpoint), R16_thread);
+    address calls_return_pc = __ last_calls_return_pc();
+    __ reset_last_Java_frame();
+    // The handle is dereferenced through a load barrier.
+    Label null_jobject;
+    __ cmpdi(CCR0, R3_RET, 0);
+    __ beq(CCR0, null_jobject);
+    DecoratorSet decorators = ACCESS_READ | IN_NATIVE;
+    BarrierSetAssembler* bs = BarrierSet::barrier_set()->barrier_set_assembler();
+    bs->load_at(_masm, decorators, T_OBJECT, R3_RET /*base*/, (intptr_t)0, R3_RET /*dst*/, tmp1, tmp2, MacroAssembler::PRESERVATION_NONE);
+    __ bind(null_jobject);
+    __ pop_frame();
+    __ ld(tmp1, _abi0(lr), R1_SP);
+    __ mtlr(tmp1);
+    __ blr();
+
+    OopMap* map = new OopMap(framesize, 0);
+    oop_maps->add_gc_map(calls_return_pc - start, map);
+
+    RuntimeStub* stub = // codeBlob framesize is in words (not VMRegImpl::slot_size)
+      RuntimeStub::new_runtime_stub("jfr_write_checkpoint", &code, frame_complete,
+                                    (framesize >> (LogBytesPerWord - LogBytesPerInt)),
+                                    oop_maps, false);
+    return stub;
+  }
+
+#endif // INCLUDE_JFR
+
+
   // Initialization
   void generate_initial() {
     // Generates all stubs and initializes the entry points
@@ -4536,6 +4617,19 @@ class StubGenerator: public StubCodeGenerator {
     }
   }
 
+  void generate_phase1() {
+    // Continuation stubs:
+    StubRoutines::_cont_thaw          = generate_cont_thaw();
+    StubRoutines::_cont_returnBarrier = generate_cont_returnBarrier();
+    StubRoutines::_cont_returnBarrierExc = generate_cont_returnBarrier_exception();
+    StubRoutines::_cont_doYield_stub = generate_cont_doYield();
+    StubRoutines::_cont_doYield      = StubRoutines::_cont_doYield_stub == nullptr ? nullptr
+                                        : StubRoutines::_cont_doYield_stub->entry_point();
+
+    JFR_ONLY(StubRoutines::_jfr_write_checkpoint_stub = generate_jfr_write_checkpoint();)
+    JFR_ONLY(StubRoutines::_jfr_write_checkpoint = StubRoutines::_jfr_write_checkpoint_stub->entry_point();)
+  }
+
   void generate_all() {
     // Generates all stubs and initializes the entry points
 
@@ -4608,11 +4702,13 @@ class StubGenerator: public StubCodeGenerator {
   }
 
  public:
-  StubGenerator(CodeBuffer* code, bool all) : StubCodeGenerator(code) {
-    if (all) {
-      generate_all();
-    } else {
+  StubGenerator(CodeBuffer* code, int phase) : StubCodeGenerator(code) {
+    if (phase == 0) {
       generate_initial();
+    } else if (phase == 1) {
+      generate_phase1(); // stubs that must be available for the interpreter
+    } else {
+      generate_all();
     }
   }
 };