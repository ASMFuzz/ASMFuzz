@@ -1362,7 +1362,8 @@ protected int getDividerBorderSize() {
      * LayoutManager for JSplitPanes that have an orientation of
      * HORIZONTAL_SPLIT.
      */
-    public class BasicHorizontalLayoutManager implements LayoutManager2
+    public sealed class BasicHorizontalLayoutManager implements LayoutManager2
+         permits BasicVerticalLayoutManager
     {
         /* left, right, divider. (in this exact order) */
         /**
@@ -2142,7 +2143,7 @@ else if (rValid) {
      * VERTICAL_SPLIT.
      *
      */
-    public class BasicVerticalLayoutManager extends
+    public non-sealed class BasicVerticalLayoutManager extends
             BasicHorizontalLayoutManager
     {
         /**