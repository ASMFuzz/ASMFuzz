@@ -66,9 +66,7 @@ inline HeapWord* BlockOffsetSharedArray::address_for_index(size_t index) const {
 inline void BlockOffsetSharedArray::check_reducing_assertion(bool reducing) {
     assert(reducing || !SafepointSynchronize::is_at_safepoint() || init_to_zero() ||
            Thread::current()->is_VM_thread() ||
-           Thread::current()->is_ConcurrentGC_thread() ||
-           ((!Thread::current()->is_ConcurrentGC_thread()) &&
-            ParGCRareEvent_lock->owned_by_self()), "Crack");
+           Thread::current()->is_ConcurrentGC_thread(), "Crack");
 }
 
 #endif // SHARE_GC_SHARED_BLOCKOFFSETTABLE_INLINE_HPP