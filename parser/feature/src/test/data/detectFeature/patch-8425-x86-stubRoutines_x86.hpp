@@ -178,6 +178,11 @@ class x86 {
   static address _vector_long_shuffle_mask;
   static address _vector_iota_indices;
   static address _vector_popcount_lut;
+  static address _vector_count_leading_zeros_lut;
+  static address _vector_reverse_bit_lut;
+  static address _vector_reverse_byte_perm_mask_long;
+  static address _vector_reverse_byte_perm_mask_int;
+  static address _vector_reverse_byte_perm_mask_short;
 #ifdef _LP64
   static juint _k256_W[];
   static address _k256_W_adr;
@@ -341,6 +346,26 @@ class x86 {
     return _vector_iota_indices;
   }
 
+  static address vector_count_leading_zeros_lut() {
+    return _vector_count_leading_zeros_lut;
+  }
+
+  static address vector_reverse_bit_lut() {
+    return _vector_reverse_bit_lut;
+  }
+
+  static address vector_reverse_byte_perm_mask_long() {
+    return _vector_reverse_byte_perm_mask_long;
+  }
+
+  static address vector_reverse_byte_perm_mask_int() {
+    return _vector_reverse_byte_perm_mask_int;
+  }
+
+  static address vector_reverse_byte_perm_mask_short() {
+    return _vector_reverse_byte_perm_mask_short;
+  }
+
   static address vector_popcount_lut() {
     return _vector_popcount_lut;
   }