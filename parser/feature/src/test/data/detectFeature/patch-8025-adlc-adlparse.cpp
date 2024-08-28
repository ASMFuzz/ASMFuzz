@@ -2046,14 +2046,20 @@ void ADLParser::peep_parse(void) {
         return;
       }
       // check for legal subsections of peephole rule
-      if (strcmp(token,"peepmatch")==0) {
+      if (strcmp(token,"peeppredicate")==0) {
+        peep_predicate_parse(*peep); }
+      else if (strcmp(token,"peepmatch")==0) {
         peep_match_parse(*peep); }
+      else if (strcmp(token, "peepprocedure")==0) {
+        peep_procedure_parse(*peep); }
       else if (strcmp(token,"peepconstraint")==0) {
         peep_constraint_parse(*peep); }
       else if (strcmp(token,"peepreplace")==0) {
         peep_replace_parse(*peep); }
       else {
-        parse_err(SYNERR, "expected peepmatch, peepconstraint, or peepreplace for identifier %s.\n", token);
+        parse_err(SYNERR,
+            "expected peeppreddicate, peepmatch, peepprocedure, peepconstraint, peepreplace, received %s.\n",
+            token);
       }
       skipws();
     }
@@ -2537,6 +2543,31 @@ InstructForm *ADLParser::peep_match_child_parse(PeepMatch &match, int parent, in
   return NULL;
 }
 
+//---------------------------peep-predicate-parse------------------------------
+// Syntax for a peeppredicate rule
+//
+// peeppredicate ( predicate );
+//
+void ADLParser::peep_predicate_parse(Peephole& peep) {
+
+  skipws();
+  char* rule = nullptr;
+  if ( (rule = get_paren_expr("pred expression", true)) == nullptr ) {
+    parse_err(SYNERR, "incorrect or missing expression for 'peeppredicate'\n");
+    return;
+  }
+  if (_curchar != ';') {
+    parse_err(SYNERR, "missing ';' in peeppredicate definition\n");
+    return;
+  }
+  next_char();   // skip ';'
+  skipws();
+
+  // Construct PeepPredicate
+  PeepPredicate* predicate = new PeepPredicate(rule);
+  peep.add_predicate(predicate);
+}
+
 //------------------------------peep_match_parse-------------------------------
 // Syntax for a peepmatch rule
 //
@@ -2583,6 +2614,46 @@ void ADLParser::peep_match_parse(Peephole &peep) {
   root->append_peephole(&peep);
 }
 
+//---------------------------peep-procedure-parse------------------------------
+// Syntax for a peepprocedure rule
+//
+// peeppredicate ( function_name );
+//
+void ADLParser::peep_procedure_parse(Peephole& peep) {
+
+  skipws();
+  // Check for open paren
+  if (_curchar != '(') {
+    parse_err(SYNERR, "missing '(' at start of peepprocedure rule.\n");
+    return;
+  }
+  next_char();   // skip '('
+  skipws();
+
+  char* name = nullptr;
+  if ( (name = get_ident_dup()) == nullptr ) {
+    parse_err(SYNERR, "incorrect or missing expression for 'peepprocedure'\n");
+    return;
+  }
+
+  skipws();
+  if (_curchar != ')') {
+    parse_err(SYNERR, "peepprocedure should contain a single identifier only\n");
+    return;
+  }
+  next_char();   // skip ')'
+  if (_curchar != ';') {
+    parse_err(SYNERR, "missing ';' in peepprocedure definition\n");
+    return;
+  }
+  next_char();   // skip ';'
+  skipws();
+
+  // Construct PeepProcedure
+  PeepProcedure* procedure = new PeepProcedure(name);
+  peep.add_procedure(procedure);
+}
+
 //------------------------------peep_constraint_parse--------------------------
 // Syntax for a peepconstraint rule
 // A parenthesized list of relations between operands in peepmatch subtree
@@ -2629,7 +2700,7 @@ void ADLParser::peep_constraint_parse(Peephole &peep) {
 
     skipws();
     // Get information on the right instruction and its operand
-    int right_inst;        // Right-instructions's number
+    int right_inst;        // Right-instruction's number
     if( isdigit(_curchar) ) {
       right_inst = get_int();
       // Right-instruction's operand