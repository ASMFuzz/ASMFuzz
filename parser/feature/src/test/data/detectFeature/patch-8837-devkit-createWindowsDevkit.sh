@@ -107,7 +107,7 @@ POTENTIAL_INI_FILES="Common7/IDE/wdexpress.isolation.ini Common7/IDE/devenv.isol
 for f in $POTENTIAL_INI_FILES; do
     if [ -f "$VS_INSTALL_DIR/$f" ]; then
         VS_VERSION_SP="$(grep ^SemanticVersion= "$VS_INSTALL_DIR/$f")"
-        # Remove SemnaticVersion=
+        # Remove SemanticVersion=
         VS_VERSION_SP="${VS_VERSION_SP#*=}"
         # Remove suffix of too detailed numbering starting with +
         VS_VERSION_SP="${VS_VERSION_SP%+*}"