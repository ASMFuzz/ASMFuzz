@@ -4033,6 +4033,15 @@ protected JCClassDecl enumDeclaration(JCModifiers mods, Comment dc) {
 
         Name name = typeName();
 
+        int typeNamePos = token.pos;
+        List<JCTypeParameter> typarams = typeParametersOpt(true);
+        if (typarams == null || !typarams.isEmpty()) {
+            int errorPosition = typarams == null
+                    ? typeNamePos
+                    : typarams.head.pos;
+            log.error(DiagnosticFlag.SYNTAX, errorPosition, Errors.EnumCantBeGeneric);
+        }
+
         List<JCExpression> implementing = List.nil();
         if (token.kind == IMPLEMENTS) {
             nextToken();
@@ -4535,9 +4544,21 @@ List<JCExpression> qualidentList(boolean allowAnnos) {
      *  }
      */
     protected List<JCTypeParameter> typeParametersOpt() {
+        return typeParametersOpt(false);
+    }
+    /** Parses a potentially empty type parameter list if needed with `allowEmpty`.
+     *  The caller is free to choose the desirable error message in this (erroneous) case.
+     */
+    protected List<JCTypeParameter> typeParametersOpt(boolean parseEmpty) {
         if (token.kind == LT) {
             ListBuffer<JCTypeParameter> typarams = new ListBuffer<>();
             nextToken();
+
+            if (parseEmpty && token.kind == GT) {
+                accept(GT);
+                return null;
+            }
+
             typarams.append(typeParameter());
             while (token.kind == COMMA) {
                 nextToken();