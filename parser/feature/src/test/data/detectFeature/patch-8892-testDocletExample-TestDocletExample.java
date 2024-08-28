@@ -67,9 +67,6 @@ public void testEntryPoint(Path base) throws Exception {
         var docletPkg = snippets.getElements().getPackageElement("jdk.javadoc.doclet");
         var dc = snippets.getDocTrees().getDocCommentTree(docletPkg);
         var entryPointSnippet = snippets.getSnippetById(dc, "entry-point");
-        if (entryPointSnippet == null) {
-            throw new Error("Cannot find snippet \"entry-point\"");
-        }
         var entryPointCode = entryPointSnippet.getBody().getBody();
         var code = """
                 class C {
@@ -94,9 +91,6 @@ public void testDocletExample(Path base) throws Exception {
         var docletPkg = snippets.getElements().getPackageElement("jdk.javadoc.doclet");
         var dc = snippets.getDocTrees().getDocCommentTree(docletPkg);
         var exampleSnippet = snippets.getSnippetById(dc, "Example.java");
-        if (exampleSnippet == null) {
-            throw new Error("Cannot find snippet \"Example.java\"");
-        }
         var exampleCode = exampleSnippet.getBody().getBody();
 
         // compile it