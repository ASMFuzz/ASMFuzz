@@ -143,23 +143,24 @@
  * to read existing entries from the keystore, or to write new entries
  * into the keystore:
  * <pre>
- *    KeyStore.ProtectionParameter protParam =
+ *    KeyStore.PasswordProtection protParam =
  *        new KeyStore.PasswordProtection(password);
+ *    try (FileOutputStream fos = new FileOutputStream("newKeyStoreName")) {
+ *        // get my private key
+ *        KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
+ *            ks.getEntry("privateKeyAlias", protParam);
+ *        PrivateKey myPrivateKey = pkEntry.getPrivateKey();
  *
- *    // get my private key
- *    KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)
- *        ks.getEntry("privateKeyAlias", protParam);
- *    PrivateKey myPrivateKey = pkEntry.getPrivateKey();
- *
- *    // save my secret key
- *    javax.crypto.SecretKey mySecretKey;
- *    KeyStore.SecretKeyEntry skEntry =
- *        new KeyStore.SecretKeyEntry(mySecretKey);
- *    ks.setEntry("secretKeyAlias", skEntry, protParam);
+ *        // save my secret key
+ *        javax.crypto.SecretKey mySecretKey;
+ *        KeyStore.SecretKeyEntry skEntry =
+ *            new KeyStore.SecretKeyEntry(mySecretKey);
+ *        ks.setEntry("secretKeyAlias", skEntry, protParam);
  *
- *    // store away the keystore
- *    try (FileOutputStream fos = new FileOutputStream("newKeyStoreName")) {
+ *        // store away the keystore
  *        ks.store(fos, password);
+ *    } finally {
+ *        protParam.destroy();
  *    }
  * </pre>
  *