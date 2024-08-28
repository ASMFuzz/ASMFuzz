@@ -2849,16 +2849,24 @@ Node* SuperWord::vector_opd(Node_List* p, int opd_idx) {
   uint vlen = p->size();
   Node* opd = p0->in(opd_idx);
   CountedLoopNode *cl = lpt()->_head->as_CountedLoop();
+  bool have_same_inputs = same_inputs(p, opd_idx);
 
   if (cl->is_rce_post_loop()) {
     // override vlen with the main loops vector length
+    assert(p->size() == 1, "Packs in post loop should have only one node");
     vlen = cl->slp_max_unroll();
   }
 
-  // Insert index population operation
-  if (opd == iv()) {
+  // Insert index population operation to create a vector of increasing
+  // indices starting from the iv value. In some special unrolled loops
+  // (see JDK-8286125), we need scalar replications of the iv value if
+  // all inputs are the same iv, so we do a same inputs check here. But
+  // in post loops, "have_same_inputs" is always true because all packs
+  // are singleton. That's why a pack size check is also required.
+  if (opd == iv() && (!have_same_inputs || p->size() == 1)) {
     BasicType p0_bt = velt_basic_type(p0);
     BasicType iv_bt = is_subword_type(p0_bt) ? p0_bt : T_INT;
+    assert(VectorNode::is_populate_index_supported(iv_bt), "Should support");
     const TypeVect* vt = TypeVect::make(iv_bt, vlen);
     Node* vn = new PopulateIndexNode(iv(), _igvn.intcon(1), vt);
 #ifdef ASSERT
@@ -2872,7 +2880,7 @@ Node* SuperWord::vector_opd(Node_List* p, int opd_idx) {
     return vn;
   }
 
-  if (same_inputs(p, opd_idx)) {
+  if (have_same_inputs) {
     if (opd->is_Vector() || opd->is_LoadVector()) {
       assert(((opd_idx != 2) || !VectorNode::is_shift(p0)), "shift's count can't be vector");
       if (opd_idx == 2 && VectorNode::is_shift(p0)) {