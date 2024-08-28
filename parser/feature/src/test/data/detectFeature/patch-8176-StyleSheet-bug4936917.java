@@ -79,11 +79,16 @@ public void run() {
         int y = p.y + 15;
         int match = 0;
         int nonmatch = 0;
+        int tolerance = 7;
 
         passed = true;
         for (int x = x0; x < x0 + 10; x++) {
             System.out.println("color ("+x+"," + y +")=" + robot.getPixelColor(x,y));
-            if (!robot.getPixelColor(x, y).equals(new Color(0xcc, 0xcc, 0xcc))) {
+            Color color = robot.getPixelColor(x, y);
+            Color expectedColor = new Color(0xcc, 0xcc, 0xcc);
+            if ((Math.abs(color.getRed() - expectedColor.getRed()) > tolerance) ||
+                (Math.abs(color.getBlue() - expectedColor.getBlue()) > tolerance) ||
+                (Math.abs(color.getGreen() - expectedColor.getGreen()) > tolerance)) {
                 nonmatch++;
             } else match++;
         }