@@ -157,31 +157,26 @@ class BufferNode {
       reinterpret_cast<char*>(node) + buffer_offset());
   }
 
-  class AllocatorConfig;
   class Allocator;              // Free-list based allocator.
   class TestSupport;            // Unit test support.
 };
 
-// We use BufferNode::AllocatorConfig to set the allocation options for the
-// FreeListAllocator.
-class BufferNode::AllocatorConfig : public FreeListConfig {
-  const size_t _buffer_size;
-public:
-  explicit AllocatorConfig(size_t size);
+class BufferNode::Allocator {
+  friend class TestSupport;
 
-  ~AllocatorConfig() = default;
+  class MemAllocator : public AbstractAllocator {
+    const size_t _buffer_size;
+  public:
+    explicit MemAllocator(size_t buffer_size) : _buffer_size(buffer_size) {}
 
-  void* allocate() override;
+    ~MemAllocator() = default;
 
-  void deallocate(void* node) override;
+    void* allocate() override;
 
-  size_t buffer_size() const { return _buffer_size; }
-};
-
-class BufferNode::Allocator {
-  friend class TestSupport;
+    void deallocate(void* node) override;
 
-  AllocatorConfig _config;
+    size_t buffer_size() const { return _buffer_size; }
+  } _mem_allocator;
   FreeListAllocator _free_list;
 
   NONCOPYABLE(Allocator);
@@ -190,7 +185,7 @@ class BufferNode::Allocator {
   Allocator(const char* name, size_t buffer_size);
   ~Allocator() = default;
 
-  size_t buffer_size() const { return _config.buffer_size(); }
+  size_t buffer_size() const { return _mem_allocator.buffer_size(); }
   size_t free_count() const;
   BufferNode* allocate();
   void release(BufferNode* node);