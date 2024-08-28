@@ -30,6 +30,10 @@
 #define SUPPORTS_NATIVE_CX8
 #endif
 
+#ifndef FFI_GO_CLOSURES
+#define FFI_GO_CLOSURES 0
+#endif
+
 #include <ffi.h>
 
 // Indicates whether the C calling conventions require that