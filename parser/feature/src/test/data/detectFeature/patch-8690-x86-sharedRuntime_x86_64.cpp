@@ -153,8 +153,8 @@ class RegisterSaver {
   };
 
  public:
-  static OopMap* save_live_registers(MacroAssembler* masm, int additional_frame_words, int* total_frame_words, bool save_vectors);
-  static void restore_live_registers(MacroAssembler* masm, bool restore_vectors = false);
+  static OopMap* save_live_registers(MacroAssembler* masm, int additional_frame_words, int* total_frame_words, bool save_wide_vectors);
+  static void restore_live_registers(MacroAssembler* masm, bool restore_wide_vectors = false);
 
   // Offsets into the register save area
   // Used by deoptimization when it is managing result register
@@ -175,16 +175,16 @@ class RegisterSaver {
 // "0" is assigned for rax. Thus we need to ignore -Wnonnull.
 PRAGMA_DIAG_PUSH
 PRAGMA_NONNULL_IGNORED
-OopMap* RegisterSaver::save_live_registers(MacroAssembler* masm, int additional_frame_words, int* total_frame_words, bool save_vectors) {
+OopMap* RegisterSaver::save_live_registers(MacroAssembler* masm, int additional_frame_words, int* total_frame_words, bool save_wide_vectors) {
   int off = 0;
   int num_xmm_regs = XMMRegisterImpl::available_xmm_registers();
 #if COMPILER2_OR_JVMCI
-  if (save_vectors && UseAVX == 0) {
-    save_vectors = false; // vectors larger than 16 byte long are supported only with AVX
+  if (save_wide_vectors && UseAVX == 0) {
+    save_wide_vectors = false; // vectors larger than 16 byte long are supported only with AVX
   }
-  assert(!save_vectors || MaxVectorSize <= 64, "Only up to 64 byte long vectors are supported");
+  assert(!save_wide_vectors || MaxVectorSize <= 64, "Only up to 64 byte long vectors are supported");
 #else
-  save_vectors = false; // vectors are generated only by C2 and JVMCI
+  save_wide_vectors = false; // vectors are generated only by C2 and JVMCI
 #endif
 
   // Always make the frame size 16-byte aligned, both vector and non vector stacks are always allocated
@@ -205,7 +205,7 @@ OopMap* RegisterSaver::save_live_registers(MacroAssembler* masm, int additional_
   __ push_CPU_state(); // Push a multiple of 16 bytes
 
   // push cpu state handles this on EVEX enabled targets
-  if (save_vectors) {
+  if (save_wide_vectors) {
     // Save upper half of YMM registers(0..15)
     int base_addr = XSAVE_AREA_YMM_BEGIN;
     for (int n = 0; n < 16; n++) {
@@ -234,11 +234,12 @@ OopMap* RegisterSaver::save_live_registers(MacroAssembler* masm, int additional_
     }
   } else {
     if (VM_Version::supports_evex()) {
-      // Save upper bank of ZMM registers(16..31) for double/float usage
+      // Save upper bank of XMM registers(16..31) for scalar or 16-byte vector usage
       int base_addr = XSAVE_AREA_UPPERBANK;
       off = 0;
+      int vector_len = VM_Version::supports_avx512vl() ?  Assembler::AVX_128bit : Assembler::AVX_512bit;
       for (int n = 16; n < num_xmm_regs; n++) {
-        __ movsd(Address(rsp, base_addr+(off++*64)), as_XMMRegister(n));
+        __ evmovdqul(Address(rsp, base_addr+(off++*64)), as_XMMRegister(n), vector_len);
       }
 #if COMPILER2_OR_JVMCI
       base_addr = XSAVE_AREA_OPMASK_BEGIN;
@@ -302,7 +303,7 @@ OopMap* RegisterSaver::save_live_registers(MacroAssembler* masm, int additional_
   }
 
 #if COMPILER2_OR_JVMCI
-  if (save_vectors) {
+  if (save_wide_vectors) {
     // Save upper half of YMM registers(0..15)
     off = ymm0_off;
     delta = ymm1_off - ymm0_off;
@@ -366,26 +367,26 @@ OopMap* RegisterSaver::save_live_registers(MacroAssembler* masm, int additional_
 }
 PRAGMA_DIAG_POP
 
-void RegisterSaver::restore_live_registers(MacroAssembler* masm, bool restore_vectors) {
+void RegisterSaver::restore_live_registers(MacroAssembler* masm, bool restore_wide_vectors) {
   int num_xmm_regs = XMMRegisterImpl::available_xmm_registers();
   if (frame::arg_reg_save_area_bytes != 0) {
     // Pop arg register save area
     __ addptr(rsp, frame::arg_reg_save_area_bytes);
   }
 
 #if COMPILER2_OR_JVMCI
-  if (restore_vectors) {
+  if (restore_wide_vectors) {
     assert(UseAVX > 0, "Vectors larger than 16 byte long are supported only with AVX");
     assert(MaxVectorSize <= 64, "Only up to 64 byte long vectors are supported");
   }
 #else
-  assert(!restore_vectors, "vectors are generated only by C2");
+  assert(!restore_wide_vectors, "vectors are generated only by C2");
 #endif
 
   __ vzeroupper();
 
   // On EVEX enabled targets everything is handled in pop fpu state
-  if (restore_vectors) {
+  if (restore_wide_vectors) {
     // Restore upper half of YMM registers (0..15)
     int base_addr = XSAVE_AREA_YMM_BEGIN;
     for (int n = 0; n < 16; n++) {
@@ -414,11 +415,12 @@ void RegisterSaver::restore_live_registers(MacroAssembler* masm, bool restore_ve
     }
   } else {
     if (VM_Version::supports_evex()) {
-      // Restore upper bank of ZMM registers(16..31) for double/float usage
+      // Restore upper bank of XMM registers(16..31) for scalar or 16-byte vector usage
       int base_addr = XSAVE_AREA_UPPERBANK;
       int off = 0;
+      int vector_len = VM_Version::supports_avx512vl() ?  Assembler::AVX_128bit : Assembler::AVX_512bit;
       for (int n = 16; n < num_xmm_regs; n++) {
-        __ movsd(as_XMMRegister(n), Address(rsp, base_addr+(off++*64)));
+        __ evmovdqul(as_XMMRegister(n), Address(rsp, base_addr+(off++*64)), vector_len);
       }
 #if COMPILER2_OR_JVMCI
       base_addr = XSAVE_AREA_OPMASK_BEGIN;
@@ -2456,7 +2458,7 @@ void SharedRuntime::generate_deopt_blob() {
   // Prolog for non exception case!
 
   // Save everything in sight.
-  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_vectors*/ true);
+  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_wide_vectors*/ true);
 
   // Normal deoptimization.  Save exec mode for unpack_frames.
   __ movl(r14, Deoptimization::Unpack_deopt); // callee-saved
@@ -2474,7 +2476,7 @@ void SharedRuntime::generate_deopt_blob() {
   // return address is the pc describes what bci to do re-execute at
 
   // No need to update map as each call to save_live_registers will produce identical oopmap
-  (void) RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_vectors*/ true);
+  (void) RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_wide_vectors*/ true);
 
   __ movl(r14, Deoptimization::Unpack_reexecute); // callee-saved
   __ jmp(cont);
@@ -2493,7 +2495,7 @@ void SharedRuntime::generate_deopt_blob() {
     uncommon_trap_offset = __ pc() - start;
 
     // Save everything in sight.
-    RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_vectors*/ true);
+    RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_wide_vectors*/ true);
     // fetch_unroll_info needs to call last_java_frame()
     __ set_last_Java_frame(noreg, noreg, NULL);
 
@@ -2540,7 +2542,7 @@ void SharedRuntime::generate_deopt_blob() {
   __ push(0);
 
   // Save everything in sight.
-  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_vectors*/ true);
+  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_wide_vectors*/ true);
 
   // Now it is safe to overwrite any register
 
@@ -2971,7 +2973,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
   address call_pc = NULL;
   int frame_size_in_words;
   bool cause_return = (poll_type == POLL_AT_RETURN);
-  bool save_vectors = (poll_type == POLL_AT_VECTOR_LOOP);
+  bool save_wide_vectors = (poll_type == POLL_AT_VECTOR_LOOP);
 
   if (UseRTMLocking) {
     // Abort RTM transaction before calling runtime
@@ -2986,7 +2988,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
   }
 
   // Save registers, fpu state, and flags
-  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, save_vectors);
+  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, save_wide_vectors);
 
   // The following is basically a call_VM.  However, we need the precise
   // address of the call in order to generate an oopmap. Hence, we do all the
@@ -3025,7 +3027,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
 
   // Exception pending
 
-  RegisterSaver::restore_live_registers(masm, save_vectors);
+  RegisterSaver::restore_live_registers(masm, save_wide_vectors);
 
   __ jump(RuntimeAddress(StubRoutines::forward_exception_entry()));
 
@@ -3098,7 +3100,7 @@ SafepointBlob* SharedRuntime::generate_handler_blob(address call_ptr, int poll_t
 
   __ bind(no_adjust);
   // Normal exit, restore registers and exit.
-  RegisterSaver::restore_live_registers(masm, save_vectors);
+  RegisterSaver::restore_live_registers(masm, save_wide_vectors);
   __ ret(0);
 
 #ifdef ASSERT
@@ -3138,7 +3140,7 @@ RuntimeStub* SharedRuntime::generate_resolve_blob(address destination, const cha
   int start = __ offset();
 
   // No need to save vector registers since they are caller-saved anyway.
-  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_vectors*/ false);
+  map = RegisterSaver::save_live_registers(masm, 0, &frame_size_in_words, /*save_wide_vectors*/ false);
 
   int frame_complete = __ offset();
 