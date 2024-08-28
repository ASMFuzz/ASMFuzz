@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,10 @@
 
 package jdk.internal.math;
 
+import static java.lang.Double.MIN_EXPONENT;
+import static java.lang.Double.PRECISION;
+import static java.lang.Double.SIZE;
+
 /**
  * This class contains additional constants documenting limits of the
  * {@code double} type.
@@ -42,42 +46,42 @@ private DoubleConsts() {}
      * The number of logical bits in the significand of a
      * {@code double} number, including the implicit bit.
      */
-    public static final int SIGNIFICAND_WIDTH   = 53;
+    public static final int SIGNIFICAND_WIDTH = PRECISION;
 
     /**
      * The exponent the smallest positive {@code double}
      * subnormal value would have if it could be normalized..
      */
-    public static final int     MIN_SUB_EXPONENT = Double.MIN_EXPONENT -
-                                                   (SIGNIFICAND_WIDTH - 1);
+    public static final int MIN_SUB_EXPONENT =
+            MIN_EXPONENT - (SIGNIFICAND_WIDTH - 1); // -1074
 
     /**
      * Bias used in representing a {@code double} exponent.
      */
-    public static final int     EXP_BIAS        = 1023;
+    public static final int EXP_BIAS =
+            (1 << (SIZE - SIGNIFICAND_WIDTH - 1)) - 1; // 1023
 
     /**
      * Bit mask to isolate the sign bit of a {@code double}.
      */
-    public static final long    SIGN_BIT_MASK   = 0x8000000000000000L;
+    public static final long SIGN_BIT_MASK = 1L << (SIZE - 1);
 
     /**
-     * Bit mask to isolate the exponent field of a
-     * {@code double}.
+     * Bit mask to isolate the exponent field of a {@code double}.
      */
-    public static final long    EXP_BIT_MASK    = 0x7FF0000000000000L;
+    public static final long EXP_BIT_MASK =
+            ((1L << (SIZE - SIGNIFICAND_WIDTH)) - 1) << (SIGNIFICAND_WIDTH - 1);
 
     /**
-     * Bit mask to isolate the significand field of a
-     * {@code double}.
+     * Bit mask to isolate the significand field of a {@code double}.
      */
-    public static final long    SIGNIF_BIT_MASK = 0x000FFFFFFFFFFFFFL;
+    public static final long SIGNIF_BIT_MASK = (1L << (SIGNIFICAND_WIDTH - 1)) - 1;
 
     /**
      * Bit mask to isolate the magnitude bits (combined exponent and
      * significand fields) of a {@code double}.
      */
-    public static final long    MAG_BIT_MASK = ~SIGN_BIT_MASK;
+    public static final long MAG_BIT_MASK = EXP_BIT_MASK | SIGNIF_BIT_MASK;
 
     static {
         // verify bit masks cover all bit positions and that the bit
@@ -87,6 +91,5 @@ private DoubleConsts() {}
                 ((SIGN_BIT_MASK & SIGNIF_BIT_MASK) == 0L) &&
                 ((EXP_BIT_MASK & SIGNIF_BIT_MASK) == 0L)) &&
                 ((SIGN_BIT_MASK | MAG_BIT_MASK) == ~0L));
-
     }
 }