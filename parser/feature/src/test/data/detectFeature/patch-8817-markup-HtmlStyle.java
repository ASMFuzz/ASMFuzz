@@ -655,11 +655,6 @@ public enum HtmlStyle {
     //
     // The following constants are used for items in the static and interactive search indexes.
 
-    /**
-     * The class for a {@code button} in the search page to copy the search URL to the clipboard.
-     */
-    copyUrl,
-
     /**
      * The class for a {@code details} element in the search page to show additional information.
      */
@@ -915,6 +910,11 @@ public enum HtmlStyle {
      */
     classUses,
 
+    /**
+     * The class for a {@code button} element to copy some page content to the clipboard.
+     */
+    copy,
+
     /**
      * The class of an {@code a} element for a link with an external target.
      */