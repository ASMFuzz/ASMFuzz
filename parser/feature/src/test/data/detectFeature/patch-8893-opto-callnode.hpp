@@ -27,7 +27,9 @@
 
 #include "opto/connode.hpp"
 #include "opto/mulnode.hpp"
+#include "opto/addnode.hpp"
 #include "opto/multnode.hpp"
+#include "opto/cfgnode.hpp"
 #include "opto/opcodes.hpp"
 #include "opto/phaseX.hpp"
 #include "opto/replacednodes.hpp"
@@ -735,6 +737,7 @@ class CallStaticJavaNode : public CallJavaNode {
 
   // If this is an uncommon trap, return the request code, else zero.
   int uncommon_trap_request() const;
+  bool is_uncommon_trap() const;
   static int extract_uncommon_trap_request(const Node* call);
 
   bool is_boxing_method() const {
@@ -1008,6 +1011,225 @@ class AllocateArrayNode : public AllocateNode {
   }
 };
 
+// This node is used during EA/SR to simplify allocation merges.
+// It's placed in this file just because it's closely related to allocation.
+class ReducedAllocationMergeNode : public TypeNode {
+private:
+  ciKlass* _klass;                  // Which Klass is the merge for
+
+  uint _num_orig_inputs;            // Number of inputs to the original Phi
+
+  Node_Array* _in_copy;             // I need a *copy* of the original Phi input node addresses
+                                    // because these input nodes are going to go away as we scalar
+                                    // replace the allocations and remove the nodes. However, I
+                                    // the order of the inputs in the original Phi is important
+                                    // to several operations of RAM.
+
+  bool _needs_all_fields;           // This is set to true when there was an Safepoint or uncommon_trap
+                                    // using the original Phi. In that situation we need information of
+                                    // all fields reaching the Safepoing/trap so that we can construct
+                                    // a SafepoingScalarObjectNode
+
+  Dict* _fields_and_values;
+
+  bool _found_memory_phi;           // Set to true when we find a matching memory Phi from
+                                    // same Region as original phi.
+
+  uint _memories_indexes_start;
+
+public:
+  ReducedAllocationMergeNode(Compile* C, PhaseIterGVN* igvn, const PhiNode* phi) : TypeNode(phi->type(), phi->req()) {
+    init_class_id(Class_ReducedAllocationMerge);
+    init_flags(Flag_is_macro);
+
+    _num_orig_inputs        = phi->req();
+    _needs_all_fields       = false;
+    _in_copy                = new Node_Array(Thread::current()->resource_area(), phi->req());
+    _memories_indexes_start = -1;
+    _fields_and_values      = new (C->comp_arena()) Dict(cmpkey, hashkey);
+    _found_memory_phi       = false;
+
+    const Type* ram_t = Type::TOP;
+
+    for (uint i=0; i<phi->req(); i++) {
+      init_req(i, phi->in(i));
+      _in_copy->map(i, this->_in[i]);
+
+      if (i > 0) {
+        const Type* in_t = igvn->type(phi->in(i));
+        ram_t = ram_t->meet_speculative(in_t);
+      }
+    }
+
+    _klass = ram_t->isa_oopptr()->klass();
+
+    // Now let's try to find a memory Phi coming from same region
+    Node* reg = phi->region();
+    for (DUIterator_Fast imax, i = reg->fast_outs(imax); i < imax; i++) {
+      Node* n = reg->fast_out(i);
+      if (n->is_Phi() && n->bottom_type() == Type::MEMORY) {
+        // Safe the index where we are storing the memory edge
+        _memories_indexes_start = req();
+
+        for (uint j=1; j<n->req(); j++) {
+          add_req(n->in(j));
+        }
+
+        _found_memory_phi = true;
+        break;
+      }
+    }
+
+    this->raise_bottom_type(ram_t);
+    igvn->set_type(this, ram_t);
+
+    C->add_macro_node(this);
+  }
+
+  virtual int Opcode() const;
+
+  ciKlass* klass() const { return _klass; }
+
+  bool needs_field(intptr_t field) const {
+    return _needs_all_fields || ((*_fields_and_values)[(void*)field] != NULL);
+  }
+
+  void register_use(Node* n) {
+    if (n->is_AddP()) {
+      jlong field = n->in(AddPNode::Offset)->find_long_con(-1);
+
+      assert(field != -1, "Didn't find constant for AddP.");
+
+      if ((*_fields_and_values)[(void*)field] == NULL) {
+        _fields_and_values->Insert((void*)field, (void*)new Node_Array(Compile::current()->node_arena(), _num_orig_inputs));
+      }
+
+      // If we didn't find memory edges to use so far then try to
+      // figure out which Memory edge subsequent Loads of this field use
+      if (_found_memory_phi == false) {
+        for (DUIterator_Fast imax, i = n->fast_outs(imax); i < imax; i++) {
+          Node* addp_use = n->fast_out(i);
+
+          if (addp_use->is_Load()) {
+            Node* load_mem = addp_use->in(LoadNode::Memory);
+
+            // Safe the index where we are storing the memory edge
+            _memories_indexes_start = req();
+
+            if (load_mem->is_Phi()) {
+              for (uint j=1; j<_num_orig_inputs; j++) {
+                add_req(load_mem->in(j));
+              }
+            }
+            else {
+              for (uint j=1; j<_num_orig_inputs; j++) {
+                add_req(load_mem);
+              }
+            }
+
+            _found_memory_phi = true;
+            break;
+          }
+          else {
+            assert(false, "User of AddP in RAM is not a Load.");
+          }
+        }
+      }
+
+      tty->print_cr("Registering in %d RAM the use of field @ offset %ld.", this->_idx, field);
+    }
+    else if (n->Opcode() == Op_SafePoint || (n->is_CallStaticJava() && n->as_CallStaticJava()->is_uncommon_trap())) {
+      _needs_all_fields = true;
+
+      tty->print_cr("Registering in %d RAM the use of all fields.", this->_idx);
+    }
+    else {
+      NOT_PRODUCT(tty->print_cr("Node: %d %s", n->_idx, n->Name());)
+      assert(false, "Trying to register unsupported use in RAM.");
+    }
+  }
+
+  Node* memory_for(jlong field, Node* base) const {
+    assert(_found_memory_phi, "Didn't find memory edges yet?");
+
+    for (uint i=1; i<_num_orig_inputs; i++) {
+      if (base == _in_copy->at(i)) {
+        return in(_memories_indexes_start + i - 1);
+      }
+    }
+
+    assert(false, "Did not find a matching base when searching for memory.");
+    return NULL;
+  }
+
+  // The offsets to access the array value for each _fields_and_definitions entry should
+  // be 1 less than the offset of the base matching the input to RAM
+  void register_value_for_field(jlong field, Node* base, Node* value) {
+    // It's possible that the entry for this field is null because we didn't
+    // see a load to it, just a Safepoint using it all fields.
+    if ((*_fields_and_values)[(void*)field] == NULL) {
+      _fields_and_values->Insert((void*)field, (void*)new Node_Array(Compile::current()->node_arena(), _num_orig_inputs));
+    }
+
+    Node_Array* values = (Node_Array*) ((*_fields_and_values)[(void*)field]);
+
+    if (_num_orig_inputs == 3) {
+      if (base == _in_copy->at(1)) {
+        values->map(1, value);
+      }
+      else if (base == _in_copy->at(2)) {
+        values->map(2, value);
+      }
+      else {
+        assert(false, "insanity");
+      }
+    }
+    else {
+      uint i = 1;
+      for (; i<_num_orig_inputs; i++) {
+        if (base == _in_copy->at(i)) {
+          values->map(i, value);
+          break;
+        }
+      }
+      assert(i < _num_orig_inputs, "insanity");
+    }
+
+    this->add_req(value);
+  }
+
+  Node* value_phi_for_field(jlong field, PhaseIterGVN* igvn) {
+    PhiNode* phi       = new PhiNode(this->in(0), Type::BOTTOM);
+    Node_Array* values = (Node_Array*) ((*_fields_and_values)[(void*)field]);
+    const Type *t      = Type::TOP;        // Merged type starting value
+
+    for (uint i=1; i<_num_orig_inputs; i++) {
+      assert(values->at(i) != NULL, "shouldn't be null at this point");
+      phi->set_req(i, values->at(i));
+      const Type* input_type = igvn->type(values->at(i));
+      t = t->meet_speculative(input_type);
+    }
+    igvn->set_type(phi, t);
+    phi->raise_bottom_type(t);
+
+    return phi;
+  }
+
+  static ReducedAllocationMergeNode* make(Compile* C, PhaseIterGVN* igvn, PhiNode* phi) {
+    ReducedAllocationMergeNode* ram = new ReducedAllocationMergeNode(C, igvn, phi);
+
+    for (DUIterator_Fast imax, i = phi->fast_outs(imax); i < imax; i++) {
+      Node* n = phi->fast_out(i);
+      ram->register_use(n);
+    }
+
+    igvn->hash_insert(ram);
+
+    return ram;
+  }
+};
+
+
 //------------------------------AbstractLockNode-----------------------------------
 class AbstractLockNode: public CallNode {
 private: