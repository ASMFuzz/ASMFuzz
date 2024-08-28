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
- * @run main/othervm -XX:-UseGCOverheadLimit gc.gctests.WeakReference.weak004.weak004 -t 1
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.WeakReference.weak004.weak004 -t 1
  */
 
 package gc.gctests.WeakReference.weak004;
 
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.gc.*;
 import java.lang.ref.WeakReference;
 
@@ -46,7 +49,7 @@
  */
 public class weak004 extends ThreadedGCTest {
 
-    class Worker implements Runnable, OOMStress {
+    class Worker implements Runnable {
 
         private int arrayLength;
         private int objectSize = 100;
@@ -64,7 +67,7 @@ public void run() {
             arrayLength = Memory.getArrayLength(runParams.getTestMemory() - objectSize, Memory.getReferenceSize() + objectSize);
             System.out.println("Array size: " + arrayLength);
             makeReferences();
-            Algorithms.eatMemory(getExecutionController());
+            WhiteBox.getWhiteBox().fullGC();
             if (!getExecutionController().continueExecution()) {
                 return;
             }