@@ -203,9 +203,9 @@ public void generateClassFiles(ClassTree classTree) throws DocletException {
      * @throws DocletException if there is a problem while writing the other files
      */
     @Override // defined by AbstractDoclet
-    protected void generateOtherFiles(ClassTree classtree)
+    protected void generateOtherFiles(ClassTree classTree)
             throws DocletException {
-        super.generateOtherFiles(classtree);
+        super.generateOtherFiles(classTree);
         HtmlOptions options = configuration.getOptions();
         if (options.linkSource()) {
             SourceToHTMLConverter.convertRoot(configuration, DocPaths.SOURCE_OUTPUT);
@@ -228,11 +228,11 @@ protected void generateOtherFiles(ClassTree classtree)
         }
         // do early to reduce memory footprint
         if (options.classUse()) {
-            ClassUseWriter.generate(configuration, classtree);
+            ClassUseWriter.generate(configuration, classTree);
         }
 
         if (options.createTree()) {
-            TreeWriter.generate(configuration, classtree);
+            TreeWriter.generate(configuration, classTree);
         }
 
         if (configuration.conditionalPages.contains((HtmlConfiguration.ConditionalPage.DEPRECATED))) {
@@ -392,7 +392,7 @@ protected void generateModuleFiles() throws DocletException {
     }
 
     @Override // defined by AbstractDoclet
-    protected void generatePackageFiles(ClassTree classtree) throws DocletException {
+    protected void generatePackageFiles(ClassTree classTree) throws DocletException {
         HtmlOptions options = configuration.getOptions();
         Set<PackageElement> packages = configuration.packages;
         List<PackageElement> pList = new ArrayList<>(packages);