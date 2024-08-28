@@ -150,12 +150,6 @@ class FreeListAllocator {
   size_t mem_size() const {
     return sizeof(*this);
   }
-
-  // Deallocate some of the available nodes in the free_list.
-  // remove_goal is the target number to remove.  Returns the number
-  // actually deallocated, which may be less than the goal if there
-  // were fewer available.
-  size_t reduce_free_list(size_t remove_goal);
 };
 
 #endif // SHARE_GC_SHARED_FREELISTALLOCATOR_HPP