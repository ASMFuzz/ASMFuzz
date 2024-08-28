@@ -195,19 +195,3 @@ bool FreeListAllocator::try_transfer_pending() {
   Atomic::release_store(&_transfer_lock, false);
   return true;
 }
-
-size_t FreeListAllocator::reduce_free_list(size_t remove_goal) {
-  try_transfer_pending();
-  size_t removed = 0;
-  for ( ; removed < remove_goal; ++removed) {
-    FreeNode* node = _free_list.pop();
-    if (node == nullptr) break;
-    node->~FreeNode();
-    _config->deallocate(node);
-  }
-  size_t new_count = Atomic::sub(&_free_count, removed);
-  log_debug(gc, freelist)
-           ("Reduced %s free list by " SIZE_FORMAT " to " SIZE_FORMAT,
-            name(), removed, new_count);
-  return removed;
-}