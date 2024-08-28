@@ -49,7 +49,7 @@ char* AllocateHeap(size_t size,
 char* AllocateHeap(size_t size,
                    MEMFLAGS flags,
                    AllocFailType alloc_failmode /* = AllocFailStrategy::EXIT_OOM*/) {
-  return AllocateHeap(size, flags, CALLER_PC);
+  return AllocateHeap(size, flags, CALLER_PC, alloc_failmode);
 }
 
 char* ReallocateHeap(char *old,