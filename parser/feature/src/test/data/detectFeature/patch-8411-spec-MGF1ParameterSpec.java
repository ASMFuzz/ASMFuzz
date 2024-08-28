@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -65,76 +65,84 @@
 public class MGF1ParameterSpec implements AlgorithmParameterSpec {
 
     /**
-     * The MGF1ParameterSpec which uses "SHA-1" message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-1" message digest.
      */
     public static final MGF1ParameterSpec SHA1 =
         new MGF1ParameterSpec("SHA-1");
 
     /**
-     * The MGF1ParameterSpec which uses "SHA-224" message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-224" message digest.
      */
     public static final MGF1ParameterSpec SHA224 =
         new MGF1ParameterSpec("SHA-224");
 
     /**
-     * The MGF1ParameterSpec which uses "SHA-256" message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-256" message digest.
      */
     public static final MGF1ParameterSpec SHA256 =
         new MGF1ParameterSpec("SHA-256");
 
     /**
-     * The MGF1ParameterSpec which uses "SHA-384" message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-384" message digest.
      */
     public static final MGF1ParameterSpec SHA384 =
         new MGF1ParameterSpec("SHA-384");
 
     /**
-     * The MGF1ParameterSpec which uses SHA-512 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-512" message digest.
      */
     public static final MGF1ParameterSpec SHA512 =
         new MGF1ParameterSpec("SHA-512");
 
     /**
-     * The MGF1ParameterSpec which uses SHA-512/224 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-512/224" message digest.
+     *
+     * @since 11
      */
     public static final MGF1ParameterSpec SHA512_224 =
         new MGF1ParameterSpec("SHA-512/224");
 
     /**
-     * The MGF1ParameterSpec which uses SHA-512/256 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA-512/256" message digest.
+     *
+     * @since 11
      */
     public static final MGF1ParameterSpec SHA512_256 =
         new MGF1ParameterSpec("SHA-512/256");
 
     /**
-     * The MGF1ParameterSpec which uses SHA3-224 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA3-224" message digest.
+     *
      * @since 16
      */
     public static final MGF1ParameterSpec SHA3_224 =
         new MGF1ParameterSpec("SHA3-224");
 
     /**
-     * The MGF1ParameterSpec which uses SHA3-256 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA3-256" message digest.
+     *
      * @since 16
      */
     public static final MGF1ParameterSpec SHA3_256 =
         new MGF1ParameterSpec("SHA3-256");
 
     /**
-     * The MGF1ParameterSpec which uses SHA3-384 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA3-384" message digest.
+     *
      * @since 16
      */
     public static final MGF1ParameterSpec SHA3_384 =
         new MGF1ParameterSpec("SHA3-384");
 
     /**
-     * The MGF1ParameterSpec which uses SHA3-512 message digest
+     * The {@code MGF1ParameterSpec} uses a "SHA3-512" message digest.
+     *
      * @since 16
      */
     public static final MGF1ParameterSpec SHA3_512 =
         new MGF1ParameterSpec("SHA3-512");
 
-    private String mdName;
+    private final String mdName;
 
     /**
      * Constructs a parameter set for mask generation function MGF1