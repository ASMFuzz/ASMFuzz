@@ -35,8 +35,12 @@
 
 import test.java.awt.regtesthelpers.Util;
 
-import javax.swing.*;
-import java.awt.*;
+import java.awt.Color;
+import java.awt.Cursor;
+import java.awt.Frame;
+import java.awt.Panel;
+import java.awt.Point;
+import java.awt.Robot;
 import java.awt.datatransfer.StringSelection;
 import java.awt.dnd.DnDConstants;
 import java.awt.dnd.DragGestureEvent;
@@ -48,15 +52,17 @@
 import java.awt.dnd.DropTargetDropEvent;
 import java.awt.dnd.DropTargetEvent;
 import java.awt.event.InputEvent;
+import java.util.concurrent.CountDownLatch;
+import java.util.concurrent.TimeUnit;
+import javax.swing.SwingUtilities;
 
 public class MissedDragExitTest {
 
     private static final int FRAME_SIZE = 100;
     private static final int FRAME_LOCATION = 100;
 
-    private static volatile boolean dragExitCalled = false;
-
     private static volatile Frame f;
+    private static CountDownLatch dragLatch = new CountDownLatch(2);
 
     private static void initAndShowUI() {
         f = new Frame("Test frame");
@@ -70,21 +76,30 @@ private static void initAndShowUI() {
 
             @Override
             public void dragExit(DropTargetEvent dte) {
-                dragExitCalled = true;
+                System.out.println("Drag Exit");
+                dragLatch.countDown();
             }
 
             @Override
             public void dragOver(DropTargetDragEvent dtde) {
-                Panel newDropTarget = new Panel();
-                newDropTarget.setDropTarget(new DropTarget());
-                newDropTarget.setBackground(Color.red);
-                newDropTarget.setBounds(0, 0, FRAME_SIZE, FRAME_SIZE);
-                dragSource.add(newDropTarget);
+                Panel newDropTargetPanel = new Panel();
+                final DropTarget dropTarget = new DropTarget(null,new DropTargetAdapter() {
+                    @Override
+                    public void drop(DropTargetDropEvent dtde) {
+                        System.out.println("Drop complete");
+                        dragLatch.countDown();
+                    }
+                });
+                newDropTargetPanel.setDropTarget(dropTarget);
+                newDropTargetPanel.setBackground(Color.red);
+                newDropTargetPanel.setSize(FRAME_SIZE, FRAME_SIZE);
+                dragSource.add(newDropTargetPanel);
             }
         });
         dragSource.setDropTarget(dt);
         f.add(dragSource);
 
+        f.setAlwaysOnTop(true);
         f.setVisible(true);
     }
 
@@ -105,8 +120,7 @@ public void run() {
                     new Point(FRAME_LOCATION + FRAME_SIZE / 3 * 2, FRAME_LOCATION + FRAME_SIZE / 3 * 2),
                     InputEvent.BUTTON1_DOWN_MASK);
             Util.waitForIdle(r);
-
-            if (!dragExitCalled) {
+            if(!dragLatch.await(10, TimeUnit.SECONDS)) {
                 throw new RuntimeException("Failed. Drag exit was not called" );
             }
         } finally {