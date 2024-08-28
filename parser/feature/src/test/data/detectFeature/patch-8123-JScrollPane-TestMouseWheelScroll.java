@@ -23,6 +23,8 @@
 import java.awt.Point;
 import java.awt.Robot;
 import java.awt.event.InputEvent;
+import java.awt.event.MouseWheelEvent;
+import java.awt.event.MouseWheelListener;
 import javax.swing.DefaultListModel;
 import javax.swing.ListModel;
 import javax.swing.JScrollPane;
@@ -35,7 +37,6 @@
 /*
  * @test
  * @key headful
- * @requires (os.family != "mac")
  * @bug  6911375
  * @summary Verifies mouseWheel effect on JList without scrollBar
  */
@@ -48,6 +49,7 @@ public class TestMouseWheelScroll {
     static volatile int height;
     static volatile Point viewPosition;
     static volatile Point newPosition;
+    static volatile int direction;
 
     private static void setLookAndFeel(UIManager.LookAndFeelInfo laf) {
         try {
@@ -82,6 +84,13 @@ public static void main(String[] args) throws Exception {
                     frame.setSize(200,200);
                     frame.setLocationRelativeTo(null);
                     frame.setVisible(true);
+                    scrollPane.addMouseWheelListener(new MouseWheelListener() {
+                        @Override
+                        public void mouseWheelMoved(MouseWheelEvent event) {
+                            System.out.println(event.getWheelRotation());
+                            direction = event.getWheelRotation();
+                        }
+                    });
                 });
                 robot.waitForIdle();
                 robot.delay(1000);
@@ -100,6 +109,9 @@ public static void main(String[] args) throws Exception {
                 robot.delay(1000);
                 robot.mouseWheel(1);
                 robot.delay(500);
+                if (direction == -1) {
+                    robot.mouseWheel(-1);
+                }
                 SwingUtilities.invokeAndWait(() -> {
                     newPosition = scrollPane.getViewport().getViewPosition();
                 });