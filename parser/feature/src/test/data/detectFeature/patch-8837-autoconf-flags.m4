@@ -295,7 +295,7 @@ AC_DEFUN_ONCE([FLAGS_PRE_TOOLCHAIN],
   # FIXME: Don't really know how to do with this, but this was the old behavior
   GLOBAL_CPPFLAGS="$SYSROOT_CFLAGS"
 
-  # FIXME: For compatilibity, export this as EXTRA_CFLAGS for now.
+  # FIXME: For compatibility, export this as EXTRA_CFLAGS for now.
   EXTRA_CFLAGS="$MACHINE_FLAG $USER_CFLAGS"
   EXTRA_CXXFLAGS="$MACHINE_FLAG $USER_CXXFLAGS"
   EXTRA_LDFLAGS="$MACHINE_FLAG $USER_LDFLAGS"