@@ -231,34 +231,8 @@ AC_DEFUN_ONCE([TOOLCHAIN_DETERMINE_TOOLCHAIN_TYPE],
   toolchain_var_name=VALID_TOOLCHAINS_$OPENJDK_BUILD_OS
   VALID_TOOLCHAINS=${!toolchain_var_name}
 
-  if test "x$OPENJDK_TARGET_OS" = xmacosx; then
-    if test -n "$XCODEBUILD"; then
-      # On Mac OS X, default toolchain to clang after Xcode 5
-      XCODE_VERSION_OUTPUT=`"$XCODEBUILD" -version | $HEAD -n 1`
-      $ECHO "$XCODE_VERSION_OUTPUT" | $GREP "Xcode " > /dev/null
-      if test $? -ne 0; then
-        AC_MSG_NOTICE([xcodebuild output: $XCODE_VERSION_OUTPUT])
-        AC_MSG_ERROR([Failed to determine Xcode version.])
-      fi
-      XCODE_MAJOR_VERSION=`$ECHO $XCODE_VERSION_OUTPUT | \
-          $SED -e 's/^Xcode \(@<:@1-9@:>@@<:@0-9.@:>@*\)/\1/' | \
-          $CUT -f 1 -d .`
-      AC_MSG_NOTICE([Xcode major version: $XCODE_MAJOR_VERSION])
-      if test $XCODE_MAJOR_VERSION -ge 5; then
-          DEFAULT_TOOLCHAIN="clang"
-      else
-          DEFAULT_TOOLCHAIN="gcc"
-      fi
-    else
-      # If Xcode is not installed, but the command line tools are
-      # then we can't run xcodebuild. On these systems we should
-      # default to clang
-      DEFAULT_TOOLCHAIN="clang"
-    fi
-  else
-    # First toolchain type in the list is the default
-    DEFAULT_TOOLCHAIN=${VALID_TOOLCHAINS%% *}
-  fi
+  # First toolchain type in the list is the default
+  DEFAULT_TOOLCHAIN=${VALID_TOOLCHAINS%% *}
 
   if test "x$with_toolchain_type" = xlist; then
     # List all toolchains
@@ -341,10 +315,19 @@ AC_DEFUN_ONCE([TOOLCHAIN_PRE_DETECTION],
   # autoconf magic only relies on PATH, so update it if tools dir is specified
   OLD_PATH="$PATH"
 
-  if test "x$XCODE_VERSION_OUTPUT" != x; then
-    # For Xcode, we set the Xcode version as TOOLCHAIN_VERSION
-    TOOLCHAIN_VERSION=`$ECHO $XCODE_VERSION_OUTPUT | $CUT -f 2 -d ' '`
-    TOOLCHAIN_DESCRIPTION="$TOOLCHAIN_DESCRIPTION from Xcode $TOOLCHAIN_VERSION"
+  if test "x$OPENJDK_BUILD_OS" = "xmacosx"; then
+    if test "x$XCODEBUILD" != x; then
+      XCODE_VERSION_OUTPUT=`"$XCODEBUILD" -version 2> /dev/null | $HEAD -n 1`
+      $ECHO "$XCODE_VERSION_OUTPUT" | $GREP "^Xcode " > /dev/null
+      if test $? -ne 0; then
+        AC_MSG_NOTICE([xcodebuild -version output: $XCODE_VERSION_OUTPUT])
+        AC_MSG_ERROR([Failed to determine Xcode version])
+      fi
+
+      # For Xcode, we set the Xcode version as TOOLCHAIN_VERSION
+      TOOLCHAIN_VERSION=`$ECHO $XCODE_VERSION_OUTPUT | $CUT -f 2 -d ' '`
+      TOOLCHAIN_DESCRIPTION="$TOOLCHAIN_DESCRIPTION from Xcode $TOOLCHAIN_VERSION"
+    fi
   fi
   AC_SUBST(TOOLCHAIN_VERSION)
 