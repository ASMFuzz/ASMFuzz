@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,89 +21,45 @@
  * questions.
  */
 
-import java.lang.ref.WeakReference;
-import java.util.ArrayList;
 import javax.swing.border.TitledBorder;
-import javax.swing.JFrame;
-import javax.swing.JPanel;
-import javax.swing.JLabel;
-import javax.swing.SwingUtilities;
 
-/**
+/*
  * @test
- * @key headful
  * @bug 8204963
  * @summary Verifies TitledBorder's memory leak
- * @run main TestTitledBorderLeak
+ * @run main/othervm -Xmx10M TestTitledBorderLeak
  */
-
 public class TestTitledBorderLeak {
-
-    final static int TOTAL_TITLEDBORDER = 10;
-    final static int GC_ATTEMPTS = 10;
-    static ArrayList<WeakReference<TitledBorder>> weakRefArrTB =
-                                         new ArrayList(TOTAL_TITLEDBORDER);
-
     public static void main(String[] args) throws Exception {
+        int max = 100000;
+        long initialFreeMemory = 0L;
+        long currentFreeMemory;
+        try {
+            for (int i = 1; i <= max; i++) {
+                new TitledBorder("");
+                if ((i % 1000) == 0) {
+                    System.gc();
+                    currentFreeMemory = dumpMemoryStatus("After " + i);
+                    if(initialFreeMemory == 0L) {
+                        initialFreeMemory = currentFreeMemory;
+                    } else if( currentFreeMemory < initialFreeMemory/2) {
+                        throw new RuntimeException("Memory halved: there's a leak");
+                    }
 
-        JFrame frame[] = new JFrame[TOTAL_TITLEDBORDER];
-
-        SwingUtilities.invokeAndWait(() -> {
-            for (int i = 0; i < TOTAL_TITLEDBORDER; i++) {
-                TitledBorder tb = new TitledBorder("");
-                weakRefArrTB.add(i, new WeakReference<TitledBorder>(tb));
-                JLabel label = new JLabel("TitledBorder");
-                label.setBorder(tb);
-                frame[i] = new JFrame("Borders");
-                JPanel panel = new JPanel();
-                panel.add(label);
-                frame[i].setContentPane(panel);
-                frame[i].setVisible(true);
-
-            }
-        });
-        if (TOTAL_TITLEDBORDER != weakRefArrTB.size()) {
-            System.err.println("TOTAL_TITLEDBORDER != weakRefArrTB.size()");
-        }
-        Thread.sleep(3000);
-        SwingUtilities.invokeAndWait(() -> {
-            for (int i = 0; i < TOTAL_TITLEDBORDER; i++) {
-                frame[i].dispose();
-                frame[i] = null;
+                }
             }
-        });
-        Thread.sleep(3000);
-        attemptGCTitledBorder();
-        if (TOTAL_TITLEDBORDER != getCleanedUpTitledBorderCount()) {
-            throw new RuntimeException("Expected Total TitledBorder to be freed : " + TOTAL_TITLEDBORDER +
-                           " Freed " + getCleanedUpTitledBorderCount());
-        }
-        System.out.println("OK");
-    }
-
-    private static void attemptGCTitledBorder() {
-        // Attempt gc GC_ATTEMPTS times
-        for (int i = 0; i < GC_ATTEMPTS; i++) {
+        }catch(OutOfMemoryError e) {
+            // Don't think it would work; should not happen
             System.gc();
-            System.runFinalization();
-            if (getCleanedUpTitledBorderCount() == TOTAL_TITLEDBORDER) {
-                break;
-            }
-            try {
-                Thread.sleep(500);
-            } catch (InterruptedException e) {
-                System.err.println("InterruptedException occurred during Thread.sleep()");
-            }
+            throw new RuntimeException("There was OOM");
         }
+        System.out.println("Passed");
     }
-
-    private static int getCleanedUpTitledBorderCount() {
-        int count = 0;
-        for (WeakReference<TitledBorder> ref : weakRefArrTB) {
-            if (ref.get() == null) {
-                count++;
-            }
-        }
-        return count;
+    private static long dumpMemoryStatus(String msg) {
+        Runtime rt = Runtime.getRuntime();
+        long freeMem = rt.freeMemory();
+        System.out.println(msg + ": " + freeMem + " free");
+        return freeMem;
     }
 }
+