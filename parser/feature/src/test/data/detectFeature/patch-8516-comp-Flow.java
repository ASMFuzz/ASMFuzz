@@ -27,9 +27,12 @@
 
 package com.sun.tools.javac.comp;
 
+import java.util.Map;
+import java.util.Map.Entry;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.Set;
+import java.util.stream.Collectors;
 import java.util.stream.StreamSupport;
 
 import com.sun.source.tree.LambdaExpressionTree.BodyKind;
@@ -52,6 +55,7 @@
 import static com.sun.tools.javac.code.Kinds.Kind.*;
 import com.sun.tools.javac.code.Type.TypeVar;
 import static com.sun.tools.javac.code.TypeTag.BOOLEAN;
+import static com.sun.tools.javac.code.TypeTag.NONE;
 import static com.sun.tools.javac.code.TypeTag.VOID;
 import com.sun.tools.javac.resources.CompilerProperties.Fragments;
 import static com.sun.tools.javac.tree.JCTree.Tag.*;
@@ -664,15 +668,11 @@ public void visitSwitch(JCSwitch tree) {
             pendingExits = new ListBuffer<>();
             scan(tree.selector);
             boolean exhaustiveSwitch = TreeInfo.expectedExhaustive(tree);
-            Set<Symbol> constants = exhaustiveSwitch ? new HashSet<>() : null;
             for (List<JCCase> l = tree.cases; l.nonEmpty(); l = l.tail) {
                 alive = Liveness.ALIVE;
                 JCCase c = l.head;
                 for (JCCaseLabel pat : c.labels) {
                     scan(pat);
-                    if (TreeInfo.unguardedCaseLabel(pat)) {
-                        handleConstantCaseLabel(constants, pat);
-                    }
                 }
                 scanStats(c.stats);
                 if (alive != Liveness.DEAD && c.caseKind == JCCase.RULE) {
@@ -690,7 +690,8 @@ public void visitSwitch(JCSwitch tree) {
             tree.isExhaustive = tree.hasUnconditionalPattern ||
                                 TreeInfo.isErrorEnumSwitch(tree.selector, tree.cases);
             if (exhaustiveSwitch) {
-                tree.isExhaustive |= isExhaustive(tree.selector.pos(), tree.selector.type, constants);
+                Set<Symbol> coveredSymbols = coveredSymbolsForCases(tree.pos(), tree.selector, tree.cases);
+                tree.isExhaustive |= isExhaustive(tree.selector.pos(), tree.selector.type, coveredSymbols);
                 if (!tree.isExhaustive) {
                     log.error(tree, Errors.NotExhaustiveStatement);
                 }
@@ -706,16 +707,12 @@ public void visitSwitchExpression(JCSwitchExpression tree) {
             ListBuffer<PendingExit> prevPendingExits = pendingExits;
             pendingExits = new ListBuffer<>();
             scan(tree.selector);
-            Set<Symbol> constants = new HashSet<>();
             Liveness prevAlive = alive;
             for (List<JCCase> l = tree.cases; l.nonEmpty(); l = l.tail) {
                 alive = Liveness.ALIVE;
                 JCCase c = l.head;
                 for (JCCaseLabel pat : c.labels) {
                     scan(pat);
-                    if (TreeInfo.unguardedCaseLabel(pat)) {
-                        handleConstantCaseLabel(constants, pat);
-                    }
                 }
                 scanStats(c.stats);
                 if (alive == Liveness.ALIVE) {
@@ -728,28 +725,143 @@ public void visitSwitchExpression(JCSwitchExpression tree) {
                     }
                 }
             }
+            Set<Symbol> coveredSymbols = coveredSymbolsForCases(tree.pos(), tree.selector, tree.cases);
             tree.isExhaustive = tree.hasUnconditionalPattern ||
                                 TreeInfo.isErrorEnumSwitch(tree.selector, tree.cases) ||
-                                isExhaustive(tree.selector.pos(), tree.selector.type, constants);
+                                isExhaustive(tree.selector.pos(), tree.selector.type, coveredSymbols);
             if (!tree.isExhaustive) {
                 log.error(tree, Errors.NotExhaustive);
             }
             alive = prevAlive;
             alive = alive.or(resolveYields(tree, prevPendingExits));
         }
 
-        private void handleConstantCaseLabel(Set<Symbol> constants, JCCaseLabel pat) {
-            if (constants != null) {
-                if (pat.isExpression()) {
-                    JCExpression expr = (JCExpression) pat;
-                    if (expr.hasTag(IDENT) && ((JCIdent) expr).sym.isEnum())
-                        constants.add(((JCIdent) expr).sym);
-                } else if (pat.isPattern()) {
-                    Type primaryType = TreeInfo.primaryPatternType(pat);
+        private Set<Symbol> coveredSymbolsForCases(DiagnosticPosition pos,
+                                                   JCExpression selector, List<JCCase> cases) {
+            HashSet<JCCaseLabel> labels = cases.stream()
+                                               .flatMap(c -> c.labels.stream())
+                                               .filter(TreeInfo::unguardedCaseLabel)
+                                               .collect(Collectors.toCollection(HashSet::new));
+            return coveredSymbols(pos, selector.type, labels);
+        }
+
+        private Set<Symbol> coveredSymbols(DiagnosticPosition pos, Type targetType,
+                                           Iterable<? extends JCCaseLabel> labels) {
+            Set<Symbol> coveredSymbols = new HashSet<>();
+            Map<Symbol, List<JCRecordPattern>> deconstructionPatternsBySymbol = new HashMap<>();
+
+            for (JCCaseLabel label : labels) {
+                switch (label.getTag()) {
+                    case BINDINGPATTERN, PARENTHESIZEDPATTERN -> {
+                        Type primaryPatternType = TreeInfo.primaryPatternType((JCPattern) label);
+                        if (!primaryPatternType.hasTag(NONE)) {
+                            coveredSymbols.add(primaryPatternType.tsym);
+                        }
+                    }
+                    case RECORDPATTERN -> {
+                        JCRecordPattern dpat = (JCRecordPattern) label;
+                        Symbol type = dpat.record;
+                        List<JCRecordPattern> augmentedPatterns =
+                                deconstructionPatternsBySymbol.getOrDefault(type, List.nil())
+                                                                 .prepend(dpat);
+
+                        deconstructionPatternsBySymbol.put(type, augmentedPatterns);
+                    }
+
+
+                    case DEFAULTCASELABEL -> {}
+                    default -> {
+                        if (label.isExpression()) {
+                            JCExpression expr = (JCExpression) label;
+                            if (expr.hasTag(IDENT) && ((JCIdent) expr).sym.isEnum())
+                                coveredSymbols.add(((JCIdent) expr).sym);
+                        } else {
+                            throw new AssertionError(label.getTag());
+                        }
+                    }
+                }
+            }
+            for (Entry<Symbol, List<JCRecordPattern>> e : deconstructionPatternsBySymbol.entrySet()) {
+                if (coversDeconstructionFromComponent(pos, targetType, e.getValue(), 0)) {
+                    coveredSymbols.add(e.getKey());
+                }
+            }
+            return coveredSymbols;
+        }
+
+        private boolean coversDeconstructionFromComponent(DiagnosticPosition pos,
+                                                          Type targetType,
+                                                          List<JCRecordPattern> deconstructionPatterns,
+                                                          int component) {
+            //Given a set of record patterns for the same record, and a starting component,
+            //this method checks, whether the nested patterns for the components are exhaustive,
+            //i.e. represent all possible combinations.
+            //This is done by categorizing the patterns based on the type covered by the given
+            //starting component.
+            //For each such category, it is then checked if the nested patterns starting at the next
+            //component are exhaustive, by recursivelly invoking this method. If these nested patterns
+            //are exhaustive, the given covered type is accepted.
+            //All such covered types are then checked whether they cover the declared type of
+            //the starting component's declaration. If yes, the given set of patterns starting at
+            //the given component cover the given record exhaustivelly, and true is returned.
+            List<? extends RecordComponent> components =
+                    deconstructionPatterns.head.record.getRecordComponents();
+
+            if (components.size() == component) {
+                //no components remain to be checked:
+                return true;
+            }
+
+            //for the first tested component, gather symbols covered by the nested patterns:
+            Type instantiatedComponentType = types.memberType(targetType, components.get(component));
+            List<JCPattern> nestedComponentPatterns = deconstructionPatterns.map(d -> d.nested.get(component));
+            Set<Symbol> coveredSymbolsForComponent = coveredSymbols(pos, instantiatedComponentType,
+                                                                    nestedComponentPatterns);
+
+            //for each of the symbols covered by the starting component, find all deconstruction patterns
+            //that have the given type, or its supertype, as a type of the starting nested pattern:
+            Map<Symbol, List<JCRecordPattern>> coveredSymbol2Patterns = new HashMap<>();
+
+            for (JCRecordPattern deconstructionPattern : deconstructionPatterns) {
+                JCPattern nestedPattern = deconstructionPattern.nested.get(component);
+                Symbol componentPatternType;
+                switch (nestedPattern.getTag()) {
+                    case BINDINGPATTERN, PARENTHESIZEDPATTERN -> {
+                        Type primaryPatternType =
+                                TreeInfo.primaryPatternType(nestedPattern);
+                        componentPatternType = primaryPatternType.tsym;
+                    }
+                    case RECORDPATTERN -> {
+                        componentPatternType = ((JCRecordPattern) nestedPattern).record;
+                    }
+                    default -> {
+                        throw Assert.error("Unexpected tree kind: " + nestedPattern.getTag());
+                    }
+                }
+                for (Symbol currentType : coveredSymbolsForComponent) {
+                    if (types.isSubtype(types.erasure(currentType.type),
+                                        types.erasure(componentPatternType.type))) {
+                        coveredSymbol2Patterns.put(currentType,
+                                                   coveredSymbol2Patterns.getOrDefault(currentType,
+                                                                                       List.nil())
+                                              .prepend(deconstructionPattern));
+                    }
+                }
+            }
+
+            //Check the components following the starting component, for each of the covered symbol,
+            //if they are exhaustive. If yes, the given covered symbol should be part of the following
+            //exhaustiveness check:
+            Set<Symbol> covered = new HashSet<>();
 
-                    constants.add(primaryType.tsym);
+            for (Entry<Symbol, List<JCRecordPattern>> e : coveredSymbol2Patterns.entrySet()) {
+                if (coversDeconstructionFromComponent(pos, targetType, e.getValue(), component + 1)) {
+                    covered.add(e.getKey());
                 }
             }
+
+            //verify whether the filtered symbols cover the given record's declared type:
+            return isExhaustive(pos, instantiatedComponentType, covered);
         }
 
         private void transitiveCovers(DiagnosticPosition pos, Type seltype, Set<Symbol> covered) {
@@ -817,10 +929,15 @@ private boolean isExhaustive(DiagnosticPosition pos, Type seltype, Set<Symbol> c
                         }
                         yield false;
                     }
-                    yield covered.contains(seltype.tsym);
+                    yield covered.stream()
+                                 .filter(coveredSym -> coveredSym.kind == TYP)
+                                 .anyMatch(coveredSym -> types.isSubtype(types.erasure(seltype),
+                                                                         types.erasure(coveredSym.type)));
                 }
                 case TYPEVAR -> isExhaustive(pos, ((TypeVar) seltype).getUpperBound(), covered);
-                default -> false;
+                default -> {
+                    yield covered.contains(seltype.tsym);
+                }
             };
         }
 
@@ -2857,6 +2974,14 @@ public void visitBindingPattern(JCBindingPattern tree) {
             scan(tree.guard);
         }
 
+        @Override
+        public void visitRecordPattern(JCRecordPattern tree) {
+            super.visitRecordPattern(tree);
+            if (tree.var != null) {
+                initParam(tree.var);
+            }
+        }
+
         void referenced(Symbol sym) {
             unrefdResources.remove(sym);
         }
@@ -3044,6 +3169,19 @@ public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
             }
         }
 
+        @Override
+        public void visitRecordPattern(JCRecordPattern tree) {
+            scan(tree.deconstructor);
+            scan(tree.nested);
+            JCTree prevTree = currentTree;
+            try {
+                currentTree = tree;
+                scan(tree.guard);
+            } finally {
+                currentTree = prevTree;
+            }
+        }
+
         @Override
         public void visitIdent(JCIdent tree) {
             if (tree.sym.kind == VAR) {