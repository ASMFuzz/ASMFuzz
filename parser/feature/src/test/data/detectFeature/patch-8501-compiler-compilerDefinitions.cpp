@@ -27,6 +27,7 @@
 #include "runtime/arguments.hpp"
 #include "runtime/flags/jvmFlag.hpp"
 #include "runtime/flags/jvmFlagAccess.hpp"
+#include "runtime/flags/jvmFlagConstraintsCompiler.hpp"
 #include "runtime/flags/jvmFlagLimit.hpp"
 #include "runtime/globals.hpp"
 #include "runtime/globals_extension.hpp"
@@ -286,7 +287,10 @@ void CompilerConfig::set_legacy_emulation_flags() {
   // Scale CompileThreshold
   // CompileThresholdScaling == 0.0 is equivalent to -Xint and leaves CompileThreshold unchanged.
   if (!FLAG_IS_DEFAULT(CompileThresholdScaling) && CompileThresholdScaling > 0.0 && CompileThreshold > 0) {
-    FLAG_SET_ERGO(CompileThreshold, scaled_compile_threshold(CompileThreshold));
+    intx scaled_value = scaled_compile_threshold(CompileThreshold);
+    if (CompileThresholdConstraintFunc(scaled_value, true) != JVMFlag::VIOLATES_CONSTRAINT) {
+      FLAG_SET_ERGO(CompileThreshold, scaled_value);
+    }
   }
 }
 