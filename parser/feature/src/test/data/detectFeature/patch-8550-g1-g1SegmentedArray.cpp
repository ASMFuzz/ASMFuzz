@@ -124,7 +124,7 @@ G1SegmentedArraySegment* G1SegmentedArray::create_new_segment(G1SegmentedArraySe
     // Successfully installed the segment into the list.
     Atomic::inc(&_num_segments, memory_order_relaxed);
     Atomic::add(&_mem_size, next->mem_size(), memory_order_relaxed);
-    Atomic::add(&_num_available_slots, next->num_slots(), memory_order_relaxed);
+    Atomic::add(&_num_total_slots, next->num_slots(), memory_order_relaxed);
     return next;
   }
 }
@@ -137,7 +137,7 @@ G1SegmentedArray::G1SegmentedArray(const G1SegmentedArrayAllocOptions* alloc_opt
   _num_segments(0),
   _mem_size(0),
   _free_segment_list(free_segment_list),
-  _num_available_slots(0),
+  _num_total_slots(0),
   _num_allocated_slots(0) {
   assert(_free_segment_list != nullptr, "precondition!");
 }
@@ -182,7 +182,7 @@ void G1SegmentedArray::drop_all() {
   _last = nullptr;
   _num_segments = 0;
   _mem_size = 0;
-  _num_available_slots = 0;
+  _num_total_slots = 0;
   _num_allocated_slots = 0;
 }
 