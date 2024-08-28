@@ -51,6 +51,9 @@ const char* C2Compiler::retry_no_locks_coarsening() {
 const char* C2Compiler::retry_no_iterative_escape_analysis() {
   return "retry without iterative escape analysis";
 }
+const char* C2Compiler::retry_no_split_phi_bases() {
+  return "retry without split phi bases";
+}
 const char* C2Compiler::retry_class_loading_during_parsing() {
   return "retry class loading during parsing";
 }
@@ -103,12 +106,13 @@ void C2Compiler::compile_method(ciEnv* env, ciMethod* target, int entry_bci, boo
   bool subsume_loads = SubsumeLoads;
   bool do_escape_analysis = DoEscapeAnalysis;
   bool do_iterative_escape_analysis = DoEscapeAnalysis;
+  bool split_phi_bases = SplitPhiBases;
   bool eliminate_boxing = EliminateAutoBox;
   bool do_locks_coarsening = EliminateLocks;
 
   while (!env->failing()) {
     // Attempt to compile while subsuming loads into machine instructions.
-    Options options(subsume_loads, do_escape_analysis, do_iterative_escape_analysis, eliminate_boxing, do_locks_coarsening, install_code);
+    Options options(subsume_loads, do_escape_analysis, do_iterative_escape_analysis, split_phi_bases, eliminate_boxing, do_locks_coarsening, install_code);
     Compile C(env, target, entry_bci, options, directive);
 
     // Check result and retry if appropriate.
@@ -135,6 +139,12 @@ void C2Compiler::compile_method(ciEnv* env, ciMethod* target, int entry_bci, boo
         env->report_failure(C.failure_reason());
         continue;  // retry
       }
+      if (C.failure_reason_is(retry_no_split_phi_bases())) {
+        assert(split_phi_bases, "must make progress");
+        split_phi_bases = false;
+        env->report_failure(C.failure_reason());
+        continue;  // retry
+      }
       if (C.failure_reason_is(retry_no_locks_coarsening())) {
         assert(do_locks_coarsening, "must make progress");
         do_locks_coarsening = false;