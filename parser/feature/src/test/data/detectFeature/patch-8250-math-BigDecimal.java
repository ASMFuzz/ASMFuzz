@@ -2157,7 +2157,7 @@ public BigDecimal sqrt(MathContext mc) {
             //
             // unscaledValue * 10^(-scale)
             //
-            // where unscaledValue is an integer with the mimimum
+            // where unscaledValue is an integer with the minimum
             // precision for the cohort of the numerical value. To
             // allow binary floating-point hardware to be used to get
             // approximately a 15 digit approximation to the square
@@ -4311,7 +4311,7 @@ private void writeObject(java.io.ObjectOutputStream s)
      * digits.
      *
      * @param x the {@code long}
-     * @return the length of the unscaled value, in deciaml digits.
+     * @return the length of the unscaled value, in decimal digits.
      */
     static int longDigitLength(long x) {
         /*
@@ -4944,7 +4944,7 @@ private static BigDecimal stripZerosToMatchScale(BigInteger intVal, long intComp
     }
 
     /*
-     * returns INFLATED if oveflow
+     * returns INFLATED if overflow
      */
     private static long add(long xs, long ys){
         long sum = xs + ys;