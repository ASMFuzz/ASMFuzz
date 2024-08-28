@@ -59,38 +59,45 @@ public static DocTreePath getPath(TreePath treePath, DocCommentTree doc, DocTree
      * @return a path identifying the target node
      */
     public static DocTreePath getPath(DocTreePath path, DocTree target) {
-        Objects.requireNonNull(path); //null check
-        Objects.requireNonNull(target); //null check
-
-        class Result extends Error {
-            static final long serialVersionUID = -5942088234594905625L;
-            @SuppressWarnings("serial") // Type of field is not Serializable
-            DocTreePath path;
-            Result(DocTreePath path) {
-                this.path = path;
+        Objects.requireNonNull(path);
+        Objects.requireNonNull(target);
+
+        class PathFinder extends DocTreePathScanner<DocTreePath, DocTree> {
+            private DocTreePath result;
+
+            @Override
+            public DocTreePath scan(DocTreePath path, DocTree target) {
+                super.scan(path, target);
+                return result;
             }
-        }
 
-        class PathFinder extends DocTreePathScanner<DocTreePath,DocTree> {
             @Override
             public DocTreePath scan(DocTree tree, DocTree target) {
-                if (tree == target) {
-                    throw new Result(new DocTreePath(getCurrentPath(), target));
+                if (result == null) {
+                    if (tree == target) {
+                        result = new DocTreePath(getCurrentPath(), target);
+                    } else {
+                        super.scan(tree, target);
+                    }
                 }
-                return super.scan(tree, target);
+                return result;
             }
-        }
 
-        if (path.getLeaf() == target) {
-            return path;
-        }
-
-        try {
-            new PathFinder().scan(path, target);
-        } catch (Result result) {
-            return result.path;
+            @Override
+            public DocTreePath scan(Iterable<? extends DocTree> nodes, DocTree target) {
+                if (nodes != null && result == null) {
+                    for (DocTree node : nodes) {
+                        scan(node, target);
+                        if (result != null) {
+                            break;
+                        }
+                    }
+                }
+                return result;
+            }
         }
-        return null;
+        return path.getLeaf() == target ? path
+                : new PathFinder().scan(path, target);
     }
 
     /**