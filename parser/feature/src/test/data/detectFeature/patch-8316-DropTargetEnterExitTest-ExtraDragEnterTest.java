@@ -35,8 +35,13 @@
 
 import test.java.awt.regtesthelpers.Util;
 
-import javax.swing.*;
-import java.awt.*;
+import java.awt.Color;
+import java.awt.Cursor;
+import java.awt.Frame;
+import java.awt.GridLayout;
+import java.awt.Panel;
+import java.awt.Point;
+import java.awt.Robot;
 import java.awt.datatransfer.StringSelection;
 import java.awt.dnd.DnDConstants;
 import java.awt.dnd.DragGestureEvent;
@@ -47,23 +52,27 @@
 import java.awt.dnd.DropTargetDragEvent;
 import java.awt.dnd.DropTargetDropEvent;
 import java.awt.event.InputEvent;
+import java.util.concurrent.CountDownLatch;
+import java.util.concurrent.TimeUnit;
 import java.util.concurrent.atomic.AtomicInteger;
+import javax.swing.SwingUtilities;
 
 public class ExtraDragEnterTest {
 
     private static final int FRAME_SIZE = 100;
-    private static final int FRAME_LOCATION = 100;
 
     private static AtomicInteger dragEnterCalled = new AtomicInteger(0);
 
     private static volatile Panel mainPanel;
     private static volatile Frame f;
+    private static CountDownLatch dropCompleteLatch = new CountDownLatch(1);
 
     private static void initAndShowUI() {
         f = new Frame("Test frame");
-        f.setBounds(FRAME_LOCATION,FRAME_LOCATION,FRAME_SIZE,FRAME_SIZE);
+        f.setLocationRelativeTo(null);
+        f.setSize(FRAME_SIZE,FRAME_SIZE);
         mainPanel = new Panel();
-        mainPanel.setBounds(0, 0, FRAME_SIZE, FRAME_SIZE);
+        mainPanel.setSize(FRAME_SIZE, FRAME_SIZE);
         mainPanel.setBackground(Color.black);
         mainPanel.setLayout(new GridLayout(2, 1));
 
@@ -75,7 +84,10 @@ private static void initAndShowUI() {
         Panel dropTarget = new Panel();
         dropTarget.setBackground(Color.red);
         DropTarget dt = new DropTarget(dropTarget, new DropTargetAdapter() {
-            @Override public void drop(DropTargetDropEvent dtde) { }
+            @Override public void drop(DropTargetDropEvent dtde) {
+                System.out.println("Drop complete");
+                dropCompleteLatch.countDown();
+            }
 
             @Override
             public void dragEnter(DropTargetDragEvent dtde) {
@@ -86,6 +98,7 @@ public void dragEnter(DropTargetDragEvent dtde) {
         mainPanel.add(dropTarget);
 
         f.add(mainPanel);
+        f.setAlwaysOnTop(true);
         f.setVisible(true);
     }
 
@@ -113,6 +126,9 @@ public void run() {
             if (called != 1) {
                 throw new RuntimeException("Failed. Drag enter called " + called + " times. Expected 1" );
             }
+            if(!dropCompleteLatch.await(10, TimeUnit.SECONDS)) {
+                throw new RuntimeException("Waited too long, but the drop is not completed");
+            }
         } finally {
             if (f != null) {
                 f.dispose();