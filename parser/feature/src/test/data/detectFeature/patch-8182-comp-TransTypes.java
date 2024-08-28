@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -565,6 +565,7 @@ public void visitCase(JCCase tree) {
 
     public void visitBindingPattern(JCBindingPattern tree) {
         tree.var = translate(tree.var, null);
+        tree.guard = translate(tree.guard, syms.booleanType);
         result = tree;
     }
 
@@ -582,13 +583,7 @@ public void visitSwitchExpression(JCSwitchExpression tree) {
     @Override
     public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         tree.pattern = translate(tree.pattern, null);
-        result = tree;
-    }
-
-    @Override
-    public void visitGuardPattern(JCGuardPattern tree) {
-        tree.patt = translate(tree.patt, null);
-        tree.expr = translate(tree.expr, syms.booleanType);
+        tree.guard = translate(tree.guard, syms.booleanType);
         result = tree;
     }
 