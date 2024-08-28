@@ -47,7 +47,7 @@ AC_DEFUN([LIB_SETUP_HSDIS_CAPSTONE],
     fi
   else
     if test "x$OPENJDK_TARGET_OS" = xwindows; then
-      # There is no way to auto-detect capstone on Windowos
+      # There is no way to auto-detect capstone on Windows
       AC_MSG_NOTICE([You must specify capstone location using --with-capstone=<path>])
       AC_MSG_ERROR([Cannot continue])
     fi