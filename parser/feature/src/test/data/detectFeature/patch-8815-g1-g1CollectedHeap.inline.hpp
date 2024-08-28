@@ -158,27 +158,27 @@ inline G1ScannerTasksQueue* G1CollectedHeap::task_queue(uint i) const {
   return _task_queues->queue(i);
 }
 
-inline bool G1CollectedHeap::is_marked_next(oop obj) const {
+inline bool G1CollectedHeap::is_marked_next(const oop obj) const {
   return _cm->next_mark_bitmap()->is_marked(obj);
 }
 
-inline bool G1CollectedHeap::is_in_cset(oop obj) {
+inline bool G1CollectedHeap::is_in_cset(const oop obj) const {
   return is_in_cset(cast_from_oop<HeapWord*>(obj));
 }
 
-inline bool G1CollectedHeap::is_in_cset(HeapWord* addr) {
+inline bool G1CollectedHeap::is_in_cset(HeapWord* const addr) const {
   return _region_attr.is_in_cset(addr);
 }
 
-bool G1CollectedHeap::is_in_cset(const HeapRegion* hr) {
+bool G1CollectedHeap::is_in_cset(const HeapRegion* hr) const {
   return _region_attr.is_in_cset(hr);
 }
 
 bool G1CollectedHeap::is_in_cset_or_humongous(const oop obj) {
   return _region_attr.is_in_cset_or_humongous(cast_from_oop<HeapWord*>(obj));
 }
 
-G1HeapRegionAttr G1CollectedHeap::region_attr(const void* addr) const {
+G1HeapRegionAttr G1CollectedHeap::region_attr(void* const addr) const {
   return _region_attr.at((HeapWord*)addr);
 }
 