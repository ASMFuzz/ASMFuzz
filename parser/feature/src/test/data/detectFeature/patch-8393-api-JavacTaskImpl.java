@@ -489,10 +489,6 @@ public void process(Env<AttrContext> env) {
         return results;
     }
 
-    public Iterable<? extends Tree> pathFor(CompilationUnitTree unit, Tree node) {
-        return TreeInfo.pathFor((JCTree) node, (JCTree.JCCompilationUnit) unit).reverse();
-    }
-
     public void ensureEntered() {
         args.allowEmpty();
         enter(null);