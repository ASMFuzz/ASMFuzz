@@ -1703,7 +1703,8 @@ const intx ObjectAlignmentInBytes = 8;
   /* Properties for Java libraries  */                                      \
                                                                             \
   product(uint64_t, MaxDirectMemorySize, 0,                                 \
-          "Maximum total size of NIO direct-buffer allocations")            \
+          "Maximum total size of NIO direct-buffer allocations. "           \
+          "Ignored if not explicitly set.")                                 \
           range(0, max_jlong)                                               \
                                                                             \
   /* Flags used for temporary code during development  */                   \