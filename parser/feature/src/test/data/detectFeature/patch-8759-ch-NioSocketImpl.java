@@ -573,7 +573,7 @@ protected void connect(SocketAddress remote, int millis) throws IOException {
                 FileDescriptor fd = beginConnect(address, port);
                 try {
                     configureNonBlockingIfNeeded(fd, millis > 0);
-                    int n = Net.connect(fd, address, port);
+                    int n = Net.connect(fd, address, port, localport != 0);
                     if (n > 0) {
                         // connection established
                         connected = true;