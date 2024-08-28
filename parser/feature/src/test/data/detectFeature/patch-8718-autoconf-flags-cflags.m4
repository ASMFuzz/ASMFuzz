@@ -460,9 +460,11 @@ AC_DEFUN([FLAGS_SETUP_CFLAGS_HELPER],
   elif test "x$TOOLCHAIN_TYPE" = xmicrosoft; then
     # Access APIs for Windows 8 and above
     # see https://docs.microsoft.com/en-us/cpp/porting/modifying-winver-and-win32-winnt?view=msvc-170
-    ALWAYS_DEFINES_JDK="-DWIN32_LEAN_AND_MEAN -D_WIN32_WINNT=0x0602 -D_CRT_SECURE_NO_DEPRECATE \
-        -D_CRT_NONSTDC_NO_DEPRECATE -DWIN32 -DIAL"
-    ALWAYS_DEFINES_JVM="-DNOMINMAX -DWIN32_LEAN_AND_MEAN -D_WIN32_WINNT=0x0602"
+    ALWAYS_DEFINES_JDK="-DWIN32_LEAN_AND_MEAN -D_WIN32_WINNT=0x0602 \
+        -D_CRT_SECURE_NO_WARNINGS -D_CRT_NONSTDC_NO_DEPRECATE -DWIN32 -DIAL"
+    ALWAYS_DEFINES_JVM="-DNOMINMAX -DWIN32_LEAN_AND_MEAN -D_WIN32_WINNT=0x0602 \
+        -D_CRT_SECURE_NO_WARNINGS -D_CRT_NONSTDC_NO_DEPRECATE \
+        -D_WINSOCK_DEPRECATED_NO_WARNINGS"
   fi
 
   ###############################################################################