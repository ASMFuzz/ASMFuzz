@@ -683,8 +683,7 @@ void G1Policy::record_young_collection_end(bool concurrent_operation_is_full_mar
   } else if (G1GCPauseTypeHelper::is_mixed_pause(this_pause)) {
     // This is a mixed GC. Here we decide whether to continue doing more
     // mixed GCs or not.
-    if (!next_gc_should_be_mixed("continue mixed GCs",
-                                 "do not continue mixed GCs")) {
+    if (!next_gc_should_be_mixed("do not continue mixed GCs")) {
       collector_state()->set_in_young_only_phase(true);
 
       clear_collection_set_candidates();
@@ -1125,7 +1124,7 @@ void G1Policy::record_concurrent_mark_cleanup_end(bool has_rebuilt_remembered_se
   if (has_rebuilt_remembered_sets) {
     G1CollectionSetCandidates* candidates = G1CollectionSetChooser::build(_g1h->workers(), _g1h->num_regions());
     _collection_set->set_candidates(candidates);
-    mixed_gc_pending = next_gc_should_be_mixed("request mixed gcs", "request young-only gcs");
+    mixed_gc_pending = next_gc_should_be_mixed("request young-only gcs");
   }
 
   if (log_is_enabled(Trace, gc, liveness)) {
@@ -1248,16 +1247,16 @@ void G1Policy::abort_time_to_mixed_tracking() {
   _concurrent_start_to_mixed.reset();
 }
 
-bool G1Policy::next_gc_should_be_mixed(const char* true_action_str,
-                                       const char* false_action_str) const {
+bool G1Policy::next_gc_should_be_mixed(const char* no_candidates_str) const {
   G1CollectionSetCandidates* candidates = _collection_set->candidates();
 
   if (candidates == NULL || candidates->is_empty()) {
-    log_debug(gc, ergo)("%s (candidate old regions not available)", false_action_str);
+    log_debug(gc, ergo)("%s (candidate old regions not available)", no_candidates_str);
     return false;
   }
-  // Go through all regions - we already pruned regions not worth collecting
-  // during candidate selection.
+  // Otherwise always continue mixed collection. There is no other reason to stop the
+  // mixed phase than there are no more candidates. All candidates not pruned earlier
+  // during candidate selection are worth collecting.
   return true;
 }
 