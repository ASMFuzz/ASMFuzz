@@ -217,6 +217,12 @@
           "do not start profiling in the interpreter")                      \
           range(0, max_jint)                                                \
                                                                             \
+  product(intx, TieredOldPercentage, 1000, DIAGNOSTIC,                      \
+          "Percentage over tier 3 thresholds after which a method is "      \
+          "considered old (turns off parts of prioritization based on "     \
+          "compile queue length)")                                          \
+          range(0, max_jint)                                                \
+                                                                            \
   product(intx, Tier3DelayOn, 5,                                            \
           "If C2 queue size grows over this amount per compiler thread "    \
           "stop compiling at tier 3 and start compiling at tier 2")         \
@@ -248,8 +254,7 @@
                                                                             \
   product(intx, Tier0ProfilingStartPercentage, 200,                         \
           "Start profiling in interpreter if the counters exceed the "      \
-          "specified percentage of tier 3 thresholds (tier 4 thresholds "   \
-          "with CompilationMode=high-only|high-only-quick-internal)")       \
+          "specified percentage of tier 3 thresholds")                      \
           range(0, max_jint)                                                \
                                                                             \
   product(uintx, IncreaseFirstTierCompileThresholdAt, 50,                   \