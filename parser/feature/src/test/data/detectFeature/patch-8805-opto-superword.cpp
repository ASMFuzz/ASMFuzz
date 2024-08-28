@@ -110,8 +110,6 @@ bool SuperWord::transform_loop(IdealLoopTree* lpt, bool do_optimization) {
     return false; // skip malformed counted loop
   }
 
-  assert(!lpt->has_reduction_nodes() || cl->is_reduction_loop(),
-         "non-reduction loop contains reduction nodes");
   if (cl->is_rce_post_loop() && cl->is_reduction_loop()) {
     // Post loop vectorization doesn't support reductions
     return false;
@@ -2399,6 +2397,11 @@ bool SuperWord::output() {
     return false;
   }
 
+  // Check that the loop to be vectorized does not have inconsistent reduction
+  // information, which would likely lead to a miscompilation.
+  assert(!lpt()->has_reduction_nodes() || cl->is_reduction_loop(),
+         "non-reduction loop contains reduction nodes");
+
 #ifndef PRODUCT
   if (TraceLoopOpts) {
     tty->print("SuperWord::output    ");