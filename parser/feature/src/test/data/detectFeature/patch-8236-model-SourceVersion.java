@@ -351,7 +351,15 @@ public enum SourceVersion {
      *
      * @since 19
      */
-    RELEASE_19;
+    RELEASE_19,
+
+    /**
+     * The version recognized by the Java Platform, Standard Edition
+     * 20.
+     *
+     * @since 20
+     */
+    RELEASE_20;
 
     // Note that when adding constants for newer releases, the
     // behavior of latest() and latestSupported() must be updated too.
@@ -360,7 +368,7 @@ public enum SourceVersion {
      * {@return the latest source version that can be modeled}
      */
     public static SourceVersion latest() {
-        return RELEASE_19;
+        return RELEASE_20;
     }
 
     private static final SourceVersion latestSupported = getLatestSupported();
@@ -375,7 +383,7 @@ public static SourceVersion latest() {
     private static SourceVersion getLatestSupported() {
         int intVersion = Runtime.version().feature();
         return (intVersion >= 11) ?
-            valueOf("RELEASE_" + Math.min(19, intVersion)):
+            valueOf("RELEASE_" + Math.min(20, intVersion)):
             RELEASE_10;
     }
 