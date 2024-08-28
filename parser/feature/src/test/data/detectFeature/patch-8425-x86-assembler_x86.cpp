@@ -4838,18 +4838,54 @@ void Assembler::popcntl(Register dst, Register src) {
   emit_int24(0x0F, (unsigned char)0xB8, (0xC0 | encode));
 }
 
-void Assembler::vpopcntd(XMMRegister dst, XMMRegister src, int vector_len) {
+void Assembler::evpopcntb(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512_bitalg(), "must support avx512bitalg feature");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16(0x54, (0xC0 | encode));
+}
+
+void Assembler::evpopcntw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512_bitalg(), "must support avx512bitalg feature");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16(0x54, (0xC0 | encode));
+}
+
+void Assembler::evpopcntd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
   assert(VM_Version::supports_avx512_vpopcntdq(), "must support vpopcntdq feature");
-  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
   attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
   int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
   emit_int16(0x55, (0xC0 | encode));
 }
 
-void Assembler::vpopcntq(XMMRegister dst, XMMRegister src, int vector_len) {
+void Assembler::evpopcntq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
   assert(VM_Version::supports_avx512_vpopcntdq(), "must support vpopcntdq feature");
-  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
   attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
   int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
   emit_int16(0x55, (0xC0 | encode));
 }
@@ -7894,6 +7930,32 @@ void Assembler::evprorvq(XMMRegister dst, XMMRegister src, XMMRegister shift, in
   emit_int16(0x14, (unsigned char)(0xC0 | encode));
 }
 
