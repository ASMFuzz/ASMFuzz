@@ -39,6 +39,7 @@
 #include "opto/phaseX.hpp"
 #include "opto/movenode.hpp"
 #include "opto/rootnode.hpp"
+#include "opto/castnode.hpp"
 #include "utilities/macros.hpp"
 
 ConnectionGraph::ConnectionGraph(Compile * C, PhaseIterGVN *igvn, int invocation) :
@@ -66,6 +67,12 @@ ConnectionGraph::ConnectionGraph(Compile * C, PhaseIterGVN *igvn, int invocation
     assert(noop_null->_idx < nodes_size(), "should be created already");
     map_ideal_node(noop_null, null_obj);
   }
+
+#ifndef PRODUCT
+  _collectingTrace = (SaveEATraceToFile != NULL &&
+                      (!strcmp(SaveEATraceToFile, "all") ||
+                        (strstr(SaveEATraceToFile, _compile->method()->holder()->name()->as_utf8()) != NULL && strstr(SaveEATraceToFile, _compile->method()->name()->as_utf8()) != NULL)));
+#endif
 }
 
 bool ConnectionGraph::has_candidates(Compile *C) {
@@ -91,7 +98,7 @@ bool ConnectionGraph::has_candidates(Compile *C) {
   return false;
 }
 
-void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn) {
+void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn, bool only_analysis) {
   Compile::TracePhase tp("escapeAnalysis", &Phase::timers[Phase::_t_escapeAnalysis]);
   ResourceMark rm;
 
@@ -104,8 +111,9 @@ void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn) {
     invocation = C->congraph()->_invocation + 1;
   }
   ConnectionGraph* congraph = new(C->comp_arena()) ConnectionGraph(C, igvn, invocation);
+  NOT_PRODUCT( congraph->dump_ir("IR before EA Starts."); )
   // Perform escape analysis
-  if (congraph->compute_escape()) {
+  if (congraph->compute_escape(only_analysis)) {
     // There are non escaping objects.
     C->set_congraph(congraph);
   }
@@ -116,9 +124,10 @@ void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn) {
   if (noop_null->outcnt() == 0) {
     igvn->hash_delete(noop_null);
   }
+  NOT_PRODUCT( congraph->dump_ir("IR after EA execution."); )
 }
 
-bool ConnectionGraph::compute_escape() {
+bool ConnectionGraph::compute_escape(bool only_analysis) {
   Compile* C = _compile;
   PhaseGVN* igvn = _igvn;
 
@@ -259,6 +268,13 @@ bool ConnectionGraph::compute_escape() {
     return false;
   }
 
+  if (only_analysis) {
+    _collecting = false;
+    return non_escaped_allocs_worklist.length() > 0;
+  }
+
+  NOT_PRODUCT( dump(ptnodes_worklist, "Before adjust_scalar_replaceable_state"); )
+
   // 3. Adjust scalar_replaceable state of nonescaping objects and push
   //    scalar replaceable allocations on alloc_worklist for processing
   //    in split_unique_types().
@@ -278,6 +294,8 @@ bool ConnectionGraph::compute_escape() {
     }
   }
 
+  NOT_PRODUCT( dump(ptnodes_worklist, "After adjust_scalar_replaceable_state"); )
+
 #ifdef ASSERT
   if (VerifyConnectionGraph) {
     // Verify that graph is complete - no new edges could be added or needed.
@@ -295,15 +313,17 @@ bool ConnectionGraph::compute_escape() {
 
   } // TracePhase t3("connectionGraph")
 
+
   // 4. Optimize ideal graph based on EA information.
   bool has_non_escaping_obj = (non_escaped_allocs_worklist.length() > 0);
+
   if (has_non_escaping_obj) {
     optimize_ideal_graph(ptr_cmp_worklist, storestore_worklist);
   }
 
 #ifndef PRODUCT
   if (PrintEscapeAnalysis) {
-    dump(ptnodes_worklist); // Dump ConnectionGraph
+    dump(ptnodes_worklist, ""); // Dump ConnectionGraph
   }
 #endif
 
@@ -318,6 +338,8 @@ bool ConnectionGraph::compute_escape() {
   }
 #endif
 
+  NOT_PRODUCT( save_trace(); )
+
   // 5. Separate memory graph for scalar replaceable allcations.
   bool has_scalar_replaceable_candidates = (alloc_worklist.length() > 0);
   if (has_scalar_replaceable_candidates &&
@@ -719,7 +741,7 @@ void ConnectionGraph::add_final_edges(Node *n) {
           continue;  // ignore top or inputs which go back this node
         }
         PointsToNode* ptn = ptnode_adr(in->_idx);
-        assert(ptn != NULL, "node should be registered");
+        assert(ptn != NULL, "node should be registered. %d\n", in->_idx);
         add_edge(n_ptn, ptn);
       }
       break;
@@ -1813,6 +1835,7 @@ void ConnectionGraph::adjust_scalar_replaceable_state(JavaObjectNode* jobj) {
         // Mark all objects.
         jobj->set_scalar_replaceable(false);
          ptn->set_scalar_replaceable(false);
+         NOT_PRODUCT( _traceStream.print_cr("Marking object %d and %d as NSR because of constraint 3.", jobj->ideal_node()->_idx, ptn->ideal_node()->_idx); )
       }
     }
     if (!jobj->scalar_replaceable()) {
@@ -1885,6 +1908,7 @@ void ConnectionGraph::adjust_scalar_replaceable_state(JavaObjectNode* jobj) {
           // Mark all bases.
           jobj->set_scalar_replaceable(false);
           base->set_scalar_replaceable(false);
+         NOT_PRODUCT( _traceStream.print_cr("Marking object %d and %d as NSR because of constraint 3.", jobj->ideal_node()->_idx, base->ideal_node()->_idx); )
         }
       }
     }
