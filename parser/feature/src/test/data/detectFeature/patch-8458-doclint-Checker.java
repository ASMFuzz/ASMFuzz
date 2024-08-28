@@ -251,7 +251,7 @@ public Void scan(DocCommentTree tree, TreePath p) {
         // the following checks are made after the scan, which will record @param tags
         if (isDeclaredType()) {
             TypeElement te = (TypeElement) env.currElement;
-            // checkParamsDocumented(te.getTypeParameters()); // See JDK-8285496
+            checkParamsDocumented(te.getTypeParameters());
             checkParamsDocumented(te.getRecordComponents());
         } else if (isExecutable()) {
             if (!isOverridingMethod) {