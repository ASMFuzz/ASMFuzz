@@ -109,7 +109,7 @@ protected SSLServerSocket(int port)
      * The <code>backlog</code> argument is the requested maximum number of
      * pending connections on the socket. Its exact semantics are implementation
      * specific. In particular, an implementation may impose a maximum length
-     * or may choose to ignore the parameter altogther. The value provided
+     * or may choose to ignore the parameter altogether. The value provided
      * should be greater than <code>0</code>. If it is less than or equal to
      * <code>0</code>, then an implementation specific default will be used.
      * <P>
@@ -154,7 +154,7 @@ protected SSLServerSocket(int port, int backlog)
      * The <code>backlog</code> argument is the requested maximum number of
      * pending connections on the socket. Its exact semantics are implementation
      * specific. In particular, an implementation may impose a maximum length
-     * or may choose to ignore the parameter altogther. The value provided
+     * or may choose to ignore the parameter altogether. The value provided
      * should be greater than <code>0</code>. If it is less than or equal to
      * <code>0</code>, then an implementation specific default will be used.
      * <P>
@@ -238,7 +238,7 @@ protected SSLServerSocket(int port, int backlog, InetAddress address)
      * @see #getSupportedCipherSuites()
      * @see #getEnabledCipherSuites()
      */
-    public abstract void setEnabledCipherSuites(String suites []);
+    public abstract void setEnabledCipherSuites(String[] suites);
 
 
     /**
@@ -309,7 +309,7 @@ protected SSLServerSocket(int port, int backlog, InetAddress address)
      * @see #getEnabledProtocols()
      * @see #getSupportedProtocols()
      */
-    public abstract void setEnabledProtocols(String protocols[]);
+    public abstract void setEnabledProtocols(String[] protocols);
 
 
     /**
@@ -545,10 +545,8 @@ public void setSSLParameters(SSLParameters params) {
 
         if (params.getNeedClientAuth()) {
             setNeedClientAuth(true);
-        } else if (params.getWantClientAuth()) {
-            setWantClientAuth(true);
         } else {
-            setWantClientAuth(false);
+            setWantClientAuth(params.getWantClientAuth());
         }
     }
 