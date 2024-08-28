@@ -333,7 +333,7 @@ <A> Future<Void> implConnect(SocketAddress remote,
             // notify hook if unbound
             if (notifyBeforeTcpConnect)
                 NetHooks.beforeTcpConnect(fd, isa.getAddress(), isa.getPort());
-            int n = Net.connect(fd, isa.getAddress(), isa.getPort());
+            int n = Net.connect(fd, isa.getAddress(), isa.getPort(), localAddress != null);
             if (n == IOStatus.UNAVAILABLE) {
                 // connection could not be established immediately
                 PendingFuture<Void,A> result = null;