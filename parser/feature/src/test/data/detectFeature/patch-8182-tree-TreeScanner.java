@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -305,21 +305,17 @@ public void visitTypeTest(JCInstanceOf tree) {
 
     public void visitBindingPattern(JCBindingPattern tree) {
         scan(tree.var);
+        scan(tree.guard);
     }
 
     @Override
     public void visitDefaultCaseLabel(JCDefaultCaseLabel tree) {
     }
 
     @Override
-    public void visitParenthesizedPattern(JCParenthesizedPattern that) {
-        scan(that.pattern);
-    }
-
-    @Override
-    public void visitGuardPattern(JCGuardPattern that) {
-        scan(that.patt);
-        scan(that.expr);
+    public void visitParenthesizedPattern(JCParenthesizedPattern tree) {
+        scan(tree.pattern);
+        scan(tree.guard);
     }
 
     public void visitIndexed(JCArrayAccess tree) {