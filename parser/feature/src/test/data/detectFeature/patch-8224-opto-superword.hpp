@@ -458,6 +458,12 @@ class SuperWord : public ResourceObj {
   bool same_origin_idx(Node* a, Node* b) const;
   bool same_generation(Node* a, Node* b) const;
 
+  // Check whether urshift_node can be transformed to rshift node
+  bool can_transform_to_rshift(const Node* urshift_node, const Type* type) const;
+
+  // Transform urshift_node to rshift node
+  Node* transform_to_rshift(Node* urshift_node);
+
   // methods
 
   // Extract the superword level parallelism