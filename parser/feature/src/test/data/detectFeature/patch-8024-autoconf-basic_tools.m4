@@ -161,25 +161,23 @@ AC_DEFUN([BASIC_CHECK_MAKE_VERSION],
 AC_DEFUN([BASIC_CHECK_MAKE_OUTPUT_SYNC],
 [
   # Check if make supports the output sync option and if so, setup using it.
-  AC_MSG_CHECKING([if make --output-sync is supported])
-  if $MAKE --version -O > /dev/null 2>&1; then
-    OUTPUT_SYNC_SUPPORTED=true
-    AC_MSG_RESULT([yes])
-    AC_MSG_CHECKING([for output-sync value])
-    AC_ARG_WITH([output-sync], [AS_HELP_STRING([--with-output-sync],
-      [set make output sync type if supported by make. @<:@recurse@:>@])],
-      [OUTPUT_SYNC=$with_output_sync])
-    if test "x$OUTPUT_SYNC" = "x"; then
-      OUTPUT_SYNC=none
-    fi
-    AC_MSG_RESULT([$OUTPUT_SYNC])
-    if ! $MAKE --version -O$OUTPUT_SYNC > /dev/null 2>&1; then
-      AC_MSG_ERROR([Make did not the support the value $OUTPUT_SYNC as output sync type.])
-    fi
-  else
-    OUTPUT_SYNC_SUPPORTED=false
-    AC_MSG_RESULT([no])
-  fi
+  UTIL_ARG_WITH(NAME: output-sync, TYPE: literal,
+      VALID_VALUES: [none recurse line target], DEFAULT: none,
+      OPTIONAL: true, ENABLED_DEFAULT: true,
+      ENABLED_RESULT: OUTPUT_SYNC_SUPPORTED,
+      CHECKING_MSG: [for make --output-sync value],
+      DESC: [set make --output-sync type if supported by make],
+      CHECK_AVAILABLE:
+      [
+        AC_MSG_CHECKING([if make --output-sync is supported])
+        if ! $MAKE --version -O > /dev/null 2>&1; then
+          AC_MSG_RESULT([no])
+          AVAILABLE=false
+        else
+          AC_MSG_RESULT([yes])
+        fi
+      ]
+  )
   AC_SUBST(OUTPUT_SYNC_SUPPORTED)
   AC_SUBST(OUTPUT_SYNC)
 ])
@@ -271,6 +269,8 @@ AC_DEFUN([BASIC_CHECK_TAR],
     TAR_TYPE="bsd"
   elif test "x$($TAR -v | $GREP "bsdtar")" != "x"; then
     TAR_TYPE="bsd"
+  elif test "x$($TAR --version | $GREP "busybox")" != "x"; then
+    TAR_TYPE="busybox"
   elif test "x$OPENJDK_BUILD_OS" = "xaix"; then
     TAR_TYPE="aix"
   fi
@@ -282,9 +282,12 @@ AC_DEFUN([BASIC_CHECK_TAR],
     TAR_SUPPORTS_TRANSFORM="true"
   elif test "x$TAR_TYPE" = "aix"; then
     # -L InputList of aix tar: name of file listing the files and directories
-    # that need to be   archived or extracted
+    # that need to be archived or extracted
     TAR_INCLUDE_PARAM="L"
     TAR_SUPPORTS_TRANSFORM="false"
+  elif test "x$TAR_TYPE" = "xbusybox"; then
+    TAR_INCLUDE_PARAM="T"
+    TAR_SUPPORTS_TRANSFORM="false"
   else
     TAR_INCLUDE_PARAM="I"
     TAR_SUPPORTS_TRANSFORM="false"
@@ -374,17 +377,15 @@ AC_DEFUN_ONCE([BASIC_SETUP_COMPLEX_TOOLS],
     UTIL_REQUIRE_PROGS(XATTR, xattr)
     UTIL_LOOKUP_PROGS(CODESIGN, codesign)
 
-    if test "x$CODESIGN" != "x"; then
-      # Check for user provided code signing identity.
-      # If no identity was provided, fall back to "openjdk_codesign".
-      AC_ARG_WITH([macosx-codesign-identity], [AS_HELP_STRING([--with-macosx-codesign-identity],
-        [specify the code signing identity])],
-        [MACOSX_CODESIGN_IDENTITY=$with_macosx_codesign_identity],
-        [MACOSX_CODESIGN_IDENTITY=openjdk_codesign]
-      )
-
-      AC_SUBST(MACOSX_CODESIGN_IDENTITY)
+    # Check for user provided code signing identity.
+    UTIL_ARG_WITH(NAME: macosx-codesign-identity, TYPE: string,
+        DEFAULT: openjdk_codesign, CHECK_VALUE: UTIL_CHECK_STRING_NON_EMPTY,
+        DESC: [specify the macosx code signing identity],
+        CHECKING_MSG: [for macosx code signing identity]
+    )
+    AC_SUBST(MACOSX_CODESIGN_IDENTITY)
 
+    if test "x$CODESIGN" != "x"; then
       # Verify that the codesign certificate is present
       AC_MSG_CHECKING([if codesign certificate is present])
       $RM codesign-testfile