@@ -37,6 +37,7 @@
 #include "runtime/sharedRuntime.hpp"
 #include "runtime/stubRoutines.hpp"
 #include "utilities/align.hpp"
+#include "utilities/macros.hpp"
 #include "utilities/powerOfTwo.hpp"
 
 void C1_MacroAssembler::inline_cache_check(Register receiver, Register iCache) {