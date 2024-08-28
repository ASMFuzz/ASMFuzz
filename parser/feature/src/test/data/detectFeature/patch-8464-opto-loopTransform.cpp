@@ -1605,6 +1605,15 @@ void PhaseIdealLoop::insert_pre_post_loops(IdealLoopTree *loop, Node_List &old_n
   set_idom(new_pre_exit, pre_end, dd_main_head);
   set_loop(new_pre_exit, outer_loop->_parent);
 
+  if (peel_only) {
+    // Nodes in the peeled iteration that were marked as reductions within the
+    // original loop might not be reductions within their new outer loop.
+    for (uint i = 0; i < loop->_body.size(); i++) {
+      Node* n = old_new[loop->_body[i]->_idx];
+      n->remove_flag(Node::Flag_is_reduction);
+    }
+  }
+
   // Step B2: Build a zero-trip guard for the main-loop.  After leaving the
   // pre-loop, the main-loop may not execute at all.  Later in life this
   // zero-trip guard will become the minimum-trip guard when we unroll