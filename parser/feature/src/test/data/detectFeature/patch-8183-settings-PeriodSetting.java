@@ -114,10 +114,10 @@ public void setValue(String value) {
             break;
         default:
             long nanos = Utils.parseTimespanWithInfinity(value);
-            if (nanos != Long.MAX_VALUE) {
-                eventType.setPeriod(nanos / 1_000_000, false, false);
+            if (nanos == 0 || nanos == Long.MAX_VALUE) {
+                eventType.setPeriod(nanos, false, false);
             } else {
-                eventType.setPeriod(Long.MAX_VALUE, false, false);
+                eventType.setPeriod(Math.max(1, nanos / 1_000_000), false, false);
             }
         }
         this.value = value;