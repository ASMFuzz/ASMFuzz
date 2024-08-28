@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -22,16 +22,25 @@
  */
 
 
-import java.awt.*;
-
+import java.awt.Button;
+import java.awt.Color;
+import java.awt.Component;
+import java.awt.EventQueue;
+import java.awt.Frame;
+import java.awt.GridLayout;
+import java.awt.List;
+import java.awt.Point;
+import java.awt.TextArea;
+import java.awt.TextField;
 import java.awt.event.InputEvent;
 import java.awt.event.KeyEvent;
 import java.awt.event.KeyListener;
 import java.awt.event.MouseEvent;
 import java.awt.event.MouseListener;
 import java.util.ArrayList;
 
-import static jdk.test.lib.Asserts.*;
+import static jdk.test.lib.Asserts.assertEQ;
+import static jdk.test.lib.Asserts.assertTrue;
 
 
 import test.java.awt.event.helpers.lwcomponents.LWButton;
@@ -52,7 +61,7 @@
  * @build LWButton
  * @build LWList
  * @build ExtendedRobot
- * @run main/timeout=600 MouseButtonsAndKeyMasksTest
+ * @run main/timeout=300 MouseButtonsAndKeyMasksTest
  */
 
 public class MouseButtonsAndKeyMasksTest implements MouseListener, KeyListener {
@@ -68,11 +77,11 @@ public class MouseButtonsAndKeyMasksTest implements MouseListener, KeyListener {
 
     ExtendedRobot robot;
 
-    private final static int robotDelay = 1500;
-    private final static int   keyDelay =  500;
+    private final static int robotDelay = 500;
+    private final static int   keyDelay =  100;
     private final static int  waitDelay = 5000;
 
-    int modMouse = 0, modMouseEx = 0, modKey = 0, modAction = 0;
+    int modMouse = 0, modMouseEx = 0, modKey = 0;
 
     boolean mousePressFired = false;
     boolean keyPressFired = false;
@@ -90,6 +99,7 @@ public void createGUI() {
         frame = new Frame();
         frame.setTitle("MouseButtonsAndKeysTest");
         frame.setLayout(new GridLayout(1, 6));
+        frame.setLocationRelativeTo(null);
 
         button = new Button();
         button.addKeyListener(this);