@@ -267,12 +267,11 @@ void CompilerConfig::set_legacy_emulation_flags() {
         FLAG_SET_ERGO(Tier0BackedgeNotifyFreqLog, MAX2<intx>(10, osr_threshold_log));
       }
       // Adjust the tiered policy flags to approximate the legacy behavior.
-      if (CompilerConfig::is_c1_only()) {
-        FLAG_SET_ERGO(Tier3InvocationThreshold, threshold);
-        FLAG_SET_ERGO(Tier3MinInvocationThreshold, threshold);
-        FLAG_SET_ERGO(Tier3CompileThreshold, threshold);
-        FLAG_SET_ERGO(Tier3BackEdgeThreshold, osr_threshold);
-      } else {
+      FLAG_SET_ERGO(Tier3InvocationThreshold, threshold);
+      FLAG_SET_ERGO(Tier3MinInvocationThreshold, threshold);
+      FLAG_SET_ERGO(Tier3CompileThreshold, threshold);
+      FLAG_SET_ERGO(Tier3BackEdgeThreshold, osr_threshold);
+      if (CompilerConfig::is_c2_or_jvmci_compiler_only()) {
         FLAG_SET_ERGO(Tier4InvocationThreshold, threshold);
         FLAG_SET_ERGO(Tier4MinInvocationThreshold, threshold);
         FLAG_SET_ERGO(Tier4CompileThreshold, threshold);
@@ -338,6 +337,20 @@ void CompilerConfig::set_compilation_policy_flags() {
     if (FLAG_IS_DEFAULT(Tier4BackEdgeThreshold)) {
       FLAG_SET_DEFAULT(Tier4BackEdgeThreshold, 15000);
     }
+
+    if (FLAG_IS_DEFAULT(Tier3InvocationThreshold)) {
+      FLAG_SET_DEFAULT(Tier3InvocationThreshold, Tier4InvocationThreshold);
+    }
+    if (FLAG_IS_DEFAULT(Tier3MinInvocationThreshold)) {
+      FLAG_SET_DEFAULT(Tier3MinInvocationThreshold, Tier4MinInvocationThreshold);
+    }
+    if (FLAG_IS_DEFAULT(Tier3CompileThreshold)) {
+      FLAG_SET_DEFAULT(Tier3CompileThreshold, Tier4CompileThreshold);
+    }
+    if (FLAG_IS_DEFAULT(Tier3BackEdgeThreshold)) {
+      FLAG_SET_DEFAULT(Tier3BackEdgeThreshold, Tier4BackEdgeThreshold);
+    }
+
   }
 
   // Scale tiered compilation thresholds.