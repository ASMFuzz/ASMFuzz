@@ -96,7 +96,7 @@ public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
             cfg.collectRelevantVectors(rv, "AdditionalFile");
             for(String addFile : rv) {
                if (addFile.equals(fileName)) {
-                  // supress any ignore
+                  // suppress any ignore
                   // TODO - may need some adjustments
                   if (file.toAbsolutePath().toString().contains(cfg.get("Flavour"))) {
                      currentFileAttr.removeFromIgnored(cfg);
@@ -154,7 +154,7 @@ public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs)
                newAttr.setIgnore(cfg);
             }
 
-            // Hide is always on all configs. And additional files are never hiddden
+            // Hide is always on all configs. And additional files are never hidden
             if (cfg.matchesHidePath(path.toAbsolutePath().toString())) {
                hide = true;
                break;