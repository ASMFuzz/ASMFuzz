@@ -3345,6 +3345,13 @@ void SuperWord::compute_vector_element_type() {
                 vt = TypeInt::INT;
               }
             }
+
+            if (op == Op_URShiftI && can_transform_to_rshift(in, vt)) {
+              // Transform urshift(short/byte) to rshift(short/byte) in hoping that
+              // the shift operation may be vectorized.
+              in = transform_to_rshift(in);
+            }
+
             set_velt_type(in, vt);
           }
         }
@@ -4606,6 +4613,39 @@ bool SuperWord::same_generation(Node* a, Node* b) const {
   return a != NULL && b != NULL && _clone_map.same_gen(a->_idx, b->_idx);
 }
 
+bool SuperWord::can_transform_to_rshift(const Node* urshift_node, const Type* type) const {
+  assert(urshift_node->Opcode() == Op_URShiftI, "Can be only called with a urshift node");
+  const TypeInt *t = _igvn.type(urshift_node->in(2))->isa_int();
+  if(t && t->is_con()) {
+    int shift_cnt = t->get_con();
+    if (((type == TypeInt::SHORT) && (shift_cnt <= 16)) ||
+        ((type == TypeInt::BYTE)  && (shift_cnt <= 24))) {
+      return true;
+    }
+  }
+  return false;
+}
+
+Node* SuperWord::transform_to_rshift(Node* urshift_node) {
+  assert(urshift_node->Opcode() == Op_URShiftI, "Can be only called with a urshift node");
+  Node* rshift_node = new RShiftINode(urshift_node->in(1), urshift_node->in(2));
+
+  int idx = bb_idx(urshift_node);
+  set_bb_idx(rshift_node, idx);
+  _phase->set_ctrl(rshift_node, _phase->get_ctrl(urshift_node));
+  _igvn.register_new_node_with_optimizer(rshift_node, urshift_node);
+  _igvn.replace_node(urshift_node, rshift_node);
+
+  // Update block, loop body and packset
+  _block.at_put(idx, rshift_node);
+  lpt()->_body.replace(urshift_node, rshift_node);
+  for (int i = 0; i < _packset.length(); i++) {
+    _packset.at(i)->replace(urshift_node, rshift_node);
+  }
+
+  return rshift_node;
+}
+
 Node*  SuperWord::find_phi_for_mem_dep(LoadNode* ld) {
   assert(in_bb(ld), "must be in block");
   if (_clone_map.gen(ld->_idx) == _ii_first) {