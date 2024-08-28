@@ -162,11 +162,4 @@ class MetaspacePool : public MemoryPool {
   size_t used_in_bytes();
 };
 
-class CompressedKlassSpacePool : public MemoryPool {
- public:
-  CompressedKlassSpacePool();
-  MemoryUsage get_memory_usage();
-  size_t used_in_bytes();
-};
-
 #endif // SHARE_SERVICES_MEMORYPOOL_HPP