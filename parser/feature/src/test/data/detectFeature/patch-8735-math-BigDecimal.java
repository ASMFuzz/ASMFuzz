@@ -416,6 +416,14 @@ public class BigDecimal extends Number implements Comparable<BigDecimal> {
     public static final BigDecimal ONE =
         ZERO_THROUGH_TEN[1];
 
+    /**
+     * The value 2, with a scale of 0.
+     *
+     * @since  19
+     */
+    public static final BigDecimal TWO =
+        ZERO_THROUGH_TEN[2];
+
     /**
      * The value 10, with a scale of 0.
      *