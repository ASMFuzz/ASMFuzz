@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -218,7 +218,7 @@ public final String getAlgorithm() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the standard name of the requested key algorithm.
@@ -359,16 +359,15 @@ private KeyGeneratorSpi nextSpi(KeyGeneratorSpi oldSpi,
             }
             while (serviceIterator.hasNext()) {
                 Service s = serviceIterator.next();
-                if (JceSecurity.canUseProvider(s.getProvider()) == false) {
+                if (!JceSecurity.canUseProvider(s.getProvider())) {
                     continue;
                 }
                 try {
                     Object inst = s.newInstance(null);
                     // ignore non-spis
-                    if (inst instanceof KeyGeneratorSpi == false) {
+                    if (!(inst instanceof KeyGeneratorSpi spi)) {
                         continue;
                     }
-                    KeyGeneratorSpi spi = (KeyGeneratorSpi)inst;
                     if (reinit) {
                         if (initType == I_SIZE) {
                             spi.engineInit(initKeySize, initRandom);
@@ -489,10 +488,7 @@ public final void init(AlgorithmParameterSpec params, SecureRandom random)
         if (failure instanceof InvalidAlgorithmParameterException) {
             throw (InvalidAlgorithmParameterException)failure;
         }
-        if (failure instanceof RuntimeException) {
-            throw (RuntimeException)failure;
-        }
-        throw new InvalidAlgorithmParameterException("init() failed", failure);
+        throw (RuntimeException)failure;
     }
 
     /**