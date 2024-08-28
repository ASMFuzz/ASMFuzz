@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -99,13 +99,13 @@
 public class AlgorithmParameterGenerator {
 
     // The provider
-    private Provider provider;
+    private final Provider provider;
 
     // The provider implementation (delegate)
-    private AlgorithmParameterGeneratorSpi paramGenSpi;
+    private final AlgorithmParameterGeneratorSpi paramGenSpi;
 
     // The algorithm
-    private String algorithm;
+    private final String algorithm;
 
     /**
      * Creates an AlgorithmParameterGenerator object.
@@ -150,7 +150,7 @@ public final String getAlgorithm() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the name of the algorithm this