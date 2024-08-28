@@ -57,7 +57,6 @@ class MemoryService : public AllStatic {
   static GrowableArray<MemoryPool*>*    _code_heap_pools;
 
   static MemoryPool*                    _metaspace_pool;
-  static MemoryPool*                    _compressed_class_pool;
 
 public:
   static void set_universe_heap(CollectedHeap* heap);
@@ -92,9 +91,6 @@ class MemoryService : public AllStatic {
   static void track_metaspace_memory_usage() {
     track_memory_pool_usage(_metaspace_pool);
   }
-  static void track_compressed_class_memory_usage() {
-    track_memory_pool_usage(_compressed_class_pool);
-  }
   static void track_memory_pool_usage(MemoryPool* pool);
 
   static void gc_begin(GCMemoryManager* manager, bool recordGCBeginTime,