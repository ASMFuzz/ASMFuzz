@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -156,7 +156,7 @@ public final String getAlgorithm() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the standard name of the requested MAC algorithm.
@@ -182,7 +182,7 @@ public static final Mac getInstance(String algorithm)
         Iterator<Service> t = services.iterator();
         while (t.hasNext()) {
             Service s = t.next();
-            if (JceSecurity.canUseProvider(s.getProvider()) == false) {
+            if (!JceSecurity.canUseProvider(s.getProvider())) {
                 continue;
             }
             return new Mac(s, t, algorithm);
@@ -310,12 +310,12 @@ void chooseFirstProvider() {
                 } else {
                     s = serviceIterator.next();
                 }
-                if (JceSecurity.canUseProvider(s.getProvider()) == false) {
+                if (!JceSecurity.canUseProvider(s.getProvider())) {
                     continue;
                 }
                 try {
                     Object obj = s.newInstance(null);
-                    if (obj instanceof MacSpi == false) {
+                    if (!(obj instanceof MacSpi)) {
                         continue;
                     }
                     spi = (MacSpi)obj;
@@ -354,10 +354,10 @@ private void chooseProvider(Key key, AlgorithmParameterSpec params)
                     s = serviceIterator.next();
                 }
                 // if provider says it does not support this key, ignore it
-                if (s.supportsParameter(key) == false) {
+                if (!s.supportsParameter(key)) {
                     continue;
                 }
-                if (JceSecurity.canUseProvider(s.getProvider()) == false) {
+                if (!JceSecurity.canUseProvider(s.getProvider())) {
                     continue;
                 }
                 try {
@@ -481,7 +481,7 @@ public final void init(Key key, AlgorithmParameterSpec params)
      */
     public final void update(byte input) throws IllegalStateException {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
         spi.engineUpdate(input);
@@ -497,7 +497,7 @@ public final void update(byte input) throws IllegalStateException {
      */
     public final void update(byte[] input) throws IllegalStateException {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
         if (input != null) {
@@ -519,7 +519,7 @@ public final void update(byte[] input) throws IllegalStateException {
     public final void update(byte[] input, int offset, int len)
             throws IllegalStateException {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
 
@@ -544,7 +544,7 @@ public final void update(byte[] input, int offset, int len)
      */
     public final void update(ByteBuffer input) {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
         if (input == null) {
@@ -574,7 +574,7 @@ public final void update(ByteBuffer input) {
      */
     public final byte[] doFinal() throws IllegalStateException {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
         byte[] mac = spi.engineDoFinal();
@@ -612,7 +612,7 @@ public final void doFinal(byte[] output, int outOffset)
         throws ShortBufferException, IllegalStateException
     {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
         int macLen = getMacLength();
@@ -622,7 +622,6 @@ public final void doFinal(byte[] output, int outOffset)
         }
         byte[] mac = doFinal();
         System.arraycopy(mac, 0, output, outOffset, macLen);
-        return;
     }
 
     /**
@@ -648,7 +647,7 @@ public final void doFinal(byte[] output, int outOffset)
     public final byte[] doFinal(byte[] input) throws IllegalStateException
     {
         chooseFirstProvider();
-        if (initialized == false) {
+        if (!initialized) {
             throw new IllegalStateException("MAC not initialized");
         }
         update(input);