@@ -359,7 +359,7 @@ class MachNode : public Node {
   virtual const class TypePtr *adr_type() const;
 
   // Apply peephole rule(s) to this instruction
-  virtual MachNode *peephole(Block *block, int block_index, PhaseRegAlloc *ra_, int &deleted);
+  virtual int peephole(Block *block, int block_index, PhaseCFG* cfg_, PhaseRegAlloc *ra_);
 
   // Top-level ideal Opcode matched
   virtual int ideal_Opcode()     const { return Op_Node; }