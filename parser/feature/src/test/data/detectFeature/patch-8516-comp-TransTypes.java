@@ -587,6 +587,14 @@ public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         result = tree;
     }
 
+    public void visitRecordPattern(JCRecordPattern tree) {
+        tree.fullComponentTypes = tree.record.getRecordComponents()
+                                             .map(rc -> types.memberType(tree.type, rc));
+        tree.deconstructor = translate(tree.deconstructor, null);
+        tree.nested = translate(tree.nested, null);
+        result = tree;
+    }
+
     public void visitSynchronized(JCSynchronized tree) {
         tree.lock = translate(tree.lock, erasure(tree.lock.type));
         tree.body = translate(tree.body);