@@ -1,5 +1,5 @@
 /*
-* Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
+* Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
@@ -24,50 +24,52 @@
 
 import java.io.File;
 import java.io.FileReader;
+import java.util.concurrent.CountDownLatch;
+
 import javax.swing.SwingUtilities;
 import javax.swing.text.Document;
 import javax.swing.text.html.HTMLEditorKit;
 
+import static java.util.concurrent.TimeUnit.MILLISECONDS;
+
 /* @test
    @bug 8078268
    @summary  javax.swing.text.html.parser.Parser parseScript incorrectly optimized
-   @author Mikhail Cherkasov
    @run main bug8078268
 */
 public class bug8078268 {
-    static volatile boolean parsingDone = false;
-    static volatile Exception exception;
+    private static final long TIMEOUT = 10_000;
+
+    private static final String FILENAME = "slowparse.html";
+
+    private static final CountDownLatch latch = new CountDownLatch(1);
+    private static volatile Exception exception;
 
     public static void main(String[] args) throws Exception {
-        long timeout = 10_000;
-        long s = System.currentTimeMillis();
         SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 HTMLEditorKit htmlKit = new HTMLEditorKit();
                 Document doc = htmlKit.createDefaultDocument();
                 try {
-                    htmlKit.read(new FileReader(getDirURL() + "slowparse.html"), doc, 0);
-                    parsingDone = true;
+                    htmlKit.read(new FileReader(getAbsolutePath()), doc, 0);
                 } catch (Exception e) {
                     exception = e;
                 }
+                latch.countDown();
             }
         });
-        while (!parsingDone && exception == null && System.currentTimeMillis() - s < timeout) {
-            Thread.sleep(200);
+
+        if (!latch.await(TIMEOUT, MILLISECONDS)) {
+            throw new RuntimeException("Parsing takes too long.");
         }
-        final long took = System.currentTimeMillis() - s;
         if (exception != null) {
             throw exception;
         }
-        if (took > timeout) {
-            throw new RuntimeException("Parsing takes too long.");
-        }
     }
 
-    static String getDirURL() {
-        return new File(System.getProperty("test.src", ".")).getAbsolutePath() +
-                File.separator;
+    private static String getAbsolutePath() {
+        return System.getProperty("test.src", ".")
+               + File.separator + FILENAME;
     }
 }