@@ -162,15 +162,15 @@ inline bool G1CollectedHeap::is_marked_next(oop obj) const {
   return _cm->next_mark_bitmap()->is_marked(obj);
 }
 
-inline bool G1CollectedHeap::is_in_cset(oop obj) {
+inline bool G1CollectedHeap::is_in_cset(oop obj) const {
   return is_in_cset(cast_from_oop<HeapWord*>(obj));
 }
 
-inline bool G1CollectedHeap::is_in_cset(HeapWord* addr) {
+inline bool G1CollectedHeap::is_in_cset(HeapWord* addr) const {
   return _region_attr.is_in_cset(addr);
 }
 
-bool G1CollectedHeap::is_in_cset(const HeapRegion* hr) {
+bool G1CollectedHeap::is_in_cset(const HeapRegion* hr) const {
   return _region_attr.is_in_cset(hr);
 }
 