@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,18 +31,29 @@
 */
 
 
-import java.awt.*;
-import java.awt.event.InputEvent;
-import java.awt.geom.*;
+import java.awt.Color;
+import java.awt.EventQueue;
+import java.awt.Frame;
+import java.awt.Graphics;
+import java.awt.Point;
+import java.awt.Rectangle;
+import java.awt.Robot;
+import java.awt.geom.Area;
+import java.awt.geom.Ellipse2D;
+import java.awt.geom.Rectangle2D;
 
 
 public class ShapeNotSetSometimes {
 
     private Frame backgroundFrame;
     private Frame window;
-    private static final Color BACKGROUND_COLOR = Color.BLUE;
-    private Shape shape;
-    private int[][] pointsToCheck;
+    private static final Color BACKGROUND_COLOR = Color.GREEN;
+    private static final Color SHAPE_COLOR = Color.WHITE;
+    private Point[] pointsOutsideToCheck;
+    private Point[] shadedPointsToCheck;
+    private Point innerPoint;
+
+    private final Rectangle bounds = new Rectangle(220, 400, 300, 300);
 
     private static Robot robot;
 
@@ -54,43 +65,39 @@ public ShapeNotSetSometimes() throws Exception {
     private void initializeGUI() {
         backgroundFrame = new BackgroundFrame();
         backgroundFrame.setUndecorated(true);
-        backgroundFrame.setSize(300, 300);
-        backgroundFrame.setLocation(20, 400);
+        backgroundFrame.setBounds(bounds);
         backgroundFrame.setVisible(true);
 
-        shape = null;
-        String shape_name = null;
-        Area a;
-        GeneralPath gp;
-        shape_name = "Rounded-corners";
-        a = new Area();
-        a.add(new Area(new Rectangle2D.Float(50, 0, 100, 150)));
-        a.add(new Area(new Rectangle2D.Float(0, 50, 200, 50)));
-        a.add(new Area(new Ellipse2D.Float(0, 0, 100, 100)));
-        a.add(new Area(new Ellipse2D.Float(0, 50, 100, 100)));
-        a.add(new Area(new Ellipse2D.Float(100, 0, 100, 100)));
-        a.add(new Area(new Ellipse2D.Float(100, 50, 100, 100)));
-        shape = a;
-        pointsToCheck = new int[][] {
-            // inside shape
-            {106, 86}, {96, 38}, {76, 107}, {180, 25}, {24, 105},
-            {196, 77}, {165, 50}, {14, 113}, {89, 132}, {167, 117},
-            // outside shape
-            {165, 196}, {191, 163}, {146, 185}, {61, 170}, {148, 171},
-            {82, 172}, {186, 11}, {199, 141}, {13, 173}, {187, 3}
+        Area area = new Area();
+        area.add(new Area(new Rectangle2D.Float(100, 50, 100, 150)));
+        area.add(new Area(new Rectangle2D.Float(50, 100, 200, 50)));
+        area.add(new Area(new Ellipse2D.Float(50, 50, 100, 100)));
+        area.add(new Area(new Ellipse2D.Float(50, 100, 100, 100)));
+        area.add(new Area(new Ellipse2D.Float(150, 50, 100, 100)));
+        area.add(new Area(new Ellipse2D.Float(150, 100, 100, 100)));
+
+
+        innerPoint = new Point(150, 130);
+        pointsOutsideToCheck = new Point[] {
+                new Point(150, 20),
+                new Point(280, 120),
+                new Point(150, 250),
+                new Point(20, 120)
+        };
+
+        shadedPointsToCheck = new Point[] {
+                new Point(62, 62),
+                new Point(240, 185)
         };
 
         window = new TestFrame();
         window.setUndecorated(true);
-        window.setSize(200, 200);
-        window.setLocation(70, 450);
-        window.setShape(shape);
+        window.setBounds(bounds);
+        window.setShape(area);
         window.setVisible(true);
-
-        System.out.println("Checking " + window.getClass().getSuperclass().getName() + " with " + shape_name + " shape (" + window.getShape() + ")...");
     }
 
-    class BackgroundFrame extends Frame {
+    static class BackgroundFrame extends Frame {
 
         @Override
         public void paint(Graphics g) {
@@ -107,8 +114,8 @@ class TestFrame extends Frame {
         @Override
         public void paint(Graphics g) {
 
-            g.setColor(Color.WHITE);
-            g.fillRect(0, 0, 200, 200);
+            g.setColor(SHAPE_COLOR);
+            g.fillRect(0, 0, bounds.width, bounds.height);
 
             super.paint(g);
         }
@@ -124,48 +131,58 @@ public static void main(String[] args) throws Exception {
     }
 
     private void doTest() throws Exception {
-        Point wls = backgroundFrame.getLocationOnScreen();
+        EventQueue.invokeAndWait(backgroundFrame::toFront);
+        robot.waitForIdle();
 
-        robot.mouseMove(wls.x + 5, wls.y + 5);
-        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
-        robot.delay(10);
-        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
-        robot.delay(500);
+        EventQueue.invokeAndWait(window::toFront);
+        robot.waitForIdle();
 
-        EventQueue.invokeAndWait(window::requestFocus);
+        robot.delay(500);
 
-        robot.waitForIdle();
         try {
-            Thread.sleep(300);
-        } catch (InterruptedException e) {
-            // ignore this one
-        }
+            colorCheck(innerPoint.x, innerPoint.y, SHAPE_COLOR, true);
 
-        // check transparency
-        final int COUNT_TARGET = 10;
-
-        // checking outside points only
-        for(int i = COUNT_TARGET; i < COUNT_TARGET * 2; i++) {
-            int x = pointsToCheck[i][0];
-            int y = pointsToCheck[i][1];
-            boolean inside = i < COUNT_TARGET;
-            Color c = robot.getPixelColor(window.getX() + x, window.getY() + y);
-            System.out.println("checking " + x + ", " + y + ", color = " + c);
-            if (inside && BACKGROUND_COLOR.equals(c) || !inside && !BACKGROUND_COLOR.equals(c)) {
-                System.out.println("window.getX() = " + window.getX() + ", window.getY() = " + window.getY());
-                System.err.println("Checking for transparency failed: point: " +
-                        (window.getX() + x) + ", " + (window.getY() + y) +
-                        ", color = " + c + (inside ? " is of un" : " is not of ") +
-                        "expected background color " + BACKGROUND_COLOR);
-                throw new RuntimeException("Test failed. The shape has not been applied.");
+            for (Point point : pointsOutsideToCheck) {
+                colorCheck(point.x, point.y, BACKGROUND_COLOR, true);
             }
-        }
 
-        EventQueue.invokeAndWait(new Runnable() {
-            public void run() {
+            for (Point point : shadedPointsToCheck) {
+                colorCheck(point.x, point.y, SHAPE_COLOR, false);
+            }
+        } finally {
+            EventQueue.invokeAndWait(() -> {
                 backgroundFrame.dispose();
                 window.dispose();
-            }
-        });
+            });
+        }
+    }
+
+    private void colorCheck(int x, int y, Color expectedColor, boolean mustBeExpectedColor) {
+
+        int screenX = window.getX() + x;
+        int screenY = window.getY() + y;
+
+        Color actualColor = robot.getPixelColor(screenX, screenY);
+
+        System.out.printf(
+                "Checking %3d, %3d, %35s should %sbe %35s\n",
+                x, y,
+                actualColor,
+                (mustBeExpectedColor) ? "" : "not ",
+                expectedColor
+        );
+
+        if (mustBeExpectedColor != expectedColor.equals(actualColor)) {
+            System.out.printf("window.getX() = %3d, window.getY() = %3d\n", window.getX(), window.getY());
+
+            System.err.printf(
+                    "Checking for transparency failed: point: %3d, %3d\n\tactual    %s\n\texpected %s%s\n",
+                    screenX,
+                    screenY,
+                    actualColor,
+                    mustBeExpectedColor ? "" : "not ",
+                    expectedColor);
+            throw new RuntimeException("Test failed. The shape has not been applied.");
+        }
     }
 }