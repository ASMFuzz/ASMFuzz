@@ -500,6 +500,13 @@ public JCParenthesizedPattern ParenthesizedPattern(JCPattern pattern) {
         return tree;
     }
 
+    public JCRecordPattern RecordPattern(JCExpression deconstructor, List<JCPattern> nested,
+                                         JCVariableDecl var) {
+        JCRecordPattern tree = new JCRecordPattern(deconstructor, nested, var);
+        tree.pos = pos;
+        return tree;
+    }
+
     public JCArrayAccess Indexed(JCExpression indexed, JCExpression index) {
         JCArrayAccess tree = new JCArrayAccess(indexed, index);
         tree.pos = pos;