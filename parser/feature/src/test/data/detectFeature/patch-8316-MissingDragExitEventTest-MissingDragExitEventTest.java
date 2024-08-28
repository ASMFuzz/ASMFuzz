@@ -32,9 +32,14 @@
  * @author Sergey Bylokhov
  */
 
+import test.java.awt.regtesthelpers.Util;
+
 import java.awt.Color;
+import java.awt.Dimension;
 import java.awt.Point;
+import java.awt.Rectangle;
 import java.awt.Robot;
+import java.awt.Toolkit;
 import java.awt.dnd.DnDConstants;
 import java.awt.dnd.DropTarget;
 import java.awt.dnd.DropTargetAdapter;
@@ -44,13 +49,16 @@
 import java.awt.event.InputEvent;
 import java.awt.event.MouseAdapter;
 import java.awt.event.MouseEvent;
-
+import java.io.File;
+import java.io.IOException;
+import java.util.concurrent.CountDownLatch;
+import java.util.concurrent.TimeUnit;
+import java.util.concurrent.atomic.AtomicReference;
+import javax.imageio.ImageIO;
 import javax.swing.JFrame;
 import javax.swing.JTextArea;
 import javax.swing.SwingUtilities;
 
-import test.java.awt.regtesthelpers.Util;
-
 public class MissingDragExitEventTest {
 
     private static volatile JFrame frame;
@@ -59,23 +67,26 @@ public class MissingDragExitEventTest {
     private static boolean MOUSE_ENTERED;
     private static boolean MOUSE_EXIT_TD;
     private static boolean MOUSE_EXIT;
-    private static int SIZE = 300;
+    private static int SIZE = 100;
+    private static CountDownLatch dropCompleteLatch = new CountDownLatch(1);
 
     private static void initAndShowUI() {
         frame = new JFrame("Test frame");
-
+        frame.setUndecorated(true);
         frame.setSize(SIZE, SIZE);
         frame.setLocationRelativeTo(null);
         final JTextArea jta = new JTextArea();
         jta.setBackground(Color.RED);
         frame.add(jta);
         jta.setText("1234567890");
-        jta.setFont(jta.getFont().deriveFont(150f));
+        jta.setFont(jta.getFont().deriveFont(50f));
         jta.setDragEnabled(true);
         jta.selectAll();
         jta.setDropTarget(new DropTarget(jta, DnDConstants.ACTION_COPY,
                                          new TestdropTargetListener()));
         jta.addMouseListener(new TestMouseAdapter());
+        frame.pack();
+        frame.setAlwaysOnTop(true);
         frame.setVisible(true);
     }
 
@@ -92,25 +103,36 @@ public void run() {
                     initAndShowUI();
                 }
             });
-
-            final Point inside = new Point(frame.getLocationOnScreen());
-            inside.translate(20, SIZE / 2);
+            final AtomicReference<Point> insidePoint = new AtomicReference<>();
+            SwingUtilities.invokeAndWait(() -> insidePoint.set(frame.getLocationOnScreen()));
+            final Point inside = insidePoint.get();
+            inside.translate(2,20);
             final Point outer = new Point(inside);
-            outer.translate(-40, 0);
+            outer.translate(-20, 0);
             r.mouseMove(inside.x, inside.y);
-            r.mousePress(InputEvent.BUTTON1_MASK);
+            r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
             try {
                 for (int i = 0; i < 3; ++i) {
                     Util.mouseMove(r, inside, outer);
                     Util.mouseMove(r, outer, inside);
                 }
             } finally {
-                r.mouseRelease(InputEvent.BUTTON1_MASK);
+                r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             }
-            sleep(r);
 
-            if (FAILED || !MOUSE_ENTERED || !MOUSE_ENTERED_DT || !MOUSE_EXIT
-                    || !MOUSE_EXIT_TD) {
+            if (!dropCompleteLatch.await(10, TimeUnit.SECONDS)) {
+                captureScreen(r);
+                throw new RuntimeException(
+                        "Waited too long, but the drop is not completed");
+            }
+            if (FAILED || !MOUSE_ENTERED || !MOUSE_ENTERED_DT || !MOUSE_EXIT ||
+                !MOUSE_EXIT_TD) {
+                System.out.println(
+                        "Events, FAILED = " + FAILED + ", MOUSE_ENTERED = " +
+                        MOUSE_ENTERED + ", MOUSE_ENTERED_DT = " +
+                        MOUSE_ENTERED_DT + ", MOUSE_EXIT = " + MOUSE_EXIT +
+                        ", MOUSE_EXIT_TD = " + MOUSE_EXIT_TD);
+                captureScreen(r);
                 throw new RuntimeException("Failed");
             }
         } finally {
@@ -120,12 +142,14 @@ public void run() {
         }
     }
 
-    private static void sleep(Robot robot) {
+    private static void captureScreen(Robot r) {
+        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         try {
-            Thread.sleep(10000);
-        } catch (InterruptedException ignored) {
+            ImageIO.write(r.createScreenCapture(
+                    new Rectangle(0, 0, screenSize.width, screenSize.height)),
+                          "png", new File("FailedScreenImage.png"));
+        } catch (IOException ignore) {
         }
-        robot.waitForIdle();
     }
 
     static class TestdropTargetListener extends DropTargetAdapter {
@@ -140,10 +164,6 @@ public void dragEnter(final DropTargetDragEvent dtde) {
             }
             inside = true;
             MOUSE_ENTERED_DT = true;
-            try {
-                Thread.sleep(10000); // we should have time to leave a component
-            } catch (InterruptedException ignored) {
-            }
         }
 
         @Override
@@ -162,6 +182,7 @@ public void dragExit(final DropTargetEvent dte) {
             }
             inside = false;
             MOUSE_EXIT_TD = true;
+            System.out.println("Drag exit");
         }
 
         @Override
@@ -171,6 +192,8 @@ public void drop(final DropTargetDropEvent dtde) {
                 Thread.dumpStack();
             }
             inside = false;
+            System.out.println("Drop complete");
+            dropCompleteLatch.countDown();
         }
     }
 
@@ -190,6 +213,7 @@ public void mouseEntered(final MouseEvent e) {
 
         @Override
         public void mouseExited(final MouseEvent e) {
+            System.out.println( "Mouse exit");
             if (!inside) {
                 FAILED = true;
                 Thread.dumpStack();