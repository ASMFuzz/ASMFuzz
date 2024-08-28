@@ -184,6 +184,8 @@ MemoryUsage CodeHeapPool::get_memory_usage() {
   return MemoryUsage(initial_size(), used, committed, maxSize);
 }
 
+// Note, any NonHeap pools would be counted into Non-Heap memory by MemoryMXBean.getNonHeapMemoryUsage.
+// Make sure that it behaves as you expected if you want to add a new type of NonHeap pool
 MetaspacePool::MetaspacePool() :
   MemoryPool("Metaspace", NonHeap, 0, calculate_max_size(), true, false) { }
 
@@ -200,15 +202,3 @@ size_t MetaspacePool::calculate_max_size() const {
   return !FLAG_IS_DEFAULT(MaxMetaspaceSize) ? MaxMetaspaceSize :
                                               MemoryUsage::undefined_size();
 }
-
-CompressedKlassSpacePool::CompressedKlassSpacePool() :
-  MemoryPool("Compressed Class Space", NonHeap, 0, CompressedClassSpaceSize, true, false) { }
-
-size_t CompressedKlassSpacePool::used_in_bytes() {
-  return MetaspaceUtils::used_bytes(Metaspace::ClassType);
-}
-
-MemoryUsage CompressedKlassSpacePool::get_memory_usage() {
-  MetaspaceStats stats = MetaspaceUtils::get_statistics(Metaspace::ClassType);
-  return MemoryUsage(initial_size(), stats.used(), stats.committed(), max_size());
-}