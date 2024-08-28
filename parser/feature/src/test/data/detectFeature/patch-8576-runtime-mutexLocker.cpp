@@ -365,8 +365,8 @@ void mutex_init() {
 
   if (UseG1GC) {
     defl(G1OldGCCount_lock         , PaddedMonitor, Threads_lock, true);
+    defl(ParGCRareEvent_lock       , PaddedMutex  , Threads_lock, true);
   }
-  defl(ParGCRareEvent_lock         , PaddedMutex  , Threads_lock, true);
 
   defl(CompileTaskAlloc_lock       , PaddedMutex ,  MethodCompileQueue_lock);
 #ifdef INCLUDE_PARALLELGC