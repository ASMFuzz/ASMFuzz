@@ -877,7 +877,7 @@ public boolean connect(SocketAddress remote) throws IOException {
                         if (isUnixSocket()) {
                             n = UnixDomainSockets.connect(fd, sa);
                         } else {
-                            n = Net.connect(family, fd, sa);
+                            n = Net.connect(family, fd, sa, localAddress != null);
                         }
                         if (n > 0) {
                             connected = true;
@@ -1228,7 +1228,7 @@ void blockingConnect(SocketAddress remote, long nanos) throws IOException {
                             if (isUnixSocket()) {
                                 n = UnixDomainSockets.connect(fd, sa);
                             } else {
-                                n = Net.connect(family, fd, sa);
+                                n = Net.connect(family, fd, sa, localAddress != null);
                             }
                             connected = (n > 0) ? true : finishTimedConnect(nanos);
                         } finally {