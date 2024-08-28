@@ -1252,7 +1252,7 @@ class G1CollectedHeap : public CollectedHeap {
   inline bool is_obj_dead_full(const oop obj) const;
 
   // Mark the live object that failed evacuation in the prev bitmap.
-  void mark_evac_failure_object(const oop obj, uint worker_id) const;
+  void mark_evac_failure_object(oop obj) const;
 
   G1ConcurrentMark* concurrent_mark() const { return _cm; }
 