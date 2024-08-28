@@ -269,6 +269,8 @@ AC_DEFUN([BASIC_CHECK_TAR],
     TAR_TYPE="bsd"
   elif test "x$($TAR -v | $GREP "bsdtar")" != "x"; then
     TAR_TYPE="bsd"
+  elif test "x$($TAR --version | $GREP "busybox")" != "x"; then
+    TAR_TYPE="busybox"
   elif test "x$OPENJDK_BUILD_OS" = "xaix"; then
     TAR_TYPE="aix"
   fi
@@ -280,9 +282,12 @@ AC_DEFUN([BASIC_CHECK_TAR],
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