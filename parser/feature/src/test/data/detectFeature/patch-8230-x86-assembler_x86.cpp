@@ -3021,53 +3021,27 @@ void Assembler::vmovdqu(Address dst, XMMRegister src) {
 }
 
 // Move Unaligned EVEX enabled Vector (programmable : 8,16,32,64)
-void Assembler::evmovdqub(XMMRegister dst, XMMRegister src, bool merge, int vector_len) {
-  assert(VM_Version::supports_evex(), "");
-  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ true, /* uses_vl */ true);
+void Assembler::evmovdqub(XMMRegister dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
+  assert(VM_Version::supports_avx512vlbw(), "");
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ false, /* uses_vl */ true);
+  attributes.set_embedded_opmask_register_specifier(mask);
   attributes.set_is_evex_instruction();
   if (merge) {
     attributes.reset_is_clear_context();
   }
-  int prefix = (_legacy_mode_bw) ? VEX_SIMD_F2 : VEX_SIMD_F3;
-  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), (Assembler::VexSimdPrefix)prefix, VEX_OPCODE_0F, &attributes);
+  int encode = vex_prefix_and_encode(dst->encoding(), 0, src->encoding(), VEX_SIMD_F2, VEX_OPCODE_0F, &attributes);
   emit_int16(0x6F, (0xC0 | encode));
 }
 
-void Assembler::evmovdqub(XMMRegister dst, Address src, bool merge, int vector_len) {
-  assert(VM_Version::supports_evex(), "");
-  InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ true, /* uses_vl */ true);
-  int prefix = (_legacy_mode_bw) ? VEX_SIMD_F2 : VEX_SIMD_F3;
-  attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
-  attributes.set_is_evex_instruction();
-  if (merge) {
-    attributes.reset_is_clear_context();
-  }
-  vex_prefix(src, 0, dst->encoding(), (Assembler::VexSimdPrefix)prefix, VEX_OPCODE_0F, &attributes);
-  emit_int8(0x6F);
-  emit_operand(dst, src);
-}
-
-void Assembler::evmovdqub(Address dst, XMMRegister src, bool merge, int vector_len) {
-  assert(VM_Version::supports_evex(), "");
-  assert(src != xnoreg, "sanity");
-  InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ true, /* uses_vl */ true);
-  int prefix = (_legacy_mode_bw) ? VEX_SIMD_F2 : VEX_SIMD_F3;
-  attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
-  attributes.set_is_evex_instruction();
-  if (merge) {
-    attributes.reset_is_clear_context();
-  }
-  vex_prefix(dst, 0, src->encoding(), (Assembler::VexSimdPrefix)prefix, VEX_OPCODE_0F, &attributes);
-  emit_int8(0x7F);
-  emit_operand(src, dst);
+void Assembler::evmovdqub(XMMRegister dst, XMMRegister src, int vector_len) {
+  // Unmasked instruction
+  evmovdqub(dst, k0, src, /*merge*/ false, vector_len);
 }
 
 void Assembler::evmovdqub(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) {
   assert(VM_Version::supports_avx512vlbw(), "");
   InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ false, /* uses_vl */ true);
   attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
   attributes.set_embedded_opmask_register_specifier(mask);
   attributes.set_is_evex_instruction();
@@ -3079,11 +3053,16 @@ void Assembler::evmovdqub(XMMRegister dst, KRegister mask, Address src, bool mer
   emit_operand(dst, src);
 }
 
+void Assembler::evmovdqub(XMMRegister dst, Address src, int vector_len) {
+  // Unmasked instruction
+  evmovdqub(dst, k0, src, /*merge*/ false, vector_len);
+}
+
 void Assembler::evmovdqub(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
   assert(VM_Version::supports_avx512vlbw(), "");
   assert(src != xnoreg, "sanity");
   InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  InstructionAttr attributes(vector_len, /* vex_w */ false, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ false, /* uses_vl */ true);
   attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
   attributes.set_embedded_opmask_register_specifier(mask);
   attributes.set_is_evex_instruction();
@@ -3095,25 +3074,15 @@ void Assembler::evmovdqub(Address dst, KRegister mask, XMMRegister src, bool mer
   emit_operand(src, dst);
 }
 
-void Assembler::evmovdquw(XMMRegister dst, Address src, bool merge, int vector_len) {
-  assert(VM_Version::supports_evex(), "");
-  InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ true, /* uses_vl */ true);
-  attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
-  attributes.set_is_evex_instruction();
-  if (merge) {
-    attributes.reset_is_clear_context();
-  }
-  int prefix = (_legacy_mode_bw) ? VEX_SIMD_F2 : VEX_SIMD_F3;
-  vex_prefix(src, 0, dst->encoding(), (Assembler::VexSimdPrefix)prefix, VEX_OPCODE_0F, &attributes);
-  emit_int8(0x6F);
-  emit_operand(dst, src);
+void Assembler::evmovdquw(XMMRegister dst, Address src, int vector_len) {
+  // Unmasked instruction
+  evmovdquw(dst, k0, src, /*merge*/ false, vector_len);
 }
 
 void Assembler::evmovdquw(XMMRegister dst, KRegister mask, Address src, bool merge, int vector_len) {
   assert(VM_Version::supports_avx512vlbw(), "");
   InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ false, /* uses_vl */ true);
   attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
   attributes.set_embedded_opmask_register_specifier(mask);
   attributes.set_is_evex_instruction();
@@ -3125,27 +3094,16 @@ void Assembler::evmovdquw(XMMRegister dst, KRegister mask, Address src, bool mer
   emit_operand(dst, src);
 }
 
-void Assembler::evmovdquw(Address dst, XMMRegister src, bool merge, int vector_len) {
-  assert(VM_Version::supports_evex(), "");
-  assert(src != xnoreg, "sanity");
-  InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ true, /* uses_vl */ true);
-  attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
-  attributes.set_is_evex_instruction();
-  if (merge) {
-    attributes.reset_is_clear_context();
-  }
-  int prefix = (_legacy_mode_bw) ? VEX_SIMD_F2 : VEX_SIMD_F3;
-  vex_prefix(dst, 0, src->encoding(), (Assembler::VexSimdPrefix)prefix, VEX_OPCODE_0F, &attributes);
-  emit_int8(0x7F);
-  emit_operand(src, dst);
+void Assembler::evmovdquw(Address dst, XMMRegister src, int vector_len) {
+  // Unmasked instruction
+  evmovdquw(dst, k0, src, /*merge*/ false, vector_len);
 }
 
 void Assembler::evmovdquw(Address dst, KRegister mask, XMMRegister src, bool merge, int vector_len) {
   assert(VM_Version::supports_avx512vlbw(), "");
   assert(src != xnoreg, "sanity");
   InstructionMark im(this);
-  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ false, /* no_mask_reg */ false, /* uses_vl */ true);
+  InstructionAttr attributes(vector_len, /* vex_w */ true, /* legacy_mode */ _legacy_mode_bw, /* no_mask_reg */ false, /* uses_vl */ true);
   attributes.set_address_attributes(/* tuple_type */ EVEX_FVM, /* input_size_in_bits */ EVEX_NObit);
   attributes.set_embedded_opmask_register_specifier(mask);
   attributes.set_is_evex_instruction();