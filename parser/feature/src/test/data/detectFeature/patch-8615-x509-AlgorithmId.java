@@ -256,15 +256,25 @@ public final ObjectIdentifier getOID () {
     }
 
     /**
-     * Returns a name for the algorithm which may be more intelligible
+     * Returns a name for the algorithm which can be used by getInstance()
+     * call of a crypto primitive. The name is usually more intelligible
      * to humans than the algorithm's OID, but which won't necessarily
      * be comprehensible on other systems.  For example, this might
      * return a name such as "MD5withRSA" for a signature algorithm on
-     * some systems.  It also returns names like "OID.1.2.3.4", when
-     * no particular name for the algorithm is known.
+     * some systems.  It also returns OID names like "1.2.3.4", when
+     * no particular name for the algorithm is known. The OID may also be
+     * recognized by getInstance() calls since an OID is usually defined
+     * as an alias for an algorithm by the security provider.
      *
-     * Note: for ecdsa-with-SHA2 plus hash algorithm (Ex: SHA-256), this method
+     * In some special cases where the OID does not include enough info
+     * to return a Java standard algorithm name, an algorithm name
+     * that includes info on the params is returned:
+     *
+     * 1. For ecdsa-with-SHA2 plus hash algorithm (Ex: SHA-256), this method
      * returns the "full" signature algorithm (Ex: SHA256withECDSA) directly.
+     *
+     * 2. For PBES2, this method returns the "full" cipher name containing the
+     * KDF and Enc algorithms (Ex: PBEWithHmacSHA256AndAES_256) directly.
      */
     public String getName() {
         String oidStr = algid.toString();
@@ -281,6 +291,14 @@ public String getName() {
                     // ignore
                 }
             }
+        } else if (o == KnownOIDs.PBES2) {
+            if (algParams != null) {
+                return algParams.toString();
+            } else {
+                // when getName() is called in decodeParams(), algParams is
+                // null, where AlgorithmParameters.getInstance("PBES2") will
+                // be used to initialize it.
+            }
         }
         if (o != null) {
             return o.stdName();