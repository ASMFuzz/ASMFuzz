@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,56 +21,72 @@
  * questions.
  */
 
-/**
+import java.awt.Graphics;
+import java.awt.print.PageFormat;
+import java.awt.print.Printable;
+import java.awt.print.PrinterException;
+import java.awt.print.PrinterJob;
+import javax.print.attribute.HashPrintRequestAttributeSet;
+import javax.print.attribute.PrintRequestAttributeSet;
+import javax.print.attribute.standard.DialogTypeSelection;
+import javax.print.attribute.standard.PageRanges;
+import jtreg.SkippedException;
+
+/*
  * @test
  * @bug 8061267
+ * @key printer
+ * @library /java/awt/regtesthelpers
+ * @library /test/lib
+ * @build PassFailJFrame
+ * @build jtreg.SkippedException
  * @summary The specified page range should be displayed in the dialog
- * @run main/manual=yesno PageRangesDlgTest
+ * @run main/manual PageRangesDlgTest
  */
 
-import javax.print.*;
-import javax.print.attribute.*;
-import javax.print.attribute.standard.*;
-import java.awt.*;
-import java.awt.print.*;
-
 public class PageRangesDlgTest implements Printable {
 
-    static String[] instr = {
-     "This test is to check that the print dialog displays the specified",
-     "page ranges. You must have a printer installed for this test.",
-     "It is valid only on dialogs which support page ranges",
-     "In each dialog, check that a page range of 2 to 3 is requested",
-     "Optionally press Print instead of Cancel, and verify that the",
-     "correct number/set of pages is printed",
-    };
-
-    public static void main(String args[]) throws Exception {
-        for (int i=0;i<instr.length;i++) {
-            System.out.println(instr[i]);
-        }
+    private static void showPrintDialogs() throws PrinterException {
         PrinterJob job = PrinterJob.getPrinterJob();
-        if (job.getPrintService() == null) {
-           System.out.println("No printers. Test cannot continue.");
-           return;
-        }
         job.setPrintable(new PageRangesDlgTest());
         PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
-        aset.add(new PageRanges(2,3));
+        aset.add(new PageRanges(2, 3));
         if (job.printDialog(aset)) {
-           job.print(aset);
+            job.print(aset);
         }
 
         job = PrinterJob.getPrinterJob();
         job.setPrintable(new PageRangesDlgTest());
         aset.add(DialogTypeSelection.NATIVE);
-        if (job.printDialog()) {
+        if (job.printDialog(aset)) {
             job.print();
         }
     }
 
+    public static void main(String[] args) throws Exception {
+        if (PrinterJob.lookupPrintServices().length == 0) {
+            throw new SkippedException("Printer not configured or available."
+                    + " Test cannot continue.");
+        }
+
+        String instruction = """
+                Note: You must have a printer installed for this test.
+                If printer is not installed then the test passes automatically.
+
+                This test is to check that the print dialog displays the specified,
+                page ranges. It is valid only on dialogs which support page ranges,
+                In each dialog, check that a page range of 2 to 3 is requested,
+                Optionally press Print instead of Cancel, and verify that the,
+                correct number/set of pages is printed.
+                """;
+
+        PassFailJFrame passFailJFrame = new PassFailJFrame(instruction, 10);
+        showPrintDialogs();
+        passFailJFrame.awaitAndCheck();
+    }
+
     public int print(Graphics g, PageFormat pf, int pi)
-                     throws PrinterException  {
+                     throws PrinterException {
 
         System.out.println("pi="+pi);
         if (pi >= 5) {