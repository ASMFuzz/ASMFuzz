@@ -200,6 +200,9 @@ public static byte[] decodeSignature(ObjectIdentifier oid, byte[] sig)
         if (algId.getEncodedParams() != null) {
             throw new IOException("Unexpected AlgorithmId parameters");
         }
+        if (values[1].isConstructed()) {
+            throw new IOException("Unexpected constructed digest value");
+        }
         byte[] digest = values[1].getOctetString();
         return digest;
     }