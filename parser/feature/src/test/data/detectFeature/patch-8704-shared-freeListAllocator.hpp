@@ -31,36 +31,30 @@
 #include "utilities/globalDefinitions.hpp"
 #include "utilities/lockFreeStack.hpp"
 
-class FreeListConfig {
-  // Desired minimum transfer batch size.  There is relatively little
-  // importance to the specific number.  It shouldn't be too big, else
-  // we're wasting space when the release rate is low.  If the release
-  // rate is high, we might accumulate more than this before being
-  // able to start a new transfer, but that's okay.
-  const size_t _transfer_threshold;
+class AbstractAllocator {
 protected:
-  ~FreeListConfig() = default;
+  ~AbstractAllocator() = default;
 public:
-  explicit FreeListConfig(size_t threshold = 10) : _transfer_threshold(threshold) {}
-
-  size_t transfer_threshold() { return _transfer_threshold; }
-
   virtual void* allocate() = 0;
 
-  virtual  void deallocate(void* node) = 0;
+  virtual void deallocate(void* node) = 0;
 };
 
 // Allocation is based on a lock-free list of nodes. To reduce synchronization
 // overhead on the free list between allocation and release calls, the released
 // nodes are first placed on a pending list, then transferred to the free list in
 // batches. While on the pending list, the nodes are not available for allocation.
-// The allocator uses allocation options specified by an instance of
-// FreeListConfig. The FreeListConfig includes an allocation method to use in case
-// the free list is empty and a deallocation method used to deallocate nodes in
-// the free list. Additionally, the FreeListConfig configures the threshold used
-// as a minimum batch size for transferring released nodes from the pending list
-// to the free list making them available for re-allocation.
+// Actual allocation & deallocation of nodes are provided by AbstractAllocator.
 class FreeListAllocator {
+  // Desired minimum transfer batch size.  There is relatively little
+  // importance to the specific number.  It shouldn't be too big, else
+  // we're wasting space when the release rate is low.  If the release
+  // rate is high, we might accumulate more than this before being
+  // able to start a new transfer, but that's okay.
+  const size_t _transfer_threshold;
+
+  size_t transfer_threshold() const { return _transfer_threshold; }
+
   struct FreeNode {
     FreeNode* volatile _next;
 
@@ -108,8 +102,8 @@ class FreeListAllocator {
   static FreeNode* volatile* next_ptr(FreeNode& node) { return node.next_addr(); }
   typedef LockFreeStack<FreeNode, &next_ptr> Stack;
 
-  FreeListConfig* _config;
-  char _name[DEFAULT_CACHE_LINE_SIZE - sizeof(FreeListConfig*)];  // Use name as padding.
+  AbstractAllocator* _allocator;
+  char _name[DEFAULT_CACHE_LINE_SIZE - sizeof(AbstractAllocator*)];  // Use name as padding.
 
 #define DECLARE_PADDED_MEMBER(Id, Type, Name) \
   Type Name; DEFINE_PAD_MINUS_SIZE(Id, DEFAULT_CACHE_LINE_SIZE, sizeof(Type))
@@ -126,7 +120,9 @@ class FreeListAllocator {
   NONCOPYABLE(FreeListAllocator);
 
 public:
-  FreeListAllocator(const char* name, FreeListConfig* config);
+  FreeListAllocator(const char* name,
+                    AbstractAllocator* allocator,
+                    size_t transfer_threshold = 10);
 
   const char* name() const { return _name; }
 