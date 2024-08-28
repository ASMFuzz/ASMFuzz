@@ -278,6 +278,16 @@ public interface TreeVisitor<R,P> {
     @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
     R visitDefaultCaseLabel(DefaultCaseLabelTree node, P p);
 
+    /**
+     * Visits a {@code DeconstructionPatternTree} node.
+     * @param node the node being visited
+     * @param p a parameter value
+     * @return a result value
+     * @since 19
+     */
+    @PreviewFeature(feature=PreviewFeature.Feature.RECORD_PATTERNS, reflective=true)
+    R visitDeconstructionPattern(DeconstructionPatternTree node, P p);
+
     /**
      * Visits a {@code MethodTree} node.
      * @param node the node being visited