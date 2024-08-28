@@ -1832,7 +1832,7 @@ void empty() {
      * is maintained according to the CSS attributes.
      */
     @SuppressWarnings("serial") // Same-version serialization only
-    public static class BoxPainter implements Serializable {
+    public static final class BoxPainter implements Serializable {
 
         BoxPainter(AttributeSet a, CSS css, StyleSheet ss) {
             this.ss = ss;
@@ -2093,7 +2093,7 @@ float getOrientationMargin(HorizontalMargin side, float cssMargin,
      * are being cached.
      */
     @SuppressWarnings("serial") // Same-version serialization only
-    public static class ListPainter implements Serializable {
+    public static final class ListPainter implements Serializable {
 
         ListPainter(AttributeSet attr, StyleSheet ss) {
             this.ss = ss;