@@ -140,7 +140,7 @@ inline bool HeapRegion::is_obj_dead(const oop obj, const G1CMBitMap* const prev_
          !is_closed_archive();
 }
 
-inline size_t HeapRegion::block_size(const HeapWord *addr) const {
+inline size_t HeapRegion::block_size(const HeapWord* addr) const {
   assert(addr < top(), "precondition");
 
   if (block_is_obj(addr)) {