@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2017, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -46,36 +46,25 @@ public class ComboPopupTest {
     private volatile Point p = null;
     private volatile Dimension d = null;
 
-    void blockTillDisplayed(JComponent comp) throws Exception {
-        while (p == null) {
-            try {
-                SwingUtilities.invokeAndWait(() -> {
-                    p = comp.getLocationOnScreen();
-                    d = comboBox.getSize();
-                });
-            } catch (IllegalStateException e) {
-                try {
-                    Thread.sleep(1000);
-                } catch (InterruptedException ie) {
-                }
-            }
-        }
-    }
-
     public static void main(String[] args) throws Exception {
         new ComboPopupTest();
     }
 
     public ComboPopupTest() throws Exception {
         try {
             Robot robot = new Robot();
-            robot.setAutoDelay(200);
+            robot.setAutoDelay(100);
             SwingUtilities.invokeAndWait(() -> start());
-            blockTillDisplayed(comboBox);
+            robot.delay(1000);
+            SwingUtilities.invokeAndWait(() -> {
+                p = comboBox.getLocationOnScreen();
+                d = comboBox.getSize();
+            });
+            robot.waitForIdle();
+            robot.mouseMove(p.x + d.width - 1, p.y + d.height/2);
             robot.waitForIdle();
-            robot.mouseMove(p.x + d.width-1, p.y + d.height/2);
-            robot.mousePress(InputEvent.BUTTON1_MASK);
-            robot.mouseRelease(InputEvent.BUTTON1_MASK);
+            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
+            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
             robot.waitForIdle();
 
             System.out.println("popmenu visible " + comboBox.isPopupVisible());