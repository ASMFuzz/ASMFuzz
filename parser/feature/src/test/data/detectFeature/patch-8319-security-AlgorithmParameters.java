@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -75,13 +75,13 @@
 public class AlgorithmParameters {
 
     // The provider
-    private Provider provider;
+    private final Provider provider;
 
     // The provider implementation (delegate)
-    private AlgorithmParametersSpi paramSpi;
+    private final AlgorithmParametersSpi paramSpi;
 
     // The algorithm
-    private String algorithm;
+    private final String algorithm;
 
     // Has this object been initialized?
     private boolean initialized = false;
@@ -131,7 +131,7 @@ public final String getAlgorithm() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the name of the algorithm requested.
@@ -342,7 +342,7 @@ public final void init(byte[] params, String format) throws IOException {
      * parameters should be returned in an instance of the
      * {@code DSAParameterSpec} class.
      *
-     * @param <T> the type of the parameter specification to be returrned
+     * @param <T> the type of the parameter specification to be returned
      * @param paramSpec the specification class in which
      * the parameters should be returned.
      *
@@ -356,7 +356,7 @@ public final void init(byte[] params, String format) throws IOException {
         T getParameterSpec(Class<T> paramSpec)
         throws InvalidParameterSpecException
     {
-        if (this.initialized == false) {
+        if (!this.initialized) {
             throw new InvalidParameterSpecException("not initialized");
         }
         return paramSpi.engineGetParameterSpec(paramSpec);
@@ -374,7 +374,7 @@ T getParameterSpec(Class<T> paramSpec)
      */
     public final byte[] getEncoded() throws IOException
     {
-        if (this.initialized == false) {
+        if (!this.initialized) {
             throw new IOException("not initialized");
         }
         return paramSpi.engineGetEncoded();
@@ -396,7 +396,7 @@ public final byte[] getEncoded() throws IOException
      */
     public final byte[] getEncoded(String format) throws IOException
     {
-        if (this.initialized == false) {
+        if (!this.initialized) {
             throw new IOException("not initialized");
         }
         return paramSpi.engineGetEncoded(format);
@@ -409,7 +409,7 @@ public final byte[] getEncoded(String format) throws IOException
      * parameter object has not been initialized.
      */
     public final String toString() {
-        if (this.initialized == false) {
+        if (!this.initialized) {
             return null;
         }
         return paramSpi.engineToString();