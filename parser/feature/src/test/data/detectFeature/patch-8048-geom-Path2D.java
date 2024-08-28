@@ -70,7 +70,9 @@
  * @author Jim Graham
  * @since 1.6
  */
-public abstract class Path2D implements Shape, Cloneable {
+public abstract sealed class Path2D implements Shape, Cloneable
+    permits Path2D.Double,
+            Path2D.Float   {
     /**
      * An even-odd winding rule for determining the interior of
      * a path.
@@ -191,7 +193,7 @@ static byte[] expandPointTypes(byte[] oldPointTypes, int needed) {
      *
      * @since 1.6
      */
-    public static class Float extends Path2D implements Serializable {
+    public static non-sealed class Float extends Path2D implements Serializable {
         transient float[] floatCoords;
 
         /**
@@ -1093,7 +1095,7 @@ public int currentSegment(double[] coords) {
      *
      * @since 1.6
      */
-    public static class Double extends Path2D implements Serializable {
+    public static non-sealed class Double extends Path2D implements Serializable {
         transient double[] doubleCoords;
 
         /**