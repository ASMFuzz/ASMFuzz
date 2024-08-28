@@ -91,8 +91,9 @@ define_pd_global(intx, InlineSmallCode,          1000);
   product(bool, AvoidUnalignedAccesses, true,                                    \
           "Avoid generating unaligned memory accesses")                          \
   product(bool, UseRVV, false, EXPERIMENTAL, "Use RVV instructions")             \
-  product(bool, UseRVB, false, EXPERIMENTAL, "Use RVB instructions")             \
   product(bool, UseRVC, false, EXPERIMENTAL, "Use RVC instructions")             \
+  product(bool, UseZba, false, EXPERIMENTAL, "Use Zba instructions")             \
+  product(bool, UseZbb, false, EXPERIMENTAL, "Use Zbb instructions")             \
   product(bool, UseRVVForBigIntegerShiftIntrinsics, true,                        \
           "Use RVV instructions for left/right shift of BigInteger")
 