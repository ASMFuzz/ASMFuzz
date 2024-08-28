@@ -185,8 +185,8 @@ public class ElementsTable {
     private Set<ModulePackage> excludePackages = new LinkedHashSet<>();
     private Set<ModulePackage> subPackages = new LinkedHashSet<>();
 
-    private List<JCClassDecl> classDecList = Collections.emptyList();
-    private List<String> classArgList = Collections.emptyList();
+    private List<JCClassDecl> classDecList = List.of();
+    private List<String> classArgList = List.of();
     private com.sun.tools.javac.util.List<JCCompilationUnit> classTreeList = null;
 
     private final Set<JavaFileObject.Kind> sourceKinds = EnumSet.of(JavaFileObject.Kind.SOURCE);
@@ -837,7 +837,7 @@ private List<JavaFileObject> getFiles(ModulePackage modpkg,
         ListBuffer<JavaFileObject> lb = new ListBuffer<>();
         List<Location> locs = getLocation(modpkg);
         if (locs.isEmpty()) {
-            return Collections.emptyList();
+            return List.of();
         }
         String pname = modpkg.packageName;
         for (Location packageLocn : locs) {
@@ -865,7 +865,7 @@ private ModuleSymbol findModuleOfPackageName(String packageName) {
 
     private List<Location> getLocation(ModulePackage modpkg) throws ToolException {
         if (locations.size() == 1 && !locations.contains(StandardLocation.MODULE_SOURCE_PATH)) {
-            return Collections.singletonList(locations.get(0));
+            return List.of(locations.get(0));
         }
 
         if (modpkg.hasModule()) {
@@ -874,7 +874,7 @@ private List<Location> getLocation(ModulePackage modpkg) throws ToolException {
         // TODO: handle invalid results better.
         ModuleSymbol msym = findModuleOfPackageName(modpkg.packageName);
         if (msym == null) {
-            return Collections.emptyList();
+            return List.of();
         }
         return getModuleLocation(locations, msym.name.toString());
     }