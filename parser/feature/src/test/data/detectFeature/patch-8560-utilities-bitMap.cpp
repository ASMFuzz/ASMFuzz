@@ -232,10 +232,10 @@ void BitMap::par_put_range_within_word(idx_t beg, idx_t end, bool value) {
   // With a valid range (beg <= end), this test ensures that end != 0, as
   // required by inverted_bit_mask_for_range.  Also avoids an unnecessary write.
   if (beg != end) {
-    bm_word_t* pw = word_addr(beg);
-    bm_word_t  w  = *pw;
-    bm_word_t  mr = inverted_bit_mask_for_range(beg, end);
-    bm_word_t  nw = value ? (w | ~mr) : (w & mr);
+    volatile bm_word_t* pw = word_addr(beg);
+    bm_word_t w = Atomic::load(pw);
+    bm_word_t mr = inverted_bit_mask_for_range(beg, end);
+    bm_word_t nw = value ? (w | ~mr) : (w & mr);
     while (true) {
       bm_word_t res = Atomic::cmpxchg(pw, w, nw);
       if (res == w) break;