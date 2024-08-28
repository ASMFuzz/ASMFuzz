@@ -69,7 +69,7 @@ protected void init(Cipher c, int mode, SecretKeySpec ks)
         }
 
         // toggle some bits in the IV to get around IV reuse defenses
-        iv[0] ^= 0xFF;
+        iv[0] ^= (byte)0xFF;
         AlgorithmParameterSpec paramSpec = makeParameterSpec();
 
         c.init(mode, ks, paramSpec);