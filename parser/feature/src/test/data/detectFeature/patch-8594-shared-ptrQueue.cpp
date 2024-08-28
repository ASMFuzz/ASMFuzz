@@ -72,10 +72,6 @@ void BufferNode::Allocator::release(BufferNode* node) {
   _free_list.release(node);
 }
 
-size_t BufferNode::Allocator::reduce_free_list(size_t remove_goal) {
-  return _free_list.reduce_free_list(remove_goal);
-}
-
 PtrQueueSet::PtrQueueSet(BufferNode::Allocator* allocator) :
   _allocator(allocator)
 {}