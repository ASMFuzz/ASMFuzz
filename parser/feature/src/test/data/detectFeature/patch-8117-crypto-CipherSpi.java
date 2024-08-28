@@ -31,13 +31,13 @@
 
 /**
  * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
- * for the <code>Cipher</code> class.
+ * for the {@code Cipher} class.
  * All the abstract methods in this class must be implemented by each
  * cryptographic service provider who wishes to supply the implementation
  * of a particular cipher algorithm.
  *
- * <p>In order to create an instance of <code>Cipher</code>, which
- * encapsulates an instance of this <code>CipherSpi</code> class, an
+ * <p>In order to create an instance of {@code Cipher}, which
+ * encapsulates an instance of this {@code CipherSpi} class, an
  * application calls one of the
  * {@link Cipher#getInstance(java.lang.String) getInstance}
  * factory methods of the
@@ -73,12 +73,12 @@
  * <i>algorithm</i> or <i>algorithm/mode</i> or <i>algorithm//padding</i>
  * (note the double slashes),
  * in which case the requested mode and/or padding are set automatically by
- * the <code>getInstance</code> methods of <code>Cipher</code>, which invoke
+ * the {@code getInstance} methods of {@code Cipher}, which invoke
  * the {@link #engineSetMode(java.lang.String) engineSetMode} and
  * {@link #engineSetPadding(java.lang.String) engineSetPadding}
- * methods of the provider's subclass of <code>CipherSpi</code>.
+ * methods of the provider's subclass of {@code CipherSpi}.
  *
- * <p>A <code>Cipher</code> property in a provider master class may have one of
+ * <p>A {@code Cipher} property in a provider master class may have one of
  * the following formats:
  *
  * <ul>
@@ -87,126 +87,126 @@
  * <pre>
  *     // provider's subclass of "CipherSpi" implements "algName" with
  *     // pluggable mode and padding
- *     <code>Cipher.</code><i>algName</i>
+ *     {@code Cipher.}<i>algName</i>
  * </pre>
  *
  * <li>
  * <pre>
  *     // provider's subclass of "CipherSpi" implements "algName" in the
  *     // specified "mode", with pluggable padding
- *     <code>Cipher.</code><i>algName/mode</i>
+ *     {@code Cipher.}<i>algName/mode</i>
  * </pre>
  *
  * <li>
  * <pre>
  *     // provider's subclass of "CipherSpi" implements "algName" with the
  *     // specified "padding", with pluggable mode
- *     <code>Cipher.</code><i>algName//padding</i>
+ *     {@code Cipher.}<i>algName//padding</i>
  * </pre>
  *
  * <li>
  * <pre>
  *     // provider's subclass of "CipherSpi" implements "algName" with the
  *     // specified "mode" and "padding"
- *     <code>Cipher.</code><i>algName/mode/padding</i>
+ *     {@code Cipher.}<i>algName/mode/padding</i>
  * </pre>
  *
  * </ul>
  *
- * <p>For example, a provider may supply a subclass of <code>CipherSpi</code>
+ * <p>For example, a provider may supply a subclass of {@code CipherSpi}
  * that implements <i>AES/ECB/PKCS5Padding</i>, one that implements
  * <i>AES/CBC/PKCS5Padding</i>, one that implements
  * <i>AES/CFB/PKCS5Padding</i>, and yet another one that implements
  * <i>AES/OFB/PKCS5Padding</i>. That provider would have the following
- * <code>Cipher</code> properties in its master class:
+ * {@code Cipher} properties in its master class:
  *
  * <ul>
  *
  * <li>
  * <pre>
- *     <code>Cipher.</code><i>AES/ECB/PKCS5Padding</i>
+ *     {@code Cipher.}<i>AES/ECB/PKCS5Padding</i>
  * </pre>
  *
  * <li>
  * <pre>
- *     <code>Cipher.</code><i>AES/CBC/PKCS5Padding</i>
+ *     {@code Cipher.}<i>AES/CBC/PKCS5Padding</i>
  * </pre>
  *
  * <li>
  * <pre>
- *     <code>Cipher.</code><i>AES/CFB/PKCS5Padding</i>
+ *     {@code Cipher.}<i>AES/CFB/PKCS5Padding</i>
  * </pre>
  *
  * <li>
  * <pre>
- *     <code>Cipher.</code><i>AES/OFB/PKCS5Padding</i>
+ *     {@code Cipher.}<i>AES/OFB/PKCS5Padding</i>
  * </pre>
  *
  * </ul>
  *
  * <p>Another provider may implement a class for each of the above modes
  * (i.e., one class for <i>ECB</i>, one for <i>CBC</i>, one for <i>CFB</i>,
  * and one for <i>OFB</i>), one class for <i>PKCS5Padding</i>,
- * and a generic <i>AES</i> class that subclasses from <code>CipherSpi</code>.
+ * and a generic <i>AES</i> class that subclasses from {@code CipherSpi}.
  * That provider would have the following
- * <code>Cipher</code> properties in its master class:
+ * {@code Cipher} properties in its master class:
  *
  * <ul>
  *
  * <li>
  * <pre>
- *     <code>Cipher.</code><i>AES</i>
+ *     {@code Cipher.}<i>AES</i>
  * </pre>
  *
  * </ul>
  *
- * <p>The <code>getInstance</code> factory method of the <code>Cipher</code>
+ * <p>The {@code getInstance} factory method of the {@code Cipher}
  * engine class follows these rules in order to instantiate a provider's
- * implementation of <code>CipherSpi</code> for a
+ * implementation of {@code CipherSpi} for a
  * transformation of the form "<i>algorithm</i>":
  *
  * <ol>
  * <li>
- * Check if the provider has registered a subclass of <code>CipherSpi</code>
+ * Check if the provider has registered a subclass of {@code CipherSpi}
  * for the specified "<i>algorithm</i>".
  * <p>If the answer is YES, instantiate this
  * class, for whose mode and padding scheme default values (as supplied by
  * the provider) are used.
- * <p>If the answer is NO, throw a <code>NoSuchAlgorithmException</code>
+ * <p>If the answer is NO, throw a {@code NoSuchAlgorithmException}
  * exception.
  * </ol>
  *
- * <p>The <code>getInstance</code> factory method of the <code>Cipher</code>
+ * <p>The {@code getInstance} factory method of the {@code Cipher}
  * engine class follows these rules in order to instantiate a provider's
- * implementation of <code>CipherSpi</code> for a
+ * implementation of {@code CipherSpi} for a
  * transformation of the form "<i>algorithm/mode/padding</i>":
  *
  * <ol>
  * <li>
- * Check if the provider has registered a subclass of <code>CipherSpi</code>
+ * Check if the provider has registered a subclass of {@code CipherSpi}
  * for the specified "<i>algorithm/mode/padding</i>" transformation.
  * <p>If the answer is YES, instantiate it.
  * <p>If the answer is NO, go to the next step.
  * <li>
- * Check if the provider has registered a subclass of <code>CipherSpi</code>
+ * Check if the provider has registered a subclass of {@code CipherSpi}
  * for the sub-transformation "<i>algorithm/mode</i>".
  * <p>If the answer is YES, instantiate it, and call
- * <code>engineSetPadding(<i>padding</i>)</code> on the new instance.
+ * {@code engineSetPadding(<i>padding</i>)} on the new instance.
  * <p>If the answer is NO, go to the next step.
  * <li>
- * Check if the provider has registered a subclass of <code>CipherSpi</code>
+ * Check if the provider has registered a subclass of {@code CipherSpi}
  * for the sub-transformation "<i>algorithm//padding</i>" (note the double
  * slashes).
  * <p>If the answer is YES, instantiate it, and call
- * <code>engineSetMode(<i>mode</i>)</code> on the new instance.
+ * {@code engineSetMode(<i>mode</i>)} on the new instance.
  * <p>If the answer is NO, go to the next step.
  * <li>
- * Check if the provider has registered a subclass of <code>CipherSpi</code>
+ * Check if the provider has registered a subclass of {@code CipherSpi}
  * for the sub-transformation "<i>algorithm</i>".
  * <p>If the answer is YES, instantiate it, and call
- * <code>engineSetMode(<i>mode</i>)</code> and
- * <code>engineSetPadding(<i>padding</i>)</code> on the new instance.
- * <p>If the answer is NO, throw a <code>NoSuchAlgorithmException</code>
+ * {@code engineSetMode(<i>mode</i>)} and
+ * {@code engineSetPadding(<i>padding</i>)} on the new instance.
+ * <p>If the answer is NO, throw a {@code NoSuchAlgorithmException}
  * exception.
  * </ol>
  *
@@ -228,7 +228,7 @@ public CipherSpi() {}
      *
      * @param mode the cipher mode
      *
-     * @exception NoSuchAlgorithmException if the requested cipher mode does
+     * @throws NoSuchAlgorithmException if the requested cipher mode does
      * not exist
      */
     protected abstract void engineSetMode(String mode)
