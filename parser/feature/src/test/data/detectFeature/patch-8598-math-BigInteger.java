@@ -1605,6 +1605,7 @@ public BigInteger multiply(BigInteger val) {
      * @param  val value to be multiplied by this BigInteger.
      * @return {@code this * val}
      * @see #multiply
+     * @since 19
      */
     public BigInteger parallelMultiply(BigInteger val) {
         return multiply(val, false, true, 0);