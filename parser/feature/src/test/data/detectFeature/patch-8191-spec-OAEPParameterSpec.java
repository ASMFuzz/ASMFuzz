@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -72,13 +72,6 @@
  * }
  * EncodingParameters ::= OCTET STRING(SIZE(0..MAX))
  * </pre>
- * <p>Note: the OAEPParameterSpec.DEFAULT uses the following:
- * <pre>
- *     message digest  -- "SHA-1"
- *     mask generation function (mgf) -- "MGF1"
- *     parameters for mgf -- MGF1ParameterSpec.SHA1
- *     source of encoding input -- PSource.PSpecified.DEFAULT
- * </pre>
  *
  * @see java.security.spec.MGF1ParameterSpec
  * @see PSource
@@ -89,39 +82,49 @@
  */
 public class OAEPParameterSpec implements AlgorithmParameterSpec {
 
-    private String mdName = "SHA-1";
-    private String mgfName = "MGF1";
-    private AlgorithmParameterSpec mgfSpec = MGF1ParameterSpec.SHA1;
-    private PSource pSrc = PSource.PSpecified.DEFAULT;
-
-    /**
-     * The OAEP parameter set with all default values.
-     */
-    public static final OAEPParameterSpec DEFAULT = new OAEPParameterSpec();
+    private final String mdName;
+    private final String mgfName;
+    private final AlgorithmParameterSpec mgfSpec;
+    private final PSource pSrc;
 
     /**
-     * Constructs a parameter set for OAEP padding as defined in
-     * the PKCS #1 standard using the default values.
+     * The OAEP parameter set with all default values, i.e. "SHA-1" as message
+     * digest algorithm, "MGF1" as mask generation function (mgf) algorithm,
+     * {@code MGF1ParameterSpec.SHA1} as parameters for the mask generation
+     * function, and {@code PSource.PSpecified.DEFAULT} as the source of the
+     * encoding input.
+     *
+     * @deprecated This field uses the default values defined in the PKCS #1
+     *         standard. Some of these defaults are no longer recommended due
+     *         to advances in cryptanalysis -- see
+     *         <a href="https://www.rfc-editor.org/rfc/rfc8017#appendix-B.1">Appendix B.1 of PKCS #1</a>
+     *         for more details. Thus, it is recommended to create
+     *         a new {@code OAEPParameterSpec} with the desired parameter values
+     *         using the
+     *         {@link #OAEPParameterSpec(String, String, AlgorithmParameterSpec, PSource)} constructor.
+     *
      */
-    private OAEPParameterSpec() {
-    }
+    @Deprecated(since="19")
+    public static final OAEPParameterSpec DEFAULT = new OAEPParameterSpec(
+            "SHA-1", "MGF1", MGF1ParameterSpec.SHA1,
+            PSource.PSpecified.DEFAULT);
 
     /**
      * Constructs a parameter set for OAEP padding as defined in
      * the PKCS #1 standard using the specified message digest
-     * algorithm <code>mdName</code>, mask generation function
-     * algorithm <code>mgfName</code>, parameters for the mask
-     * generation function <code>mgfSpec</code>, and source of
-     * the encoding input P <code>pSrc</code>.
+     * algorithm {@code mdName}, mask generation function
+     * algorithm {@code mgfName}, parameters for the mask
+     * generation function {@code mgfSpec}, and source of
+     * the encoding input P {@code pSrc}.
      *
-     * @param mdName the algorithm name for the message digest.
-     * @param mgfName the algorithm name for the mask generation
-     * function.
-     * @param mgfSpec the parameters for the mask generation function.
-     * If null is specified, null will be returned by getMGFParameters().
-     * @param pSrc the source of the encoding input P.
-     * @exception NullPointerException if <code>mdName</code>,
-     * <code>mgfName</code>, or <code>pSrc</code> is null.
+     * @param mdName the algorithm name for the message digest
+     * @param mgfName the algorithm name for the mask generation function
+     * @param mgfSpec the parameters for the mask generation function;
+     * if {@code null} is specified, {@code null} will be returned by
+     * {@link #getMGFParameters()}
+     * @param pSrc the source of the encoding input P
+     * @throws NullPointerException if {@code mdName},
+     * {@code mgfName}, or {@code pSrc} is {@code null}
      */
     public OAEPParameterSpec(String mdName, String mgfName,
                              AlgorithmParameterSpec mgfSpec,