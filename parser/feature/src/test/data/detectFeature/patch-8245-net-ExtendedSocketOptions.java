@@ -199,6 +199,28 @@ private ExtendedSocketOptions() { }
         = new ExtSocketOption<UnixDomainPrincipal>
             ("SO_PEERCRED", UnixDomainPrincipal.class);
 
+    /**
+     * Disable IP packet fragmentation.
+     *
+     * <p> The value of this socket option is a {@code Boolean} that represents
+     * whether the option is enabled or disabled. When {@code true} fragmentation
+     * of outgoing IPv4 and IPv6 packets does not occur. This option can only be used
+     * with datagram sockets. When set, care must be taken to limit outgoing packet
+     * sizes to the {@link java.net.NetworkInterface#getMTU() local MTU}. Depending
+     * on the implementation and the network interface, packets larger than the MTU
+     * may be sent or dropped silently or dropped with an exception thrown.
+     *
+     * @apiNote
+     * For IPv4 this option sets the DF (Do not Fragment) flag in the IP packet
+     * header. This instructs intermediate routers to not fragment the packet.
+     * IPv6 routers never fragment packets. Instead, fragmentation is handled
+     * by the sending and receiving nodes exclusively. Setting this option for
+     * an IPv6 socket ensures that packets to be sent are never fragmented, in
+     * which case, the local network MTU must be observed.
+     */
+    public static final SocketOption<Boolean> IP_DONTFRAGMENT =
+        new ExtSocketOption<Boolean>("IP_DONTFRAGMENT", Boolean.class);
+
     private static final PlatformSocketOptions platformSocketOptions =
             PlatformSocketOptions.get();
 
@@ -210,6 +232,7 @@ private ExtendedSocketOptions() { }
             platformSocketOptions.peerCredentialsSupported();
     private static final boolean incomingNapiIdOptSupported  =
             platformSocketOptions.incomingNapiIdSupported();
+
     private static final Set<SocketOption<?>> extendedOptions = options();
 
     static Set<SocketOption<?>> options() {
@@ -226,6 +249,7 @@ static Set<SocketOption<?>> options() {
         if (peerCredentialsSupported) {
             options.add(SO_PEERCRED);
         }
+        options.add(IP_DONTFRAGMENT);
         return Collections.unmodifiableSet(options);
     }
 
@@ -248,6 +272,8 @@ public void setOption(FileDescriptor fd,
                     setQuickAckOption(fd, (boolean) value);
                 } else if (option == TCP_KEEPCOUNT) {
                     setTcpkeepAliveProbes(fd, (Integer) value);
+                } else if (option == IP_DONTFRAGMENT) {
+                    setIpDontFragment(fd, (Boolean) value);
                 } else if (option == TCP_KEEPIDLE) {
                     setTcpKeepAliveTime(fd, (Integer) value);
                 } else if (option == TCP_KEEPINTERVAL) {
@@ -277,6 +303,8 @@ public Object getOption(FileDescriptor fd,
                     return getQuickAckOption(fd);
                 } else if (option == TCP_KEEPCOUNT) {
                     return getTcpkeepAliveProbes(fd);
+                } else if (option == IP_DONTFRAGMENT) {
+                    return getIpDontFragment(fd);
                 } else if (option == TCP_KEEPIDLE) {
                     return getTcpKeepAliveTime(fd);
                 } else if (option == TCP_KEEPINTERVAL) {
@@ -320,6 +348,11 @@ private static void setTcpKeepAliveTime(FileDescriptor fd, int value)
         platformSocketOptions.setTcpKeepAliveTime(fdAccess.get(fd), value);
     }
 
+    private static void setIpDontFragment(FileDescriptor fd, boolean value)
+            throws SocketException {
+        platformSocketOptions.setIpDontFragment(fdAccess.get(fd), value);
+    }
+
     private static void setTcpKeepAliveIntvl(FileDescriptor fd, int value)
             throws SocketException {
         platformSocketOptions.setTcpKeepAliveIntvl(fdAccess.get(fd), value);
@@ -329,6 +362,10 @@ private static int getTcpkeepAliveProbes(FileDescriptor fd) throws SocketExcepti
         return platformSocketOptions.getTcpkeepAliveProbes(fdAccess.get(fd));
     }
 
+    private static boolean getIpDontFragment(FileDescriptor fd) throws SocketException {
+        return platformSocketOptions.getIpDontFragment(fdAccess.get(fd));
+    }
+
     private static int getTcpKeepAliveTime(FileDescriptor fd) throws SocketException {
         return platformSocketOptions.getTcpKeepAliveTime(fdAccess.get(fd));
     }
@@ -368,6 +405,8 @@ public String run() {
                 return newInstance("jdk.net.LinuxSocketOptions");
             } else if (osname.startsWith("Mac")) {
                 return newInstance("jdk.net.MacOSXSocketOptions");
+            } else if (osname.startsWith("Windows")) {
+                return newInstance("jdk.net.WindowsSocketOptions");
             } else {
                 return new PlatformSocketOptions();
             }
@@ -415,6 +454,14 @@ void setTcpKeepAliveIntvl(int fd, final int value) throws SocketException {
             throw new UnsupportedOperationException("unsupported TCP_KEEPINTVL option");
         }
 
+        void setIpDontFragment(int fd, final boolean value) throws SocketException {
+            throw new UnsupportedOperationException("unsupported IP_DONTFRAGMENT option");
+        }
+
+        boolean getIpDontFragment(int fd) throws SocketException {
+            throw new UnsupportedOperationException("unsupported IP_DONTFRAGMENT option");
+        }
+
         int getTcpkeepAliveProbes(int fd) throws SocketException {
             throw new UnsupportedOperationException("unsupported TCP_KEEPCNT option");
         }