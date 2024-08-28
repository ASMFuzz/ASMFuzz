@@ -3317,7 +3317,7 @@ HeapRegion* G1CollectedHeap::alloc_highest_free_region() {
   return NULL;
 }
 
-void G1CollectedHeap::mark_evac_failure_object(const oop obj, uint worker_id) const {
+void G1CollectedHeap::mark_evac_failure_object(const oop obj) const {
   // All objects failing evacuation are live. What we'll do is
   // that we'll update the prev marking info so that they are
   // all under PTAMS and explicitly marked.