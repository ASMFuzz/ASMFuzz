@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,7 +21,7 @@
  * questions.
  */
 
-import java.awt.*;
+import java.awt.SystemTray;
 
 /*
  * @test
@@ -30,43 +30,56 @@
  *          a proper instance is returned in supported platforms and a proper
  *          exception is thrown in unsupported platforms
  * @author Dmitriy Ermashov (dmitriy.ermashov@oracle.com)
+ * @requires (os.family != "linux")
  * @run main/othervm -DSystemTraySupport=TRUE SystemTrayInstanceTest
  */
 
+/*
+ * @test
+ * @key headful
+ * @requires (os.family == "linux")
+ * @run main/othervm -DSystemTraySupport=MAYBE SystemTrayInstanceTest
+ */
+
 public class SystemTrayInstanceTest {
 
-    private static boolean supported = false;
+    private static boolean shouldSupport = false;
 
     public static void main(String[] args) throws Exception {
         String sysTraySupport = System.getProperty("SystemTraySupport");
         if (sysTraySupport == null)
             throw new RuntimeException("SystemTray support status unknown!");
 
         if ("TRUE".equals(sysTraySupport)) {
-            System.out.println("System tray is supported on the platform under test");
-            supported = true;
+            System.out.println("System tray should be supported on this platform.");
+            shouldSupport = true;
         }
 
         new SystemTrayInstanceTest().doTest();
     }
 
-    private void doTest() throws Exception {
-        boolean flag = SystemTray.isSupported();
-        if (supported != flag)
-            throw new RuntimeException("FAIL: isSupported did not return the correct value"+
-                    (supported ?
-                            "SystemTray is supported on the platform under test" :
-                            "SystemTray is not supported on the platform under test") +
-                    "SystemTray.isSupported() method returned " + flag);
+    private void doTest() {
+        boolean systemSupported = SystemTray.isSupported();
+        if (shouldSupport && !systemSupported) {
+            throw new RuntimeException(
+                    "FAIL: SystemTray is not supported on the platform under test, while it should."
+            );
+        }
 
-        if (supported) {
+        if (shouldSupport || systemSupported) {
             SystemTray tray = SystemTray.getSystemTray();
+            System.out.println("SystemTray instance received");
         } else {
+            boolean exceptionThrown = false;
             try {
                 SystemTray tray = SystemTray.getSystemTray();
             } catch (UnsupportedOperationException uoe) {
+                exceptionThrown = true;
                 System.out.println("UnsupportedOperationException thrown correctly");
             }
+            if (!exceptionThrown) {
+                throw new RuntimeException("UnsupportedOperationException is not thrown");
+            }
         }
     }
 }