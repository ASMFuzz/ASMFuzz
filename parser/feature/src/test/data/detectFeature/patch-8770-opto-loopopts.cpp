@@ -333,9 +333,11 @@ Node *PhaseIdealLoop::has_local_phi_input( Node *n ) {
       // We allow the special case of AddP's with no local inputs.
       // This allows us to split-up address expressions.
       if (m->is_AddP() &&
-          get_ctrl(m->in(2)) != n_ctrl &&
-          get_ctrl(m->in(3)) != n_ctrl) {
-        // Move the AddP up to dominating point
+          get_ctrl(m->in(AddPNode::Base)) != n_ctrl &&
+          get_ctrl(m->in(AddPNode::Address)) != n_ctrl &&
+          get_ctrl(m->in(AddPNode::Offset)) != n_ctrl) {
+        // Move the AddP up to the dominating point. That's fine because control of m's inputs
+        // must dominate get_ctrl(m) == n_ctrl and we just checked that the input controls are != n_ctrl.
         Node* c = find_non_split_ctrl(idom(n_ctrl));
         if (c->is_OuterStripMinedLoop()) {
           c->as_Loop()->verify_strip_mined(1);
@@ -1703,6 +1705,8 @@ void PhaseIdealLoop::try_sink_out_of_loop(Node* n) {
   }
 }
 
+// Compute the early control of a node by following its inputs until we reach
+// nodes that are pinned. Then compute the LCA of the control of all pinned nodes.
 Node* PhaseIdealLoop::compute_early_ctrl(Node* n, Node* n_ctrl) {
   Node* early_ctrl = NULL;
   ResourceMark rm;
@@ -1718,17 +1722,14 @@ Node* PhaseIdealLoop::compute_early_ctrl(Node* n, Node* n_ctrl) {
     } else {
       for (uint j = 0; j < m->req(); j++) {
         Node* in = m->in(j);
-        if (in == NULL) {
-          continue;
+        if (in != NULL) {
+          wq.push(in);
         }
-        wq.push(in);
       }
     }
     if (c != NULL) {
-      assert(is_dominator(c, n_ctrl), "");
-      if (early_ctrl == NULL) {
-        early_ctrl = c;
-      } else if (is_dominator(early_ctrl, c)) {
+      assert(is_dominator(c, n_ctrl), "control input must dominate current control");
+      if (early_ctrl == NULL || is_dominator(early_ctrl, c)) {
         early_ctrl = c;
       }
     }