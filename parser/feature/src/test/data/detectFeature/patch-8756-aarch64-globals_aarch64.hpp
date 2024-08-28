@@ -105,7 +105,7 @@ define_pd_global(intx, InlineSmallCode,          1000);
           "Use DC ZVA for block zeroing")                               \
   product(intx, BlockZeroingLowLimit, 256,                              \
           "Minimum size in bytes when block zeroing will be used")      \
-          range(1, max_jint)                                            \
+          range(wordSize, max_jint)                                     \
   product(bool, TraceTraps, false, "Trace all traps the signal handler")\
   product(int, SoftwarePrefetchHintDistance, -1,                        \
           "Use prfm hint with specified distance in compiled code."     \