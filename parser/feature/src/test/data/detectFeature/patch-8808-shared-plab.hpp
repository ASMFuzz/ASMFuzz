@@ -25,6 +25,7 @@
 #ifndef SHARE_GC_SHARED_PLAB_HPP
 #define SHARE_GC_SHARED_PLAB_HPP
 
+#include "gc/shared/collectedHeap.hpp"
 #include "gc/shared/gcUtil.hpp"
 #include "memory/allocation.hpp"
 #include "utilities/globalDefinitions.hpp"
@@ -46,7 +47,6 @@ class PLAB: public CHeapObj<mtGC> {
   size_t    _wasted;        // in HeapWord units
   size_t    _undo_wasted;
   char      tail[32];
-  static size_t AlignmentReserve;
 
   // Force future allocations to fail and queries for contains()
   // to return false. Returns the amount of unused space in this PLAB.
@@ -73,7 +73,7 @@ class PLAB: public CHeapObj<mtGC> {
   // Must get initialized with "set_buf" for an allocation to succeed.
   PLAB(size_t word_sz);
 
-  static size_t size_required_for_allocation(size_t word_size) { return word_size + AlignmentReserve; }
+  static size_t size_required_for_allocation(size_t word_size) { return word_size + CollectedHeap::lab_alignment_reserve(); }
 
   // Minimum PLAB size.
   static size_t min_size();
@@ -117,13 +117,13 @@ class PLAB: public CHeapObj<mtGC> {
 
   // Sets the space of the buffer to be [buf, space+word_sz()).
   void set_buf(HeapWord* buf, size_t new_word_sz) {
-    assert(new_word_sz > AlignmentReserve, "Too small");
+    assert(new_word_sz > CollectedHeap::lab_alignment_reserve(), "Too small");
     _word_sz = new_word_sz;
 
     _bottom   = buf;
     _top      = _bottom;
     _hard_end = _bottom + word_sz();
-    _end      = _hard_end - AlignmentReserve;
+    _end      = _hard_end - CollectedHeap::lab_alignment_reserve();
     assert(_end >= _top, "Negative buffer");
     // In support of ergonomic sizing
     _allocated += word_sz();