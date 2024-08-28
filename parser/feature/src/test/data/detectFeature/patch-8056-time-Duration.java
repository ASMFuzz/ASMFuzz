@@ -246,9 +246,9 @@ public static Duration ofSeconds(long seconds) {
      * @throws ArithmeticException if the adjustment causes the seconds to exceed the capacity of {@code Duration}
      */
     public static Duration ofSeconds(long seconds, long nanoAdjustment) {
-        long secs = Math.addExact(seconds, Math.floorDiv(nanoAdjustment, NANOS_PER_SECOND));
-        int nos = (int) Math.floorMod(nanoAdjustment, NANOS_PER_SECOND);
-        return create(secs, nos);
+        long secs = Math.floorDiv(nanoAdjustment, NANOS_PER_SECOND);
+        int nos = (int) (nanoAdjustment - secs * NANOS_PER_SECOND);
+        return create(Math.addExact(seconds, secs), nos);
     }
 
     //-----------------------------------------------------------------------