@@ -884,7 +884,7 @@ private void discoverAndRunProcs(Set<TypeElement> annotationsPresent,
                                      List<ClassSymbol> topLevelClasses,
                                      List<PackageSymbol> packageInfoFiles,
                                      List<ModuleSymbol> moduleInfoFiles) {
-        Map<String, TypeElement> unmatchedAnnotations = new HashMap<>(annotationsPresent.size());
+        Map<String, TypeElement> unmatchedAnnotations = new HashMap<>((int) Math.ceil(annotationsPresent.size() / 0.75));
 
         for(TypeElement a  : annotationsPresent) {
             ModuleElement mod = elementUtils.getModuleOf(a);