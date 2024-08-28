@@ -2346,12 +2346,12 @@ void G1CollectedHeap::par_iterate_regions_array(HeapRegionClosure* cl,
   } while (cur_pos != start_pos);
 }
 
-HeapWord* G1CollectedHeap::block_start(const void* addr) const {
+HeapWord* G1CollectedHeap::block_start(void* const addr) const {
   HeapRegion* hr = heap_region_containing(addr);
   return hr->block_start(addr);
 }
 
-bool G1CollectedHeap::block_is_obj(const HeapWord* addr) const {
+bool G1CollectedHeap::block_is_obj(HeapWord* const addr) const {
   HeapRegion* hr = heap_region_containing(addr);
   return hr->block_is_obj(addr);
 }
@@ -3317,7 +3317,7 @@ HeapRegion* G1CollectedHeap::alloc_highest_free_region() {
   return NULL;
 }
 
-void G1CollectedHeap::mark_evac_failure_object(const oop obj, uint worker_id) const {
+void G1CollectedHeap::mark_evac_failure_object(const oop obj) const {
   // All objects failing evacuation are live. What we'll do is
   // that we'll update the prev marking info so that they are
   // all under PTAMS and explicitly marked.