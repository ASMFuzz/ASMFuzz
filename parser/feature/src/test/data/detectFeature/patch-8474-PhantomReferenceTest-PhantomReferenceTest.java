@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,8 +36,10 @@
  *
  * @library /vmTestbase
  *          /test/lib
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
  * @run main/othervm
- *      -XX:-UseGCOverheadLimit
+ *      -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI
  *      gc.gctests.PhantomReference.PhantomReferenceTest.PhantomReferenceTest
  */
 
@@ -49,6 +51,8 @@
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Random;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.TestFailure;
 import nsk.share.gc.GC;
 import nsk.share.gc.GCTestBase;
@@ -109,7 +113,7 @@ public final void run() {
 
         Stresser stresser = new Stresser(runParams.getStressOptions());
         stresser.start(0);
-        GarbageUtils.eatMemory(stresser);
+        WhiteBox.getWhiteBox().fullGC();
         if (!stresser.continueExecution()) {
             return; //we couldn't be sure that FullGC is triggered
         }