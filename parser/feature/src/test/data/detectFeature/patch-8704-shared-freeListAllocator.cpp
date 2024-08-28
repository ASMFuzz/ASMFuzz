@@ -64,8 +64,11 @@ size_t FreeListAllocator::PendingList::count() const {
   return  Atomic::load(&_count);
 }
 
-FreeListAllocator::FreeListAllocator(const char* name, FreeListConfig* config) :
-  _config(config),
+FreeListAllocator::FreeListAllocator(const char* name,
+                                     AbstractAllocator* allocator,
+                                     size_t transfer_threshold) :
+  _transfer_threshold(transfer_threshold),
+  _allocator(allocator),
   _free_count(0),
   _free_list(),
   _transfer_lock(false),
@@ -80,7 +83,7 @@ void FreeListAllocator::delete_list(FreeNode* list) {
   while (list != nullptr) {
     FreeNode* next = list->next();
     list->~FreeNode();
-    _config->deallocate(list);
+    _allocator->deallocate(list);
     list = next;
   }
 }
@@ -129,7 +132,7 @@ void* FreeListAllocator::allocate() {
     assert((count + 1) != 0, "_free_count underflow");
     return node;
   } else {
-    return _config->allocate();
+    return _allocator->allocate();
   }
 }
 
@@ -152,7 +155,7 @@ void FreeListAllocator::release(void* free_node) {
     GlobalCounter::CriticalSection cs(Thread::current());
     uint index = Atomic::load_acquire(&_active_pending_list);
     size_t count = _pending_lists[index].add(node);
-    if (count <= _config->transfer_threshold()) return;
+    if (count <= transfer_threshold()) return;
   }
   // Attempt transfer when number pending exceeds the transfer threshold.
   try_transfer_pending();