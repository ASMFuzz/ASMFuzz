@@ -144,7 +144,8 @@ AC_DEFUN_ONCE([LIB_SETUP_LIBRARIES],
          test "x$OPENJDK_TARGET_CPU" = xmips ||
          test "x$OPENJDK_TARGET_CPU" = xmipsel ||
          test "x$OPENJDK_TARGET_CPU" = xppc ||
-         test "x$OPENJDK_TARGET_CPU" = xsh); then
+         test "x$OPENJDK_TARGET_CPU" = xsh ||
+         test "x$OPENJDK_TARGET_CPU" = xriscv32); then
       BASIC_JVM_LIBS="$BASIC_JVM_LIBS -latomic"
     fi
   fi