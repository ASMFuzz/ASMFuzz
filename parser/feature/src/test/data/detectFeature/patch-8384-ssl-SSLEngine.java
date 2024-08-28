@@ -68,7 +68,7 @@
  * using the {@link #getSession()} method.
  * <P>
  * The {@code SSLSocket} class provides much of the same security
- * functionality, but all of the inbound and outbound data is
+ * functionality, but all the inbound and outbound data is
  * automatically transported using the underlying {@link
  * java.net.Socket Socket}, which by design uses a blocking model.
  * While this is appropriate for many applications, this model does not
@@ -870,7 +870,7 @@ public abstract SSLEngineResult unwrap(ByteBuffer src,
      * accept any more inbound data messages.
      *
      * @return  true if the {@code SSLEngine} will not
-     *          consume anymore network data (and by implication,
+     *          consume any more network data (and by implication,
      *          will not produce any more application data.)
      * @see     #closeInbound()
      */
@@ -974,7 +974,7 @@ public abstract SSLEngineResult unwrap(ByteBuffer src,
      * for a certain cipher suite.
      * <P>
      * See {@link #getEnabledCipherSuites()} for more information
-     * on why a specific cipher suite may never be used on a engine.
+     * on why a specific cipher suite may never be used on an engine.
      *
      * @param   suites Names of all the cipher suites to enable
      * @throws  IllegalArgumentException when one or more of the ciphers
@@ -1031,7 +1031,7 @@ public abstract SSLEngineResult unwrap(ByteBuffer src,
      * Returns the {@code SSLSession} in use in this
      * {@code SSLEngine}.
      * <P>
-     * These can be long lived, and frequently correspond to an entire
+     * These can be long-lived, and frequently correspond to an entire
      * login session for some user.  The session specifies a particular
      * cipher suite which is being actively used by all connections in
      * that session, as well as the identities of the session's client
@@ -1336,10 +1336,8 @@ public void setSSLParameters(SSLParameters params) {
         }
         if (params.getNeedClientAuth()) {
             setNeedClientAuth(true);
-        } else if (params.getWantClientAuth()) {
-            setWantClientAuth(true);
         } else {
-            setWantClientAuth(false);
+            setWantClientAuth(params.getWantClientAuth());
         }
     }
 