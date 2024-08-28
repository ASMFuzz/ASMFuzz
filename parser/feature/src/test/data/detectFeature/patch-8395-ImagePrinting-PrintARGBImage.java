@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,42 +21,59 @@
  * questions.
  */
 
-/**
+import java.awt.Color;
+import java.awt.Graphics;
+import java.awt.Graphics2D;
+import java.awt.image.BufferedImage;
+import java.awt.print.PageFormat;
+import java.awt.print.Printable;
+import java.awt.print.PrinterException;
+import java.awt.print.PrinterJob;
+import java.lang.reflect.InvocationTargetException;
+
+/*
  * @test
  * @bug 6581756
+ * @library ../../../regtesthelpers
+ * @build PassFailJFrame
  * @summary Test printing of images which need to have src area clipped
- * @run main/manual=yesno PrintARGBImage
+ * @run main/manual PrintARGBImage
  */
 
-import java.awt.*;
-import java.awt.image.*;
-import java.awt.print.*;
-
 public class PrintARGBImage implements Printable {
 
-    static String[] text = {
-     "This is a manual test which needs a printer installed",
-     "If you have no printer installed you CANNOT use this test",
-     "It runs automatically and sends one page to the default printer",
-     "It passes if the text shows through the rectangular image",
-    };
+    public static void main(String[] args) throws InterruptedException,
+            InvocationTargetException {
+        if (PrinterJob.lookupPrintServices().length > 0) {
 
-    public static void main( String[] args ) {
-
-        for (int i=0;i<text.length;i++) {
-            System.out.println(text[i]);
-        }
+            String instruction = """
+                    This is a manual test which needs a printer installed.
+                    If you have no printer installed the test passes automatically.
+                    The test runs automatically and sends one page to the default printer.
+                    The test passes if the text shows through the rectangular image.
+                    """;
 
-        try {
-            PrinterJob pj = PrinterJob.getPrinterJob();
-            pj.setPrintable(new PrintARGBImage());
-            pj.print();
+            PassFailJFrame passFailJFrame = new PassFailJFrame(instruction, 10);
+            try {
+                PrinterJob pj = PrinterJob.getPrinterJob();
+                pj.setPrintable(new PrintARGBImage());
+                pj.print();
             } catch (Exception ex) {
+                ex.printStackTrace();
+                throw new RuntimeException("Exception whilst printing.");
+            }
+
+            passFailJFrame.awaitAndCheck();
+
+        } else {
+            System.out.println("Printer not configured or available."
+                    + " Test cannot continue.");
+            PassFailJFrame.forcePass();
         }
     }
 
     public int print(Graphics g, PageFormat pf, int pageIndex)
-               throws PrinterException{
+               throws PrinterException {
 
         if (pageIndex != 0) {
             return NO_SUCH_PAGE;
@@ -77,3 +94,5 @@ public int print(Graphics g, PageFormat pf, int pageIndex)
         return PAGE_EXISTS;
     }
 }
+
+