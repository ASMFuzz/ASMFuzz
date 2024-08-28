@@ -636,7 +636,12 @@ class ConnectionGraph: public ResourceObj {
   bool add_final_edges_unsafe_access(Node* n, uint opcode);
 
 #ifndef PRODUCT
+  static int _no_escape_counter;
+  static int _arg_escape_counter;
+  static int _global_escape_counter;
   void dump(GrowableArray<PointsToNode*>& ptnodes_worklist);
+  static void print_statistics();
+  void escape_state_statistics(GrowableArray<JavaObjectNode*>& java_objects_worklist);
 #endif
 };
 