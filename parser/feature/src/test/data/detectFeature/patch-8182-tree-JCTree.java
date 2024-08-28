@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -241,7 +241,6 @@ public enum Tag {
          */
         BINDINGPATTERN,
         DEFAULTCASELABEL,
-        GUARDPATTERN,
         PARENTHESIZEDPATTERN,
 
         /** Indexed array expressions, of type Indexed.
@@ -1284,9 +1283,10 @@ public static class JCSwitch extends JCStatement implements SwitchTree {
         public List<JCCase> cases;
         /** Position of closing brace, optional. */
         public int endpos = Position.NOPOS;
-        public boolean hasTotalPattern;
+        public boolean hasUnconditionalPattern;
         public boolean isExhaustive;
         public boolean patternSwitch;
+        public boolean wasEnumSelector;
         protected JCSwitch(JCExpression selector, List<JCCase> cases) {
             this.selector = selector;
             this.cases = cases;
@@ -1371,9 +1371,10 @@ public static class JCSwitchExpression extends JCPolyExpression implements Switc
         public List<JCCase> cases;
         /** Position of closing brace, optional. */
         public int endpos = Position.NOPOS;
-        public boolean hasTotalPattern;
+        public boolean hasUnconditionalPattern;
         public boolean isExhaustive;
         public boolean patternSwitch;
+        public boolean wasEnumSelector;
         protected JCSwitchExpression(JCExpression selector, List<JCCase> cases) {
             this.selector = selector;
             this.cases = cases;
@@ -2243,6 +2244,11 @@ public Tag getTag() {
     public abstract static class JCPattern extends JCCaseLabel
             implements PatternTree {
 
+        public JCExpression guard;
+
+        @Override @DefinedBy(Api.COMPILER_TREE)
+        public JCExpression getGuard() { return guard; }
+
         @Override
         public boolean isExpression() {
             return false;
@@ -2362,48 +2368,6 @@ public Tag getTag() {
         }
     }
 
-    public static class JCGuardPattern extends JCPattern
-            implements GuardedPatternTree {
-        public JCPattern patt;
-        public JCExpression expr;
-
-        public JCGuardPattern(JCPattern patt, JCExpression expr) {
-            this.patt = patt;
-            this.expr = expr;
-        }
-
-        @Override @DefinedBy(Api.COMPILER_TREE)
-        public PatternTree getPattern() {
-            return patt;
-        }
-
-        @Override @DefinedBy(Api.COMPILER_TREE)
-        public ExpressionTree getExpression() {
-            return expr;
-        }
-
-        @Override
-        public void accept(Visitor v) {
-            v.visitGuardPattern(this);
-        }
-
-        @DefinedBy(Api.COMPILER_TREE)
-        public Kind getKind() {
-            return Kind.GUARDED_PATTERN;
-        }
-
-        @Override
-        @DefinedBy(Api.COMPILER_TREE)
-        public <R, D> R accept(TreeVisitor<R, D> v, D d) {
-            return v.visitGuardedPattern(this, d);
-        }
-
-        @Override
-        public Tag getTag() {
-            return Tag.GUARDPATTERN;
-        }
-    }
-
     /**
      * An array selection
      */
@@ -3446,7 +3410,6 @@ public abstract static class Visitor {
         public void visitBindingPattern(JCBindingPattern that) { visitTree(that); }
         public void visitDefaultCaseLabel(JCDefaultCaseLabel that) { visitTree(that); }
         public void visitParenthesizedPattern(JCParenthesizedPattern that) { visitTree(that); }
-        public void visitGuardPattern(JCGuardPattern that) { visitTree(that); }
         public void visitIndexed(JCArrayAccess that)         { visitTree(that); }
         public void visitSelect(JCFieldAccess that)          { visitTree(that); }
         public void visitReference(JCMemberReference that)   { visitTree(that); }