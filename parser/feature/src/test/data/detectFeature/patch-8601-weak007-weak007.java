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
- * @run main/othervm -XX:-UseGCOverheadLimit gc.gctests.WeakReference.weak007.weak007 -t 1
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.WeakReference.weak007.weak007 -t 1
  */
 
 package gc.gctests.WeakReference.weak007;
 
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.TestFailure;
 import nsk.share.gc.*;
 import java.lang.ref.WeakReference;
@@ -45,13 +48,13 @@
  *
  * This test creates a number of weak references,
  * each of which points to the next, then provokes
- * GC with Algorithms.eatMemory(). The test succeeds
+ * GC with WB.fullGC(). The test succeeds
  * if last reference has been cleared and the object
  * has been finalized.
  */
 public class weak007 extends ThreadedGCTest {
 
-    class Worker implements Runnable, OOMStress {
+    class Worker implements Runnable {
 
         private int length = 10000;
         private int objectSize = 10000;
@@ -71,7 +74,7 @@ private void makeReferences() {
 
         public void run() {
             makeReferences();
-            Algorithms.eatMemory(getExecutionController());
+            WhiteBox.getWhiteBox().fullGC();
             if (getExecutionController().continueExecution()) {
                 if (references[length - 1].get() != null) {
                     throw new TestFailure("Last weak reference has not been cleared");