@@ -198,11 +198,6 @@ class BufferNode::Allocator {
   // If _free_list has items buffered in the pending list, transfer
   // these to make them available for re-allocation.
   bool flush_free_list() { return _free_list.try_transfer_pending(); }
-
-  // Deallocate some of the available buffers.  remove_goal is the target
-  // number to remove.  Returns the number actually deallocated, which may
-  // be less than the goal if there were fewer available.
-  size_t reduce_free_list(size_t remove_goal);
 };
 
 // A PtrQueueSet represents resources common to a set of pointer queues.