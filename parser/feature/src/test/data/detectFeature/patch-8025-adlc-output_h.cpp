@@ -1703,7 +1703,7 @@ void ArchDesc::declareClasses(FILE *fp) {
 
     // If there is an explicit peephole rule, build it
     if ( instr->peepholes() != NULL ) {
-      fprintf(fp,"  virtual MachNode      *peephole(Block *block, int block_index, PhaseRegAlloc *ra_, int &deleted);\n");
+      fprintf(fp,"  virtual int            peephole(Block* block, int block_index, PhaseCFG* cfg_, PhaseRegAlloc* ra_);\n");
     }
 
     // Output the declaration for number of relocation entries