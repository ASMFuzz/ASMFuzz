@@ -29,6 +29,7 @@
 import java.util.Random;
 import jdk.internal.math.FloatConsts;
 import jdk.internal.math.DoubleConsts;
+import jdk.internal.vm.annotation.ForceInline;
 import jdk.internal.vm.annotation.IntrinsicCandidate;
 
 /**
@@ -1346,16 +1347,278 @@ public static long negateExact(long a) {
      * Returns the value of the {@code long} argument,
      * throwing an exception if the value overflows an {@code int}.
      *
-     * @param value the long value
-     * @return the argument as an int
-     * @throws ArithmeticException if the {@code argument} overflows an int
+     * @param value the {@code long} value
+     * @return the argument as an {@code int}
+     * @throws ArithmeticException if the argument overflows an {@code int}
      * @since 1.8
      */
+    @ForceInline
     public static int toIntExact(long value) {
-        if ((int)value != value) {
-            throw new ArithmeticException("integer overflow");
+        int result = (int) value;
+        if ((long) result != value) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code double} argument,
+     * throwing an exception if the conversion is inexact.
+     * The method returns if and only if the argument and the result
+     * are mathematically equal.
+     *
+     * <p>Special cases:
+     * <ul>
+     * <li>If the argument is {@link Double#NEGATIVE_INFINITY},
+     * {@link Double#POSITIVE_INFINITY} or {@link Double#NaN},
+     * the method throws.
+     * <li>If the argument is {@code -0.0} or {@code 0.0},
+     * the method returns {@code 0}.
+     * </ul>
+     *
+     * @param value the {@code double} value
+     * @return the argument as a {@code int}
+     * @throws ArithmeticException if the conversion is inexact
+     * @see Math#rint(double)
+     * @see Math#round(double)
+     * @since 19
+     */
+    @ForceInline
+    public static int toIntExact(double value) {
+        int result = (int) value;
+        if ((double) result != value) {
+            throw newArithmeticExceptionInexact(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows a {@code short}.
+     *
+     * @param value the {@code long} value
+     * @return the argument as a {@code short}
+     * @throws ArithmeticException if the argument overflows a {@code short}
+     * @since 19
+     */
+    @ForceInline
+    public static short toShortExact(long value) {
+        short result = (short) value;
+        if ((long) result != value) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows a {@code byte}.
+     *
+     * @param value the {@code long} value
+     * @return the argument as a {@code byte}
+     * @throws ArithmeticException if the argument overflows a {@code byte}
+     * @since 19
+     */
+    @ForceInline
+    public static byte toByteExact(long value) {
+        byte result = (byte) value;
+        if ((long) result != value) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the conversion is inexact.
+     * The method returns if and only if the argument and the result
+     * are mathematically equal.
+     *
+     * <p>Special case:
+     * <ul>
+     * <li>If the argument is {@code 0L}, the method returns {@code 0.0f}.
+     * </ul>
+     *
+     * @param value the {@code long} value
+     * @return the argument as a {@code float}
+     * @throws ArithmeticException if the conversion is inexact
+     * @since 19
+     */
+    @ForceInline
+    public static float toFloatExact(long value) {
+        /*
+         * The left-hand side of the test below correctly discriminates
+         * inexact conversions, *except* for Long.MAX_VALUE.
+         * Long.MAX_VALUE cannot be converted exactly,
+         * and yet the left-hand side evaluates to false.
+         */
+        float result = (float) value;
+        if ((long) result != value || value == Long.MAX_VALUE) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code double} argument,
+     * throwing an exception if the conversion is inexact.
+     * The method returns if and only if the argument and the result
+     * are mathematically equal.
+     *
+     * <p>Special cases:
+     * <ul>
+     * <li>If the argument is {@link Double#NEGATIVE_INFINITY},
+     * {@link Double#POSITIVE_INFINITY}, {@link Double#NaN},
+     * {@code -0.0} or {@code 0.0},
+     * the method returns {@link Float#NEGATIVE_INFINITY},
+     * {@link Float#POSITIVE_INFINITY}, {@link Float#NaN},
+     * {@code -0.0f} or {@code 0.0f}, respectively.
+     * </ul>
+     *
+     * @param value the {@code double} value
+     * @return the argument as a {@code float}
+     * @throws ArithmeticException if the conversion is inexact
+     * @since 19
+     */
+    @ForceInline
+    public static float toFloatExact(double value) {
+        /*
+         * The left-hand side of the test below correctly discriminates
+         * inexact conversions, *except* for Double.NaN.
+         * Double.NaN can be converted exactly,
+         * and yet the left-hand side evaluates to true.
+         * The right-hand side checks for non Double.NaN.
+         */
+        float result = (float) value;
+        if ((double) result != value && value == value) {
+            throw newArithmeticExceptionInexact(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the conversion is inexact.
+     * The method returns if and only if the argument and the result
+     * are mathematically equal.
+     *
+     * <p>Special case:
+     * <ul>
+     * <li>If the argument is {@code 0L}, the method returns {@code 0.0}.
+     * </ul>
+     *
+     * @param value the {@code long} value
+     * @return the argument as a {@code double}
+     * @throws ArithmeticException if the conversion is inexact
+     * @since 19
+     */
+    @ForceInline
+    public static double toDoubleExact(long value) {
+        /*
+         * The left-hand side of the test below correctly discriminates
+         * inexact conversions, *except* for Long.MAX_VALUE.
+         * Long.MAX_VALUE cannot be converted exactly,
+         * and yet the left-hand side evaluates to false.
+         */
+        double result = (double) value;
+        if ((long) result != value || value == Long.MAX_VALUE) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code double} argument,
+     * throwing an exception if the conversion is inexact.
+     * The method returns if and only if the argument and the result
+     * are mathematically equal.
+     *
+     * <p>Special cases:
+     * <ul>
+     * <li>If the argument is {@link Double#NEGATIVE_INFINITY},
+     * {@link Double#POSITIVE_INFINITY} or {@link Double#NaN},
+     * the method throws.
+     * <li>If the argument is {@code -0.0} or {@code 0.0},
+     * the method returns {@code 0L}.
+     * </ul>
+     *
+     * @param value the {@code double} value
+     * @return the argument as a {@code long}
+     * @throws ArithmeticException if the conversion is inexact
+     * @see Math#rint(double)
+     * @see Math#round(double)
+     * @since 19
+     */
+    @ForceInline
+    public static long toLongExact(double value) {
+        /*
+         * The left-hand side of the test below correctly discriminates
+         * inexact conversions, *except* for 0x1p63.
+         * 0x1p63 cannot be converted exactly,
+         * and yet the left-hand side evaluates to false.
+         */
+        long result = (long) value;
+        if ((double) result != value || value == 0x1p63) {
+            throw newArithmeticExceptionInexact(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows the range
+     * [0, 2<sup>{@link Integer#SIZE}</sup>) of an unsigned int.
+     *
+     * @param value the {@code long} value
+     * @return the argument as an unsigned int
+     * @throws ArithmeticException if the argument overflows an unsigned int
+     * @since 19
+     */
+    @ForceInline
+    public static long toUnsignedIntRangeExact(long value) {
+        long result = value & 0xFFFF_FFFFL;
+        if (result != value) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows the range
+     * [0, 2<sup>{@link Short#SIZE}</sup>) of an unsigned short.
+     *
+     * @param value the {@code long} value
+     * @return the argument as an unsigned short
+     * @throws ArithmeticException if the argument overflows an unsigned short
+     * @since 19
+     */
+    @ForceInline
+    public static int toUnsignedShortRangeExact(long value) {
+        int result = (int) value & 0xFFFF;
+        if ((long) result != value) {
+            throw newArithmeticExceptionOverflow(value);
         }
-        return (int)value;
+        return result;
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows the range
+     * [0, 2<sup>{@link Byte#SIZE}</sup>) of an unsigned byte.
+     *
+     * @param value the {@code long} value
+     * @return the argument as an unsigned byte
+     * @throws ArithmeticException if the argument overflows an unsigned byte
+     * @since 19
+     */
+    @ForceInline
+    public static int toUnsignedByteRangeExact(long value) {
+        int result = (int) value & 0xFF;
+        if ((long) result != value) {
+            throw newArithmeticExceptionOverflow(value);
+        }
+        return result;
     }
 
     /**
@@ -3249,4 +3512,13 @@ static float powerOfTwoF(int n) {
                                      (FloatConsts.SIGNIFICAND_WIDTH-1))
                                     & FloatConsts.EXP_BIT_MASK);
     }
+
+    private static ArithmeticException newArithmeticExceptionOverflow(long value) {
+        return new ArithmeticException("integer overflow on " + value);
+    }
+
+    private static ArithmeticException newArithmeticExceptionInexact(double value) {
+        return new ArithmeticException("inexact conversion on " + value);
+    }
+
 }