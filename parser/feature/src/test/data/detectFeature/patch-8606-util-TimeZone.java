@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -40,6 +40,7 @@
 
 import java.io.Serializable;
 import java.time.ZoneId;
+import java.time.ZoneOffset;
 
 import jdk.internal.util.StaticProperty;
 import sun.security.action.GetPropertyAction;
@@ -74,6 +75,7 @@
  *
  * <blockquote><pre>
  * <a id="CustomID"><i>CustomID:</i></a>
+ *         {@code GMT} <i>Sign</i> <i>Hours</i> {@code :} <i>Minutes</i> {@code :} <i>Seconds</i>
  *         {@code GMT} <i>Sign</i> <i>Hours</i> {@code :} <i>Minutes</i>
  *         {@code GMT} <i>Sign</i> <i>Hours</i> <i>Minutes</i>
  *         {@code GMT} <i>Sign</i> <i>Hours</i>
@@ -84,11 +86,13 @@
  *         <i>Digit</i> <i>Digit</i>
  * <i>Minutes:</i>
  *         <i>Digit</i> <i>Digit</i>
+ * <i>Seconds:</i>
+ *         <i>Digit</i> <i>Digit</i>
  * <i>Digit:</i> one of
  *         {@code 0 1 2 3 4 5 6 7 8 9}
  * </pre></blockquote>
  *
- * <i>Hours</i> must be between 0 to 23 and <i>Minutes</i> must be
+ * <i>Hours</i> must be between 0 to 23 and <i>Minutes</i>/<i>Seconds</i> must be
  * between 00 to 59.  For example, "GMT+10" and "GMT+0010" mean ten
  * hours and ten minutes ahead of GMT, respectively.
  * <p>
@@ -102,17 +106,20 @@
  * zone ID is normalized in the following syntax:
  * <blockquote><pre>
  * <a id="NormalizedCustomID"><i>NormalizedCustomID:</i></a>
- *         {@code GMT} <i>Sign</i> <i>TwoDigitHours</i> {@code :} <i>Minutes</i>
+ *         {@code GMT} <i>Sign</i> <i>TwoDigitHours</i> {@code :} <i>Minutes</i> [<i>ColonSeconds</i>]
  * <i>Sign:</i> one of
  *         {@code + -}
  * <i>TwoDigitHours:</i>
  *         <i>Digit</i> <i>Digit</i>
  * <i>Minutes:</i>
  *         <i>Digit</i> <i>Digit</i>
+ * <i>ColonSeconds:</i>
+ *         {@code :} <i>Digit</i> <i>Digit</i>
  * <i>Digit:</i> one of
  *         {@code 0 1 2 3 4 5 6 7 8 9}
  * </pre></blockquote>
  * For example, TimeZone.getTimeZone("GMT-8").getID() returns "GMT-08:00".
+ * <i>ColonSeconds</i> part only appears if the seconds value is non-zero.
  *
  * <h2>Three-letter time zone IDs</h2>
  *
@@ -529,11 +536,11 @@ public static synchronized TimeZone getTimeZone(String ID) {
      */
     public static TimeZone getTimeZone(ZoneId zoneId) {
         String tzid = zoneId.getId(); // throws an NPE if null
-        char c = tzid.charAt(0);
-        if (c == '+' || c == '-') {
-            tzid = "GMT" + tzid;
-        } else if (c == 'Z' && tzid.length() == 1) {
-            tzid = "UTC";
+        if (zoneId instanceof ZoneOffset zo) {
+            var totalMillis = zo.getTotalSeconds() * 1_000;
+            return new ZoneInfo(totalMillis == 0 ? "UTC" : GMT_ID + tzid, totalMillis);
+        } else if (tzid.startsWith("UT") && !tzid.equals("UTC")) {
+            tzid = tzid.replaceFirst("(UTC|UT)(.*)", "GMT$2");
         }
         return getTimeZone(tzid, true);
     }
@@ -823,19 +830,24 @@ private static final TimeZone parseCustomTimeZone(String id) {
         }
 
         int hours = 0;
+        int minutes = 0;
         int num = 0;
         int countDelim = 0;
         int len = 0;
         while (index < length) {
             c = id.charAt(index++);
             if (c == ':') {
-                if (countDelim > 0) {
+                if (countDelim > 1) {
                     return null;
                 }
-                if (len > 2) {
+                if (len == 0 || len > 2) {
                     return null;
                 }
-                hours = num;
+                if (countDelim == 0) {
+                    hours = num;
+                } else if (countDelim == 1){
+                    minutes = num;
+                }
                 countDelim++;
                 num = 0;
                 len = 0;
@@ -853,20 +865,31 @@ private static final TimeZone parseCustomTimeZone(String id) {
         if (countDelim == 0) {
             if (len <= 2) {
                 hours = num;
+                minutes = 0;
                 num = 0;
-            } else {
+            } else if (len <= 4) {
                 hours = num / 100;
-                num %= 100;
+                minutes = num % 100;
+                num = 0;
+            } else {
+                return null;
+            }
+        } else if (countDelim == 1){
+            if (len == 2) {
+                minutes = num;
+                num = 0;
+            } else {
+                return null;
             }
         } else {
             if (len != 2) {
                 return null;
             }
         }
-        if (hours > 23 || num > 59) {
+        if (hours > 23 || minutes > 59 || num > 59) {
             return null;
         }
-        int gmtOffset =  (hours * 60 + num) * 60 * 1000;
+        int gmtOffset =  (hours * 3_600 + minutes * 60 + num) * 1_000;
 
         if (gmtOffset == 0) {
             zi = ZoneInfoFile.getZoneInfo(GMT_ID);