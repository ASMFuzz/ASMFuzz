@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -500,12 +500,6 @@ public JCParenthesizedPattern ParenthesizedPattern(JCPattern pattern) {
         return tree;
     }
 
-    public JCGuardPattern GuardPattern(JCPattern guardedPattern, JCExpression expr) {
-        JCGuardPattern tree = new JCGuardPattern(guardedPattern, expr);
-        tree.pos = pos;
-        return tree;
-    }
-
     public JCArrayAccess Indexed(JCExpression indexed, JCExpression index) {
         JCArrayAccess tree = new JCArrayAccess(indexed, index);
         tree.pos = pos;