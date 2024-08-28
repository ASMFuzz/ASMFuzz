@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -35,19 +35,29 @@
  * @build LWButton
  * @build LWList
  * @build ExtendedRobot
- * @run main/timeout=600 KeyMaskTest
+ * @run main/timeout=300 KeyMaskTest
  */
 
 
-import java.awt.*;
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
 
 import java.awt.event.KeyAdapter;
 import java.awt.event.KeyEvent;
 
 import java.util.ArrayList;
 
-import static jdk.test.lib.Asserts.*;
+import static jdk.test.lib.Asserts.assertEQ;
+import static jdk.test.lib.Asserts.assertTrue;
 
 import test.java.awt.event.helpers.lwcomponents.LWButton;
 import test.java.awt.event.helpers.lwcomponents.LWList;
@@ -65,12 +75,9 @@ public class KeyMaskTest extends KeyAdapter {
     List      list;
     LWList    listLW;
 
-    int buttonPressedNumber;
-    int buttonReleasedNumber;
-
     ExtendedRobot robot;
 
-    private final static int robotDelay = 1500;
+    private final static int robotDelay = 500;
     private final static int waitDelay  = 3500;
 
     final Object lock;
@@ -89,6 +96,7 @@ public void createGUI() {
         frame = new Frame();
         frame.setTitle("KeyMaskTest");
         frame.setLayout(new GridLayout(1, 6));
+        frame.setLocationRelativeTo(null);
 
         button = new Button();
         button.addKeyListener(this);