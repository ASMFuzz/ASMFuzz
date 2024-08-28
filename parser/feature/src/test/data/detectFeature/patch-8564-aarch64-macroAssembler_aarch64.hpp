@@ -1113,8 +1113,75 @@ class MacroAssembler: public Assembler {
 #endif
 
 public:
-  // Calls
-
+  // AArch64 OpenJDK uses four different types of calls:
+  //   - direct call: bl pc_relative_offset
+  //     This is the shortest and the fastest, but the offset has the range:
+  //     +/-128MB for the release build, +/-2MB for the debug build.
+  //
+  //   - far call: adrp reg, pc_relative_offset; add; bl reg
+  //     This is longer than a direct call. The offset has
+  //     the range +/-4GB. As the code cache size is limited to 4GB,
+  //     far calls can reach anywhere in the code cache. If a jump is
+  //     needed rather than a call, a far jump 'b reg' can be used instead.
+  //     All instructions are embedded at a call site.
+  //
+  //   - trampoline call:
+  //     This is only available in C1/C2-generated code (nmethod). It is a combination
+  //     of a direct call, which is used if the destination of a call is in range,
+  //     and a register-indirect call. It has the advantages of reaching anywhere in
+  //     the AArch64 address space and being patchable at runtime when the generated
+  //     code is being executed by other threads.
+  //
+  //     [Main code section]
+  //       bl trampoline
+  //     [Stub code section]
+  //     trampoline:
+  //       ldr reg, pc + 8
+  //       br reg
+  //       <64-bit destination address>
+  //
+  //     If the destination is in range when the generated code is moved to the code
+  //     cache, 'bl trampoline' is replaced with 'bl destination' and the trampoline
+  //     is not used.
+  //     The optimization does not remove the trampoline from the stub section.
+  //     This is necessary because the trampoline may well be redirected later when
+  //     code is patched, and the new destination may not be reachable by a simple BR
+  //     instruction.
+  //
+  //   - indirect call: move reg, address; blr reg
+  //     This too can reach anywhere in the address space, but it cannot be
+  //     patched while code is running, so it must only be modified at a safepoint.
+  //     This form of call is most suitable for targets at fixed addresses, which
+  //     will never be patched.
+  //
+  // The patching we do conforms to the "Concurrent modification and
+  // execution of instructions" section of the Arm Architectural
+  // Reference Manual, which only allows B, BL, BRK, HVC, ISB, NOP, SMC,
+  // or SVC instructions to be modified while another thread is
+  // executing them.
+  //
+  // To patch a trampoline call when the BL can't reach, we first modify
+  // the 64-bit destination address in the trampoline, then modify the
+  // BL to point to the trampoline, then flush the instruction cache to
+  // broadcast the change to all executing threads. See
+  // NativeCall::set_destination_mt_safe for the details.
+  //
+  // There is a benign race in that the other thread might observe the
+  // modified BL before it observes the modified 64-bit destination
+  // address. That does not matter because the destination method has been
+  // invalidated, so there will be a trap at its start.
+  // For this to work, the destination address in the trampoline is
+  // always updated, even if we're not using the trampoline.
+
+  // Emit a direct call if the entry address will always be in range,
+  // otherwise a trampoline call.
+  // Supported entry.rspec():
+  // - relocInfo::runtime_call_type
+  // - relocInfo::opt_virtual_call_type
+  // - relocInfo::static_call_type
+  // - relocInfo::virtual_call_type
+  //
+  // Return: NULL if CodeCache is full.
   address trampoline_call(Address entry, CodeBuffer* cbuf = NULL) { return trampoline_call1(entry, cbuf, true); }
   address trampoline_call1(Address entry, CodeBuffer* cbuf, bool check_emit_size = true);
 
@@ -1127,19 +1194,17 @@ class MacroAssembler: public Assembler {
     return CodeCache::max_distance_to_non_nmethod() > branch_range;
   }
 
-  // Far_call and far_jump generate a call of/jump to the provided address.
+  // Emit a direct call/jump if the entry address will always be in range,
+  // otherwise a far call/jump.
   // The address must be inside the code cache.
   // Supported entry.rspec():
   // - relocInfo::external_word_type
   // - relocInfo::runtime_call_type
   // - relocInfo::none
-  // If the distance to the address can exceed the branch range
-  // (128M for the release build, 2M for the debug build; see branch_range definition)
-  // for direct calls(BL)/jumps(B), a call(BLR)/jump(BR) with the address put in
-  // the tmp register is generated. Instructions putting the address in the tmp register
-  // are embedded at a call site. The tmp register is invalidated.
-  // This differs from trampoline_call which puts additional code (trampoline) including
-  // BR into the stub code section and a BL to the trampoline at a call site.
+  // In the case of a far call/jump, the entry address is put in the tmp register.
+  // The tmp register is invalidated.
+  //
+  // Far_jump returns the amount of the emitted code.
   void far_call(Address entry, CodeBuffer *cbuf = NULL, Register tmp = rscratch1);
   int far_jump(Address entry, CodeBuffer *cbuf = NULL, Register tmp = rscratch1);
 