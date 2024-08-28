@@ -25,6 +25,7 @@
 #include "precompiled.hpp"
 #include "code/codeCache.hpp"
 #include "runtime/arguments.hpp"
+#include "runtime/continuation.hpp"
 #include "runtime/flags/jvmFlag.hpp"
 #include "runtime/flags/jvmFlagAccess.hpp"
 #include "runtime/flags/jvmFlagConstraintsCompiler.hpp"
@@ -587,7 +588,13 @@ void CompilerConfig::ergo_initialize() {
 #endif
 
   if (FLAG_IS_DEFAULT(SweeperThreshold)) {
-    if ((SweeperThreshold * ReservedCodeCacheSize / 100) > (1.2 * M)) {
+    if (Continuations::enabled()) {
+      // When continuations are enabled, the sweeper needs to trigger GC to
+      // be able to sweep nmethods. Therefore, it's in general a good idea
+      // to be significantly less aggressive with sweeping, in order not to
+      // trigger excessive GC work.
+      FLAG_SET_ERGO(SweeperThreshold, SweeperThreshold * 10.0);
+    } else if ((SweeperThreshold * ReservedCodeCacheSize / 100) > (1.2 * M)) {
       // Cap default SweeperThreshold value to an equivalent of 1.2 Mb
       FLAG_SET_ERGO(SweeperThreshold, (1.2 * M * 100) / ReservedCodeCacheSize);
     }