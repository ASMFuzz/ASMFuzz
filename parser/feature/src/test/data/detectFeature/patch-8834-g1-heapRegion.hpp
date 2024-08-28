@@ -130,8 +130,6 @@ class HeapRegion : public CHeapObj<mtGC> {
 
   void clear(bool mangle_space);
 
-  HeapWord* block_start_const(const void* p) const;
-
   void mangle_unused_area() PRODUCT_RETURN;
 
   // Try to allocate at least min_word_size and up to desired_size from this region.