@@ -588,6 +588,30 @@ class StubGenerator: public StubCodeGenerator {
     return start;
   }
 
+  address generate_count_leading_zeros_lut(const char *stub_name) {
+    __ align64();
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data(0x02020304, relocInfo::none, 0);
+    __ emit_data(0x01010101, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x02020304, relocInfo::none, 0);
+    __ emit_data(0x01010101, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x02020304, relocInfo::none, 0);
+    __ emit_data(0x01010101, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x02020304, relocInfo::none, 0);
+    __ emit_data(0x01010101, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    __ emit_data(0x00000000, relocInfo::none, 0);
+    return start;
+  }
+
+
   address generate_popcount_avx_lut(const char *stub_name) {
     __ align64();
     StubCodeMark mark(this, "StubRoutines", stub_name);
@@ -635,6 +659,98 @@ class StubGenerator: public StubCodeGenerator {
     return start;
   }
 
+  address generate_vector_reverse_bit_lut(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data(0x0C040800, relocInfo::none, 0);
+    __ emit_data(0x0E060A02, relocInfo::none, 0);
+    __ emit_data(0x0D050901, relocInfo::none, 0);
+    __ emit_data(0x0F070B03, relocInfo::none, 0);
+    __ emit_data(0x0C040800, relocInfo::none, 0);
+    __ emit_data(0x0E060A02, relocInfo::none, 0);
+    __ emit_data(0x0D050901, relocInfo::none, 0);
+    __ emit_data(0x0F070B03, relocInfo::none, 0);
+    __ emit_data(0x0C040800, relocInfo::none, 0);
+    __ emit_data(0x0E060A02, relocInfo::none, 0);
+    __ emit_data(0x0D050901, relocInfo::none, 0);
+    __ emit_data(0x0F070B03, relocInfo::none, 0);
+    __ emit_data(0x0C040800, relocInfo::none, 0);
+    __ emit_data(0x0E060A02, relocInfo::none, 0);
+    __ emit_data(0x0D050901, relocInfo::none, 0);
+    __ emit_data(0x0F070B03, relocInfo::none, 0);
+    return start;
+  }
+
+  address generate_vector_reverse_byte_perm_mask_long(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    return start;
+  }
+
+  address generate_vector_reverse_byte_perm_mask_int(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    __ emit_data(0x00010203, relocInfo::none, 0);
+    __ emit_data(0x04050607, relocInfo::none, 0);
+    __ emit_data(0x08090A0B, relocInfo::none, 0);
+    __ emit_data(0x0C0D0E0F, relocInfo::none, 0);
+    return start;
+  }
+
+  address generate_vector_reverse_byte_perm_mask_short(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data(0x02030001, relocInfo::none, 0);
+    __ emit_data(0x06070405, relocInfo::none, 0);
+    __ emit_data(0x0A0B0809, relocInfo::none, 0);
+    __ emit_data(0x0E0F0C0D, relocInfo::none, 0);
+    __ emit_data(0x02030001, relocInfo::none, 0);
+    __ emit_data(0x06070405, relocInfo::none, 0);
+    __ emit_data(0x0A0B0809, relocInfo::none, 0);
+    __ emit_data(0x0E0F0C0D, relocInfo::none, 0);
+    __ emit_data(0x02030001, relocInfo::none, 0);
+    __ emit_data(0x06070405, relocInfo::none, 0);
+    __ emit_data(0x0A0B0809, relocInfo::none, 0);
+    __ emit_data(0x0E0F0C0D, relocInfo::none, 0);
+    __ emit_data(0x02030001, relocInfo::none, 0);
+    __ emit_data(0x06070405, relocInfo::none, 0);
+    __ emit_data(0x0A0B0809, relocInfo::none, 0);
+    __ emit_data(0x0E0F0C0D, relocInfo::none, 0);
+    return start;
+  }
+
   address generate_vector_byte_shuffle_mask(const char *stub_name) {
     __ align(CodeEntryAlignment);
     StubCodeMark mark(this, "StubRoutines", stub_name);
@@ -4090,8 +4206,13 @@ class StubGenerator: public StubCodeGenerator {
     StubRoutines::x86::_vector_all_bits_set = generate_vector_mask("vector_all_bits_set", 0xFFFFFFFF);
     StubRoutines::x86::_vector_int_mask_cmp_bits = generate_vector_mask("vector_int_mask_cmp_bits", 0x00000001);
     StubRoutines::x86::_vector_iota_indices = generate_iota_indices("iota_indices");
+    StubRoutines::x86::_vector_count_leading_zeros_lut = generate_count_leading_zeros_lut("count_leading_zeros_lut");
+    StubRoutines::x86::_vector_reverse_bit_lut = generate_vector_reverse_bit_lut("reverse_bit_lut");
+    StubRoutines::x86::_vector_reverse_byte_perm_mask_long = generate_vector_reverse_byte_perm_mask_long("perm_mask_long");
+    StubRoutines::x86::_vector_reverse_byte_perm_mask_int = generate_vector_reverse_byte_perm_mask_int("perm_mask_int");
+    StubRoutines::x86::_vector_reverse_byte_perm_mask_short = generate_vector_reverse_byte_perm_mask_short("perm_mask_short");
 
-    if (UsePopCountInstruction && VM_Version::supports_avx2() && !VM_Version::supports_avx512_vpopcntdq()) {
+    if (VM_Version::supports_avx2() && !VM_Version::supports_avx512_vpopcntdq()) {
       // lut implementation influenced by counting 1s algorithm from section 5-1 of Hackers' Delight.
       StubRoutines::x86::_vector_popcount_lut = generate_popcount_avx_lut("popcount_lut");
     }