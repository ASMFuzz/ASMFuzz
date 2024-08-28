@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,8 +30,12 @@
  *
  * @library /vmTestbase
  *          /test/lib
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
  * @run main/othervm
- *      -XX:-UseGCOverheadLimit
+ *      -Xbootclasspath/a:.
+ *      -XX:+UnlockDiagnosticVMOptions
+ *      -XX:+WhiteBoxAPI
  *      gc.gctests.ReferencesGC.ReferencesGC
  *      -range 200
  *      -ratio 0.9
@@ -41,12 +45,11 @@
 package gc.gctests.ReferencesGC;
 
 import java.lang.ref.*;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.TestFailure;
-import nsk.share.gc.Algorithms;
 import nsk.share.gc.GC;
 import nsk.share.gc.ThreadedGCTest;
-import nsk.share.gc.gp.GarbageProducer;
-import nsk.share.gc.gp.GarbageUtils;
 import nsk.share.test.ExecutionController;
 
 public class ReferencesGC extends ThreadedGCTest {
@@ -87,7 +90,6 @@ private class Worker implements Runnable {
         WeakReference wr[] = new WeakReference[RANGE];
         SoftReference sr[] = new SoftReference[RANGE];
         PhantomReference phr[] = new PhantomReference[RANGE];
-        GarbageProducer gp = GarbageUtils.getArrayProducers().get(0);
         int iter = 0;
 
         @Override
@@ -98,21 +100,16 @@ public void run() {
 
             while (stresser.continueExecution()) {
                 int totalLive = 0;
-                try {
-                    refq = new ReferenceQueue();
-                    alive = new int[3];
-                    wrong = new int[3];
-                    for (int j = 0; j < RANGE; j++) {
-                        holder[j] = new CircularLinkedList();
-                        holder[j].addNelements(300);
-                        wr[j] = new WeakReference(holder[j], refq);
-                        sr[j] = new SoftReference(holder[j], refq);
-                        phr[j] = new PhantomReference(holder[j], refq);
-                    }
-                } catch (OutOfMemoryError oome) {
-                    // we should just skip the test
-                    // the other thread could eat all memory
-                    continue;
+
+                refq = new ReferenceQueue();
+                alive = new int[3];
+                wrong = new int[3];
+                for (int j = 0; j < RANGE; j++) {
+                    holder[j] = new CircularLinkedList();
+                    holder[j].addNelements(300);
+                    wr[j] = new WeakReference(holder[j], refq);
+                    sr[j] = new SoftReference(holder[j], refq);
+                    phr[j] = new PhantomReference(holder[j], refq);
                 }
 
                 for (int i = 0; i < RANGE; i++) {
@@ -134,12 +131,11 @@ public void run() {
                     holder[i] = null;
                 }
 
-                Algorithms.eatMemory(stresser);
+                // WB.fullGC() is guaranteed to clear all kinds of weak references.
+                WhiteBox.getWhiteBox().fullGC();
                 if (!stresser.continueExecution()) {
                     break;
                 }
-                // At this point OOME was thrown and accordingly to spec
-                // all weak refs should be processed
 
                 long waitTime = System.currentTimeMillis() + finalizationMaxTime;
                 int totalQ = 0;