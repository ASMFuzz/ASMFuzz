@@ -1393,13 +1393,13 @@ void G1Policy::calculate_optional_collection_set_regions(G1CollectionSetCandidat
   assert(_g1h->collector_state()->in_mixed_phase(), "Should only be called in mixed phase");
 
   num_optional_regions = 0;
-  double prediction_ms = 0;
+  double total_prediction_ms = 0.0;
   uint candidate_idx = candidates->cur_idx();
 
   HeapRegion* r = candidates->at(candidate_idx);
   while (num_optional_regions < max_optional_regions) {
     assert(r != NULL, "Region must exist");
-    prediction_ms += predict_region_total_time_ms(r, false);
+    double prediction_ms = predict_region_total_time_ms(r, false);
 
     if (prediction_ms > time_remaining_ms) {
       log_debug(gc, ergo, cset)("Prediction %.3fms for region %u does not fit remaining time: %.3fms.",
@@ -1408,13 +1408,14 @@ void G1Policy::calculate_optional_collection_set_regions(G1CollectionSetCandidat
     }
     // This region will be included in the next optional evacuation.
 
+    total_prediction_ms += prediction_ms;
     time_remaining_ms -= prediction_ms;
     num_optional_regions++;
     r = candidates->at(++candidate_idx);
   }
 
-  log_debug(gc, ergo, cset)("Prepared %u regions out of %u for optional evacuation. Predicted time: %.3fms",
-                            num_optional_regions, max_optional_regions, prediction_ms);
+  log_debug(gc, ergo, cset)("Prepared %u regions out of %u for optional evacuation. Total predicted time: %.3fms",
+                            num_optional_regions, max_optional_regions, total_prediction_ms);
 }
 
 // Number of regions required to store the given number of bytes, taking