@@ -346,14 +346,14 @@ public void computeModulesData() {
         utils.getProvidesTrees(mdle).forEach(tree -> {
             TypeElement t = ch.getServiceType(tree);
             if (t != null) {
-                providesTrees.put(t, commentTagsToContent(tree, mdle, ch.getDescription(tree), false, true));
+                providesTrees.put(t, commentTagsToContent(mdle, ch.getDescription(tree), false, true));
             }
         });
         // Generate the map of all services listed using @uses, and the description.
         utils.getUsesTrees(mdle).forEach(tree -> {
             TypeElement t = ch.getServiceType(tree);
             if (t != null) {
-                usesTrees.put(t, commentTagsToContent(tree, mdle, ch.getDescription(tree), false, true));
+                usesTrees.put(t, commentTagsToContent(mdle, ch.getDescription(tree), false, true));
             }
         });
     }