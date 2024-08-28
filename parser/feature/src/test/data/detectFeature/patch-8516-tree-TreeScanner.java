@@ -318,6 +318,16 @@ public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         scan(tree.guard);
     }
 
+    @Override
+    public void visitRecordPattern(JCRecordPattern that) {
+        scan(that.deconstructor);
+        scan(that.nested);
+        if (that.var != null) {
+            scan(that.var);
+        }
+        scan(that.guard);
+    }
+
     public void visitIndexed(JCArrayAccess tree) {
         scan(tree.indexed);
         scan(tree.index);