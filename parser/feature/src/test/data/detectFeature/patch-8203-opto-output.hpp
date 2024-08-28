@@ -240,8 +240,6 @@ class PhaseOutput : public Phase {
 
   int               bang_size_in_bytes() const;
 
-  uint              node_bundling_limit();
-  Bundle*           node_bundling_base();
   void          set_node_bundling_limit(uint n) { _node_bundling_limit = n; }
   void          set_node_bundling_base(Bundle* b) { _node_bundling_base = b; }
 
@@ -253,10 +251,8 @@ class PhaseOutput : public Phase {
   // Dump formatted assembly
 #if defined(SUPPORT_OPTO_ASSEMBLY)
   void dump_asm_on(outputStream* ost, int* pcs, uint pc_limit);
-  void dump_asm(int* pcs = NULL, uint pc_limit = 0) { dump_asm_on(tty, pcs, pc_limit); }
 #else
   void dump_asm_on(outputStream* ost, int* pcs, uint pc_limit) { return; }
-  void dump_asm(int* pcs = NULL, uint pc_limit = 0) { return; }
 #endif
 
   // Build OopMaps for each GC point