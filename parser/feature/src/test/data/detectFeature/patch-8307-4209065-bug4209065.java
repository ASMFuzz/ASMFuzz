@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2015, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,37 +21,63 @@
  * questions.
  */
 
-import java.awt.EventQueue;
+/*
+ * @test
+ * @bug 4209065
+ * @library /java/awt/regtesthelpers
+ * @build PassFailJFrame
+ * @summary To test if the style of the text on the tab matches the description.
+ * @run main/manual bug4209065
+ */
+
 import java.lang.reflect.InvocationTargetException;
 
-import javax.swing.JApplet;
+import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JTabbedPane;
+import javax.swing.SwingUtilities;
 
-/**
- * @test
- * @bug 4209065
- * @author Georges Saab
- * @run applet/manual=yesno bug4209065.html
- */
-public final class bug4209065 extends JApplet {
-
-    @Override
-    public void init() {
-        try {
-            EventQueue.invokeAndWait(this::createTabbedPane);
-        } catch (InterruptedException | InvocationTargetException e) {
-            throw new RuntimeException(e);
-        }
+
+public final class bug4209065 {
+
+    private static JFrame frame;
+    private static final String text =
+            "If the style of the text on the tabs matches the descriptions," +
+                    "\npress PASS.\n\nNOTE: where a large font is used, the" +
+                    " text may be larger\nthan the tab height but this is OK" +
+                    " and NOT a failure.";
+
+    public static void createAndShowGUI() throws InterruptedException,
+            InvocationTargetException {
+        SwingUtilities.invokeAndWait(() -> {
+            frame = new JFrame("JTabbedPane");
+
+            JTabbedPane tp = new JTabbedPane();
+
+            tp.addTab("<html><center><font size=+3>big</font></center></html>",
+                    new JLabel());
+            tp.addTab("<html><center><font color=red>red</font></center></html>",
+                    new JLabel());
+            tp.addTab("<html><center><em><b>Bold Italic!</b></em></center></html>",
+                    new JLabel());
+
+            frame.getContentPane().add(tp);
+            frame.setSize(400, 400);
+            frame.setLocationRelativeTo(null);
+            frame.setVisible(true);
+
+
+            PassFailJFrame.addTestFrame(frame);
+            PassFailJFrame.positionTestFrame(frame,
+                    PassFailJFrame.Position.HORIZONTAL);
+        });
     }
 
-    private void createTabbedPane() {
-        JTabbedPane tp = new JTabbedPane();
-        getContentPane().add(tp);
-        String text = "<html><center>If the style of the text on the tabs matches"
-                      + "<br>the descriptions, press <em><b>PASS</b></em></center></html>";
-        tp.addTab("<html><center><font size=+3>big</font></center></html>", new JLabel(text));
-        tp.addTab("<html><center><font color=red>red</font></center></html>", new JLabel(text));
-        tp.addTab("<html><center><em><b>Bold Italic!</b></em></center></html>", new JLabel(text));
+    public static void main(String[] args) throws InterruptedException,
+            InvocationTargetException {
+        PassFailJFrame passFailJFrame = new PassFailJFrame("JTabbedPane " +
+                "Test Instructions", text, 5, 19, 35);
+        createAndShowGUI();
+        passFailJFrame.awaitAndCheck();
     }
-}
+}
\ No newline at end of file