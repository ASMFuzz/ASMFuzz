@@ -518,11 +518,11 @@ public final void initVerify(PublicKey publicKey)
      * of this call.
      *
      * @param publicKey the public key of the identity whose signature is
-     * going to be verified.
-     * @param params the parameters used for verifying this signature.
+     * going to be verified
+     * @param params the parameters used for verifying this signature object
      *
-     * @throws    InvalidKeyException if the key is invalid.
-     * @throws    InvalidAlgorithmParameterException if the params is invalid.
+     * @throws    InvalidKeyException if the key is invalid
+     * @throws    InvalidAlgorithmParameterException if the params is invalid
      */
     final void initVerify(PublicKey publicKey, AlgorithmParameterSpec params)
             throws InvalidKeyException, InvalidAlgorithmParameterException {
@@ -598,13 +598,13 @@ public final void initVerify(Certificate certificate)
      * {@code InvalidKeyException} is thrown.
      *
      * @param certificate the certificate of the identity whose signature is
-     * going to be verified.
-     * @param params the parameters used for verifying this signature.
+     * going to be verified
+     * @param params the parameters used for verifying this signature object
      *
      * @throws    InvalidKeyException  if the public key in the certificate
      * is not encoded properly or does not include required  parameter
-     * information or cannot be used for digital signature purposes.
-     * @throws    InvalidAlgorithmParameterException if the params is invalid.
+     * information or cannot be used for digital signature purposes
+     * @throws    InvalidAlgorithmParameterException if the params is invalid
      *
      * @since 13
      */
@@ -647,9 +647,9 @@ public final void initSign(PrivateKey privateKey)
      * of this call.
      *
      * @param privateKey the private key of the identity whose signature
-     * is going to be generated.
+     * is going to be generated
      *
-     * @param random the source of randomness for this signature.
+     * @param random the source of randomness for this signature object
      *
      * @throws    InvalidKeyException if the key is invalid.
      */
@@ -670,11 +670,11 @@ public final void initSign(PrivateKey privateKey, SecureRandom random)
      * of this call.
      *
      * @param privateKey the private key of the identity whose signature
-     * is going to be generated.
-     * @param params the parameters used for generating signature.
-     * @param random the source of randomness for this signature.
+     * is going to be generated
+     * @param params the parameters used for generating signature
+     * @param random the source of randomness for this signature object
      *
-     * @throws    InvalidKeyException if the key is invalid.
+     * @throws    InvalidKeyException if the key is invalid
      * @throws    InvalidAlgorithmParameterException if the params is invalid
      */
     final void initSign(PrivateKey privateKey,
@@ -967,11 +967,11 @@ public String toString() {
      * naming scheme for each parameter is desirable but left unspecified
      * at this time.
      *
-     * @param param the string identifier of the parameter.
-     * @param value the parameter value.
+     * @param param the string identifier of the parameter
+     * @param value the parameter value
      *
      * @throws    InvalidParameterException if {@code param} is an
-     * invalid parameter for this signature algorithm engine,
+     * invalid parameter for this signature object,
      * the parameter is already set
      * and cannot be set again, a security exception occurs, and so on.
      *
@@ -988,12 +988,12 @@ public final void setParameter(String param, Object value)
     }
 
     /**
-     * Initializes this signature engine with the specified parameter set.
+     * Initializes this signature object with the specified parameter values.
      *
-     * @param params the parameters
+     * @param params the parameter values
      *
-     * @throws    InvalidAlgorithmParameterException if the given parameters
-     * are inappropriate for this signature engine
+     * @throws InvalidAlgorithmParameterException if the given parameter values
+     * are inappropriate for this signature object
      *
      * @see #getParameters
      */
@@ -1005,17 +1005,20 @@ public final void setParameter(AlgorithmParameterSpec params)
     /**
      * Returns the parameters used with this signature object.
      *
-     * <p> If this signature has been initialized with parameters
-     * (by calling {@link #setParameter(AlgorithmParameterSpec)} or
-     * {@link #setParameter(String, Object)}) and the underlying signature
-     * implementation supports returning the parameters as
-     * {@code AlgorithmParameters}, this method returns the same parameters.
-     * If the parameters were not set, this method may return a combination
-     * of default and randomly generated parameter values if the
-     * underlying signature implementation supports it and can successfully
-     * generate them. Otherwise, {@code null} is returned.
-     *
-     * @return the parameters used with this signature, or {@code null}
+     * <p>The returned parameters may be the same that were used to initialize
+     * this signature object, or may contain additional default or random
+     * parameter values used by the underlying signature scheme. If the required
+     * parameters were not supplied and can be generated by the signature
+     * object, the generated parameters are returned; otherwise {@code null} is
+     * returned.
+     *
+     * <p>However, if the signature scheme does not support returning
+     * the parameters as {@code AlgorithmParameters}, {@code null} is always
+     * returned.
+     *
+     * @return the parameters used with this signature object, or {@code null}
+     * @throws UnsupportedOperationException if the provider does not support
+     * this method
      *
      * @see #setParameter(AlgorithmParameterSpec)
      * @since 1.4