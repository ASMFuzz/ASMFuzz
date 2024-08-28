@@ -97,8 +97,8 @@ public static long dosToJavaTime(long dtime) {
         if (month > 0 && month < 13 && day > 0 && hour < 24 && minute < 60 && second < 60) {
             try {
                 LocalDateTime ldt = LocalDateTime.of(year, month, day, hour, minute, second);
-                return TimeUnit.MILLISECONDS.convert(ldt.toEpochSecond(
-                        ZoneId.systemDefault().getRules().getOffset(ldt)), TimeUnit.SECONDS);
+                return TimeUnit.SECONDS.toMillis(ldt.toEpochSecond(
+                        ZoneId.systemDefault().getRules().getOffset(ldt)));
             } catch (DateTimeException dte) {
                 // ignore
             }