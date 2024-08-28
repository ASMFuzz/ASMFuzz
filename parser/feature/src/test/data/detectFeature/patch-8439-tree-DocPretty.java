@@ -504,6 +504,20 @@ public Void visitSnippet(SnippetTree node, Void p) {
         return null;
     }
 
+    @Override @DefinedBy(Api.COMPILER_TREE)
+    public Void visitSpec(SpecTree node, Void p) {
+        try {
+            printTagName(node);
+            print(" ");
+            print(node.getURL());
+            print(" ");
+            print(node.getTitle());
+        } catch (IOException e) {
+            throw new UncheckedIOException(e);
+        }
+        return null;
+    }
+
     @Override @DefinedBy(Api.COMPILER_TREE)
     public Void visitStartElement(StartElementTree node, Void p) {
         try {