@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,7 +39,6 @@
 import com.sun.tools.javac.resources.CompilerProperties.Errors;
 import com.sun.tools.javac.resources.CompilerProperties.Warnings;
 import com.sun.tools.javac.tree.*;
-import com.sun.tools.javac.tree.TreeInfo.PatternPrimaryType;
 import com.sun.tools.javac.util.*;
 import com.sun.tools.javac.util.JCDiagnostic.DiagnosticPosition;
 import com.sun.tools.javac.util.JCDiagnostic.Error;
@@ -671,7 +670,9 @@ public void visitSwitch(JCSwitch tree) {
                 JCCase c = l.head;
                 for (JCCaseLabel pat : c.labels) {
                     scan(pat);
-                    handleConstantCaseLabel(constants, pat);
+                    if (TreeInfo.unguardedCaseLabel(pat)) {
+                        handleConstantCaseLabel(constants, pat);
+                    }
                 }
                 scanStats(c.stats);
                 if (alive != Liveness.DEAD && c.caseKind == JCCase.RULE) {
@@ -686,15 +687,15 @@ public void visitSwitch(JCSwitch tree) {
                                 l.tail.head.pos(),
                                 Warnings.PossibleFallThroughIntoCase);
             }
-            tree.isExhaustive = tree.hasTotalPattern ||
+            tree.isExhaustive = tree.hasUnconditionalPattern ||
                                 TreeInfo.isErrorEnumSwitch(tree.selector, tree.cases);
             if (exhaustiveSwitch) {
                 tree.isExhaustive |= isExhaustive(tree.selector.pos(), tree.selector.type, constants);
                 if (!tree.isExhaustive) {
                     log.error(tree, Errors.NotExhaustiveStatement);
                 }
             }
-            if (!tree.hasTotalPattern) {
+            if (!tree.hasUnconditionalPattern) {
                 alive = Liveness.ALIVE;
             }
             alive = alive.or(resolveBreaks(tree, prevPendingExits));
@@ -712,7 +713,9 @@ public void visitSwitchExpression(JCSwitchExpression tree) {
                 JCCase c = l.head;
                 for (JCCaseLabel pat : c.labels) {
                     scan(pat);
-                    handleConstantCaseLabel(constants, pat);
+                    if (TreeInfo.unguardedCaseLabel(pat)) {
+                        handleConstantCaseLabel(constants, pat);
+                    }
                 }
                 scanStats(c.stats);
                 if (alive == Liveness.ALIVE) {
@@ -725,7 +728,7 @@ public void visitSwitchExpression(JCSwitchExpression tree) {
                     }
                 }
             }
-            tree.isExhaustive = tree.hasTotalPattern ||
+            tree.isExhaustive = tree.hasUnconditionalPattern ||
                                 TreeInfo.isErrorEnumSwitch(tree.selector, tree.cases) ||
                                 isExhaustive(tree.selector.pos(), tree.selector.type, constants);
             if (!tree.isExhaustive) {
@@ -742,11 +745,9 @@ private void handleConstantCaseLabel(Set<Symbol> constants, JCCaseLabel pat) {
                     if (expr.hasTag(IDENT) && ((JCIdent) expr).sym.isEnum())
                         constants.add(((JCIdent) expr).sym);
                 } else if (pat.isPattern()) {
-                    PatternPrimaryType patternType = TreeInfo.primaryPatternType((JCPattern) pat);
+                    Type primaryType = TreeInfo.primaryPatternType(pat);
 
-                    if (patternType.unconditional()) {
-                        constants.add(patternType.type().tsym);
-                    }
+                    constants.add(primaryType.tsym);
                 }
             }
         }
@@ -2014,6 +2015,14 @@ void scanExprs(List<? extends JCExpression> trees) {
                     scanExpr(l.head);
         }
 
+        void scanPattern(JCTree tree) {
+            scan(tree);
+            if (inits.isReset()) {
+                inits.assign(initsWhenTrue);
+                uninits.assign(uninitsWhenTrue);
+            }
+        }
+
         /** Analyze a condition. Make sure to set (un)initsWhenTrue(WhenFalse)
          *  rather than (un)inits on exit.
          */
@@ -2454,11 +2463,7 @@ private void handleSwitch(JCTree tree, JCExpression selector,
                 uninits.assign(uninits.andSet(uninitsSwitch));
                 JCCase c = l.head;
                 for (JCCaseLabel pat : c.labels) {
-                    scan(pat);
-                    if (inits.isReset()) {
-                        inits.assign(initsWhenTrue);
-                        uninits.assign(uninitsWhenTrue);
-                    }
+                    scanPattern(pat);
                 }
                 if (l.head.stats.isEmpty() &&
                     l.tail.nonEmpty() &&
@@ -2847,8 +2852,9 @@ public void visitIdent(JCIdent tree) {
 
         @Override
         public void visitBindingPattern(JCBindingPattern tree) {
-            super.visitBindingPattern(tree);
+            scan(tree.var);
             initParam(tree.var);
+            scan(tree.guard);
         }
 
         void referenced(Symbol sym) {
@@ -2940,7 +2946,7 @@ void checkEffectivelyFinal(DiagnosticPosition pos, VarSymbol sym) {
                             }
                             break;
                         }
-                    case GUARDPATTERN:
+                    case BINDINGPATTERN, PARENTHESIZEDPATTERN:
                     case LAMBDA:
                         if ((sym.flags() & (EFFECTIVELY_FINAL | FINAL)) == 0) {
                            reportEffectivelyFinalError(pos, sym);
@@ -2964,7 +2970,7 @@ void letInit(JCTree tree) {
                                 reportInnerClsNeedsFinalError(tree, sym);
                                 break;
                             }
-                        case GUARDPATTERN:
+                        case CASE:
                         case LAMBDA:
                             reportEffectivelyFinalError(tree, sym);
                     }
@@ -2975,7 +2981,7 @@ void letInit(JCTree tree) {
         void reportEffectivelyFinalError(DiagnosticPosition pos, Symbol sym) {
             Fragment subKey = switch (currentTree.getTag()) {
                 case LAMBDA -> Fragments.Lambda;
-                case GUARDPATTERN -> Fragments.Guard;
+                case BINDINGPATTERN, PARENTHESIZEDPATTERN -> Fragments.Guard;
                 case CLASSDEF -> Fragments.InnerCls;
                 default -> throw new AssertionError("Unexpected tree kind: " + currentTree.getTag());
             };
@@ -3015,12 +3021,24 @@ public void visitLambda(JCLambda tree) {
         }
 
         @Override
-        public void visitGuardPattern(JCGuardPattern tree) {
-            scan(tree.patt);
+        public void visitBindingPattern(JCBindingPattern tree) {
+            scan(tree.var);
+            JCTree prevTree = currentTree;
+            try {
+                currentTree = tree;
+                scan(tree.guard);
+            } finally {
+                currentTree = prevTree;
+            }
+        }
+
+        @Override
+        public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
+            scan(tree.pattern);
             JCTree prevTree = currentTree;
             try {
                 currentTree = tree;
-                scan(tree.expr);
+                scan(tree.guard);
             } finally {
                 currentTree = prevTree;
             }