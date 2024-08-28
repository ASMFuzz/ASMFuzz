@@ -853,6 +853,7 @@ bool PhaseIdealLoop::create_loop_nest(IdealLoopTree* loop, Node_List &old_new) {
   if (bt == T_INT && head->as_CountedLoop()->is_strip_mined()) {
     // Loop is strip mined: use the safepoint of the outer strip mined loop
     OuterStripMinedLoopNode* outer_loop = head->as_CountedLoop()->outer_loop();
+    assert(outer_loop != NULL, "no outer loop");
     safepoint = outer_loop->outer_safepoint();
     outer_loop->transform_to_counted_loop(&_igvn, this);
     exit_test = head->loopexit();