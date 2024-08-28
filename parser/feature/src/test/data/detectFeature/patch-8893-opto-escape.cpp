@@ -91,7 +91,7 @@ bool ConnectionGraph::has_candidates(Compile *C) {
   return false;
 }
 
-void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn) {
+void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn, bool only_analysis) {
   Compile::TracePhase tp("escapeAnalysis", &Phase::timers[Phase::_t_escapeAnalysis]);
   ResourceMark rm;
 
@@ -100,12 +100,12 @@ void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn) {
   Node* oop_null = igvn->zerocon(T_OBJECT);
   Node* noop_null = igvn->zerocon(T_NARROWOOP);
   int invocation = 0;
-  if (C->congraph() != NULL) {
+  if (C->congraph() != NULL && !only_analysis) {
     invocation = C->congraph()->_invocation + 1;
   }
   ConnectionGraph* congraph = new(C->comp_arena()) ConnectionGraph(C, igvn, invocation);
   // Perform escape analysis
-  if (congraph->compute_escape()) {
+  if (congraph->compute_escape(only_analysis)) {
     // There are non escaping objects.
     C->set_congraph(congraph);
   }
@@ -118,7 +118,7 @@ void ConnectionGraph::do_analysis(Compile *C, PhaseIterGVN *igvn) {
   }
 }
 
-bool ConnectionGraph::compute_escape() {
+bool ConnectionGraph::compute_escape(bool only_analysis) {
   Compile* C = _compile;
   PhaseGVN* igvn = _igvn;
 
@@ -273,6 +273,20 @@ bool ConnectionGraph::compute_escape() {
     return false;
   }
 
+  // 2.a The step above might have transitively marked objects in non_escaped_allocs_worklist
+  // as ArgEscape or GlobalEscape
+  for (int next = non_escaped_allocs_worklist.length()-1; next >= 0 ; --next) {
+    JavaObjectNode* ptn = non_escaped_allocs_worklist.at(next);
+    if (ptn->escape_state() >= PointsToNode::ArgEscape) {
+      non_escaped_allocs_worklist.delete_at(next);
+    }
+  }
+
+  if (only_analysis) {
+    _collecting = false;
+    return non_escaped_allocs_worklist.length() > 0;
+  }
+
   // 3. Adjust scalar_replaceable state of nonescaping objects and push
   //    scalar replaceable allocations on alloc_worklist for processing
   //    in split_unique_types().
@@ -378,6 +392,145 @@ bool ConnectionGraph::compute_escape() {
   return has_non_escaping_obj;
 }
 
+void ConnectionGraph::reduce_allocation_merges() {
+  Unique_Node_List ideal_nodes;
+  ideal_nodes.map(_compile->live_nodes(), NULL);
+  ideal_nodes.push(_compile->root());
+
+  bool prev_delay_transform = _igvn->delay_transform();
+  _igvn->set_delay_transform(true);
+
+  for (uint next = 0; next < ideal_nodes.size(); ++next) {
+    Node* candidate_region = ideal_nodes.at(next);
+
+    if (candidate_region->is_Region()) {
+      Unique_Node_List target_phis;
+
+      for (DUIterator_Fast imax, i = candidate_region->fast_outs(imax); i < imax; i++) {
+        Node* candidate_phi = candidate_region->fast_out(i);
+
+        // Performs several checks to see if we can/should reduce this Phi
+        if (should_reduce_this_phi(candidate_phi)) {
+          target_phis.push(candidate_phi);
+        }
+      }
+
+      for (uint target_phi_idx = 0; target_phi_idx < target_phis.size(); ++target_phi_idx) {
+        Node* target_phi = target_phis.at(target_phi_idx);
+        reduce_this_phi(target_phi->as_Phi());
+      }
+    }
+
+    for (DUIterator_Fast imax, i = candidate_region->fast_outs(imax); i < imax; i++) {
+      Node* m = candidate_region->fast_out(i);
+      ideal_nodes.push(m);
+    }
+  }
+
+  _igvn->set_delay_transform(prev_delay_transform);
+}
+
+Node* ConnectionGraph::come_from_allocate(Node* n) {
+  while (true) {
+    switch (n->Opcode()) {
+      case Op_CastPP:
+      case Op_CheckCastPP:
+      case Op_EncodeP:
+      case Op_EncodePKlass:
+      case Op_DecodeN:
+      case Op_DecodeNKlass:
+        n = n->in(1);
+        break;
+      case Op_Proj:
+        assert(n->as_Proj()->_con == TypeFunc::Parms, "Should be proj from a call");
+        n = n->in(0);
+        break;
+      case Op_Parm:
+      case Op_LoadP:
+      case Op_LoadN:
+      case Op_LoadNKlass:
+      case Op_ConP:
+      case Op_CreateEx:
+      case Op_AllocateArray:
+      case Op_Phi:
+        return n;
+      case Op_Allocate:
+        return NULL;
+      default:
+        if (n->is_Call()) {
+          return n;
+        }
+        assert(false, "Should not reach here. Unmatched %d %s", n->_idx, n->Name());
+    }
+  }
+
+  // should never reach here
+  return n;
+}
+
+bool ConnectionGraph::should_reduce_this_phi(Node* n) {
+  if (!n->is_Phi())                     return false;
+  if (!is_ideal_node_in_graph(n->_idx)) return false;
+
+  PointsToNode* ptn = ptnode_adr(n->_idx);
+
+  if (ptn == NULL)                                                return false;
+  if (ptn->escape_state() != PointsToNode::EscapeState::NoEscape) return false;
+
+  // Check whether this Phi node actually point to Allocate nodes
+  for (uint in_idx=1; in_idx<n->req(); in_idx++) {
+    Node* input = n->in(in_idx);
+    Node* src = come_from_allocate(input);
+    if (src != NULL) {
+      NOT_PRODUCT(if (Verbose) tty->print_cr("Will NOT try to reduce Phi %d. The %dth input does not come from an Allocate -> %d %s", n->_idx, in_idx, src->_idx, src->Name());)
+      return false;
+    }
+  }
+
+  // Check if we can in fact later replace the uses of the
+  // current Phi by Phi's of individual fields.
+  // Conditions checked:
+  //    - The only consumers of the Phi are:
+  //        - AddP
+  //        - Safepoint
+  //        - uncommon_trap
+  for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+    Node* use = n->fast_out(i);
+
+    if (!use->is_AddP() && !use->is_CallStaticJava() && use->Opcode() != Op_SafePoint) {
+      NOT_PRODUCT(if (Verbose) tty->print_cr("Will NOT try to reduce Phi %d. Has Allocate but cannot scalar replace it. One of the uses is: %d %s", n->_idx, use->_idx, use->Name());)
+      return false;
+    }
+
+    if (use->is_CallStaticJava() && !use->as_CallStaticJava()->is_uncommon_trap()) {
+      NOT_PRODUCT(if (Verbose) tty->print_cr("Will NOT try to reduce Phi %d. Has Allocate but cannot scalar replace it. CallStaticJava is not a trap.", n->_idx);)
+      return false;
+    }
+
+    if (use->is_AddP() && use->in(AddPNode::Offset)->find_long_con(-1) == -1) {
+      NOT_PRODUCT(if (Verbose) tty->print_cr("Will NOT try to reduce Phi %d. Did not find constant input for %d : AddP.", n->_idx, use->_idx);)
+      dump_ir("AddP constant not found.");
+      return false;
+    }
+  }
+
+  NOT_PRODUCT(if (Verbose) tty->print_cr("Will try to reduce Phi %d.", n->_idx);)
+  return true;
+}
+
+void ConnectionGraph::reduce_this_phi(PhiNode* n) {
+  // Copy input edges of 'n' to 'reduced'
+  Node* reduced = ReducedAllocationMergeNode::make(_compile, _igvn, n);
+
+  // Patch users of 'n' to instead use 'reduced'
+  _igvn->replace_node(n, reduced);
+
+  // The original phi now should have no users
+  _igvn->remove_dead_node(n);
+
+  _igvn->_worklist.push(reduced);
+}
+
 // Returns true if there is an object in the scope of sfn that does not escape globally.
 bool ConnectionGraph::has_ea_local_in_scope(SafePointNode* sfn) {
   Compile* C = _compile;
@@ -475,7 +628,7 @@ void ConnectionGraph::add_node_to_connection_graph(Node *n, Unique_Node_List *de
     return; // Ignore node if already handled by GC.
   }
 
-  if (n->is_Call()) {
+  if (n->is_Call() || n->is_ReducedAllocationMerge()) {
     // Arguments to allocation and locking don't escape.
     if (n->is_AbstractLock()) {
       // Put Lock and Unlock nodes on IGVN worklist to process them during
@@ -484,7 +637,10 @@ void ConnectionGraph::add_node_to_connection_graph(Node *n, Unique_Node_List *de
     } else if (n->is_Allocate()) {
       add_call_node(n->as_Call());
       record_for_optimizer(n);
-    } else {
+    } else if (n->is_ReducedAllocationMerge()) {
+      add_java_object(n, PointsToNode::NoEscape);
+    }
+    else {
       if (n->is_CallStaticJava()) {
         const char* name = n->as_CallStaticJava()->_name;
         if (name != NULL && strcmp(name, "uncommon_trap") == 0) {
@@ -582,7 +738,7 @@ void ConnectionGraph::add_node_to_connection_graph(Node *n, Unique_Node_List *de
       break;
     }
     case Op_PartialSubtypeCheck: {
-      // Produces Null or notNull and is used in only in CmpP so
+      // Produces Null or notNull and is used only in CmpP so
       // phantom_obj could be used.
       map_ideal_node(n, phantom_obj); // Result is unknown
       break;
@@ -1666,8 +1822,8 @@ int ConnectionGraph::find_field_value(FieldNode* field) {
   for (BaseIterator i(field); i.has_next(); i.next()) {
     PointsToNode* base = i.get();
     if (base->is_JavaObject()) {
-      // Skip Allocate's fields which will be processed later.
-      if (base->ideal_node()->is_Allocate()) {
+      // Skip Allocate's & ReducedAllocationmerge fields which will be processed later.
+      if (base->ideal_node()->is_Allocate() || base->ideal_node()->is_ReducedAllocationMerge()) {
         return 0;
       }
       assert(base == null_obj, "only NULL ptr base expected here");
@@ -1686,9 +1842,11 @@ int ConnectionGraph::find_init_values_phantom(JavaObjectNode* pta) {
   assert(pta->escape_state() == PointsToNode::NoEscape, "Not escaped Allocate nodes only");
   Node* alloc = pta->ideal_node();
 
+  // Do nothing for ReducedAllocationMerges because their fields is "known".
+  //
   // Do nothing for Allocate nodes since its fields values are
   // "known" unless they are initialized by arraycopy/clone.
-  if (alloc->is_Allocate() && !pta->arraycopy_dst()) {
+  if (alloc->is_ReducedAllocationMerge() || (alloc->is_Allocate() && !pta->arraycopy_dst())) {
     return 0;
   }
   assert(pta->arraycopy_dst() || alloc->as_CallStaticJava(), "sanity");
@@ -1996,8 +2154,8 @@ void ConnectionGraph::verify_connection_graph(
           }
         }
       }
-      // Verify that all fields have initializing values.
-      if (field->edge_count() == 0) {
+      // Verify that all fields have initializing values unless its base is RAM.
+      if (!base->is_ReducedAllocationMerge() && field->edge_count() == 0) {
         tty->print_cr("----------field does not have references----------");
         field->dump();
         for (BaseIterator i(field); i.has_next(); i.next()) {
@@ -2529,6 +2687,13 @@ Node* ConnectionGraph::get_addp_base(Node *addp) {
   //     \  |
   //     AddP  ( base == top )
   //
+  // case #10: RAM as base
+  //        {...}      {...}
+  //          \          /
+  //     ReducedAllocationMerge
+  //             ||
+  //            AddP
+  //
   Node *base = addp->in(AddPNode::Base);
   if (base->uncast()->is_top()) { // The AddP case #3 and #6 and #9.
     base = addp->in(AddPNode::Address);
@@ -3272,31 +3437,97 @@ void ConnectionGraph::split_unique_types(GrowableArray<Node *>  &alloc_worklist,
           }
         }
       }
+    }
+    else if (n->is_ReducedAllocationMerge()) {
+      continue; // there is no need for this kind of node to have an instance id
+      /////// // This is necessary because EA put ReducedAllocationMerge nodes
+      /////// // initially into the worklist and the processing of Allocate* nodes
+      /////// // might also add the same node to the worklist.
+      /////// if (visited.test_set(n->_idx)) {
+      ///////   continue;  // already processed
+      /////// }
+
+      /////// PointsToNode* ptn = ptnode_adr(n->_idx);
+      /////// PointsToNode::EscapeState es = ptn->escape_state();
+      /////// const TypeOopPtr *t = igvn->type(n)->isa_oopptr();
+
+      /////// assert(es == PointsToNode::EscapeState::NoEscape, "This should be NoEscape.");
+      /////// assert(t != NULL, "This should be an oopptr.");
+
+      /////// // Just to simplify some checks
+      /////// set_map(n, n);
+
+      /////// // ReducedAllocationMerge has it's own instance_id which is it's ID
+      /////// // I'm casting to exactness here because only exact nodes can have an
+      /////// // instance_id and this node will later disappear, in reality the merge
+      /////// // might not be exact.
+      /////// t = t->cast_to_exactness(true)->isa_oopptr();
+      /////// const TypeOopPtr* tinst = t->cast_to_instance_id(ni);
+
+      /////// igvn->hash_delete(n);
+      /////// igvn->set_type(n,  tinst);
+      /////// n->raise_bottom_type(tinst);
+      /////// igvn->hash_insert(n);
+
+      ///////   // TODO: should I keep the find second AddP part? I.e., for the case
+      ///////   // when the merge was for array allocations?
+
+      ///////   for (EdgeIterator e(ptn); e.has_next(); e.next()) {
+      ///////     PointsToNode* tgt = e.get();
+      ///////     if (tgt->is_Arraycopy()) {
+      ///////       continue;
+      ///////     }
+      ///////     Node* use = tgt->ideal_node();
+      ///////     assert(tgt->is_Field() && use->is_AddP(),
+      ///////             "only AddP nodes are Field edges in CG");
+      ///////     if (use->outcnt() > 0) { // Don't process dead nodes
+      ///////       Node* addp2 = find_second_addp(use, use->in(AddPNode::Base));
+      ///////       if (addp2 != NULL) {
+      ///////         alloc_worklist.append_if_missing(addp2);
+      ///////       }
+      ///////       alloc_worklist.append_if_missing(use);
+      ///////     }
+      ///////   }
+
+      ///////   for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+      ///////     Node *use = n->fast_out(i);
+      ///////     if (use->is_AddP() && use->outcnt() > 0) { // Don't process dead nodes
+      ///////       Node* addp2 = find_second_addp(use, n);
+      ///////       if (addp2 != NULL) {
+      ///////         alloc_worklist.append_if_missing(addp2);
+      ///////       }
+      ///////       alloc_worklist.append_if_missing(use);
+      ///////     } else if (use->is_MemBar()) {
+      ///////       memnode_worklist.append_if_missing(use);
+      ///////     }
+      ///////   }
     } else if (n->is_AddP()) {
       JavaObjectNode* jobj = unique_java_object(get_addp_base(n));
       if (jobj == NULL || jobj == phantom_obj) {
 #ifdef ASSERT
+        //_compile->print_method(PHASE_AFTER_REDUCE_ALLOCATION, 2);
         ptnode_adr(get_addp_base(n)->_idx)->dump();
         ptnode_adr(n->_idx)->dump();
         assert(jobj != NULL && jobj != phantom_obj, "escaped allocation");
 #endif
         _compile->record_failure(_invocation > 0 ? C2Compiler::retry_no_iterative_escape_analysis() : C2Compiler::retry_no_escape_analysis());
         return;
       }
-      Node *base = get_map(jobj->idx());  // CheckCastPP node
+      Node *base = get_map(jobj->idx());
       if (!split_AddP(n, base)) continue; // wrong type from dead path
     } else if (n->is_Phi() ||
                n->is_CheckCastPP() ||
                n->is_EncodeP() ||
                n->is_DecodeN() ||
                (n->is_ConstraintCast() && n->Opcode() == Op_CastPP)) {
       if (visited.test_set(n->_idx)) {
-        assert(n->is_Phi(), "loops only through Phi's");
+        assert(n->is_Phi(), "loops only through Phi's. Actual node is %s", n->Name());
         continue;  // already processed
       }
       JavaObjectNode* jobj = unique_java_object(n);
       if (jobj == NULL || jobj == phantom_obj) {
 #ifdef ASSERT
+        //_compile->print_method(PHASE_AFTER_REDUCE_ALLOCATION, 2);
         ptnode_adr(n->_idx)->dump();
         assert(jobj != NULL && jobj != phantom_obj, "escaped allocation");
 #endif
@@ -3356,6 +3587,7 @@ void ConnectionGraph::split_unique_types(GrowableArray<Node *>  &alloc_worklist,
         }
         alloc_worklist.append_if_missing(use);
       } else if (use->is_Phi() ||
+                 use->is_ReducedAllocationMerge() ||
                  use->is_CheckCastPP() ||
                  use->is_EncodeNarrowPtr() ||
                  use->is_DecodeNarrowPtr() ||
@@ -3502,6 +3734,8 @@ void ConnectionGraph::split_unique_types(GrowableArray<Node *>  &alloc_worklist,
           memnode_worklist.append_if_missing(use);
         }
 #ifdef ASSERT
+      } else if(use->is_ReducedAllocationMerge()) {
+        continue; // don't do anything
       } else if(use->is_Mem()) {
         assert(use->in(MemNode::Memory) != n, "EA: missing memory path");
       } else if (use->is_MergeMem()) {
@@ -3657,7 +3891,7 @@ void ConnectionGraph::split_unique_types(GrowableArray<Node *>  &alloc_worklist,
       igvn->hash_insert(n);
       record_for_optimizer(n);
     } else {
-      assert(n->is_Allocate() || n->is_CheckCastPP() ||
+      assert(n->is_Allocate() || n->is_ReducedAllocationMerge() || n->is_CheckCastPP() ||
              n->is_AddP() || n->is_Phi(), "unknown node used for set_map()");
     }
   }
@@ -3711,19 +3945,19 @@ void PointsToNode::dump(bool print_state, outputStream* out, bool newline) const
     if (f->offset() > 0) {
       out->print("+%d ", f->offset());
     }
-    out->print("(");
+    out->print("Bases: (");
     for (BaseIterator i(f); i.has_next(); i.next()) {
       PointsToNode* b = i.get();
       out->print(" %d%s", b->idx(),(b->is_JavaObject() ? "P" : ""));
     }
     out->print(" )");
   }
-  out->print("[");
+  out->print("Edges: [");
   for (EdgeIterator i(this); i.has_next(); i.next()) {
     PointsToNode* e = i.get();
     out->print(" %d%s%s", e->idx(),(e->is_JavaObject() ? "P" : (e->is_Field() ? "F" : "")), e->is_Arraycopy() ? "cp" : "");
   }
-  out->print(" [");
+  out->print("] Uses: [");
   for (UseIterator i(this); i.has_next(); i.next()) {
     PointsToNode* u = i.get();
     bool is_base = false;
@@ -3733,52 +3967,40 @@ void PointsToNode::dump(bool print_state, outputStream* out, bool newline) const
     }
     out->print(" %d%s%s", u->idx(), is_base ? "b" : "", u->is_Arraycopy() ? "cp" : "");
   }
-  out->print(" ]]  ");
+  out->print(" ]  ");
   if (_node == NULL) {
     out->print("<null>%s", newline ? "\n" : "");
   } else {
     _node->dump(newline ? "\n" : "", false, out);
   }
 }
 
-void ConnectionGraph::dump(GrowableArray<PointsToNode*>& ptnodes_worklist) {
-  bool first = true;
+void ConnectionGraph::dump(GrowableArray<PointsToNode*>& ptnodes_worklist, const char* title) {
   int ptnodes_length = ptnodes_worklist.length();
+
+  ttyLocker ttyl;
+  tty->cr();
+  tty->print("======== Connection Graph%sfor ", title != NULL ? title : "");
+  _compile->method()->print_short_name();
+  tty->print_cr(" vvvvvv");
+  tty->print_cr("invocation #%d: %d iterations and %f sec to build connection graph with %d nodes and worklist size %d",
+                _invocation, _build_iterations, _build_time, nodes_size(), ptnodes_worklist.length());
+  tty->cr();
   for (int i = 0; i < ptnodes_length; i++) {
     PointsToNode *ptn = ptnodes_worklist.at(i);
-    if (ptn == NULL || !ptn->is_JavaObject()) {
-      continue;
-    }
-    PointsToNode::EscapeState es = ptn->escape_state();
-    if ((es != PointsToNode::NoEscape) && !Verbose) {
+    if (ptn == NULL) {
       continue;
     }
-    Node* n = ptn->ideal_node();
-    if (n->is_Allocate() || (n->is_CallStaticJava() &&
-                             n->as_CallStaticJava()->is_boxing_method())) {
-      if (first) {
-        tty->cr();
-        tty->print("======== Connection graph for ");
-        _compile->method()->print_short_name();
-        tty->cr();
-        tty->print_cr("invocation #%d: %d iterations and %f sec to build connection graph with %d nodes and worklist size %d",
-                      _invocation, _build_iterations, _build_time, nodes_size(), ptnodes_worklist.length());
-        tty->cr();
-        first = false;
-      }
-      ptn->dump();
-      // Print all locals and fields which reference this allocation
-      for (UseIterator j(ptn); j.has_next(); j.next()) {
-        PointsToNode* use = j.get();
-        if (use->is_LocalVar()) {
-          use->dump(Verbose);
-        } else if (Verbose) {
-          use->dump();
-        }
+    if (!Verbose) {
+      PointsToNode::EscapeState es = ptn->escape_state();
+
+      if (!ptn->is_JavaObject() || es != PointsToNode::NoEscape) {
+        continue;
       }
-      tty->cr();
     }
+    ptn->dump();
   }
+  tty->print_cr("======== End Connection graph ^^^^^^ ");
 }
 
 void ConnectionGraph::trace_es_update_helper(PointsToNode* ptn, PointsToNode::EscapeState es, bool fields, const char* reason) const {
@@ -3825,6 +4047,44 @@ const char* ConnectionGraph::trace_merged_message(PointsToNode* other) const {
   }
 }
 
+void ConnectionGraph::dump_ir(const char* title) {
+    ttyLocker ttyl;  // keep the following output all in one block
+
+    _compile->method()->print_short_name();
+    tty->cr();
+    tty->cr();
+
+    tty->print_cr("%s", title);
+
+    Unique_Node_List ideal_nodes; // Used by CG construction and types splitting.
+    ideal_nodes.map(_compile->live_nodes(), NULL);  // preallocate space
+    ideal_nodes.push(_compile->root());
+
+    for( uint next = 0; next < ideal_nodes.size(); ++next ) {
+      Node* n = ideal_nodes.at(next);
+
+      n->dump();
+
+      const Type* tt = _igvn->type_or_null(n);
+      if (tt != NULL) {
+        const TypeOopPtr *node_t = tt->isa_oopptr();
+        if (node_t != NULL) {
+          int alias_idx = _compile->get_alias_index(node_t);
+          bool instance = _igvn->type(n)->isa_instptr() != NULL;
+          bool array = _igvn->type(n)->isa_aryptr() != NULL;
+          tty->print_cr("#\t\t -> OOP-PTR(instance=%c, array=%c) instance_id: %d, alias_idx: %d", instance ? 'Y' : 'N', array ? 'Y' : 'N', node_t->instance_id(), alias_idx);
+        }
+      }
+
+      for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+        Node* m = n->fast_out(i);   // Get user
+        ideal_nodes.push(m);
+      }
+    }
+
+    tty->cr(); tty->cr(); tty->cr(); tty->cr();
+}
+
 #endif
 
 void ConnectionGraph::record_for_optimizer(Node *n) {