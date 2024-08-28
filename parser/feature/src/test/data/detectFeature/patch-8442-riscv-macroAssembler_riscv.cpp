@@ -379,7 +379,7 @@ void MacroAssembler::_verify_oop(Register reg, const char* s, const char* file,
 
   mv(c_rarg0, reg); // c_rarg0 : x10
   // The length of the instruction sequence emitted should be independent
-  // of the values of the local char buffer address so that the size of mach
+  // of the value of the local char buffer address so that the size of mach
   // nodes for scratch emit and normal emit matches.
   mv(t0, (address)b);
 
@@ -418,7 +418,7 @@ void MacroAssembler::_verify_oop_addr(Address addr, const char* s, const char* f
   }
 
   // The length of the instruction sequence emitted should be independent
-  // of the values of the local char buffer address so that the size of mach
+  // of the value of the local char buffer address so that the size of mach
   // nodes for scratch emit and normal emit matches.
   mv(t0, (address)b);
 
@@ -535,17 +535,9 @@ void MacroAssembler::resolve_jobject(Register value, Register thread, Register t
 }
 
 void MacroAssembler::stop(const char* msg) {
-  address ip = pc();
-  pusha();
-  // The length of the instruction sequence emitted should be independent
-  // of the values of msg and ip so that the size of mach nodes for scratch
-  // emit and normal emit matches.
-  mv(c_rarg0, (address)msg);
-  mv(c_rarg1, (address)ip);
-  mv(c_rarg2, sp);
-  mv(c_rarg3, CAST_FROM_FN_PTR(address, MacroAssembler::debug64));
-  jalr(c_rarg3);
-  ebreak();
+  BLOCK_COMMENT(msg);
+  illegal_instruction(Assembler::csr::time);
+  emit_int64((uintptr_t)msg);
 }
 
 void MacroAssembler::unimplemented(const char* what) {
@@ -1119,18 +1111,6 @@ void MacroAssembler::pop_call_clobbered_registers_except(RegSet exclude) {
   pop_reg(RegSet::of(x7) + RegSet::range(x10, x17) + RegSet::range(x28, x31) - exclude, sp);
 }
 
-// Push all the integer registers, except zr(x0) & sp(x2) & gp(x3) & tp(x4).
-void MacroAssembler::pusha() {
-  CompressibleRegion cr(this);
-  push_reg(0xffffffe2, sp);
-}
-
-// Pop all the integer registers, except zr(x0) & sp(x2) & gp(x3) & tp(x4).
-void MacroAssembler::popa() {
-  CompressibleRegion cr(this);
-  pop_reg(0xffffffe2, sp);
-}
-
 void MacroAssembler::push_CPU_state(bool save_vectors, int vector_size_in_bytes) {
   CompressibleRegion cr(this);
   // integer registers, except zr(x0) & ra(x1) & sp(x2) & gp(x3) & tp(x4)
@@ -2936,9 +2916,7 @@ address MacroAssembler::emit_trampoline_stub(int insts_call_instruction_offset,
   // with the call instruction at insts_call_instruction_offset in the
   // instructions code-section.
 
-  // make sure 4 byte aligned here, so that the destination address would be
-  // 8 byte aligned after 3 instructions
-  // when we reach here we may get a 2-byte alignment so need to align it
+  // Make sure the address of destination 8-byte aligned after 3 instructions.
   align(wordSize, NativeCallTrampolineStub::data_offset);
 
   relocate(trampoline_stub_Relocation::spec(code()->insts()->start() +