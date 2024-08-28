@@ -221,7 +221,7 @@ AC_DEFUN([FLAGS_SETUP_QUALITY_CHECKS],
       ;;
     slowdebug )
       # FIXME: By adding this to C(XX)FLAGS_DEBUG_OPTIONS/JVM_CFLAGS_SYMBOLS it
-      # get's added conditionally on whether we produce debug symbols or not.
+      # gets added conditionally on whether we produce debug symbols or not.
       # This is most likely not really correct.
 
       # Add runtime stack smashing and undefined behavior checks.
@@ -667,7 +667,7 @@ AC_DEFUN([FLAGS_SETUP_CFLAGS_CPU_DEP],
     $1_DEFINES_CPU_JVM="${$1_DEFINES_CPU_JVM} -D_LP64=1"
   fi
 
-  # toolchain dependend, per-cpu
+  # toolchain dependent, per-cpu
   if test "x$TOOLCHAIN_TYPE" = xmicrosoft; then
     if test "x$FLAGS_CPU" = xaarch64; then
       $1_DEFINES_CPU_JDK="${$1_DEFINES_CPU_JDK} -D_ARM64_ -Darm64"