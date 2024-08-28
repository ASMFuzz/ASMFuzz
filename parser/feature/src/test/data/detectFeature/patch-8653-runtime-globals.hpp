@@ -973,9 +973,6 @@ const intx ObjectAlignmentInBytes = 8;
   product(bool, UsePopCountInstruction, false,                              \
           "Use population count instruction")                               \
                                                                             \
-  develop(bool, EagerInitialization, false,                                 \
-          "Eagerly initialize classes if possible")                         \
-                                                                            \
   product(bool, LogTouchedMethods, false, DIAGNOSTIC,                       \
           "Log methods which have been ever touched in runtime")            \
                                                                             \