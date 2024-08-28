@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2011, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -32,6 +32,7 @@
 
 import jdk.test.lib.process.OutputAnalyzer;
 import jdk.test.lib.process.ProcessTools;
+import jdk.test.lib.Platform;
 import jdk.test.lib.Utils;
 
 /*
@@ -57,6 +58,7 @@ public static void main(String[] args) throws Exception {
         testJcmdPid_f();
         testJcmdPidPerfCounterPrint();
         testJcmdPidBigScript();
+        testJcmdPidVMinfo();
     }
 
     /**
@@ -164,4 +166,21 @@ private static void verifyOutputAgainstFile(OutputAnalyzer output) throws IOExce
                 "The ouput should contain all content of " + path.toAbsolutePath());
     }
 
+    /**
+     * Sanity check for VM.info
+     */
+    private static void testJcmdPidVMinfo() throws Exception {
+        OutputAnalyzer output = JcmdBase.jcmd(VM_ARGS, new String[] {"VM.info"});
+        output.shouldHaveExitValue(0);
+        output.shouldContain(Long.toString(ProcessTools.getProcessId()) + ":");
+
+        // Should find the signal handler summary (except on Windows):
+        if (!Platform.isWindows()) {
+          output.shouldContain("Signal Handlers:");
+          // Should not find any of the possible signal handler modification warnings:
+          output.shouldNotContain(" handler modified!"); // e.g. Warning: SIGILL handler modified!
+          output.shouldNotContain("*** Handler was modified!");
+          output.shouldNotContain("*** Expected: "); // e.g. *** Expected: javaSignalHandler in ...
+        }
+    }
 }