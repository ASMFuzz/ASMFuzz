@@ -429,8 +429,8 @@ int MachNode::operand_index(Node* def) const {
 
 //------------------------------peephole---------------------------------------
 // Apply peephole rule(s) to this instruction
-MachNode *MachNode::peephole(Block *block, int block_index, PhaseRegAlloc *ra_, int &deleted) {
-  return NULL;
+int MachNode::peephole(Block *block, int block_index, PhaseCFG* cfg_, PhaseRegAlloc *ra_) {
+  return -1;
 }
 
 //------------------------------add_case_label---------------------------------