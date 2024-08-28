@@ -562,34 +562,38 @@ private static native void bind0(FileDescriptor fd, boolean preferIPv6,
 
     static native void listen(FileDescriptor fd, int backlog) throws IOException;
 
-    static int connect(FileDescriptor fd, InetAddress remote, int remotePort)
+    static int connect(FileDescriptor fd, InetAddress remote, int remotePort,
+                       boolean isBound)
         throws IOException
     {
-        return connect(UNSPEC, fd, remote, remotePort);
+        return connect(UNSPEC, fd, remote, remotePort, isBound);
     }
 
-    static int connect(ProtocolFamily family, FileDescriptor fd, InetAddress remote, int remotePort)
+    static int connect(ProtocolFamily family, FileDescriptor fd,
+                       InetAddress remote, int remotePort, boolean isBound)
         throws IOException
     {
         if (remote.isLinkLocalAddress()) {
             remote = IPAddressUtil.toScopedAddress(remote);
         }
         boolean preferIPv6 = isIPv6Available() &&
             (family != StandardProtocolFamily.INET);
-        return connect0(preferIPv6, fd, remote, remotePort);
+        return connect0(preferIPv6, fd, remote, remotePort, isBound);
     }
 
-    static int connect(ProtocolFamily family, FileDescriptor fd, SocketAddress remote)
+    static int connect(ProtocolFamily family, FileDescriptor fd,
+                       SocketAddress remote, boolean isBound)
         throws IOException
     {
         InetSocketAddress isa = (InetSocketAddress) remote;
-        return connect(family, fd, isa.getAddress(), isa.getPort());
+        return connect(family, fd, isa.getAddress(), isa.getPort(), isBound);
     }
 
     private static native int connect0(boolean preferIPv6,
                                        FileDescriptor fd,
                                        InetAddress remote,
-                                       int remotePort)
+                                       int remotePort,
+                                       boolean isBound)
         throws IOException;
 
     public static native int accept(FileDescriptor fd,