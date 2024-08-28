@@ -1121,19 +1121,214 @@ public static long negateExact(long a) {
     }
 
     /**
-     * Returns the value of the {@code long} argument, throwing an exception
-     * if the value overflows an {@code int}.
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows an {@code int}.
      *
-     * @param value the long value
-     * @return the argument as an int
-     * @throws ArithmeticException if the {@code argument} overflows an int
+     * @param value the {@code long} value
+     * @return the argument as an {@code int}
+     * @throws ArithmeticException if the argument overflows an {@code int}
      * @see Math#toIntExact(long)
      * @since 1.8
      */
     public static int toIntExact(long value) {
         return Math.toIntExact(value);
     }
 
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
+     * @see Math#toIntExact(double)
+     * @since 19
+     */
+    public static int toIntExact(double value) {
+        return Math.toIntExact(value);
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows a {@code short}.
+     *
+     * @param value the {@code long} value
+     * @return the argument as a {@code short}
+     * @throws ArithmeticException if the argument overflows a {@code short}
+     * @see Math#toShortExact(long)
+     * @since 19
+     */
+    public static short toShortExact(long value) {
+        return Math.toShortExact(value);
+    }
+
+    /**
+     * Returns the value of the {@code long} argument,
+     * throwing an exception if the value overflows a {@code byte}.
+     *
+     * @param value the {@code long} value
+     * @return the argument as a {@code byte}
+     * @throws ArithmeticException if the argument overflows a {@code byte}
+     * @see Math#toByteExact(long)
+     * @since 19
+     */
+    public static byte toByteExact(long value) {
+        return Math.toByteExact(value);
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
+     * @see Math#toFloatExact(long)
+     * @since 19
+     */
+    public static float toFloatExact(long value) {
+        return Math.toFloatExact(value);
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
+     * @see Math#toFloatExact(double)
+     * @since 19
+     */
+    public static float toFloatExact(double value) {
+        return Math.toFloatExact(value);
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
+     * @see Math#toDoubleExact(long)
+     * @since 19
+     */
+    public static double toDoubleExact(long value) {
+        return Math.toDoubleExact(value);
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
+     * @see Math#toLongExact(double)
+     * @since 19
+     */
+    public static long toLongExact(double value) {
+        return Math.toLongExact(value);
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
+     * @see Math#toUnsignedIntRangeExact(long)
+     * @since 19
+     */
+    public static long toUnsignedIntRangeExact(long value) {
+        return Math.toUnsignedIntRangeExact(value);
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
+     * @see Math#toUnsignedShortRangeExact(long)
+     * @since 19
+     */
+    public static int toUnsignedShortRangeExact(long value) {
+        return Math.toUnsignedShortRangeExact(value);
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
+     * @see Math#toUnsignedByteRangeExact(long)
+     * @since 19
+     */
+    public static int toUnsignedByteRangeExact(long value) {
+        return Math.toUnsignedByteRangeExact(value);
+    }
+
     /**
      * Returns the exact mathematical product of the arguments.
      *