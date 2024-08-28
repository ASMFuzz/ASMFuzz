@@ -759,27 +759,67 @@ public JCExpression parseExpression() {
         return term(EXPR);
     }
 
-
     /** parses patterns.
      */
 
-    public JCPattern parsePattern(int pos, JCModifiers mods, JCExpression parsedType) {
+    public JCPattern parsePattern(int pos, JCModifiers mods, JCExpression parsedType,
+                                  boolean allowVar, boolean checkGuard) {
         JCPattern pattern;
         if (token.kind == LPAREN && parsedType == null) {
+            //parenthesized pattern:
             int startPos = token.pos;
             accept(LPAREN);
-            JCPattern p = parsePattern(token.pos, null, null);
+            JCPattern p = parsePattern(token.pos, null, null, true, false);
             accept(RPAREN);
             pattern = toP(F.at(startPos).ParenthesizedPattern(p));
         } else {
             mods = mods != null ? mods : optFinal(0);
-            JCExpression e = parsedType == null ? term(TYPE | NOLAMBDA) : parsedType;
-            JCVariableDecl var = toP(F.at(token.pos).VarDef(mods, ident(), e, null));
-            pattern = toP(F.at(pos).BindingPattern(var));
+            JCExpression e;
+            if (parsedType == null) {
+                boolean var = token.kind == IDENTIFIER && token.name() == names.var;
+                e = unannotatedType(allowVar, TYPE | NOLAMBDA);
+                if (var) {
+                    e = null;
+                }
+            } else {
+                e = parsedType;
+            }
+            if (token.kind == LPAREN) {
+                //deconstruction pattern:
+                checkSourceLevel(Feature.RECORD_PATTERNS);
+                ListBuffer<JCPattern> nested = new ListBuffer<>();
+                if (!peekToken(RPAREN)) {
+                    do {
+                        nextToken();
+                        JCPattern nestedPattern = parsePattern(token.pos, null, null, true, false);
+                        nested.append(nestedPattern);
+                    } while (token.kind == COMMA);
+                } else {
+                    nextToken();
+                }
+                accept(RPAREN);
+                JCVariableDecl var;
+                if (token.kind == IDENTIFIER) {
+                    if (!checkGuard || token.name() != names.when) {
+                        var = to(F.at(token.pos).VarDef(F.Modifiers(0), token.name(), e, null));
+                        nextToken();
+                    } else {
+                        var = null;
+                    }
+                } else {
+                    var = null;
+                }
+                pattern = toP(F.at(pos).RecordPattern(e, nested.toList(), var));
+            } else {
+                //type test pattern:
+                JCVariableDecl var = toP(F.at(token.pos).VarDef(mods, ident(), e, null));
+                pattern = toP(F.at(pos).BindingPattern(var));
+            }
         }
         return pattern;
     }
 
+
     /**
      * parses (optional) type annotations followed by a type. If the
      * annotations are present before the type and are not consumed during array
@@ -812,7 +852,11 @@ public JCExpression parseType(boolean allowVar, List<JCAnnotation> annotations)
     }
 
     public JCExpression unannotatedType(boolean allowVar) {
-        JCExpression result = term(TYPE);
+        return unannotatedType(allowVar, TYPE);
+    }
+
+    public JCExpression unannotatedType(boolean allowVar, int newmode) {
+        JCExpression result = term(newmode);
         Name restrictedTypeName = restrictedTypeName(result, !allowVar);
 
         if (restrictedTypeName != null && (!allowVar || restrictedTypeName != names.var)) {
@@ -961,15 +1005,17 @@ JCExpression term2Rest(JCExpression t, int minprec) {
                 JCTree pattern;
                 if (token.kind == LPAREN) {
                     checkSourceLevel(token.pos, Feature.PATTERN_SWITCH);
-                    pattern = parsePattern(token.pos, null, null);
+                    pattern = parsePattern(token.pos, null, null, false, false);
                 } else {
                     int patternPos = token.pos;
                     JCModifiers mods = optFinal(0);
                     int typePos = token.pos;
                     JCExpression type = unannotatedType(false);
                     if (token.kind == IDENTIFIER) {
                         checkSourceLevel(token.pos, Feature.PATTERN_MATCHING_IN_INSTANCEOF);
-                        pattern = parsePattern(patternPos, mods, type);
+                        pattern = parsePattern(patternPos, mods, type, false, false);
+                    } else if (token.kind == LPAREN) {
+                        pattern = parsePattern(patternPos, mods, type, false, false);
                     } else {
                         checkNoMods(typePos, mods.flags & ~Flags.DEPRECATED);
                         if (mods.annotations.nonEmpty()) {
@@ -3070,7 +3116,7 @@ private JCCaseLabel parseCaseLabel() {
                               analyzePattern(lookahead) == PatternResult.PATTERN;
             if (pattern) {
                 checkSourceLevel(token.pos, Feature.PATTERN_SWITCH);
-                JCPattern p = parsePattern(patternPos, mods, null);
+                JCPattern p = parsePattern(patternPos, mods, null, false, true);
                 if (token.kind == IDENTIFIER && token.name() == names.when) {
                     nextToken();
                     p.guard = term(EXPR | NOLAMBDA);
@@ -3086,25 +3132,34 @@ private JCCaseLabel parseCaseLabel() {
 
     @SuppressWarnings("fallthrough")
     PatternResult analyzePattern(int lookahead) {
-        int depth = 0;
+        int typeDepth = 0;
+        int parenDepth = 0;
+        PatternResult pendingResult = PatternResult.EXPRESSION;
         while (true) {
             TokenKind token = S.token(lookahead).kind;
             switch (token) {
                 case BYTE: case SHORT: case INT: case LONG: case FLOAT:
                 case DOUBLE: case BOOLEAN: case CHAR: case VOID:
                 case ASSERT, ENUM, IDENTIFIER, UNDERSCORE:
-                    if (depth == 0 && peekToken(lookahead, LAX_IDENTIFIER)) return PatternResult.PATTERN;
+                    if (typeDepth == 0 && peekToken(lookahead, LAX_IDENTIFIER)) {
+                        if (parenDepth == 0) {
+                            return PatternResult.PATTERN;
+                        } else {
+                            pendingResult = PatternResult.PATTERN;
+                        }
+                    }
                     break;
                 case DOT, QUES, EXTENDS, SUPER, COMMA: break;
-                case LT: depth++; break;
-                case GTGTGT: depth--;
-                case GTGT: depth--;
+                case LT: typeDepth++; break;
+                case GTGTGT: typeDepth--;
+                case GTGT: typeDepth--;
                 case GT:
-                    depth--;
-                    if (depth == 0) {
-                         return peekToken(lookahead, LAX_IDENTIFIER) ? PatternResult.PATTERN
-                                                          : PatternResult.EXPRESSION;
-                    } else if (depth < 0) return PatternResult.EXPRESSION;
+                    typeDepth--;
+                    if (typeDepth == 0) {
+                         return peekToken(lookahead, LAX_IDENTIFIER) ||
+                                peekToken(lookahead, tk -> tk == LPAREN) ? PatternResult.PATTERN
+                                                                         : PatternResult.EXPRESSION;
+                    } else if (typeDepth < 0) return PatternResult.EXPRESSION;
                     break;
                 case MONKEYS_AT:
                     lookahead = skipAnnotation(lookahead);
@@ -3118,7 +3173,17 @@ PatternResult analyzePattern(int lookahead) {
                     } else {
                         return PatternResult.EXPRESSION;
                     }
-                default: return PatternResult.EXPRESSION;
+                case LPAREN:
+                    if (S.token(lookahead + 1).kind == RPAREN) {
+                        return parenDepth != 0 && S.token(lookahead + 2).kind == ARROW
+                                ? PatternResult.EXPRESSION
+                                : PatternResult.PATTERN;
+                    }
+                    parenDepth++; break;
+                case RPAREN: parenDepth--; break;
+                case ARROW: return parenDepth > 0 ? PatternResult.EXPRESSION
+                                                   : pendingResult;
+                default: return pendingResult;
             }
             lookahead++;
         }