@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -20,10 +20,12 @@
  * or visit www.oracle.com if you need additional information or have any
  * questions.
  */
+
 import java.awt.Button;
 import java.awt.Frame;
 import java.awt.Rectangle;
 import java.awt.Robot;
+import java.util.concurrent.atomic.AtomicInteger;
 
 import jdk.test.lib.Platform;
 
@@ -40,22 +42,46 @@
 public class RobotWheelTest {
 
     private static final int NUMTESTS = 20;
-    private static volatile int wheelRotation;
+
+    private static AtomicInteger wheelRotation = new AtomicInteger();
+    private static int wheelSign = Platform.isOSX() ? -1 : 1;
+
+    static Robot robot;
+
+    static void waitTillSuccess(int i) {
+        boolean success = false;
+
+        for (int t = 0; t < 5; t++) {
+            if (i == wheelSign * wheelRotation.get()) {
+                success = true;
+                break;
+            }
+            System.out.printf(
+                    "attempt #%d failed. wheelRotation = %d, expected value = %d\n",
+                    t, wheelRotation.get(), i
+            );
+            robot.delay(100);
+        }
+
+        if (!success) {
+            throw new RuntimeException("wheelRotation = " + wheelRotation.get()
+                    + ", expected value = " + i);
+        }
+    }
 
     public static void main(String[] args) throws Exception {
+        robot = new Robot();
 
         Frame frame = null;
         try {
-            int wheelSign = Platform.isOSX() ? -1 : 1;
-
             frame = new Frame();
             frame.setSize(200, 200);
             Button button = new Button("WheelButton");
-            button.addMouseWheelListener(e -> wheelRotation = e.getWheelRotation());
+            button.addMouseWheelListener(e -> wheelRotation.addAndGet(e.getWheelRotation()));
             frame.add(button);
+            frame.setLocationRelativeTo(null);
             frame.setVisible(true);
 
-            Robot robot = new Robot();
             robot.setAutoDelay(100);
             robot.waitForIdle();
 
@@ -69,12 +95,13 @@ public static void main(String[] args) throws Exception {
                 if (i == 0) {
                     continue;
                 }
+
+                wheelRotation.set(0);
+
                 robot.mouseWheel(i);
                 robot.waitForIdle();
-                if (i != wheelSign * wheelRotation) {
-                    throw new RuntimeException("wheelRotation = " + wheelRotation
-                            + ", expected value = " + i);
-                }
+
+                waitTillSuccess(i);
             }
         } finally {
             if (frame != null) {