@@ -2308,10 +2308,20 @@ void ShenandoahHeap::flush_liveness_cache(uint worker_id) {
 }
 
 bool ShenandoahHeap::requires_barriers(stackChunkOop obj) const {
-  ShenandoahHeapRegion* region = heap_region_containing(obj);
-  bool allocated_after_mark_start = marking_context()->allocated_after_mark_start(obj);
-  bool requires_concmark_barriers = is_concurrent_mark_in_progress() && !allocated_after_mark_start;
-  bool requires_loadref_barriers = has_forwarded_objects() && cast_from_oop<HeapWord*>(obj) < heap_region_containing(obj)->get_update_watermark();
-  bool requires_deep_loadref_barriers = allocated_after_mark_start && has_forwarded_objects();
-  return requires_concmark_barriers || requires_loadref_barriers || requires_deep_loadref_barriers;
+  if (is_idle()) return false;
+
+  // Objects allocated after marking start are implicitly alive, don't need any barriers during
+  // marking phase.
+  if (is_concurrent_mark_in_progress() && marking_context()->allocated_after_mark_start(obj)) {
+    return false;
+  }
+
+  // Objects allocated after evacuation start are guaranteed in to-space, don't need any barriers
+  // during evacuation/update references phases.
+  if (has_forwarded_objects() &&
+      cast_from_oop<HeapWord*>(obj) >= heap_region_containing(obj)->get_update_watermark()) {
+    return false;
+  }
+
+  return true;
 }