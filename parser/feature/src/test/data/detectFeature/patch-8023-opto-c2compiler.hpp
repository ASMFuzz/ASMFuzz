@@ -50,6 +50,7 @@ class C2Compiler : public AbstractCompiler {
   static const char* retry_no_subsuming_loads();
   static const char* retry_no_escape_analysis();
   static const char* retry_no_iterative_escape_analysis();
+  static const char* retry_no_split_phi_bases();
   static const char* retry_no_locks_coarsening();
   static const char* retry_class_loading_during_parsing();
 