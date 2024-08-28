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
- * @run main/othervm -XX:-UseGCOverheadLimit gc.gctests.SoftReference.soft005.soft005 -t 1
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.SoftReference.soft005.soft005 -t 1
  */
 
 package gc.gctests.SoftReference.soft005;
 
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.gc.*;
 import java.lang.ref.SoftReference;
 
@@ -43,12 +46,12 @@
  *
  * This test creates a number of soft references,
  * each of which points to the next,
- * then provokes GC with Algorithms.eatMemory(). Then
+ * then provokes GC with WB.fullGC(). Then
  * checks that first reference has been cleared.
  */
 public class soft005 extends ThreadedGCTest {
 
-    class Worker implements Runnable, OOMStress {
+    class Worker implements Runnable {
 
         private int length = 10000;
         private int objectSize = 10000;
@@ -74,7 +77,7 @@ private void makeReferences() {
 
         public void run() {
             makeReferences();
-            Algorithms.eatMemory(getExecutionController());
+            WhiteBox.getWhiteBox().fullGC();
             if (!getExecutionController().continueExecution()) {
                 return;
             }