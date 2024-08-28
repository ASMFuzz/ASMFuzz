@@ -114,6 +114,8 @@ class CollectedHeap : public CHeapObj<mtGC> {
 
   bool _is_gc_active;
 
+  // (Minimum) Alignment reserve for TLABs and PLABs.
+  static size_t _lab_alignment_reserve;
   // Used for filler objects (static, but initialized in ctor).
   static size_t _filler_array_max_size;
 
@@ -312,7 +314,10 @@ class CollectedHeap : public CHeapObj<mtGC> {
     return oopDesc::header_size();
   }
 
-  size_t tlab_alloc_reserve() const;
+  static size_t lab_alignment_reserve() {
+    assert(_lab_alignment_reserve != ~(size_t)0, "uninitialized");
+    return _lab_alignment_reserve;
+  }
 
   // Some heaps may offer a contiguous region for shared non-blocking
   // allocation, via inlined code (by exporting the address of the top and