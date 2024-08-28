@@ -2028,6 +2028,9 @@ const intx ObjectAlignmentInBytes = 8;
                                                                             \
   develop(bool, TraceOptimizedUpcallStubs, false,                              \
                 "Trace optimized upcall stub generation")                      \
+                                                                            \
+  product(bool, CrashProtectAsyncGetCallTrace, true,                        \
+                "Catch segmentation fault in AsyncGetCallTrace silently ")  \
 
 // end of RUNTIME_FLAGS
 