@@ -1265,7 +1265,8 @@ static void check_peepconstraints(FILE *fp, FormDict &globals, PeepMatch *pmatch
 // }
 
 // Construct the new sub-tree
-static void generate_peepreplace( FILE *fp, FormDict &globals, PeepMatch *pmatch, PeepConstraint *pconstraint, PeepReplace *preplace, int max_position ) {
+static void generate_peepreplace( FILE *fp, FormDict &globals, int peephole_number, PeepMatch *pmatch,
+                                  PeepConstraint *pconstraint, PeepReplace *preplace, int max_position ) {
   fprintf(fp, "      // IF instructions and constraints matched\n");
   fprintf(fp, "      if( matches ) {\n");
   fprintf(fp, "        // generate the new sub-tree\n");
@@ -1314,7 +1315,6 @@ static void generate_peepreplace( FILE *fp, FormDict &globals, PeepMatch *pmatch
           fprintf(fp, "        root->_bottom_type = inst%d->bottom_type();\n", inst_num);
         }
         // Define result register and result operand
-        fprintf(fp, "        ra_->add_reference(root, inst%d);\n", inst_num);
         fprintf(fp, "        ra_->set_oop (root, ra_->is_oop(inst%d));\n", inst_num);
         fprintf(fp, "        ra_->set_pair(root->_idx, ra_->get_reg_second(inst%d), ra_->get_reg_first(inst%d));\n", inst_num, inst_num);
         fprintf(fp, "        root->_opnds[0] = inst%d->_opnds[0]->clone(); // result\n", inst_num);
@@ -1340,20 +1340,28 @@ static void generate_peepreplace( FILE *fp, FormDict &globals, PeepMatch *pmatch
     assert( false, "ShouldNotReachHere();");
   }
 
+  // Set output of the new node
+  fprintf(fp, "        inst0->replace_by(root);\n");
+  // Mark the node as removed because peephole does not remove nodes from the graph
   for (int i = 0; i <= max_position; i++) {
     fprintf(fp, "        inst%d->set_removed();\n", i);
+    fprintf(fp, "        cfg_->map_node_to_block(inst%d, nullptr);\n", i);
   }
-  // Return the new sub-tree
-  fprintf(fp, "        deleted = %d;\n", max_position+1 /*zero to one based*/);
-  fprintf(fp, "        return root;  // return new root;\n");
+  for (int i = 0; i <= max_position; i++) {
+    fprintf(fp, "        block->remove_node(block_index - %d);\n", i);
+  }
+  fprintf(fp, "        block->insert_node(root, block_index - %d);\n", max_position);
+  fprintf(fp, "        cfg_->map_node_to_block(root, block);\n");
+  // Return the peephole index
+  fprintf(fp, "        return %d;  // return the peephole index;\n", peephole_number);
   fprintf(fp, "      }\n");
 }
 
 
 // Define the Peephole method for an instruction node
 void ArchDesc::definePeephole(FILE *fp, InstructForm *node) {
   // Generate Peephole function header
-  fprintf(fp, "MachNode *%sNode::peephole(Block *block, int block_index, PhaseRegAlloc *ra_, int &deleted) {\n", node->_ident);
+  fprintf(fp, "int %sNode::peephole(Block* block, int block_index, PhaseCFG* cfg_, PhaseRegAlloc* ra_) {\n", node->_ident);
   fprintf(fp, "  bool  matches = true;\n");
 
   // Identify the maximum instruction position,
@@ -1366,6 +1374,9 @@ void ArchDesc::definePeephole(FILE *fp, InstructForm *node) {
   int max_position = 0;
   Peephole *peep;
   for( peep = node->peepholes(); peep != NULL; peep = peep->next() ) {
+    if (peep->procedure() != NULL) {
+      continue;
+    }
     PeepMatch *pmatch = peep->match();
     assert( pmatch != NULL, "fatal(), missing peepmatch rule");
     if( max_position < pmatch->max_position() )  max_position = pmatch->max_position();
@@ -1384,7 +1395,9 @@ void ArchDesc::definePeephole(FILE *fp, InstructForm *node) {
   //   If these match, Generate the new subtree
   for( peep = node->peepholes(); peep != NULL; peep = peep->next() ) {
     int         peephole_number = peep->peephole_number();
+    PeepPredicate  *ppredicate  = peep->predicate();
     PeepMatch      *pmatch      = peep->match();
+    PeepProcedure  *pprocedure  = peep->procedure();
     PeepConstraint *pconstraint = peep->constraints();
     PeepReplace    *preplace    = peep->replacement();
 
@@ -1393,29 +1406,58 @@ void ArchDesc::definePeephole(FILE *fp, InstructForm *node) {
             "root of PeepMatch does not match instruction");
 
     // Make each peephole rule individually selectable
-    fprintf(fp, "  if( (OptoPeepholeAt == -1) || (OptoPeepholeAt==%d) ) {\n", peephole_number);
-    fprintf(fp, "    matches = true;\n");
-    // Scan the peepmatch and output a test for each instruction
-    check_peepmatch_instruction_sequence( fp, pmatch, pconstraint );
+    fprintf(fp, "  if( ((OptoPeepholeAt == -1) || (OptoPeepholeAt==%d)) && ( %s ) ) {\n",
+            peephole_number, ppredicate != NULL ? ppredicate->rule() : "true");
+    if (pprocedure == NULL) {
+      fprintf(fp, "    matches = true;\n");
+      // Scan the peepmatch and output a test for each instruction
+      check_peepmatch_instruction_sequence( fp, pmatch, pconstraint );
+
+      // Check constraints and build replacement inside scope
+      fprintf(fp, "    // If instruction subtree matches\n");
+      fprintf(fp, "    if( matches ) {\n");
 
-    // Check constraints and build replacement inside scope
-    fprintf(fp, "    // If instruction subtree matches\n");
-    fprintf(fp, "    if( matches ) {\n");
+      // Generate tests for the constraints
+      check_peepconstraints( fp, _globalNames, pmatch, pconstraint );
 
-    // Generate tests for the constraints
-    check_peepconstraints( fp, _globalNames, pmatch, pconstraint );
+      // Construct the new sub-tree
+      generate_peepreplace( fp, _globalNames, peephole_number, pmatch, pconstraint, preplace, max_position );
 
-    // Construct the new sub-tree
-    generate_peepreplace( fp, _globalNames, pmatch, pconstraint, preplace, max_position );
+      // End of scope for this peephole's constraints
+      fprintf(fp, "    }\n");
+    } else {
+      const char* replace_inst = NULL;
+      preplace->next_instruction(replace_inst);
+      // Generate the target instruction
+      fprintf(fp, "    auto replacing = [](){ return static_cast<MachNode*>(new %sNode()); };\n", replace_inst);
+
+      // Call the precedure
+      fprintf(fp, "    bool replacement = Peephole::%s(block, block_index, cfg_, ra_, replacing", pprocedure->name());
+
+      int         parent        = -1;
+      int         inst_position = 0;
+      const char* inst_name     = NULL;
+      int         input         = 0;
+      pmatch->reset();
+      for (pmatch->next_instruction(parent, inst_position, inst_name, input);
+           inst_name != NULL;
+           pmatch->next_instruction(parent, inst_position, inst_name, input)) {
+        fprintf(fp, ", %s_rule", inst_name);
+      }
+      fprintf(fp, ");\n");
+
+      // If substitution succeeded, return the new node
+      fprintf(fp, "    if (replacement) {\n");
+      fprintf(fp, "      return %d;\n", peephole_number);
+      fprintf(fp, "    }\n");
+    }
 
-    // End of scope for this peephole's constraints
-    fprintf(fp, "    }\n");
     // Closing brace '}' to make each peephole rule individually selectable
     fprintf(fp, "  } // end of peephole rule #%d\n", peephole_number);
     fprintf(fp, "\n");
   }
 
-  fprintf(fp, "  return NULL;  // No peephole rules matched\n");
+  fprintf(fp, "  return -1;  // No peephole rules matched\n");
   fprintf(fp, "}\n");
   fprintf(fp, "\n");
 }