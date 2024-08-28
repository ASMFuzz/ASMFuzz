@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -29,7 +29,7 @@
 import com.sun.tools.javac.code.Symbol.BindingSymbol;
 import com.sun.tools.javac.resources.CompilerProperties.Errors;
 import com.sun.tools.javac.tree.JCTree;
-import com.sun.tools.javac.tree.JCTree.JCGuardPattern;
+import com.sun.tools.javac.tree.JCTree.JCCase;
 import com.sun.tools.javac.tree.JCTree.Tag;
 import com.sun.tools.javac.tree.TreeScanner;
 import com.sun.tools.javac.util.Context;
@@ -112,7 +112,7 @@ public MatchBindings binary(JCTree tree, MatchBindings lhsBindings, MatchBinding
         return EMPTY;
     }
 
-    public MatchBindings guardedPattern(JCGuardPattern tree, MatchBindings patternBindings, MatchBindings guardBindings) {
+    public MatchBindings caseGuard(JCCase tree, MatchBindings patternBindings, MatchBindings guardBindings) {
         return andOperation(tree.pos(), patternBindings, guardBindings);
     }
 
@@ -142,7 +142,7 @@ public MatchBindings switchCase(JCTree tree, MatchBindings prevBindings, MatchBi
     public MatchBindings finishBindings(JCTree tree, MatchBindings matchBindings) {
         switch (tree.getTag()) {
             case NOT: case AND: case OR: case BINDINGPATTERN:
-            case PARENTHESIZEDPATTERN: case GUARDPATTERN:
+            case PARENTHESIZEDPATTERN:
             case PARENS: case TYPETEST:
             case CONDEXPR: //error recovery:
                 return matchBindings;