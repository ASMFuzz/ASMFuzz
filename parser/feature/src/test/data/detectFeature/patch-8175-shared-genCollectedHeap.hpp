@@ -417,11 +417,6 @@ class GenCollectedHeap : public CollectedHeap {
   void prepare_for_compaction();
 #endif
 
-  // Perform a full collection of the generations up to and including max_generation.
-  // This is the low level interface used by the public versions of
-  // collect() and collect_locked(). Caller holds the Heap_lock on entry.
-  void collect_locked(GCCause::Cause cause, GenerationType max_generation);
-
   // Save the tops of the spaces in all generations
   void record_gen_tops_before_GC() PRODUCT_RETURN;
 