@@ -239,7 +239,7 @@ protected abstract void engineSetMode(String mode)
      *
      * @param padding the padding mechanism
      *
-     * @exception NoSuchPaddingException if the requested padding mechanism
+     * @throws NoSuchPaddingException if the requested padding mechanism
      * does not exist
      */
     protected abstract void engineSetPadding(String padding)
@@ -248,22 +248,22 @@ protected abstract void engineSetPadding(String padding)
     /**
      * Returns the block size (in bytes).
      *
-     * @return the block size (in bytes), or 0 if the underlying algorithm is
+     * @return the block size (in bytes), or 0 if the algorithm is
      * not a block cipher
      */
     protected abstract int engineGetBlockSize();
 
     /**
      * Returns the length in bytes that an output buffer would
-     * need to be in order to hold the result of the next <code>update</code>
-     * or <code>doFinal</code> operation, given the input length
-     * <code>inputLen</code> (in bytes).
+     * need to be in order to hold the result of the next {@code update}
+     * or {@code doFinal} operation, given the input length
+     * {@code inputLen} (in bytes).
      *
      * <p>This call takes into account any unprocessed (buffered) data from a
-     * previous <code>update</code> call, padding, and AEAD tagging.
+     * previous {@code update} call, padding, and AEAD tagging.
      *
-     * <p>The actual output length of the next <code>update</code> or
-     * <code>doFinal</code> call may be smaller than the length returned by
+     * <p>The actual output length of the next {@code update} or
+     * {@code doFinal} call may be smaller than the length returned by
      * this method.
      *
      * @param inputLen the input length (in bytes)
@@ -278,22 +278,22 @@ protected abstract void engineSetPadding(String padding)
      * <p> This is useful in the context of password-based encryption or
      * decryption, where the IV is derived from a user-provided passphrase.
      *
-     * @return the initialization vector in a new buffer, or null if the
-     * underlying algorithm does not use an IV, or if the IV has not yet
-     * been set.
+     * @return the initialization vector in a new buffer, or {@code null} if the
+     * algorithm does not use an IV, or if the IV has not yet
+     * been set
      */
     protected abstract byte[] engineGetIV();
 
     /**
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
     protected abstract AlgorithmParameters engineGetParameters();
 
@@ -303,14 +303,14 @@ protected abstract void engineSetPadding(String padding)
      *
      * <p>The cipher is initialized for one of the following four operations:
      * encryption, decryption, key wrapping or key unwrapping, depending on
-     * the value of <code>opmode</code>.
+     * the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters that cannot be
-     * derived from the given <code>key</code>, the underlying cipher
+     * derived from the given {@code key}, the underlying cipher
      * implementation is supposed to generate the required parameters itself
      * (using provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
-     * <code>InvalidKeyException</code> if it is being
+     * {@code InvalidKeyException} if it is being
      * initialized for decryption or key unwrapping.
      * The generated parameters can be retrieved using
      * {@link #engineGetParameters() engineGetParameters} or
@@ -321,29 +321,29 @@ protected abstract void engineSetPadding(String padding)
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
-     * them from <code>random</code>.
+     * them from {@code random}.
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
      * the following:
-     * <code>ENCRYPT_MODE</code>, <code>DECRYPT_MODE</code>,
-     * <code>WRAP_MODE</code> or <code>UNWRAP_MODE</code>)
+     * {@code ENCRYPT_MODE}, {@code DECRYPT_MODE},
+     * {@code WRAP_MODE} or {@code UNWRAP_MODE})
      * @param key the encryption key
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher, or requires
      * algorithm parameters that cannot be
-     * determined from the given key.
+     * determined from the given key
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} is not implemented
-     * by the cipher.
+     * by the cipher
      */
     protected abstract void engineInit(int opmode, Key key,
                                        SecureRandom random)
