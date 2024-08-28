@@ -138,7 +138,8 @@
  */
 @jdk.internal.ValueBased
 public final class LocalDate
-        implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable {
+        implements Temporal, TemporalAdjuster, ChronoLocalDate, Serializable,
+                   java.time.chrono.FooDate {
 
     /**
      * The minimum supported {@code LocalDate}, '-999999999-01-01'.