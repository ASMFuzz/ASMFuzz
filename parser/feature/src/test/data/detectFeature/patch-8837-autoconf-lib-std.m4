@@ -31,7 +31,7 @@
 ################################################################################
 AC_DEFUN_ONCE([LIB_SETUP_STD_LIBS],
 [
-  # statically link libstdc++ before C++ ABI is stablized on Linux unless
+  # statically link libstdc++ before C++ ABI is stabilized on Linux unless
   # dynamic build is configured on command line.
   AC_ARG_WITH([stdc++lib], [AS_HELP_STRING([--with-stdc++lib=<static>,<dynamic>,<default>],
       [force linking of the C++ runtime on Linux to either static or dynamic, default is static with dynamic as fallback])],