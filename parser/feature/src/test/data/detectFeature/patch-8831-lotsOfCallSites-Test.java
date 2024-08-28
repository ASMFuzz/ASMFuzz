@@ -124,11 +124,11 @@ private static int removeQueuedReferences() {
         return count;
     }
 
-    private MemoryPoolMXBean getClassMetadataMemoryPoolMXBean() {
-    MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
-    for (MemoryPoolMXBean memPool : ManagementFactory.getMemoryPoolMXBeans()) {
+    private MemoryPoolMXBean getMetaspaceMemoryPoolMXBean() {
+        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
+        for (MemoryPoolMXBean memPool : ManagementFactory.getMemoryPoolMXBeans()) {
             String name = memPool.getName();
-        if ((name.contains("Compressed class space") || name.contains("Metaspace")) && memPool.getUsage() != null) {
+            if (name.contains("Metaspace") && memPool.getUsage() != null) {
                 return memPool;
             }
         }
@@ -140,8 +140,8 @@ public boolean run() throws Throwable {
         setHeapDumpAfter(heapDumpOpt);
 
         final byte[] classBytes = FileUtils.readClass(TESTEE_CLASS_NAME);
-        final MemoryPoolMXBean classMetadataPoolMXB = getClassMetadataMemoryPoolMXBean();
-        final String memPoolName = classMetadataPoolMXB == null ? "" : classMetadataPoolMXB.getName();
+        final MemoryPoolMXBean metaspacePoolMXB = getMetaspaceMemoryPoolMXBean();
+        final String memPoolName = metaspacePoolMXB == null ? "" : metaspacePoolMXB.getName();
 
         int removedEntries = 0;
 
@@ -156,8 +156,8 @@ public boolean run() throws Throwable {
 
                 if (stresser.getIteration() % 1000 == 0) {
                     Env.traceNormal("Iterations: " + stresser.getIteration() + " removed entries: " + removedEntries);
-                    if (TERMINATE_ON_FULL_METASPACE && classMetadataPoolMXB != null) {
-                        MemoryUsage mu = classMetadataPoolMXB.getUsage();
+                    if (TERMINATE_ON_FULL_METASPACE && metaspacePoolMXB != null) {
+                        MemoryUsage mu = metaspacePoolMXB.getUsage();
                         Env.traceNormal(memPoolName + " usage: " + mu);
                         if  (mu.getUsed() >= mu.getMax() * 9 / 10) {
                             Env.traceNormal(memPoolName + " is nearly out of space: " + mu + ". Terminating.");