@@ -890,8 +890,8 @@ AC_DEFUN([FLAGS_SETUP_CFLAGS_CPU_DEP],
 # $2 - Prefix for compiler variables (either BUILD_ or nothing).
 AC_DEFUN([FLAGS_SETUP_GCC6_COMPILER_FLAGS],
 [
-  # These flags are required for GCC 6 builds as undefined behaviour in OpenJDK code
-  # runs afoul of the more aggressive versions of these optimisations.
+  # These flags are required for GCC 6 builds as undefined behavior in OpenJDK code
+  # runs afoul of the more aggressive versions of these optimizations.
   # Notably, value range propagation now assumes that the this pointer of C++
   # member functions is non-null.
   NO_DELETE_NULL_POINTER_CHECKS_CFLAG="-fno-delete-null-pointer-checks"