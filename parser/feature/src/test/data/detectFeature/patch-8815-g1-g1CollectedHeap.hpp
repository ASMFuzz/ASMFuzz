@@ -1044,9 +1044,9 @@ class G1CollectedHeap : public CollectedHeap {
 
   // Return "TRUE" iff the given object address is within the collection
   // set. Assumes that the reference points into the heap.
-  inline bool is_in_cset(const HeapRegion *hr);
-  inline bool is_in_cset(oop obj);
-  inline bool is_in_cset(HeapWord* addr);
+  inline bool is_in_cset(const HeapRegion *hr) const;
+  inline bool is_in_cset(const oop obj) const;
+  inline bool is_in_cset(HeapWord* const addr) const;
 
   inline bool is_in_cset_or_humongous(const oop obj);
 
@@ -1058,7 +1058,7 @@ class G1CollectedHeap : public CollectedHeap {
 
  public:
 
-  inline G1HeapRegionAttr region_attr(const void* obj) const;
+  inline G1HeapRegionAttr region_attr(void* const obj) const;
   inline G1HeapRegionAttr region_attr(uint idx) const;
 
   MemRegion reserved() const {
@@ -1167,11 +1167,11 @@ class G1CollectedHeap : public CollectedHeap {
   // address "addr".  We say "blocks" instead of "object" since some heaps
   // may not pack objects densely; a chunk may either be an object or a
   // non-object.
-  HeapWord* block_start(const void* addr) const;
+  HeapWord* block_start(void* const addr) const;
 
   // Requires "addr" to be the start of a block, and returns "TRUE" iff
   // the block is an object.
-  bool block_is_obj(const HeapWord* addr) const;
+  bool block_is_obj(HeapWord* const addr) const;
 
   // Section on thread-local allocation buffers (TLABs)
   // See CollectedHeap for semantics.
@@ -1234,7 +1234,7 @@ class G1CollectedHeap : public CollectedHeap {
   bool check_young_list_empty();
 #endif
 
-  bool is_marked_next(oop obj) const;
+  bool is_marked_next(const oop obj) const;
 
   // Determine if an object is dead, given the object and also
   // the region to which the object belongs.
@@ -1243,16 +1243,14 @@ class G1CollectedHeap : public CollectedHeap {
   // Determine if an object is dead, given only the object itself.
   // This will find the region to which the object belongs and
   // then call the region version of the same function.
-
-  // Added if it is NULL it isn't dead.
-
+  // NULL obj are not considered dead.
   inline bool is_obj_dead(const oop obj) const;
 
   inline bool is_obj_dead_full(const oop obj, const HeapRegion* hr) const;
   inline bool is_obj_dead_full(const oop obj) const;
 
   // Mark the live object that failed evacuation in the prev bitmap.
-  void mark_evac_failure_object(const oop obj, uint worker_id) const;
+  void mark_evac_failure_object(const oop obj) const;
 
   G1ConcurrentMark* concurrent_mark() const { return _cm; }
 