@@ -355,7 +355,7 @@ AC_DEFUN([TOOLCHAIN_EXTRACT_VISUAL_STUDIO_ENV],
   PATH="$OLDPATH"
 
   if test ! -s $VS_ENV_TMP_DIR/set-vs-env.sh; then
-    AC_MSG_NOTICE([Could not succesfully extract the environment variables needed for the VS setup.])
+    AC_MSG_NOTICE([Could not successfully extract the environment variables needed for the VS setup.])
     AC_MSG_NOTICE([Try setting --with-tools-dir to the VC/bin directory within the VS installation.])
     AC_MSG_NOTICE([To analyze the problem, see extract-vs-env.log and extract-vs-env.bat in])
     AC_MSG_NOTICE([$VS_ENV_TMP_DIR.])