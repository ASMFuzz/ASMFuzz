@@ -192,9 +192,6 @@ class GenCollectedHeap : public CollectedHeap {
   // supports. Caller does not hold the Heap_lock on entry.
   virtual void collect(GCCause::Cause cause);
 
-  // The same as above but assume that the caller holds the Heap_lock.
-  void collect_locked(GCCause::Cause cause);
-
   // Perform a full collection of generations up to and including max_generation.
   // Mostly used for testing purposes. Caller does not hold the Heap_lock on entry.
   void collect(GCCause::Cause cause, GenerationType max_generation);