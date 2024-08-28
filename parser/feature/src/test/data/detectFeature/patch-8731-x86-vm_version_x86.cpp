@@ -895,8 +895,9 @@ void VM_Version::get_processor_features() {
     }
   }
   if (FLAG_IS_DEFAULT(UseAVX)) {
-    // Don't use AVX-512 on older Skylakes unless explicitly requested.
-    if (use_avx_limit > 2 && is_intel_skylake() && _stepping < 5) {
+    // Don't use AVX-512 on Skylake (or the related Cascade Lake) CPUs unless explicitly
+    // requested - these instructions can cause performance issues on these processors.
+    if (use_avx_limit > 2 && is_intel_skylake()) {
       FLAG_SET_DEFAULT(UseAVX, 2);
     } else {
       FLAG_SET_DEFAULT(UseAVX, use_avx_limit);