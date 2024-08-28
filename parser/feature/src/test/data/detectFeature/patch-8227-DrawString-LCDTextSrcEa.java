@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -23,44 +23,38 @@
 
 /**
  * @test
- * @key headful
- * @bug 6996867
+ * @bug 6996867 8223543
+ * @requires (os.family == "windows")
  * @summary Render as LCD Text in SrcEa composite mode.
  */
 
-import java.awt.*;
-import java.awt.event.*;
-import java.awt.image.*;
+import java.awt.AlphaComposite;
+import java.awt.Color;
+import java.awt.Graphics2D;
+import java.awt.RenderingHints;
+import java.awt.image.BufferedImage;
 
-public class LCDTextSrcEa extends Component {
-
-    static int SZ=150;
-    BufferedImage target =
-        new BufferedImage(SZ, SZ, BufferedImage.TYPE_INT_RGB);
-
-    public static void main(String args[]) {
-        Frame f = new Frame("LCD Text SrcEa Test");
-        f.addWindowListener(new WindowAdapter() {
-            @Override
-            public void windowClosing(WindowEvent e) {
-                System.exit(0);
-            }
-        });
-        LCDTextSrcEa td = new LCDTextSrcEa();
-        f.add("Center", td);
-        f.pack();
-        f.setVisible(true);
-    }
-
-    public Dimension getPreferredSize() {
-        return new Dimension(SZ,SZ);
-    }
-
-    public void paint(Graphics gx) {
+public class LCDTextSrcEa {
 
+    public static void main(String[] args) {
+        String os = System.getProperty("os.name");
+        if (os.toLowerCase().startsWith("mac")) {
+            System.out.println("macOS doesn't support LCD any more. Skipping");
+            return;
+        }
+        /* Sometimes freetype on Linux is built without LCD support, so
+         * it can't be relied upon to test there.
+         */
+        if (os.toLowerCase().startsWith("linux")) {
+            System.out.println("Linux freetype may not do LCD. Skipping");
+            return;
+        }
+        int SZ=200;
+        BufferedImage target =
+            new BufferedImage(SZ, SZ, BufferedImage.TYPE_INT_RGB);
         Graphics2D g2d = (Graphics2D) target.getGraphics();
         g2d.setColor(Color.white);
-        g2d.fillRect(0, 0, getWidth(), getHeight());
+        g2d.fillRect(0, 0, SZ, SZ);
 
         g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 0.01f));
         g2d.setRenderingHint(
@@ -72,7 +66,6 @@ public void paint(Graphics gx) {
 
         g2d.setColor(Color.black);
         g2d.drawString("Some sample text.", 10, 20);
-        gx.drawImage(target, 0, 0, null);
         boolean nongrey = false;
         //Test BI: should be some non-greyscale color
         for (int px=0;px<SZ;px++) {