@@ -3608,7 +3632,267 @@ void ConnectionGraph::split_unique_types(GrowableArray<Node *>  &alloc_worklist,
 #endif
 }
 
+//
+// We are only going to split nodes that match the following requirements:
+//  - It's a Phi node and EA has deemed it as NoEscape.
+//  - At least one of the merge inputs of the Phi points to an Allocate node.
+// The only uses of the Phi node are:
+//  - AddP without a control input and with a single Load node as output.
+bool ConnectionGraph::should_split_this_phi(Node* n, Unique_Node_List& splitted_phi_nodes) {
+  if (!n->is_Phi())                     return false;
+  if (!is_ideal_node_in_graph(n->_idx)) return false;
+
+  PointsToNode* ptn = ptnode_adr(n->_idx);
+
+  if (ptn == NULL)                                                return false;
+  if (ptn->escape_state() != PointsToNode::EscapeState::NoEscape) return false;
+
+  bool should_split = false;
+  Unique_Node_List allocates;
+
+  // Check if this Phi node actually point to an Allocate node
+  for (EdgeIterator i(ptn); i.has_next(); i.next()) {
+    PointsToNode* e = i.get();
+
+    if (e->ideal_node()->is_Allocate()) {
+      should_split = true;
+      allocates.push(e->ideal_node());
+    }
+  }
+
+  if (!should_split) return false;
+
+  // Check the uses of this Phi to see if we can handle them properly
+  for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+    Node* phi_use = n->fast_out(i);
+
+    // For now we only handle AddP's that have a single Load node as output
+    if (phi_use->is_AddP()) {
+      NOT_PRODUCT(tty->print("\t\tPhi use is AddP. %d\n", phi_use->_idx);)
+
+      if (phi_use->outcnt() != 1 || !phi_use->raw_out(0)->is_Load() || phi_use->in(TypeFunc::Control) != NULL) {
+        NOT_PRODUCT(tty->print("\t\tAddP (%d), ctrl is NULL? %d, have (%d) use(s). First one is a %s\n", phi_use->_idx, phi_use->outcnt(), phi_use->in(TypeFunc::Control) != NULL, phi_use->raw_out(0)->Name());)
+        should_split = false;
+      }
+    }
+    else {
+      NOT_PRODUCT(tty->print("\t\tPhi use is not AddP: %s\n", phi_use->Name());)
+      should_split = false;
+    }
+  }
+
+  // We'll check that all nodes in splitted_phi_nodes were removed from
+  // the IR graph after macro node expansion. We should only check that
+  // the allocates were removed if we indeed ran split_phi_bases.
+  if (should_split) {
+    for (uint next = 0; next < allocates.size(); ++next) {
+      Node* allocate = allocates.at(next);
+      splitted_phi_nodes.push(allocate);
+    }
+  }
+
+  return should_split;
+}
+
+void ConnectionGraph::split_bases(Unique_Node_List& splitted_phi_nodes) {
+  Unique_Node_List ideal_nodes;
+  ideal_nodes.map(_compile->live_nodes(), NULL);
+  ideal_nodes.push(_compile->root());
+
+  bool prev_delay_transform = _igvn->delay_transform();
+  _igvn->set_delay_transform(true);
+
+  NOT_PRODUCT(dump_ir("Before Split_Bases");)
+
+  // Iterate over all IR nodes looking for Regions.
+  //   When a region is found we'll look for Phi nodes coming out of the region.
+  //     When we find a Phi node we check if we can/need to split it.
+  for (uint next = 0; next < ideal_nodes.size(); ++next) {
+    Node* candidate_region = ideal_nodes.at(next);
+
+    if (candidate_region->is_Region()) {
+      // current_parent_control is the node that produces Control for the next
+      // IfNode that checks which base should be used when we split a Phi.
+      Node* current_parent_control = candidate_region;
+      Unique_Node_List uses_of_region;
+
+      for (DUIterator i = candidate_region->outs(); candidate_region->has_out(i); i++) {
+        uses_of_region.push(candidate_region->out(i));
+      }
+
+      // Search for a Phi node.
+      for (uint region_use_idx = 0; region_use_idx < uses_of_region.size(); ++region_use_idx) {
+        Node* candidate_phi = uses_of_region.at(region_use_idx);
+
+        // Performs several checks to see if we can/should split this Phi
+        if (should_split_this_phi(candidate_phi, splitted_phi_nodes)) {
+          NOT_PRODUCT(tty->print("Orig_Region: %d\n", candidate_region->_idx);)
+          NOT_PRODUCT(tty->print("\tOrig_Phi: %d\n", candidate_phi->_idx);)
+
+          // We decided to split the Phi node. Now we go over each of it's use
+          // and patch them to use the Phi inputs directly - conditioned on the
+          // selector If.
+          for (uint i = 0; i < candidate_phi->outcnt(); i++) {
+            Node* original_phi_use = candidate_phi->raw_out(i);
+
+            if (original_phi_use->is_AddP()) {
+              current_parent_control = split_phi_for_addp(candidate_phi, original_phi_use, current_parent_control, splitted_phi_nodes);
+            }
+            else {
+              assert(false, "Unsupported Phi use.");
+            }
+          }
+        }
+      }
+
+      // Patch all CFG nodes coming out of this Region. They now should be users of
+      // current_parent_control - which at this point is the Region node merging the
+      // branches of the selector If.
+      for (uint region_use_idx = 0; region_use_idx < uses_of_region.size(); ++region_use_idx) {
+        Node* possible_cfg_node = uses_of_region.at(region_use_idx);
+
+        // We don't want to replace the self loop of the region by something else
+        if (possible_cfg_node->_idx == candidate_region->_idx) continue;
+
+        if (possible_cfg_node->is_CFG()) {
+          _igvn->_worklist.push(possible_cfg_node);
+          possible_cfg_node->replace_edge(candidate_region, current_parent_control, _igvn);
+        }
+      }
+    }
+
+    for (DUIterator_Fast imax, i = candidate_region->fast_outs(imax); i < imax; i++) {
+      Node* m = candidate_region->fast_out(i);
+      ideal_nodes.push(m);
+    }
+  }
+
+  NOT_PRODUCT( dump_ir("After Split_Bases"); )
+
+_igvn->set_delay_transform(prev_delay_transform);
+}
+
+Node* ConnectionGraph::create_selector_phi(Node* orig_phi) {
+  Node* selector_phi = _igvn->transform(new PhiNode(orig_phi->in(TypeFunc::Control), TypeInt::INT));
+
+  for (uint i=1; i<orig_phi->req(); i++) {
+    Node* coni = _igvn->transform(ConINode::make(_compile->next_unique_base_id()));
+    selector_phi->set_req(i, coni);
+  }
+
+  return selector_phi;
+}
+
+Node* ConnectionGraph::split_phi_for_addp(Node* original_phi, Node* original_addp, Node* prev_control, Unique_Node_List& splitted_phi_nodes) {
+  Node* selector_phi       = create_selector_phi(original_phi);
+  Node* original_load      = original_addp->raw_out(0); // For now we only handle AddPs with single output
+  Node* ctrl_of_next_if    = (original_addp->in(TypeFunc::Control) != NULL) ? original_addp->in(TypeFunc::Control) : prev_control;
+  Node* final_merge_region = _igvn->transform(new RegionNode(selector_phi->req()));
+  Node* final_merge_phi    = _igvn->transform(PhiNode::make_blank(original_phi->in(0), original_load));
+
+  NOT_PRODUCT(tty->print("\t\tOrig_Use: %d\n", original_addp->_idx);)
+  NOT_PRODUCT(tty->print("\t\tOrig_Use_Use: %d\n", original_load->_idx);)
+
+  // Iterate over the different inputs of the original Phi and
+  // attach an AddP->Load directly to each input.
+  for (uint idx=1; idx < selector_phi->req()-1; idx++ ) {
+    Node* coni    = selector_phi->in(idx);
+    Node* cmp     = _igvn->transform(new CmpINode(selector_phi, coni));
+    Node* boo     = _igvn->transform(new BoolNode(cmp, BoolTest::eq));
+    Node* iff     = _igvn->transform(new IfNode(ctrl_of_next_if, boo, 0, .0f));
+    Node* iftrue  = _igvn->transform(new IfTrueNode(iff->as_If()));
+    Node* iffalse = _igvn->transform(new IfFalseNode(iff->as_If()));
+
+    // Will clone original_addp and original_load and nest them under iftrue
+    clone_addp_and_load_chain(original_phi, idx, original_addp, original_load, splitted_phi_nodes, final_merge_region, final_merge_phi, iftrue);
+
+    ctrl_of_next_if = iffalse;
+  }
+
+  // Will clone original_addp and original_load and nest them under ctrl_of_next_if (i.e., last iffalse)
+  clone_addp_and_load_chain(original_phi, selector_phi->req()-1, original_addp, original_load, splitted_phi_nodes, final_merge_region, final_merge_phi, ctrl_of_next_if);
+
+  _igvn->hash_delete(original_load);
+  _igvn->hash_delete(final_merge_phi);
+
+  Unique_Node_List uses_of_original_load;
+  for (DUIterator i = original_load->outs(); original_load->has_out(i); i++) {
+    uses_of_original_load.push(original_load->out(i));
+  }
+
+  for(uint next = 0; next < uses_of_original_load.size(); ++next ) {
+    Node* use_of_original_load = uses_of_original_load.at(next);
+
+    _igvn->hash_delete(use_of_original_load);
+    _igvn->_worklist.push(use_of_original_load);
+
+    // Replace the uses of the original Load by uses of a Phi merging the cloned Loads
+    use_of_original_load->replace_edge(original_load, final_merge_phi, _igvn);
+  }
+
+  _igvn->hash_insert(original_load);
+  _igvn->hash_insert(final_merge_phi);
+
+  _igvn->remove_dead_node(original_load);
+  _igvn->remove_dead_node(original_addp);
+
+  NOT_PRODUCT(tty->print("\t\tdata_merge_phi: %d\n", final_merge_phi->_idx));
+  NOT_PRODUCT(tty->print("\t\tfinal_merge_region: %d\n", final_merge_region->_idx));
+
+  return final_merge_region;
+}
+
+void ConnectionGraph::clone_addp_and_load_chain(Node* original_phi, uint idx, Node* original_addp, Node* original_load, Unique_Node_List& splitted_phi_nodes, Node* final_merge_region, Node* final_merge_phi, Node* merge_ctrl) {
+  Node* new_addp = _igvn->transform(original_addp->clone());
+  Node* new_load = _igvn->transform(original_load->clone());
+
+  new_addp->replace_edge(original_phi, original_phi->in(idx));
+
+  // If the AddP "adr" is different from the "base" we need to create an
+  // unique "adr" input for it as well
+  if (new_addp->in(AddPNode::Base) != new_addp->in(AddPNode::Address)) {
+    Node* orig_addp_adr   = new_addp->in(AddPNode::Address);
+
+    new_addp->replace_edge(orig_addp_adr, orig_addp_adr->is_Phi() ? orig_addp_adr->in(idx) : orig_addp_adr);
+  }
+
+  new_load->replace_edge(original_addp, new_addp);
+
+  // Create unique input for "memory" of Load
+  Node* orig_load_mem   = original_load->in(LoadNode::Memory);
+  new_load->replace_edge(orig_load_mem, orig_load_mem->is_Phi() ? orig_load_mem->in(idx) : orig_load_mem);
+
+  final_merge_region->set_req(idx, merge_ctrl);
+  final_merge_phi->set_req(idx, new_load);
+}
+
+bool ConnectionGraph::were_splitted_bases_removed(Unique_Node_List& splitted_phi_nodes) {
+  Unique_Node_List ideal_nodes;
+
+  ideal_nodes.map(_compile->live_nodes(), NULL);
+  ideal_nodes.push(_compile->root());
+
+  for( uint next = 0; next < ideal_nodes.size(); ++next ) {
+    Node* n = ideal_nodes.at(next);
+
+    if (splitted_phi_nodes.member(n)) {
+      NOT_PRODUCT(tty->print_cr("Node %d (%s) wasn't removed from IR graph.", n->_idx, n->Name()));
+      return false;
+    }
+
+    for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+      Node* m = n->fast_out(i);
+      ideal_nodes.push(m);
+    }
+  }
+
+  return true;
+}
+
 #ifndef PRODUCT
