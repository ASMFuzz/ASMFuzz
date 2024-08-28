@@ -63,8 +63,10 @@ public enum SourceVersion {
      *  15: text blocks (sealed classes in preview; records and pattern
      *      matching in second preview)
      *  16: records and pattern matching (sealed classes in second preview)
-     *  17: sealed classes, floating-point always strict
-     *  18: TBD
+     *  17: sealed classes, floating-point always strict (pattern
+     *      matching for switch in preview)
+     *  18: no changes (pattern matching for switch in second preview)
+     *  19: TBD
      */
 
     /**
@@ -247,6 +249,8 @@ public enum SourceVersion {
      * The version recognized by the Java Platform, Standard Edition
      * 18.
      *
+     * No major changes from the prior release.
+     *
      * @since 18
      */
     RELEASE_18,