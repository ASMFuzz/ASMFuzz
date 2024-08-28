@@ -184,7 +184,7 @@ public Map<String, MemoryManagerMXBean> nameToMBeanMap() {
                 if (list.isEmpty()) {
                     map = Collections.emptyMap();
                 } else {
-                    map = new HashMap<>(list.size());
+                    map = HashMap.newHashMap(list.size());
                     for (MemoryManagerMXBean gcm : list) {
                         map.put(gcm.getObjectName().getCanonicalName(),
                                 gcm);
@@ -278,7 +278,7 @@ public Map<String, MemoryPoolMXBean> nameToMBeanMap() {
                 if (list.isEmpty()) {
                     map = Collections.<String, MemoryPoolMXBean>emptyMap();
                 } else {
-                    map = new HashMap<>(list.size());
+                    map = HashMap.newHashMap(list.size());
                     for (MemoryPoolMXBean mpm : list) {
                         map.put(mpm.getObjectName().getCanonicalName(),
                                 mpm);
@@ -415,7 +415,7 @@ public Map<String, BufferPoolMXBean> nameToMBeanMap() {
                 if (list.isEmpty()) {
                     map = Collections.<String, BufferPoolMXBean>emptyMap();
                 } else {
-                    map = new HashMap<>(list.size());
+                    map = HashMap.newHashMap(list.size());
                     list.forEach(mbean -> map.put(mbean.getObjectName().getCanonicalName(),mbean));
                 }
                 return map;