@@ -100,6 +100,13 @@ class BitMap {
   template<bm_word_t flip, bool aligned_right>
   inline idx_t get_next_bit_impl(idx_t l_index, idx_t r_index) const;
 
+  // Helper for get_prev_{zero,one}_bit variants.
+  // - flip designates whether searching for 1s or 0s.  Must be one of
+  //   find_{zeros,ones}_flip.
+  // - aligned_left is true if l_index is a priori on a bm_word_t boundary.
+  template<bm_word_t flip, bool aligned_left>
+  inline idx_t get_prev_bit_impl(idx_t l_index, idx_t r_index) const;
+
   // Values for get_next_bit_impl flip parameter.
   static const bm_word_t find_ones_flip = 0;
   static const bm_word_t find_zeros_flip = ~(bm_word_t)0;
@@ -315,6 +322,15 @@ class BitMap {
   // aligned to bitsizeof(bm_word_t).
   idx_t get_next_one_offset_aligned_right(idx_t l_index, idx_t r_index) const;
 
+  static constexpr idx_t NotFound = ~(idx_t)0;
+  // Find the index of the first bit set scanning from r_index (exclusive) to
+  // l_index (inclusive) backwards.
+  // Returns that index or NotFound if there is no such bit in the range.
+  idx_t get_prev_one_offset(idx_t l_index, idx_t r_index) const;
+  // Same as get_prev_one_offset, except requires that "l_index" is aligned to
+  // bitsizeof(bm_word_t).
+  idx_t get_prev_one_offset_aligned_left(idx_t l_index, idx_t r_index) const;
+
   // Returns the number of bits set in the bitmap.
   idx_t count_one_bits() const;
 