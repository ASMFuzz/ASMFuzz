@@ -79,7 +79,7 @@
  * itself. For example, the entity may authenticate itself using different
  * certificate authorities, or using different public key algorithms.
  *
- * <p> Whether aliases are case sensitive is implementation dependent. In order
+ * <p> Whether aliases are case-sensitive is implementation dependent. In order
  * to avoid problems, it is recommended not to use aliases in a KeyStore that
  * only differ in case.
  *
@@ -211,13 +211,13 @@ public class KeyStore {
     private static final String KEYSTORE_TYPE = "keystore.type";
 
     // The keystore type
-    private String type;
+    private final String type;
 
     // The provider
-    private Provider provider;
+    private final Provider provider;
 
     // The provider implementation
-    private KeyStoreSpi keyStoreSpi;
+    private final KeyStoreSpi keyStoreSpi;
 
     // Has this keystore been initialized (loaded)?
     private boolean initialized;
@@ -231,13 +231,13 @@ public class KeyStore {
      *
      * @since 1.5
      */
-    public static interface LoadStoreParameter {
+    public interface LoadStoreParameter {
         /**
          * Gets the parameter used to protect keystore data.
          *
          * @return the parameter used to protect keystore data, or null
          */
-        public ProtectionParameter getProtectionParameter();
+        ProtectionParameter getProtectionParameter();
     }
 
     /**
@@ -252,7 +252,7 @@ public static interface LoadStoreParameter {
      *
      * @since 1.5
      */
-    public static interface ProtectionParameter { }
+    public interface ProtectionParameter { }
 
     /**
      * A password-based implementation of {@code ProtectionParameter}.
@@ -420,7 +420,7 @@ public CallbackHandler getCallbackHandler() {
      *
      * @since 1.5
      */
-    public static interface Entry {
+    public interface Entry {
 
         /**
          * Retrieves the attributes associated with an entry.
@@ -432,8 +432,8 @@ public static interface Entry {
          *
          * @since 1.8
          */
-        public default Set<Attribute> getAttributes() {
-            return Collections.<Attribute>emptySet();
+        default Set<Attribute> getAttributes() {
+            return Collections.emptySet();
         }
 
         /**
@@ -442,21 +442,21 @@ public default Set<Attribute> getAttributes() {
          *
          * @since 1.8
          */
-        public interface Attribute {
+        interface Attribute {
             /**
              * Returns the attribute's name.
              *
              * @return the attribute name
              */
-            public String getName();
+            String getName();
 
             /**
              * Returns the attribute's value.
-             * Multi-valued attributes encode their values as a single string.
+             * Multivalued attributes encode their values as a single string.
              *
              * @return the attribute value
              */
-            public String getValue();
+            String getValue();
         }
     }
 
@@ -497,7 +497,7 @@ public static final class PrivateKeyEntry implements Entry {
          *      in the end entity {@code Certificate} (at index 0)
          */
         public PrivateKeyEntry(PrivateKey privateKey, Certificate[] chain) {
-            this(privateKey, chain, Collections.<Attribute>emptySet());
+            this(privateKey, chain, Collections.emptySet());
         }
 
         /**
@@ -660,7 +660,7 @@ public SecretKeyEntry(SecretKey secretKey) {
                 throw new NullPointerException("invalid null input");
             }
             this.sKey = secretKey;
-            this.attributes = Collections.<Attribute>emptySet();
+            this.attributes = Collections.emptySet();
         }
 
         /**
@@ -743,7 +743,7 @@ public TrustedCertificateEntry(Certificate trustedCert) {
                 throw new NullPointerException("invalid null input");
             }
             this.cert = trustedCert;
-            this.attributes = Collections.<Attribute>emptySet();
+            this.attributes = Collections.emptySet();
         }
 
         /**
@@ -842,7 +842,7 @@ private String getProviderName() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param type the type of keystore.
@@ -988,11 +988,8 @@ public static KeyStore getInstance(String type, Provider provider)
      */
     public static final String getDefaultType() {
         @SuppressWarnings("removal")
-        String kstype = AccessController.doPrivileged(new PrivilegedAction<>() {
-            public String run() {
-                return Security.getProperty(KEYSTORE_TYPE);
-            }
-        });
+        String kstype = AccessController.doPrivileged((PrivilegedAction<String>) () ->
+            Security.getProperty(KEYSTORE_TYPE));
         if (kstype == null) {
             kstype = "jks";
         }
@@ -1776,7 +1773,7 @@ private static final KeyStore getInstance(File file, char[] password,
             throw new NullPointerException();
         }
 
-        if (file.isFile() == false) {
+        if (!file.isFile()) {
             throw new IllegalArgumentException(
                 "File does not exist or it does not refer to a normal file: " +
                     file);
@@ -1917,7 +1914,7 @@ public static Builder newInstance(final KeyStore keyStore,
             if ((keyStore == null) || (protectionParameter == null)) {
                 throw new NullPointerException();
             }
-            if (keyStore.initialized == false) {
+            if (!keyStore.initialized) {
                 throw new IllegalArgumentException("KeyStore not initialized");
             }
             return new Builder() {
@@ -1933,7 +1930,7 @@ public ProtectionParameter getProtectionParameter(String alias)
                     if (alias == null) {
                         throw new NullPointerException();
                     }
-                    if (getCalled == false) {
+                    if (!getCalled) {
                         throw new IllegalStateException
                             ("getKeyStore() must be called first");
                     }
@@ -2055,7 +2052,7 @@ private static final class FileBuilder extends Builder {
             private final String type;
             private final Provider provider;
             private final File file;
-            private ProtectionParameter protection;
+            private final ProtectionParameter protection;
             private ProtectionParameter keyProtection;
             @SuppressWarnings("removal")
             private final AccessControlContext context;
@@ -2109,7 +2106,7 @@ public KeyStore run() throws Exception {
                     }
                     public KeyStore run0() throws Exception {
                         KeyStore ks;
-                        char[] password = null;
+                        char[] password;
 
                         // Acquire keystore password
                         if (protection instanceof PasswordProtection) {
@@ -2213,7 +2210,7 @@ public static Builder newInstance(final String type,
                 private IOException oldException;
 
                 private final PrivilegedExceptionAction<KeyStore> action
-                        = new PrivilegedExceptionAction<KeyStore>() {
+                        = new PrivilegedExceptionAction<>() {
 
                     public KeyStore run() throws Exception {
                         KeyStore ks;
@@ -2273,7 +2270,7 @@ public ProtectionParameter getProtectionParameter(String alias)
                     if (alias == null) {
                         throw new NullPointerException();
                     }
-                    if (getCalled == false) {
+                    if (!getCalled) {
                         throw new IllegalStateException
                             ("getKeyStore() must be called first");
                     }