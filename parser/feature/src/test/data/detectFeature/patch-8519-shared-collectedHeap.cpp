@@ -60,6 +60,7 @@
 
 class ClassLoaderData;
 
+Klass* CollectedHeap::_filler_object_klass = NULL;
 size_t CollectedHeap::_filler_array_max_size = 0;
 
 class GCMessage : public FormatBuffer<1024> {
@@ -467,7 +468,7 @@ CollectedHeap::fill_with_object_impl(HeapWord* start, size_t words, bool zap)
     fill_with_array(start, words, zap);
   } else if (words > 0) {
     assert(words == min_fill_size(), "unaligned size");
-    ObjAllocator allocator(vmClasses::FillerObject_klass(), words);
+    ObjAllocator allocator(CollectedHeap::filler_object_klass(), words);
     allocator.initialize(start);
   }
 }