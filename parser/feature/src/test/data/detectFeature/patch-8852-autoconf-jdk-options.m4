@@ -23,20 +23,6 @@
 # questions.
 #
 
-###############################################################################
-# Check which variant of the JDK that we want to build.
-# Currently we have:
-#    normal:   standard edition
-# but the custom make system may add other variants
-#
-# Effectively the JDK variant gives a name to a specific set of
-# modules to compile into the JDK.
-AC_DEFUN_ONCE([JDKOPT_SETUP_JDK_VARIANT],
-[
-  # Deprecated in JDK 12
-  UTIL_DEPRECATED_ARG_WITH([jdk-variant])
-])
-
 ###############################################################################
 # Set the debug level
 #    release: no debug information, all optimizations, no asserts.