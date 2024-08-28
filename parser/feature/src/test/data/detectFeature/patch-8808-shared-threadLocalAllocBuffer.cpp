@@ -471,7 +471,7 @@ void ThreadLocalAllocStats::publish() {
 }
 
 size_t ThreadLocalAllocBuffer::end_reserve() {
-  size_t reserve_size = Universe::heap()->tlab_alloc_reserve();
+  size_t reserve_size = CollectedHeap::lab_alignment_reserve();
   return MAX2(reserve_size, (size_t)_reserve_for_allocation_prefetch);
 }
 