@@ -293,6 +293,12 @@ Node *MemNode::Ideal_common(PhaseGVN *phase, bool can_reshape) {
   ctl = in(MemNode::Control);
   // Don't bother trying to transform a dead node
   if (ctl && ctl->is_top())  return NodeSentinel;
+  Node *address = in(MemNode::Address);
+  // Don't try to optimize loads under RAM
+  if (address != NULL && address->is_AddP() &&
+    address->in(AddPNode::Base) != NULL && address->in(AddPNode::Base)->is_ReducedAllocationMerge()) {
+    return NodeSentinel;
+  }
 
   PhaseIterGVN *igvn = phase->is_IterGVN();
   // Wait if control on the worklist.
@@ -326,7 +332,6 @@ Node *MemNode::Ideal_common(PhaseGVN *phase, bool can_reshape) {
     return NodeSentinel; // caller will return NULL
   }
 
-  Node *address = in(MemNode::Address);
   const Type *t_adr = phase->type(address);
   if (t_adr == Type::TOP)              return NodeSentinel; // caller will return NULL
 