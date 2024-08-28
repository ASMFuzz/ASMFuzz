@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -157,7 +157,7 @@ public final String getAlgorithm() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the standard name of the requested key agreement
@@ -186,7 +186,7 @@ public static final KeyAgreement getInstance(String algorithm)
         Iterator<Service> t = services.iterator();
         while (t.hasNext()) {
             Service s = t.next();
-            if (JceSecurity.canUseProvider(s.getProvider()) == false) {
+            if (!JceSecurity.canUseProvider(s.getProvider())) {
                 continue;
             }
             return new KeyAgreement(s, t, algorithm);
@@ -319,12 +319,12 @@ void chooseFirstProvider() {
                 } else {
                     s = serviceIterator.next();
                 }
-                if (JceSecurity.canUseProvider(s.getProvider()) == false) {
+                if (!JceSecurity.canUseProvider(s.getProvider())) {
                     continue;
                 }
                 try {
                     Object obj = s.newInstance(null);
-                    if (obj instanceof KeyAgreementSpi == false) {
+                    if (!(obj instanceof KeyAgreementSpi)) {
                         continue;
                     }
                     spi = (KeyAgreementSpi)obj;
@@ -377,10 +377,10 @@ private void chooseProvider(int initType, Key key,
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
@@ -563,7 +563,7 @@ public final void init(Key key, AlgorithmParameterSpec params,
      * @param key the key for this phase. For example, in the case of
      * Diffie-Hellman between 2 parties, this would be the other party's
      * Diffie-Hellman public key.
-     * @param lastPhase flag which indicates whether or not this is the last
+     * @param lastPhase flag which indicates whether this is the last
      * phase of this key agreement.
      *
      * @return the (intermediate) key resulting from this phase, or null