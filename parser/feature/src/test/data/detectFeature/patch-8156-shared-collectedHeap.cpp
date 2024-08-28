@@ -447,7 +447,7 @@ CollectedHeap::fill_with_array(HeapWord* start, size_t words, bool zap)
   const size_t len = payload_size * HeapWordSize / sizeof(jint);
   assert((int)len >= 0, "size too large " SIZE_FORMAT " becomes %d", words, (int)len);
 
-  ObjArrayAllocator allocator(Universe::intArrayKlassObj(), words, (int)len, /* do_zero */ false);
+  ObjArrayAllocator allocator(Universe::fillerArrayKlassObj(), words, (int)len, /* do_zero */ false);
   allocator.initialize(start);
   if (DumpSharedSpaces) {
     // This array is written into the CDS archive. Make sure it
@@ -467,7 +467,7 @@ CollectedHeap::fill_with_object_impl(HeapWord* start, size_t words, bool zap)
     fill_with_array(start, words, zap);
   } else if (words > 0) {
     assert(words == min_fill_size(), "unaligned size");
-    ObjAllocator allocator(vmClasses::Object_klass(), words);
+    ObjAllocator allocator(vmClasses::FillerObject_klass(), words);
     allocator.initialize(start);
   }
 }