@@ -4070,7 +4070,7 @@ private Certificate[] validateReply(String alias,
      *                 It must have the same public key as certToVerify
      *                 but cannot be the same cert.
      * @param certToVerify the starting certificate to build the chain
-     * @returns the established chain, might be null if user decides not
+     * @return the established chain, might be null if user decides not
      */
     private Certificate[] establishCertChain(Certificate userCert,
                                              Certificate certToVerify)