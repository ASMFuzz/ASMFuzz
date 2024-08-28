@@ -358,12 +358,7 @@ Node* IdealKit::load(Node* ctl,
   const TypePtr* adr_type = NULL; // debug-mode-only argument
   debug_only(adr_type = C->get_adr_type(adr_idx));
   Node* mem = memory(adr_idx);
-  Node* ld;
-  if (require_atomic_access && bt == T_LONG) {
-    ld = LoadLNode::make_atomic(ctl, mem, adr, adr_type, t, mo);
-  } else {
-    ld = LoadNode::make(_gvn, ctl, mem, adr, adr_type, t, bt, mo);
-  }
+  Node* ld = LoadNode::make(_gvn, ctl, mem, adr, adr_type, t, bt, mo, LoadNode::DependsOnlyOnTest, require_atomic_access);
   return transform(ld);
 }
 
@@ -375,12 +370,7 @@ Node* IdealKit::store(Node* ctl, Node* adr, Node *val, BasicType bt,
   const TypePtr* adr_type = NULL;
   debug_only(adr_type = C->get_adr_type(adr_idx));
   Node *mem = memory(adr_idx);
-  Node* st;
-  if (require_atomic_access && bt == T_LONG) {
-    st = StoreLNode::make_atomic(ctl, mem, adr, adr_type, val, mo);
-  } else {
-    st = StoreNode::make(_gvn, ctl, mem, adr, adr_type, val, bt, mo);
-  }
+  Node* st = StoreNode::make(_gvn, ctl, mem, adr, adr_type, val, bt, mo, require_atomic_access);
   if (mismatched) {
     st->as_Store()->set_mismatched_access();
   }