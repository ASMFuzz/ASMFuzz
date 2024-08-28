@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -38,7 +38,7 @@
  * @build LWButton
  * @build LWList
  * @build ExtendedRobot
- * @run main/timeout=600 ExtendedModifiersTest
+ * @run main/timeout=300 ExtendedModifiersTest
  */
 import java.awt.Button;
 import java.awt.Color;
@@ -71,7 +71,7 @@ public class ExtendedModifiersTest implements KeyListener {
 
     private final ExtendedRobot robot;
     private static final int WAIT_DELAY = 5000;
-    private static final int KEY_DELAY = 500;
+    private static final int KEY_DELAY = 100;
     private final Object lock;
 
     private boolean keyPressedFlag;
@@ -106,6 +106,7 @@ public void createGUI() {
         frame = new Frame();
         frame.setTitle("ExtendedModifiersTest");
         frame.setLayout(new GridLayout(1, 6));
+        frame.setLocationRelativeTo(null);
 
         button = new Button();
         button.addKeyListener(this);