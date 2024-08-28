@@ -85,13 +85,6 @@ TEST_VM(PtrQueueBufferAllocatorTest, test) {
   }
   ASSERT_TRUE(BufferNode::TestSupport::try_transfer_pending(&allocator));
   ASSERT_EQ(node_count, allocator.free_count());
-
-  // Destroy some nodes in the free list.
-  // We don't have a way to verify destruction, but we can at
-  // least verify we don't crash along the way.
-  size_t count = allocator.free_count();
-  ASSERT_EQ(count, allocator.reduce_free_list(count));
-  // destroy allocator.
 }
 
 // Stress test with lock-free allocator and completed buffer list.