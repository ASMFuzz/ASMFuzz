@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,12 +30,16 @@
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm -XX:-UseGCOverheadLimit gc.gctests.SoftReference.soft003.soft003 -t 1
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.SoftReference.soft003.soft003 -t 1
  */
 
 package gc.gctests.SoftReference.soft003;
 
 import java.lang.ref.Reference;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.test.*;
 import nsk.share.gc.*;
 import nsk.share.TestFailure;
@@ -45,12 +49,12 @@
  * Test that GC clears soft references before throwing OOM.
  *
  * This test creates a number of soft references, then provokes
- * GC with Algorithms.eatMemory() and checks that all references
+ * GC with WB.fullGC() and checks that all references
  * have been cleared.
  */
 public class soft003 extends ThreadedGCTest {
 
-    class Worker implements Runnable, OOMStress {
+    class Worker implements Runnable {
 
         private int arrayLength;
         private int objectSize = 100;
@@ -60,7 +64,7 @@ public void run() {
             for (int i = 0; i < arrayLength; ++i) {
                 references[i] = new SoftReference<MemoryObject>(new MemoryObject(LocalRandom.nextInt(objectSize)));
             }
-            Algorithms.eatMemory(getExecutionController());
+            WhiteBox.getWhiteBox().fullGC();
             if (!getExecutionController().continueExecution()) {
                 return;
             }