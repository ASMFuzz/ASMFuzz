@@ -347,7 +347,7 @@ private void initModules() {
         }
 
         // add entries for modules which may not have exported packages
-        modules.forEach(mdle -> modulePackages.computeIfAbsent(mdle, m -> Collections.emptySet()));
+        modules.forEach(mdle -> modulePackages.computeIfAbsent(mdle, m -> Set.of()));
 
         modules.addAll(modulePackages.keySet());
         showModules = !modules.isEmpty();