@@ -24,8 +24,7 @@
 /*
  * @test
  * @bug 8015854
- * @requires (os.family == "mac")
- * @summary Tests HTML image as JButton text for unwanted padding on macOS Aqua LAF
+ * @summary Tests HTML image as JButton text for unwanted padding
  * @run main HtmlButtonImageTest
  */
 
@@ -41,6 +40,7 @@
 import javax.swing.JButton;
 import javax.swing.SwingUtilities;
 import javax.swing.UIManager;
+import javax.swing.UnsupportedLookAndFeelException;
 
 import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
 
@@ -60,19 +60,38 @@ public final class HtmlButtonImageTest {
     private static final int maxX = centerX + (SQUARE_WIDTH / 2);
     private static final int maxY = centerY + (SQUARE_HEIGHT / 2);
 
+    private static boolean supportedLaf;
+    private static int failCount = 0;
+    private static String currentLaf = new String();
+    private static StringBuffer failedLafs = new StringBuffer();
+
+
     public static void main(String[] args) throws Exception {
-        UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
         testDir = Path.of(System.getProperty("test.classes", "."));
         generateRedSquare();
 
-        SwingUtilities.invokeAndWait(HtmlButtonImageTest::createButton);
-        SwingUtilities.invokeAndWait(HtmlButtonImageTest::paintButton);
+        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
+            SwingUtilities.invokeAndWait(() -> setLookAndFeel(laf));
+            if(supportedLaf) {
+                currentLaf = laf.getName();
+                SwingUtilities.invokeAndWait(HtmlButtonImageTest::createButton);
+                SwingUtilities.invokeAndWait(HtmlButtonImageTest::paintButton);
+
+                testImageCentering(image.getRGB(centerX, centerY),
+                        image.getRGB(minX, minY),
+                        image.getRGB(minX, maxY),
+                        image.getRGB(maxX, minY),
+                        image.getRGB(maxX, maxY));
+            }
+        }
 
-        testImageCentering(image.getRGB(centerX, centerY),
-                image.getRGB(minX, minY),
-                image.getRGB(minX, maxY),
-                image.getRGB(maxX, minY),
-                image.getRGB(maxX, maxY));
+        if(!failedLafs.isEmpty()) {
+            if(failCount > 1) {
+                failedLafs.setLength(failedLafs.length() - 2);
+            }
+            throw new RuntimeException("HTML image not centered in button " +
+                    "for these L&F's: " + failedLafs);
+        }
     }
 
     private static void generateRedSquare() throws IOException {
@@ -105,11 +124,22 @@ private static boolean checkRedColor(int rgb) {
     private static void testImageCentering(int... colors) throws IOException {
         for (int c : colors) {
             if (!checkRedColor(c)) {
-                ImageIO.write(image, "png",
-                        new File(testDir + "/fail_image.png"));
-                throw new RuntimeException("HTML image not centered in button");
+                failCount++;
+                ImageIO.write(image, "png", new File(testDir + "/fail_image_" +
+                        currentLaf.replaceAll("[^\\w\\s]","") + ".png"));
+                failedLafs.append(currentLaf + ", ");
+                break;
             }
         }
-        System.out.println("Passed");
+    }
+
+    private static void setLookAndFeel(UIManager.LookAndFeelInfo laf) {
+        try {
+            UIManager.setLookAndFeel(laf.getClassName());
+            supportedLaf = true;
+        } catch (UnsupportedLookAndFeelException | ClassNotFoundException |
+                InstantiationException | IllegalAccessException e) {
+            supportedLaf = false;
+        }
     }
 }