@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2022, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022 Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -22,25 +22,31 @@
  */
 package lib;
 
-import javax.swing.BorderFactory;
-import javax.swing.JFrame;
-import javax.swing.JLabel;
-import javax.swing.JPanel;
-import javax.swing.JSplitPane;
-import javax.swing.JTextArea;
-import javax.swing.border.BevelBorder;
 import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.awt.GridLayout;
+import java.io.File;
 import java.io.IOException;
 import java.lang.reflect.InvocationTargetException;
-import java.net.URL;
 import java.util.concurrent.CountDownLatch;
+import java.util.concurrent.TimeUnit;
 import java.util.concurrent.atomic.AtomicReference;
 import java.util.function.Consumer;
 import java.util.function.Supplier;
+import javax.imageio.ImageIO;
+import javax.swing.BorderFactory;
+import javax.swing.JEditorPane;
+import javax.swing.JFrame;
+import javax.swing.JLabel;
+import javax.swing.JPanel;
+import javax.swing.JSplitPane;
+import javax.swing.JTextArea;
+import javax.swing.border.BevelBorder;
 
-import static java.awt.BorderLayout.*;
+import static java.awt.BorderLayout.CENTER;
+import static java.awt.BorderLayout.NORTH;
+import static java.awt.BorderLayout.SOUTH;
+import static java.io.File.separator;
 import static javax.swing.SwingUtilities.invokeAndWait;
 
 /**
@@ -51,7 +57,9 @@ public class ManualTestFrame extends JFrame {
 
     private boolean alreadyFailed = false;
 
-    private ManualTestFrame(String testName, String headerText, URL instructions, Consumer<TestResult> listener) throws IOException {
+    private ManualTestFrame(String testName, String headerText,
+                            Consumer<JEditorPane> instructions,
+                            Consumer<TestResult> listener) throws IOException {
 
         super(testName);
 
@@ -124,14 +132,17 @@ private ManualTestFrame(String testName, String headerText, URL instructions, Co
 
     /**
      * Show a test control frame which allows a user to either pass or fail the test.
-     * @param testName
-     * @param headerText
-     * @param instructions
+     *
+     * @param testName     name of the testcase
+     * @param headerText   information to the user to wait for the test frame.
+     * @param instructions test instruction for the user
      * @return Returning supplier blocks till the test is passed or failed by the user.
-     * @throws InterruptedException
-     * @throws InvocationTargetException
+     * @throws InterruptedException      exception
+     * @throws InvocationTargetException exception
      */
-    public static Supplier<TestResult> showUI(String testName, String headerText, URL instructions)
+    public static Supplier<TestResult> showUI(String testName,
+                                              String headerText,
+                                              Consumer<JEditorPane> instructions)
             throws InterruptedException, InvocationTargetException {
         AtomicReference<TestResult> resultContainer = new AtomicReference<>();
         CountDownLatch latch = new CountDownLatch(1);
@@ -148,12 +159,46 @@ public static Supplier<TestResult> showUI(String testName, String headerText, UR
         });
         return () -> {
             try {
-                latch.await();
+                int timeout = Integer.getInteger("timeout", 10);
+                System.out.println("timeout value : " + timeout);
+                if (!latch.await(timeout, TimeUnit.MINUTES)) {
+                    throw new RuntimeException("Timeout : User failed to " +
+                            "take decision on the test result.");
+                }
             } catch (InterruptedException e) {
                 return new TestResult(e);
             }
             return resultContainer.get();
         };
     }
 
+    /**
+     * Checks the TestResult after user interacted with the manual TestFrame
+     * and the test UI.
+     *
+     * @param result   Instance of the TestResult
+     * @param testName name of the testcase
+     * @throws IOException exception
+     */
+    public static void handleResult(TestResult result, String testName) throws IOException {
+        if (result != null) {
+            System.err.println("Failure reason: \n" + result.getFailureDescription());
+            if (result.getScreenCapture() != null) {
+                File screenDump = new File(System.getProperty("test.classes") + separator + testName + ".png");
+                System.err.println("Saving screen image to " + screenDump.getAbsolutePath());
+                ImageIO.write(result.getScreenCapture(), "png", screenDump);
+            }
+            Throwable e = result.getException();
+            if (e != null) {
+                throw new RuntimeException(e);
+            } else {
+                if (!result.getStatus())
+                    throw new RuntimeException("Test failed!");
+            }
+        } else {
+            throw new RuntimeException("No result returned!");
+        }
+    }
+
 }
+