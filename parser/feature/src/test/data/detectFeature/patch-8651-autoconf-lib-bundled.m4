@@ -1,5 +1,5 @@
 #
-# Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
+# Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
 # DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 #
 # This code is free software; you can redistribute it and/or modify it
@@ -217,6 +217,9 @@ AC_DEFUN_ONCE([LIB_SETUP_ZLIB],
   LIBZ_LIBS=""
   if test "x$USE_EXTERNAL_LIBZ" = "xfalse"; then
     LIBZ_CFLAGS="$LIBZ_CFLAGS -I$TOPDIR/src/java.base/share/native/libzip/zlib"
+    if test "x$OPENJDK_TARGET_OS" = xmacosx; then
+        LIBZ_CFLAGS="$LIBZ_CFLAGS -DHAVE_UNISTD_H"
+    fi
   else
     LIBZ_LIBS="-lz"
   fi