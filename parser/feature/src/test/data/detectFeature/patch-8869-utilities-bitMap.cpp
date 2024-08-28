@@ -36,6 +36,8 @@ STATIC_ASSERT(sizeof(BitMap::bm_word_t) == BytesPerWord); // "Implementation ass
 typedef BitMap::bm_word_t bm_word_t;
 typedef BitMap::idx_t     idx_t;
 
+constexpr idx_t BitMap::NotFound;
+
 class ResourceBitMapAllocator : StackObj {
  public:
   bm_word_t* allocate(idx_t size_in_words) const {