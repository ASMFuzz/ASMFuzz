@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -80,9 +80,6 @@ abstract class ECDSASignature extends SignatureSpi {
     // public key, if initialized for verifying
     private ECPublicKey publicKey;
 
-    // signature parameters
-    private ECParameterSpec sigParams = null;
-
     // The format. true for the IEEE P1363 format. false (default) for ASN.1
     private final boolean p1363Format;
 
@@ -347,10 +344,6 @@ public SHA3_512inP1363Format() {
     protected void engineInitVerify(PublicKey publicKey)
     throws InvalidKeyException {
         ECPublicKey key = (ECPublicKey) ECKeyFactory.toECKey(publicKey);
-        if (!isCompatible(this.sigParams, key.getParams())) {
-            throw new InvalidKeyException("Key params does not match signature params");
-        }
-
         // Should check that the supplied key is appropriate for signature
         // algorithm (e.g. P-256 for SHA256withECDSA)
         this.publicKey = key;
@@ -370,10 +363,6 @@ protected void engineInitSign(PrivateKey privateKey)
     protected void engineInitSign(PrivateKey privateKey, SecureRandom random)
     throws InvalidKeyException {
         ECPrivateKey key = (ECPrivateKey) ECKeyFactory.toECKey(privateKey);
-        if (!isCompatible(this.sigParams, key.getParams())) {
-            throw new InvalidKeyException("Key params does not match signature params");
-        }
-
         ECUtil.checkPrivateKey(key);
         // Should check that the supplied key is appropriate for signature
         // algorithm (e.g. P-256 for SHA256withECDSA)
@@ -430,15 +419,6 @@ protected void engineUpdate(ByteBuffer byteBuffer) {
         needsReset = true;
     }
 
-    private static boolean isCompatible(ECParameterSpec sigParams,
-            ECParameterSpec keyParams) {
-        if (sigParams == null) {
-            // no restriction on key param
-            return true;
-        }
-        return ECUtil.equals(sigParams, keyParams);
-    }
-
     private byte[] signDigestImpl(ECDSAOperations ops, int seedBits,
         byte[] digest, ECPrivateKey priv, SecureRandom random)
         throws SignatureException {
@@ -528,17 +508,21 @@ protected void engineSetParameter(String param, Object value)
 
     @Override
     protected void engineSetParameter(AlgorithmParameterSpec params)
-    throws InvalidAlgorithmParameterException {
-        if (params != null && !(params instanceof ECParameterSpec)) {
-            throw new InvalidAlgorithmParameterException("No parameter accepted");
+            throws InvalidAlgorithmParameterException {
+        // Interop: some certificates include parameters in an ECDSA
+        // algorithm identifier. We only accept one matching the key.
+        if (params == null) {
+            return;
+        }
+        if (!(params instanceof ECParameterSpec ecparams)) {
+            throw new InvalidAlgorithmParameterException(
+                    "Parameters must be of type ECParameterSpec");
         }
         ECKey key = (this.privateKey == null? this.publicKey : this.privateKey);
-        if ((key != null) && !isCompatible((ECParameterSpec)params, key.getParams())) {
+        if ((key != null) && !ECUtil.equals(ecparams, key.getParams())) {
             throw new InvalidAlgorithmParameterException
                 ("Signature params does not match key params");
         }
-
-        sigParams = (ECParameterSpec) params;
     }
 
     // get parameter, not supported. See JCA doc
@@ -551,16 +535,9 @@ protected Object engineGetParameter(String param)
 
     @Override
     protected AlgorithmParameters engineGetParameters() {
-        if (sigParams == null) {
-            return null;
-        }
-        try {
-            AlgorithmParameters ap = AlgorithmParameters.getInstance("EC");
-            ap.init(sigParams);
-            return ap;
-        } catch (Exception e) {
-            // should never happen
-            throw new ProviderException("Error retrieving EC parameters", e);
-        }
+        // Always return null even if setParameter is called before.
+        // According to RFC 3279 2.2.3 and RFC 5758 3.2, no parameters is
+        // defined for ECDSA AlgorithmIdentifiers.
+        return null;
     }
 }