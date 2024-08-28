@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2017, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,16 +58,16 @@
 public class EncryptedPrivateKeyInfo {
 
     // the "encryptionAlgorithm" field
-    private AlgorithmId algid;
+    private final AlgorithmId algid;
 
     // the algorithm name of the encrypted private key
     private String keyAlg;
 
     // the "encryptedData" field
-    private byte[] encryptedData;
+    private final byte[] encryptedData;
 
     // the ASN.1 encoded contents of this class
-    private byte[] encoded = null;
+    private byte[] encoded;
 
     /**
      * Constructs (i.e., parses) an <code>EncryptedPrivateKeyInfo</code> from
@@ -124,7 +124,7 @@ public EncryptedPrivateKeyInfo(byte[] encoded) throws IOException {
      * Java Security Standard Algorithm Names</a> document
      * for information about standard Cipher algorithm names.
      * @param encryptedData encrypted data. The contents of
-     * <code>encrypedData</code> are copied to protect against subsequent
+     * <code>encryptedData</code> are copied to protect against subsequent
      * modification when constructing this object.
      * @exception NullPointerException if <code>algName</code> or
      * <code>encryptedData</code> is null.
@@ -162,10 +162,10 @@ public EncryptedPrivateKeyInfo(String algName, byte[] encryptedData)
      * @param algParams the algorithm parameters for the encryption
      * algorithm. <code>algParams.getEncoded()</code> should return
      * the ASN.1 encoded bytes of the <code>parameters</code> field
-     * of the <code>AlgorithmIdentifer</code> component of the
+     * of the <code>AlgorithmIdentifier</code> component of the
      * <code>EncryptedPrivateKeyInfo</code> type.
      * @param encryptedData encrypted data. The contents of
-     * <code>encrypedData</code> are copied to protect against
+     * <code>encryptedData</code> are copied to protect against
      * subsequent modification when constructing this object.
      * @exception NullPointerException if <code>algParams</code> or
      * <code>encryptedData</code> is null.
@@ -248,7 +248,7 @@ public byte[] getEncryptedData() {
      */
     public PKCS8EncodedKeySpec getKeySpec(Cipher cipher)
         throws InvalidKeySpecException {
-        byte[] encoded = null;
+        byte[] encoded;
         try {
             encoded = cipher.doFinal(encryptedData);
             checkPKCS8Encoding(encoded);
@@ -264,7 +264,7 @@ public PKCS8EncodedKeySpec getKeySpec(Cipher cipher)
     private PKCS8EncodedKeySpec getKeySpecImpl(Key decryptKey,
         Provider provider) throws NoSuchAlgorithmException,
         InvalidKeyException {
-        byte[] encoded = null;
+        byte[] encoded;
         Cipher c;
         try {
             if (provider == null) {