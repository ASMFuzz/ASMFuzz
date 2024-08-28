@@ -433,9 +433,7 @@ protected static byte[] getPlatformCiphers() {
 
                 logger.log(Level.FINE, "DIGEST01:Platform supports {0}", JCE_CIPHER_NAME[i]);
                 ciphers[i] |= CIPHER_MASKS[i];
-            } catch (NoSuchAlgorithmException e) {
-                // no implementation found for requested algorithm.
-            } catch (NoSuchPaddingException e) {
+            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                 // no implementation found for requested algorithm.
             }
         }