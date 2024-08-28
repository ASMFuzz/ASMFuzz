@@ -49,6 +49,7 @@
 public class DisposeFrameOnDragTest {
 
     private static JTextArea textArea;
+    private static JFrame background;
 
     public static void main(String[] args) throws Throwable {
 
@@ -72,14 +73,20 @@ public void run() {
         Util.drag(testRobot,
                 new Point((int) loc.x + 3, (int) loc.y + 3),
                 new Point((int) loc.x + 40, (int) loc.y + 40),
-                InputEvent.BUTTON1_MASK);
+                InputEvent.BUTTON1_DOWN_MASK);
 
         Util.waitForIdle(testRobot);
 
         testRobot.delay(200);
+        background.dispose();
     }
 
     private static void constructTestUI() {
+        background = new JFrame("Background");
+        background.setBounds(100, 100, 100, 100);
+        background.setUndecorated(true);
+        background.setVisible(true);
+
         final JFrame frame = new JFrame("Test frame");
         textArea = new JTextArea("Drag Me!");
         try {