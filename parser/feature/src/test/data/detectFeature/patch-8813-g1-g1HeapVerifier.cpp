@@ -485,14 +485,9 @@ void G1HeapVerifier::verify(VerifyOption vo) {
 
   log_debug(gc, verify)("HeapRegions");
 
-  uint num_workers = GCParallelVerificationEnabled ? _g1h->workers()->active_workers() : 1u;
   G1VerifyTask task(_g1h, vo);
-  _g1h->workers()->run_task(&task, num_workers);
-  if (task.failures()) {
-    failures = true;
-  }
-
-  if (failures) {
+  _g1h->workers()->run_task(&task);
+  if (failures || task.failures()) {
     log_error(gc, verify)("Heap after failed verification (kind %u):",
                           static_cast<std::underlying_type_t<VerifyOption>>(vo));
     // It helps to have the per-region information in the output to
@@ -502,8 +497,9 @@ void G1HeapVerifier::verify(VerifyOption vo) {
     ResourceMark rm;
     LogStream ls(log.error());
     _g1h->print_extended_on(&ls);
+
+    fatal("there should not have been any failures");
   }
-  guarantee(!failures, "there should not have been any failures");
 }
 
 // Heap region set verification