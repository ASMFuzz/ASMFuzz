@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -542,10 +542,6 @@ public static int getStartPos(JCTree tree) {
                 JCBindingPattern node = (JCBindingPattern)tree;
                 return getStartPos(node.var);
             }
-            case GUARDPATTERN: {
-                JCGuardPattern node = (JCGuardPattern) tree;
-                return getStartPos(node.patt);
-            }
             case ERRONEOUS: {
                 JCErroneous node = (JCErroneous)tree;
                 if (node.errs != null && node.errs.nonEmpty()) {
@@ -644,10 +640,6 @@ public static int getEndPos(JCTree tree, EndPosTable endPosTable) {
                 JCParenthesizedPattern node = (JCParenthesizedPattern) tree;
                 return getEndPos(node.pattern, endPosTable);
             }
-            case GUARDPATTERN: {
-                JCGuardPattern node = (JCGuardPattern) tree;
-                return getEndPos(node.expr, endPosTable);
-            }
             case ERRONEOUS: {
                 JCErroneous node = (JCErroneous)tree;
                 if (node.errs != null && node.errs.nonEmpty())
@@ -1314,42 +1306,40 @@ public static boolean isErrorEnumSwitch(JCExpression selector, List<JCCase> case
                              .allMatch(p -> p.hasTag(IDENT));
     }
 
-    public static PatternPrimaryType primaryPatternType(JCPattern pat) {
+    public static Type primaryPatternType(JCTree pat) {
         return switch (pat.getTag()) {
-            case BINDINGPATTERN -> new PatternPrimaryType(((JCBindingPattern) pat).type, true);
-            case GUARDPATTERN -> {
-                JCGuardPattern guarded = (JCGuardPattern) pat;
-                PatternPrimaryType nested = primaryPatternType(guarded.patt);
-                boolean unconditional = nested.unconditional();
-                if (guarded.expr.type.hasTag(BOOLEAN) && unconditional) {
-                    unconditional = false;
-                    var constValue = guarded.expr.type.constValue();
-                    if (constValue != null && ((int) constValue) == 1) {
-                        unconditional = true;
-                    }
-                }
-                yield new PatternPrimaryType(nested.type(), unconditional);
-            }
+            case BINDINGPATTERN -> pat.type;
             case PARENTHESIZEDPATTERN -> primaryPatternType(((JCParenthesizedPattern) pat).pattern);
             default -> throw new AssertionError();
         };
     }
 
-    public static JCBindingPattern primaryPatternTree(JCPattern pat) {
+    public static JCBindingPattern primaryPatternTree(JCTree pat) {
         return switch (pat.getTag()) {
             case BINDINGPATTERN -> (JCBindingPattern) pat;
-            case GUARDPATTERN -> primaryPatternTree(((JCGuardPattern) pat).patt);
             case PARENTHESIZEDPATTERN -> primaryPatternTree(((JCParenthesizedPattern) pat).pattern);
             default -> throw new AssertionError();
         };
     }
 
-    public record PatternPrimaryType(Type type, boolean unconditional) {}
-
     public static boolean expectedExhaustive(JCSwitch tree) {
         return tree.patternSwitch ||
                tree.cases.stream()
                          .flatMap(c -> c.labels.stream())
                          .anyMatch(l -> TreeInfo.isNull(l));
     }
+
+    public static boolean unguardedCaseLabel(JCCaseLabel cse) {
+        if (!cse.isPattern()) {
+            return true;
+        }
+        JCExpression guard = ((JCPattern) cse).guard;
+        if (guard == null) {
+            return true;
+        }
+        var constValue = guard.type.constValue();
+        return constValue != null &&
+               guard.type.hasTag(BOOLEAN) &&
+               ((int) constValue) == 1;
+    }
 }