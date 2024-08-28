@@ -38,21 +38,19 @@ PtrQueue::~PtrQueue() {
   assert(_buf == NULL, "queue must be flushed before delete");
 }
 
-BufferNode::AllocatorConfig::AllocatorConfig(size_t size) : _buffer_size(size) {}
-
-void* BufferNode::AllocatorConfig::allocate() {
+void* BufferNode::Allocator::MemAllocator::allocate() {
   size_t byte_size = _buffer_size * sizeof(void*);
   return NEW_C_HEAP_ARRAY(char, buffer_offset() + byte_size, mtGC);
 }
 
-void BufferNode::AllocatorConfig::deallocate(void* node) {
+void BufferNode::Allocator::MemAllocator::deallocate(void* node) {
   assert(node != nullptr, "precondition");
   FREE_C_HEAP_ARRAY(char, node);
 }
 
 BufferNode::Allocator::Allocator(const char* name, size_t buffer_size) :
-  _config(buffer_size),
-  _free_list(name, &_config)
+  _mem_allocator(buffer_size),
+  _free_list(name, &_mem_allocator)
 {
 
 }