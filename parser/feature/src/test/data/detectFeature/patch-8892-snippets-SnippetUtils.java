@@ -35,6 +35,7 @@
 import java.util.Set;
 import java.util.function.BiConsumer;
 import java.util.function.Consumer;
+import java.util.function.Supplier;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 
@@ -43,6 +44,7 @@
 import javax.lang.model.element.Modifier;
 import javax.lang.model.element.ModuleElement;
 import javax.lang.model.element.PackageElement;
+import javax.lang.model.element.QualifiedNameable;
 import javax.lang.model.element.TypeElement;
 import javax.lang.model.element.VariableElement;
 import javax.lang.model.util.Elements;
@@ -97,6 +99,24 @@ public ConfigurationException(String message) {
         }
     }
 
+    /**
+     * Exception used to report that a snippet could not be found.
+     */
+    public static class SnippetNotFoundException extends Exception {
+        public SnippetNotFoundException(String message) {
+            super(message);
+        }
+    }
+
+    /**
+     * Exception used to report that a doc comment could not be found.
+     */
+    public static class DocCommentNotFoundException extends Exception {
+        public DocCommentNotFoundException(String message) {
+            super(message);
+        }
+    }
+
     private static final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
 
     private final StandardJavaFileManager fileManager;
@@ -218,20 +238,34 @@ public DocCommentTree getDocCommentTree(Element element) {
      *
      * @param tree the doc comment tree
      * @param id   the id
+     *
+     * @throws SnippetNotFoundException if the snippet cannot be found
      */
-    public SnippetTree getSnippetById(DocCommentTree tree, String id) {
-        return new SnippetFinder().scan(tree, id);
+    public SnippetTree getSnippetById(DocCommentTree tree, String id) throws SnippetNotFoundException {
+        SnippetTree result = new SnippetFinder().scan(tree, id);
+        if (result == null) {
+            throw new SnippetNotFoundException(id);
+        }
+        return result;
     }
 
     /**
      * {@return the snippet with a given id in the doc comment tree for an element}
      *
      * @param element the element
      * @param id      the id
+     *
+     * @throws DocCommentNotFoundException if the doc comment for the element cannot be found
+     * @throws SnippetNotFoundException if the snippet cannot be found
      */
-    public SnippetTree getSnippetById(Element element, String id) {
-        DocCommentTree tree = getDocCommentTree(element);
-        return new SnippetFinder().scan(tree, id);
+    public SnippetTree getSnippetById(Element element, String id)
+            throws DocCommentNotFoundException, SnippetNotFoundException {
+        DocCommentTree docCommentTree = getDocCommentTree(element);
+        if (docCommentTree == null) {
+            var name = (element instanceof QualifiedNameable q) ? q.getQualifiedName() : element.getSimpleName();
+            throw new DocCommentNotFoundException(element.getKind() + " " + name);
+        }
+        return getSnippetById(docCommentTree, id);
     }
 
     /**