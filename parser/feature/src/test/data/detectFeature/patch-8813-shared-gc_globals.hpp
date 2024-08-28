@@ -538,9 +538,6 @@
           "dictionary, classloader_data_graph, metaspace, jni_handles, "    \
           "codecache_oops, resolved_method_table, stringdedup")             \
                                                                             \
-  product(bool, GCParallelVerificationEnabled, true, DIAGNOSTIC,            \
-          "Enable parallel memory system verification")                     \
-                                                                            \
   product(bool, DeferInitialCardMark, false, DIAGNOSTIC,                    \
           "When +ReduceInitialCardMarks, explicitly defer any that "        \
           "may arise from new_pre_store_barrier")                           \