@@ -230,7 +230,7 @@ private static class DefaultOptionsHolder {
         static final Set<SocketOption<?>> defaultOptions = defaultOptions();
 
         private static Set<SocketOption<?>> defaultOptions() {
-            HashSet<SocketOption<?>> set = new HashSet<>(2);
+            HashSet<SocketOption<?>> set = HashSet.newHashSet(2);
             set.add(StandardSocketOptions.SO_RCVBUF);
             set.add(StandardSocketOptions.SO_REUSEADDR);
             if (Net.isReusePortAvailable()) {