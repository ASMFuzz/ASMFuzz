@@ -698,10 +698,10 @@ AC_DEFUN_ONCE([TOOLCHAIN_DETECT_TOOLCHAIN_CORE],
     AS="$CC -c"
   else
     if test "x$OPENJDK_TARGET_CPU_BITS" = "x64"; then
-      # On 64 bit windows, the assember is "ml64.exe"
+      # On 64 bit windows, the assembler is "ml64.exe"
       UTIL_LOOKUP_TOOLCHAIN_PROGS(AS, ml64)
     else
-      # otherwise, the assember is "ml.exe"
+      # otherwise, the assembler is "ml.exe"
       UTIL_LOOKUP_TOOLCHAIN_PROGS(AS, ml)
     fi
   fi
@@ -881,13 +881,13 @@ AC_DEFUN_ONCE([TOOLCHAIN_SETUP_BUILD_COMPILERS],
       UTIL_REQUIRE_PROGS(BUILD_CC, cl, [$VS_PATH])
       UTIL_REQUIRE_PROGS(BUILD_CXX, cl, [$VS_PATH])
 
-      # On windows, the assember is "ml.exe". We currently don't need this so
+      # On windows, the assembler is "ml.exe". We currently don't need this so
       # do not require.
       if test "x$OPENJDK_BUILD_CPU_BITS" = "x64"; then
-        # On 64 bit windows, the assember is "ml64.exe"
+        # On 64 bit windows, the assembler is "ml64.exe"
         UTIL_LOOKUP_PROGS(BUILD_AS, ml64, [$VS_PATH])
       else
-        # otherwise the assember is "ml.exe"
+        # otherwise the assembler is "ml.exe"
         UTIL_LOOKUP_PROGS(BUILD_AS, ml, [$VS_PATH])
       fi
 