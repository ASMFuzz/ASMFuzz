@@ -894,7 +894,12 @@ Type attribBase(JCTree tree,
         Type t = tree.type != null ?
             tree.type :
             attribType(tree, env);
-        return checkBase(t, tree, env, classExpected, interfaceExpected, checkExtensible);
+        try {
+            return checkBase(t, tree, env, classExpected, interfaceExpected, checkExtensible);
+        } catch (CompletionFailure ex) {
+            chk.completionError(tree.pos(), ex);
+            return t;
+        }
     }
     Type checkBase(Type t,
                    JCTree tree,