@@ -174,6 +174,8 @@ protected Attr(Context context) {
         allowRecords = Feature.RECORDS.allowedInSource(source);
         allowPatternSwitch = (preview.isEnabled() || !preview.isPreview(Feature.PATTERN_SWITCH)) &&
                              Feature.PATTERN_SWITCH.allowedInSource(source);
+        allowUnconditionalPatternsInstanceOf = (preview.isEnabled() || !preview.isPreview(Feature.UNCONDITIONAL_PATTERN_IN_INSTANCEOF)) &&
+                                     Feature.UNCONDITIONAL_PATTERN_IN_INSTANCEOF.allowedInSource(source);
         sourceName = source.name;
         useBeforeDeclarationWarning = options.isSet("useBeforeDeclarationWarning");
 
@@ -218,6 +220,10 @@ protected Attr(Context context) {
      */
     private final boolean allowPatternSwitch;
 
+    /** Are unconditional patterns in instanceof allowed
+     */
+    private final boolean allowUnconditionalPatternsInstanceOf;
+
     /**
      * Switch: warn about use of variable before declaration?
      * RFE: 6425594
@@ -1686,7 +1692,8 @@ private void handleSwitch(JCTree switchTree,
             List<Type> coveredTypesForPatterns = List.nil();
             List<Type> coveredTypesForConstants = List.nil();
             boolean hasDefault = false;           // Is there a default label?
-            boolean hasTotalPattern = false;      // Is there a total pattern?
+            boolean hasUnconditionalPattern = false; // Is there a unconditional pattern?
+            boolean lastPatternErroneous = false; // Has the last pattern erroneous type?
             boolean hasNullPattern = false;       // Is there a null pattern?
             CaseTree.CaseKind caseKind = null;
             boolean wasError = false;
@@ -1701,15 +1708,15 @@ private void handleSwitch(JCTree switchTree,
                     wasError = true;
                 }
                 MatchBindings currentBindings = prevBindings;
-                boolean wasTotalPattern = hasTotalPattern;
+                boolean wasUnconditionalPattern = hasUnconditionalPattern;
                 for (JCCaseLabel pat : c.labels) {
                     if (pat.isExpression()) {
                         JCExpression expr = (JCExpression) pat;
                         if (TreeInfo.isNull(expr)) {
                             preview.checkSourceLevel(expr.pos(), Feature.CASE_NULL);
                             if (hasNullPattern) {
                                 log.error(pat.pos(), Errors.DuplicateCaseLabel);
-                            } else if (wasTotalPattern) {
+                            } else if (wasUnconditionalPattern) {
                                 log.error(pat.pos(), Errors.PatternDominated);
                             }
                             hasNullPattern = true;
@@ -1762,42 +1769,57 @@ private void handleSwitch(JCTree switchTree,
                     } else if (pat.hasTag(DEFAULTCASELABEL)) {
                         if (hasDefault) {
                             log.error(pat.pos(), Errors.DuplicateDefaultLabel);
-                        } else if (hasTotalPattern) {
-                            log.error(pat.pos(), Errors.TotalPatternAndDefault);
+                        } else if (hasUnconditionalPattern) {
+                            log.error(pat.pos(), Errors.UnconditionalPatternAndDefault);
                         }
                         hasDefault = true;
                         matchBindings = MatchBindingsComputer.EMPTY;
                     } else {
                         //binding pattern
                         attribExpr(pat, switchEnv);
-                        var primary = TreeInfo.primaryPatternType((JCPattern) pat);
-                        Type primaryType = primary.type();
+                        Type primaryType = TreeInfo.primaryPatternType(pat);
                         if (!primaryType.hasTag(TYPEVAR)) {
                             primaryType = chk.checkClassOrArrayType(pat.pos(), primaryType);
                         }
                         checkCastablePattern(pat.pos(), seltype, primaryType);
                         Type patternType = types.erasure(primaryType);
-                        boolean isTotal = primary.unconditional() &&
-                                          !patternType.isErroneous() &&
-                                          types.isSubtype(types.erasure(seltype), patternType);
-                        if (isTotal) {
-                            if (hasTotalPattern) {
-                                log.error(pat.pos(), Errors.DuplicateTotalPattern);
+                        JCExpression guard = ((JCPattern) pat).guard;
+                        if (guard != null) {
+                            MatchBindings afterPattern = matchBindings;
+                            Env<AttrContext> bodyEnv = bindingEnv(env, matchBindings.bindingsWhenTrue);
+                            try {
+                                attribExpr(guard, bodyEnv, syms.booleanType);
+                            } finally {
+                                bodyEnv.info.scope.leave();
+                            }
+                            matchBindings = matchBindingsComputer.caseGuard(c, afterPattern, matchBindings);
+                        }
+                        boolean unguarded = TreeInfo.unguardedCaseLabel(pat);
+                        boolean unconditional =
+                                unguarded &&
+                                !patternType.isErroneous() &&
+                                types.isSubtype(types.boxedTypeOrType(types.erasure(seltype)),
+                                                patternType);
+                        if (unconditional) {
+                            if (hasUnconditionalPattern) {
+                                log.error(pat.pos(), Errors.DuplicateUnconditionalPattern);
                             } else if (hasDefault) {
-                                log.error(pat.pos(), Errors.TotalPatternAndDefault);
+                                log.error(pat.pos(), Errors.UnconditionalPatternAndDefault);
                             }
-                            hasTotalPattern = true;
+                            hasUnconditionalPattern = true;
                         }
+                        lastPatternErroneous = patternType.isErroneous();
                         checkCaseLabelDominated(pat.pos(), coveredTypesForPatterns, patternType);
                         if (!patternType.isErroneous()) {
                             coveredTypesForConstants = coveredTypesForConstants.prepend(patternType);
-                            if (primary.unconditional()) {
+                            if (unguarded) {
                                 coveredTypesForPatterns = coveredTypesForPatterns.prepend(patternType);
                             }
                         }
                     }
                     currentBindings = matchBindingsComputer.switchCase(pat, currentBindings, matchBindings);
                 }
+
                 Env<AttrContext> caseEnv =
                         bindingEnv(switchEnv, c, currentBindings.bindingsWhenTrue);
                 try {
@@ -1817,10 +1839,12 @@ private void handleSwitch(JCTree switchTree,
                 chk.checkSwitchCaseStructure(cases);
             }
             if (switchTree.hasTag(SWITCH)) {
-                ((JCSwitch) switchTree).hasTotalPattern = hasDefault || hasTotalPattern;
+                ((JCSwitch) switchTree).hasUnconditionalPattern =
+                        hasDefault || hasUnconditionalPattern || lastPatternErroneous;
                 ((JCSwitch) switchTree).patternSwitch = patternSwitch;
             } else if (switchTree.hasTag(SWITCH_EXPRESSION)) {
-                ((JCSwitchExpression) switchTree).hasTotalPattern = hasDefault || hasTotalPattern;
+                ((JCSwitchExpression) switchTree).hasUnconditionalPattern =
+                        hasDefault || hasUnconditionalPattern || lastPatternErroneous;
                 ((JCSwitchExpression) switchTree).patternSwitch = patternSwitch;
             } else {
                 Assert.error(switchTree.getTag().name());
@@ -4090,7 +4114,11 @@ public void visitTypeTest(JCInstanceOf tree) {
             clazztype = tree.pattern.type;
             if (types.isSubtype(exprtype, clazztype) &&
                 !exprtype.isErroneous() && !clazztype.isErroneous()) {
-                log.error(tree.pos(), Errors.InstanceofPatternNoSubtype(exprtype, clazztype));
+                if (!allowUnconditionalPatternsInstanceOf) {
+                    log.error(tree.pos(), Errors.InstanceofPatternNoSubtype(exprtype, clazztype));
+                } else if (preview.isPreview(Feature.UNCONDITIONAL_PATTERN_IN_INSTANCEOF)) {
+                    preview.warnPreview(tree.pattern.pos(), Feature.UNCONDITIONAL_PATTERN_IN_INSTANCEOF);
+                }
             }
             typeTree = TreeInfo.primaryPatternTree((JCPattern) tree.pattern).var.vartype;
         } else {
@@ -4126,6 +4154,10 @@ private boolean checkCastablePattern(DiagnosticPosition pos,
             chk.basicHandler.report(pos,
                     diags.fragment(Fragments.InconvertibleTypes(exprType, pattType)));
             return false;
+        } else if (exprType.isPrimitive() ^ pattType.isPrimitive()) {
+            chk.basicHandler.report(pos,
+                    diags.fragment(Fragments.NotApplicableTypes(exprType, pattType)));
+            return false;
         } else if (warner.hasLint(LintCategory.UNCHECKED)) {
             log.error(pos,
                     Errors.InstanceofReifiableNotSafe(exprType, pattType));
@@ -4158,20 +4190,6 @@ public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         result = tree.type = tree.pattern.type;
     }
 
-    @Override
-    public void visitGuardPattern(JCGuardPattern tree) {
-        attribExpr(tree.patt, env);
-        MatchBindings afterPattern = matchBindings;
-        Env<AttrContext> bodyEnv = bindingEnv(env, matchBindings.bindingsWhenTrue);
-        try {
-            attribExpr(tree.expr, bodyEnv, syms.booleanType);
-        } finally {
-            bodyEnv.info.scope.leave();
-        }
-        result = tree.type = tree.patt.type;
-        matchBindings = matchBindingsComputer.guardedPattern(tree, afterPattern, matchBindings);
-    }
-
     public void visitIndexed(JCArrayAccess tree) {
         Type owntype = types.createErrorType(tree.type);
         Type atype = attribExpr(tree.indexed, env);