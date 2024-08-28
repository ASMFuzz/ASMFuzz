@@ -355,6 +355,12 @@ class ConnectionGraph: public ResourceObj {
     // growableArray::at() will throw assert otherwise.
     return _nodes.at(idx);
   }
+
+  // Check if the ideal node with ID 'idx' is present in the Connection Graph.
+  bool is_ideal_node_in_graph(uint idx) const {
+    return idx < nodes_size() && _nodes.at(idx) != NULL;
+  }
+
   uint nodes_size() const { return _nodes.length(); }
 
   uint next_pidx() { return _next_pidx++; }
@@ -573,7 +579,10 @@ class ConnectionGraph: public ResourceObj {
   void record_for_optimizer(Node *n);
 
   // Compute the escape information
-  bool compute_escape();
+  bool compute_escape(bool only_analysis);
+  Node* come_from_allocate(Node* n);
+  bool should_reduce_this_phi(Node* n);
+  void reduce_this_phi(PhiNode* n);
 
   void set_not_scalar_replaceable(PointsToNode* ptn NOT_PRODUCT(COMMA const char* reason)) const {
 #ifndef PRODUCT
@@ -600,7 +609,9 @@ class ConnectionGraph: public ResourceObj {
   static bool has_candidates(Compile *C);
 
   // Perform escape analysis
-  static void do_analysis(Compile *C, PhaseIterGVN *igvn);
+  static void do_analysis(Compile *C, PhaseIterGVN *igvn, bool only_analysis = false);
+
+  void reduce_allocation_merges();
 
   bool not_global_escape(Node *n);
 
@@ -636,7 +647,8 @@ class ConnectionGraph: public ResourceObj {
   bool add_final_edges_unsafe_access(Node* n, uint opcode);
 
 #ifndef PRODUCT
-  void dump(GrowableArray<PointsToNode*>& ptnodes_worklist);
+  void dump(GrowableArray<PointsToNode*>& ptnodes_worklist, const char* title = NULL);
+  void dump_ir(const char* title);
 #endif
 };
 