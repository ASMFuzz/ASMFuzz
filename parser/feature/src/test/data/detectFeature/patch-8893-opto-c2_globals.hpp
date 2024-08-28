@@ -471,6 +471,9 @@
   develop(bool, TracePostallocExpand, false, "Trace expanding nodes after"  \
           " register allocation.")                                          \
                                                                             \
+  product(bool, ReduceAllocationMerges, false,                              \
+          "Try to simplify allocation merges before Scalar Replacement")    \
+                                                                            \
   product(bool, DoEscapeAnalysis, true,                                     \
           "Perform escape analysis")                                        \
                                                                             \