@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1997, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,10 +25,11 @@
  * @test
  * @bug 4028006 4044013 4096694 4107276 4107570 4112869 4130885 7039469 7126465 7158483
  *      8008577 8077685 8098547 8133321 8138716 8148446 8151876 8159684 8166875 8181157
- *      8228469 8274407
+ *      8228469 8274407 8285844
  * @modules java.base/sun.util.resources
  * @library /java/text/testlib
  * @summary test TimeZone
+ * @run main TimeZoneTest -verbose
  */
 
 import java.io.*;
@@ -220,12 +221,14 @@ public static int compare(Object o1, Object o2) {
         }
     }
 
-    static final String formatMinutes(int min) {
+    static final String formatSeconds(int sec) {
         char sign = '+';
-        if (min < 0) { sign = '-'; min = -min; }
-        int h = min/60;
-        min = min%60;
-        return "" + sign + h + ":" + ((min<10) ? "0" : "") + min;
+        if (sec < 0) { sign = '-'; sec = -sec; }
+        int h = sec / 3_600;
+        int m = sec % 3_600 / 60;
+        sec = sec % 60;
+        return "" + sign + h + ":" + ((m<10) ? "0" : "") + m +
+                (sec > 0 ? ":" + ((sec < 10) ? "0" : "") + sec : "");
     }
     /**
      * As part of the VM fix (see CCC approved RFE 4028006, bug
@@ -240,21 +243,28 @@ static final String formatMinutes(int min) {
      */
     public void TestCustomParse() throws Exception {
         Object[] DATA = {
-            // ID        Expected offset in minutes
-            "GMT",       null,
-            "GMT+0",     new Integer(0),
-            "GMT+1",     new Integer(60),
-            "GMT-0030",  new Integer(-30),
-            "GMT+15:99", null,
-            "GMT+",      null,
-            "GMT-",      null,
-            "GMT+0:",    null,
-            "GMT-:",     null,
-            "GMT+0010",  new Integer(10), // Interpret this as 00:10
-            "GMT-10",    new Integer(-10*60),
-            "GMT+30",    null,
-            "GMT-3:30",  new Integer(-(3*60+30)),
-            "GMT-230",   new Integer(-(2*60+30)),
+            // ID               Expected offset in seconds
+            "GMT",              null,
+            "GMT+0",            0,
+            "GMT+1",            60 * 60,
+            "GMT-0030",         -30 * 60,
+            "GMT+15:99",        null,
+            "GMT+",             null,
+            "GMT-",             null,
+            "GMT+0:",           null,
+            "GMT-:",            null,
+            "GMT+0010",         10 * 60, // Interpret this as 00:10
+            "GMT-10",           -10 * 60 * 60,
+            "GMT+30",           null,
+            "GMT-3:30",         -(3 * 60 + 30) * 60,
+            "GMT-230",          -(2 * 60 + 30) * 60,
+            "GMT+00:00:01",     1,
+            "GMT-00:00:01",     -1,
+            "GMT+00000",        null,
+            "GMT+00:00:01:",    null,
+            "GMT+00:00:012",    null,
+            "GMT+00:00:0",      null,
+            "GMT+00:00:",       null,
         };
         for (int i=0; i<DATA.length; i+=2) {
             String id = (String)DATA[i];
@@ -266,21 +276,21 @@ public void TestCustomParse() throws Exception {
                 // returns GMT -- a dubious practice, but required for
                 // backward compatibility.
                 if (exp != null) {
-                    throw new Exception("Expected offset of " + formatMinutes(exp.intValue()) +
+                    throw new Exception("Expected offset of " + formatSeconds(exp.intValue()) +
                                         " for " + id + ", got parse failure");
                 }
             }
             else {
-                int ioffset = zone.getRawOffset()/60000;
-                String offset = formatMinutes(ioffset);
+                int ioffset = zone.getRawOffset() / 1_000;
+                String offset = formatSeconds(ioffset);
                 logln(id + " -> " + zone.getID() + " GMT" + offset);
                 if (exp == null) {
                     throw new Exception("Expected parse failure for " + id +
                                         ", got offset of " + offset +
                                         ", id " + zone.getID());
                 }
                 else if (ioffset != exp.intValue()) {
-                    throw new Exception("Expected offset of " + formatMinutes(exp.intValue()) +
+                    throw new Exception("Expected offset of " + formatSeconds(exp.intValue()) +
                                         ", id Custom, for " + id +
                                         ", got offset of " + offset +
                                         ", id " + zone.getID());