@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -52,13 +52,13 @@
 public class ExemptionMechanism {
 
     // The provider
-    private Provider provider;
+    private final Provider provider;
 
     // The provider implementation (delegate)
-    private ExemptionMechanismSpi exmechSpi;
+    private final ExemptionMechanismSpi exmechSpi;
 
     // The name of the exemption mechanism.
-    private String mechanism;
+    private final String mechanism;
 
     // Flag which indicates whether this ExemptionMechanism
     // result is generated successfully.
@@ -118,7 +118,7 @@ public final String getName() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the standard name of the requested exemption
@@ -228,7 +228,7 @@ public static final ExemptionMechanism getInstance(String algorithm,
      * @see java.security.Provider
      */
     public static final ExemptionMechanism getInstance(String algorithm,
-            Provider provider) throws NoSuchAlgorithmException {
+        Provider provider) throws NoSuchAlgorithmException {
         Objects.requireNonNull(algorithm, "null algorithm name");
         Instance instance = JceSecurity.getInstance("ExemptionMechanism",
                 ExemptionMechanismSpi.class, algorithm, provider);