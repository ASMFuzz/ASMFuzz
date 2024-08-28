@@ -28,6 +28,7 @@
 import java.util.*;
 import java.util.function.BiConsumer;
 import java.util.function.Consumer;
+import java.util.stream.Stream;
 
 import javax.lang.model.element.ElementKind;
 import javax.tools.JavaFileObject;
@@ -1803,7 +1804,7 @@ private void handleSwitch(JCTree switchTree,
                                 log.error(guard.pos(), Errors.GuardHasConstantExpressionFalse);
                             }
                         }
-                        boolean unguarded = TreeInfo.unguardedCaseLabel(pat);
+                        boolean unguarded = TreeInfo.unguardedCaseLabel(pat) && !pat.hasTag(RECORDPATTERN);
                         boolean unconditional =
                                 unguarded &&
                                 !patternType.isErroneous() &&
@@ -4118,18 +4119,20 @@ public void visitTypeTest(JCInstanceOf tree) {
         Type clazztype;
         JCTree typeTree;
         if (tree.pattern.getTag() == BINDINGPATTERN ||
-           tree.pattern.getTag() == PARENTHESIZEDPATTERN) {
+            tree.pattern.getTag() == PARENTHESIZEDPATTERN ||
+            tree.pattern.getTag() == RECORDPATTERN) {
             attribTree(tree.pattern, env, unknownExprInfo);
             clazztype = tree.pattern.type;
             if (types.isSubtype(exprtype, clazztype) &&
-                !exprtype.isErroneous() && !clazztype.isErroneous()) {
+                !exprtype.isErroneous() && !clazztype.isErroneous() &&
+                tree.pattern.getTag() != RECORDPATTERN) {
                 if (!allowUnconditionalPatternsInstanceOf) {
                     log.error(tree.pos(), Errors.InstanceofPatternNoSubtype(exprtype, clazztype));
                 } else if (preview.isPreview(Feature.UNCONDITIONAL_PATTERN_IN_INSTANCEOF)) {
                     preview.warnPreview(tree.pattern.pos(), Feature.UNCONDITIONAL_PATTERN_IN_INSTANCEOF);
                 }
             }
-            typeTree = TreeInfo.primaryPatternTree((JCPattern) tree.pattern).var.vartype;
+            typeTree = TreeInfo.primaryPatternTypeTree((JCPattern) tree.pattern);
         } else {
             clazztype = attribType(tree.pattern, env);
             typeTree = tree.pattern;
@@ -4163,7 +4166,10 @@ private boolean checkCastablePattern(DiagnosticPosition pos,
             chk.basicHandler.report(pos,
                     diags.fragment(Fragments.InconvertibleTypes(exprType, pattType)));
             return false;
-        } else if (exprType.isPrimitive() ^ pattType.isPrimitive()) {
+        } else if ((exprType.isPrimitive() || pattType.isPrimitive()) &&
+                   (!exprType.isPrimitive() ||
+                    !pattType.isPrimitive() ||
+                    !types.isSameType(exprType, pattType))) {
             chk.basicHandler.report(pos,
                     diags.fragment(Fragments.NotApplicableTypes(exprType, pattType)));
             return false;
@@ -4177,23 +4183,100 @@ private boolean checkCastablePattern(DiagnosticPosition pos,
     }
 
     public void visitBindingPattern(JCBindingPattern tree) {
-        ResultInfo varInfo = new ResultInfo(KindSelector.TYP, resultInfo.pt, resultInfo.checkContext);
-        tree.type = tree.var.type = attribTree(tree.var.vartype, env, varInfo);
-        BindingSymbol v = new BindingSymbol(tree.var.mods.flags, tree.var.name, tree.var.vartype.type, env.info.scope.owner);
+        Type type;
+        if (tree.var.vartype != null) {
+            ResultInfo varInfo = new ResultInfo(KindSelector.TYP, resultInfo.pt, resultInfo.checkContext);
+            type = attribTree(tree.var.vartype, env, varInfo);
+        } else {
+            type = resultInfo.pt;
+        }
+        tree.type = tree.var.type = type;
+        BindingSymbol v = new BindingSymbol(tree.var.mods.flags, tree.var.name, type, env.info.scope.owner);
         v.pos = tree.pos;
         tree.var.sym = v;
         if (chk.checkUnique(tree.var.pos(), v, env.info.scope)) {
             chk.checkTransparentVar(tree.var.pos(), v, env.info.scope);
         }
-        annotate.annotateLater(tree.var.mods.annotations, env, v, tree.pos());
-        annotate.queueScanTreeAndTypeAnnotate(tree.var.vartype, env, v, tree.var.pos());
-        annotate.flush();
+        if (tree.var.vartype != null) {
+            annotate.annotateLater(tree.var.mods.annotations, env, v, tree.pos());
+            annotate.queueScanTreeAndTypeAnnotate(tree.var.vartype, env, v, tree.var.pos());
+            annotate.flush();
+        }
         chk.validate(tree.var.vartype, env, true);
         result = tree.type;
         matchBindings = new MatchBindings(List.of(v), List.nil());
     }
 
     @Override
+    public void visitRecordPattern(JCRecordPattern tree) {
+        tree.type = attribType(tree.deconstructor, env);
+        Type site = types.removeWildcards(tree.type);
+        List<Type> expectedRecordTypes;
+        if (site.tsym.kind == Kind.TYP && ((ClassSymbol) site.tsym).isRecord()) {
+            ClassSymbol record = (ClassSymbol) site.tsym;
+            if (record.type.getTypeArguments().nonEmpty() && tree.type.isRaw()) {
+                log.error(tree.pos(),Errors.RawDeconstructionPattern);
+            }
+            expectedRecordTypes = record.getRecordComponents()
+                                        .stream()
+                                        .map(rc -> types.memberType(site, rc)).collect(List.collector());
+            tree.record = record;
+        } else {
+            log.error(tree.pos(), Errors.DeconstructionPatternOnlyRecords(site.tsym));
+            expectedRecordTypes = Stream.generate(() -> Type.noType)
+                                .limit(tree.nested.size())
+                                .collect(List.collector());
+        }
+        ListBuffer<BindingSymbol> outBindings = new ListBuffer<>();
+        List<Type> recordTypes = expectedRecordTypes;
+        List<JCPattern> nestedPatterns = tree.nested;
+        Env<AttrContext> localEnv = env.dup(tree, env.info.dup(env.info.scope.dup()));
+        try {
+            while (recordTypes.nonEmpty() && nestedPatterns.nonEmpty()) {
+                boolean nestedIsVarPattern = false;
+                nestedIsVarPattern |= nestedPatterns.head.hasTag(BINDINGPATTERN) &&
+                                      ((JCBindingPattern) nestedPatterns.head).var.vartype == null;
+                attribExpr(nestedPatterns.head, localEnv, nestedIsVarPattern ? recordTypes.head : Type.noType);
+                checkCastablePattern(nestedPatterns.head.pos(), recordTypes.head, nestedPatterns.head.type);
+                outBindings.addAll(matchBindings.bindingsWhenTrue);
+                matchBindings.bindingsWhenTrue.forEach(localEnv.info.scope::enter);
+                nestedPatterns = nestedPatterns.tail;
+                recordTypes = recordTypes.tail;
+            }
+            if (recordTypes.nonEmpty() || nestedPatterns.nonEmpty()) {
+                while (nestedPatterns.nonEmpty()) {
+                    attribExpr(nestedPatterns.head, localEnv, Type.noType);
+                    nestedPatterns = nestedPatterns.tail;
+                }
+                List<Type> nestedTypes =
+                        tree.nested.stream().map(p -> p.type).collect(List.collector());
+                log.error(tree.pos(),
+                          Errors.IncorrectNumberOfNestedPatterns(expectedRecordTypes,
+                                                                 nestedTypes));
+            }
+            if (tree.var != null) {
+                BindingSymbol v = new BindingSymbol(tree.var.mods.flags, tree.var.name, tree.type,
+                                                    localEnv.info.scope.owner);
+                v.pos = tree.pos;
+                tree.var.sym = v;
+                if (chk.checkUnique(tree.var.pos(), v, localEnv.info.scope)) {
+                    chk.checkTransparentVar(tree.var.pos(), v, localEnv.info.scope);
+                }
+                if (tree.var.vartype != null) {
+                    annotate.annotateLater(tree.var.mods.annotations, localEnv, v, tree.pos());
+                    annotate.queueScanTreeAndTypeAnnotate(tree.var.vartype, localEnv, v, tree.var.pos());
+                    annotate.flush();
+                }
+                outBindings.add(v);
+            }
+        } finally {
+            localEnv.info.scope.leave();
+        }
+        chk.validate(tree.deconstructor, env, true);
+        result = tree.type;
+        matchBindings = new MatchBindings(outBindings.toList(), List.nil());
+    }
+
     public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         attribExpr(tree.pattern, env);
         result = tree.type = tree.pattern.type;