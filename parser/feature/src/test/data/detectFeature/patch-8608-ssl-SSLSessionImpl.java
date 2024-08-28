@@ -24,7 +24,7 @@
  */
 package sun.security.ssl;
 
-import sun.security.x509.X509CertImpl;
+import sun.security.provider.X509Factory;
 
 import java.io.IOException;
 import java.math.BigInteger;
@@ -459,7 +459,7 @@ final class SSLSessionImpl extends ExtendedSSLSession {
                 b = new byte[buf.getInt()];
                 buf.get(b);
                 try {
-                    this.peerCerts[j] = new X509CertImpl(b);
+                    this.peerCerts[j] = X509Factory.cachedGetX509Cert(b);
                 } catch (Exception e) {
                     throw new IOException(e);
                 }
@@ -480,7 +480,7 @@ final class SSLSessionImpl extends ExtendedSSLSession {
                     b = new byte[buf.getInt()];
                     buf.get(b);
                     try {
-                        this.localCerts[i] = new X509CertImpl(b);
+                        this.localCerts[i] = X509Factory.cachedGetX509Cert(b);
                     } catch (Exception e) {
                         throw new IOException(e);
                     }