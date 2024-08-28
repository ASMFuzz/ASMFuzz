@@ -861,8 +861,8 @@ bool LoadNode::is_immutable_value(Node* adr) {
 
 //----------------------------LoadNode::make-----------------------------------
 // Polymorphic factory method:
-Node *LoadNode::make(PhaseGVN& gvn, Node *ctl, Node *mem, Node *adr, const TypePtr* adr_type, const Type *rt, BasicType bt, MemOrd mo,
-                     ControlDependency control_dependency, bool unaligned, bool mismatched, bool unsafe, uint8_t barrier_data) {
+Node* LoadNode::make(PhaseGVN& gvn, Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, const Type* rt, BasicType bt, MemOrd mo,
+                     ControlDependency control_dependency, bool require_atomic_access, bool unaligned, bool mismatched, bool unsafe, uint8_t barrier_data) {
   Compile* C = gvn.C;
 
   // sanity check the alias category against the created node type
@@ -884,9 +884,9 @@ Node *LoadNode::make(PhaseGVN& gvn, Node *ctl, Node *mem, Node *adr, const TypeP
   case T_INT:     load = new LoadINode (ctl, mem, adr, adr_type, rt->is_int(),  mo, control_dependency); break;
   case T_CHAR:    load = new LoadUSNode(ctl, mem, adr, adr_type, rt->is_int(),  mo, control_dependency); break;
   case T_SHORT:   load = new LoadSNode (ctl, mem, adr, adr_type, rt->is_int(),  mo, control_dependency); break;
-  case T_LONG:    load = new LoadLNode (ctl, mem, adr, adr_type, rt->is_long(), mo, control_dependency); break;
+  case T_LONG:    load = new LoadLNode (ctl, mem, adr, adr_type, rt->is_long(), mo, control_dependency, require_atomic_access); break;
   case T_FLOAT:   load = new LoadFNode (ctl, mem, adr, adr_type, rt,            mo, control_dependency); break;
-  case T_DOUBLE:  load = new LoadDNode (ctl, mem, adr, adr_type, rt,            mo, control_dependency); break;
+  case T_DOUBLE:  load = new LoadDNode (ctl, mem, adr, adr_type, rt,            mo, control_dependency, require_atomic_access); break;
   case T_ADDRESS: load = new LoadPNode (ctl, mem, adr, adr_type, rt->is_ptr(),  mo, control_dependency); break;
   case T_OBJECT:
 #ifdef _LP64
@@ -922,42 +922,6 @@ Node *LoadNode::make(PhaseGVN& gvn, Node *ctl, Node *mem, Node *adr, const TypeP
   return load;
 }
 
-LoadLNode* LoadLNode::make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, const Type* rt, MemOrd mo,
-                                  ControlDependency control_dependency, bool unaligned, bool mismatched, bool unsafe, uint8_t barrier_data) {
-  bool require_atomic = true;
-  LoadLNode* load = new LoadLNode(ctl, mem, adr, adr_type, rt->is_long(), mo, control_dependency, require_atomic);
-  if (unaligned) {
-    load->set_unaligned_access();
-  }
-  if (mismatched) {
-    load->set_mismatched_access();
-  }
-  if (unsafe) {
-    load->set_unsafe_access();
-  }
-  load->set_barrier_data(barrier_data);
-  return load;
-}
-
-LoadDNode* LoadDNode::make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, const Type* rt, MemOrd mo,
-                                  ControlDependency control_dependency, bool unaligned, bool mismatched, bool unsafe, uint8_t barrier_data) {
-  bool require_atomic = true;
-  LoadDNode* load = new LoadDNode(ctl, mem, adr, adr_type, rt, mo, control_dependency, require_atomic);
-  if (unaligned) {
-    load->set_unaligned_access();
-  }
-  if (mismatched) {
-    load->set_mismatched_access();
-  }
-  if (unsafe) {
-    load->set_unsafe_access();
-  }
-  load->set_barrier_data(barrier_data);
-  return load;
-}
-
-
-
 //------------------------------hash-------------------------------------------
 uint LoadNode::hash() const {
   // unroll addition of interesting fields
@@ -1289,7 +1253,7 @@ Node* LoadNode::convert_to_unsigned_load(PhaseGVN& gvn) {
   }
   return LoadNode::make(gvn, in(MemNode::Control), in(MemNode::Memory), in(MemNode::Address),
                         raw_adr_type(), rt, bt, _mo, _control_dependency,
-                        is_unaligned_access(), is_mismatched_access());
+                        false /*require_atomic_access*/, is_unaligned_access(), is_mismatched_access());
 }
 
 // Construct an equivalent signed load.
@@ -1309,7 +1273,7 @@ Node* LoadNode::convert_to_signed_load(PhaseGVN& gvn) {
   }
   return LoadNode::make(gvn, in(MemNode::Control), in(MemNode::Memory), in(MemNode::Address),
                         raw_adr_type(), rt, bt, _mo, _control_dependency,
-                        is_unaligned_access(), is_mismatched_access());
+                        false /*require_atomic_access*/, is_unaligned_access(), is_mismatched_access());
 }
 
 bool LoadNode::has_reinterpret_variant(const Type* rt) {
@@ -1332,9 +1296,12 @@ Node* LoadNode::convert_to_reinterpret_load(PhaseGVN& gvn, const Type* rt) {
   if (raw_type == NULL) {
     is_mismatched = true; // conservatively match all non-raw accesses as mismatched
   }
+  const int op = Opcode();
+  bool require_atomic_access = (op == Op_LoadL && ((LoadLNode*)this)->require_atomic_access()) ||
+                               (op == Op_LoadD && ((LoadDNode*)this)->require_atomic_access());
   return LoadNode::make(gvn, in(MemNode::Control), in(MemNode::Memory), in(MemNode::Address),
                         raw_adr_type(), rt, bt, _mo, _control_dependency,
-                        is_unaligned_access(), is_mismatched);
+                        require_atomic_access, is_unaligned_access(), is_mismatched);
 }
 
 bool StoreNode::has_reinterpret_variant(const Type* vt) {
@@ -1352,7 +1319,11 @@ bool StoreNode::has_reinterpret_variant(const Type* vt) {
 Node* StoreNode::convert_to_reinterpret_store(PhaseGVN& gvn, Node* val, const Type* vt) {
   BasicType bt = vt->basic_type();
   assert(has_reinterpret_variant(vt), "no reinterpret variant: %s %s", Name(), type2name(bt));
-  StoreNode* st = StoreNode::make(gvn, in(MemNode::Control), in(MemNode::Memory), in(MemNode::Address), raw_adr_type(), val, bt, _mo);
+  const int op = Opcode();
+  bool require_atomic_access = (op == Op_StoreL && ((StoreLNode*)this)->require_atomic_access()) ||
+                               (op == Op_StoreD && ((StoreDNode*)this)->require_atomic_access());
+  StoreNode* st = StoreNode::make(gvn, in(MemNode::Control), in(MemNode::Memory), in(MemNode::Address),
+                                  raw_adr_type(), val, bt, _mo, require_atomic_access);
 
   bool is_mismatched = is_mismatched_access();
   const TypeRawPtr* raw_type = gvn.type(in(MemNode::Memory))->isa_rawptr();
@@ -2582,7 +2553,7 @@ Node* LoadRangeNode::Identity(PhaseGVN* phase) {
 //=============================================================================
 //---------------------------StoreNode::make-----------------------------------
 // Polymorphic factory method:
-StoreNode* StoreNode::make(PhaseGVN& gvn, Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, Node* val, BasicType bt, MemOrd mo) {
+StoreNode* StoreNode::make(PhaseGVN& gvn, Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, Node* val, BasicType bt, MemOrd mo, bool require_atomic_access) {
   assert((mo == unordered || mo == release), "unexpected");
   Compile* C = gvn.C;
   assert(C->get_alias_index(adr_type) != Compile::AliasIdxRaw ||
@@ -2594,9 +2565,9 @@ StoreNode* StoreNode::make(PhaseGVN& gvn, Node* ctl, Node* mem, Node* adr, const
   case T_INT:     return new StoreINode(ctl, mem, adr, adr_type, val, mo);
   case T_CHAR:
   case T_SHORT:   return new StoreCNode(ctl, mem, adr, adr_type, val, mo);
-  case T_LONG:    return new StoreLNode(ctl, mem, adr, adr_type, val, mo);
+  case T_LONG:    return new StoreLNode(ctl, mem, adr, adr_type, val, mo, require_atomic_access);
   case T_FLOAT:   return new StoreFNode(ctl, mem, adr, adr_type, val, mo);
-  case T_DOUBLE:  return new StoreDNode(ctl, mem, adr, adr_type, val, mo);
+  case T_DOUBLE:  return new StoreDNode(ctl, mem, adr, adr_type, val, mo, require_atomic_access);
   case T_METADATA:
   case T_ADDRESS:
   case T_OBJECT:
@@ -2620,17 +2591,6 @@ StoreNode* StoreNode::make(PhaseGVN& gvn, Node* ctl, Node* mem, Node* adr, const
   }
 }
 
-StoreLNode* StoreLNode::make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, Node* val, MemOrd mo) {
-  bool require_atomic = true;
-  return new StoreLNode(ctl, mem, adr, adr_type, val, mo, require_atomic);
-}
-
-StoreDNode* StoreDNode::make_atomic(Node* ctl, Node* mem, Node* adr, const TypePtr* adr_type, Node* val, MemOrd mo) {
-  bool require_atomic = true;
-  return new StoreDNode(ctl, mem, adr, adr_type, val, mo, require_atomic);
-}
-
-
 //--------------------------bottom_type----------------------------------------
 const Type *StoreNode::bottom_type() const {
   return Type::MEMORY;