@@ -352,15 +352,13 @@ void G1HeapVerifier::verify_archive_regions() {
 
 class VerifyRegionClosure: public HeapRegionClosure {
 private:
-  bool             _par;
   VerifyOption     _vo;
   bool             _failures;
 public:
   // _vo == UsePrevMarking -> use "prev" marking information,
   // _vo == UseFullMarking -> use "next" marking bitmap but no TAMS
-  VerifyRegionClosure(bool par, VerifyOption vo)
-    : _par(par),
-      _vo(vo),
+  VerifyRegionClosure(VerifyOption vo)
+    : _vo(vo),
       _failures(false) {}
 
   bool failures() {
@@ -415,9 +413,9 @@ class VerifyRegionClosure: public HeapRegionClosure {
   }
 };
 
-// This is the task used for parallel verification of the heap regions
+// This is the task used for verification of the heap regions
 
-class G1ParVerifyTask: public WorkerTask {
+class G1VerifyTask: public WorkerTask {
 private:
   G1CollectedHeap*  _g1h;
   VerifyOption      _vo;
@@ -427,8 +425,8 @@ class G1ParVerifyTask: public WorkerTask {
 public:
   // _vo == UsePrevMarking -> use "prev" marking information,
   // _vo == UseFullMarking -> use "next" marking bitmap but no TAMS
-  G1ParVerifyTask(G1CollectedHeap* g1h, VerifyOption vo) :
-      WorkerTask("Parallel verify task"),
+  G1VerifyTask(G1CollectedHeap* g1h, VerifyOption vo) :
+      WorkerTask("Verify task"),
       _g1h(g1h),
       _vo(vo),
       _failures(false),
@@ -439,7 +437,7 @@ class G1ParVerifyTask: public WorkerTask {
   }
 
   void work(uint worker_id) {
-    VerifyRegionClosure blk(true, _vo);
+    VerifyRegionClosure blk(_vo);
     _g1h->heap_region_par_iterate_from_worker_offset(&blk, &_hrclaimer, worker_id);
     if (blk.failures()) {
       _failures = true;
@@ -491,20 +489,12 @@ void G1HeapVerifier::verify(VerifyOption vo) {
   }
 
   log_debug(gc, verify)("HeapRegions");
-  if (GCParallelVerificationEnabled && ParallelGCThreads > 1) {
-
-    G1ParVerifyTask task(_g1h, vo);
-    _g1h->workers()->run_task(&task);
-    if (task.failures()) {
-      failures = true;
-    }
 
-  } else {
-    VerifyRegionClosure blk(false, vo);
-    _g1h->heap_region_iterate(&blk);
-    if (blk.failures()) {
-      failures = true;
-    }
+  uint num_workers = GCParallelVerificationEnabled ? _g1h->workers()->active_workers() : 1u;
+  G1VerifyTask task(_g1h, vo);
+  _g1h->workers()->run_task(&task, num_workers);
+  if (task.failures()) {
+    failures = true;
   }
 
   if (failures) {