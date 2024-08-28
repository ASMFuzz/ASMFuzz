@@ -56,7 +56,7 @@ void G1CardSetAllocator::drop_all() {
 
 size_t G1CardSetAllocator::mem_size() const {
   return sizeof(*this) +
-         _segmented_array.num_segments() * sizeof(G1CardSetSegment) +
+         num_segments() * sizeof(G1CardSetSegment) +
          _segmented_array.num_total_slots() * _segmented_array.slot_size();
 }
 
@@ -71,25 +71,6 @@ uint G1CardSetAllocator::num_segments() const {
   return _segmented_array.num_segments();
 }
 
-void G1CardSetAllocator::print(outputStream* os) {
-  uint num_allocated_slots = _segmented_array.num_allocated_slots();
-  uint num_total_slots = _segmented_array.num_total_slots();
-  uint highest = _segmented_array.first_array_segment() != nullptr
-               ? _segmented_array.first_array_segment()->num_slots()
-               : 0;
-  uint num_segments = _segmented_array.num_segments();
-  uint num_pending_slots = (uint)_free_slots_list.pending_count();
-  os->print("MA " PTR_FORMAT ": %u slots pending (allocated %u total %u) used %.3f highest %u segments %u size %zu ",
-            p2i(this),
-            num_pending_slots,
-            num_allocated_slots,
-            num_total_slots,
-            percent_of(num_allocated_slots - num_pending_slots, num_total_slots),
-            highest,
-            num_segments,
-            mem_size());
-}
-
 G1CardSetMemoryManager::G1CardSetMemoryManager(G1CardSetConfiguration* config,
                                                G1CardSetFreePool* free_list_pool) : _config(config) {
 
@@ -126,13 +107,6 @@ void G1CardSetMemoryManager::flush() {
   }
 }
 
-void G1CardSetMemoryManager::print(outputStream* os) {
-  os->print_cr("MM " PTR_FORMAT " size %zu", p2i(this), sizeof(*this));
-  for (uint i = 0; i < num_mem_object_types(); i++) {
-    _allocators[i].print(os);
-  }
-}
-
 size_t G1CardSetMemoryManager::mem_size() const {
   size_t result = 0;
   for (uint i = 0; i < num_mem_object_types(); i++) {