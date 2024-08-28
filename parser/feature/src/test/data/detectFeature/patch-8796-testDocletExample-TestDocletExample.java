@@ -25,6 +25,7 @@
  * @test
  * @bug 8272944
  * @summary Use snippets in jdk.javadoc documentation
+ * @key needs-src needs-src-jdk_javadoc
  * @library /tools/lib ../../lib
  * @modules jdk.compiler/com.sun.tools.javac.api
  *          jdk.compiler/com.sun.tools.javac.main
@@ -53,18 +54,22 @@ public static void main(String... args) throws Exception {
         t.runTests(m -> new Object[] { Path.of(m.getName()) });
     }
 
-    SnippetUtils snippets = new SnippetUtils("jdk.javadoc");
+    SnippetUtils snippets;
     ToolBox tb = new ToolBox();
 
-    TestDocletExample() {
+    TestDocletExample() throws SnippetUtils.ConfigurationException {
         super(System.out);
+        snippets = new SnippetUtils("jdk.javadoc");
     }
 
     @Test
     public void testEntryPoint(Path base) throws Exception {
         var docletPkg = snippets.getElements().getPackageElement("jdk.javadoc.doclet");
         var dc = snippets.getDocTrees().getDocCommentTree(docletPkg);
         var entryPointSnippet = snippets.getSnippetById(dc, "entry-point");
+        if (entryPointSnippet == null) {
+            throw new Error("Cannot find snippet \"entry-point\"");
+        }
         var entryPointCode = entryPointSnippet.getBody().getBody();
         var code = """
                 class C {
@@ -89,6 +94,9 @@ public void testDocletExample(Path base) throws Exception {
         var docletPkg = snippets.getElements().getPackageElement("jdk.javadoc.doclet");
         var dc = snippets.getDocTrees().getDocCommentTree(docletPkg);
         var exampleSnippet = snippets.getSnippetById(dc, "Example.java");
+        if (exampleSnippet == null) {
+            throw new Error("Cannot find snippet \"Example.java\"");
+        }
         var exampleCode = exampleSnippet.getBody().getBody();
 
         // compile it