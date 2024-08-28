@@ -83,9 +83,11 @@ class G1CardSetAllocator {
   // be called in a globally synchronized area.
   void drop_all();
 
+  // Total memory allocated.
   size_t mem_size() const;
 
-  size_t wasted_mem_size() const;
+  // Unused (but usable) memory.
+  size_t unused_mem_size() const;
 
   uint num_segments() const;
 
@@ -119,7 +121,7 @@ class G1CardSetMemoryManager : public CHeapObj<mtGCCardSet> {
   void print(outputStream* os);
 
   size_t mem_size() const;
-  size_t wasted_mem_size() const;
+  size_t unused_mem_size() const;
 
   G1SegmentedArrayMemoryStats memory_stats() const;
 };