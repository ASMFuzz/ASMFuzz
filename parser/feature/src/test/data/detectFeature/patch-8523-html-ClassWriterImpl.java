@@ -77,7 +77,7 @@ public class ClassWriterImpl extends SubWriterHolderWriter implements ClassWrite
 
     protected final TypeElement typeElement;
 
-    protected final ClassTree classtree;
+    protected final ClassTree classTree;
 
     /**
      * @param configuration the configuration data for the doclet
@@ -89,7 +89,7 @@ public ClassWriterImpl(HtmlConfiguration configuration, TypeElement typeElement,
         super(configuration, configuration.docPaths.forClass(typeElement));
         this.typeElement = typeElement;
         configuration.currentTypeElement = typeElement;
-        this.classtree = classTree;
+        this.classTree = classTree;
     }
 
     @Override
@@ -285,7 +285,7 @@ public void addSubClassInfo(Content target) {
                     return;    // Don't generate the list, too huge
                 }
             }
-            Set<TypeElement> subclasses = classtree.directSubClasses(typeElement, false);
+            Set<TypeElement> subclasses = classTree.hierarchy(typeElement).subtypes(typeElement);
             if (!subclasses.isEmpty()) {
                 var dl = HtmlTree.DL(HtmlStyle.notes);
                 dl.add(HtmlTree.DT(contents.subclassesLabel));
@@ -298,7 +298,7 @@ public void addSubClassInfo(Content target) {
     @Override
     public void addSubInterfacesInfo(Content target) {
         if (utils.isPlainInterface(typeElement)) {
-            Set<TypeElement> subInterfaces = classtree.allSubClasses(typeElement, false);
+            Set<TypeElement> subInterfaces = classTree.hierarchy(typeElement).allSubtypes(typeElement);
             if (!subInterfaces.isEmpty()) {
                 var dl = HtmlTree.DL(HtmlStyle.notes);
                 dl.add(HtmlTree.DT(contents.subinterfacesLabel));
@@ -318,7 +318,7 @@ public void addInterfaceUsageInfo(Content target) {
                 return;    // Don't generate the list, too huge
             }
         }
-        Set<TypeElement> implcl = classtree.implementingClasses(typeElement);
+        Set<TypeElement> implcl = classTree.implementingClasses(typeElement);
         if (!implcl.isEmpty()) {
             var dl = HtmlTree.DL(HtmlStyle.notes);
             dl.add(HtmlTree.DT(contents.implementingClassesLabel));