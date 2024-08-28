@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2007, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,22 +30,25 @@
  *
  * @library /vmTestbase
  *          /test/lib
- * @run main/othervm -XX:-UseGCOverheadLimit gc.gctests.WeakReference.weak003.weak003 -t 1
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
+ * @run main/othervm -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI gc.gctests.WeakReference.weak003.weak003 -t 1
  */
 
 package gc.gctests.WeakReference.weak003;
 
 import java.lang.ref.Reference;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.test.*;
-import nsk.share.TestFailure;
 import nsk.share.gc.*;
 import java.lang.ref.WeakReference;
 
 /**
  * Test that GC clears weak references before throwing OOM.
  *
  * This test creates a number of weak references, then provokes
- * GC with Algorithms.eatMemory and checks that all references
+ * GC with WB.fullGC() and checks that all references
  * have been cleared.
  *
  * This assertion is not clearly stated in javadoc for WeakReference,
@@ -54,7 +57,7 @@
  */
 public class weak003 extends ThreadedGCTest {
 
-    class Worker implements Runnable, OOMStress {
+    class Worker implements Runnable {
 
         private int arrayLength;
         private int objectSize = 100;
@@ -64,7 +67,7 @@ public void run() {
             for (int i = 0; i < arrayLength; ++i) {
                 references[i] = new WeakReference<MemoryObject>(new MemoryObject(LocalRandom.nextInt(objectSize)));
             }
-            Algorithms.eatMemory(getExecutionController());
+            WhiteBox.getWhiteBox().fullGC();
             if (!getExecutionController().continueExecution()) {
                 return;
             }
@@ -77,7 +80,7 @@ public void run() {
             }
             if (n != 0) {
                 references = null;
-                throw new TestFailure("Some of the references have been not cleared: " + n);
+                throw new RuntimeException("Some of the references have been not cleared: " + n);
             }
         }
 