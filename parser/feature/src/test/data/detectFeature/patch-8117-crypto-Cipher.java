@@ -52,8 +52,8 @@
  * encryption and decryption. It forms the core of the Java Cryptographic
  * Extension (JCE) framework.
  *
- * <p>In order to create a Cipher object, the application calls the
- * Cipher's {@code getInstance} method, and passes the name of the
+ * <p>In order to create a {code Cipher} object, the application calls the
+ * cipher's {@code getInstance} method, and passes the name of the
  * requested <i>transformation</i> to it. Optionally, the name of a provider
  * may be specified.
  *
@@ -112,7 +112,8 @@
  * encryption with a given key. When IVs are repeated for GCM
  * encryption, such usages are subject to forgery attacks. Thus, after
  * each encryption operation using GCM mode, callers should re-initialize
- * the cipher objects with GCM parameters which have a different IV value.
+ * the {@code Cipher} objects with GCM parameters which have a different IV
+ * value.
  * <pre>
  *     GCMParameterSpec s = ...;
  *     cipher.init(..., s);
@@ -224,7 +225,7 @@ public class Cipher {
     private final String transformation;
 
     // Crypto permission representing the maximum allowable cryptographic
-    // strength that this Cipher object can be used for. (The cryptographic
+    // strength that this cipher can be used for. (The cryptographic
     // strength is a function of the keysize and algorithm parameters encoded
     // in the crypto permission.)
     private CryptoPermission cryptoPerm;
@@ -257,14 +258,14 @@ public class Cipher {
     private final Object lock;
 
     /**
-     * Creates a Cipher object.
+     * Creates a {code Cipher} object.
      *
      * @param cipherSpi the delegate
      * @param provider the provider
      * @param transformation the transformation
      * @throws NullPointerException if {@code provider} is {@code null}
      * @throws IllegalArgumentException if the supplied arguments
-     *         are deemed invalid for constructing the Cipher object
+     *         are deemed invalid for constructing the {code Cipher} object
      */
     protected Cipher(CipherSpi cipherSpi,
                      Provider provider,
@@ -284,7 +285,7 @@ protected Cipher(CipherSpi cipherSpi,
     }
 
     /**
-     * Creates a Cipher object. Called internally and by NullCipher.
+     * Creates a {code Cipher} object. Called internally by {code NullCipher}.
      *
      * @param cipherSpi the delegate
      * @param transformation the transformation
@@ -313,7 +314,7 @@ private static String[] tokenizeTransformation(String transformation)
             throw new NoSuchAlgorithmException("No transformation given");
         }
         /*
-         * array containing the components of a Cipher transformation:
+         * array containing the components of a cipher transformation:
          *
          * index 0: algorithm component (e.g., AES)
          * index 1: feedback component (e.g., CFB)
@@ -402,7 +403,7 @@ int supportsModePadding(Service s) {
         }
 
         // separate methods for mode and padding
-        // called directly by Cipher only to throw the correct exception
+        // called directly by cipher only to throw the correct exception
         int supportsMode(Service s) {
             return supports(s, ATTR_MODE, mode);
         }
@@ -481,11 +482,11 @@ private static Transform getTransform(Service s,
      * Returns a {@code Cipher} object that implements the specified
      * transformation.
      *
-     * <p> This method traverses the list of registered security Providers,
-     * starting with the most preferred Provider.
-     * A new Cipher object encapsulating the
-     * CipherSpi implementation from the first
-     * Provider that supports the specified algorithm is returned.
+     * <p> This method traverses the list of registered security providers,
+     * starting with the most preferred provider.
+     * A new {@code Cipher} object encapsulating the
+     * {@code CipherSpi} implementation from the first
+     * provider that supports the specified algorithm is returned.
      *
      * <p> Note that the list of registered providers may be retrieved via
      * the {@link Security#getProviders() Security.getProviders()} method.
@@ -518,7 +519,7 @@ private static Transform getTransform(Service s,
      *
      * @throws NoSuchAlgorithmException if {@code transformation}
      *         is {@code null}, empty, in an invalid format,
-     *         or if no {@code Provider} supports a {@code CipherSpi}
+     *         or if no provider supports a {@code CipherSpi}
      *         implementation for the specified algorithm
      *
      * @throws NoSuchPaddingException if {@code transformation}
@@ -577,8 +578,8 @@ public static final Cipher getInstance(String transformation)
      * Returns a {@code Cipher} object that implements the specified
      * transformation.
      *
-     * <p> A new Cipher object encapsulating the
-     * CipherSpi implementation from the specified provider
+     * <p> A new {@code Cipher} object encapsulating the
+     * {@code CipherSpi} implementation from the specified provider
      * is returned.  The specified provider must be registered
      * in the security provider list.
      *
@@ -603,7 +604,7 @@ public static final Cipher getInstance(String transformation)
      * Java Security Standard Algorithm Names Specification</a>
      * for information about standard transformation names.
      *
-     * @param provider the name of the provider.
+     * @param provider the name of the provider
      *
      * @return a cipher that implements the requested transformation
      *
@@ -651,9 +652,9 @@ private String getProviderName() {
      * Returns a {@code Cipher} object that implements the specified
      * transformation.
      *
-     * <p> A new Cipher object encapsulating the
-     * CipherSpi implementation from the specified Provider
-     * object is returned.  Note that the specified Provider object
+     * <p> A new {@code Cipher} object encapsulating the
+     * {@code CipherSpi} implementation from the specified {@code provider}
+     * object is returned.  Note that the specified {@code provider} object
      * does not have to be registered in the provider list.
      *
      * @apiNote
@@ -674,7 +675,7 @@ private String getProviderName() {
      * Java Security Standard Algorithm Names Specification</a>
      * for information about standard transformation names.
      *
-     * @param provider the provider.
+     * @param provider the provider
      *
      * @return a cipher that implements the requested transformation
      *
@@ -685,7 +686,7 @@ private String getProviderName() {
      *         is {@code null}, empty, in an invalid format,
      *         or if a {@code CipherSpi} implementation for the
      *         specified algorithm is not available from the specified
-     *         {@code Provider} object
+     *         {@code provider} object
      *
      * @throws NoSuchPaddingException if {@code transformation}
      *         contains a padding scheme that is not available
@@ -977,9 +978,9 @@ public final Provider getProvider() {
      *
      * <p>This is the same name that was specified in one of the
      * {@code getInstance} calls that created this {@code Cipher}
-     * object..
+     * object.
      *
-     * @return the algorithm name of this {@code Cipher} object.
+     * @return the algorithm name of this {@code Cipher} object
      */
     public final String getAlgorithm() {
         return this.transformation;
@@ -988,7 +989,7 @@ public final String getAlgorithm() {
     /**
      * Returns the block size (in bytes).
      *
-     * @return the block size (in bytes), or 0 if the underlying algorithm is
+     * @return the block size (in bytes), or 0 if this cipher is
      * not a block cipher
      */
     public final int getBlockSize() {
@@ -1013,7 +1014,7 @@ public final int getBlockSize() {
      *
      * @return the required output buffer size (in bytes)
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not yet been initialized)
      */
     public final int getOutputSize(int inputLen) {
@@ -1036,8 +1037,8 @@ public final int getOutputSize(int inputLen) {
      * or in the context of password-based encryption or
      * decryption, where the IV is derived from a user-supplied password.
      *
-     * @return the initialization vector in a new buffer, or null if the
-     * underlying algorithm does not use an IV, or if the IV has not yet
+     * @return the initialization vector in a new buffer, or {@code null} if
+     * this cipher does not use an IV, or if the IV has not yet
      * been set.
      */
     public final byte[] getIV() {
@@ -1049,12 +1050,12 @@ public final byte[] getIV() {
      * Returns the parameters used with this cipher.
      *
      * <p>The returned parameters may be the same that were used to initialize
-     * this cipher, or may contain a combination of default and random
-     * parameter values used by the underlying cipher implementation if this
-     * cipher requires algorithm parameters but was not initialized with any.
+     * this cipher, or may contain additional default or random parameter
+     * values used by the underlying cipher implementation. If the required
+     * parameters were not supplied and can be generated by the cipher, the
+     * generated parameters are returned. Otherwise, {@code null} is returned.
      *
-     * @return the parameters used with this cipher, or null if this cipher
-     * does not use any parameters.
+     * @return the parameters used with this cipher, or {@code null}
      */
     public final AlgorithmParameters getParameters() {
         chooseFirstProvider();
@@ -1065,7 +1066,7 @@ public final AlgorithmParameters getParameters() {
      * Returns the exemption mechanism object used with this cipher.
      *
      * @return the exemption mechanism object used with this cipher, or
-     * null if this cipher does not use any exemption mechanism.
+     * {@code null} if this cipher does not use any exemption mechanism.
      */
     public final ExemptionMechanism getExemptionMechanism() {
         chooseFirstProvider();
@@ -1204,17 +1205,17 @@ private static void checkOpmode(int opmode) {
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them using the {@link java.security.SecureRandom}
      * implementation of the highest-priority
      * installed provider as the source of randomness.
      * (If none of the installed providers supply an implementation of
      * SecureRandom, a system-provided source of randomness will be used.)
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of
@@ -1223,15 +1224,15 @@ private static void checkOpmode(int opmode) {
      * {@code WRAP_MODE} or {@code UNWRAP_MODE})
      * @param key the key
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or requires
      * algorithm parameters that cannot be
      * determined from the given key, or if the given key has a keysize that
      * exceeds the maximum allowable keysize (as determined from the
-     * configured jurisdiction policy files).
+     * configured jurisdiction policy files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Key key) throws InvalidKeyException {
         init(opmode, key, JCAUtil.getDefSecureRandom());
@@ -1260,13 +1261,13 @@ public final void init(int opmode, Key key) throws InvalidKeyException {
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them from {@code random}.
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1276,15 +1277,15 @@ public final void init(int opmode, Key key) throws InvalidKeyException {
      * @param key the encryption key
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or requires
      * algorithm parameters that cannot be
      * determined from the given key, or if the given key has a keysize that
      * exceeds the maximum allowable keysize (as determined from the
-     * configured jurisdiction policy files).
+     * configured jurisdiction policy files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Key key, SecureRandom random)
             throws InvalidKeyException
@@ -1321,7 +1322,7 @@ public final void init(int opmode, Key key, SecureRandom random)
      * on the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters and
-     * {@code params} is null, the underlying cipher implementation is
+     * {@code params} is {@code null}, the underlying cipher implementation is
      * supposed to generate the required parameters itself (using
      * provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
@@ -1336,17 +1337,17 @@ public final void init(int opmode, Key key, SecureRandom random)
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them using the {@link java.security.SecureRandom}
      * implementation of the highest-priority
      * installed provider as the source of randomness.
      * (If none of the installed providers supply an implementation of
      * SecureRandom, a system-provided source of randomness will be used.)
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1356,19 +1357,19 @@ public final void init(int opmode, Key key, SecureRandom random)
      * @param key the encryption key
      * @param params the algorithm parameters
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or its keysize exceeds the maximum allowable
-     * keysize (as determined from the configured jurisdiction policy files).
-     * @exception InvalidAlgorithmParameterException if the given algorithm
+     * keysize (as determined from the configured jurisdiction policy files)
+     * @throws InvalidAlgorithmParameterException if the given algorithm
      * parameters are inappropriate for this cipher,
      * or this cipher requires
-     * algorithm parameters and {@code params} is null, or the given
+     * algorithm parameters and {@code params} is {@code null}, or the given
      * algorithm parameters imply a cryptographic strength that would exceed
      * the legal limits (as determined from the configured jurisdiction
-     * policy files).
+     * policy files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Key key, AlgorithmParameterSpec params)
             throws InvalidKeyException, InvalidAlgorithmParameterException
@@ -1385,7 +1386,7 @@ public final void init(int opmode, Key key, AlgorithmParameterSpec params)
      * on the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters and
-     * {@code params} is null, the underlying cipher implementation is
+     * {@code params} is {@code null}, the underlying cipher implementation is
      * supposed to generate the required parameters itself (using
      * provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
@@ -1400,13 +1401,13 @@ public final void init(int opmode, Key key, AlgorithmParameterSpec params)
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them from {@code random}.
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1417,19 +1418,19 @@ public final void init(int opmode, Key key, AlgorithmParameterSpec params)
      * @param params the algorithm parameters
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or its keysize exceeds the maximum allowable
-     * keysize (as determined from the configured jurisdiction policy files).
-     * @exception InvalidAlgorithmParameterException if the given algorithm
+     * keysize (as determined from the configured jurisdiction policy files)
+     * @throws InvalidAlgorithmParameterException if the given algorithm
      * parameters are inappropriate for this cipher,
      * or this cipher requires
-     * algorithm parameters and {@code params} is null, or the given
+     * algorithm parameters and {@code params} is {@code null}, or the given
      * algorithm parameters imply a cryptographic strength that would exceed
      * the legal limits (as determined from the configured jurisdiction
-     * policy files).
+     * policy files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Key key, AlgorithmParameterSpec params,
                            SecureRandom random)
@@ -1462,7 +1463,7 @@ public final void init(int opmode, Key key, AlgorithmParameterSpec params,
      * on the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters and
-     * {@code params} is null, the underlying cipher implementation is
+     * {@code params} is {@code null}, the underlying cipher implementation is
      * supposed to generate the required parameters itself (using
      * provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
@@ -1477,17 +1478,17 @@ public final void init(int opmode, Key key, AlgorithmParameterSpec params,
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them using the {@link java.security.SecureRandom}
      * implementation of the highest-priority
      * installed provider as the source of randomness.
      * (If none of the installed providers supply an implementation of
      * SecureRandom, a system-provided source of randomness will be used.)
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1497,19 +1498,19 @@ public final void init(int opmode, Key key, AlgorithmParameterSpec params,
      * @param key the encryption key
      * @param params the algorithm parameters
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or its keysize exceeds the maximum allowable
      * keysize (as determined from the configured jurisdiction policy files).
-     * @exception InvalidAlgorithmParameterException if the given algorithm
+     * @throws InvalidAlgorithmParameterException if the given algorithm
      * parameters are inappropriate for this cipher,
      * or this cipher requires
-     * algorithm parameters and {@code params} is null, or the given
+     * algorithm parameters and {@code params} is {@code null}, or the given
      * algorithm parameters imply a cryptographic strength that would exceed
      * the legal limits (as determined from the configured jurisdiction
-     * policy files).
+     * policy files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Key key, AlgorithmParameters params)
             throws InvalidKeyException, InvalidAlgorithmParameterException
@@ -1526,7 +1527,7 @@ public final void init(int opmode, Key key, AlgorithmParameters params)
      * on the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters and
-     * {@code params} is null, the underlying cipher implementation is
+     * {@code params} is {@code null}, the underlying cipher implementation is
      * supposed to generate the required parameters itself (using
      * provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
@@ -1541,13 +1542,13 @@ public final void init(int opmode, Key key, AlgorithmParameters params)
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them from {@code random}.
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1558,19 +1559,19 @@ public final void init(int opmode, Key key, AlgorithmParameters params)
      * @param params the algorithm parameters
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or its keysize exceeds the maximum allowable
-     * keysize (as determined from the configured jurisdiction policy files).
-     * @exception InvalidAlgorithmParameterException if the given algorithm
+     * keysize (as determined from the configured jurisdiction policy files)
+     * @throws InvalidAlgorithmParameterException if the given algorithm
      * parameters are inappropriate for this cipher,
      * or this cipher requires
-     * algorithm parameters and {@code params} is null, or the given
+     * algorithm parameters and {@code params} is {@code null}, or the given
      * algorithm parameters imply a cryptographic strength that would exceed
      * the legal limits (as determined from the configured jurisdiction
-     * policy files).
+     * policy files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Key key, AlgorithmParameters params,
                            SecureRandom random)
@@ -1626,7 +1627,7 @@ public final void init(int opmode, Key key, AlgorithmParameters params,
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them using the
      * {@code SecureRandom}
@@ -1635,9 +1636,9 @@ public final void init(int opmode, Key key, AlgorithmParameters params,
      * (If none of the installed providers supply an implementation of
      * SecureRandom, a system-provided source of randomness will be used.)
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1646,16 +1647,16 @@ public final void init(int opmode, Key key, AlgorithmParameters params,
      * {@code WRAP_MODE} or {@code UNWRAP_MODE})
      * @param certificate the certificate
      *
-     * @exception InvalidKeyException if the public key in the given
+     * @throws InvalidKeyException if the public key in the given
      * certificate is inappropriate for initializing this cipher, or this
      * cipher requires algorithm parameters that cannot be determined from the
      * public key in the given certificate, or the keysize of the public key
      * in the given certificate has a keysize that exceeds the maximum
      * allowable keysize (as determined by the configured jurisdiction policy
-     * files).
+     * files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Certificate certificate)
             throws InvalidKeyException
@@ -1698,13 +1699,13 @@ public final void init(int opmode, Certificate certificate)
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
      * them from {@code random}.
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
-     * equivalent to creating a new instance of that Cipher and initializing
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
+     * equivalent to creating a new instance of that cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of the
@@ -1714,17 +1715,17 @@ public final void init(int opmode, Certificate certificate)
      * @param certificate the certificate
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the public key in the given
+     * @throws InvalidKeyException if the public key in the given
      * certificate is inappropriate for initializing this cipher, or this
      * cipher
      * requires algorithm parameters that cannot be determined from the
      * public key in the given certificate, or the keysize of the public key
      * in the given certificate has a keysize that exceeds the maximum
      * allowable keysize (as determined by the configured jurisdiction policy
-     * files).
+     * files)
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} but the mode is not implemented
-     * by the underlying {@code CipherSpi}.
+     * by the underlying {@code CipherSpi}
      */
     public final void init(int opmode, Certificate certificate,
                            SecureRandom random)
@@ -1781,9 +1782,9 @@ public final void init(int opmode, Certificate certificate,
     }
 
     /**
-     * Ensures that Cipher is in a valid state for update() and doFinal()
+     * Ensures that cipher is in a valid state for update() and doFinal()
      * calls - should be initialized and in ENCRYPT_MODE or DECRYPT_MODE.
-     * @throws IllegalStateException if Cipher object is not in valid state.
+     * @throws IllegalStateException if this cipher is not in valid state
      */
     private void checkCipherState() {
         if (!(this instanceof NullCipher)) {
@@ -1811,11 +1812,11 @@ private void checkCipherState() {
      *
      * @param input the input buffer
      *
-     * @return the new buffer with the result, or null if the underlying
+     * @return the new buffer with the result, or {@code null} if this
      * cipher is a block cipher and the input data is too short to result in a
-     * new block.
+     * new block
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
      */
     public final byte[] update(byte[] input) {
@@ -1850,11 +1851,11 @@ public final byte[] update(byte[] input) {
      * starts
      * @param inputLen the input length
      *
-     * @return the new buffer with the result, or null if the underlying
+     * @return the new buffer with the result, or null if this
      * cipher is a block cipher and the input data is too short to result in a
      * new block.
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
      */
     public final byte[] update(byte[] input, int inputOffset, int inputLen) {
@@ -1904,9 +1905,9 @@ public final byte[] update(byte[] input, int inputOffset, int inputLen) {
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception ShortBufferException if the given output buffer is too small
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
      */
     public final int update(byte[] input, int inputOffset, int inputLen,
@@ -1962,9 +1963,9 @@ public final int update(byte[] input, int inputOffset, int inputLen,
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception ShortBufferException if the given output buffer is too small
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
      */
     public final int update(byte[] input, int inputOffset, int inputLen,
@@ -2016,12 +2017,12 @@ public final int update(byte[] input, int inputOffset, int inputLen,
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalArgumentException if input and output are the
+     * @throws IllegalArgumentException if input and output are the
      *   same object
-     * @exception ReadOnlyBufferException if the output buffer is read-only
-     * @exception ShortBufferException if there is insufficient space in the
+     * @throws ReadOnlyBufferException if the output buffer is read-only
+     * @throws ShortBufferException if there is insufficient space in the
      * output buffer
      * @since 1.5
      */
@@ -2056,28 +2057,28 @@ public final int update(ByteBuffer input, ByteBuffer output)
      * case of decryption.
      * The result is stored in a new buffer.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * @return the new buffer with the result
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      */
@@ -2108,13 +2109,13 @@ public final byte[] doFinal()
      * {@link #getOutputSize(int) getOutputSize} to determine how big
      * the output buffer should be.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * @param output the buffer for the result
@@ -2123,19 +2124,19 @@ public final byte[] doFinal()
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception ShortBufferException if the given output buffer is too small
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      */
@@ -2166,30 +2167,30 @@ public final int doFinal(byte[] output, int outputOffset)
      * case of decryption.
      * The result is stored in a new buffer.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * @param input the input buffer
      *
      * @return the new buffer with the result
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      */
@@ -2220,13 +2221,13 @@ public final byte[] doFinal(byte[] input)
      * case of decryption.
      * The result is stored in a new buffer.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * @param input the input buffer
@@ -2236,17 +2237,17 @@ public final byte[] doFinal(byte[] input)
      *
      * @return the new buffer with the result
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      */
@@ -2284,13 +2285,13 @@ public final byte[] doFinal(byte[] input, int inputOffset, int inputLen)
      * {@link #getOutputSize(int) getOutputSize} to determine how big
      * the output buffer should be.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * <p>Note: this method should be copy-safe, which means the
@@ -2306,19 +2307,19 @@ public final byte[] doFinal(byte[] input, int inputOffset, int inputLen)
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception ShortBufferException if the given output buffer is too small
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      */
@@ -2361,13 +2362,13 @@ public final int doFinal(byte[] input, int inputOffset, int inputLen,
      * {@link #getOutputSize(int) getOutputSize} to determine how big
      * the output buffer should be.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * <p>Note: this method should be copy-safe, which means the
@@ -2385,19 +2386,19 @@ public final int doFinal(byte[] input, int inputOffset, int inputLen,
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception ShortBufferException if the given output buffer is too small
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      */
@@ -2441,13 +2442,13 @@ public final int doFinal(byte[] input, int inputOffset, int inputLen,
      * {@link #getOutputSize(int) getOutputSize} to determine how big
      * the output buffer should be.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to {@code init}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
      * {@code init}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * <p>Note: this method should be copy-safe, which means the
@@ -2460,22 +2461,22 @@ public final int doFinal(byte[] input, int inputOffset, int inputLen,
      *
      * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
+     * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized)
-     * @exception IllegalArgumentException if input and output are the
+     * @throws IllegalArgumentException if input and output are the
      *   same object
-     * @exception ReadOnlyBufferException if the output buffer is read-only
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws ReadOnlyBufferException if the output buffer is read-only
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
      * process the input data provided.
-     * @exception ShortBufferException if there is insufficient space in the
+     * @throws ShortBufferException if there is insufficient space in the
      * output buffer
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
+     * @throws AEADBadTagException if this cipher is decrypting in an
      * AEAD mode (such as GCM/CCM), and the received authentication tag
      * does not match the calculated value
      *
@@ -2504,24 +2505,24 @@ public final int doFinal(ByteBuffer input, ByteBuffer output)
     /**
      * Wrap a key.
      *
-     * @param key the key to be wrapped.
+     * @param key the key to be wrapped
      *
-     * @return the wrapped key.
+     * @return the wrapped key
      *
-     * @exception IllegalStateException if this cipher is in a wrong
-     * state (e.g., has not been initialized).
+     * @throws IllegalStateException if this cipher is in a wrong
+     * state (e.g., has not been initialized)
      *
-     * @exception IllegalBlockSizeException if this cipher is a block
+     * @throws IllegalBlockSizeException if this cipher is a block
      * cipher, no padding has been requested, and the length of the
      * encoding of the key to be wrapped is not a
-     * multiple of the block size.
+     * multiple of the block size
      *
-     * @exception InvalidKeyException if it is impossible or unsafe to
+     * @throws InvalidKeyException if it is impossible or unsafe to
      * wrap the key with this cipher (e.g., a hardware protected key is
-     * being passed to a software-only cipher).
+     * being passed to a software-only cipher)
      *
      * @throws UnsupportedOperationException if the corresponding method in the
-     * {@code CipherSpi} is not supported.
+     * {@code CipherSpi} is not supported
      */
     public final byte[] wrap(Key key)
             throws IllegalBlockSizeException, InvalidKeyException {
@@ -2542,30 +2543,30 @@ public final byte[] wrap(Key key)
     /**
      * Unwrap a previously wrapped key.
      *
-     * @param wrappedKey the key to be unwrapped.
+     * @param wrappedKey the key to be unwrapped
      *
      * @param wrappedKeyAlgorithm the algorithm associated with the wrapped
-     * key.
+     * key
      *
      * @param wrappedKeyType the type of the wrapped key. This must be one of
      * {@code SECRET_KEY}, {@code PRIVATE_KEY}, or
-     * {@code PUBLIC_KEY}.
+     * {@code PUBLIC_KEY}
      *
-     * @return the unwrapped key.
+     * @return the unwrapped key
      *
-     * @exception IllegalStateException if this cipher is in a wrong state
-     * (e.g., has not been initialized).
+     * @throws IllegalStateException if this cipher is in a wrong state
+     * (e.g., has not been initialized)
      *
-     * @exception NoSuchAlgorithmException if no installed providers
+     * @throws NoSuchAlgorithmException if no installed providers
      * can create keys of type {@code wrappedKeyType} for the
-     * {@code wrappedKeyAlgorithm}.
+     * {@code wrappedKeyAlgorithm}
      *
-     * @exception InvalidKeyException if {@code wrappedKey} does not
+     * @throws InvalidKeyException if {@code wrappedKey} does not
      * represent a wrapped key of type {@code wrappedKeyType} for
-     * the {@code wrappedKeyAlgorithm}.
+     * the {@code wrappedKeyAlgorithm}
      *
      * @throws UnsupportedOperationException if the corresponding method in the
-     * {@code CipherSpi} is not supported.
+     * {@code CipherSpi} is not supported
      */
     public final Key unwrap(byte[] wrappedKey,
                             String wrappedKeyAlgorithm,
@@ -2632,17 +2633,17 @@ private static CryptoPermission getConfiguredPermission(
      * Returns the maximum key length for the specified transformation
      * according to the installed JCE jurisdiction policy files. If
      * JCE unlimited strength jurisdiction policy files are installed,
-     * Integer.MAX_VALUE will be returned.
+     * {@code Integer.MAX_VALUE} will be returned.
      * For more information on the default key sizes and the JCE jurisdiction
      * policy files, please see the Cryptographic defaults and limitations in
      * the {@extLink security_guide_jdk_providers JDK Providers Documentation}.
      *
-     * @param transformation the cipher transformation.
-     * @return the maximum key length in bits or Integer.MAX_VALUE.
-     * @exception NullPointerException if {@code transformation} is null.
-     * @exception NoSuchAlgorithmException if {@code transformation}
+     * @param transformation the cipher transformation
+     * @return the maximum key length in bits or {@code Integer.MAX_VALUE}
+     * @throws NullPointerException if {@code transformation} is {@code null}
+     * @throws NoSuchAlgorithmException if {@code transformation}
      * is not a valid transformation, i.e. in the form of "algorithm" or
-     * "algorithm/mode/padding".
+     * "algorithm/mode/padding"
      * @since 1.5
      */
     public static final int getMaxAllowedKeyLength(String transformation)
@@ -2652,21 +2653,21 @@ public static final int getMaxAllowedKeyLength(String transformation)
     }
 
     /**
-     * Returns an AlgorithmParameterSpec object which contains
+     * Returns an {code AlgorithmParameterSpec} object which contains
      * the maximum cipher parameter value according to the
      * jurisdiction policy file. If JCE unlimited strength jurisdiction
      * policy files are installed or there is no maximum limit on the
      * parameters for the specified transformation in the policy file,
-     * null will be returned.
-     *
-     * @param transformation the cipher transformation.
-     * @return an AlgorithmParameterSpec which holds the maximum
-     * value or null.
-     * @exception NullPointerException if {@code transformation}
-     * is null.
-     * @exception NoSuchAlgorithmException if {@code transformation}
+     * {@code null} will be returned.
+     *
+     * @param transformation the cipher transformation
+     * @return an {code AlgorithmParameterSpec} object which holds the maximum
+     * value or {@code null}
+     * @throws NullPointerException if {@code transformation}
+     * is {@code null}
+     * @throws NoSuchAlgorithmException if {@code transformation}
      * is not a valid transformation, i.e. in the form of "algorithm" or
-     * "algorithm/mode/padding".
+     * "algorithm/mode/padding"
      * @since 1.5
      */
     public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(
@@ -2688,7 +2689,7 @@ public static final AlgorithmParameterSpec getMaxAllowedParameterSpec(
      * @param src the buffer containing the Additional Authentication Data
      *
      * @throws IllegalArgumentException if the {@code src}
-     * byte array is null
+     * byte array is {@code null}
      * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized), does not accept AAD, or if
      * operating in either GCM or CCM mode and one of the {@code update}
@@ -2723,7 +2724,7 @@ public final void updateAAD(byte[] src) {
      * @param len the number of AAD bytes
      *
      * @throws IllegalArgumentException if the {@code src}
-     * byte array is null, or the {@code offset} or {@code length}
+     * byte array is {@code null}, or the {@code offset} or {@code length}
      * is less than 0, or the sum of the {@code offset} and
      * {@code len} is greater than the length of the
      * {@code src} byte array
@@ -2772,7 +2773,7 @@ public final void updateAAD(byte[] src, int offset, int len) {
      * @param src the buffer containing the AAD
      *
      * @throws IllegalArgumentException if the {@code src ByteBuffer}
-     * is null
+     * is {@code null}
      * @throws IllegalStateException if this cipher is in a wrong state
      * (e.g., has not been initialized), does not accept AAD, or if
      * operating in either GCM or CCM mode and one of the {@code update}
@@ -2800,14 +2801,14 @@ public final void updateAAD(ByteBuffer src) {
     }
 
     /**
-     * Returns a String representation of this Cipher.
+     * Returns a String representation of this cipher.
      *
      * @implNote
      * This implementation returns a String containing the transformation,
-     * mode, and provider of this Cipher.
+     * mode, and provider of this cipher.
      * The exact format of the String is unspecified and is subject to change.
      *
-     * @return a String describing this Cipher
+     * @return a String describing this cipher
      */
     @Override
     public String toString() {