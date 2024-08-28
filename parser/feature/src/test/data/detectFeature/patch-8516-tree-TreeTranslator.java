@@ -470,6 +470,13 @@ public void visitAnnotatedType(JCAnnotatedType tree) {
         result = tree;
     }
 
+    @Override
+    public void visitRecordPattern(JCRecordPattern tree) {
+        tree.deconstructor = translate(tree.deconstructor);
+        tree.nested = translate(tree.nested);
+        result = tree;
+    }
+
     public void visitTree(JCTree tree) {
         throw new AssertionError(tree);
     }