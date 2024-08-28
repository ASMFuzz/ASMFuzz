@@ -151,17 +151,10 @@ public static AlgorithmParameterSpec getParamSpec(String sigName,
                     createAlgorithmParameters(sigName, paramBytes);
                 paramSpec = RSAUtil.getParamSpec(params);
             } else if (sigName.contains("ECDSA")) {
-                try {
-                    Provider p = Signature.getInstance(sigName).getProvider();
-                    paramSpec = ECUtil.getECParameterSpec(p, paramBytes);
-                } catch (Exception e) {
-                    throw new ProviderException("Error handling EC parameters", e);
-                }
-                // ECUtil discards exception and returns null, so we need to check
-                // the returned value
-                if (paramSpec == null) {
-                    throw new ProviderException("Error handling EC parameters");
-                }
+                // Some certificates have params in an ECDSA algorithmID.
+                // According to RFC 3279 2.2.3 and RFC 5758 3.2,
+                // they are useless and should be ignored.
+                return null;
             } else {
                 throw new ProviderException
                      ("Unrecognized algorithm for signature parameters " +