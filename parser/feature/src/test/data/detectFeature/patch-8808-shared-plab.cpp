@@ -34,7 +34,7 @@
 
 size_t PLAB::min_size() {
   // Make sure that we return something that is larger than AlignmentReserve
-  return align_object_size(MAX2(MinTLABSize / HeapWordSize, (size_t)oopDesc::header_size())) + AlignmentReserve;
+  return align_object_size(MAX2(MinTLABSize / HeapWordSize, (size_t)oopDesc::header_size())) + CollectedHeap::lab_alignment_reserve();
 }
 
 size_t PLAB::max_size() {
@@ -45,19 +45,11 @@ PLAB::PLAB(size_t desired_plab_sz_) :
   _word_sz(desired_plab_sz_), _bottom(NULL), _top(NULL),
   _end(NULL), _hard_end(NULL), _allocated(0), _wasted(0), _undo_wasted(0)
 {
-  AlignmentReserve = Universe::heap()->tlab_alloc_reserve();
-  assert(min_size() > AlignmentReserve,
+  assert(min_size() > CollectedHeap::lab_alignment_reserve(),
          "Minimum PLAB size " SIZE_FORMAT " must be larger than alignment reserve " SIZE_FORMAT " "
-         "to be able to contain objects", min_size(), AlignmentReserve);
+         "to be able to contain objects", min_size(), CollectedHeap::lab_alignment_reserve());
 }
 
-// If the minimum object size is greater than MinObjAlignment, we can
-// end up with a shard at the end of the buffer that's smaller than
-// the smallest object.  We can't allow that because the buffer must
-// look like it's full of objects when we retire it, so we make
-// sure we have enough space for a filler int array object.
-size_t PLAB::AlignmentReserve;
-
 void PLAB::flush_and_retire_stats(PLABStats* stats) {
   // Retire the last allocation buffer.
   size_t unused = retire_internal();