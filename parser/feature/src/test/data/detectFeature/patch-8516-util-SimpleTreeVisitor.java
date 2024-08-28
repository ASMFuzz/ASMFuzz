@@ -667,6 +667,20 @@ public R visitDefaultCaseLabel(DefaultCaseLabelTree node, P p) {
      * @param node {@inheritDoc}
      * @param p {@inheritDoc}
      * @return  the result of {@code defaultAction}
+     * @since 19
+     */
+    @Override
+    @PreviewFeature(feature=PreviewFeature.Feature.RECORD_PATTERNS, reflective=true)
+    public R visitDeconstructionPattern(DeconstructionPatternTree node, P p) {
+        return defaultAction(node, p);
+    }
+
+    /**
+     * {@inheritDoc} This implementation calls {@code defaultAction}.
+     *
+     * @param node {@inheritDoc}
+     * @param p {@inheritDoc}
+     * @return  the result of {@code defaultAction}
      */
     @Override
     public R visitArrayAccess(ArrayAccessTree node, P p) {