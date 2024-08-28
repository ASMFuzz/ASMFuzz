@@ -91,19 +91,19 @@ Node* BarrierSetC2::store_at_resolved(C2Access& access, C2AccessValue& val) cons
   MemNode::MemOrd mo = access.mem_node_mo();
 
   Node* store;
+  BasicType bt = access.type();
   if (access.is_parse_access()) {
     C2ParseAccess& parse_access = static_cast<C2ParseAccess&>(access);
 
     GraphKit* kit = parse_access.kit();
-    if (access.type() == T_DOUBLE) {
+    if (bt == T_DOUBLE) {
       Node* new_val = kit->dprecision_rounding(val.node());
       val.set_node(new_val);
     }
 
-    store = kit->store_to_memory(kit->control(), access.addr().node(), val.node(), access.type(),
-                                     access.addr().type(), mo, requires_atomic_access, unaligned, mismatched, unsafe);
+    store = kit->store_to_memory(kit->control(), access.addr().node(), val.node(), bt,
+                                 access.addr().type(), mo, requires_atomic_access, unaligned, mismatched, unsafe);
   } else {
-    assert(!requires_atomic_access, "not yet supported");
     assert(access.is_opt_access(), "either parse or opt access");
     C2OptAccess& opt_access = static_cast<C2OptAccess&>(access);
     Node* ctl = opt_access.ctl();
@@ -113,7 +113,7 @@ Node* BarrierSetC2::store_at_resolved(C2Access& access, C2AccessValue& val) cons
     int alias = gvn.C->get_alias_index(adr_type);
     Node* mem = mm->memory_at(alias);
 
-    StoreNode* st = StoreNode::make(gvn, ctl, mem, access.addr().node(), adr_type, val.node(), access.type(), mo);
+    StoreNode* st = StoreNode::make(gvn, ctl, mem, access.addr().node(), adr_type, val.node(), bt, mo, requires_atomic_access);
     if (unaligned) {
       st->set_unaligned_access();
     }
@@ -156,28 +156,26 @@ Node* BarrierSetC2::load_at_resolved(C2Access& access, const Type* val_type) con
     Node* control = control_dependent ? kit->control() : NULL;
 
     if (immutable) {
-      assert(!requires_atomic_access, "can't ensure atomicity");
       Compile* C = Compile::current();
       Node* mem = kit->immutable_memory();
       load = LoadNode::make(kit->gvn(), control, mem, adr,
-                            adr_type, val_type, access.type(), mo, dep, unaligned,
-                            mismatched, unsafe, access.barrier_data());
+                            adr_type, val_type, access.type(), mo, dep, requires_atomic_access,
+                            unaligned, mismatched, unsafe, access.barrier_data());
       load = kit->gvn().transform(load);
     } else {
       load = kit->make_load(control, adr, val_type, access.type(), adr_type, mo,
                             dep, requires_atomic_access, unaligned, mismatched, unsafe,
                             access.barrier_data());
     }
   } else {
-    assert(!requires_atomic_access, "not yet supported");
     assert(access.is_opt_access(), "either parse or opt access");
     C2OptAccess& opt_access = static_cast<C2OptAccess&>(access);
     Node* control = control_dependent ? opt_access.ctl() : NULL;
     MergeMemNode* mm = opt_access.mem();
     PhaseGVN& gvn = opt_access.gvn();
     Node* mem = mm->memory_at(gvn.C->get_alias_index(adr_type));
-    load = LoadNode::make(gvn, control, mem, adr, adr_type, val_type, access.type(), mo,
-                          dep, unaligned, mismatched, unsafe, access.barrier_data());
+    load = LoadNode::make(gvn, control, mem, adr, adr_type, val_type, access.type(), mo, dep,
+                          requires_atomic_access, unaligned, mismatched, unsafe, access.barrier_data());
     load = gvn.transform(load);
   }
   access.set_raw_access(load);