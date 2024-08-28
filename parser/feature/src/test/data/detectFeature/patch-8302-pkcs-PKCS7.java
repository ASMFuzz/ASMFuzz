@@ -514,7 +514,7 @@ public void encodeSignedData(DerOutputStream out)
         // CRLs (optional)
         if (crls != null && crls.length != 0) {
             // cast to X509CRLImpl[] since X509CRLImpl implements DerEncoder
-            Set<X509CRLImpl> implCRLs = new HashSet<>(crls.length);
+            Set<X509CRLImpl> implCRLs = HashSet.newHashSet(crls.length);
             for (X509CRL crl: crls) {
                 if (crl instanceof X509CRLImpl)
                     implCRLs.add((X509CRLImpl) crl);