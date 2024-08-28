@@ -215,6 +215,10 @@ protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
             byte[] digest = getDigestValue();
             byte[] decrypted = RSACore.rsa(sigBytes, publicKey);
             byte[] unpadded = padding.unpad(decrypted);
+            // https://www.rfc-editor.org/rfc/rfc8017.html#section-8.2.2
+            // Step 4 suggests comparing the encoded message instead of the
+            // decoded, but some vendors might omit the NULL params in
+            // digest algorithm identifier.
             byte[] decodedDigest = RSAUtil.decodeSignature(digestOID, unpadded);
             return MessageDigest.isEqual(digest, decodedDigest);
         } catch (javax.crypto.BadPaddingException e) {