@@ -95,8 +95,24 @@ AC_DEFUN([FLAGS_SETUP_DEBUG_SYMBOLS],
   # info flags for toolchains unless we know they work.
   # See JDK-8207057.
   ASFLAGS_DEBUG_SYMBOLS=""
+
+  # Debug prefix mapping if supported by compiler
+  DEBUG_PREFIX_CFLAGS=
+
   # Debug symbols
   if test "x$TOOLCHAIN_TYPE" = xgcc; then
+    if test "x$ALLOW_ABSOLUTE_PATHS_IN_OUTPUT" = "xfalse"; then
+      # Check if compiler supports -fdebug-prefix-map. If so, use that to make
+      # the debug symbol paths resolve to paths relative to the workspace root.
+      workspace_root_trailing_slash="${WORKSPACE_ROOT%/}/"
+      DEBUG_PREFIX_CFLAGS="-fdebug-prefix-map=${workspace_root_trailing_slash}="
+      FLAGS_COMPILER_CHECK_ARGUMENTS(ARGUMENT: [${DEBUG_PREFIX_CFLAGS}],
+        IF_FALSE: [
+            DEBUG_PREFIX_CFLAGS=
+        ]
+      )
+    fi
+
     CFLAGS_DEBUG_SYMBOLS="-g"
     ASFLAGS_DEBUG_SYMBOLS="-g"
   elif test "x$TOOLCHAIN_TYPE" = xclang; then
@@ -108,6 +124,11 @@ AC_DEFUN([FLAGS_SETUP_DEBUG_SYMBOLS],
     CFLAGS_DEBUG_SYMBOLS="-Z7"
   fi
 
+  if test "x$DEBUG_PREFIX_CFLAGS" != x; then
+    CFLAGS_DEBUG_SYMBOLS="$CFLAGS_DEBUG_SYMBOLS $DEBUG_PREFIX_CFLAGS"
+    ASFLAGS_DEBUG_SYMBOLS="$ASFLAGS_DEBUG_SYMBOLS $DEBUG_PREFIX_CFLAGS"
+  fi
+
   AC_SUBST(CFLAGS_DEBUG_SYMBOLS)
   AC_SUBST(ASFLAGS_DEBUG_SYMBOLS)
 ])