@@ -51,7 +51,6 @@ MemoryManager*   MemoryService::_code_cache_manager    = NULL;
 GrowableArray<MemoryPool*>* MemoryService::_code_heap_pools =
     new (ResourceObj::C_HEAP, mtServiceability) GrowableArray<MemoryPool*>(init_code_heap_pools_size, mtServiceability);
 MemoryPool*      MemoryService::_metaspace_pool        = NULL;
-MemoryPool*      MemoryService::_compressed_class_pool = NULL;
 
 class GcThreadCountClosure: public ThreadClosure {
  private:
@@ -112,13 +111,6 @@ void MemoryService::add_metaspace_memory_pools() {
   _metaspace_pool = new MetaspacePool();
   mgr->add_pool(_metaspace_pool);
   _pools_list->append(_metaspace_pool);
-
-  if (UseCompressedClassPointers) {
-    _compressed_class_pool = new CompressedKlassSpacePool();
-    mgr->add_pool(_compressed_class_pool);
-    _pools_list->append(_compressed_class_pool);
-  }
-
   _managers_list->append(mgr);
 }
 