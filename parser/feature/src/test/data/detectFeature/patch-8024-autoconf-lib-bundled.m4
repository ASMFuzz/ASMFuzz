@@ -1,5 +1,5 @@
 #
-# Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
+# Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
 # DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 #
 # This code is free software; you can redistribute it and/or modify it
@@ -166,7 +166,9 @@ AC_DEFUN_ONCE([LIB_SETUP_ZLIB],
 
   DEFAULT_ZLIB=system
   if test "x$OPENJDK_TARGET_OS" = xwindows -o "x$OPENJDK_TARGET_OS" = xaix; then
-    # On windows and aix default is bundled, on others default is system
+    # On windows and aix default is bundled
+    DEFAULT_ZLIB=bundled
+  elif test "x$OPENJDK_TARGET_OS" = xmacosx -a "x$OPENJDK_TARGET_CPU" = xaarch64; then
     DEFAULT_ZLIB=bundled
   fi
 
@@ -217,6 +219,9 @@ AC_DEFUN_ONCE([LIB_SETUP_ZLIB],
   LIBZ_LIBS=""
   if test "x$USE_EXTERNAL_LIBZ" = "xfalse"; then
     LIBZ_CFLAGS="$LIBZ_CFLAGS -I$TOPDIR/src/java.base/share/native/libzip/zlib"
+    if test "x$OPENJDK_TARGET_OS" = xmacosx; then
+        LIBZ_CFLAGS="$LIBZ_CFLAGS -DHAVE_UNISTD_H"
+    fi
   else
     LIBZ_LIBS="-lz"
   fi