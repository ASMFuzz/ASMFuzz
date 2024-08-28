@@ -202,25 +202,25 @@ private void startGeneration() throws DocletException {
         }
         messages.notice("doclet.build_version",
             configuration.getDocletVersion());
-        ClassTree classtree = new ClassTree(configuration, configuration.getOptions().noDeprecated());
+        ClassTree classTree = new ClassTree(configuration);
 
-        generateClassFiles(classtree);
+        generateClassFiles(classTree);
 
         ElementListWriter.generate(configuration);
-        generatePackageFiles(classtree);
+        generatePackageFiles(classTree);
         generateModuleFiles();
 
-        generateOtherFiles(classtree);
+        generateOtherFiles(classTree);
         configuration.tagletManager.printReport();
     }
 
     /**
      * Generate additional documentation that is added to the API documentation.
      *
-     * @param classtree the data structure representing the class tree
+     * @param classTree the data structure representing the class tree
      * @throws DocletException if there is a problem while generating the documentation
      */
-    protected void generateOtherFiles(ClassTree classtree) throws DocletException {
+    protected void generateOtherFiles(ClassTree classTree) throws DocletException {
         BuilderFactory builderFactory = configuration.getBuilderFactory();
         AbstractBuilder constantsSummaryBuilder = builderFactory.getConstantsSummaryBuilder();
         constantsSummaryBuilder.build();
@@ -239,28 +239,28 @@ protected void generateOtherFiles(ClassTree classtree) throws DocletException {
     /**
      * Generate the package documentation.
      *
-     * @param classtree the data structure representing the class tree
+     * @param classTree the data structure representing the class tree
      * @throws DocletException if there is a problem while generating the documentation
      */
-    protected abstract void generatePackageFiles(ClassTree classtree) throws DocletException;
+    protected abstract void generatePackageFiles(ClassTree classTree) throws DocletException;
 
     /**
      * Generate the class documentation.
      *
      * @param arr the set of types to be documented
-     * @param classtree the data structure representing the class tree
+     * @param classTree the data structure representing the class tree
      * @throws DocletException if there is a problem while generating the documentation
      */
-    protected abstract void generateClassFiles(SortedSet<TypeElement> arr, ClassTree classtree)
+    protected abstract void generateClassFiles(SortedSet<TypeElement> arr, ClassTree classTree)
             throws DocletException;
 
     /**
      * Iterate through all classes and construct documentation for them.
      *
-     * @param classtree the data structure representing the class tree
+     * @param classTree the data structure representing the class tree
      * @throws DocletException if there is a problem while generating the documentation
      */
-    protected void generateClassFiles(ClassTree classtree)
+    protected void generateClassFiles(ClassTree classTree)
             throws DocletException {
 
         SortedSet<TypeElement> classes = new TreeSet<>(utils.comparators.makeGeneralPurposeComparator());
@@ -278,6 +278,6 @@ protected void generateClassFiles(ClassTree classtree)
             classes.addAll(utils.getAllClasses(pkg));
         }
 
-        generateClassFiles(classes, classtree);
+        generateClassFiles(classes, classTree);
     }
 }