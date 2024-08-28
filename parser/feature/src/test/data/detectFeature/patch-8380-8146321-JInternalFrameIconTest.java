@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,8 +26,6 @@
  * @key headful
  * @bug 8146321 8151282
  * @summary verifies JInternalFrame Icon and ImageIcon
- * @library ../../regtesthelpers
- * @build Util
  * @run main JInternalFrameIconTest
  */
 import java.io.File;
@@ -79,7 +77,7 @@ private static void executeCase(String lookAndFeelString) throws Exception {
             createImageIconUI(lookAndFeelString);
             robot.waitForIdle();
             robot.delay(1000);
-            getImageIconBufferedImage();
+            getImageIconBufferedImage(lookAndFeelString);
             robot.waitForIdle();
             robot.delay(1000);
             cleanUp();
@@ -89,7 +87,7 @@ private static void executeCase(String lookAndFeelString) throws Exception {
             createIconUI(lookAndFeelString);
             robot.waitForIdle();
             robot.delay(1000);
-            getIconBufferedImage();
+            getIconBufferedImage(lookAndFeelString);
             robot.waitForIdle();
             robot.delay(1000);
             cleanUp();
@@ -139,6 +137,7 @@ public void paintIcon(
                 frame.getContentPane().setLayout(new BorderLayout());
                 frame.getContentPane().add(desktopPane, "Center");
                 frame.setSize(500, 500);
+                frame.setUndecorated(true);
                 frame.setLocationRelativeTo(null);
                 frame.setVisible(true);
                 frame.toFront();
@@ -182,39 +181,54 @@ public void paintIcon(
                 frame.getContentPane().setLayout(new BorderLayout());
                 frame.getContentPane().add(desktopPane, "Center");
                 frame.setSize(500, 500);
+                frame.setUndecorated(true);
                 frame.setLocationRelativeTo(null);
                 frame.setVisible(true);
                 frame.toFront();
             }
         });
     }
 
-    private static void getImageIconBufferedImage() throws Exception {
+    private static void getImageIconBufferedImage(String lookAndFeelString) throws Exception {
         Point point = internalFrame.getLocationOnScreen();
         Rectangle rect = internalFrame.getBounds();
-        Rectangle captureRect = new Rectangle(
+        Rectangle captureRect = null;
+        if (lookAndFeelString.contains("Aqua")) {
+            captureRect = new Rectangle(
+                point.x + internalFrame.getInsets().left,
+                point.y + internalFrame.getInsets().top,
+                rect.width - internalFrame.getInsets().left - internalFrame.getInsets().right,
+                internalFrame.getInsets().top);
+        } else {
+            captureRect = new Rectangle(
                 point.x + internalFrame.getInsets().left,
                 point.y + internalFrame.getInsets().top,
                 titleImageIcon.getIconWidth(),
                 titleImageIcon.getIconHeight());
-
+        }
         System.out.println("imageicon captureRect " + captureRect);
-        imageIconImage
-                = robot.createScreenCapture(captureRect);
+        imageIconImage = robot.createScreenCapture(captureRect);
     }
 
-    private static void getIconBufferedImage() throws Exception {
+    private static void getIconBufferedImage(String lookAndFeelString) throws Exception {
         Point point = internalFrame.getLocationOnScreen();
         Rectangle rect = internalFrame.getBounds();
-        Rectangle captureRect = new Rectangle(
+        Rectangle captureRect = null;
+        if (lookAndFeelString.contains("Aqua")) {
+            captureRect = new Rectangle(
+                    point.x + internalFrame.getInsets().left,
+                    point.y + internalFrame.getInsets().top,
+                    rect.width - internalFrame.getInsets().left - internalFrame.getInsets().right,
+                    internalFrame.getInsets().top);
+        } else {
+            captureRect = new Rectangle(
                 point.x + internalFrame.getInsets().left,
                 point.y + internalFrame.getInsets().top,
                 titleIcon.getIconWidth(),
                 titleIcon.getIconHeight());
-
+        }
         System.out.println("icon captureRect " + captureRect);
-        iconImage
-                = robot.createScreenCapture(captureRect);
+        iconImage = robot.createScreenCapture(captureRect);
     }
 
     private static void testIfSame(final String lookAndFeelString)
@@ -225,7 +239,7 @@ private static void testIfSame(final String lookAndFeelString)
             String error ="[" + lookAndFeelString
                     + "] : ERROR: icon and imageIcon not same.";
             errorString += error;
-            System.err.println(error);
+            System.out.println(error);
         } else {
             System.out.println("[" + lookAndFeelString
                     + "] : SUCCESS: icon and imageIcon same.");
@@ -238,7 +252,7 @@ private static boolean bufferedImagesEqual(
 
         if (bufferedImage1.getWidth() == bufferedImage2.getWidth()
                 && bufferedImage1.getHeight() == bufferedImage2.getHeight()) {
-            final int colorTolerance = 25;
+            final int colorTolerance = 1;
             final int mismatchTolerance = (int) (0.1
                     * bufferedImage1.getWidth() * bufferedImage1.getHeight());
             int mismatchCounter = 0;