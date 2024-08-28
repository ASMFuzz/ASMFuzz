@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,10 @@
 
 package jdk.internal.math;
 
+import static java.lang.Float.MIN_EXPONENT;
+import static java.lang.Float.PRECISION;
+import static java.lang.Float.SIZE;
+
 /**
  * This class contains additional constants documenting limits of the
  * {@code float} type.
@@ -42,42 +46,42 @@ private FloatConsts() {}
      * The number of logical bits in the significand of a
      * {@code float} number, including the implicit bit.
      */
-    public static final int SIGNIFICAND_WIDTH   = 24;
+    public static final int SIGNIFICAND_WIDTH = PRECISION;
 
     /**
-     * The exponent the smallest positive {@code float} subnormal
-     * value would have if it could be normalized.
+     * The exponent the smallest positive {@code float}
+     * subnormal value would have if it could be normalized.
      */
-    public static final int     MIN_SUB_EXPONENT = Float.MIN_EXPONENT -
-                                                   (SIGNIFICAND_WIDTH - 1);
+    public static final int MIN_SUB_EXPONENT =
+            MIN_EXPONENT - (SIGNIFICAND_WIDTH - 1); // -149
 
     /**
      * Bias used in representing a {@code float} exponent.
      */
-    public static final int     EXP_BIAS        = 127;
+    public static final int EXP_BIAS =
+            (1 << (SIZE - SIGNIFICAND_WIDTH - 1)) - 1; // 127
 
     /**
      * Bit mask to isolate the sign bit of a {@code float}.
      */
-    public static final int     SIGN_BIT_MASK   = 0x80000000;
+    public static final int SIGN_BIT_MASK = 1 << (SIZE - 1);
 
     /**
-     * Bit mask to isolate the exponent field of a
-     * {@code float}.
+     * Bit mask to isolate the exponent field of a {@code float}.
      */
-    public static final int     EXP_BIT_MASK    = 0x7F800000;
+    public static final int EXP_BIT_MASK =
+            ((1 << (SIZE - SIGNIFICAND_WIDTH)) - 1) << (SIGNIFICAND_WIDTH - 1);
 
     /**
-     * Bit mask to isolate the significand field of a
-     * {@code float}.
+     * Bit mask to isolate the significand field of a {@code float}.
      */
-    public static final int     SIGNIF_BIT_MASK = 0x007FFFFF;
+    public static final int SIGNIF_BIT_MASK = (1 << (SIGNIFICAND_WIDTH - 1)) - 1;
 
     /**
      * Bit mask to isolate the magnitude bits (combined exponent and
      * significand fields) of a {@code float}.
      */
-    public static final int     MAG_BIT_MASK = ~SIGN_BIT_MASK;
+    public static final int MAG_BIT_MASK = EXP_BIT_MASK | SIGNIF_BIT_MASK;
 
     static {
         // verify bit masks cover all bit positions and that the bit