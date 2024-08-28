@@ -34,6 +34,7 @@
 #include "opto/castnode.hpp"
 #include "opto/cfgnode.hpp"
 #include "opto/compile.hpp"
+#include "opto/c2compiler.hpp"
 #include "opto/convertnode.hpp"
 #include "opto/graphKit.hpp"
 #include "opto/intrinsicnode.hpp"
@@ -535,7 +536,7 @@ Node *PhaseMacroExpand::value_from_mem(Node *sfpt_mem, Node *sfpt_ctl, BasicType
     } else if (mem->is_ArrayCopy()) {
       Node* ctl = mem->in(0);
       Node* m = mem->in(TypeFunc::Memory);
-      if (sfpt_ctl->is_Proj() && sfpt_ctl->as_Proj()->is_uncommon_trap_proj(Deoptimization::Reason_none)) {
+      if (sfpt_ctl != NULL && sfpt_ctl->is_Proj() && sfpt_ctl->as_Proj()->is_uncommon_trap_proj(Deoptimization::Reason_none)) {
         // pin the loads in the uncommon trap path
         ctl = sfpt_ctl;
         m = sfpt_mem;
@@ -548,7 +549,7 @@ Node *PhaseMacroExpand::value_from_mem(Node *sfpt_mem, Node *sfpt_ctl, BasicType
 }
 
 // Check the possibility of scalar replacement.
-bool PhaseMacroExpand::can_eliminate_allocation(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints) {
+bool PhaseMacroExpand::can_eliminate_allocation(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints, GrowableArray <ReducedAllocationMergeNode *>& rams) {
   //  Scan the uses of the allocation to check for anything that would
   //  prevent us from eliminating it.
   NOT_PRODUCT( const char* fail_eliminate = NULL; )
@@ -611,6 +612,9 @@ bool PhaseMacroExpand::can_eliminate_allocation(AllocateNode *alloc, GrowableArr
                   use->as_ArrayCopy()->is_copyofrange_validated()) &&
                  use->in(ArrayCopyNode::Dest) == res) {
         // ok to eliminate
+      } else if (use->is_ReducedAllocationMerge()) {
+        // also ok to eliminate
+        rams.append_if_missing(use->as_ReducedAllocationMerge());
       } else if (use->is_SafePoint()) {
         SafePointNode* sfpt = use->as_SafePoint();
         if (sfpt->is_Call() && sfpt->as_Call()->has_non_debug_use(res)) {
@@ -675,7 +679,7 @@ bool PhaseMacroExpand::can_eliminate_allocation(AllocateNode *alloc, GrowableArr
 }
 
 // Do scalar replacement.
-bool PhaseMacroExpand::scalar_replacement(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints) {
+bool PhaseMacroExpand::scalar_replacement(AllocateNode *alloc, GrowableArray <SafePointNode *>& safepoints, GrowableArray <ReducedAllocationMergeNode *>& rams) {
   GrowableArray <SafePointNode *> safepoints_done;
 
   ciInstanceKlass* iklass = NULL;
@@ -707,6 +711,77 @@ bool PhaseMacroExpand::scalar_replacement(AllocateNode *alloc, GrowableArray <Sa
       field_type = res_type->is_aryptr()->elem();
     }
   }
+
+  //
+  // Process the Reduced Allocation Merges uses
+  //
+  while (rams.length() > 0) {
+    ReducedAllocationMergeNode* ram = rams.pop();
+
+    _igvn.hash_delete(ram);
+
+    // Scan object's fields adding an input to the RAM for each field.
+    for (int j = 0; j < nfields; j++) {
+      intptr_t offset;
+      ciField* field = NULL;
+      const Type *field_type;
+      if (iklass != NULL) {
+        field = iklass->nonstatic_field_at(j);
+        offset = field->offset();
+        elem_type = field->type();
+        basic_elem_type = field->layout_type();
+      } else {
+        offset = array_base + j * (intptr_t)element_size;
+      }
+
+      if (!ram->needs_field(offset)) {
+        continue;
+      }
+
+      if (is_reference_type(basic_elem_type)) {
+        if (!elem_type->is_loaded()) {
+          field_type = TypeInstPtr::BOTTOM;
+        } else if (field != NULL && field->is_static_constant()) {
+          // This can happen if the constant oop is non-perm.
+          ciObject* con = field->constant_value().as_object();
+          // Do not "join" in the previous type; it doesn't add value,
+          // and may yield a vacuous result if the field is of interface type.
+          field_type = TypeOopPtr::make_from_constant(con)->isa_oopptr();
+          assert(field_type != NULL, "field singleton type must be consistent");
+        } else {
+          field_type = TypeOopPtr::make_from_klass(elem_type->as_klass());
+        }
+        if (UseCompressedOops) {
+          field_type = field_type->make_narrowoop();
+          basic_elem_type = T_NARROWOOP;
+        }
+      } else {
+        field_type = Type::get_const_basic_type(basic_elem_type);
+      }
+
+      const TypeOopPtr *field_addr_type = res_type->add_offset(offset)->isa_oopptr();
+      Node *memory = ram->memory_for(offset, res);
+      //if (Verbose) tty->print_cr("Searching for value for field @ %ld starting in memory %d", offset, memory->_idx);
+      Node *field_val = value_from_mem(memory, NULL, basic_elem_type, field_type, field_addr_type, alloc);
+
+      // If we can't actually find the value for this field we won't be able to remove the
+      // RAM node and in that situation the only way out is to recompile the method with
+      // ReduceAllocations disabled.
+      if (field_val == NULL) {
+        assert(false, "Didn't find value for field!!!");
+        //C->record_failure(C2Compiler::retry_no_escape_analysis());
+        return false;
+      }
+
+      ram->register_value_for_field(offset, res, field_val);
+
+      //if (Verbose) tty->print_cr("\tNode %d registering value (%d) in RAM %d about field at offset %ld.", res->_idx, field_val->_idx, ram->_idx, offset);
+    }
+
+    _igvn.hash_insert(ram);
+    _igvn._worklist.push(ram);
+  }
+
   //
   // Process the safepoint uses
   //
@@ -926,6 +1001,11 @@ void PhaseMacroExpand::process_users_of_allocation(CallNode *alloc) {
           }
         }
         _igvn._worklist.push(ac);
+      } else if (use->is_ReducedAllocationMerge()) {
+        _igvn.hash_delete(use);
+        use->replace_edge(res, C->top());
+        _igvn.hash_insert(use);
+        _igvn._worklist.push(use);
       } else {
         eliminate_gc_barrier(use);
       }
@@ -1028,7 +1108,8 @@ bool PhaseMacroExpand::eliminate_allocate_node(AllocateNode *alloc) {
   alloc->extract_projections(&_callprojs, false /*separate_io_proj*/, false /*do_asserts*/);
 
   GrowableArray <SafePointNode *> safepoints;
-  if (!can_eliminate_allocation(alloc, safepoints)) {
+  GrowableArray <ReducedAllocationMergeNode *> rams;
+  if (!can_eliminate_allocation(alloc, safepoints, rams)) {
     return false;
   }
 
@@ -1042,7 +1123,7 @@ bool PhaseMacroExpand::eliminate_allocate_node(AllocateNode *alloc) {
     }
   }
 
-  if (!scalar_replacement(alloc, safepoints)) {
+  if (!scalar_replacement(alloc, safepoints, rams)) {
     return false;
   }
 
@@ -1112,6 +1193,192 @@ bool PhaseMacroExpand::eliminate_boxing_node(CallStaticJavaNode *boxing) {
   return true;
 }
 
+void dump_ir(Compile* _compile, const char* title) {
+
+
+
+
+
+
+
+
+    return ;
+
+
+
+
+
+
+
+
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
+      for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+        Node* m = n->fast_out(i);   // Get user
+        ideal_nodes.push(m);
+      }
+    }
+
+    tty->cr(); tty->cr(); tty->cr(); tty->cr();
+}
+
+
+bool PhaseMacroExpand::eliminate_reduced_allocation_merge(ReducedAllocationMergeNode *ram) {
+  tty->print_cr("Going to remove %d RAM", ram->_idx);
+
+  for (DUIterator_Fast imax, i = ram->fast_outs(imax); i < imax; i++) {
+    Node* use = ram->fast_out(i);
+
+    ciKlass* klass = ram->klass();
+    ciInstanceKlass* iklass = klass->as_instance_klass();
+    int nfields = iklass->nof_nonstatic_fields();
+    const TypeOopPtr* res_type = _igvn.type(ram)->isa_oopptr();
+
+    if (use->is_AddP()) {
+      Node* addp = use; // just for readability
+      jlong field = addp->in(AddPNode::Offset)->find_long_con(-1);
+
+      assert(field != -1, "Didn't find constant offset for AddP.");
+
+      Node* phi = ram->value_phi_for_field(field, &_igvn);
+      _igvn._worklist.push(phi);
+
+      for (DUIterator_Fast jmax, j = addp->fast_outs(jmax); j < jmax; j++) {
+        Node* addp_use = addp->fast_out(j);
+
+        if (addp_use->is_Load()) {
+          Node* load = addp_use; // just for readability
+
+          for (DUIterator_Last kmin, k = load->last_outs(kmin); k >= kmin; --k) {
+            Node* load_use = load->last_out(k);
+
+            _igvn.hash_delete(load_use);
+            load_use->replace_edge(load, phi, &_igvn);
+            _igvn.hash_insert(load_use);
+            _igvn._worklist.push(load_use);
+          }
+        }
+        else {
+          assert(false, "Unexpected use of AddP.");
+        }
+      }
+    }
+    else if (use->Opcode() == Op_SafePoint || use->is_CallStaticJava()) {
+      Node* sfpt = use;
+      Node* mem = sfpt->in(TypeFunc::Memory);
+      Node* ctl = sfpt->in(TypeFunc::Control);
+      assert(sfpt->jvms() != NULL, "missed JVMS");
+
+      // Fields of scalar objs are referenced only at the end
+      // of regular debuginfo at the last (youngest) JVMS.
+      // Record relative start index.
+      uint first_ind = (sfpt->req() - sfpt->jvms()->scloff());
+      SafePointScalarObjectNode* sobj = new SafePointScalarObjectNode(res_type,
+                                                                      #ifdef ASSERT
+                                                                        ram,
+                                                                      #endif
+                                                                        first_ind,
+                                                                        nfields);
+      sobj->init_req(0, C->root());
+      transform_later(sobj);
+
+      // Scan object's fields adding an input to the safepoint for each field.
+      for (int j = 0; j < nfields; j++) {
+        intptr_t offset;
+        ciField* field = NULL;
+        field = iklass->nonstatic_field_at(j);
+        offset = field->offset();
+        ciType* elem_type = field->type();
+        BasicType basic_elem_type = field->layout_type();
+
+        const Type *field_type;
+        // The next code is taken from Parse::do_get_xxx().
+        if (is_reference_type(basic_elem_type)) {
+          if (!elem_type->is_loaded()) {
+            field_type = TypeInstPtr::BOTTOM;
+          } else if (field != NULL && field->is_static_constant()) {
+            // This can happen if the constant oop is non-perm.
+            ciObject* con = field->constant_value().as_object();
+            // Do not "join" in the previous type; it doesn't add value,
+            // and may yield a vacuous result if the field is of interface type.
+            field_type = TypeOopPtr::make_from_constant(con)->isa_oopptr();
+            assert(field_type != NULL, "field singleton type must be consistent");
+          } else {
+            field_type = TypeOopPtr::make_from_klass(elem_type->as_klass());
+          }
+          if (UseCompressedOops) {
+            field_type = field_type->make_narrowoop();
+            basic_elem_type = T_NARROWOOP;
+          }
+        } else {
+          field_type = Type::get_const_basic_type(basic_elem_type);
+        }
+
+        const TypeOopPtr *field_addr_type = res_type->add_offset(offset)->isa_oopptr();
+
+        Node* field_val = ram->value_phi_for_field(offset, &_igvn);
+        _igvn._worklist.push(field_val);
+
+        if (field_val == NULL) {
+  #ifndef PRODUCT
+          if (PrintEliminateAllocations) {
+            tty->print("=== At SafePoint node %d can't find value of Field: ", sfpt->_idx);
+            field->print();
+            int field_idx = C->get_alias_index(field_addr_type);
+            tty->print(" (alias_idx=%d)", field_idx);
+            tty->print(", which prevents elimination of: ");
+            ram->dump();
+          }
+  #endif
+          return false;
+        }
+        if (UseCompressedOops && field_type->isa_narrowoop()) {
+          // Enable "DecodeN(EncodeP(Allocate)) --> Allocate" transformation
+          // to be able scalar replace the allocation.
+          if (field_val->is_EncodeP()) {
+            field_val = field_val->in(1);
+          } else {
+            field_val = transform_later(new DecodeNNode(field_val, field_val->get_ptr_type()));
+          }
+        }
+        sfpt->add_req(field_val);
+      }
+      JVMState *jvms = sfpt->jvms();
+      jvms->set_endoff(sfpt->req());
+      // Now make a pass over the debug information replacing any references
+      // to the allocated object with "sobj"
+      int start = jvms->debug_start();
+      int end   = jvms->debug_end();
+      sfpt->replace_edges_in_range(ram, sobj, start, end, &_igvn);
+      _igvn._worklist.push(sfpt);
+
+      --i; --imax;
+    }
+    else {
+      assert(false, "Unknown use of RAM. %d:%s", use->_idx, use->Name());
+    }
+
+    dump_ir(C, "After eliminating one use.");
+  }
+
+  return true;
+}
+
 //---------------------------set_eden_pointers-------------------------
 void PhaseMacroExpand::set_eden_pointers(Node* &eden_top_adr, Node* &eden_end_adr) {
   if (UseTLAB) {                // Private allocation: load from TLS
@@ -2334,6 +2601,7 @@ void PhaseMacroExpand::expand_subtypecheck_node(SubTypeCheckNode *check) {
   _igvn.replace_node(check, C->top());
 }
 
+
 //---------------------------eliminate_macro_nodes----------------------
 // Eliminate scalar replaced allocations and associated locks.
 void PhaseMacroExpand::eliminate_macro_nodes() {
@@ -2369,6 +2637,9 @@ void PhaseMacroExpand::eliminate_macro_nodes() {
       progress = progress || success;
     }
   }
+
+  dump_ir(C, "before removing any allocate.");
+
   // Next, attempt to eliminate allocations
   _has_locks = false;
   progress = true;
@@ -2382,10 +2653,16 @@ void PhaseMacroExpand::eliminate_macro_nodes() {
       case Node::Class_Allocate:
       case Node::Class_AllocateArray:
         success = eliminate_allocate_node(n->as_Allocate());
+        if (success) {
+          dump_ir(C, "After eliminate allocate");
+        }
         break;
       case Node::Class_CallStaticJava:
         success = eliminate_boxing_node(n->as_CallStaticJava());
         break;
+      case Node::Class_ReducedAllocationMerge:
+        // Needs to be processed after all others
+        break;
       case Node::Class_Lock:
       case Node::Class_Unlock:
         assert(!n->as_AbstractLock()->is_eliminated(), "sanity");
@@ -2411,8 +2688,22 @@ void PhaseMacroExpand::eliminate_macro_nodes() {
       progress = progress || success;
     }
   }
+
+  dump_ir(C, "after removing all allocates / before removing any RAM.");
+
+  // Next, try to eliminate reduced allocation merges
+  for (int i = C->macro_count(); i > 0; i = MIN2(i - 1, C->macro_count())) { // more than 1 element can be eliminated at once
+    Node* n = C->macro_node(i - 1);
+    if (n->is_ReducedAllocationMerge()) {
+      bool success = eliminate_reduced_allocation_merge(n->as_ReducedAllocationMerge());
+      assert(success, "Needs to be eliminated.");
+      if (C->failing()) return ;
+    }
+  }
 }
 
+
+
 //------------------------------expand_macro_nodes----------------------
 //  Returns true if a failure occurred.
 bool PhaseMacroExpand::expand_macro_nodes() {