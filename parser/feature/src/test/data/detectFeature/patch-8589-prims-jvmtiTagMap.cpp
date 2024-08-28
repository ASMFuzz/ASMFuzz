@@ -1155,7 +1155,7 @@ void JvmtiTagMap::iterate_through_heap(jint heap_filter,
 {
   // EA based optimizations on tagged objects are already reverted.
   // disabled if vritual threads are enabled with --enable-preview
-  EscapeBarrier eb(!Continuations::enabled() && !(heap_filter & JVMTI_HEAP_FILTER_UNTAGGED), JavaThread::current());
+  EscapeBarrier eb(!(heap_filter & JVMTI_HEAP_FILTER_UNTAGGED), JavaThread::current());
   eb.deoptimize_objects_all_threads();
   MutexLocker ml(Heap_lock);
   IterateThroughHeapObjectClosure blk(this,