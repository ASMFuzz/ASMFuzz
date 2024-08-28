@@ -1302,7 +1302,8 @@ DatagramChannel connect(SocketAddress sa, boolean check) throws IOException {
                     int n = Net.connect(family,
                                         fd,
                                         isa.getAddress(),
-                                        isa.getPort());
+                                        isa.getPort(),
+                                        true);
                     if (n <= 0)
                         throw new Error();      // Can't happen
 