+
+bool ConnectionGraph::_collectingTrace = false;
+
 static const char *node_type_names[] = {
   "UnknownType",
   "JavaObject",
@@ -3624,92 +3908,139 @@ static const char *esc_names[] = {
   "GlobalEscape"
 };
 
-void PointsToNode::dump(bool print_state) const {
+void PointsToNode::dump(outputStream* st, bool print_state) const {
+  if (st == NULL)
+    st = tty;
+
   NodeType nt = node_type();
-  tty->print("%s ", node_type_names[(int) nt]);
+  st->print("%11s ", node_type_names[(int) nt]);
+
   if (print_state) {
     EscapeState es = escape_state();
     EscapeState fields_es = fields_escape_state();
-    tty->print("%s(%s) ", esc_names[(int)es], esc_names[(int)fields_es]);
-    if (nt == PointsToNode::JavaObject && !this->scalar_replaceable()) {
-      tty->print("NSR ");
-    }
+    st->print("%13s(%13s) ", esc_names[(int)es], esc_names[(int)fields_es]);
+    st->print("%s ", (nt == PointsToNode::JavaObject && this->scalar_replaceable()) ? "  SR" : " NSR");
   }
+
   if (is_Field()) {
-    FieldNode* f = (FieldNode*)this;
-    if (f->is_oop()) {
-      tty->print("oop ");
+    if (this->_idx == 140) {
+      st->cr();
     }
-    if (f->offset() > 0) {
-      tty->print("+%d ", f->offset());
-    }
-    tty->print("(");
+
+    FieldNode* f = (FieldNode*)this;
+    st->print("OOP? %d ", f->is_oop());
+    st->print("Off? %04d ", f->offset() > 0 ? f->offset() : 0);
+
+    st->print("Base pointers: [");
     for (BaseIterator i(f); i.has_next(); i.next()) {
       PointsToNode* b = i.get();
-      tty->print(" %d%s", b->idx(),(b->is_JavaObject() ? "P" : ""));
+      st->print(" %04d%s", b->idx(),(b->is_JavaObject() ? "P" : ""));
     }
-    tty->print(" )");
+    st->print(" ]");
+  }
+  else {
+    st->print("%40c", ' ');
   }
-  tty->print("[");
+  st->print(" Points to: [");
   for (EdgeIterator i(this); i.has_next(); i.next()) {
     PointsToNode* e = i.get();
-    tty->print(" %d%s%s", e->idx(),(e->is_JavaObject() ? "P" : (e->is_Field() ? "F" : "")), e->is_Arraycopy() ? "cp" : "");
+    st->print(" %04d%s%s", e->idx(),(e->is_JavaObject() ? "P" : (e->is_Field() ? "F" : "")), e->is_Arraycopy() ? "cp" : "");
   }
-  tty->print(" [");
+  st->print("] Pointed by: [");
   for (UseIterator i(this); i.has_next(); i.next()) {
     PointsToNode* u = i.get();
     bool is_base = false;
     if (PointsToNode::is_base_use(u)) {
       is_base = true;
       u = PointsToNode::get_use_node(u)->as_Field();
     }
-    tty->print(" %d%s%s", u->idx(), is_base ? "b" : "", u->is_Arraycopy() ? "cp" : "");
+    st->print(" %04d%s%s", u->idx(), is_base ? "b" : "", u->is_Arraycopy() ? "cp" : "");
   }
-  tty->print(" ]]  ");
+  st->print(" ]  ---> IR Node: ");
   if (_node == NULL) {
-    tty->print_cr("<null>");
-  } else {
-    _node->dump();
+    st->print_cr("<null>");
+  }
+  else {
+    _node->dump("", false, st);
   }
 }
 
-void ConnectionGraph::dump(GrowableArray<PointsToNode*>& ptnodes_worklist) {
+void ConnectionGraph::dump(GrowableArray<PointsToNode*>& ptnodes_worklist, const char* label) {
   bool first = true;
   int ptnodes_length = ptnodes_worklist.length();
+  stringStream st;
   for (int i = 0; i < ptnodes_length; i++) {
     PointsToNode *ptn = ptnodes_worklist.at(i);
-    if (ptn == NULL || !ptn->is_JavaObject()) {
+    if (ptn == NULL) {
       continue;
     }
-    PointsToNode::EscapeState es = ptn->escape_state();
-    if ((es != PointsToNode::NoEscape) && !Verbose) {
-      continue;
-    }
-    Node* n = ptn->ideal_node();
-    if (n->is_Allocate() || (n->is_CallStaticJava() &&
-                             n->as_CallStaticJava()->is_boxing_method())) {
       if (first) {
-        tty->cr();
-        tty->print("======== Connection graph for ");
-        _compile->method()->print_short_name();
-        tty->cr();
-        tty->print_cr("invocation #%d: %d iterations and %f sec to build connection graph with %d nodes and worklist size %d",
-                      _invocation, _build_iterations, _build_time, nodes_size(), ptnodes_worklist.length());
-        tty->cr();
+        st.cr();
+        st.print("======== Connection graph - %s", label);
+        st.cr();
         first = false;
       }
-      ptn->dump();
-      // Print all locals and fields which reference this allocation
-      for (UseIterator j(ptn); j.has_next(); j.next()) {
-        PointsToNode* use = j.get();
-        if (use->is_LocalVar()) {
-          use->dump(Verbose);
-        } else if (Verbose) {
-          use->dump();
+      ptn->dump(&st);
+      st.cr();
+  }
+  _traceStream.print("%s", st.as_string());
+}
+
+void ConnectionGraph::dump_ir(const char* title) {
+  if (_collectingTrace) {
+    ttyLocker ttyl;  // keep the following output all in one block
+
+    _compile->method()->print_short_name(&_traceStream);
+    _traceStream.cr();
+    _traceStream.cr();
+
+    _traceStream.print_cr("%s", title);
+
+    Unique_Node_List ideal_nodes; // Used by CG construction and types splitting.
+    ideal_nodes.map(_compile->live_nodes(), NULL);  // preallocate space
+    ideal_nodes.push(_compile->root());
+
+    for( uint next = 0; next < ideal_nodes.size(); ++next ) {
+      Node* n = ideal_nodes.at(next);
+
+      n->dump("", false, &_traceStream);
+      _traceStream.cr();
+      const Type* tt = _igvn->type_or_null(n);
+      if (tt != NULL) {
+        const TypeOopPtr *node_t = tt->isa_oopptr();
+        if (node_t != NULL) {
+          int alias_idx = _compile->get_alias_index(node_t);
+          bool instance = _igvn->type(n)->isa_instptr() != NULL;
+          bool array = _igvn->type(n)->isa_aryptr() != NULL;
+          _traceStream.print_cr("#\t\t -> OOP-PTR(instance=%c, array=%c) instance_id: %d, alias_idx: %d", instance ? 'Y' : 'N', array ? 'Y' : 'N', node_t->instance_id(), alias_idx);
         }
       }
-      tty->cr();
+
+      for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+        Node* m = n->fast_out(i);   // Get user
+        ideal_nodes.push(m);
+      }
     }
+
+    _traceStream.cr(); _traceStream.cr(); _traceStream.cr(); _traceStream.cr();
+
+    save_trace();
+  }
+}
+
+void ConnectionGraph::save_trace() {
+  if (_collectingTrace) {
+    ttyLocker ttl;
+    static int counter = 0;
+    stringStream fullName;
+    fullName.print("/tmp/EATrace_%s_%s_%d.log", _compile->method()->holder()->name()->as_utf8(), _compile->method()->name()->as_utf8(), counter++);
+
+    fileStream oStream(fullName.as_string(), "w");
+               oStream.write(_traceStream.as_string(), _traceStream.size());
+               oStream.cr();
+               oStream.flush();
+
+    _traceStream.reset();
   }
 }
 #endif