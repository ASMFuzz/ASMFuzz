@@ -387,6 +387,15 @@ public static HtmlTree DD(Content body) {
                 .add(body);
     }
 
+    /**
+     * Creates an HTML {@code DETAILS} element.
+     *
+     * @return the element
+     */
+    public static HtmlTree DETAILS() {
+        return new HtmlTree(TagName.DETAILS);
+    }
+
     /**
      * Creates an HTML {@code DETAILS} element.
      *