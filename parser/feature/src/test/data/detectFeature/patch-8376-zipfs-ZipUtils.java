@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2009, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2009, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -214,8 +214,8 @@ public static long dosToJavaTime(long dtime) {
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
@@ -253,22 +253,22 @@ public static long javaToDosTime(long time) {
 
     // used to adjust values between Windows and java epoch
     private static final long WINDOWS_EPOCH_IN_MICROSECONDS = -11644473600000000L;
-    public static final long winToJavaTime(long wtime) {
-        return TimeUnit.MILLISECONDS.convert(
-               wtime / 10 + WINDOWS_EPOCH_IN_MICROSECONDS, TimeUnit.MICROSECONDS);
+    public static long winToJavaTime(long wtime) {
+        return TimeUnit.MICROSECONDS.toMillis(
+               wtime / 10 + WINDOWS_EPOCH_IN_MICROSECONDS);
     }
 
-    public static final long javaToWinTime(long time) {
-        return (TimeUnit.MICROSECONDS.convert(time, TimeUnit.MILLISECONDS)
+    public static long javaToWinTime(long time) {
+        return (TimeUnit.MILLISECONDS.toMicros(time)
                - WINDOWS_EPOCH_IN_MICROSECONDS) * 10;
     }
 
-    public static final long unixToJavaTime(long utime) {
-        return TimeUnit.MILLISECONDS.convert(utime, TimeUnit.SECONDS);
+    public static long unixToJavaTime(long utime) {
+        return TimeUnit.SECONDS.toMillis(utime);
     }
 
-    public static final long javaToUnixTime(long time) {
-        return TimeUnit.SECONDS.convert(time, TimeUnit.MILLISECONDS);
+    public static long javaToUnixTime(long time) {
+        return TimeUnit.MILLISECONDS.toSeconds(time);
     }
 
     private static final String regexMetaChars = ".^$+{[]|()";