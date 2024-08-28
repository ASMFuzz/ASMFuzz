@@ -240,6 +240,7 @@ public enum Feature {
         PATTERN_SWITCH(JDK17, Fragments.FeaturePatternSwitch, DiagKind.PLURAL),
         REDUNDANT_STRICTFP(JDK17),
         UNCONDITIONAL_PATTERN_IN_INSTANCEOF(JDK19, Fragments.FeatureUnconditionalPatternsInInstanceof, DiagKind.PLURAL),
+        RECORD_PATTERNS(JDK19, Fragments.FeatureDeconstructionPatterns, DiagKind.PLURAL),
         ;
 
         enum DiagKind {