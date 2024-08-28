@@ -61,34 +61,44 @@ public static TreePath getPath(TreePath path, Tree target) {
         Objects.requireNonNull(path);
         Objects.requireNonNull(target);
 
-        class Result extends Error {
-            static final long serialVersionUID = -5942088234594905625L;
-            @SuppressWarnings("serial") // Type of field is not Serializable
-            TreePath path;
-            Result(TreePath path) {
-                this.path = path;
+        class PathFinder extends TreePathScanner<TreePath,Tree> {
+            private TreePath result;
+
+
+            @Override
+            public TreePath scan(TreePath path, Tree target) {
+                super.scan(path, target);
+                return result;
             }
-        }
 
-        class PathFinder extends TreePathScanner<TreePath,Tree> {
+            @Override
             public TreePath scan(Tree tree, Tree target) {
-                if (tree == target) {
-                    throw new Result(new TreePath(getCurrentPath(), target));
+                if (result == null) {
+                    if (tree == target) {
+                        result = new TreePath(getCurrentPath(), target);
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
+            @Override
+            public TreePath scan(Iterable<? extends Tree> nodes, Tree target) {
+                if (nodes != null && result == null) {
+                    for (Tree node : nodes) {
+                        scan(node, target);
+                        if (result != null) {
+                            break;
+                        }
+                    }
+                }
+                return result;
+            }
         }
 
-        try {
-            new PathFinder().scan(path, target);
-        } catch (Result result) {
-            return result.path;
-        }
-        return null;
+        return path.getLeaf() == target ? path
+                : new PathFinder().scan(path, target);
     }
 
     /**