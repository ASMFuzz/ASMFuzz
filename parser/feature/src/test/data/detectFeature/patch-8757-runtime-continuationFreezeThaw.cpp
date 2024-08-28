@@ -1285,8 +1285,8 @@ stackChunkOop Freeze<ConfigT>::allocate_chunk(size_t stack_size) {
   if (fast_oop != nullptr) {
     assert(!chunk->requires_barriers(), "Unfamiliar GC requires barriers on TLAB allocation");
   } else {
-    assert(!UseZGC || !chunk->requires_barriers(), "Allocated ZGC object requires barriers");
-    _barriers = !UseZGC && chunk->requires_barriers();
+    assert(!UseZGC || !UseShenandoahGC || !chunk->requires_barriers(), "Allocated ZGC/ShenandoahGC object requires barriers");
+    _barriers = !UseZGC && !UseShenandoahGC && chunk->requires_barriers();
 
     if (_barriers) {
       log_develop_trace(continuations)("allocation requires barriers");