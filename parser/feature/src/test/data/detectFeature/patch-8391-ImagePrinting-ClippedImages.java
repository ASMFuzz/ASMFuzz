@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,106 +21,120 @@
  * questions.
  */
 
-/**
+import java.awt.BorderLayout;
+import java.awt.Button;
+import java.awt.Color;
+import java.awt.Component;
+import java.awt.Dimension;
+import java.awt.Font;
+import java.awt.FontMetrics;
+import java.awt.Frame;
+import java.awt.Graphics;
+import java.awt.Graphics2D;
+import java.awt.Panel;
+import java.awt.geom.AffineTransform;
+import java.awt.image.BufferedImage;
+import java.awt.print.PageFormat;
+import java.awt.print.Pageable;
+import java.awt.print.Printable;
+import java.awt.print.PrinterException;
+import java.awt.print.PrinterJob;
+import java.lang.reflect.InvocationTargetException;
+import java.util.Objects;
+import javax.print.attribute.HashPrintRequestAttributeSet;
+import javax.print.attribute.PrintRequestAttributeSet;
+
+import static java.awt.EventQueue.invokeAndWait;
+
+/*
  * @test
  * @bug 6531728
+ * @key printer
+ * @library ../../../regtesthelpers
+ * @build PassFailJFrame
  * @summary Test printing of images which need to have src area clipped
- * @run main/manual=yesno/timeout=900 ClippedImages
+ * @run main/manual ClippedImages
  */
 
