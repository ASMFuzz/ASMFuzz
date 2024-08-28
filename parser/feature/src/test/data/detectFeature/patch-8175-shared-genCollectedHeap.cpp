@@ -843,28 +843,24 @@ void GenCollectedHeap::collect(GCCause::Cause cause) {
 void GenCollectedHeap::collect(GCCause::Cause cause, GenerationType max_generation) {
   // The caller doesn't have the Heap_lock
   assert(!Heap_lock->owned_by_self(), "this thread should not own the Heap_lock");
-  MutexLocker ml(Heap_lock);
-  collect_locked(cause, max_generation);
-}
 
-// this is the private collection interface
-// The Heap_lock is expected to be held on entry.
+  unsigned int gc_count_before;
+  unsigned int full_gc_count_before;
 
-void GenCollectedHeap::collect_locked(GCCause::Cause cause, GenerationType max_generation) {
-  // Read the GC count while holding the Heap_lock
-  unsigned int gc_count_before      = total_collections();
-  unsigned int full_gc_count_before = total_full_collections();
+  {
+    MutexLocker ml(Heap_lock);
+    // Read the GC count while holding the Heap_lock
+    gc_count_before      = total_collections();
+    full_gc_count_before = total_full_collections();
+  }
 
   if (GCLocker::should_discard(cause, gc_count_before)) {
     return;
   }
 
-  {
-    MutexUnlocker mu(Heap_lock);  // give up heap lock, execute gets it back
-    VM_GenCollectFull op(gc_count_before, full_gc_count_before,
-                         cause, max_generation);
-    VMThread::execute(&op);
-  }
+  VM_GenCollectFull op(gc_count_before, full_gc_count_before,
+                       cause, max_generation);
+  VMThread::execute(&op);
 }
 
 void GenCollectedHeap::do_full_collection(bool clear_all_soft_refs) {