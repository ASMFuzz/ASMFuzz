@@ -508,6 +508,7 @@ public static boolean isNaN(float v) {
      * @return  {@code true} if the argument is positive infinity or
      *          negative infinity; {@code false} otherwise.
      */
+    @IntrinsicCandidate
     public static boolean isInfinite(float v) {
         return (v == POSITIVE_INFINITY) || (v == NEGATIVE_INFINITY);
     }