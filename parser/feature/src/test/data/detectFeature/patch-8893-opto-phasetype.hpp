@@ -37,6 +37,8 @@
   flags(EXPAND_VBOX,                  "Expand VectorBox") \
   flags(ELIMINATE_VBOX_ALLOC,         "Eliminate VectorBoxAllocate") \
   flags(PHASEIDEAL_BEFORE_EA,         "PhaseIdealLoop before EA") \
+  flags(BEFORE_REDUCE_ALLOCATION,     "Before reducing allocation merges") \
+  flags(AFTER_REDUCE_ALLOCATION,      "After reducing allocation merges") \
   flags(ITER_GVN_AFTER_VECTOR,        "Iter GVN after vector box elimination") \
   flags(ITER_GVN_BEFORE_EA,           "Iter GVN before EA") \
   flags(ITER_GVN_AFTER_EA,            "Iter GVN after EA") \