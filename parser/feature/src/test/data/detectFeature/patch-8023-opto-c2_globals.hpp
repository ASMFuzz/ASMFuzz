@@ -471,6 +471,9 @@
   develop(bool, TracePostallocExpand, false, "Trace expanding nodes after"  \
           " register allocation.")                                          \
                                                                             \
+  product(bool, SplitPhiBases, false,                                       \
+          "Split object bases through Phis")                                \
+                                                                            \
   product(bool, DoEscapeAnalysis, true,                                     \
           "Perform escape analysis")                                        \
                                                                             \
@@ -484,6 +487,10 @@
   notproduct(bool, PrintEscapeAnalysis, false,                              \
           "Print the results of escape analysis")                           \
                                                                             \
+                                                                            \
+  product(ccstr, SaveEATraceToFile, NULL,                                   \
+          "Save EA & SR trace to file. Filter using Class::method or all.") \
+                                                                            \
   product(bool, EliminateAllocations, true,                                 \
           "Use escape analysis to eliminate allocations")                   \
                                                                             \