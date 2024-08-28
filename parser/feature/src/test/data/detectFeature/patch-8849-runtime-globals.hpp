@@ -1291,10 +1291,11 @@ const intx ObjectAlignmentInBytes = 8;
   develop(bool, DebugDeoptimization, false,                                 \
           "Tracing various information while debugging deoptimization")     \
                                                                             \
-  product(intx, SelfDestructTimer, 0,                                       \
-          "Will cause VM to terminate after a given time (in minutes) "     \
-          "(0 means off)")                                                  \
-          range(0, max_intx)                                                \
+  product(double, SelfDestructTimer, 0.0,                                   \
+          "Will cause VM to terminate after a given time "                  \
+          "(in fractional minutes) "                                        \
+          "(0.0 means off)")                                                \
+          range(0.0, (double)max_intx)                                      \
                                                                             \
   product(intx, MaxJavaStackTraceDepth, 1024,                               \
           "The maximum number of lines in the stack trace for Java "        \