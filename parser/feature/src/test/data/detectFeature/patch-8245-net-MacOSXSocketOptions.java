@@ -78,6 +78,16 @@ int getTcpKeepAliveIntvl(int fd) throws SocketException {
         return getTcpKeepAliveIntvl0(fd);
     }
 
+    @Override
+    void setIpDontFragment(int fd, final boolean value) throws SocketException {
+        setIpDontFragment0(fd, value);
+    }
+
+    @Override
+    boolean getIpDontFragment(int fd) throws SocketException {
+        return getIpDontFragment0(fd);
+    }
+
     @Override
     UnixDomainPrincipal getSoPeerCred(int fd) throws SocketException {
         long l = getSoPeerCred0(fd);
@@ -91,9 +101,11 @@ UnixDomainPrincipal getSoPeerCred(int fd) throws SocketException {
     private static native void setTcpkeepAliveProbes0(int fd, int value) throws SocketException;
     private static native void setTcpKeepAliveTime0(int fd, int value) throws SocketException;
     private static native void setTcpKeepAliveIntvl0(int fd, int value) throws SocketException;
+    private static native void setIpDontFragment0(int fd, boolean value) throws SocketException;
     private static native int getTcpkeepAliveProbes0(int fd) throws SocketException;
     private static native int getTcpKeepAliveTime0(int fd) throws SocketException;
     private static native int getTcpKeepAliveIntvl0(int fd) throws SocketException;
+    private static native boolean getIpDontFragment0(int fd) throws SocketException;
     private static native long getSoPeerCred0(int fd) throws SocketException;
     private static native boolean keepAliveOptionsSupported0();
     static {