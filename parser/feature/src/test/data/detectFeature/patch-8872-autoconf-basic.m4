@@ -116,6 +116,82 @@ AC_DEFUN([BASIC_EVAL_BUILD_DEVKIT_VARIABLE],
   fi
 ])
 
+###############################################################################
+AC_DEFUN([BASIC_SETUP_XCODE_SYSROOT],
+[
+  AC_MSG_CHECKING([for sdk name])
+  AC_ARG_WITH([sdk-name], [AS_HELP_STRING([--with-sdk-name],
+      [use the Xcode platform SDK of the given name. @<:@macosx@:>@])],
+      [SDK_NAME=$with_sdk_name]
+  )
+  if test "x$SDK_NAME" = x; then
+    SDK_NAME=macosx
+  fi
+  AC_MSG_RESULT([$SDK_NAME])
+
+  if test "x$DEVKIT_ROOT" != x; then
+    # We need to use xcodebuild from the devkit, if provided
+    UTIL_LOOKUP_PROGS(XCODEBUILD, xcodebuild, $DEVKIT_TOOLCHAIN_PATH)
+    if test "x$XCODEBUILD" = x; then
+      AC_MSG_ERROR([No xcodebuild tool found in the provided devkit])
+    fi
+    XCODEBUILD_OUTPUT=`"$XCODEBUILD" -version 2>&1`
+    if test $? -ne 0; then
+      AC_MSG_ERROR([The xcodebuild tool in the devkit reports an error: $XCODEBUILD_OUTPUT])
+    fi
+  else
+    UTIL_LOOKUP_PROGS(XCODEBUILD, xcodebuild)
+    if test "x$XCODEBUILD" != x; then
+      XCODEBUILD_OUTPUT=`"$XCODEBUILD" -version 2>&1`
+      if test $? -ne 0; then
+        AC_MSG_WARN([Ignoring the located xcodebuild tool $XCODEBUILD due to an error: $XCODEBUILD_OUTPUT])
+        XCODEBUILD=
+      fi
+    fi
+  fi
+
+  if test "x$SYSROOT" != x; then
+    if ! test -f "$SYSROOT/System/Library/Frameworks/Foundation.framework/Headers/Foundation.h"; then
+      AC_MSG_ERROR([Invalid sysroot, framework headers not found])
+    fi
+    if test "x$with_sdk_name" != x; then
+      AC_MSG_WARN([--with-sdk-name will be ignored since a sysroot or devkit is provided])
+    fi
+    AC_MSG_NOTICE([Setting sysroot from devkit or --with-sysroot])
+  else
+    if test "x$XCODEBUILD" != x; then
+      SYSROOT=`"$XCODEBUILD" -sdk "$SDK_NAME" -version | $GREP '^Path: ' | $SED 's/Path: //'`
+      if test "x$SYSROOT" = x; then
+        AC_MSG_ERROR([No sysroot found for SDK $SDK_NAME from xcodebuild. Check your Xcode installation.])
+      fi
+      if ! test -f "$SYSROOT/System/Library/Frameworks/Foundation.framework/Headers/Foundation.h"; then
+        AC_MSG_ERROR([Unable to find required framework headers, provide a path to an SDK via --with-sysroot or --with-sdk-name and be sure Xcode is installed properly])
+      fi
+      AC_MSG_NOTICE([Setting sysroot from xcodebuild with SDK $SDK_NAME])
+    else
+      UTIL_LOOKUP_PROGS(XCRUN, xcrun)
+      if test "x$XCRUN" != x; then
+        XCRUN_SDK_PATH=`"$XCRUN" --show-sdk-path -sdk "$SDK_NAME"`
+      fi
+
+      if test "x$XCRUN_SDK_PATH" != x && test -f "$XCRUN_SDK_PATH/System/Library/Frameworks/Foundation.framework/Headers/Foundation.h"; then
+        AC_MSG_NOTICE([Setting sysroot from xcrun with SDK $SDK_NAME])
+        SYSROOT="$XCRUN_SDK_PATH"
+      elif test -f /System/Library/Frameworks/Foundation.framework/Headers/Foundation.h; then
+        AC_MSG_WARN([No devkit provided and no xcodebuild found. Proceeding using system headers.])
+        if test "x$with_sdk_name" != x; then
+          AC_MSG_WARN([--with-sdk-name will be ignored since no xcodebuild could be found])
+        fi
+      else
+        AC_MSG_NOTICE([No devkit provided, no xcodebuild tool and no system headers found in the system.])
+        AC_MSG_NOTICE([Check that Xcode is properly installed, or set a devkit with --with-devkit,])
+        AC_MSG_NOTICE([or override SDK selection using --with-sysroot or --with-sdk-name.])
+        AC_MSG_ERROR([Cannot continue])
+      fi
+    fi
+  fi
+])
+
 ###############################################################################
 AC_DEFUN_ONCE([BASIC_SETUP_DEVKIT],
 [
@@ -218,87 +294,20 @@ AC_DEFUN_ONCE([BASIC_SETUP_DEVKIT],
   )
 
   if test "x$OPENJDK_BUILD_OS" = "xmacosx"; then
-    # If a devkit has been supplied, find xcodebuild in the toolchain_path.
-    # If not, detect if Xcode is installed by running xcodebuild -version
-    # if no Xcode installed, xcodebuild exits with 1
-    # if Xcode is installed, even if xcode-select is misconfigured, then it exits with 0
-    if test "x$DEVKIT_ROOT" != x || /usr/bin/xcodebuild -version >/dev/null 2>&1; then
-      # We need to use xcodebuild in the toolchain dir provided by the user
-      UTIL_LOOKUP_PROGS(XCODEBUILD, xcodebuild, $TOOLCHAIN_PATH)
-      if test x$XCODEBUILD = x; then
-        # fall back on the stub binary in /usr/bin/xcodebuild
-        XCODEBUILD=/usr/bin/xcodebuild
-      fi
-    else
-      # this should result in SYSROOT being empty, unless --with-sysroot is provided
-      # when only the command line tools are installed there are no SDKs, so headers
-      # are copied into the system frameworks
-      XCODEBUILD=
-      AC_SUBST(XCODEBUILD)
-    fi
-
-    AC_MSG_CHECKING([for sdk name])
-    AC_ARG_WITH([sdk-name], [AS_HELP_STRING([--with-sdk-name],
-        [use the platform SDK of the given name. @<:@macosx@:>@])],
-        [SDKNAME=$with_sdk_name]
-    )
-    AC_MSG_RESULT([$SDKNAME])
-
-    # if toolchain path is specified then don't rely on system headers, they may not compile
-    HAVE_SYSTEM_FRAMEWORK_HEADERS=0
-    test -z "$TOOLCHAIN_PATH" && \
-      HAVE_SYSTEM_FRAMEWORK_HEADERS=`test ! -f /System/Library/Frameworks/Foundation.framework/Headers/Foundation.h; echo $?`
-
-    if test -z "$SYSROOT"; then
-      if test -n "$XCODEBUILD"; then
-        # if we don't have system headers, use default SDK name (last resort)
-        if test -z "$SDKNAME" -a $HAVE_SYSTEM_FRAMEWORK_HEADERS -eq 0; then
-          SDKNAME=${SDKNAME:-macosx}
-        fi
-
-        if test -n "$SDKNAME"; then
-          # Call xcodebuild to determine SYSROOT
-          SYSROOT=`"$XCODEBUILD" -sdk $SDKNAME -version | $GREP '^Path: ' | $SED 's/Path: //'`
-        fi
-      else
-        if test $HAVE_SYSTEM_FRAMEWORK_HEADERS -eq 0; then
-          AC_MSG_ERROR([No xcodebuild tool and no system framework headers found, use --with-sysroot or --with-sdk-name to provide a path to a valid SDK])
-        fi
-      fi
-    else
-      # warn user if --with-sdk-name was also set
-      if test -n "$with_sdk_name"; then
-        AC_MSG_WARN([Both SYSROOT and --with-sdk-name are set, only SYSROOT will be used])
-      fi
-    fi
-
-    if test $HAVE_SYSTEM_FRAMEWORK_HEADERS -eq 0 -a -z "$SYSROOT"; then
-      # If no system framework headers, then SYSROOT must be set, or we won't build
-      AC_MSG_ERROR([Unable to determine SYSROOT and no headers found in /System/Library/Frameworks. Check Xcode configuration, --with-sysroot or --with-sdk-name arguments.])
-    fi
-
-    # Perform a basic sanity test
-    if test ! -f "$SYSROOT/System/Library/Frameworks/Foundation.framework/Headers/Foundation.h"; then
-      if test -z "$SYSROOT"; then
-        AC_MSG_ERROR([Unable to find required framework headers, provide a path to an SDK via --with-sysroot or --with-sdk-name and be sure Xcode is installed properly])
-      else
-        AC_MSG_ERROR([Invalid SDK or SYSROOT path, dependent framework headers not found])
-      fi
-    fi
-
-    # set SDKROOT too, Xcode tools will pick it up
-    SDKROOT="$SYSROOT"
-    AC_SUBST(SDKROOT)
+    BASIC_SETUP_XCODE_SYSROOT
   fi
 
   # Prepend the extra path to the global path
   UTIL_PREPEND_TO_PATH([PATH],$EXTRA_PATH)
 
   AC_MSG_CHECKING([for sysroot])
   AC_MSG_RESULT([$SYSROOT])
+  AC_SUBST(SYSROOT)
+
   AC_MSG_CHECKING([for toolchain path])
   AC_MSG_RESULT([$TOOLCHAIN_PATH])
   AC_SUBST(TOOLCHAIN_PATH)
+
   AC_MSG_CHECKING([for extra path])
   AC_MSG_RESULT([$EXTRA_PATH])
 ])