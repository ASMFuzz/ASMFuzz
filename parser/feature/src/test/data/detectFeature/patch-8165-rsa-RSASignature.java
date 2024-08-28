@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -47,7 +47,7 @@
  * @since   1.5
  * @author  Andreas Sterbenz
  */
-public abstract class RSASignature extends SignatureSpi {
+abstract class RSASignature extends SignatureSpi {
 
     // we sign an ASN.1 SEQUENCE of AlgorithmId and digest
     // it has the form 30:xx:30:xx:[digestOID]:05:00:04:xx:[digest]
@@ -188,7 +188,7 @@ protected byte[] engineSign() throws SignatureException {
         }
         byte[] digest = getDigestValue();
         try {
-            byte[] encoded = encodeSignature(digestOID, digest);
+            byte[] encoded = RSAUtil.encodeSignature(digestOID, digest);
             byte[] padded = padding.pad(encoded);
             byte[] encrypted = RSACore.rsa(padded, privateKey, true);
             return encrypted;
@@ -215,7 +215,7 @@ protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
             byte[] digest = getDigestValue();
             byte[] decrypted = RSACore.rsa(sigBytes, publicKey);
             byte[] unpadded = padding.unpad(decrypted);
-            byte[] decodedDigest = decodeSignature(digestOID, unpadded);
+            byte[] decodedDigest = RSAUtil.decodeSignature(digestOID, unpadded);
             return MessageDigest.isEqual(digest, decodedDigest);
         } catch (javax.crypto.BadPaddingException e) {
             // occurs if the app has used the wrong RSA public key
@@ -230,44 +230,6 @@ protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
         }
     }
 
-    /**
-     * Encode the digest, return the to-be-signed data.
-     * Also used by the PKCS#11 provider.
-     */
-    public static byte[] encodeSignature(ObjectIdentifier oid, byte[] digest)
-            throws IOException {
-        DerOutputStream out = new DerOutputStream();
-        new AlgorithmId(oid).encode(out);
-        out.putOctetString(digest);
-        DerValue result =
-            new DerValue(DerValue.tag_Sequence, out.toByteArray());
-        return result.toByteArray();
-    }
-
-    /**
-     * Decode the signature data. Verify that the object identifier matches
-     * and return the message digest.
-     */
-    public static byte[] decodeSignature(ObjectIdentifier oid, byte[] sig)
-            throws IOException {
-        // Enforce strict DER checking for signatures
-        DerInputStream in = new DerInputStream(sig, 0, sig.length, false);
-        DerValue[] values = in.getSequence(2);
-        if ((values.length != 2) || (in.available() != 0)) {
-            throw new IOException("SEQUENCE length error");
-        }
-        AlgorithmId algId = AlgorithmId.parse(values[0]);
-        if (algId.getOID().equals(oid) == false) {
-            throw new IOException("ObjectIdentifier mismatch: "
-                + algId.getOID());
-        }
-        if (algId.getEncodedParams() != null) {
-            throw new IOException("Unexpected AlgorithmId parameters");
-        }
-        byte[] digest = values[1].getOctetString();
-        return digest;
-    }
-
     // set parameter, not supported. See JCA doc
     @Deprecated
     @Override