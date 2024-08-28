@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -763,12 +763,12 @@ public JCExpression parseExpression() {
     /** parses patterns.
      */
 
-    public JCPattern parsePattern(int pos, JCModifiers mods, JCExpression parsedType, boolean inInstanceOf) {
+    public JCPattern parsePattern(int pos, JCModifiers mods, JCExpression parsedType) {
         JCPattern pattern;
         if (token.kind == LPAREN && parsedType == null) {
             int startPos = token.pos;
             accept(LPAREN);
-            JCPattern p = parsePattern(token.pos, null, null, false);
+            JCPattern p = parsePattern(token.pos, null, null);
             accept(RPAREN);
             pattern = toP(F.at(startPos).ParenthesizedPattern(p));
         } else {
@@ -777,12 +777,6 @@ public JCPattern parsePattern(int pos, JCModifiers mods, JCExpression parsedType
             JCVariableDecl var = toP(F.at(token.pos).VarDef(mods, ident(), e, null));
             pattern = toP(F.at(pos).BindingPattern(var));
         }
-        if (!inInstanceOf && token.kind == AMPAMP) {
-            checkSourceLevel(Feature.PATTERN_SWITCH);
-            nextToken();
-            JCExpression guard = term(EXPR | NOLAMBDA);
-            pattern = F.at(pos).GuardPattern(pattern, guard);
-        }
         return pattern;
     }
 
@@ -967,15 +961,15 @@ JCExpression term2Rest(JCExpression t, int minprec) {
                 JCTree pattern;
                 if (token.kind == LPAREN) {
                     checkSourceLevel(token.pos, Feature.PATTERN_SWITCH);
-                    pattern = parsePattern(token.pos, null, null, true);
+                    pattern = parsePattern(token.pos, null, null);
                 } else {
                     int patternPos = token.pos;
                     JCModifiers mods = optFinal(0);
                     int typePos = token.pos;
                     JCExpression type = unannotatedType(false);
                     if (token.kind == IDENTIFIER) {
                         checkSourceLevel(token.pos, Feature.PATTERN_MATCHING_IN_INSTANCEOF);
-                        pattern = parsePattern(patternPos, mods, type, true);
+                        pattern = parsePattern(patternPos, mods, type);
                     } else {
                         checkNoMods(typePos, mods.flags & ~Flags.DEPRECATED);
                         if (mods.annotations.nonEmpty()) {
@@ -3076,7 +3070,12 @@ private JCCaseLabel parseCaseLabel() {
                               analyzePattern(lookahead) == PatternResult.PATTERN;
             if (pattern) {
                 checkSourceLevel(token.pos, Feature.PATTERN_SWITCH);
-                return parsePattern(patternPos, mods, null, false);
+                JCPattern p = parsePattern(patternPos, mods, null);
+                if (token.kind == IDENTIFIER && token.name() == names.when) {
+                    nextToken();
+                    p.guard = term(EXPR | NOLAMBDA);
+                }
+                return p;
             } else {
                 return term(EXPR | NOLAMBDA);
             }