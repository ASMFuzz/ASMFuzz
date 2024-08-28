@@ -199,7 +199,7 @@ public Void scan(DocCommentTree tree, TreePath p) {
                     // Don't report an empty description if the comment contains @deprecated,
                     // because javadoc will use the content of that tag in summary tables.
                     if (tree.getBlockTags().stream().allMatch(t -> t.getKind() != DocTree.Kind.DEPRECATED)) {
-                        env.messages.report(MISSING, Kind.WARNING, tree, "dc.empty.description");
+                        env.messages.report(MISSING, Kind.WARNING, tree, "dc.empty.main.description");
                     }
                 }
             }