@@ -800,6 +800,24 @@ public R visitDefaultCaseLabel(DefaultCaseLabelTree node, P p) {
      * @param node  {@inheritDoc}
      * @param p  {@inheritDoc}
      * @return the result of scanning
+     * @since 19
+     */
+    @Override
+    @PreviewFeature(feature=PreviewFeature.Feature.RECORD_PATTERNS, reflective=true)
+    public R visitDeconstructionPattern(DeconstructionPatternTree node, P p) {
+        R r = scan(node.getDeconstructor(), p);
+        r = scanAndReduce(node.getNestedPatterns(), p, r);
+        r = scanAndReduce(node.getVariable(), p, r);
+        r = scanAndReduce(node.getGuard(), p, r);
+        return r;
+    }
+
+    /**
+     * {@inheritDoc} This implementation scans the children in left to right order.
+     *
+     * @param node  {@inheritDoc}
+     * @param p  {@inheritDoc}
+     * @return the result of scanning
      */
     @Override
     public R visitArrayAccess(ArrayAccessTree node, P p) {