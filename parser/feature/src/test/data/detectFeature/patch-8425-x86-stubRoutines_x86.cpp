@@ -59,7 +59,12 @@ address StubRoutines::x86::_vector_double_sign_flip = NULL;
 address StubRoutines::x86::_vector_byte_perm_mask = NULL;
 address StubRoutines::x86::_vector_long_sign_mask = NULL;
 address StubRoutines::x86::_vector_iota_indices = NULL;
+address StubRoutines::x86::_vector_reverse_bit_lut = NULL;
+address StubRoutines::x86::_vector_reverse_byte_perm_mask_long = NULL;
+address StubRoutines::x86::_vector_reverse_byte_perm_mask_int = NULL;
+address StubRoutines::x86::_vector_reverse_byte_perm_mask_short = NULL;
 address StubRoutines::x86::_vector_popcount_lut = NULL;
+address StubRoutines::x86::_vector_count_leading_zeros_lut = NULL;
 address StubRoutines::x86::_vector_32_bit_mask = NULL;
 address StubRoutines::x86::_vector_64_bit_mask = NULL;
 #ifdef _LP64