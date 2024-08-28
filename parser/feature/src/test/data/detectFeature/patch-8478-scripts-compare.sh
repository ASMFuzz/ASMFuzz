@@ -324,7 +324,7 @@ compare_general_files() {
         ! -name "*.cpl" ! -name "*.pdb" ! -name "*.exp" ! -name "*.ilk" \
         ! -name "*.lib" ! -name "*.jmod" ! -name "*.exe" \
         ! -name "*.obj" ! -name "*.o" ! -name "jspawnhelper" ! -name "*.a" \
-        ! -name "*.tar.gz" ! -name "classes_nocoops.jsa" ! -name "gtestLauncher" \
+        ! -name "*.tar.gz" ! -name "gtestLauncher" \
         ! -name "*.map" \
         | $GREP -v "./bin/"  | $SORT | $FILTER)
 