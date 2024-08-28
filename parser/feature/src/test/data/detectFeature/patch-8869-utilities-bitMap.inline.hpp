@@ -167,7 +167,8 @@ inline void BitMap::par_clear_range(idx_t beg, idx_t end, RangeSizeHint hint) {
 
 template<BitMap::bm_word_t flip, bool aligned_right>
 inline BitMap::idx_t BitMap::get_next_bit_impl(idx_t l_index, idx_t r_index) const {
-  STATIC_ASSERT(flip == find_ones_flip || flip == find_zeros_flip);
+  static_assert(flip == find_ones_flip || flip == find_zeros_flip,
+                "flip must be either find_ones_flip or find_zero_flip");
   verify_range(l_index, r_index);
   assert(!aligned_right || is_aligned(r_index, BitsPerWord), "r_index not aligned");
 
@@ -228,6 +229,69 @@ inline BitMap::idx_t BitMap::get_next_bit_impl(idx_t l_index, idx_t r_index) con
   return r_index;
 }
 
+template<BitMap::bm_word_t flip, bool aligned_left>
+inline BitMap::idx_t BitMap::get_prev_bit_impl(idx_t l_index, idx_t r_index) const {
+  static_assert(flip == find_ones_flip || flip == find_zeros_flip,
+                "flip must be either find_ones_flip or find_zero_flip");
+  verify_range(l_index, r_index);
+  assert(!aligned_left || is_aligned(l_index, BitsPerWord), "l_index not aligned");
+
+  // The first word often contains an interesting bit, either due to
+  // density or because of features of the calling algorithm.  So it's
+  // important to examine that first word with a minimum of fuss,
+  // minimizing setup time for later words that will be wasted if the
+  // first word is indeed interesting.
+
+  // The benefit from aligned_left being true is very small. It saves
+  // an operation when returning results.
+
+  // The return value when no bit is found is BitMap::NotFound.
+
+  if (l_index < r_index) {
+    // Get the word containing r_index - 1 (r_index is exclusive), and shift out high bits.
+    r_index--;
+    idx_t index = to_words_align_down(r_index);
+    bm_word_t cword = (map(index) ^ flip) << ((BitsPerWord - 1) - bit_in_word(r_index));
+
+    static_assert(sizeof(intptr_t) == sizeof(bm_word_t), "can not use sign comparison otherwise");
+    if (intptr_t(cword) < 0) {
+      // The first bit is similarly often interesting. When it matters
+      // (density or features of the calling algorithm make it likely
+      // the first bit is set), going straight to the next clause compares
+      // poorly with doing this check first; count_leading_zeros can be
+      // relatively expensive, plus there is the additional range check.
+      // But when the first bit isn't set, the cost of having tested for
+      // it is relatively small compared to the rest of the search.
+      return r_index;
+    } else if (cword != 0) {
+      // Flipped and shifted first word is non-zero.
+      idx_t result = r_index - count_leading_zeros(cword);
+      if (aligned_left || (result >= l_index)) {
+        return result;
+      }
+      // Result is beyond range bound. Fall through.
+    } else {
+      // Flipped and shifted first word is zero.  Word search through
+      // aligned down l_index for a non-zero flipped word.
+      idx_t limit = to_words_align_down(l_index);
+      while (index-- > limit) {
+        cword = map(index) ^ flip;
+        if (cword != 0) {
+          idx_t result = bit_index(index) + (BitsPerWord - 1) - count_leading_zeros(cword);
+          if (aligned_left || (result >= l_index)) {
+            return result;
+          }
+          // Result is beyond range bound; return NotFound
+          assert(index == limit, "invariant");
+          break;
+        }
+      }
+      // No bits in range. Fall through.
+    }
+  }
+  return NotFound;
+}
+
 inline BitMap::idx_t
 BitMap::get_next_one_offset(idx_t l_offset, idx_t r_offset) const {
   return get_next_bit_impl<find_ones_flip, false>(l_offset, r_offset);
@@ -243,6 +307,16 @@ BitMap::get_next_one_offset_aligned_right(idx_t l_offset, idx_t r_offset) const
   return get_next_bit_impl<find_ones_flip, true>(l_offset, r_offset);
 }
 
+inline BitMap::idx_t
+BitMap::get_prev_one_offset (idx_t l_index, idx_t r_index) const {
+  return get_prev_bit_impl<find_ones_flip, false>(l_index, r_index);
+}
+
+inline BitMap::idx_t
+BitMap::get_prev_one_offset_aligned_left(idx_t l_index, idx_t r_index) const {
+  return get_prev_bit_impl<find_ones_flip, true>(l_index, r_index);
+}
+
 template <typename BitMapClosureType>
 inline bool BitMap::iterate(BitMapClosureType* cl, idx_t beg, idx_t end) {
   for (idx_t index = beg; true; ++index) {