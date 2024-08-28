@@ -1535,14 +1535,7 @@ Node* GraphKit::make_load(Node* ctl, Node* adr, const Type* t, BasicType bt,
   const TypePtr* adr_type = NULL; // debug-mode-only argument
   debug_only(adr_type = C->get_adr_type(adr_idx));
   Node* mem = memory(adr_idx);
-  Node* ld;
-  if (require_atomic_access && bt == T_LONG) {
-    ld = LoadLNode::make_atomic(ctl, mem, adr, adr_type, t, mo, control_dependency, unaligned, mismatched, unsafe, barrier_data);
-  } else if (require_atomic_access && bt == T_DOUBLE) {
-    ld = LoadDNode::make_atomic(ctl, mem, adr, adr_type, t, mo, control_dependency, unaligned, mismatched, unsafe, barrier_data);
-  } else {
-    ld = LoadNode::make(_gvn, ctl, mem, adr, adr_type, t, bt, mo, control_dependency, unaligned, mismatched, unsafe, barrier_data);
-  }
+  Node* ld = LoadNode::make(_gvn, ctl, mem, adr, adr_type, t, bt, mo, control_dependency, require_atomic_access, unaligned, mismatched, unsafe, barrier_data);
   ld = _gvn.transform(ld);
   if (((bt == T_OBJECT) && C->do_escape_analysis()) || C->eliminate_boxing()) {
     // Improve graph before escape analysis and boxing elimination.
@@ -1562,14 +1555,7 @@ Node* GraphKit::store_to_memory(Node* ctl, Node* adr, Node *val, BasicType bt,
   const TypePtr* adr_type = NULL;
   debug_only(adr_type = C->get_adr_type(adr_idx));
   Node *mem = memory(adr_idx);
-  Node* st;
-  if (require_atomic_access && bt == T_LONG) {
-    st = StoreLNode::make_atomic(ctl, mem, adr, adr_type, val, mo);
-  } else if (require_atomic_access && bt == T_DOUBLE) {
-    st = StoreDNode::make_atomic(ctl, mem, adr, adr_type, val, mo);
-  } else {
-    st = StoreNode::make(_gvn, ctl, mem, adr, adr_type, val, bt, mo);
-  }
+  Node* st = StoreNode::make(_gvn, ctl, mem, adr, adr_type, val, bt, mo, require_atomic_access);
   if (unaligned) {
     st->as_Store()->set_unaligned_access();
   }