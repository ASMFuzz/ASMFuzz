@@ -62,7 +62,7 @@ mkdir -p $DEVKIT_ROOT
 
 ################################################################################
 # Copy the relevant parts of Xcode.app, removing things that are both big and
-# unecessary for our purposes, without building an impossibly long exclude list.
+# unnecessary for our purposes, without building an impossibly long exclude list.
 EXCLUDE_DIRS=" \
     Contents/_CodeSignature \
     Contents/Applications \