@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -205,14 +205,30 @@ public final class Double extends Number
      */
     public static final double MIN_VALUE = 0x0.0000000000001P-1022; // 4.9e-324
 
+    /**
+     * The number of bits used to represent a {@code double} value.
+     *
+     * @since 1.5
+     */
+    public static final int SIZE = 64;
+
+    /**
+     * The number of bits in the significand of a {@code double} value.
+     * This is the parameter N in section {@jls 4.2.3} of
+     * <cite>The Java Language Specification</cite>.
+     *
+     * @since 19
+     */
+    public static final int PRECISION = 53;
+
     /**
      * Maximum exponent a finite {@code double} variable may have.
      * It is equal to the value returned by
      * {@code Math.getExponent(Double.MAX_VALUE)}.
      *
      * @since 1.6
      */
-    public static final int MAX_EXPONENT = 1023;
+    public static final int MAX_EXPONENT = (1 << (SIZE - PRECISION - 1)) - 1; // 1023
 
     /**
      * Minimum exponent a normalized {@code double} variable may
@@ -221,14 +237,7 @@ public final class Double extends Number
      *
      * @since 1.6
      */
-    public static final int MIN_EXPONENT = -1022;
-
-    /**
-     * The number of bits used to represent a {@code double} value.
-     *
-     * @since 1.5
-     */
-    public static final int SIZE = 64;
+    public static final int MIN_EXPONENT = 1 - MAX_EXPONENT; // -1022
 
     /**
      * The number of bytes used to represent a {@code double} value.