@@ -97,8 +97,11 @@ public static void main(String[] args) throws Exception {
             robot.mouseMove(cx, cy);
             robot.waitForIdle();
             Color color = robot.getPixelColor(cx - OFFSET_X, cy - OFFSET_Y);
+            int tolerance = 7;
 
-            if (!FRAME_COLOR.equals(color)) {
+            if ((Math.abs(FRAME_COLOR.getRed() - color.getRed()) > tolerance) ||
+                 (Math.abs(FRAME_COLOR.getBlue() - color.getBlue()) > tolerance) ||
+                 (Math.abs(FRAME_COLOR.getGreen() - color.getGreen()) > tolerance)) {
                 System.out.println("cx " + cx + " cy " + cy);
                 System.err.println("FRAME_COLOR Red: " + FRAME_COLOR.getRed() + "; Green: " + FRAME_COLOR.getGreen() + "; Blue: " + FRAME_COLOR.getBlue());
                 System.err.println("Pixel color Red: " + color.getRed() + "; Green: " + color.getGreen() + "; Blue: " + color.getBlue());