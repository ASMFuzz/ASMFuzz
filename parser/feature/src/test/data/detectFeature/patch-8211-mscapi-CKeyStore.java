@@ -54,15 +54,30 @@
  */
 abstract class CKeyStore extends KeyStoreSpi {
 
+    private static final int LOCATION_CURRENTUSER = 0;
+    private static final int LOCATION_LOCALMACHINE = 1;
+
     public static final class MY extends CKeyStore {
         public MY() {
-            super("MY");
+            super("MY", LOCATION_CURRENTUSER);
         }
     }
 
     public static final class ROOT extends CKeyStore {
         public ROOT() {
-            super("ROOT");
+            super("ROOT", LOCATION_CURRENTUSER);
+        }
+    }
+
+    public static final class MYLocalMachine extends CKeyStore {
+        public MYLocalMachine() {
+            super("MY", LOCATION_LOCALMACHINE);
+        }
+    }
+
+    public static final class ROOTLocalMachine extends CKeyStore {
+        public ROOTLocalMachine() {
+            super("ROOT", LOCATION_LOCALMACHINE);
         }
     }
 
@@ -220,7 +235,12 @@ public void delete() throws KeyStoreException {
      */
     private final String storeName;
 
-    CKeyStore(String storeName) {
+    /*
+     * The keystore location.
+     */
+    private final int storeLocation;
+
+    CKeyStore(String storeName, int storeLocation) {
         // Get the compatibility mode
         @SuppressWarnings("removal")
         String prop = AccessController.doPrivileged(
@@ -233,6 +253,7 @@ public void delete() throws KeyStoreException {
         }
 
         this.storeName = storeName;
+        this.storeLocation = storeLocation;
     }
 
     /**
@@ -259,7 +280,7 @@ public void delete() throws KeyStoreException {
      * @exception UnrecoverableKeyException if the key cannot be recovered.
      */
     public java.security.Key engineGetKey(String alias, char[] password)
-        throws NoSuchAlgorithmException, UnrecoverableKeyException {
+            throws NoSuchAlgorithmException, UnrecoverableKeyException {
         if (alias == null) {
             return null;
         }
@@ -705,7 +726,7 @@ public void engineLoad(InputStream stream, char[] password)
         try {
 
             // Load keys and/or certificate chains
-            loadKeysOrCertificateChains(getName());
+            loadKeysOrCertificateChains(getName(), getLocation());
 
         } catch (KeyStoreException e) {
             throw new IOException(e);
@@ -801,7 +822,7 @@ private void generateKeyAndCertificateChain(boolean isRSA, String alias,
      * @param certCollection Collection of certificates.
      */
     private void generateCertificate(byte[] data,
-        Collection<Certificate> certCollection) {
+            Collection<Certificate> certCollection) {
         try {
             ByteArrayInputStream bis = new ByteArrayInputStream(data);
 
@@ -829,12 +850,20 @@ private String getName() {
     }
 
     /**
-     * Load keys and/or certificates from keystore into Collection.
+     * Returns the location of the keystore.
+     */
+    private int getLocation() {
+        return storeLocation;
+    }
+
+    /**
+     * Loads keys and/or certificates from keystore into Collection.
      *
      * @param name Name of keystore.
+     * @param location Location of keystore.
      */
-    private native void loadKeysOrCertificateChains(String name)
-            throws KeyStoreException;
+    private native void loadKeysOrCertificateChains(String name,
+            int location) throws KeyStoreException;
 
     /**
      * Stores a DER-encoded certificate into the certificate store
@@ -844,8 +873,8 @@ private native void loadKeysOrCertificateChains(String name)
      * @param encoding DER-encoded certificate.
      */
     private native void storeCertificate(String name, String alias,
-        byte[] encoding, int encodingLength, long hCryptProvider,
-        long hCryptKey) throws CertificateException, KeyStoreException;
+            byte[] encoding, int encodingLength, long hCryptProvider,
+            long hCryptKey) throws CertificateException, KeyStoreException;
 
     /**
      * Removes the certificate from the certificate store
@@ -855,7 +884,7 @@ private native void storeCertificate(String name, String alias,
      * @param encoding DER-encoded certificate.
      */
     private native void removeCertificate(String name, String alias,
-        byte[] encoding, int encodingLength)
+            byte[] encoding, int encodingLength)
             throws CertificateException, KeyStoreException;
 
     /**
@@ -864,7 +893,7 @@ private native void removeCertificate(String name, String alias,
      * @param keyContainerName The name of the key container.
      */
     private native void destroyKeyContainer(String keyContainerName)
-        throws KeyStoreException;
+            throws KeyStoreException;
 
     /**
      * Removes a CNG key.
@@ -877,16 +906,16 @@ private native void destroyKeyContainer(String keyContainerName)
      * Generates a private-key BLOB from a key's components.
      */
     private native byte[] generateRSAPrivateKeyBlob(
-        int keyBitLength,
-        byte[] modulus,
-        byte[] publicExponent,
-        byte[] privateExponent,
-        byte[] primeP,
-        byte[] primeQ,
-        byte[] exponentP,
-        byte[] exponentQ,
-        byte[] crtCoefficient) throws InvalidKeyException;
+            int keyBitLength,
+            byte[] modulus,
+            byte[] publicExponent,
+            byte[] privateExponent,
+            byte[] primeP,
+            byte[] primeQ,
+            byte[] exponentP,
+            byte[] exponentQ,
+            byte[] crtCoefficient) throws InvalidKeyException;
 
     private native CPrivateKey storePrivateKey(String alg, byte[] keyBlob,
-        String keyContainerName, int keySize) throws KeyStoreException;
+            String keyContainerName, int keySize) throws KeyStoreException;
 }