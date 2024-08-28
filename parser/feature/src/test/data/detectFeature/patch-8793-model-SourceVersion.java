@@ -66,7 +66,8 @@ public enum SourceVersion {
      *  17: sealed classes, floating-point always strict (pattern
      *      matching for switch in preview)
      *  18: no changes (pattern matching for switch in second preview)
-     *  19: TBD
+     *  19: no changes (pattern matching for switch in third preview,
+     *      record patterns in preview)
      */
 
     /**
@@ -346,6 +347,8 @@ public enum SourceVersion {
      * The version recognized by the Java Platform, Standard Edition
      * 19.
      *
+     * No major changes from the prior release.
+     *
      * @since 19
      */
     RELEASE_19;