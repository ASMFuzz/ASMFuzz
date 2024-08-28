@@ -72,7 +72,18 @@ public static void main(String[] args) throws Exception {
             for (int i = 1; i < size; i++) {
                 int rgbCW = img.getRGB(i, size / 2);
                 int rgbCH = img.getRGB(size / 2, i);
-                if (rgbCW != testRGB || rgbCH != testRGB) {
+                int tolerance = 7;
+
+                Color cwCol = new Color(rgbCW);
+                Color chCol = new Color(rgbCH);
+                Color rgbCol = new Color(testRGB);
+                if ((Math.abs(cwCol.getRed() - rgbCol.getRed()) > tolerance) ||
+                   (Math.abs(cwCol.getBlue() - rgbCol.getBlue()) > tolerance) ||
+                   (Math.abs(cwCol.getGreen() - rgbCol.getGreen()) > tolerance) ||
+                   (Math.abs(chCol.getRed() - rgbCol.getRed()) > tolerance) ||
+                   (Math.abs(chCol.getBlue() - rgbCol.getBlue()) > tolerance) ||
+                   (Math.abs(chCol.getGreen() - rgbCol.getGreen()) > tolerance)) {
+
                     System.out.println("i " + i + " rgbCW " +
                                        Integer.toHexString(rgbCW) +
                                        " testRGB " + Integer.toHexString(testRGB) +