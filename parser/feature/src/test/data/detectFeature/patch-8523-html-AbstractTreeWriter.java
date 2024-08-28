@@ -25,17 +25,19 @@
 
 package jdk.javadoc.internal.doclets.formats.html;
 
-import java.util.*;
-
-import javax.lang.model.element.TypeElement;
-
 import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
-import jdk.javadoc.internal.doclets.formats.html.markup.TagName;
 import jdk.javadoc.internal.doclets.formats.html.markup.HtmlTree;
+import jdk.javadoc.internal.doclets.formats.html.markup.TagName;
 import jdk.javadoc.internal.doclets.toolkit.Content;
 import jdk.javadoc.internal.doclets.toolkit.util.ClassTree;
+import jdk.javadoc.internal.doclets.toolkit.util.ClassTree.Hierarchy;
 import jdk.javadoc.internal.doclets.toolkit.util.DocPath;
 
+import javax.lang.model.element.TypeElement;
+import java.util.Collection;
+import java.util.SortedSet;
+import java.util.TreeSet;
+
 
 /**
  * Abstract class to print the class hierarchy page for all the Classes. This
@@ -48,20 +50,19 @@ public abstract class AbstractTreeWriter extends HtmlDocletWriter {
     /**
      * The class and interface tree built by using {@link ClassTree}
      */
-    protected final ClassTree classtree;
+    protected final ClassTree classTree;
 
     /**
-     * Constructor initializes classtree variable. This constructor will be used
-     * while generating global tree file "overview-tree.html".
+     * Constructor. This constructor will be used while generating global tree file "overview-tree.html".
      *
      * @param configuration  The current configuration
      * @param filename   File to be generated.
-     * @param classtree  Tree built by {@link ClassTree}.
+     * @param classTree  Tree built by {@link ClassTree}.
      */
     protected AbstractTreeWriter(HtmlConfiguration configuration,
-                                 DocPath filename, ClassTree classtree) {
+                                 DocPath filename, ClassTree classTree) {
         super(configuration, filename);
-        this.classtree = classtree;
+        this.classTree = classTree;
     }
 
     /**
@@ -71,56 +72,48 @@ protected AbstractTreeWriter(HtmlConfiguration configuration,
      *
      * @param parent the superclass or superinterface of the sset
      * @param collection  a collection of the sub-classes at this level
-     * @param isEnum true if we are generating a tree for enums
+     * @param hierarchy the hierarchy for which we are generating a tree
      * @param content the content to which the level information will be added
      */
     protected void addLevelInfo(TypeElement parent, Collection<TypeElement> collection,
-            boolean isEnum, Content content) {
+                                Hierarchy hierarchy, Content content) {
         if (!collection.isEmpty()) {
             var ul = new HtmlTree(TagName.UL);
             for (TypeElement local : collection) {
                 var li = new HtmlTree(TagName.LI);
                 li.setStyle(HtmlStyle.circle);
                 addPartialInfo(local, li);
                 addExtendsImplements(parent, local, li);
-                addLevelInfo(local, classtree.directSubClasses(local, isEnum),
-                             isEnum, li);   // Recurse
+                addLevelInfo(local, hierarchy.subtypes(local), hierarchy, li);   // Recurse
                 ul.add(li);
             }
             content.add(ul);
         }
     }
 
     /**
-     * Add the heading for the tree depending upon tree type if it's a
-     * Class Tree or Interface tree.
+     * Adds a class or interface hierarchy with a given heading to given content.
      *
-     * @param sset classes which are at the most base level, all the
-     * other classes in this run will derive from these classes
-     * @param heading heading for the tree
-     * @param content the content to which the tree will be added
+     * @param hierarchy the hierarchy to add
+     * @param heading   the heading
+     * @param content   the content to which to add the hierarchy
      */
-    protected void addTree(SortedSet<TypeElement> sset, String heading, Content content) {
-        addTree(sset, heading, content, false);
-    }
-
-    protected void addTree(SortedSet<TypeElement> sset, String heading,
-                           Content content, boolean isEnums) {
-        if (!sset.isEmpty()) {
-            TypeElement firstTypeElement = sset.first();
+    protected void addTree(Hierarchy hierarchy, String heading, Content content) {
+        SortedSet<TypeElement> roots = hierarchy.roots();
+        if (!roots.isEmpty()) {
+            TypeElement firstTypeElement = roots.first();
             Content headingContent = contents.getContent(heading);
             var sectionHeading = HtmlTree.HEADING_TITLE(Headings.CONTENT_HEADING,
                     headingContent);
             var section = HtmlTree.SECTION(HtmlStyle.hierarchy, sectionHeading);
             addLevelInfo(!utils.isPlainInterface(firstTypeElement) ? firstTypeElement : null,
-                    sset, isEnums, section);
+                    roots, hierarchy, section);
             content.add(section);
         }
     }
 
     /**
-     * Add information regarding the classes which this class extends or
-     * implements.
+     * Add information regarding the classes which this class extends or implements.
      *
      * @param parent the parent class of the class being documented
      * @param typeElement the TypeElement under consideration