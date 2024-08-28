@@ -2959,6 +2959,85 @@ class StubGenerator: public StubCodeGenerator {
     return stub->entry_point();
   }
 
+  RuntimeStub* generate_cont_doYield() {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+  address generate_cont_thaw(const char* label, Continuation::thaw_kind kind) {
+    if (!Continuations::enabled()) return nullptr;
+    Unimplemented();
+    return nullptr;
+  }
+
+  address generate_cont_thaw() {
+    return generate_cont_thaw("Cont thaw", Continuation::thaw_top);
+  }
+
+  address generate_cont_returnBarrier() {
+    return generate_cont_thaw("Cont thaw return barrier", Continuation::thaw_return_barrier);
+  }
+
+  address generate_cont_returnBarrier_exception() {
+    return generate_cont_thaw("Cont thaw return barrier exception", Continuation::thaw_return_barrier_exception);
+  }
+
+#if INCLUDE_JFR
+
+  // For c2: c_rarg0 is junk, call to runtime to write a checkpoint.
+  // It returns a jobject handle to the event writer.
+  // The handle is dereferenced and the return value is the event writer oop.
+  static RuntimeStub* generate_jfr_write_checkpoint() {
+    enum layout {
+      r1_off,
+      r2_off,
+      return_off,
+      framesize // inclusive of return address
+    };
+
+    CodeBuffer code("jfr_write_checkpoint", 512, 64);
+    MacroAssembler* masm = new MacroAssembler(&code);
+
+    address start = __ pc();
+    __ raw_push(R1, R2, LR);
+    address the_pc = __ pc();
+
+    int frame_complete = the_pc - start;
+
+    __ set_last_Java_frame(SP, FP, true, Rtemp);
+    __ mov(c_rarg0, Rthread);
+    __ call_VM_leaf(CAST_FROM_FN_PTR(address, JfrIntrinsicSupport::write_checkpoint), c_rarg0);
+    __ reset_last_Java_frame(Rtemp);
+
+    // R0 is jobject handle result, unpack and process it through a barrier.
+    Label L_null_jobject;
+    __ cbz(R0, L_null_jobject);
+
+    BarrierSetAssembler* bs = BarrierSet::barrier_set()->barrier_set_assembler();
+    bs->load_at(masm, ACCESS_READ | IN_NATIVE, T_OBJECT, R0, Address(R0, 0), Rtemp, R1, R2);
+
+    __ bind(L_null_jobject);
+
+    __ raw_pop(R1, R2, LR);
+    __ ret();
+
+    OopMapSet* oop_maps = new OopMapSet();
+    OopMap* map = new OopMap(framesize, 1);
+    oop_maps->add_gc_map(frame_complete, map);
+
+    RuntimeStub* stub =
+      RuntimeStub::new_runtime_stub(code.name(),
+                                    &code,
+                                    frame_complete,
+                                    (framesize >> (LogBytesPerWord - LogBytesPerInt)),
+                                    oop_maps,
+                                    false);
+    return stub;
+  }
+
+#endif // INCLUDE_JFR
+
   //---------------------------------------------------------------------------
   // Initialization
 
@@ -2991,6 +3070,18 @@ class StubGenerator: public StubCodeGenerator {
 
   }
 
+  void generate_phase1() {
+    // Continuation stubs:
+    StubRoutines::_cont_thaw          = generate_cont_thaw();
+    StubRoutines::_cont_returnBarrier = generate_cont_returnBarrier();
+    StubRoutines::_cont_returnBarrierExc = generate_cont_returnBarrier_exception();
+    StubRoutines::_cont_doYield_stub = generate_cont_doYield();
+    StubRoutines::_cont_doYield      = StubRoutines::_cont_doYield_stub == nullptr ? nullptr
+                                                                                   : StubRoutines::_cont_doYield_stub->entry_point();
+
+    JFR_ONLY(StubRoutines::_jfr_write_checkpoint_stub = generate_jfr_write_checkpoint();)
+    JFR_ONLY(StubRoutines::_jfr_write_checkpoint = StubRoutines::_jfr_write_checkpoint_stub->entry_point();)
+  }
 
   void generate_all() {
     // Generates all stubs and initializes the entry points
@@ -3029,11 +3120,13 @@ class StubGenerator: public StubCodeGenerator {
 
 
  public:
-  StubGenerator(CodeBuffer* code, bool all) : StubCodeGenerator(code) {
-    if (all) {
-      generate_all();
-    } else {
+  StubGenerator(CodeBuffer* code, int phase) : StubCodeGenerator(code) {
+    if (phase == 0) {
       generate_initial();
+    } else if (phase == 1) {
+      generate_phase1();
+    } else {
+      generate_all();
     }
   }
 }; // end class declaration