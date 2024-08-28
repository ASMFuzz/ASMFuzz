@@ -142,10 +142,4 @@ AC_DEFUN_ONCE([HOTSPOT_SETUP_MISC],
     HOTSPOT_TARGET_CPU=arm_32
     HOTSPOT_TARGET_CPU_DEFINE="ARM32"
   fi
-
-  # --with-cpu-port is no longer supported
-  UTIL_DEPRECATED_ARG_WITH(with-cpu-port)
-
-  # in jdk15 hotspot-gtest was replaced with --with-gtest
-  UTIL_DEPRECATED_ARG_ENABLE(hotspot-gtest)
 ])