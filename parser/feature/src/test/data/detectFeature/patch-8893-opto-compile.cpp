@@ -2205,6 +2205,18 @@ void Compile::Optimize() {
       if (major_progress()) print_method(PHASE_PHASEIDEAL_BEFORE_EA, 2);
       if (failing())  return;
     }
+
+    if (ReduceAllocationMerges) {
+      ConnectionGraph::do_analysis(this, &igvn, /*only_analysis=*/true);
+      if (failing())  return;
+      igvn.optimize();
+      if (congraph() != NULL) {
+        print_method(PHASE_BEFORE_REDUCE_ALLOCATION, 2);
+        congraph()->reduce_allocation_merges();
+        print_method(PHASE_AFTER_REDUCE_ALLOCATION, 2);
+      }
+    }
+
     bool progress;
     do {
       ConnectionGraph::do_analysis(this, &igvn);