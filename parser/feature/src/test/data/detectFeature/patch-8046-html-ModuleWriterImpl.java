@@ -26,7 +26,6 @@
 package jdk.javadoc.internal.doclets.formats.html;
 
 import java.util.ArrayList;
-import java.util.Collections;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
@@ -264,11 +263,11 @@ public void computeModulesData() {
         });
 
         // Get all packages if module is open or if displaying concealed modules
-        for (PackageElement pkg : utils.getModulePackageMap().getOrDefault(mdle, Collections.emptySet())) {
+        for (PackageElement pkg : utils.getModulePackageMap().getOrDefault(mdle, Set.of())) {
             if (shouldDocument(pkg) && (mdle.isOpen() || moduleMode == ModuleMode.ALL)) {
                 PackageEntry e = new PackageEntry();
                 if (mdle.isOpen()) {
-                    e.openedTo = Collections.emptySet();
+                    e.openedTo = Set.of();
                 }
                 packages.put(pkg, e);
             }
@@ -329,7 +328,7 @@ public void computeModulesData() {
             }
             SortedSet<PackageElement> openPackages = new TreeSet<>(utils.comparators.makePackageComparator());
             if (module.isOpen()) {
-                openPackages.addAll(utils.getModulePackageMap().getOrDefault(module, Collections.emptySet()));
+                openPackages.addAll(utils.getModulePackageMap().getOrDefault(module, Set.of()));
             } else {
                 ElementFilter.opensIn(module.getDirectives()).forEach(directive -> {
                     PackageElement pkg = directive.getPackage();