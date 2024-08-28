@@ -125,17 +125,18 @@ static Node *merge_region(RegionNode *region, PhaseGVN *phase) {
 
 
 //--------------------------------has_phi--------------------------------------
-// Helper function: Return any PhiNode that uses this region or NULL
-PhiNode* RegionNode::has_phi() const {
+// Helper function: Return true if there is any PhiNode or ReducedAllocationMerge
+// using this region node.
+bool RegionNode::has_phi() const {
   for (DUIterator_Fast imax, i = fast_outs(imax); i < imax; i++) {
     Node* phi = fast_out(i);
-    if (phi->is_Phi()) {   // Check for Phi users
+    if (phi->is_Phi() || phi->is_ReducedAllocationMerge()) {
       assert(phi->in(0) == (Node*)this, "phi uses region only via in(0)");
-      return phi->as_Phi();  // this one is good enough
+      return true;
     }
   }
 
-  return NULL;
+  return false;
 }
 
 
@@ -447,7 +448,7 @@ Node *RegionNode::Ideal(PhaseGVN *phase, bool can_reshape) {
   // arm of the same IF.  If found, then the control-flow split is useless.
   bool has_phis = false;
   if (can_reshape) {            // Need DU info to check for Phi users
-    has_phis = (has_phi() != NULL);       // Cache result
+    has_phis = has_phi();       // Cache result
     if (has_phis && try_clean_mem_phi(phase)) {
       has_phis = false;
     }