@@ -1137,10 +1137,33 @@ public void forEachRemaining(DoubleConsumer consumer) {
         }
     }
 
+    /**
+     * Largest value that {@link #computeNextExponential} can ever return.
+     */
+    private static final double MAX_EXPONENTIAL = 0x1.0p63 * DoubleZigguratTables.exponentialX0;
+
     /**
      * Implementation support for the {@code nextExponential} method of
      * {@link java.util.random.RandomGenerator}.
      *
+     * @param rng an instance of {@code RandomGenerator}, used to generate uniformly
+     *            pseudorandomly chosen {@code long} values
+     *
+     * @return a nonnegative {@code double} value chosen pseudorandomly
+     *         from an exponential distribution whose mean is 1
+     */
+    public static double computeNextExponential(RandomGenerator rng) {
+        return computeNextExponentialSoftCapped(rng, MAX_EXPONENTIAL);
+    }
+
+    /**
+     * Generates a pseudorandom value {@code x} such that {@code Math.min(x, maxValue)}
+     * follows the same distribution as it would if {@code x} was exponentially distributed
+     * with mean 1, but with a worst-case number of calls to {@link
+     * RandomGenerator#nextLong()} that's linear with {@code maxValue}. {@code maxValue} is
+     * a "soft" cap in that a value larger than {@code maxValue} may be returned in order
+     * to save a calculation.
+     *
      * Certain details of the algorithm used in this method may depend critically
      * on the quality of the low-order bits delivered by {@code nextLong()}.  This method
      * should not be used with RNG algorithms (such as a simple Linear Congruential
@@ -1157,7 +1180,7 @@ public void forEachRemaining(DoubleConsumer consumer) {
      * @return a nonnegative {@code double} value chosen pseudorandomly
      *         from an exponential distribution whose mean is 1
      */
-    public static double computeNextExponential(RandomGenerator rng) {
+    public static double computeNextExponentialSoftCapped(RandomGenerator rng, double maxValue) {
         /*
          * The tables themselves, as well as a number of associated parameters, are
          * defined in class DoubleZigguratTables, which is automatically
@@ -1186,9 +1209,18 @@ public static double computeNextExponential(RandomGenerator rng) {
             // This is the fast path (occurring more than 98% of the time).  Make an early exit.
             return DoubleZigguratTables.exponentialX[(int)i] * (U1 >>> 1);
         }
-        // We didn't use the upper part of U1 after all.  We'll be able to use it later.
-
-        for (double extra = 0.0; ; ) {
+        // We didn't use the upper part of U1 after all.  We'll probably be able to use it later.
+        if (maxValue <= 0.0) {
+            return 0.0;
+        }
+        final long maxExtraMinus1;
+        if (maxValue >= MAX_EXPONENTIAL) {
+            maxExtraMinus1 = Long.MAX_VALUE;
+        } else {
+            // Conversion to long rounds toward zero
+            maxExtraMinus1 = (long) (maxValue / DoubleZigguratTables.exponentialX0);
+        }
+        for (long extra = 0; ; ) {
             // Use Walker's alias method to sample an (unsigned) integer j from a discrete
             // probability distribution that includes the tail and all the ziggurat overhangs;
             // j will be less than DoubleZigguratTables.exponentialNumberOfLayers + 1.
@@ -1219,25 +1251,29 @@ public static double computeNextExponential(RandomGenerator rng) {
                     // Compute the actual x-coordinate of the randomly chosen point.
                     double x = (X[j] * 0x1.0p63) + ((X[j-1] - X[j]) * (double)U1);
                     if (Udiff >= DoubleZigguratTables.exponentialConvexMargin) {
-                        return x + extra;   // The chosen point is way below the curve; accept it.
+                        return Math.fma(extra, DoubleZigguratTables.exponentialX0, x);   // The chosen point is way below the curve; accept it.
                     }
                     // Compute the actual y-coordinate of the randomly chosen point.
                     double y = (Y[j] * 0x1.0p63) + ((Y[j-1] - Y[j]) * (double)U2);
                     // Now see how that y-coordinate compares to the curve
                     if (y <= Math.exp(-x)) {
-                        return x + extra;   // The chosen point is below the curve; accept it.
+                        return Math.fma(extra, DoubleZigguratTables.exponentialX0, x);   // The chosen point is below the curve; accept it.
                     }
                     // Otherwise, we reject this sample and have to try again.
                 }
             }
+            if (extra == maxExtraMinus1) {
+                // We've reached the maximum, so don't waste any more time
+                return maxValue;
+            }
             // We are now committed to sampling from the tail.  We could do a recursive call
             // and then add X[0], but we save some time and stack space by using an iterative loop.
-            extra += DoubleZigguratTables.exponentialX0;
-            // This is like the first five lines of this method, but if it returns, it first adds "extra".
+            extra++;
+            // This is like the first five lines of this method, but if it returns, it first adds "extra" times X0.
             U1 = rng.nextLong();
             i = U1 & DoubleZigguratTables.exponentialLayerMask;
             if (i < DoubleZigguratTables.exponentialNumberOfLayers) {
-                return DoubleZigguratTables.exponentialX[(int)i] * (U1 >>> 1) + extra;
+                return Math.fma(extra, DoubleZigguratTables.exponentialX0, DoubleZigguratTables.exponentialX[(int)i] * (U1 >>> 1));
             }
         }
     }
@@ -1359,9 +1395,11 @@ public static double computeNextGaussian(RandomGenerator rng) {
             //    ACM Comput. Surv. 39, 4, Article 11 (November 2007).  See Algorithm 16.
             //    http://doi.org/10.1145/1287620.1287622
             // Compute two separate random exponential samples and then compare them in certain way.
+            double limit;
             do {
                 x = (1.0 / DoubleZigguratTables.normalX0) * computeNextExponential(rng);
-            } while (computeNextExponential(rng) < 0.5*x*x);
+                limit = 0.5*x*x;
+            } while (computeNextExponentialSoftCapped(rng, limit) < limit);
             x += DoubleZigguratTables.normalX0;
         } else if (j < DoubleZigguratTables.normalInflectionIndex) {   // Convex overhang
             for (;; U1 = (rng.nextLong() >>> 1)) {
@@ -1392,7 +1430,7 @@ public static double computeNextGaussian(RandomGenerator rng) {
             for (;; U1 = (rng.nextLong() >>> 1)) {
                 long U2 = (rng.nextLong() >>> 1);
                 // Compute the actual x-coordinate of the randomly chosen point.
-                x = (X[j] * 0x1.0p63) + ((X[j-1] - X[j]) * (double)U1);
+                x = Math.fma(X[j-1] - X[j], (double)U1, X[j] * 0x1.0p63);
                 // Does the point lie below the curve?
                 long Udiff = U2 - U1;
                 if (Udiff >= DoubleZigguratTables.normalConvexMargin) {
@@ -1402,7 +1440,7 @@ public static double computeNextGaussian(RandomGenerator rng) {
                     continue;   // The chosen point is way above the curve; reject it.
                 }
                 // Compute the actual y-coordinate of the randomly chosen point.
-                double y = (Y[j] * 0x1.0p63) + ((Y[j-1] - Y[j]) * (double)U2);
+                double y = Math.fma(Y[j-1] - Y[j], (double)U2, Y[j] * 0x1.0p63);
                 // Now see how that y-coordinate compares to the curve
                 if (y <= Math.exp(-0.5*x*x)) {
                     break;   // The chosen point is below the curve; accept it.