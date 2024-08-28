@@ -244,6 +244,14 @@ public enum Kind {
         @PreviewFeature(feature=PreviewFeature.Feature.SWITCH_PATTERN_MATCHING, reflective=true)
         DEFAULT_CASE_LABEL(DefaultCaseLabelTree.class),
 
+        /**
+         * Used for instances of {@link DeconstructionPatternTree}.
+         *
+         * @since 19
+         */
+        @PreviewFeature(feature=PreviewFeature.Feature.RECORD_PATTERNS, reflective=true)
+        DECONSTRUCTION_PATTERN(DeconstructionPatternTree.class),
+
         /**
          * Used for instances of {@link PrimitiveTypeTree}.
          */