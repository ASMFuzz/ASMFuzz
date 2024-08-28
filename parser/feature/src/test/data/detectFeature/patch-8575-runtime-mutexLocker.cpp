@@ -242,7 +242,6 @@ void mutex_init() {
   }
   def(StringDedup_lock             , PaddedMonitor, nosafepoint);
   def(StringDedupIntern_lock       , PaddedMutex  , nosafepoint);
-  def(ParGCRareEvent_lock          , PaddedMutex  , safepoint, true);
   def(RawMonitor_lock              , PaddedMutex  , nosafepoint-1);
 
   def(Metaspace_lock               , PaddedMutex  , nosafepoint-3);
@@ -361,6 +360,8 @@ void mutex_init() {
   if (UseG1GC) {
     defl(G1OldGCCount_lock         , PaddedMonitor, Threads_lock, true);
   }
+  defl(ParGCRareEvent_lock         , PaddedMutex  , Threads_lock, true);
+
   defl(CompileTaskAlloc_lock       , PaddedMutex ,  MethodCompileQueue_lock);
 #ifdef INCLUDE_PARALLELGC
   if (UseParallelGC) {