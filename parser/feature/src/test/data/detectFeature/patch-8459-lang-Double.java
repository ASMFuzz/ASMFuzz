@@ -683,6 +683,7 @@ public static boolean isNaN(double v) {
      * @return  {@code true} if the value of the argument is positive
      *          infinity or negative infinity; {@code false} otherwise.
      */
+    @IntrinsicCandidate
     public static boolean isInfinite(double v) {
         return (v == POSITIVE_INFINITY) || (v == NEGATIVE_INFINITY);
     }