@@ -462,8 +462,7 @@ class Parse : public GraphKit {
   void merge_memory_edges(MergeMemNode* n, int pnum, bool nophi);
 
   // Parse this bytecode, and alter the Parsers JVM->Node mapping
-  void do_one_bytecode_common();
-  bool do_one_bytecode_targeted();
+  void do_one_bytecode();
 
   // helper function to generate array store check
   void array_store_check();
@@ -535,10 +534,6 @@ class Parse : public GraphKit {
   void do_jsr();
   void do_ret();
 
-  // implementation of div/rem bytecodes for handling of special case
-  // min_jint / -1
-  void do_divmod_fixup();
-
   float   dynamic_branch_prediction(float &cnt, BoolTest::mask btest, Node* test);
   float   branch_prediction(float &cnt, BoolTest::mask btest, int target_bci, Node* test);
   bool    seems_never_taken(float prob) const;