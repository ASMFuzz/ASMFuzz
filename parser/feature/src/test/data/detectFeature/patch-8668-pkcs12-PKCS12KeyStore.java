@@ -407,6 +407,8 @@ public Key engineGetKey(String alias, char[] password)
                         byte[] keyBytes = in.getOctetString();
                         if (keyAlgo.equals(KnownOIDs.OIW_DES_CBC.stdName())) {
                             keyAlgo = "DES";
+                        } else if (keyAlgo.equals(KnownOIDs.RC2$CBC$PKCS5Padding.stdName())) {
+                            keyAlgo = "RC2";
                         }
                         SecretKeySpec secretKeySpec =
                                 new SecretKeySpec(keyBytes, keyAlgo);