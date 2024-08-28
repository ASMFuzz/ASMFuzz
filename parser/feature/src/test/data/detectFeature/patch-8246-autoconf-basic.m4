@@ -172,7 +172,7 @@ AC_DEFUN_ONCE([BASIC_SETUP_DEVKIT],
     UTIL_PREPEND_TO_PATH([TOOLCHAIN_PATH],$DEVKIT_TOOLCHAIN_PATH)
 
     # If DEVKIT_SYSROOT is set, use that, otherwise try a couple of known
-    # places for backwards compatiblity.
+    # places for backwards compatibility.
     if test "x$DEVKIT_SYSROOT" != x; then
       SYSROOT="$DEVKIT_SYSROOT"
     elif test -d "$DEVKIT_ROOT/$host_alias/libc"; then
@@ -193,7 +193,7 @@ AC_DEFUN_ONCE([BASIC_SETUP_DEVKIT],
   # You can force the sysroot if the sysroot encoded into the compiler tools
   # is not correct.
   AC_ARG_WITH(sys-root, [AS_HELP_STRING([--with-sys-root],
-      [alias for --with-sysroot for backwards compatability])],
+      [alias for --with-sysroot for backwards compatibility])],
       [SYSROOT=$with_sys_root]
   )
 
@@ -496,7 +496,7 @@ AC_DEFUN_ONCE([BASIC_SETUP_DEFAULT_MAKE_TARGET],
 AC_DEFUN_ONCE([BASIC_SETUP_DEFAULT_LOG],
 [
   AC_ARG_WITH(log, [AS_HELP_STRING([--with-log],
-      [[default vaue for make LOG argument [warn]]])])
+      [[default value for make LOG argument [warn]]])])
   AC_MSG_CHECKING([for default LOG value])
   if test "x$with_log" = x; then
     DEFAULT_LOG=""