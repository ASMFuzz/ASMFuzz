@@ -2850,6 +2850,12 @@ public void visitIdent(JCIdent tree) {
             }
         }
 
+        @Override
+        public void visitTypeTest(JCInstanceOf tree) {
+            scanExpr(tree.expr);
+            scan(tree.pattern);
+        }
+
         @Override
         public void visitBindingPattern(JCBindingPattern tree) {
             scan(tree.var);