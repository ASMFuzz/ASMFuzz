@@ -142,8 +142,8 @@ public MatchBindings switchCase(JCTree tree, MatchBindings prevBindings, MatchBi
     public MatchBindings finishBindings(JCTree tree, MatchBindings matchBindings) {
         switch (tree.getTag()) {
             case NOT: case AND: case OR: case BINDINGPATTERN:
-            case PARENTHESIZEDPATTERN:
-            case PARENS: case TYPETEST:
+            case PARENTHESIZEDPATTERN: case TYPETEST:
+            case PARENS: case RECORDPATTERN:
             case CONDEXPR: //error recovery:
                 return matchBindings;
             default: