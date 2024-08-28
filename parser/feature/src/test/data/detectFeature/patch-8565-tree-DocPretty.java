@@ -632,6 +632,10 @@ public Void visitValue(ValueTree node, Void p) {
         try {
             print("{");
             printTagName(node);
+            if (node.getFormat() != null) {
+                print(" ");
+                print(node.getFormat());
+            }
             if (node.getReference() != null) {
                 print(" ");
                 print(node.getReference());