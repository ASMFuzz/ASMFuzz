@@ -2123,6 +2123,8 @@ static Rectangle2D getBounds2D(final PathIterator pi) {
         double lastY = 0.0;
         double endX = 0.0;
         double endY = 0.0;
+        double startX = 0.0;
+        double startY = 0.0;
 
         for (; !pi.isDone(); pi.next()) {
             final int type = pi.currentSegment(coords);
@@ -2131,8 +2133,8 @@ static Rectangle2D getBounds2D(final PathIterator pi) {
                     if (bounds == null) {
                         bounds = new double[] { coords[0], coords[0], coords[1], coords[1] };
                     }
-                    endX = coords[0];
-                    endY = coords[1];
+                    startX = endX = coords[0];
+                    startY = endY = coords[1];
                     break;
                 case PathIterator.SEG_LINETO:
                     endX = coords[0];
@@ -2147,6 +2149,9 @@ static Rectangle2D getBounds2D(final PathIterator pi) {
                     endY = coords[5];
                     break;
                 case PathIterator.SEG_CLOSE:
+                    endX = startX;
+                    endY = startY;
+                    break;
                 default:
                     continue;
             }