@@ -22,8 +22,7 @@
  *
  */
 
-// Must be at least Windows Vista or Server 2008 to use InitOnceExecuteOnce
-#define _WIN32_WINNT 0x0600
+// API level must be at least Windows Vista or Server 2008 to use InitOnceExecuteOnce
 
 // no precompiled headers
 #include "jvm.h"