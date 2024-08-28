@@ -25,9 +25,11 @@
 
 package jdk.jfr.internal;
 
+import static java.util.concurrent.TimeUnit.DAYS;
+import static java.util.concurrent.TimeUnit.HOURS;
 import static java.util.concurrent.TimeUnit.MICROSECONDS;
 import static java.util.concurrent.TimeUnit.MILLISECONDS;
-import static java.util.concurrent.TimeUnit.NANOSECONDS;
+import static java.util.concurrent.TimeUnit.MINUTES;
 import static java.util.concurrent.TimeUnit.SECONDS;
 
 import java.io.FileOutputStream;
@@ -311,22 +313,22 @@ public static long parseTimespan(String s) {
             return Long.parseLong(s.substring(0, s.length() - 2).trim());
         }
         if (s.endsWith("us")) {
-            return NANOSECONDS.convert(Long.parseLong(s.substring(0, s.length() - 2).trim()), MICROSECONDS);
+            return MICROSECONDS.toNanos(Long.parseLong(s.substring(0, s.length() - 2).trim()));
         }
         if (s.endsWith("ms")) {
-            return NANOSECONDS.convert(Long.parseLong(s.substring(0, s.length() - 2).trim()), MILLISECONDS);
+            return MILLISECONDS.toNanos(Long.parseLong(s.substring(0, s.length() - 2).trim()));
         }
         if (s.endsWith("s")) {
-            return NANOSECONDS.convert(Long.parseLong(s.substring(0, s.length() - 1).trim()), SECONDS);
+            return SECONDS.toNanos(Long.parseLong(s.substring(0, s.length() - 1).trim()));
         }
         if (s.endsWith("m")) {
-            return 60 * NANOSECONDS.convert(Long.parseLong(s.substring(0, s.length() - 1).trim()), SECONDS);
+            return MINUTES.toNanos(Long.parseLong(s.substring(0, s.length() - 1).trim()));
         }
         if (s.endsWith("h")) {
-            return 60 * 60 * NANOSECONDS.convert(Long.parseLong(s.substring(0, s.length() - 1).trim()), SECONDS);
+            return HOURS.toNanos(Long.parseLong(s.substring(0, s.length() - 1).trim()));
         }
         if (s.endsWith("d")) {
-            return 24 * 60 * 60 * NANOSECONDS.convert(Long.parseLong(s.substring(0, s.length() - 1).trim()), SECONDS);
+            return DAYS.toNanos(Long.parseLong(s.substring(0, s.length() - 1).trim()));
         }
 
         try {