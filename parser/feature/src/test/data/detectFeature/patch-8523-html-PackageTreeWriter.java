@@ -31,7 +31,6 @@
 import jdk.javadoc.internal.doclets.formats.html.markup.BodyContents;
 import jdk.javadoc.internal.doclets.formats.html.markup.ContentBuilder;
 import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
-import jdk.javadoc.internal.doclets.formats.html.markup.TagName;
 import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
 import jdk.javadoc.internal.doclets.formats.html.Navigation.PageMode;
 import jdk.javadoc.internal.doclets.toolkit.Content;
@@ -103,10 +102,11 @@ protected void generatePackageTreeFile() throws DocFileIOException {
             addLinkToAllPackages(div);
         }
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
         bodyContents.addMainContent(mainContent);
         bodyContents.setFooter(getFooter());
         body.add(bodyContents);