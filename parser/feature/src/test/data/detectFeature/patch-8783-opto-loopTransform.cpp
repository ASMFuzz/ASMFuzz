@@ -614,13 +614,16 @@ void PhaseIdealLoop::peeled_dom_test_elim(IdealLoopTree* loop, Node_List& old_ne
 //         after peel and predicate move
 //
 //                   stmt1
+//                     |
+//                     v
+//               loop predicate
 //                    /
 //                   /
 //        clone     /            orig
 //                 /
 //                /              +----------+
 //               /               |          |
-//              /          loop predicate   |
+//              /                |          |
 //             /                 |          |
 //            v                  v          |
 //   TOP-->loop clone          loop<----+   |
@@ -647,7 +650,10 @@ void PhaseIdealLoop::peeled_dom_test_elim(IdealLoopTree* loop, Node_List& old_ne
 //
 //              final graph
 //
-//                  stmt1
+//                 stmt1
+//                    |
+//                    v
+//              loop predicate
 //                    |
 //                    v
 //                  stmt2 clone
@@ -660,7 +666,7 @@ void PhaseIdealLoop::peeled_dom_test_elim(IdealLoopTree* loop, Node_List& old_ne
 //            false  true
 //             |      |
 //             |      v
-//             | loop predicate
+//             | initialized skeleton predicates
 //             |      |
 //             |      v
 //             |     loop<----+
@@ -714,7 +720,9 @@ void PhaseIdealLoop::do_peeling(IdealLoopTree *loop, Node_List &old_new) {
 
   // Step 1: Clone the loop body.  The clone becomes the peeled iteration.
   //         The pre-loop illegally has 2 control users (old & new loops).
-  clone_loop(loop, old_new, dom_depth(head->skip_strip_mined()), ControlAroundStripMined);
+  const uint idx_before_clone = Compile::current()->unique();
+  LoopNode* outer_loop_head = head->skip_strip_mined();
+  clone_loop(loop, old_new, dom_depth(outer_loop_head), ControlAroundStripMined);
 
   // Step 2: Make the old-loop fall-in edges point to the peeled iteration.
   //         Do this by making the old-loop fall-in edges act as if they came
@@ -723,8 +731,8 @@ void PhaseIdealLoop::do_peeling(IdealLoopTree *loop, Node_List &old_new) {
   //         the pre-loop with only 1 user (the new peeled iteration), but the
   //         peeled-loop backedge has 2 users.
   Node* new_entry = old_new[head->in(LoopNode::LoopBackControl)->_idx];
-  _igvn.hash_delete(head->skip_strip_mined());
-  head->skip_strip_mined()->set_req(LoopNode::EntryControl, new_entry);
+  _igvn.hash_delete(outer_loop_head);
+  outer_loop_head->set_req(LoopNode::EntryControl, new_entry);
   for (DUIterator_Fast jmax, j = head->fast_outs(jmax); j < jmax; j++) {
     Node* old = head->fast_out(j);
     if (old->in(0) == loop->_head && old->req() == 3 && old->is_Phi()) {
@@ -753,16 +761,33 @@ void PhaseIdealLoop::do_peeling(IdealLoopTree *loop, Node_List &old_new) {
 
   // Step 4: Correct dom-depth info.  Set to loop-head depth.
 
-  int dd = dom_depth(head->skip_strip_mined());
-  set_idom(head->skip_strip_mined(), head->skip_strip_mined()->in(LoopNode::EntryControl), dd);
+  int dd_outer_loop_head = dom_depth(outer_loop_head);
+  set_idom(outer_loop_head, outer_loop_head->in(LoopNode::EntryControl), dd_outer_loop_head);
   for (uint j3 = 0; j3 < loop->_body.size(); j3++) {
     Node *old = loop->_body.at(j3);
     Node *nnn = old_new[old->_idx];
     if (!has_ctrl(nnn)) {
-      set_idom(nnn, idom(nnn), dd-1);
+      set_idom(nnn, idom(nnn), dd_outer_loop_head-1);
     }
   }
 
+  // Step 5: skeleton_predicates instantiation
+  if (counted_loop && UseLoopPredicate) {
+    CountedLoopNode *cl_head = head->as_CountedLoop();
+    Node* init = cl_head->init_trip();
+    Node* stride = cl_head->stride();
+    IdealLoopTree* outer_loop = get_loop(outer_loop_head);
+    Predicates predicates(new_head->in(LoopNode::EntryControl));
+    initialize_skeleton_predicates_for_peeled_loop(predicates.predicate(),
+                                                   outer_loop_head, dd_outer_loop_head,
+                                                   init, stride, outer_loop,
+                                                   idx_before_clone, old_new);
+    initialize_skeleton_predicates_for_peeled_loop(predicates.profile_predicate(),
+                                                   outer_loop_head, dd_outer_loop_head,
+                                                   init, stride, outer_loop,
+                                                   idx_before_clone, old_new);
+ }
+
   // Now force out all loop-invariant dominating tests.  The optimizer
   // finds some, but we _know_ they are all useless.
   peeled_dom_test_elim(loop,old_new);
@@ -1315,12 +1340,12 @@ void PhaseIdealLoop::copy_skeleton_predicates_to_main_loop_helper(Node* predicat
         // Clone the skeleton predicate twice and initialize one with the initial
         // value of the loop induction variable. Leave the other predicate
         // to be initialized when increasing the stride during loop unrolling.
-        prev_proj = clone_skeleton_predicate_for_main_or_post_loop(iff, opaque_init, NULL, predicate, uncommon_proj,
-                                                                   current_proj, outer_loop, prev_proj);
+        prev_proj = clone_skeleton_predicate_and_initialize(iff, opaque_init, NULL, predicate, uncommon_proj,
+                                                            current_proj, outer_loop, prev_proj);
         assert(skeleton_predicate_has_opaque(prev_proj->in(0)->as_If()), "");
 
-        prev_proj = clone_skeleton_predicate_for_main_or_post_loop(iff, init, stride, predicate, uncommon_proj,
-                                                                   current_proj, outer_loop, prev_proj);
+        prev_proj = clone_skeleton_predicate_and_initialize(iff, init, stride, predicate, uncommon_proj,
+                                                            current_proj, outer_loop, prev_proj);
         assert(!skeleton_predicate_has_opaque(prev_proj->in(0)->as_If()), "");
 
         // Rewire any control inputs from the cloned skeleton predicates down to the main and post loop for data nodes that are part of the
@@ -1473,8 +1498,8 @@ Node* PhaseIdealLoop::clone_skeleton_predicate_bool(Node* iff, Node* new_init, N
 
 // Clone a skeleton predicate for the main loop. new_init and new_stride are set as new inputs. Since the predicates cannot fail at runtime,
 // Halt nodes are inserted instead of uncommon traps.
-Node* PhaseIdealLoop::clone_skeleton_predicate_for_main_or_post_loop(Node* iff, Node* new_init, Node* new_stride, Node* predicate, Node* uncommon_proj,
-                                                                     Node* control, IdealLoopTree* outer_loop, Node* input_proj) {
+Node* PhaseIdealLoop::clone_skeleton_predicate_and_initialize(Node* iff, Node* new_init, Node* new_stride, Node* predicate, Node* uncommon_proj,
+                                                              Node* control, IdealLoopTree* outer_loop, Node* input_proj) {
   Node* result = clone_skeleton_predicate_bool(iff, new_init, new_stride, control);
   Node* proj = predicate->clone();
   Node* other_proj = uncommon_proj->clone();
@@ -2004,8 +2029,8 @@ void PhaseIdealLoop::update_main_loop_skeleton_predicates(Node* ctrl, CountedLoo
         _igvn.replace_input_of(iff, 1, iff->in(1)->in(2));
       } else {
         // Add back predicates updated for the new stride.
-        prev_proj = clone_skeleton_predicate_for_main_or_post_loop(iff, init, max_value, entry, proj, ctrl, outer_loop,
-                                                                   prev_proj);
+        prev_proj = clone_skeleton_predicate_and_initialize(iff, init, max_value, entry, proj, ctrl, outer_loop,
+                                                            prev_proj);
         assert(!skeleton_predicate_has_opaque(prev_proj->in(0)->as_If()), "unexpected");
       }
     }
@@ -2033,8 +2058,8 @@ void PhaseIdealLoop::copy_skeleton_predicates_to_post_loop(LoopNode* main_loop_h
       break;
     }
     if (iff->in(1)->Opcode() == Op_Opaque4 && skeleton_predicate_has_opaque(iff)) {
-      prev_proj = clone_skeleton_predicate_for_main_or_post_loop(iff, init, stride, ctrl, proj, post_loop_entry,
-                                                                 post_loop, prev_proj);
+      prev_proj = clone_skeleton_predicate_and_initialize(iff, init, stride, ctrl, proj, post_loop_entry,
+                                                          post_loop, prev_proj);
       assert(!skeleton_predicate_has_opaque(prev_proj->in(0)->as_If()), "unexpected");
     }
     ctrl = ctrl->in(0)->in(0);
@@ -2045,6 +2070,52 @@ void PhaseIdealLoop::copy_skeleton_predicates_to_post_loop(LoopNode* main_loop_h
   }
 }
 
+void PhaseIdealLoop::initialize_skeleton_predicates_for_peeled_loop(ProjNode* predicate,
+                                                                    LoopNode* outer_loop_head,
+                                                                    int dd_outer_loop_head,
+                                                                    Node* init,
+                                                                    Node* stride,
+                                                                    IdealLoopTree* outer_loop,
+                                                                    const uint idx_before_clone,
+                                                                    const Node_List &old_new) {
+  if (predicate == nullptr) {
+    return;
+  }
+  Node* control = outer_loop_head->in(LoopNode::EntryControl);
+  Node* input_proj = control;
+
+  predicate = next_predicate(predicate);
+  while (predicate != nullptr) {
+    IfNode* iff = predicate->in(0)->as_If();
+    if (iff->in(1)->Opcode() == Op_Opaque4) {
+      assert(skeleton_predicate_has_opaque(iff), "unexpected");
+      ProjNode* uncommon_proj = iff->proj_out(1 - predicate->as_Proj()->_con);
+      input_proj = clone_skeleton_predicate_and_initialize(iff, init, stride, predicate, uncommon_proj, control, outer_loop, input_proj);
+
+      // Rewire any control inputs from the old skeleton predicates above the peeled iteration down to the initialized
+      // skeleton predicates above the peeled loop.
+      for (DUIterator i = predicate->outs(); predicate->has_out(i); i++) {
+        Node* dependent = predicate->out(i);
+        Node* new_node = old_new[dependent->_idx];
+
+        if (!dependent->is_CFG() &&
+            dependent->_idx < idx_before_clone &&  // old node
+            new_node != nullptr &&                 // cloned
+            new_node->_idx >= idx_before_clone) {  // for peeling
+          // The old nodes from the peeled loop still point to the predicate above the peeled loop.
+          // We need to rewire the dependencies to the newly initialized skeleton predicates.
+          _igvn.replace_input_of(dependent, 0, input_proj);
+          --i; // correct for just deleted predicate->out(i)
+        }
+      }
+    }
+    predicate = next_predicate(predicate);
+  }
+
+  _igvn.replace_input_of(outer_loop_head, LoopNode::EntryControl, input_proj);
+  set_idom(outer_loop_head, input_proj, dd_outer_loop_head);
+}
+
 //------------------------------do_unroll--------------------------------------
 // Unroll the loop body one step - make each trip do 2 iterations.
 void PhaseIdealLoop::do_unroll(IdealLoopTree *loop, Node_List &old_new, bool adjust_min_trip) {