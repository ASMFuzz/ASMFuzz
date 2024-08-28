@@ -58,7 +58,7 @@ public Map<String, Long> getInternalThreadCpuTimes() {
         String[] names = new String[count];
         long[] times = new long[count];
         int numThreads = getInternalThreadTimes0(names, times);
-        Map<String, Long> result = new HashMap<>(numThreads);
+        Map<String, Long> result = HashMap.newHashMap(numThreads);
         for (int i = 0; i < numThreads; i++) {
             result.put(names[i], times[i]);
         }