@@ -36,6 +36,7 @@
 #include "runtime/os.hpp"
 #include "runtime/sharedRuntime.hpp"
 #include "runtime/stubRoutines.hpp"
+#include "utilities/macros.hpp"
 
 void C1_MacroAssembler::inline_cache_check(Register receiver, Register iCache) {
   Label ic_miss, ic_hit;