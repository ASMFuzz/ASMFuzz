@@ -221,7 +221,7 @@ public class Cipher {
     private CipherSpi spi;
 
     // The transformation
-    private String transformation;
+    private final String transformation;
 
     // Crypto permission representing the maximum allowable cryptographic
     // strength that this Cipher object can be used for. (The cryptographic