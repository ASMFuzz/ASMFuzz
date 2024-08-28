@@ -98,15 +98,7 @@ public Certificate engineGenerateCertificate(InputStream is)
         try {
             byte[] encoding = readOneBlock(is);
             if (encoding != null) {
-                X509CertImpl cert = getFromCache(certCache, encoding);
-                if (cert != null) {
-                    return cert;
-                }
-                cert = new X509CertImpl(encoding);
-                addToCache(certCache, cert.getEncodedInternal(), cert);
-                // record cert details if necessary
-                commitEvent(cert);
-                return cert;
+                return cachedGetX509Cert(encoding);
             } else {
                 throw new IOException("Empty input");
             }
@@ -116,6 +108,19 @@ public Certificate engineGenerateCertificate(InputStream is)
         }
     }
 
+    public static X509CertImpl cachedGetX509Cert(byte[] encoding)
+            throws CertificateException {
+        X509CertImpl cert = getFromCache(certCache, encoding);
+        if (cert != null) {
+            return cert;
+        }
+        cert = new X509CertImpl(encoding);
+        addToCache(certCache, cert.getEncodedInternal(), cert);
+        // record cert details if necessary
+        commitEvent(cert);
+        return cert;
+    }
+
     /**
      * Read from the stream until length bytes have been read or EOF has
      * been reached. Return the number of bytes actually read.
@@ -768,7 +773,7 @@ private static int readBERInternal(InputStream is,
         return tag;
     }
 
-    private void commitEvent(X509CertImpl info) {
+    private static void commitEvent(X509CertImpl info) {
         X509CertificateEvent xce = new X509CertificateEvent();
         if (xce.shouldCommit() || EventHelper.isLoggingSecurity()) {
             PublicKey pKey = info.getPublicKey();