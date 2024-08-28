@@ -166,7 +166,9 @@ AC_DEFUN_ONCE([LIB_SETUP_ZLIB],
 
   DEFAULT_ZLIB=system
   if test "x$OPENJDK_TARGET_OS" = xwindows -o "x$OPENJDK_TARGET_OS" = xaix; then
-    # On windows and aix default is bundled, on others default is system
+    # On windows and aix default is bundled
+    DEFAULT_ZLIB=bundled
+  elif test "x$OPENJDK_TARGET_OS" = xmacosx -a "x$OPENJDK_TARGET_CPU" = xaarch64; then
     DEFAULT_ZLIB=bundled
   fi
 