@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2004, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,8 +39,10 @@
  *
  * @library /vmTestbase
  *          /test/lib
+ * @build jdk.test.whitebox.WhiteBox
+ * @run driver jdk.test.lib.helpers.ClassFileInstaller jdk.test.whitebox.WhiteBox
  * @run main/othervm
- *      -XX:-UseGCOverheadLimit
+ *      -Xbootclasspath/a:. -XX:+UnlockDiagnosticVMOptions -XX:+WhiteBoxAPI
  *      gc.gctests.PhantomReference.PhantomReferenceEvilTest.PhantomReferenceEvilTest
  */
 
@@ -52,11 +54,12 @@
 import java.util.ArrayList;
 import java.util.Random;
 import java.util.HashMap;
+
+import jdk.test.whitebox.WhiteBox;
 import nsk.share.TestFailure;
 import nsk.share.gc.GC;
 import nsk.share.gc.GCTestBase;
 import nsk.share.gc.Memory;
-import nsk.share.gc.gp.GarbageUtils;
 import nsk.share.test.Stresser;
 
 /**
@@ -152,7 +155,7 @@ public final void run() {
 
             Stresser stresser = new Stresser(runParams.getStressOptions());
             stresser.start(0);
-            GarbageUtils.eatMemory(stresser);
+            WhiteBox.getWhiteBox().fullGC();
             if (!stresser.continueExecution()) {
                 return; //we couldn't be sure that FullGC is triggered
             }