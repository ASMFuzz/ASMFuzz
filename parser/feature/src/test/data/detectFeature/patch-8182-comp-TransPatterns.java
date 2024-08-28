@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -85,7 +85,6 @@
 import com.sun.tools.javac.tree.JCTree.JCContinue;
 import com.sun.tools.javac.tree.JCTree.JCDoWhileLoop;
 import com.sun.tools.javac.tree.JCTree.JCFieldAccess;
-import com.sun.tools.javac.tree.JCTree.JCGuardPattern;
 import com.sun.tools.javac.tree.JCTree.JCLambda;
 import com.sun.tools.javac.tree.JCTree.JCParenthesizedPattern;
 import com.sun.tools.javac.tree.JCTree.JCPattern;
@@ -255,27 +254,22 @@ public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         result = translate(tree.pattern);
     }
 
-    @Override
-    public void visitGuardPattern(JCGuardPattern tree) {
-        JCExpression pattern = (JCExpression) this.<JCTree>translate(tree.patt);
-        JCExpression guard = translate(tree.expr);
-        result = makeBinary(Tag.AND, pattern, guard);
-    }
-
     @Override
     public void visitSwitch(JCSwitch tree) {
-        handleSwitch(tree, tree.selector, tree.cases, tree.hasTotalPattern, tree.patternSwitch);
+        handleSwitch(tree, tree.selector, tree.cases,
+                     tree.hasUnconditionalPattern, tree.patternSwitch);
     }
 
     @Override
     public void visitSwitchExpression(JCSwitchExpression tree) {
-        handleSwitch(tree, tree.selector, tree.cases, tree.hasTotalPattern, tree.patternSwitch);
+        handleSwitch(tree, tree.selector, tree.cases,
+                     tree.hasUnconditionalPattern, tree.patternSwitch);
     }
 
     private void handleSwitch(JCTree tree,
                               JCExpression selector,
                               List<JCCase> cases,
-                              boolean hasTotalPattern,
+                              boolean hasUnconditionalPattern,
                               boolean patternSwitch) {
         if (patternSwitch) {
             Type seltype = selector.type.hasTag(BOT)
@@ -340,12 +334,6 @@ private void handleSwitch(JCTree tree,
 
             JCCase lastCase = cases.last();
 
-            if (hasTotalPattern && !hasNullCase) {
-                if (cases.stream().flatMap(c -> c.labels.stream()).noneMatch(l -> l.hasTag(Tag.DEFAULTCASELABEL))) {
-                    lastCase.labels = lastCase.labels.prepend(makeLit(syms.botType, null));
-                    hasNullCase = true;
-                }
-            }
             selector = translate(selector);
             boolean needsNullCheck = !hasNullCase && !seltype.isPrimitive();
             statements.append(make.at(tree.pos).VarDef(temp, needsNullCheck ? attr.makeNullCheck(selector)
@@ -415,6 +403,9 @@ private void handleSwitch(JCTree tree,
                     try {
                         currentValue = temp;
                         JCExpression test = (JCExpression) this.<JCTree>translate(p);
+                        if (((JCPattern) p).guard != null) {
+                            test = makeBinary(Tag.AND, test, translate(((JCPattern) p).guard));
+                        }
                         c.stats = translate(c.stats);
                         JCContinue continueSwitch = make.at(clearedPatterns.head.pos()).Continue(null);
                         continueSwitch.target = tree;
@@ -437,10 +428,11 @@ private void handleSwitch(JCTree tree,
                     if (p.hasTag(Tag.DEFAULTCASELABEL)) {
                         translatedLabels.add(p);
                         hasDefault = true;
-                    } else if (hasTotalPattern && !hasDefault &&
+                    } else if (hasUnconditionalPattern && !hasDefault &&
                                c == lastCase && p.isPattern()) {
-                        //If the switch has total pattern, the last case will contain it.
-                        //Convert the total pattern to default:
+                        //If the switch has unconditional pattern,
+                        //the last case will contain it.
+                        //Convert the unconditional pattern to default:
                         translatedLabels.add(make.DefaultCaseLabel());
                     } else {
                         int value;
@@ -466,11 +458,13 @@ private void handleSwitch(JCTree tree,
             if (tree.hasTag(Tag.SWITCH)) {
                 ((JCSwitch) tree).selector = selector;
                 ((JCSwitch) tree).cases = cases;
+                ((JCSwitch) tree).wasEnumSelector = enumSelector;
                 statements.append((JCSwitch) tree);
                 result = make.Block(0, statements.toList());
             } else {
                 ((JCSwitchExpression) tree).selector = selector;
                 ((JCSwitchExpression) tree).cases = cases;
+                ((JCSwitchExpression) tree).wasEnumSelector = enumSelector;
                 LetExpr r = (LetExpr) make.LetExpr(statements.toList(), (JCSwitchExpression) tree)
                                           .setType(tree.type);
 
@@ -486,13 +480,13 @@ private void handleSwitch(JCTree tree,
         }
     }
 
-    private Type principalType(JCPattern p) {
-        return types.boxedTypeOrType(types.erasure(TreeInfo.primaryPatternType(p).type()));
+    private Type principalType(JCTree p) {
+        return types.boxedTypeOrType(types.erasure(TreeInfo.primaryPatternType(p)));
     }
 
     private LoadableConstant toLoadableConstant(JCCaseLabel l, Type selector) {
         if (l.isPattern()) {
-            Type principalType = principalType((JCPattern) l);
+            Type principalType = principalType(l);
             if (types.isSubtype(selector, principalType)) {
                 return (LoadableConstant) selector;
             } else {