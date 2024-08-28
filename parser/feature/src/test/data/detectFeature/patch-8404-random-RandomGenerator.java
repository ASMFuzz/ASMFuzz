@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -55,7 +55,8 @@
  * possible values of the type. In the case of {@code float} and {@code double}
  * values, first a value is always chosen uniformly from the set of
  * 2<sup><i>w</i></sup> values between 0.0 (inclusive) and 1.0 (exclusive),
- * where <i>w</i> is 23 for {@code float} values and 52 for {@code double}
+ * where <i>w</i> is {@link Float#PRECISION} for {@code float} values
+ * and {@link Double#PRECISION} for {@code double}
  * values, such that adjacent values differ by 2<sup>&minus;<i>w</i></sup>
  * (notice that this set is a <i>subset</i> of the set of
  * <i>all representable floating-point values</i> between 0.0 (inclusive) and 1.0 (exclusive));
@@ -496,11 +497,11 @@ default void nextBytes(byte[] bytes) {
      *
      * @return a pseudorandom {@code float} value between zero (inclusive) and one (exclusive)
      *
-     * @implSpec The default implementation uses the 24 high-order bits from a call to
-     * {@link RandomGenerator#nextInt() nextInt}().
+     * @implSpec The default implementation uses the {@link Float#PRECISION}
+     * high-order bits from a call to {@link RandomGenerator#nextInt() nextInt()}.
      */
     default float nextFloat() {
-        return (nextInt() >>> 8) * 0x1.0p-24f;
+        return (nextInt() >>> (Float.SIZE - Float.PRECISION)) * 0x1.0p-24f;
     }
 
     /**
@@ -562,11 +563,11 @@ default float nextFloat(float origin, float bound) {
      * @return a pseudorandom {@code double} value between zero (inclusive)
      *         and one (exclusive)
      *
-     * @implSpec The default implementation uses the 53 high-order bits from a call to
-     * {@link RandomGenerator#nextLong nextLong}().
+     * @implSpec The default implementation uses the {@link Double#PRECISION}
+     * high-order bits from a call to {@link RandomGenerator#nextLong() nextLong()}.
      */
     default double nextDouble() {
-        return (nextLong() >>> 11) * 0x1.0p-53;
+        return (nextLong() >>> (Double.SIZE - Double.PRECISION)) * 0x1.0p-53;
     }
 
     /**