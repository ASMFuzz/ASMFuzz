@@ -807,6 +807,21 @@ class StubGenerator: public StubCodeGenerator {
     return start;
   }
 
+  address generate_count_leading_zeros_lut(const char *stub_name) {
+    __ align64();
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data64(0x0101010102020304, relocInfo::none);
+    __ emit_data64(0x0000000000000000, relocInfo::none);
+    __ emit_data64(0x0101010102020304, relocInfo::none);
+    __ emit_data64(0x0000000000000000, relocInfo::none);
+    __ emit_data64(0x0101010102020304, relocInfo::none);
+    __ emit_data64(0x0000000000000000, relocInfo::none);
+    __ emit_data64(0x0101010102020304, relocInfo::none);
+    __ emit_data64(0x0000000000000000, relocInfo::none);
+    return start;
+  }
+
   address generate_popcount_avx_lut(const char *stub_name) {
     __ align64();
     StubCodeMark mark(this, "StubRoutines", stub_name);
@@ -837,6 +852,66 @@ class StubGenerator: public StubCodeGenerator {
     return start;
   }
 
+  address generate_vector_reverse_bit_lut(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data64(0x0E060A020C040800, relocInfo::none);
+    __ emit_data64(0x0F070B030D050901, relocInfo::none);
+    __ emit_data64(0x0E060A020C040800, relocInfo::none);
+    __ emit_data64(0x0F070B030D050901, relocInfo::none);
+    __ emit_data64(0x0E060A020C040800, relocInfo::none);
+    __ emit_data64(0x0F070B030D050901, relocInfo::none);
+    __ emit_data64(0x0E060A020C040800, relocInfo::none);
+    __ emit_data64(0x0F070B030D050901, relocInfo::none);
+    return start;
+  }
+
+  address generate_vector_reverse_byte_perm_mask_long(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data64(0x0001020304050607, relocInfo::none);
+    __ emit_data64(0x08090A0B0C0D0E0F, relocInfo::none);
+    __ emit_data64(0x0001020304050607, relocInfo::none);
+    __ emit_data64(0x08090A0B0C0D0E0F, relocInfo::none);
+    __ emit_data64(0x0001020304050607, relocInfo::none);
+    __ emit_data64(0x08090A0B0C0D0E0F, relocInfo::none);
+    __ emit_data64(0x0001020304050607, relocInfo::none);
+    __ emit_data64(0x08090A0B0C0D0E0F, relocInfo::none);
+    return start;
+  }
+
+  address generate_vector_reverse_byte_perm_mask_int(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data64(0x0405060700010203, relocInfo::none);
+    __ emit_data64(0x0C0D0E0F08090A0B, relocInfo::none);
+    __ emit_data64(0x0405060700010203, relocInfo::none);
+    __ emit_data64(0x0C0D0E0F08090A0B, relocInfo::none);
+    __ emit_data64(0x0405060700010203, relocInfo::none);
+    __ emit_data64(0x0C0D0E0F08090A0B, relocInfo::none);
+    __ emit_data64(0x0405060700010203, relocInfo::none);
+    __ emit_data64(0x0C0D0E0F08090A0B, relocInfo::none);
+    return start;
+  }
+
+  address generate_vector_reverse_byte_perm_mask_short(const char *stub_name) {
+    __ align(CodeEntryAlignment);
+    StubCodeMark mark(this, "StubRoutines", stub_name);
+    address start = __ pc();
+    __ emit_data64(0x0607040502030001, relocInfo::none);
+    __ emit_data64(0x0E0F0C0D0A0B0809, relocInfo::none);
+    __ emit_data64(0x0607040502030001, relocInfo::none);
+    __ emit_data64(0x0E0F0C0D0A0B0809, relocInfo::none);
+    __ emit_data64(0x0607040502030001, relocInfo::none);
+    __ emit_data64(0x0E0F0C0D0A0B0809, relocInfo::none);
+    __ emit_data64(0x0607040502030001, relocInfo::none);
+    __ emit_data64(0x0E0F0C0D0A0B0809, relocInfo::none);
+    return start;
+  }
+
   address generate_vector_byte_shuffle_mask(const char *stub_name) {
     __ align(CodeEntryAlignment);
     StubCodeMark mark(this, "StubRoutines", stub_name);
@@ -7955,8 +8030,13 @@ address generate_avx_ghash_processBlocks() {
     StubRoutines::x86::_vector_long_shuffle_mask = generate_vector_mask("vector_long_shuffle_mask", 0x0000000100000000);
     StubRoutines::x86::_vector_long_sign_mask = generate_vector_mask("vector_long_sign_mask", 0x8000000000000000);
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