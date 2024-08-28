@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2014, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -95,6 +95,24 @@ public static void test1() {
      */
     @Test
     public static void test2() {
+
+        // Please note (JDK-8284282):
+        //
+        // On Unix, this test relies on the ability of the system to adopt orphaned processes and
+        // reap them in a timely fashion. In other words, the ability to prevent orphans from becoming
+        // zombies.
+        //
+        // Therefore, on misconfigured or broken systems, this test may fail. These failures will manifest
+        // as timeouts. The failures depend on timing: they may not happen at all, be intermittent or
+        // constant.
+        //
+        // That will rarely be a problem on bare-metal systems but may be more common when running in
+        // Docker. Misconfigured Docker instances may run with an initial process unable to reap. One
+        // infamous example would be running jtreg tests inside a Docker via Jenkins CI.
+        //
+        // This is quite difficult - and inefficient - to fix inside this test, and rather easy to
+        // avoid. For a detailed analysis, as well as proposed workarounds, please see JDK-8284282.
+        //
         ProcessHandle procHandle = null;
         try {
             ConcurrentHashMap<ProcessHandle, ProcessHandle> processes = new ConcurrentHashMap<>();