@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -82,7 +82,10 @@
  *
  * @library /vmTestbase
  *          /test/lib
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
  * @run main/othervm
+ *      -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI
  *      gc.gctests.WeakReferenceGC.WeakReferenceGC
  *      -numList 50
  *      -qFactor 0.9
@@ -94,10 +97,11 @@
 
 import java.util.*;
 import java.lang.ref.*;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.TestFailure;
 import nsk.share.gc.GC;
 import nsk.share.gc.ThreadedGCTest;
-import nsk.share.gc.gp.GarbageUtils;
 
 public class WeakReferenceGC extends ThreadedGCTest {
 
@@ -198,9 +202,7 @@ private void persistentGC() {
                         if (!getExecutionController().continueExecution()) {
                                 return;
                         }
-                        if (GarbageUtils.eatMemory(getExecutionController()) == 0) {
-                                return; // We were unable to provoke OOME before timeout is over
-                        }
+                        WhiteBox.getWhiteBox().fullGC();
                         try {
                                 while ((numEnqueued < numLists) &&
                                        (refQueue.remove(1000) != null)) {