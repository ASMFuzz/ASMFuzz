@@ -516,6 +516,15 @@ public JCTree visitDefaultCaseLabel(DefaultCaseLabelTree node, P p) {
         return M.at(t.pos).DefaultCaseLabel();
     }
 
+    @DefinedBy(Api.COMPILER_TREE)
+    public JCTree visitDeconstructionPattern(DeconstructionPatternTree node, P p) {
+        JCRecordPattern t = (JCRecordPattern) node;
+        JCExpression deconstructor = copy(t.deconstructor, p);
+        List<JCPattern> nested = copy(t.nested, p);
+        JCVariableDecl var = copy(t.var, p);
+        return M.at(t.pos).RecordPattern(deconstructor, nested, var);
+    }
+
     @DefinedBy(Api.COMPILER_TREE)
     public JCTree visitUnary(UnaryTree node, P p) {
         JCUnary t = (JCUnary) node;