@@ -28,6 +28,7 @@
 #include "opto/addnode.hpp"
 #include "opto/node.hpp"
 #include "utilities/growableArray.hpp"
+#include "utilities/ostream.hpp"
 
 //
 // Adaptation for C2 of the escape analysis algorithm described in:
@@ -232,7 +233,7 @@ class PointsToNode : public ResourceObj {
 
 #ifndef PRODUCT
   NodeType node_type() const { return (NodeType)_type;}
-  void dump(bool print_state=true) const;
+  void dump(outputStream* st=NULL, bool print_state=true) const;
 #endif
 
 };
@@ -344,10 +345,13 @@ class ConnectionGraph: public ResourceObj {
   int        _build_iterations; // Number of iterations took to build graph
   double           _build_time; // Time (sec) took to build graph
 
-public:
   JavaObjectNode* phantom_obj; // Unknown object
 
-private:
+  // Check if the ideal node with ID 'idx' is present in the Connection Graph.
+  bool is_ideal_node_in_graph(uint idx) const {
+    return idx < nodes_size() && _nodes.at(idx) != NULL;
+  }
+
   // Address of an element in _nodes.  Used when the element is to be modified
   PointsToNode* ptnode_adr(int idx) const {
     // There should be no new ideal nodes during ConnectionGraph build,
@@ -532,6 +536,11 @@ class ConnectionGraph: public ResourceObj {
   PhiNode *create_split_phi(PhiNode *orig_phi, int alias_idx, GrowableArray<PhiNode *>  &orig_phi_worklist, bool &new_created);
   PhiNode *split_memory_phi(PhiNode *orig_phi, int alias_idx, GrowableArray<PhiNode *>  &orig_phi_worklist);
 
+  bool should_split_this_phi(Node* n, Unique_Node_List& splitted_phi_nodes);
+  Node* create_selector_phi(Node* orig_phi);
+  void clone_addp_and_load_chain(Node* original_phi, uint idx, Node* original_addp, Node* original_addp_use, Unique_Node_List& splitted_phi_nodes, Node* final_merge_region, Node* final_merge_phi, Node* merge_ctrl);
+  Node* split_phi_for_addp(Node* orig_phi, Node* use, Node* prev_control, Unique_Node_List& split_phi_nodes);
+
   void  move_inst_mem(Node* n, GrowableArray<PhiNode *>  &orig_phis);
   Node* find_inst_mem(Node* mem, int alias_idx,GrowableArray<PhiNode *>  &orig_phi_worklist);
   Node* step_through_mergemem(MergeMemNode *mmem, int alias_idx, const TypeOopPtr *toop);
@@ -567,7 +576,7 @@ class ConnectionGraph: public ResourceObj {
   void record_for_optimizer(Node *n);
 
   // Compute the escape information
-  bool compute_escape();
+  bool compute_escape(bool only_analysis);
 
 public:
   ConnectionGraph(Compile *C, PhaseIterGVN *igvn, int iteration);
@@ -576,7 +585,10 @@ class ConnectionGraph: public ResourceObj {
   static bool has_candidates(Compile *C);
 
   // Perform escape analysis
-  static void do_analysis(Compile *C, PhaseIterGVN *igvn);
+  static void do_analysis(Compile *C, PhaseIterGVN *igvn, bool only_analysis = false);
+
+  void split_bases(Unique_Node_List& split_phi_nodes);
+  bool were_splitted_bases_removed(Unique_Node_List& split_phi_nodes);
 
   bool not_global_escape(Node *n);
 
@@ -612,7 +624,12 @@ class ConnectionGraph: public ResourceObj {
   bool add_final_edges_unsafe_access(Node* n, uint opcode);
 
 #ifndef PRODUCT
-  void dump(GrowableArray<PointsToNode*>& ptnodes_worklist);
+  static bool _collectingTrace;
+  stringStream _traceStream;
+
+  void dump_ir(const char* title);
+  void save_trace();
+  void dump(GrowableArray<PointsToNode*>& ptnodes_worklist, const char* label = NULL);
 #endif
 };
 