@@ -101,7 +101,8 @@ static const char* env_list[] = {
   // Env variables that are defined on Linux/BSD
   "LD_LIBRARY_PATH", "LD_PRELOAD", "SHELL", "DISPLAY",
   "HOSTTYPE", "OSTYPE", "ARCH", "MACHTYPE",
-  "LANG", "LC_ALL", "LC_CTYPE", "TZ",
+  "LANG", "LC_ALL", "LC_CTYPE", "LC_NUMERIC", "LC_TIME",
+  "TERM", "TMPDIR", "TZ",
 
   // defined on AIX
   "LIBPATH", "LDR_PRELOAD", "LDR_PRELOAD64",