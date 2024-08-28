@@ -34,10 +34,11 @@
 #ifdef _WIN32
   // Windows uses Structured Exception Handling
   #include "safefetch_windows.hpp"
-#elif defined(ZERO) || defined (_AIX)
+#elif defined(ZERO) || defined (_AIX) || defined (ARM32)
   // These platforms implement safefetch via Posix sigsetjmp/longjmp.
   // This is slower than the other methods and uses more thread stack,
   // but its safe and portable.
+  // (arm32 uses sigsetjmp/longjmp as long as JDK-8284997 is not solved)
   #include "safefetch_sigjmp.hpp"
   #define SAFEFETCH_METHOD_SIGSETJMP
 #else