@@ -355,14 +355,14 @@ protected abstract void engineInit(int opmode, Key key,
      *
      * <p>The cipher is initialized for one of the following four operations:
      * encryption, decryption, key wrapping or key unwrapping, depending on
-     * the value of <code>opmode</code>.
+     * the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters and
-     * <code>params</code> is null, the underlying cipher implementation is
-     * supposed to generate the required parameters itself (using
+     * {@code params} is {@code null}, the underlying cipher implementation
+     * is supposed to generate the required parameters itself (using
      * provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
-     * <code>InvalidAlgorithmParameterException</code> if it is being
+     * {@code InvalidAlgorithmParameterException} if it is being
      * initialized for decryption or key unwrapping.
      * The generated parameters can be retrieved using
      * {@link #engineGetParameters() engineGetParameters} or
@@ -373,32 +373,32 @@ protected abstract void engineInit(int opmode, Key key,
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
-     * them from <code>random</code>.
+     * them from {@code random}.
      *
-     * <p>Note that when a Cipher object is initialized, it loses all
-     * previously-acquired state. In other words, initializing a Cipher is
+     * <p>Note that when a {@code Cipher} object is initialized, it loses all
+     * previously-acquired state. In other words, initializing a cipher is
      * equivalent to creating a new instance of that Cipher and initializing
      * it.
      *
      * @param opmode the operation mode of this cipher (this is one of
      * the following:
-     * <code>ENCRYPT_MODE</code>, <code>DECRYPT_MODE</code>,
-     * <code>WRAP_MODE</code> or <code>UNWRAP_MODE</code>)
+     * {@code ENCRYPT_MODE}, {@code DECRYPT_MODE},
+     * {@code WRAP_MODE}> or {@code UNWRAP_MODE})
      * @param key the encryption key
      * @param params the algorithm parameters
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher
-     * @exception InvalidAlgorithmParameterException if the given algorithm
+     * @throws InvalidAlgorithmParameterException if the given algorithm
      * parameters are inappropriate for this cipher,
      * or if this cipher requires
-     * algorithm parameters and <code>params</code> is null.
+     * algorithm parameters and {@code params} is {@code null}
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} is not implemented
-     * by the cipher.
+     * by the cipher
      */
     protected abstract void engineInit(int opmode, Key key,
                                        AlgorithmParameterSpec params,
@@ -411,14 +411,14 @@ protected abstract void engineInit(int opmode, Key key,
      *
      * <p>The cipher is initialized for one of the following four operations:
      * encryption, decryption, key wrapping or key unwrapping, depending on
-     * the value of <code>opmode</code>.
+     * the value of {@code opmode}.
      *
      * <p>If this cipher requires any algorithm parameters and
-     * <code>params</code> is null, the underlying cipher implementation is
+     * {@code params} is {@code null}, the underlying cipher implementation is
      * supposed to generate the required parameters itself (using
      * provider-specific default or random values) if it is being
      * initialized for encryption or key wrapping, and raise an
-     * <code>InvalidAlgorithmParameterException</code> if it is being
+     * {@code InvalidAlgorithmParameterException} if it is being
      * initialized for decryption or key unwrapping.
      * The generated parameters can be retrieved using
      * {@link #engineGetParameters() engineGetParameters} or
@@ -429,32 +429,32 @@ protected abstract void engineInit(int opmode, Key key,
      * provider-specific default values, initialization will
      * necessarily fail.
      *
-     * <p>If this cipher (including its underlying feedback or padding scheme)
+     * <p>If this cipher (including its feedback or padding scheme)
      * requires any random bytes (e.g., for parameter generation), it will get
-     * them from <code>random</code>.
+     * them from {@code random}.
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
      * the following:
-     * <code>ENCRYPT_MODE</code>, <code>DECRYPT_MODE</code>,
-     * <code>WRAP_MODE</code> or <code>UNWRAP_MODE</code>)
+     * {@code ENCRYPT_MODE}, {@code DECRYPT_MODE},
+     * {@code WRAP_MODE} or {@code UNWRAP_MODE})
      * @param key the encryption key
      * @param params the algorithm parameters
      * @param random the source of randomness
      *
-     * @exception InvalidKeyException if the given key is inappropriate for
+     * @throws InvalidKeyException if the given key is inappropriate for
      * initializing this cipher
-     * @exception InvalidAlgorithmParameterException if the given algorithm
+     * @throws InvalidAlgorithmParameterException if the given algorithm
      * parameters are inappropriate for this cipher,
      * or if this cipher requires
-     * algorithm parameters and <code>params</code> is null.
+     * algorithm parameters and {@code params} is null
      * @throws UnsupportedOperationException if {@code opmode} is
      * {@code WRAP_MODE} or {@code UNWRAP_MODE} is not implemented
-     * by the cipher.
+     * by the cipher
      */
     protected abstract void engineInit(int opmode, Key key,
                                        AlgorithmParameters params,
@@ -466,18 +466,17 @@ protected abstract void engineInit(int opmode, Key key,
      * (depending on how this cipher was initialized), processing another data
      * part.
      *
-     * <p>The first <code>inputLen</code> bytes in the <code>input</code>
-     * buffer, starting at <code>inputOffset</code> inclusive, are processed,
+     * <p>The first {@code inputLen} bytes in the {@code input}
+     * buffer, starting at {@code inputOffset} inclusive, are processed,
      * and the result is stored in a new buffer.
      *
      * @param input the input buffer
-     * @param inputOffset the offset in <code>input</code> where the input
-     * starts
+     * @param inputOffset the offset in {@code input} where the input starts
      * @param inputLen the input length
      *
-     * @return the new buffer with the result, or null if the underlying
+     * @return the new buffer with the result, or {@code null} if the
      * cipher is a block cipher and the input data is too short to result in a
-     * new block.
+     * new block
      */
     protected abstract byte[] engineUpdate(byte[] input, int inputOffset,
                                            int inputLen);
@@ -487,25 +486,25 @@ protected abstract byte[] engineUpdate(byte[] input, int inputOffset,
      * (depending on how this cipher was initialized), processing another data
      * part.
      *
-     * <p>The first <code>inputLen</code> bytes in the <code>input</code>
-     * buffer, starting at <code>inputOffset</code> inclusive, are processed,
-     * and the result is stored in the <code>output</code> buffer, starting at
-     * <code>outputOffset</code> inclusive.
+     * <p>The first {@code inputLen} bytes in the {@code input}
+     * buffer, starting at {@code inputOffset} inclusive, are processed,
+     * and the result is stored in the {@code output} buffer, starting at
+     * {@code outputOffset} inclusive.
      *
-     * <p>If the <code>output</code> buffer is too small to hold the result,
-     * a <code>ShortBufferException</code> is thrown.
+     * <p>If the {@code output} buffer is too small to hold the result,
+     * a {@code ShortBufferException} is thrown.
      *
      * @param input the input buffer
-     * @param inputOffset the offset in <code>input</code> where the input
+     * @param inputOffset the offset in {@code input} where the input
      * starts
      * @param inputLen the input length
      * @param output the buffer for the result
-     * @param outputOffset the offset in <code>output</code> where the result
+     * @param outputOffset the offset in {@code output} where the result
      * is stored
      *
-     * @return the number of bytes stored in <code>output</code>
+     * @return the number of bytes stored in {@code output}
      *
-     * @exception ShortBufferException if the given output buffer is too small
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
      */
     protected abstract int engineUpdate(byte[] input, int inputOffset,
@@ -518,29 +517,29 @@ protected abstract int engineUpdate(byte[] input, int inputOffset,
      * (depending on how this cipher was initialized), processing another data
      * part.
      *
-     * <p>All <code>input.remaining()</code> bytes starting at
-     * <code>input.position()</code> are processed. The result is stored
+     * <p>All {@code input.remaining()} bytes starting at
+     * {@code input.position()} are processed. The result is stored
      * in the output buffer.
      * Upon return, the input buffer's position will be equal
      * to its limit; its limit will not have changed. The output buffer's
      * position will have advanced by n, where n is the value returned
      * by this method; the output buffer's limit will not have changed.
      *
-     * <p>If <code>output.remaining()</code> bytes are insufficient to
-     * hold the result, a <code>ShortBufferException</code> is thrown.
+     * <p>If {@code output.remaining()} bytes are insufficient to
+     * hold the result, a {@code ShortBufferException} is thrown.
      *
      * <p>Subclasses should consider overriding this method if they can
      * process ByteBuffers more efficiently than byte arrays.
      *
      * @param input the input ByteBuffer
      * @param output the output ByteBuffer
      *
-     * @return the number of bytes stored in <code>output</code>
+     * @return the number of bytes stored in {@code output}
      *
-     * @exception ShortBufferException if there is insufficient space in the
+     * @throws ShortBufferException if there is insufficient space in the
      * output buffer
      *
-     * @throws NullPointerException if either parameter is <CODE>null</CODE>
+     * @throws NullPointerException if either parameter is {@code null}
      * @since 1.5
      */
     protected int engineUpdate(ByteBuffer input, ByteBuffer output)
@@ -559,42 +558,41 @@ protected int engineUpdate(ByteBuffer input, ByteBuffer output)
      * The data is encrypted or decrypted, depending on how this cipher was
      * initialized.
      *
-     * <p>The first <code>inputLen</code> bytes in the <code>input</code>
-     * buffer, starting at <code>inputOffset</code> inclusive, and any input
-     * bytes that may have been buffered during a previous <code>update</code>
+     * <p>The first {@code inputLen} bytes in the {@code input}
+     * buffer, starting at {@code inputOffset} inclusive, and any input
+     * bytes that may have been buffered during a previous {@code update}
      * operation, are processed, with padding (if requested) being applied.
-     * If an AEAD mode such as GCM/CCM is being used, the authentication
+     * If an AEAD mode (such as GCM or CCM) is being used, the authentication
      * tag is appended in the case of encryption, or verified in the
      * case of decryption.
      * The result is stored in a new buffer.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to
-     * <code>engineInit</code>.
+     * {@code engineInit}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
-     * <code>engineInit</code>) more data.
+     * {@code engineInit}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * @param input the input buffer
-     * @param inputOffset the offset in <code>input</code> where the input
-     * starts
+     * @param inputOffset the offset in {@code input} where the input starts
      * @param inputLen the input length
      *
      * @return the new buffer with the result
      *
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
-     * process the input data provided.
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * process the input data provided
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
-     * AEAD mode (such as GCM/CCM), and the received authentication tag
+     * @throws AEADBadTagException if this cipher is decrypting in an
+     * AEAD mode (such as GCM or CCM), and the received authentication tag
      * does not match the calculated value
      */
     protected abstract byte[] engineDoFinal(byte[] input, int inputOffset,
@@ -607,51 +605,51 @@ protected abstract byte[] engineDoFinal(byte[] input, int inputOffset,
      * The data is encrypted or decrypted, depending on how this cipher was
      * initialized.
      *
-     * <p>The first <code>inputLen</code> bytes in the <code>input</code>
-     * buffer, starting at <code>inputOffset</code> inclusive, and any input
-     * bytes that may have been buffered during a previous <code>update</code>
+     * <p>The first {@code inputLen} bytes in the {@code input}
+     * buffer, starting at {@code inputOffset} inclusive, and any input
+     * bytes that may have been buffered during a previous {@code update}
      * operation, are processed, with padding (if requested) being applied.
-     * If an AEAD mode such as GCM/CCM is being used, the authentication
+     * If an AEAD mode such as GCM or CCM is being used, the authentication
      * tag is appended in the case of encryption, or verified in the
      * case of decryption.
-     * The result is stored in the <code>output</code> buffer, starting at
-     * <code>outputOffset</code> inclusive.
+     * The result is stored in the {@code output} buffer, starting at
+     * {@code outputOffset} inclusive.
      *
-     * <p>If the <code>output</code> buffer is too small to hold the result,
-     * a <code>ShortBufferException</code> is thrown.
+     * <p>If the {@code output} buffer is too small to hold the result,
+     * a {@code ShortBufferException} is thrown.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to
-     * <code>engineInit</code>.
+     * {@code engineInit}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
-     * <code>engineInit</code>) more data.
+     * {@code engineInit}) more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * @param input the input buffer
-     * @param inputOffset the offset in <code>input</code> where the input
+     * @param inputOffset the offset in {@code input} where the input
      * starts
      * @param inputLen the input length
      * @param output the buffer for the result
-     * @param outputOffset the offset in <code>output</code> where the result
+     * @param outputOffset the offset in {@code output} where the result
      * is stored
      *
-     * @return the number of bytes stored in <code>output</code>
+     * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
-     * process the input data provided.
-     * @exception ShortBufferException if the given output buffer is too small
+     * process the input data provided
+     * @throws ShortBufferException if the given output buffer is too small
      * to hold the result
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
-     * AEAD mode (such as GCM/CCM), and the received authentication tag
+     * @throws AEADBadTagException if this cipher is decrypting in an
+     * AEAD mode (such as GCM or CCM), and the received authentication tag
      * does not match the calculated value
      */
     protected abstract int engineDoFinal(byte[] input, int inputOffset,
@@ -666,9 +664,9 @@ protected abstract int engineDoFinal(byte[] input, int inputOffset,
      * The data is encrypted or decrypted, depending on how this cipher was
      * initialized.
      *
-     * <p>All <code>input.remaining()</code> bytes starting at
-     * <code>input.position()</code> are processed.
-     * If an AEAD mode such as GCM/CCM is being used, the authentication
+     * <p>All {@code input.remaining()} bytes starting at
+     * {@code input.position()} are processed.
+     * If an AEAD mode such as GCM or CCM is being used, the authentication
      * tag is appended in the case of encryption, or verified in the
      * case of decryption.
      * The result is stored in the output buffer.
@@ -677,17 +675,17 @@ protected abstract int engineDoFinal(byte[] input, int inputOffset,
      * position will have advanced by n, where n is the value returned
      * by this method; the output buffer's limit will not have changed.
      *
-     * <p>If <code>output.remaining()</code> bytes are insufficient to
-     * hold the result, a <code>ShortBufferException</code> is thrown.
+     * <p>If {@code output.remaining()} bytes are insufficient to
+     * hold the result, a {@code ShortBufferException} is thrown.
      *
-     * <p>Upon finishing, this method resets this cipher object to the state
+     * <p>Upon finishing, this method resets this cipher to the state
      * it was in when previously initialized via a call to
-     * <code>engineInit</code>.
+     * {@code engineInit}.
      * That is, the object is reset and available to encrypt or decrypt
      * (depending on the operation mode that was specified in the call to
-     * <code>engineInit</code>) more data.
+     * {@code engineInit} more data.
      *
-     * <p>Note: if any exception is thrown, this cipher object may need to
+     * <p>Note: if any exception is thrown, this cipher may need to
      * be reset before it can be used again.
      *
      * <p>Subclasses should consider overriding this method if they can
@@ -696,23 +694,23 @@ protected abstract int engineDoFinal(byte[] input, int inputOffset,
      * @param input the input ByteBuffer
      * @param output the output ByteBuffer
      *
-     * @return the number of bytes stored in <code>output</code>
+     * @return the number of bytes stored in {@code output}
      *
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested (only in encryption mode), and the total
      * input length of the data processed by this cipher is not a multiple of
      * block size; or if this encryption algorithm is unable to
-     * process the input data provided.
-     * @exception ShortBufferException if there is insufficient space in the
+     * process the input data provided
+     * @throws ShortBufferException if there is insufficient space in the
      * output buffer
-     * @exception BadPaddingException if this cipher is in decryption mode,
+     * @throws BadPaddingException if this cipher is in decryption mode,
      * and (un)padding has been requested, but the decrypted data is not
      * bounded by the appropriate padding bytes
-     * @exception AEADBadTagException if this cipher is decrypting in an
-     * AEAD mode (such as GCM/CCM), and the received authentication tag
+     * @throws AEADBadTagException if this cipher is decrypting in an
+     * AEAD mode (such as GCM or CCM), and the received authentication tag
      * does not match the calculated value
      *
-     * @throws NullPointerException if either parameter is <CODE>null</CODE>
+     * @throws NullPointerException if either parameter is {@code null}
      * @since 1.5
      */
     protected int engineDoFinal(ByteBuffer input, ByteBuffer output)
@@ -840,25 +838,25 @@ private int bufferCrypt(ByteBuffer input, ByteBuffer output,
      * <p>This concrete method has been added to this previously-defined
      * abstract class. (For backwards compatibility, it cannot be abstract.)
      * It may be overridden by a provider to wrap a key.
-     * Such an override is expected to throw an IllegalBlockSizeException or
-     * InvalidKeyException (under the specified circumstances),
-     * if the given key cannot be wrapped.
+     * Such an override is expected to throw an
+     * {@code IllegalBlockSizeException} or {@code InvalidKeyException}
+     * (under the specified circumstances), if the given key cannot be wrapped.
      * If this method is not overridden, it always throws an
-     * UnsupportedOperationException.
+     * {@code UnsupportedOperationException}.
      *
-     * @param key the key to be wrapped.
+     * @param key the key to be wrapped
      *
-     * @return the wrapped key.
+     * @return the wrapped key
      *
-     * @exception IllegalBlockSizeException if this cipher is a block cipher,
+     * @throws IllegalBlockSizeException if this cipher is a block cipher,
      * no padding has been requested, and the length of the encoding of the
-     * key to be wrapped is not a multiple of the block size.
+     * key to be wrapped is not a multiple of the block size
      *
-     * @exception InvalidKeyException if it is impossible or unsafe to
+     * @throws InvalidKeyException if it is impossible or unsafe to
      * wrap the key with this cipher (e.g., a hardware protected key is
-     * being passed to a software-only cipher).
+     * being passed to a software-only cipher)
      *
-     * @throws UnsupportedOperationException if this method is not supported.
+     * @throws UnsupportedOperationException if this method is not supported
      */
     protected byte[] engineWrap(Key key)
         throws IllegalBlockSizeException, InvalidKeyException
@@ -872,31 +870,30 @@ protected byte[] engineWrap(Key key)
      * <p>This concrete method has been added to this previously-defined
      * abstract class. (For backwards compatibility, it cannot be abstract.)
      * It may be overridden by a provider to unwrap a previously wrapped key.
-     * Such an override is expected to throw an InvalidKeyException if
+     * Such an override is expected to throw an {@code InvalidKeyException} if
      * the given wrapped key cannot be unwrapped.
      * If this method is not overridden, it always throws an
-     * UnsupportedOperationException.
+     * {@code UnsupportedOperationException}.
      *
-     * @param wrappedKey the key to be unwrapped.
+     * @param wrappedKey the key to be unwrapped
      *
      * @param wrappedKeyAlgorithm the algorithm associated with the wrapped
-     * key.
+     * key
      *
      * @param wrappedKeyType the type of the wrapped key. This is one of
-     * <code>SECRET_KEY</code>, <code>PRIVATE_KEY</code>, or
-     * <code>PUBLIC_KEY</code>.
+     * {@code SECRET_KEY}, {@code PRIVATE_KEY}, or {@code PUBLIC_KEY}.
      *
-     * @return the unwrapped key.
+     * @return the unwrapped key
      *
-     * @exception NoSuchAlgorithmException if no installed providers
-     * can create keys of type <code>wrappedKeyType</code> for the
-     * <code>wrappedKeyAlgorithm</code>.
+     * @throws NoSuchAlgorithmException if no installed providers
+     * can create keys of type {@code wrappedKeyType} for the
+     * {@code wrappedKeyAlgorithm}
      *
-     * @exception InvalidKeyException if <code>wrappedKey</code> does not
-     * represent a wrapped key of type <code>wrappedKeyType</code> for
-     * the <code>wrappedKeyAlgorithm</code>.
+     * @throws InvalidKeyException if {@code wrappedKey} does not
+     * represent a wrapped key of type {@code wrappedKeyType} for
+     * the {@code wrappedKeyAlgorithm}
      *
-     * @throws UnsupportedOperationException if this method is not supported.
+     * @throws UnsupportedOperationException if this method is not supported
      */
     protected Key engineUnwrap(byte[] wrappedKey,
                                String wrappedKeyAlgorithm,
@@ -909,14 +906,14 @@ protected Key engineUnwrap(byte[] wrappedKey,
     /**
      * Returns the key size of the given key object in bits.
      * <p>This concrete method has been added to this previously-defined
-     * abstract class. It throws an <code>UnsupportedOperationException</code>
+     * abstract class. It throws an {@code UnsupportedOperationException}
      * if it is not overridden by the provider.
      *
-     * @param key the key object.
+     * @param key the key object
      *
-     * @return the key size of the given key object.
+     * @return the key size of the given key object
      *
-     * @exception InvalidKeyException if <code>key</code> is invalid.
+     * @throws InvalidKeyException if {@code key} is invalid
      */
     protected int engineGetKeySize(Key key)
         throws InvalidKeyException
@@ -929,10 +926,10 @@ protected int engineGetKeySize(Key key)
      * Data (AAD), using a subset of the provided buffer.
      * <p>
      * Calls to this method provide AAD to the cipher when operating in
-     * modes such as AEAD (GCM/CCM).  If this cipher is operating in
+     * modes such as AEAD (GCM or CCM).  If this cipher is operating in
      * either GCM or CCM mode, all AAD must be supplied before beginning
-     * operations on the ciphertext (via the {@code update} and {@code
-     * doFinal} methods).
+     * operations on the ciphertext (via the {@code update} and
+     * {@code doFinal} methods).
      *
      * @param src the buffer containing the AAD
      * @param offset the offset in {@code src} where the AAD input starts
@@ -959,10 +956,10 @@ protected void engineUpdateAAD(byte[] src, int offset, int len) {
      * Data (AAD).
      * <p>
      * Calls to this method provide AAD to the cipher when operating in
-     * modes such as AEAD (GCM/CCM).  If this cipher is operating in
+     * modes such as AEAD (GCM or CCM).  If this cipher is operating in
      * either GCM or CCM mode, all AAD must be supplied before beginning
-     * operations on the ciphertext (via the {@code update} and {@code
-     * doFinal} methods).
+     * operations on the ciphertext (via the {@code update} and
+     * {@code doFinal} methods).
      * <p>
      * All {@code src.remaining()} bytes starting at
      * {@code src.position()} are processed.