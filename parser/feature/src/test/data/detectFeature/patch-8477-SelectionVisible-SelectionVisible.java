@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,43 +21,57 @@
  * questions.
  */
 
-
-import java.applet.Applet;
-import java.awt.BorderLayout;
-import java.awt.Dimension;
-import java.awt.FlowLayout;
-import java.awt.Panel;
-import java.awt.TextArea;
+import java.awt.Frame;
 import java.awt.TextField;
+import java.lang.reflect.InvocationTargetException;
+
+import static java.awt.EventQueue.invokeAndWait;
+/*
+  @test
+  @key headful
+  @bug 4082144 7150100
+  @summary  Ensures that TextField.select() works when called
+            before setVisible()
+  @run main SelectionVisible
+ */
 
-public final class SelectionVisible extends Applet {
+public class SelectionVisible {
 
-    TextField tf;
+    private static Frame frame;
+    private static TextField tf;
 
-    @Override
-    public void init() {
+    public static void createTestUI() {
+        frame = new Frame("Test TextField.select()");
         tf = new TextField(20);
         tf.setText("0123456789");
         tf.select(0, 6);
+        frame.add(tf);
+        frame.setSize(200,200);
+        frame.setLocationRelativeTo(null);
+        frame.setVisible(true);
+    }
+
+    private static void test() throws InterruptedException,
+            InvocationTargetException {
+        String selectedText = tf.getSelectedText();
+        System.out.println("Selected Text : " + selectedText);
+        invokeAndWait(SelectionVisible::disposeFrame);
+        if (!selectedText.equals("012345")) {
+            throw new RuntimeException("Expected 012345 to be selected but " +
+                    "got " + selectedText);
+        }
+        System.out.println("Test passed");
+    }
 
-        final TextArea ta = new TextArea("INSTRUCTIONS:\n"
-                                         + "The text 012345 should be selected in the TextField.\n"
-                                         + "If this is what you observe, then the test passes.\n"
-                                         + "Otherwise, the test fails.", 40, 5,
-                                         TextArea.SCROLLBARS_NONE);
-        ta.setEditable(false);
-        ta.setPreferredSize(new Dimension(300, 70));
-        final Panel panel = new Panel();
-        panel.setLayout(new FlowLayout());
-        panel.add(tf);
-        setLayout(new BorderLayout());
-        add(ta, BorderLayout.CENTER);
-        add(panel, BorderLayout.PAGE_END);
+    private static void disposeFrame() {
+        if (frame != null) {
+            frame.dispose();
+        }
     }
 
-    @Override
-    public void start() {
-        setVisible(true);
-        tf.requestFocus();
+    public static void main(String[] args) throws InterruptedException,
+            InvocationTargetException {
+        invokeAndWait(SelectionVisible::createTestUI);
+        test();
     }
 }