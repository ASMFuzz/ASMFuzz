@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,15 +25,15 @@
  * @test
  * @key headful
  * @bug     8073001 8081764
+ * @requires (os.family == "mac")
  * @summary Test verifies that combo box with custom editor renders
  *          focus ring around arrow button correctly.
- * @library /test/lib
- * @build jdk.test.lib.Platform
  * @run     main CustomComboBoxFocusTest
  */
 
 import java.awt.AWTException;
 import java.awt.Component;
+import java.awt.Color;
 import java.awt.GridLayout;
 import java.awt.Point;
 import java.awt.Rectangle;
@@ -55,29 +55,24 @@
 import javax.swing.JTextField;
 import javax.swing.SwingUtilities;
 
-import jdk.test.lib.Platform;
-
 public class CustomComboBoxFocusTest {
 
     private static CustomComboBoxFocusTest test = null;
+    static int colorTolerance = 5;
 
-    public static void main(String[] args) {
-        if (!Platform.isOSX()) {
+    public static void main(String[] args) throws Exception {
+        if (!System.getProperty("os.name").toLowerCase().contains("os x")) {
             System.out.println("Only Mac platform test. Test is skipped for other OS.");
             return;
         }
 
-        try {
-            SwingUtilities.invokeAndWait(new Runnable() {
-                public void run() {
-                    test = new CustomComboBoxFocusTest();
-                }
-            });
-        } catch (InterruptedException | InvocationTargetException e ) {
-            throw new RuntimeException("Test failed.", e);
-        }
+        SwingUtilities.invokeAndWait(new Runnable() {
+            public void run() {
+                test = new CustomComboBoxFocusTest();
+            }
+        });
 
-        SwingUtilities.invokeLater(test.init);
+        SwingUtilities.invokeAndWait(test.init);
 
         try {
             System.out.println("Wait for screenshots...");
@@ -130,7 +125,23 @@ private boolean match() {
 
         for (int y = 0; y < h; y++) {
             for (int x = 0; x < w; x++) {
-                if (a.getRGB(x, y) != b.getRGB(x, y)) {
+                Color refRGB = new Color(a.getRGB(x,y));
+                Color customRGB = new Color(b.getRGB(x,y));
+
+                int red1 = refRGB.getRed();
+                int blue1 = refRGB.getBlue();
+                int green1 = refRGB.getGreen();
+
+                int red2 = customRGB.getRed();
+                int blue2 = customRGB.getBlue();
+                int green2 = customRGB.getGreen();
+
+                if ((Math.abs(red1 - red2) > colorTolerance) ||
+                    (Math.abs(green1 - green2) > colorTolerance) ||
+                    (Math.abs(blue1 - blue2) > colorTolerance)) {
+                    System.out.println("x " + x + " y " + y +
+                                       " refRGB " + refRGB +
+                                       " customRGB " + customRGB);
                     return false;
                 }
             }
@@ -222,6 +233,7 @@ public void removeActionListener(ActionListener actionListener) {
             f.add(p);
 
             f.pack();
+            f.setLocationRelativeTo(null);
             f.setVisible(true);
         }
 