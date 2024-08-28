@@ -699,6 +699,7 @@ public Void visitUses(UsesTree node, Void p) {
             public Void visitValue(ValueTree node, Void p) {
                 header(node);
                 indent(+1);
+                print("format", node.getFormat());
                 print("reference", node.getReference());
                 indent(-1);
                 indent();