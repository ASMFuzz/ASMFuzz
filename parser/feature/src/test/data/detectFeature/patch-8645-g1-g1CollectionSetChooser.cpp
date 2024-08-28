@@ -274,7 +274,7 @@ class G1PruneRegionClosure : public HeapRegionClosure {
 
   virtual bool do_heap_region(HeapRegion* r) {
     size_t const reclaimable = r->reclaimable_bytes();
-    if (_num_pruned > _max_pruned ||
+    if (_num_pruned >= _max_pruned ||
         _cur_wasted + reclaimable > _max_wasted) {
       return true;
     }