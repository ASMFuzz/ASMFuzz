@@ -1044,9 +1044,9 @@ class G1CollectedHeap : public CollectedHeap {
 
   // Return "TRUE" iff the given object address is within the collection
   // set. Assumes that the reference points into the heap.
-  inline bool is_in_cset(const HeapRegion *hr);
-  inline bool is_in_cset(oop obj);
-  inline bool is_in_cset(HeapWord* addr);
+  inline bool is_in_cset(const HeapRegion *hr) const;
+  inline bool is_in_cset(oop obj) const;
+  inline bool is_in_cset(HeapWord* addr) const;
 
   inline bool is_in_cset_or_humongous(const oop obj);
 