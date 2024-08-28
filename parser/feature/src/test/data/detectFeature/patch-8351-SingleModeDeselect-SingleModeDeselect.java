@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,16 +26,17 @@
   @key headful
   @bug 6248040
   @summary List.deselect() de-selects the currently selected item regardless of the index, win32
-  @author Dmitry Cherepanov area=awt.list
   @run main SingleModeDeselect
 */
 
-import java.awt.*;
+import java.awt.AWTException;
+import java.awt.FlowLayout;
+import java.awt.Frame;
+import java.awt.List;
+import java.awt.Robot;
 
-public class SingleModeDeselect
-{
-    public static final void main(String args[])
-    {
+public class SingleModeDeselect {
+    public static final void main(String args[]) {
         final Frame frame = new Frame();
         final List list = new List();
 
@@ -45,6 +46,7 @@ public static final void main(String args[])
         frame.add(list);
         frame.setLayout(new FlowLayout());
         frame.setBounds(100,100,300,300);
+        frame.setLocationRelativeTo(null);
         frame.setVisible(true);
 
         list.select(0);
@@ -53,14 +55,16 @@ public static final void main(String args[])
         try {
             Robot robot = new Robot();
             robot.waitForIdle();
-        }catch(Exception ex) {
+            if (list.getSelectedIndex() != 0) {
+                throw new RuntimeException("Test failed: List.getSelectedIndex() returns "
+                                           + list.getSelectedIndex());
+            }
+        } catch(AWTException ex) {
             ex.printStackTrace();
             throw new RuntimeException("Unexpected failure");
+        } finally {
+            frame.setVisible(false);
+            frame.dispose();
         }
-
-        if (list.getSelectedIndex() != 0){
-            throw new RuntimeException("Test failed: List.getSelectedIndex() returns "+list.getSelectedIndex());
-        }
-
-    }//End  init()
+    }
 }