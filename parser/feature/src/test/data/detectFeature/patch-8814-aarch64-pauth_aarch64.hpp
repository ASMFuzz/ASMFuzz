@@ -25,6 +25,10 @@
 #ifndef CPU_AARCH64_PAUTH_AARCH64_HPP
 #define CPU_AARCH64_PAUTH_AARCH64_HPP
 
+#include "runtime/vm_version.hpp"
+#include "utilities/globalDefinitions.hpp"
+#include "utilities/macros.hpp"
+
 #include OS_CPU_HEADER_INLINE(pauth)
 
 // Support for ROP Protection in VM code.