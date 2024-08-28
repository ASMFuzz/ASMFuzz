@@ -630,7 +630,8 @@
           range(1, max_intx)                                                \
                                                                             \
   product(intx, AliasLevel,     3,                                          \
-          "0 for no aliasing, 1 for oop/field/static/array split, "         \
+          "(Deprecated) 0 for no aliasing, "                                \
+          "1 for oop/field/static/array split, "                            \
           "2 for class split, 3 for unique instances")                      \
           range(0, 3)                                                       \
           constraint(AliasLevelConstraintFunc,AfterErgo)                    \