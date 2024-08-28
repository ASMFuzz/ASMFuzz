@@ -793,44 +793,6 @@ public static JCTree declarationFor(final Symbol sym, final JCTree tree) {
         return s.result;
     }
 
-    public static Env<AttrContext> scopeFor(JCTree node, JCCompilationUnit unit) {
-        return scopeFor(pathFor(node, unit));
-    }
-
-    public static Env<AttrContext> scopeFor(List<JCTree> path) {
-        // TODO: not implemented yet
-        throw new UnsupportedOperationException("not implemented yet");
-    }
-
-    public static List<JCTree> pathFor(final JCTree node, final JCCompilationUnit unit) {
-        class Result extends Error {
-            static final long serialVersionUID = -5942088234594905625L;
-            @SuppressWarnings("serial") // List not statically Serilizable
-            List<JCTree> path;
-            Result(List<JCTree> path) {
-                this.path = path;
-            }
-        }
-        class PathFinder extends TreeScanner {
-            List<JCTree> path = List.nil();
-            public void scan(JCTree tree) {
-                if (tree != null) {
-                    path = path.prepend(tree);
-                    if (tree == node)
-                        throw new Result(path);
-                    super.scan(tree);
-                    path = path.tail;
-                }
-            }
-        }
-        try {
-            new PathFinder().scan(unit);
-        } catch (Result result) {
-            return result.path;
-        }
-        return List.nil();
-    }
-
     /** Return the statement referenced by a label.
      *  If the label refers to a loop or switch, return that switch
      *  otherwise return the labelled statement itself