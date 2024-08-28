@@ -878,7 +878,11 @@ public Instant plus(long amountToAdd, TemporalUnit unit) {
      * @throws ArithmeticException if numeric overflow occurs
      */
     public Instant plusSeconds(long secondsToAdd) {
-        return plus(secondsToAdd, 0);
+        if (secondsToAdd == 0) {
+            return this;
+        }
+        long epochSec = Math.addExact(seconds, secondsToAdd);
+        return create(epochSec, nanos);
     }
 
     /**