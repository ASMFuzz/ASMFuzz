@@ -924,6 +924,26 @@ public void visitParenthesizedPattern(JCParenthesizedPattern patt) {
         }
     }
 
+    @Override
+    public void visitRecordPattern(JCRecordPattern tree) {
+        try {
+            printExpr(tree.deconstructor);
+            print("(");
+            printExprs(tree.nested);
+            print(")");
+            if (tree.var != null) {
+                print(" ");
+                print(tree.var.name);
+            }
+            if (tree.guard != null) {
+                print(" when ");
+                printExpr(tree.guard);
+            }
+        } catch (IOException e) {
+            throw new UncheckedIOException(e);
+        }
+    }
+
     public void visitSynchronized(JCSynchronized tree) {
         try {
             print("synchronized ");