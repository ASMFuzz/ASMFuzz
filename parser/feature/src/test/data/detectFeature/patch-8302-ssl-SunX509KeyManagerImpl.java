@@ -110,7 +110,7 @@ private static class X509Credentials {
             // assert privateKey and certificates != null
             this.privateKey = privateKey;
             this.certificates = certificates;
-            this.issuerX500Principals = new HashSet<>(certificates.length);
+            this.issuerX500Principals = HashSet.newHashSet(certificates.length);
             for (X509Certificate certificate : certificates) {
                 issuerX500Principals.add(certificate.getIssuerX500Principal());
             }