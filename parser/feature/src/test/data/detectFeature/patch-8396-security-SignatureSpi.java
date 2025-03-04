@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -81,7 +81,7 @@ protected abstract void engineInitVerify(PublicKey publicKey)
      *
      * @param publicKey the public key of the identity whose signature is
      * going to be verified.
-     * @param params the parameters for generating this signature
+     * @param params the parameters for verifying this signature object
      *
      * @throws    InvalidKeyException if the key is improperly
      * encoded, does not work with the given parameters, and so on.
@@ -145,7 +145,7 @@ protected void engineInitSign(PrivateKey privateKey,
      *
      * @param privateKey the private key of the identity whose signature
      * will be generated.
-     * @param params the parameters for generating this signature
+     * @param params the parameters for generating signature
      * @param random the source of randomness
      *
      * @throws    InvalidKeyException if the key is improperly
@@ -358,7 +358,7 @@ protected boolean engineVerify(byte[] sigBytes, int offset, int length)
      * @param value the parameter value.
      *
      * @throws    InvalidParameterException if {@code param} is an
-     * invalid parameter for this signature algorithm engine,
+     * invalid parameter for this signature object,
      * the parameter is already set
      * and cannot be set again, a security exception occurs, and so on.
      *
@@ -371,8 +371,7 @@ protected abstract void engineSetParameter(String param, Object value)
             throws InvalidParameterException;
 
     /**
-     * <p>This method is overridden by providers to initialize
-     * this signature engine with the specified parameter set.
+     * Initializes this signature object with the specified parameter values.
      *
      * @param params the parameters
      *
@@ -381,31 +380,31 @@ protected abstract void engineSetParameter(String param, Object value)
      *
      * @throws    InvalidAlgorithmParameterException if this method is
      * overridden by a provider and the given parameters
-     * are inappropriate for this signature engine
+     * are inappropriate for this signature object
      */
     protected void engineSetParameter(AlgorithmParameterSpec params)
             throws InvalidAlgorithmParameterException {
         throw new UnsupportedOperationException();
     }
 
     /**
-     * <p>This method is overridden by providers to return the parameters
-     * used with this signature engine.
-     *
-     * <p> If this signature engine has been initialized with parameters
-     * (by calling {@link #engineSetParameter(AlgorithmParameterSpec)} or
-     * {@link #engineSetParameter(String, Object)}) and the underlying signature
-     * implementation supports returning the parameters as
-     * {@code AlgorithmParameters}, this method returns the same parameters.
-     * If the parameters were not set, this method may return a combination
-     * of default and randomly generated parameter values if the
-     * underlying signature implementation supports it and can successfully
-     * generate them. Otherwise, {@code null} is returned.
-     *
-     * @return the parameters used with this signature engine, or {@code null}
-     *
-     * @throws    UnsupportedOperationException if this method is
-     * not overridden by a provider
+     * Returns the parameters used with this signature object.
+     *
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
+     *
+     * @throws UnsupportedOperationException if this method is not overridden
+     * by a provider
      * @since 1.4
      */
     protected AlgorithmParameters engineGetParameters() {