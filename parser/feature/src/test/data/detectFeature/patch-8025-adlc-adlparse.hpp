@@ -62,7 +62,9 @@ class PipeDesc;
 class PipeClass;
 class RegList;
 // ***** Peephole Section *****
+class PeepPredicate;
 class PeepMatch;
+class PeepProcedure;
 class PeepConstraint;
 class PeepReplace;
 
@@ -136,7 +138,9 @@ class ADLParser {
   void pipe_class_parse(PipelineForm &pipe); // Parse pipeline class definition
 
   // Parse components of a peephole rule
+  void peep_predicate_parse(Peephole &peep); // Parse the peephole predicate
   void peep_match_parse(Peephole &peep);     // Parse the peephole match rule
+  void peep_procedure_parse(Peephole &peep); // Parse the peephole procedure
   void peep_constraint_parse(Peephole &peep);// Parse the peephole constraints
   void peep_replace_parse(Peephole &peep);   // Parse peephole replacement rule
 