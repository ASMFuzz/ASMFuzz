@@ -847,12 +847,6 @@ void GenCollectedHeap::collect(GCCause::Cause cause, GenerationType max_generati
   collect_locked(cause, max_generation);
 }
 
-void GenCollectedHeap::collect_locked(GCCause::Cause cause) {
-  // The caller has the Heap_lock
-  assert(Heap_lock->owned_by_self(), "this thread should own the Heap_lock");
-  collect_locked(cause, OldGen);
-}
-
 // this is the private collection interface
 // The Heap_lock is expected to be held on entry.
 