@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -3615,20 +3615,26 @@ public void visitReturn(JCReturn tree) {
     }
 
     public void visitSwitch(JCSwitch tree) {
-        List<JCCase> cases = tree.patternSwitch ? addDefaultIfNeeded(tree.cases) : tree.cases;
+        boolean matchException = tree.patternSwitch && !tree.wasEnumSelector;
+        List<JCCase> cases = tree.patternSwitch ? addDefaultIfNeeded(matchException, tree.cases)
+                                                : tree.cases;
         handleSwitch(tree, tree.selector, cases);
     }
 
     @Override
     public void visitSwitchExpression(JCSwitchExpression tree) {
-        List<JCCase> cases = addDefaultIfNeeded(tree.cases);
+        boolean matchException = tree.patternSwitch && !tree.wasEnumSelector;
+        List<JCCase> cases = addDefaultIfNeeded(matchException, tree.cases);
         handleSwitch(tree, tree.selector, cases);
     }
 
-    private List<JCCase> addDefaultIfNeeded(List<JCCase> cases) {
+    private List<JCCase> addDefaultIfNeeded(boolean matchException, List<JCCase> cases) {
         if (cases.stream().flatMap(c -> c.labels.stream()).noneMatch(p -> p.hasTag(Tag.DEFAULTCASELABEL))) {
-            JCThrow thr = make.Throw(makeNewClass(syms.incompatibleClassChangeErrorType,
-                                                  List.nil()));
+            Type exception = matchException ? syms.matchExceptionType
+                                            : syms.incompatibleClassChangeErrorType;
+            List<JCExpression> params = matchException ? List.of(makeNull(), makeNull())
+                                                       : List.nil();
+            JCThrow thr = make.Throw(makeNewClass(exception, params));
             JCCase c = make.Case(JCCase.STATEMENT, List.of(make.DefaultCaseLabel()), List.of(thr), null);
             cases = cases.prepend(c);
         }