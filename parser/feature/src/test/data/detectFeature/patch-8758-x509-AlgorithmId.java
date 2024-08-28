@@ -213,10 +213,14 @@ public void derEncode (OutputStream out) throws IOException {
                     || algid.equals(ed25519_oid)
                     || algid.equals(x448_oid)
                     || algid.equals(x25519_oid)
+                    || algid.equals(SHA1withECDSA_oid)
                     || algid.equals(SHA224withECDSA_oid)
                     || algid.equals(SHA256withECDSA_oid)
                     || algid.equals(SHA384withECDSA_oid)
                     || algid.equals(SHA512withECDSA_oid)) {
+                // RFC 3279 2.2.3: When the ecdsa-with-SHA1 algorithm identifier
+                // appears as the algorithm field in an AlgorithmIdentifier,
+                // the encoding MUST omit the parameters field.
                 // RFC 4055 3.3: when an RSASSA-PSS key does not require
                 // parameter validation, field is absent.
                 // RFC 8410 3: for id-X25519, id-X448, id-Ed25519, and
@@ -692,6 +696,8 @@ private static ConcurrentHashMap<String, String> collectOIDAliases() {
     public static final ObjectIdentifier x448_oid =
             ObjectIdentifier.of(KnownOIDs.X448);
 
+    public static final ObjectIdentifier SHA1withECDSA_oid =
+            ObjectIdentifier.of(KnownOIDs.SHA1withECDSA);
     public static final ObjectIdentifier SHA224withECDSA_oid =
             ObjectIdentifier.of(KnownOIDs.SHA224withECDSA);
     public static final ObjectIdentifier SHA256withECDSA_oid =