+void Assembler::evplzcntd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512cd(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false,/* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16(0x44, (0xC0 | encode));
+}
+
+void Assembler::evplzcntq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512cd(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true,/* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16(0x44, (0xC0 | encode));
+}
+
 void Assembler::vpternlogd(XMMRegister dst, int imm8, XMMRegister src2, XMMRegister src3, int vector_len) {
   assert(VM_Version::supports_evex(), "requires EVEX support");
   assert(vector_len == Assembler::AVX_512bit || VM_Version::supports_avx512vl(), "requires VL support");
@@ -7930,6 +7992,84 @@ void Assembler::vpternlogq(XMMRegister dst, int imm8, XMMRegister src2, XMMRegis
   emit_int8(imm8);
 }
 
+void Assembler::evexpandps(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x88, (0xC0 | encode));
+}
+
+void Assembler::evexpandpd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x88, (0xC0 | encode));
+}
+
+void Assembler::evpexpandb(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512_vbmi2(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16(0x62, (0xC0 | encode));
+}
+
+void Assembler::evpexpandw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512_vbmi2(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16(0x62, (0xC0 | encode));
+}
+
+void Assembler::evpexpandd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x89, (0xC0 | encode));
+}
+
+void Assembler::evpexpandq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false,/* uses_vl */ true);
+  attributes.set_is_evex_instruction();
+  attributes.set_embedded_opmask_register_specifier(mask);
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x89, (0xC0 | encode));
+}
+
 // vinserti forms
 
 void Assembler::vinserti128(XMMRegister dst, XMMRegister nds, XMMRegister src, uint8_t imm8) {
@@ -7973,7 +8113,7 @@ void Assembler::vinserti32x4(XMMRegister dst, XMMRegister nds, XMMRegister src,
 }
 
 void Assembler::vinserti32x4(XMMRegister dst, XMMRegister nds, Address src, uint8_t imm8) {
-  assert(VM_Version::supports_avx(), "");
+  assert(VM_Version::supports_evex(), "");
   assert(dst != xnoreg, "sanity");
   assert(imm8 <= 0x03, "imm8: %u", imm8);
   InstructionMark im(this);
@@ -8032,7 +8172,7 @@ void Assembler::vinsertf128(XMMRegister dst, XMMRegister nds, Address src, uint8
 }
 
 void Assembler::vinsertf32x4(XMMRegister dst, XMMRegister nds, XMMRegister src, uint8_t imm8) {
-  assert(VM_Version::supports_avx2(), "");
+  assert(VM_Version::supports_evex(), "");
   assert(imm8 <= 0x03, "imm8: %u", imm8);
   InstructionAttr attributes(AVX_512bit, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
   int encode = vex_prefix_and_encode(dst->encoding(), nds->encoding(), src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_3A, &attributes);
@@ -8045,7 +8185,7 @@ void Assembler::vinsertf32x4(XMMRegister dst, XMMRegister nds, XMMRegister src,
 }
 
 void Assembler::vinsertf32x4(XMMRegister dst, XMMRegister nds, Address src, uint8_t imm8) {
-  assert(VM_Version::supports_avx(), "");
+  assert(VM_Version::supports_evex(), "");
   assert(dst != xnoreg, "sanity");
   assert(imm8 <= 0x03, "imm8: %u", imm8);
   InstructionMark im(this);
@@ -8346,6 +8486,20 @@ void Assembler::vpsadbw(XMMRegister dst, XMMRegister nds, XMMRegister src, int v
   emit_int16((unsigned char)0xF6, (0xC0 | encode));
 }
 
+void Assembler::vpunpckhwd(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len) {
+  assert(UseAVX > 0, "requires some form of AVX");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
+  int encode = vex_prefix_and_encode(dst->encoding(), nds->encoding(), src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F, &attributes);
+  emit_int16(0x69, (0xC0 | encode));
+}
+
+void Assembler::vpunpcklwd(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len) {
+  assert(UseAVX > 0, "requires some form of AVX");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
+  int encode = vex_prefix_and_encode(dst->encoding(), nds->encoding(), src->encoding(), VEX_SIMD_66, VEX_OPCODE_0F, &attributes);
+  emit_int16(0x61, (0xC0 | encode));
+}
+
 void Assembler::vpunpckhdq(XMMRegister dst, XMMRegister nds, XMMRegister src, int vector_len) {
   assert(UseAVX > 0, "requires some form of AVX");
   InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
@@ -9862,6 +10016,14 @@ void Assembler::evpternlogq(XMMRegister dst, int imm8, KRegister mask, XMMRegist
   emit_int8(imm8);
 }
 
+void Assembler::vgf2p8affineqb(XMMRegister dst, XMMRegister src2, XMMRegister src3, int imm8, int vector_len) {
+  assert(VM_Version::supports_gfni(), "requires GFNI support");
+  assert(VM_Version::supports_sse(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ true, /* uses_vl */ true);
+  int encode = vex_prefix_and_encode(dst->encoding(), src2->encoding(), src3->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_3A, &attributes);
+  emit_int24((unsigned char)0xCE, (unsigned char)(0xC0 | encode), imm8);
+}
+
 // duplicate 4-byte integer data from src into programmed locations in dest : requires AVX512VL
 void Assembler::vpbroadcastd(XMMRegister dst, XMMRegister src, int vector_len) {
   assert(UseAVX >= 2, "");
@@ -11555,6 +11717,85 @@ void Assembler::evpmovm2b(XMMRegister dst, KRegister src, int vector_len) {
   int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_F3, VEX_OPCODE_0F_38, &attributes);
   emit_int16(0x28, (0xC0 | encode));
 }
+
+void Assembler::evpcompressb(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512_vbmi2(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(src->encoding(), 0, dst->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x63, (0xC0 | encode));
+}
+
+void Assembler::evpcompressw(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512_vbmi2(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(src->encoding(), 0, dst->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x63, (0xC0 | encode));
+}
+
+void Assembler::evpcompressd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(src->encoding(), 0, dst->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x8B, (0xC0 | encode));
+}
+
+void Assembler::evpcompressq(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(src->encoding(), 0, dst->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x8B, (0xC0 | encode));
+}
+
+void Assembler::evcompressps(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(src->encoding(), 0, dst->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x8A, (0xC0 | encode));
+}
+
+void Assembler::evcompresspd(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_evex(), "");
+  assert(vector_len == AVX_512bit || VM_Version::supports_avx512vl(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
+  attributes.set_is_evex_instruction();
+  if (merge) {
+    attributes.reset_is_clear_context();
+  }
+  int encode = vex_prefix_and_encode(src->encoding(), 0, dst->encoding(), VEX_SIMD_66, VEX_OPCODE_0F_38, &attributes);
+  emit_int16((unsigned char)0x8A, (0xC0 | encode));
+}
+
 #ifndef _LP64
 
 void Assembler::incl(Register dst) {