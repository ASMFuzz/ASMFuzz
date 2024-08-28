@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2006, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2006, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -494,22 +494,20 @@ public JCTree visitInstanceOf(InstanceOfTree node, P p) {
     public JCTree visitBindingPattern(BindingPatternTree node, P p) {
         JCBindingPattern t = (JCBindingPattern) node;
         JCVariableDecl var = copy(t.var, p);
-        return M.at(t.pos).BindingPattern(var);
-    }
-
-    @DefinedBy(Api.COMPILER_TREE)
-    public JCTree visitGuardedPattern(GuardedPatternTree node, P p) {
-        JCGuardPattern t = (JCGuardPattern) node;
-        JCPattern patt = copy(t.patt, p);
-        JCExpression expr = copy(t.expr, p);
-        return M.at(t.pos).GuardPattern(patt, expr);
+        JCExpression guard = copy(t.guard, p);
+        JCPattern pat = M.at(t.pos).BindingPattern(var);
+        pat.guard = guard;
+        return pat;
     }
 
     @DefinedBy(Api.COMPILER_TREE)
     public JCTree visitParenthesizedPattern(ParenthesizedPatternTree node, P p) {
         JCParenthesizedPattern t = (JCParenthesizedPattern) node;
         JCPattern pattern = copy(t.pattern, p);
-        return M.at(t.pos).ParenthesizedPattern(pattern);
+        JCExpression guard = copy(t.guard, p);
+        JCPattern pat = M.at(t.pos).ParenthesizedPattern(pattern);
+        pat.guard = guard;
+        return pat;
     }
 
     @DefinedBy(Api.COMPILER_TREE)