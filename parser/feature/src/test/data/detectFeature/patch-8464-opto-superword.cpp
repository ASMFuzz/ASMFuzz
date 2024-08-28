@@ -110,6 +110,8 @@ bool SuperWord::transform_loop(IdealLoopTree* lpt, bool do_optimization) {
     return false; // skip malformed counted loop
   }
 
+  assert(!lpt->has_reduction_nodes() || cl->is_reduction_loop(),
+         "non-reduction loop contains reduction nodes");
   if (cl->is_rce_post_loop() && cl->is_reduction_loop()) {
     // Post loop vectorization doesn't support reductions
     return false;