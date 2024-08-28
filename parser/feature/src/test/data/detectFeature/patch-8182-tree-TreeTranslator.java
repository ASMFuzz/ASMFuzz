@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -360,6 +360,7 @@ public void visitTypeTest(JCInstanceOf tree) {
 
     public void visitBindingPattern(JCBindingPattern tree) {
         tree.var = translate(tree.var);
+        tree.guard = translate(tree.guard);
         result = tree;
     }
 
@@ -371,13 +372,7 @@ public void visitDefaultCaseLabel(JCDefaultCaseLabel tree) {
     @Override
     public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
         tree.pattern = translate(tree.pattern);
-        result = tree;
-    }
-
-    @Override
-    public void visitGuardPattern(JCGuardPattern tree) {
-        tree.patt = translate(tree.patt);
-        tree.expr = translate(tree.expr);
+        tree.guard = translate(tree.guard);
         result = tree;
     }
 