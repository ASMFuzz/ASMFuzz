@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,71 +25,88 @@
  * @test
  * @key headful
  * @bug 6276087
- * @author Romain Guy
  * @summary Tests opacity of a popup menu.
  */
-import java.awt.*;
-import java.awt.event.*;
-
-import javax.swing.*;
+import java.awt.Point;
+import java.awt.Dimension;
+import java.awt.Robot;
+import java.awt.event.InputEvent;
+
+import javax.swing.JFrame;
+import javax.swing.JMenu;
+import javax.swing.JMenuBar;
+import javax.swing.JMenuItem;
+import javax.swing.SwingUtilities;
 import static javax.swing.UIManager.LookAndFeelInfo;
 import static javax.swing.UIManager.getInstalledLookAndFeels;
 import static javax.swing.UIManager.setLookAndFeel;
 
-public class NonOpaquePopupMenuTest extends JFrame {
+public class NonOpaquePopupMenuTest {
 
     private static JMenu fileMenu;
+    private static JFrame frame;
     private static final String AQUALAF="com.apple.laf.AquaLookAndFeel";
+    private volatile static Point p;
+    private volatile static Dimension size;
 
-    public NonOpaquePopupMenuTest() {
-        getContentPane().setBackground(java.awt.Color.RED);
+    private static void createUI() {
+        frame = new JFrame();
+        frame.getContentPane().setBackground(java.awt.Color.RED);
         JMenuBar menuBar = new JMenuBar();
         fileMenu = new JMenu("File");
         JMenuItem menuItem = new JMenuItem("New");
         menuBar.add(fileMenu);
-        setJMenuBar(menuBar);
+        frame.setJMenuBar(menuBar);
 
         fileMenu.add(menuItem);
         fileMenu.getPopupMenu().setOpaque(false);
 
-        setSize(new Dimension(640, 480));
-        setLocationRelativeTo(null);
-        setVisible(true);
+        frame.setSize(new Dimension(640, 480));
+        frame.setLocationRelativeTo(null);
+        frame.setVisible(true);
     }
 
     public static void main(String[] args) throws Throwable {
         LookAndFeelInfo[] lookAndFeelInfoArray = getInstalledLookAndFeels();
+        Robot robot = new Robot();
+        robot.setAutoDelay(100);
 
         for (LookAndFeelInfo lookAndFeelInfo : lookAndFeelInfoArray) {
-            System.out.println(lookAndFeelInfo.getClassName());
-            if ( AQUALAF == lookAndFeelInfo.getClassName()) {
-                System.out.println("This test scenario is not applicable for" +
-                        " Aqua LookandFeel and hence skipping the validation");
-                continue;
-            }
-            setLookAndFeel(lookAndFeelInfo.getClassName());
-            Robot robot = new Robot();
-            robot.setAutoDelay(250);
-
-            SwingUtilities.invokeAndWait(new Runnable() {
-
-                @Override
-                public void run() {
-                    new NonOpaquePopupMenuTest();
+            try {
+                System.out.println(lookAndFeelInfo.getClassName());
+                if ( AQUALAF == lookAndFeelInfo.getClassName()) {
+                    System.out.println("This test scenario is not applicable for" +
+                            " Aqua LookandFeel and hence skipping the validation");
+                    continue;
                 }
-            });
+                robot.delay(1000);
+                setLookAndFeel(lookAndFeelInfo.getClassName());
+
+                SwingUtilities.invokeAndWait(() -> createUI());
 
-            robot.waitForIdle();
+                robot.waitForIdle();
+                robot.delay(1000);
 
-            Point p = getMenuClickPoint();
-            robot.mouseMove(p.x, p.y);
-            robot.mousePress(InputEvent.BUTTON1_MASK);
-            robot.mouseRelease(InputEvent.BUTTON1_MASK);
+                SwingUtilities.invokeAndWait(() -> {
+                    p = fileMenu.getLocationOnScreen();
+                    size = fileMenu.getSize();
+                });
+                robot.mouseMove(p.x + size.width / 2, p.y + size.height / 2);
+                robot.waitForIdle();
+                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
+                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
 
-            robot.waitForIdle();
+                robot.waitForIdle();
 
-            if (isParentOpaque()) {
-                throw new RuntimeException("Popup menu parent is opaque");
+                if (isParentOpaque()) {
+                    throw new RuntimeException("Popup menu parent is opaque");
+                }
+            } finally {
+                SwingUtilities.invokeAndWait(() -> {
+                    if (frame != null) {
+                        frame.dispose();
+                    }
+                });
             }
         }
     }
@@ -107,23 +124,4 @@ public void run() {
 
         return result[0];
     }
-
-    private static Point getMenuClickPoint() throws Exception {
-        final Point[] result = new Point[1];
-
-        SwingUtilities.invokeAndWait(new Runnable() {
-
-            @Override
-            public void run() {
-                Point p = fileMenu.getLocationOnScreen();
-                Dimension size = fileMenu.getSize();
-
-                result[0] = new Point(p.x + size.width / 2,
-                        p.y + size.height / 2);
-            }
-        });
-
-        return result[0];
-
-    }
 }