@@ -86,12 +86,9 @@ class G1CardSetAllocator {
   // Total memory allocated.
   size_t mem_size() const;
 
-  // Unused (but usable) memory.
   size_t unused_mem_size() const;
 
   uint num_segments() const;
-
-  void print(outputStream* os);
 };
 
 using G1CardSetFreePool = G1SegmentedArrayFreePool;
@@ -118,8 +115,6 @@ class G1CardSetMemoryManager : public CHeapObj<mtGCCardSet> {
 
   void flush();
 
-  void print(outputStream* os);
-
   size_t mem_size() const;
   size_t unused_mem_size() const;
 