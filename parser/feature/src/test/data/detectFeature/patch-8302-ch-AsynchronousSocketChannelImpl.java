@@ -503,7 +503,7 @@ private static class DefaultOptionsHolder {
         static final Set<SocketOption<?>> defaultOptions = defaultOptions();
 
         private static Set<SocketOption<?>> defaultOptions() {
-            HashSet<SocketOption<?>> set = new HashSet<>(5);
+            HashSet<SocketOption<?>> set = HashSet.newHashSet(5);
             set.add(StandardSocketOptions.SO_SNDBUF);
             set.add(StandardSocketOptions.SO_RCVBUF);
             set.add(StandardSocketOptions.SO_KEEPALIVE);