-import java.io.*;
-import java.util.Objects;
-import java.awt.*;
-import java.awt.geom.*;
-import java.awt.event.*;
-import java.awt.print.*;
-import java.awt.image.BufferedImage;
-import javax.print.*;
-import javax.print.attribute.*;
+public class ClippedImages {
 
-public class ClippedImages extends Frame implements ActionListener {
+    private static ClippedImageCanvas c;
 
-    private ClippedImageCanvas c;
+    public static void main(String[] args) throws InterruptedException,
+            InvocationTargetException {
 
-    public static void main(String args[]) {
+        if (PrinterJob.lookupPrintServices().length > 0) {
 
-        ClippedImages f = new ClippedImages();
-        f.setVisible(true);
+            String instruction = """
+                This is a manual test as it requires that you compare the
+                on-screen rendering with the printed output.
+
+                Select the 'Print All' button to print out the test. It will
+                generate 4 sides of content: as it will print each of 2 sets
+                of transformed images in portrait, and landscape orientations.
+
+                The sets of images are in turn made up of two similar sets of
+                pages: one is 'random' images, the other is 16 squares. Use the
+                'Toggle Contents' button to view the screen rendering. For each
+                page compare the printed content to the same on-screen one
+                taking careful note of
+                a) the positions of the red/blue circles on the corners
+                b) that numerical text on the image is displayed similarly
+                e) that the green quadrilaterals match on-screen
+                f) that the rendering is clipped at the default (typically 1 inch)
+                margins of the page.
+
+                The test PASSES if the onscreen and printed rendering match
+                """;
+
+            PassFailJFrame passFailJFrame = new PassFailJFrame("Test " +
+                    "Instruction", instruction, 15);
+            invokeAndWait(ClippedImages::createTestUI);
+            passFailJFrame.awaitAndCheck();
+
+        } else {
+            System.out.println("Printer not configured or available."
+                    + " Test cannot continue.");
+            PassFailJFrame.forcePass();
+        }
     }
 
-    public ClippedImages() {
-        super("Clipped Src Area Image Printing Test");
+    public static void createTestUI() {
+        Frame frame = new Frame("Clipped Src Area Image Printing Test");
         c = new ClippedImageCanvas();
-        add("Center", c);
+        frame.add(c, BorderLayout.CENTER);
 
         Button paintButton = new Button("Toggle Contents");
-        paintButton.addActionListener(this);
+        paintButton.addActionListener((ae) -> {
+            c.toggleContents();
+            c.repaint();
+        });
 
         Button printThisButton = new Button("Print This");
-        printThisButton.addActionListener(this);
+        printThisButton.addActionListener((ae) -> printOne());
 
         Button printAllButton = new Button("Print All");
-        printAllButton.addActionListener(this);
+        printAllButton.addActionListener((ae) -> printAll());
 
         Panel p = new Panel();
         p.add(paintButton);
         p.add(printThisButton);
         p.add(printAllButton);
-        add("South", p);
-        add("North", getInstructions());
-        addWindowListener(new WindowAdapter() {
-                public void windowClosing(WindowEvent e) {
-                    System.exit(0);
-                }
-            });
-
-        pack();
-    }
+        frame.add(p, BorderLayout.SOUTH);
+        frame.setLocationRelativeTo(null);
+        frame.pack();
+        frame.setVisible(true);
 
-    private TextArea getInstructions() {
-        TextArea ta = new TextArea(18, 60);
-        ta.setFont(new Font("Dialog", Font.PLAIN, 11));
-        ta.setText
-            ("This is a manual test as it requires that you compare "+
-             "the on-screen rendering with the printed output.\n"+
-             "Select the 'Print All' button to print out the test\n"+
-             "It will generate 4 sides of content: as it will print "+
-             "each of 2 sets of transformed images in portrait, \n"+
-             "and landscape orientations. \n"+
-             "The sets of images are in turn made up\n"+
-             "of two similar sets of pages: one is 'random' images,\n "+
-             " the other is 16 squares.\n"+
-             "Use the 'Toggle Contents' button to view the screen rendering\n"+
-             "For each page compare the printed content to the same\n"+
-             "on-screen one taking careful note of\n"+
-             "a) the positions of the red/blue circles on the corners\n"+
-             "b) that numerical text on the image is displayed similarly\n"+
-             "e) that the green quadrilaterals match on-screen\n"+
-             "f) that the rendering is clipped at the default (typically 1 inch) "+
-             "margins of the page.\n"+
-             "The test PASSES if the onscreen and printed rendering match");
-        return ta;
+        PassFailJFrame.addTestFrame(frame);
+        PassFailJFrame.positionTestFrame(frame, PassFailJFrame.Position.HORIZONTAL);
     }
 
-    public void actionPerformed(ActionEvent e) {
-
-        if (e.getActionCommand().equals("Print This")) {
-            printOne();
-        } else if (e.getActionCommand().equals("Print All")) {
-            printAll();
-        } else if (e.getActionCommand().equals("Toggle Contents")) {
-            c.toggleContents();
-            c.repaint();
-        }
-    }
-
-    private void printOne() {
+    private static void printOne() {
         PrinterJob pj = PrinterJob.getPrinterJob();
-
         PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
-        if (pj != null && (false||pj.printDialog(attrs))) {
-            c.setPrinterJob(pj, false);
-            pj.setPrintable(c);
+        c.setPrinterJob(pj, false);
+        pj.setPrintable(c);
+        if (pj.printDialog(attrs)) {
             try {
                 pj.print(attrs);
             } catch (PrinterException pe) {
@@ -129,15 +143,18 @@ private void printOne() {
             } finally {
                 System.out.println("PRINT RETURNED OK.");
             }
+        } else {
+            throw new RuntimeException("Test failed : "
+                    + "User selected 'Cancel' button on the print dialog");
         }
     }
 
-    private void printAll() {
+    private static void printAll() {
         PrinterJob pj = PrinterJob.getPrinterJob();
         PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
-        if (pj != null && (false||pj.printDialog(attrs))) {
-            c.setPrinterJob(pj, true);
-            pj.setPageable(c);
+        c.setPrinterJob(pj, true);
+        pj.setPageable(c);
+        if (pj.printDialog(attrs)) {
             try {
                 pj.print(attrs);
             } catch (PrinterException pe) {
@@ -146,6 +163,9 @@ private void printAll() {
             } finally {
                 System.out.println("PRINT RETURNED OK.");
             }
+        } else {
+            throw new RuntimeException("Test failed : "
+                    + "User selected 'Cancel' button on the print dialog");
         }
     }
 }
@@ -168,7 +188,7 @@ class ClippedImageCanvas extends Component implements Printable, Pageable {
         for (int y=12;y<sh;y+=12) {
             int x = 0;
             while (x < sw) {
-                String s = (new Integer(++cnt)).toString();
+                String s = String.valueOf(++cnt);
                 g2d.drawString(s, x, y);
                 x+= fm.stringWidth(s);
             }
@@ -196,19 +216,18 @@ void setPrinterJob(PrinterJob job, boolean pageable) {
     }
 
     public PageFormat getPageFormat(int pageIndex)
-        throws IndexOutOfBoundsException {
+            throws IndexOutOfBoundsException {
         Objects.checkIndex(pageIndex, getNumberOfPages());
 
         PageFormat pf = myPrinterJob.defaultPage();
         switch (pageIndex % 2) {
+            case 0 :
+                pf.setOrientation(PageFormat.PORTRAIT);
+                break;
 
-        case 0 :
-            pf.setOrientation(PageFormat.PORTRAIT);
-            break;
-
-        case 1:
-            pf.setOrientation(PageFormat.LANDSCAPE);
-             break;
+            case 1:
+                pf.setOrientation(PageFormat.LANDSCAPE);
+                break;
         }
         return pf;
     }
@@ -222,7 +241,7 @@ String getOrientStr(PageFormat pf) {
     }
 
     public Printable getPrintable(int pageIndex)
-        throws IndexOutOfBoundsException {
+            throws IndexOutOfBoundsException {
         Objects.checkIndex(pageIndex, getNumberOfPages());
 
         if (pageIndex < 2) {
@@ -282,7 +301,7 @@ public void paint(Graphics g) {
         for (int p=0;p<size.width;p+=20) {
             g.drawLine(p, 0, p, size.height);
         }
-       for (int p=0;p<size.height;p+=20) {
+        for (int p=0;p<size.height;p+=20) {
             g.drawLine(0, p, size.width, p);
         }
         if (paintSquares) {
@@ -368,7 +387,7 @@ private void paintSquares(Graphics g) {
 
         g.translate(20, 20);
 
-         /* sA + sD -> dA + dD - the normal untransformed case */
+        /* sA + sD -> dA + dD - the normal untransformed case */
         drawImage(g, dxa, dya, dxd, dyd, sxa, sya, sxd, syd);
         g.translate(incX, 0);
 
@@ -384,7 +403,6 @@ private void paintSquares(Graphics g) {
         drawImage(g, dxa, dya, dxd, dyd, sxc, syc, sxb, syb);
 
         g.translate(-3*incX, incY);
-        /******/
 
         /* sA + sD -> dD + dA */
         drawImage(g, dxd, dyd, dxa, dya, sxa, sya, sxd, syd);
@@ -402,7 +420,6 @@ private void paintSquares(Graphics g) {
         drawImage(g, dxd, dyd, dxa, dya, sxc, syc, sxb, syb);
 
         g.translate(-3*incX, incY);
-        /******/
 
         /* sA + sD -> dB + dC */
         drawImage(g, dxb, dyb, dxc, dyc, sxa, sya, sxd, syd);
@@ -420,7 +437,6 @@ private void paintSquares(Graphics g) {
         drawImage(g, dxb, dyb, dxc, dyc, sxc, syc, sxb, syb);
 
         g.translate(-3*incX, incY);
-        /******/
 
 
         /* sA + sD -> dC + dB */
@@ -441,11 +457,11 @@ private void paintSquares(Graphics g) {
 
 
 
-     /* Size is chosen to match default imageable width of a NA letter
-      * page. This means there will be clipping, what is clipped will
-      * depend on PageFormat orientation.
-      */
-     public Dimension getPreferredSize() {
+    /* Size is chosen to match default imageable width of a NA letter
+     * page. This means there will be clipping, what is clipped will
+     * depend on PageFormat orientation.
+     */
+    public Dimension getPreferredSize() {
         return new Dimension(468, 468);
     }
 