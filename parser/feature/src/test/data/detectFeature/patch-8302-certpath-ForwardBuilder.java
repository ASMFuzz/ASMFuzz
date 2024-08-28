@@ -81,8 +81,8 @@ final class ForwardBuilder extends Builder {
 
         // populate sets of trusted certificates and subject DNs
         trustAnchors = buildParams.trustAnchors();
-        trustedCerts = new HashSet<X509Certificate>(trustAnchors.size());
-        trustedSubjectDNs = new HashSet<X500Principal>(trustAnchors.size());
+        trustedCerts = HashSet.newHashSet(trustAnchors.size());
+        trustedSubjectDNs = HashSet.newHashSet(trustAnchors.size());
         for (TrustAnchor anchor : trustAnchors) {
             X509Certificate trustedCert = anchor.getTrustedCert();
             if (trustedCert != null) {