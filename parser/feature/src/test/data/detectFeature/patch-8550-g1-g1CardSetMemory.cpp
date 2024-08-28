@@ -57,14 +57,14 @@ void G1CardSetAllocator::drop_all() {
 size_t G1CardSetAllocator::mem_size() const {
   return sizeof(*this) +
          _segmented_array.num_segments() * sizeof(G1CardSetSegment) +
-         _segmented_array.num_available_slots() * _segmented_array.slot_size();
+         _segmented_array.num_total_slots() * _segmented_array.slot_size();
 }
 
-size_t G1CardSetAllocator::wasted_mem_size() const {
-  uint num_wasted_slots = _segmented_array.num_available_slots() -
+size_t G1CardSetAllocator::unused_mem_size() const {
+  uint num_unused_slots = _segmented_array.num_total_slots() -
                           _segmented_array.num_allocated_slots() -
                           (uint)_free_slots_list.pending_count();
-  return num_wasted_slots * _segmented_array.slot_size();
+  return num_unused_slots * _segmented_array.slot_size();
 }
 
 uint G1CardSetAllocator::num_segments() const {
@@ -73,18 +73,18 @@ uint G1CardSetAllocator::num_segments() const {
 
 void G1CardSetAllocator::print(outputStream* os) {
   uint num_allocated_slots = _segmented_array.num_allocated_slots();
-  uint num_available_slots = _segmented_array.num_available_slots();
+  uint num_total_slots = _segmented_array.num_total_slots();
   uint highest = _segmented_array.first_array_segment() != nullptr
                ? _segmented_array.first_array_segment()->num_slots()
                : 0;
   uint num_segments = _segmented_array.num_segments();
   uint num_pending_slots = (uint)_free_slots_list.pending_count();
-  os->print("MA " PTR_FORMAT ": %u slots pending (allocated %u available %u) used %.3f highest %u segments %u size %zu ",
+  os->print("MA " PTR_FORMAT ": %u slots pending (allocated %u total %u) used %.3f highest %u segments %u size %zu ",
             p2i(this),
             num_pending_slots,
             num_allocated_slots,
-            num_available_slots,
-            percent_of(num_allocated_slots - num_pending_slots, num_available_slots),
+            num_total_slots,
+            percent_of(num_allocated_slots - num_pending_slots, num_total_slots),
             highest,
             num_segments,
             mem_size());
@@ -142,10 +142,10 @@ size_t G1CardSetMemoryManager::mem_size() const {
     (sizeof(G1CardSetAllocator) * num_mem_object_types());
 }
 
-size_t G1CardSetMemoryManager::wasted_mem_size() const {
+size_t G1CardSetMemoryManager::unused_mem_size() const {
   size_t result = 0;
   for (uint i = 0; i < num_mem_object_types(); i++) {
-    result += _allocators[i].wasted_mem_size();
+    result += _allocators[i].unused_mem_size();
   }
   return result;
 }