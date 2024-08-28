@@ -60,6 +60,7 @@
 
 class ClassLoaderData;
 
+size_t CollectedHeap::_lab_alignment_reserve = ~(size_t)0;
 Klass* CollectedHeap::_filler_object_klass = NULL;
 size_t CollectedHeap::_filler_array_max_size = 0;
 size_t CollectedHeap::_stack_chunk_max_size = 0;
@@ -242,6 +243,14 @@ CollectedHeap::CollectedHeap() :
   _gc_cause(GCCause::_no_gc),
   _gc_lastcause(GCCause::_no_gc)
 {
+  // If the minimum object size is greater than MinObjAlignment, we can
+  // end up with a shard at the end of the buffer that's smaller than
+  // the smallest object.  We can't allow that because the buffer must
+  // look like it's full of objects when we retire it, so we make
+  // sure we have enough space for a filler int array object.
+  size_t min_size = min_dummy_object_size();
+  _lab_alignment_reserve = min_size > (size_t)MinObjAlignment ? align_object_size(min_size) : 0;
+
   const size_t max_len = size_t(arrayOopDesc::max_array_length(T_INT));
   const size_t elements_per_word = HeapWordSize / sizeof(jint);
   _filler_array_max_size = align_object_size(filler_array_hdr_size() +
@@ -506,11 +515,6 @@ void CollectedHeap::fill_with_dummy_object(HeapWord* start, HeapWord* end, bool
   CollectedHeap::fill_with_object(start, end, zap);
 }
 
-size_t CollectedHeap::tlab_alloc_reserve() const {
-  size_t min_size = min_dummy_object_size();
-  return min_size > (size_t)MinObjAlignment ? align_object_size(min_size) : 0;
-}
-
 HeapWord* CollectedHeap::allocate_new_tlab(size_t min_size,
                                            size_t requested_size,
                                            size_t* actual_size) {