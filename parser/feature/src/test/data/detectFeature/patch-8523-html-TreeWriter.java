@@ -66,10 +66,10 @@ public class TreeWriter extends AbstractTreeWriter {
      *
      * @param configuration the current configuration of the doclet.
      * @param filename String filename
-     * @param classtree the tree being built.
+     * @param classTree the tree being built.
      */
-    public TreeWriter(HtmlConfiguration configuration, DocPath filename, ClassTree classtree) {
-        super(configuration, filename, classtree);
+    public TreeWriter(HtmlConfiguration configuration, DocPath filename, ClassTree classTree) {
+        super(configuration, filename, classTree);
         packages = configuration.packages;
         classesOnly = packages.isEmpty();
         this.bodyContents = new BodyContents();
@@ -80,13 +80,13 @@ public TreeWriter(HtmlConfiguration configuration, DocPath filename, ClassTree c
      * "overview-tree.html" file.
      *
      * @param configuration the configuration for this doclet
-     * @param classtree the class tree being documented.
+     * @param classTree the class tree being documented.
      * @throws  DocFileIOException if there is a problem generating the overview tree page
      */
     public static void generate(HtmlConfiguration configuration,
-                                ClassTree classtree) throws DocFileIOException {
+                                ClassTree classTree) throws DocFileIOException {
         DocPath filename = DocPaths.OVERVIEW_TREE;
-        TreeWriter treegen = new TreeWriter(configuration, filename, classtree);
+        TreeWriter treegen = new TreeWriter(configuration, filename, classTree);
         treegen.generateTreeFile();
     }
 
@@ -104,10 +104,11 @@ public void generateTreeFile() throws DocFileIOException {
         addPackageTreeLinks(div);
         Content mainContent = new ContentBuilder();
         mainContent.add(div);
-        addTree(classtree.baseClasses(), "doclet.Class_Hierarchy", mainContent);
-        addTree(classtree.baseInterfaces(), "doclet.Interface_Hierarchy", mainContent);
-        addTree(classtree.baseAnnotationTypes(), "doclet.Annotation_Type_Hierarchy", mainContent);
-        addTree(classtree.baseEnums(), "doclet.Enum_Hierarchy", mainContent, true);
+        addTree(classTree.classes(), "doclet.Class_Hierarchy", mainContent);
+        addTree(classTree.interfaces(), "doclet.Interface_Hierarchy", mainContent);
+        addTree(classTree.annotationInterfaces(), "doclet.Annotation_Type_Hierarchy", mainContent);
+        addTree(classTree.enumClasses(), "doclet.Enum_Hierarchy", mainContent);
+        addTree(classTree.recordClasses(), "doclet.Record_Class_Hierarchy", mainContent);
         body.add(bodyContents
                 .addMainContent(mainContent)
                 .setFooter(getFooter()));