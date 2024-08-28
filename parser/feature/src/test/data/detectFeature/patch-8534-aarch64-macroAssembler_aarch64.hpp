@@ -1095,8 +1095,19 @@ class MacroAssembler: public Assembler {
     return CodeCache::max_distance_to_non_nmethod() > branch_range;
   }
 
-  // Jumps that can reach anywhere in the code cache.
-  // Trashes tmp.
+  // Far_call and far_jump generate a call of/jump to the provided address.
+  // The address must be inside the code cache.
+  // Supported entry.rspec():
+  // - relocInfo::external_word_type
+  // - relocInfo::runtime_call_type
+  // - relocInfo::none
+  // If the distance to the address can exceed the branch range
+  // (128M for the release build, 2M for the debug build; see branch_range definition)
+  // for direct calls(BL)/jumps(B), a call(BLR)/jump(BR) with the address put in
+  // the tmp register is generated. Instructions putting the address in the tmp register
+  // are embedded at a call site. The tmp register is invalidated.
+  // This differs from trampoline_call which puts additional code (trampoline) including
+  // BR into the stub code section and a BL to the trampoline at a call site.
   void far_call(Address entry, CodeBuffer *cbuf = NULL, Register tmp = rscratch1);
   int far_jump(Address entry, CodeBuffer *cbuf = NULL, Register tmp = rscratch1);
 