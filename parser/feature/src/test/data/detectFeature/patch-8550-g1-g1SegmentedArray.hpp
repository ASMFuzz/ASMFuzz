@@ -215,8 +215,8 @@ class G1SegmentedArray : public FreeListConfig  {
   G1SegmentedArrayFreeList* _free_segment_list;   // The global free segment list to preferentially
                                                   // get new segments from.
 
-  volatile uint _num_available_slots; // Number of slots available in all segments (allocated + free + pending + not yet used).
-  volatile uint _num_allocated_slots; // Number of total slots allocated and in use.
+  volatile uint _num_total_slots; // Number of slots available in all segments (allocated + not yet used).
+  volatile uint _num_allocated_slots; // Number of total slots allocated ever (including free and pending).
 
 private:
   inline G1SegmentedArraySegment* create_new_segment(G1SegmentedArraySegment* const prev);
@@ -226,7 +226,7 @@ class G1SegmentedArray : public FreeListConfig  {
 public:
   const G1SegmentedArraySegment* first_array_segment() const { return Atomic::load(&_first); }
 
-  uint num_available_slots() const { return Atomic::load(&_num_available_slots); }
+  uint num_total_slots() const { return Atomic::load(&_num_total_slots); }
   uint num_allocated_slots() const {
     uint allocated = Atomic::load(&_num_allocated_slots);
     assert(calculate_length() == allocated, "Must be");