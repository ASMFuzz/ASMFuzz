@@ -462,7 +462,8 @@ class Parse : public GraphKit {
   void merge_memory_edges(MergeMemNode* n, int pnum, bool nophi);
 
   // Parse this bytecode, and alter the Parsers JVM->Node mapping
-  void do_one_bytecode();
+  void do_one_bytecode_common();
+  bool do_one_bytecode_targeted();
 
   // helper function to generate array store check
   void array_store_check();
@@ -534,6 +535,10 @@ class Parse : public GraphKit {
   void do_jsr();
   void do_ret();
 
+  // implementation of div/rem bytecodes for handling of special case
+  // min_jint / -1
+  void do_divmod_fixup();
+
   float   dynamic_branch_prediction(float &cnt, BoolTest::mask btest, Node* test);
   float   branch_prediction(float &cnt, BoolTest::mask btest, int target_bci, Node* test);
   bool    seems_never_taken(float prob) const;