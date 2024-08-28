@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,11 +30,14 @@
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm -XX:-UseGCOverheadLimit gc.gctests.WeakReference.weak006.weak006 -t 1
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.WeakReference.weak006.weak006 -t 1
  */
 
 package gc.gctests.WeakReference.weak006;
 
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.test.*;
 import nsk.share.gc.*;
 import nsk.share.TestFailure;
@@ -48,12 +51,12 @@
  *
  * This test randomly creates a number of weak, soft,
  * phantom and strong references,  each of which points
- * to the next, then provokes GC with Algorithms.eatMemory().
+ * to the next, then provokes GC with WB.fullGC().
  * The test succedes if last reference has been cleared.
  */
 public class weak006 extends ThreadedGCTest {
 
-    class Worker implements Runnable, OOMStress {
+    class Worker implements Runnable {
 
         private int length;
         private int objectSize = 100;
@@ -122,7 +125,7 @@ private void makeReferences(int n) {
         public void run() {
             makeReferences(0);
             ExecutionController stresser = getExecutionController();
-            Algorithms.eatMemory(stresser);
+            WhiteBox.getWhiteBox().fullGC();
             if (!stresser.continueExecution()) {
                 return;
             }
@@ -131,7 +134,7 @@ public void run() {
                 throw new TestFailure("Last weak reference has not been cleared");
             }
             makeReferences(1);
-            Algorithms.eatMemory(stresser);
+            WhiteBox.getWhiteBox().fullGC();
             if (!stresser.continueExecution()) {
                 return;
             }