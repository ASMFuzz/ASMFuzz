@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -115,14 +115,30 @@ public final class Float extends Number
      */
     public static final float MIN_VALUE = 0x0.000002P-126f; // 1.4e-45f
 
+    /**
+     * The number of bits used to represent a {@code float} value.
+     *
+     * @since 1.5
+     */
+    public static final int SIZE = 32;
+
+    /**
+     * The number of bits in the significand of a {@code float} value.
+     * This is the parameter N in section {@jls 4.2.3} of
+     * <cite>The Java Language Specification</cite>.
+     *
+     * @since 19
+     */
+    public static final int PRECISION = 24;
+
     /**
      * Maximum exponent a finite {@code float} variable may have.  It
      * is equal to the value returned by {@code
      * Math.getExponent(Float.MAX_VALUE)}.
      *
      * @since 1.6
      */
-    public static final int MAX_EXPONENT = 127;
+    public static final int MAX_EXPONENT = (1 << (SIZE - PRECISION - 1)) - 1; // 127
 
     /**
      * Minimum exponent a normalized {@code float} variable may have.
@@ -131,14 +147,7 @@ public final class Float extends Number
      *
      * @since 1.6
      */
-    public static final int MIN_EXPONENT = -126;
-
-    /**
-     * The number of bits used to represent a {@code float} value.
-     *
-     * @since 1.5
-     */
-    public static final int SIZE = 32;
+    public static final int MIN_EXPONENT = 1 - MAX_EXPONENT; // -126
 
     /**
      * The number of bytes used to represent a {@code float} value.