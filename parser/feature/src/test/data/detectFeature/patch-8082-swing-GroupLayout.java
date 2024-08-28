@@ -1479,7 +1479,10 @@ final boolean isResizable(int axis) {
      * @see #createParallelGroup
      * @since 1.6
      */
-    public abstract class Group extends Spring {
+    public abstract sealed class Group extends Spring
+        permits ParallelGroup,
+                SequentialGroup {
+
         // private int origin;
         // private int size;
         List<Spring> springs;
@@ -1758,7 +1761,7 @@ boolean willHaveZeroSize(boolean treatAutopaddingAsZeroSized) {
      * @see #createSequentialGroup
      * @since 1.6
      */
-    public class SequentialGroup extends Group {
+    public final class SequentialGroup extends Group {
         private Spring baselineSpring;
 
         SequentialGroup() {
@@ -2454,7 +2457,9 @@ public String toString() {
      * @see #createBaselineGroup(boolean,boolean)
      * @since 1.6
      */
-    public class ParallelGroup extends Group {
+    public sealed class ParallelGroup extends Group
+         permits BaselineGroup {
+
         // How children are layed out.
         private final Alignment childAlignment;
         // Whether or not we're resizable.
@@ -2654,7 +2659,7 @@ private void checkChildAlignment(Alignment alignment,
      * An extension of {@code ParallelGroup} that aligns its
      * constituent {@code Spring}s along the baseline.
      */
-    private class BaselineGroup extends ParallelGroup {
+    private final class BaselineGroup extends ParallelGroup {
         // Whether or not all child springs have a baseline
         private boolean allSpringsHaveBaseline;
 