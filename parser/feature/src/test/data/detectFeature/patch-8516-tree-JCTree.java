@@ -243,6 +243,8 @@ public enum Tag {
         DEFAULTCASELABEL,
         PARENTHESIZEDPATTERN,
 
+        RECORDPATTERN,
+
         /** Indexed array expressions, of type Indexed.
          */
         INDEXED,
@@ -2368,6 +2370,64 @@ public Tag getTag() {
         }
     }
 
+    public static class JCRecordPattern extends JCPattern
+            implements DeconstructionPatternTree {
+        public JCExpression deconstructor;
+        public List<JCPattern> nested;
+        public JCVariableDecl var;
+        public ClassSymbol record;
+        public List<Type> fullComponentTypes;
+
+        protected JCRecordPattern(JCExpression deconstructor, List<JCPattern> nested,
+                                  JCVariableDecl var) {
+            this.deconstructor = deconstructor;
+            this.nested = nested;
+            this.var = var;
+        }
+
+        @DefinedBy(Api.COMPILER_TREE)
+        public Name getBinding() {
+            return null;
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public ExpressionTree getDeconstructor() {
+            return deconstructor;
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public List<? extends JCPattern> getNestedPatterns() {
+            return nested;
+        }
+
+        @Override
+        public void accept(Visitor v) {
+            v.visitRecordPattern(this);
+        }
+
+        @DefinedBy(Api.COMPILER_TREE)
+        public Kind getKind() {
+            return Kind.DECONSTRUCTION_PATTERN;
+        }
+
+        @Override
+        @DefinedBy(Api.COMPILER_TREE)
+        public <R, D> R accept(TreeVisitor<R, D> v, D d) {
+            return v.visitDeconstructionPattern(this, d);
+        }
+
+        @Override
+        public Tag getTag() {
+            return RECORDPATTERN;
+        }
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public VariableTree getVariable() {
+            return var;
+        }
+
+    }
+
     /**
      * An array selection
      */
@@ -3410,6 +3470,7 @@ public abstract static class Visitor {
         public void visitBindingPattern(JCBindingPattern that) { visitTree(that); }
         public void visitDefaultCaseLabel(JCDefaultCaseLabel that) { visitTree(that); }
         public void visitParenthesizedPattern(JCParenthesizedPattern that) { visitTree(that); }
+        public void visitRecordPattern(JCRecordPattern that) { visitTree(that); }
         public void visitIndexed(JCArrayAccess that)         { visitTree(that); }
         public void visitSelect(JCFieldAccess that)          { visitTree(that); }
         public void visitReference(JCMemberReference that)   { visitTree(that); }