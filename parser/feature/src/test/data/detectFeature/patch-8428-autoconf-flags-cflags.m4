@@ -457,9 +457,11 @@ AC_DEFUN([FLAGS_SETUP_CFLAGS_HELPER],
     ALWAYS_DEFINES_JVM="-D_REENTRANT"
     ALWAYS_DEFINES_JDK="-D_GNU_SOURCE -D_REENTRANT -D_LARGEFILE64_SOURCE -DSTDC"
   elif test "x$TOOLCHAIN_TYPE" = xmicrosoft; then
-    ALWAYS_DEFINES_JDK="-DWIN32_LEAN_AND_MEAN -D_CRT_SECURE_NO_DEPRECATE \
+    # Access APIs for Windows 8 and above
+    # see https://docs.microsoft.com/en-us/cpp/porting/modifying-winver-and-win32-winnt?view=msvc-170
+    ALWAYS_DEFINES_JDK="-DWIN32_LEAN_AND_MEAN -D_WIN32_WINNT=0x0602 -D_CRT_SECURE_NO_DEPRECATE \
         -D_CRT_NONSTDC_NO_DEPRECATE -DWIN32 -DIAL"
-    ALWAYS_DEFINES_JVM="-DNOMINMAX -DWIN32_LEAN_AND_MEAN"
+    ALWAYS_DEFINES_JVM="-DNOMINMAX -DWIN32_LEAN_AND_MEAN -D_WIN32_WINNT=0x0602"
   fi
 
   ###############################################################################