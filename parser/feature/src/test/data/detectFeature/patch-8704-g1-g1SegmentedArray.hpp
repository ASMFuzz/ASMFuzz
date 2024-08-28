@@ -202,7 +202,7 @@ class G1SegmentedArrayAllocOptions {
 // Their values are only consistent within each other with extra global
 // synchronization.
 
-class G1SegmentedArray : public FreeListConfig  {
+class G1SegmentedArray : public AbstractAllocator  {
   // G1SegmentedArrayAllocOptions provides parameters for allocation segment
   // sizing and expansion.
   const G1SegmentedArrayAllocOptions* _alloc_options;