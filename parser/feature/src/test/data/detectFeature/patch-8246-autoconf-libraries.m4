@@ -149,7 +149,7 @@ AC_DEFUN_ONCE([LIB_SETUP_LIBRARIES],
     fi
   fi
 
-  # Because RISC-V only has word-sized atomics, it requries libatomic where
+  # Because RISC-V only has word-sized atomics, it requires libatomic where
   # other common architectures do not.  So link libatomic by default.
   if test "x$OPENJDK_TARGET_OS" = xlinux && test "x$OPENJDK_TARGET_CPU" = xriscv64; then
     BASIC_JVM_LIBS="$BASIC_JVM_LIBS -latomic"