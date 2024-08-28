@@ -317,7 +317,7 @@ AC_DEFUN([TOOLCHAIN_FIND_VISUAL_STUDIO],
       eval MSVCP_NAME="\${VS_MSVCP_${VS_VERSION}}"
       eval USE_UCRT="\${VS_USE_UCRT_${VS_VERSION}}"
       eval VS_SUPPORTED="\${VS_SUPPORTED_${VS_VERSION}}"
-      # The rest of the variables are already evaled while probing
+      # The rest of the variables are already evaluated while probing
       AC_MSG_NOTICE([Found $VS_DESCRIPTION])
       break
     fi