@@ -22,12 +22,12 @@
  *
  */
 
-#ifndef SHARE_JFR_LEAKPROFILER_JFRBITMAP_HPP
-#define SHARE_JFR_LEAKPROFILER_JFRBITMAP_HPP
+#ifndef SHARE_JFR_LEAKPROFILER_JFRBITSET_HPP
+#define SHARE_JFR_LEAKPROFILER_JFRBITSET_HPP
 
 #include "memory/allocation.hpp"
 #include "utilities/objectBitSet.inline.hpp"
 
 typedef ObjectBitSet<mtTracing> JFRBitSet;
 
-#endif // SHARE_JFR_LEAKPROFILER_JFRBITMAP_HPP
+#endif // SHARE_JFR_LEAKPROFILER_JFRBITSET_HPP