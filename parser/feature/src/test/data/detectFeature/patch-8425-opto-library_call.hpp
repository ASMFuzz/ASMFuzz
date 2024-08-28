@@ -344,6 +344,8 @@ class LibraryCallKit : public GraphKit {
   bool inline_vector_convert();
   bool inline_vector_extract();
   bool inline_vector_insert();
+  bool inline_vector_compress_expand();
+
   Node* gen_call_to_svml(int vector_api_op_id, BasicType bt, int num_elem, Node* opd1, Node* opd2);
 
   enum VectorMaskUseType {