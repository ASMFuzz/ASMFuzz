@@ -61,9 +61,8 @@ size_t G1CardSetAllocator::mem_size() const {
 }
 
 size_t G1CardSetAllocator::unused_mem_size() const {
-  uint num_unused_slots = _segmented_array.num_total_slots() -
-                          _segmented_array.num_allocated_slots() -
-                          (uint)_free_slots_list.pending_count();
+  uint num_unused_slots = (_segmented_array.num_total_slots() - _segmented_array.num_allocated_slots()) +
+                          (uint)_free_slots_list.free_count();
   return num_unused_slots * _segmented_array.slot_size();
 }
 