@@ -539,13 +539,15 @@ default float nextFloat(float bound) {
      *
      * @throws IllegalArgumentException if {@code origin} is not finite,
      *         or {@code bound} is not finite, or {@code origin}
-     *         is greater than or equal to {@code bound}
-     *
-     * @implSpec The default implementation checks that {@code origin} and
-     * {@code bound} are positive finite floats. Then invokes
-     * {@code nextFloat()}, scaling and translating the result so that the final
-     * result lies between {@code origin} (inclusive) and {@code bound}
-     * (exclusive).
+     *         is greater than or equal to {@code bound}, or
+     *         the difference between {@code bound} and {@code origin}
+     *         is so large that it cannot be represented as a finite
+     *         {@code float} value
+     *
+     * @implSpec The default implementation verifies that the {@code origin}
+     *           and {@code bound} are valid then invokes {@code nextFloat()}
+     *           scaling and translating the result to fit between {@code origin}
+     *           and {@code bound} (exclusive).
      */
     default float nextFloat(float origin, float bound) {
         RandomSupport.checkRange(origin, bound);
@@ -603,13 +605,15 @@ default double nextDouble(double bound) {
      *
      * @throws IllegalArgumentException if {@code origin} is not finite,
      *         or {@code bound} is not finite, or {@code origin}
-     *         is greater than or equal to {@code bound}
-     *
-     * @implSpec The default implementation checks that {@code origin} and
-     * {@code bound} are positive finite doubles. Then calls
-     * {@code nextDouble()}, scaling and translating the result so that the final
-     * result lies between {@code origin} (inclusive) and {@code bound}
-     * (exclusive).
+     *         is greater than or equal to {@code bound}, or
+     *         the difference between {@code bound} and {@code origin}
+     *         is so large that it cannot be represented as a finite
+     *         {@code double} value
+     *
+     * @implSpec The default implementation verifies that the {@code origin}
+     *           and {@code bound} are valid, then invokes {@code nextDouble()}
+     *           scaling and translating the result to fit between {@code origin}
+     *           and {@code bound}( exclusive).
      */
     default double nextDouble(double origin, double bound) {
         RandomSupport.checkRange(origin, bound);