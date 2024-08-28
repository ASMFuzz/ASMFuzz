@@ -39,7 +39,9 @@
  * @author Nicholas Talian, Vincent Hardy, Jim Graham, Jerry Evans
  * @since 1.6
  */
-public abstract class MultipleGradientPaint implements Paint {
+public abstract sealed class MultipleGradientPaint implements Paint
+    permits LinearGradientPaint,
+            RadialGradientPaint {
 
     /** The method to use when painting outside the gradient bounds.
      * @since 1.6