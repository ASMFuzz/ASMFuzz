@@ -35,22 +35,44 @@
 
 import test.java.awt.regtesthelpers.Util;
 
-import javax.swing.*;
-import java.awt.*;
-import java.awt.datatransfer.*;
-import java.awt.dnd.*;
+import java.awt.Color;
+import java.awt.Cursor;
+import java.awt.Dimension;
+import java.awt.Frame;
+import java.awt.Panel;
+import java.awt.Point;
+import java.awt.Rectangle;
+import java.awt.Robot;
+import java.awt.Toolkit;
+import java.awt.datatransfer.StringSelection;
+import java.awt.dnd.DnDConstants;
+import java.awt.dnd.DragGestureEvent;
+import java.awt.dnd.DragGestureListener;
+import java.awt.dnd.DragSource;
+import java.awt.dnd.DropTarget;
+import java.awt.dnd.DropTargetAdapter;
+import java.awt.dnd.DropTargetDropEvent;
 import java.awt.event.InputEvent;
+import java.io.File;
+import java.io.IOException;
+import java.util.concurrent.CountDownLatch;
+import java.util.concurrent.TimeUnit;
+import java.util.concurrent.atomic.AtomicReference;
+import javax.imageio.ImageIO;
+import javax.swing.SwingUtilities;
 
 public class AcceptDropMultipleTimes {
 
     private static final int FRAME_SIZE = 100;
-    private static final int FRAME_LOCATION = 100;
+    private static CountDownLatch dropCompleteLatch = new CountDownLatch(1);
 
     private static volatile Frame f;
 
     private static void initAndShowUI() {
         f = new Frame("Test frame");
-        f.setBounds(FRAME_LOCATION, FRAME_LOCATION, FRAME_SIZE, FRAME_SIZE);
+        f.setSize(FRAME_SIZE, FRAME_SIZE);
+        f.setLocationRelativeTo(null);
+        f.setUndecorated(true);
 
         final DraggablePanel dragSource = new DraggablePanel();
         dragSource.setBackground(Color.yellow);
@@ -63,11 +85,12 @@ private static void initAndShowUI() {
                 dtde.acceptDrop(DnDConstants.ACTION_MOVE);
 
                 dtde.dropComplete(true);
+                dropCompleteLatch.countDown();
             }
         });
         dragSource.setDropTarget(dt);
         f.add(dragSource);
-
+        f.setAlwaysOnTop(true);
         f.setVisible(true);
     }
 
@@ -77,19 +100,37 @@ public static void main(String[] args) throws Throwable {
             SwingUtilities.invokeAndWait(() -> initAndShowUI());
 
             Robot r = new Robot();
+            r.setAutoDelay(50);
             Util.waitForIdle(r);
+            final AtomicReference<Point> frameLoc = new AtomicReference<>();
+            SwingUtilities.invokeAndWait(() -> frameLoc.set(f.getLocationOnScreen()));
+            Point loc = frameLoc.get();
             Util.drag(r,
-                    new Point(FRAME_LOCATION + FRAME_SIZE / 3, FRAME_LOCATION + FRAME_SIZE / 3),
-                    new Point(FRAME_LOCATION + FRAME_SIZE / 3 * 2, FRAME_LOCATION + FRAME_SIZE / 3 * 2),
-                    InputEvent.BUTTON1_MASK);
+                    new Point(loc.x + FRAME_SIZE / 3, loc.y + FRAME_SIZE / 3),
+                    new Point(loc.x + FRAME_SIZE / 3 * 2, loc.y + FRAME_SIZE / 3 * 2),
+                    InputEvent.BUTTON1_DOWN_MASK);
             Util.waitForIdle(r);
+            if(!dropCompleteLatch.await(10, TimeUnit.SECONDS)) {
+                captureScreen(r);
+                throw new RuntimeException("Waited too long, but the drop is not completed");
+            }
         } finally {
             if (f != null) {
                 f.dispose();
             }
         }
     }
-
+    private static void captureScreen(Robot r) {
+        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
+        try {
+            ImageIO.write(
+                    r.createScreenCapture(new Rectangle(0, 0, screenSize.width, screenSize.height)),
+                    "png",
+                    new File("FailedScreenImage.png")
+                         );
+        } catch (IOException ignore) {
+        }
+    }
     private static class DraggablePanel extends Panel implements DragGestureListener {
 
         public DraggablePanel() {