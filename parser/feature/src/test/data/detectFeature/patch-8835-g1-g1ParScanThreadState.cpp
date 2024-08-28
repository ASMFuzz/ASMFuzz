@@ -626,7 +626,7 @@ oop G1ParScanThreadState::handle_evacuation_failure_par(oop old, markWord m, siz
     // Objects failing evacuation will turn into old objects since the regions
     // are relabeled as such. We mark the failing objects in the prev bitmap and
     // later use it to handle all failed objects.
-    _g1h->mark_evac_failure_object(old, _worker_id);
+    _g1h->mark_evac_failure_object(old);
 
     if (_evac_failure_regions->record(r->hrm_index())) {
       _g1h->hr_printer()->evac_failure(r);