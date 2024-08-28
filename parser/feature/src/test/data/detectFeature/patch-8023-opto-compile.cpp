@@ -601,6 +601,7 @@ Compile::Compile( ciEnv* ci_env, ciMethod* target, int osr_bci,
                   _for_post_loop_igvn(comp_arena(), 8, 0, NULL),
                   _coarsened_locks   (comp_arena(), 8, 0, NULL),
                   _congraph(NULL),
+                  _unique_base_id(0),
                   NOT_PRODUCT(_igv_printer(NULL) COMMA)
                   _dead_node_list(comp_arena()),
                   _dead_node_count(0),
@@ -879,6 +880,7 @@ Compile::Compile( ciEnv* ci_env,
     _log(ci_env->log()),
     _failure_reason(NULL),
     _congraph(NULL),
+    _unique_base_id(0),
     NOT_PRODUCT(_igv_printer(NULL) COMMA)
     _dead_node_list(comp_arena()),
     _dead_node_count(0),
@@ -2166,13 +2168,29 @@ void Compile::Optimize() {
 
   // Perform escape analysis
   if (do_escape_analysis() && ConnectionGraph::has_candidates(this)) {
+    Unique_Node_List splitted_phi_nodes;
+
     if (has_loops()) {
       // Cleanup graph (remove dead nodes).
       TracePhase tp("idealLoop", &timers[_t_idealLoop]);
       PhaseIdealLoop::optimize(igvn, LoopOptsMaxUnroll);
       if (major_progress()) print_method(PHASE_PHASEIDEAL_BEFORE_EA, 2);
       if (failing())  return;
     }
+
+    if (SplitPhiBases && split_phi_bases()) {
+      ConnectionGraph::do_analysis(this, &igvn, true);
+      if (failing())  return;
+
+      igvn.optimize();
+      if (failing())  return;
+
+      // Only try to split-phis if there are Allocate nodes that NoEscape
+      if (congraph() != NULL) {
+        congraph()->split_bases(splitted_phi_nodes);
+      }
+    }
+
     bool progress;
     do {
       ConnectionGraph::do_analysis(this, &igvn);
@@ -2188,14 +2206,34 @@ void Compile::Optimize() {
       if (failing())  return;
 
       if (congraph() != NULL && macro_count() > 0) {
+        NOT_PRODUCT( congraph()->dump_ir("Before Eliminate MacroNodes."); )
+
         TracePhase tp("macroEliminate", &timers[_t_macroEliminate]);
         PhaseMacroExpand mexp(igvn);
         mexp.eliminate_macro_nodes();
-        igvn.set_delay_transform(false);
 
+        // If we weren't able to remove the Allocate nodes touched by
+        // split_bases it's possible that the graph is in "a bad [dominance]
+        // shape" because of the use of "fake Phis". When this happens we
+        // recompile the method without split_bases enabled.
+        if (congraph()->were_splitted_bases_removed(splitted_phi_nodes) == false) {
+          C->record_failure(C2Compiler::retry_no_split_phi_bases());
+          NOT_PRODUCT(tty->print_cr("Split-phi failed. Deoptimizing."));
+          return;
+        }
+#ifndef PRODUCT
+        else {
+          if (splitted_phi_nodes.size() > 0)
+            tty->print_cr("split phi succeeded! %s:%s", method()->holder()->name()->as_utf8(), method()->name()->as_utf8());
+        }
+#endif
+
+        igvn.set_delay_transform(false);
         igvn.optimize();
         print_method(PHASE_ITER_GVN_AFTER_ELIMINATION, 2);
 
+        NOT_PRODUCT( congraph()->dump_ir("After Eliminate MacroNodes."); )
+
         if (failing())  return;
       }
       progress = do_iterative_escape_analysis() &&