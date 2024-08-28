@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2013, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2013, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -39,8 +39,8 @@
  * @modules java.base/jdk.internal.misc
  *          java.management
  *          jdk.internal.jvmstat/sun.jvmstat.monitor
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:-UseCompressedOops -XX:-UseCompressedClassPointers -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
- * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -XX:+UseCompressedOops -XX:+UseCompressedClassPointers -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
+ * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -Xlog:class+load,class+unload=trace -XX:-UseCompressedOops -XX:-UseCompressedClassPointers -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
+ * @run main/othervm -XX:+IgnoreUnrecognizedVMOptions -Xlog:class+load,class+unload=trace -XX:+UseCompressedOops -XX:+UseCompressedClassPointers -XX:+UseSerialGC -XX:+UsePerfData -Xint gc.metaspace.TestPerfCountersAndMemoryPools
  */
 public class TestPerfCountersAndMemoryPools {
     public static void main(String[] args) throws Exception {
@@ -80,10 +80,19 @@ private static void checkMemoryUsage(String memoryPoolName, String perfNS)
         System.gc();
         assertEQ(getMinCapacity(perfNS), pool.getUsage().getInit(), "MinCapacity out of sync");
 
-        // Adding a second GC due to metadata allocations caused by getting the
-        // initial size from the pool. This is needed when running with -Xcomp.
-        System.gc();
-        assertEQ(getUsed(perfNS), pool.getUsage().getUsed(), "Used out of sync");
+        long usedPerfCounters;
+        long usedMXBean;
+
+        // the pool.getUsage().getUsed() might load additional classes intermittently
+        // so first verify that perfCounters are not changed, call System.gc() to reset them
+        do {
+            System.gc();
+            usedPerfCounters = getUsed(perfNS);
+            usedMXBean = pool.getUsage().getUsed();
+            System.gc();
+        } while (usedPerfCounters != getUsed(perfNS));
+        assertEQ(usedPerfCounters, usedMXBean, "Used out of sync");
+
         assertEQ(getCapacity(perfNS), pool.getUsage().getCommitted(), "Committed out of sync");
     }
 