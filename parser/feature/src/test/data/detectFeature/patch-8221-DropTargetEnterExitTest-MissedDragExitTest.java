@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -60,6 +60,7 @@ public class MissedDragExitTest {
 
     private static void initAndShowUI() {
         f = new Frame("Test frame");
+        f.setUndecorated(true);
         f.setBounds(FRAME_LOCATION,FRAME_LOCATION,FRAME_SIZE,FRAME_SIZE);
 
         final DraggablePanel dragSource = new DraggablePanel();
@@ -102,7 +103,7 @@ public void run() {
             Util.drag(r,
                     new Point(FRAME_LOCATION + FRAME_SIZE / 3, FRAME_LOCATION + FRAME_SIZE / 3),
                     new Point(FRAME_LOCATION + FRAME_SIZE / 3 * 2, FRAME_LOCATION + FRAME_SIZE / 3 * 2),
-                    InputEvent.BUTTON1_MASK);
+                    InputEvent.BUTTON1_DOWN_MASK);
             Util.waitForIdle(r);
 
             if (!dragExitCalled) {