@@ -515,6 +515,23 @@ public R visitSnippet(SnippetTree node, P p) {
         return r;
     }
 
+    /**
+     * {@inheritDoc}
+     *
+     * @implSpec This implementation scans the children in left to right order.
+     *
+     * @param node {@inheritDoc}
+     * @param p    {@inheritDoc}
+     * @return the result of scanning
+     * @since 20
+     */
+    @Override
+    public R visitSpec(SpecTree node, P p) {
+        R r = scan(node.getURL(), p);
+        r = scanAndReduce(node.getTitle(), p, r);
+        return r;
+    }
+
     /**
      * {@inheritDoc}
      *