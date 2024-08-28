@@ -384,7 +384,7 @@ private static Collection<TCPTransport> allKnownTransports() {
         Set<TCPTransport> s;
         synchronized (localEndpoints) {
             // presize s to number of localEndpoints
-            s = new HashSet<TCPTransport>(localEndpoints.size());
+            s = HashSet.newHashSet(localEndpoints.size());
             for (LinkedList<TCPEndpoint> epList : localEndpoints.values()) {
                 /*
                  * Each local endpoint has its transport added to s.