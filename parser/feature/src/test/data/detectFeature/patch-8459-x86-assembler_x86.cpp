@@ -10410,6 +10410,26 @@ void Assembler::vzeroupper_uncached() {
   }
 }
 
+void Assembler::vfpclassss(KRegister kdst, XMMRegister src, uint8_t imm8) {
+  // Encoding: EVEX.LIG.66.0F3A.W0 67 /r ib
+  assert(VM_Version::supports_evex(), "");
+  assert(VM_Version::supports_avx512dq(), "");
+  InstructionAttr attributes(AVX_128bit, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ false);
+  attributes.set_is_evex_instruction();
+  int encode = vex_prefix_and_encode(kdst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_3A, &attributes);
+  emit_int24((unsigned char)0x67, (unsigned char)(0xC0 | encode), imm8);
+}
+
+void Assembler::vfpclasssd(KRegister kdst, XMMRegister src, uint8_t imm8) {
+  // Encoding: EVEX.LIG.66.0F3A.W1 67 /r ib
+  assert(VM_Version::supports_evex(), "");
+  assert(VM_Version::supports_avx512dq(), "");
+  InstructionAttr attributes(AVX_128bit, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ false);
+  attributes.set_is_evex_instruction();
+  int encode = vex_prefix_and_encode(kdst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_3A, &attributes);
+  emit_int24((unsigned char)0x67, (unsigned char)(0xC0 | encode), imm8);
+}
+
 void Assembler::fld_x(Address adr) {
   InstructionMark im(this);
   emit_int8((unsigned char)0xDB);