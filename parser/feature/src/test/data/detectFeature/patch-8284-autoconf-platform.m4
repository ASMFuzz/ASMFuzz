@@ -126,6 +126,12 @@ AC_DEFUN([PLATFORM_EXTRACT_VARS_FROM_CPU],
       VAR_CPU_BITS=64
       VAR_CPU_ENDIAN=little
       ;;
+    riscv32)
+      VAR_CPU=riscv32
+      VAR_CPU_ARCH=riscv
+      VAR_CPU_BITS=32
+      VAR_CPU_ENDIAN=little
+      ;;
     riscv64)
       VAR_CPU=riscv64
       VAR_CPU_ARCH=riscv
@@ -561,6 +567,8 @@ AC_DEFUN([PLATFORM_SETUP_LEGACY_VARS_HELPER],
     HOTSPOT_$1_CPU_DEFINE=PPC64
   elif test "x$OPENJDK_$1_CPU" = xppc64le; then
     HOTSPOT_$1_CPU_DEFINE=PPC64
+  elif test "x$OPENJDK_$1_CPU" = xriscv32; then
+    HOTSPOT_$1_CPU_DEFINE=RISCV32
   elif test "x$OPENJDK_$1_CPU" = xriscv64; then
     HOTSPOT_$1_CPU_DEFINE=RISCV64
 