@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2012, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -178,15 +178,16 @@ public static ZoneInfo getCustomTimeZone(String originalId, int gmtOffset) {
 
     public static String toCustomID(int gmtOffset) {
         char sign;
-        int offset = gmtOffset / 60000;
+        int offset = gmtOffset / 1_000;
         if (offset >= 0) {
             sign = '+';
         } else {
             sign = '-';
             offset = -offset;
         }
-        int hh = offset / 60;
-        int mm = offset % 60;
+        int hh = offset / 3_600;
+        int mm = (offset % 3_600) / 60;
+        int ss = offset % 60;
 
         char[] buf = new char[] { 'G', 'M', 'T', sign, '0', '0', ':', '0', '0' };
         if (hh >= 10) {
@@ -197,7 +198,13 @@ public static String toCustomID(int gmtOffset) {
             buf[7] += mm / 10;
             buf[8] += mm % 10;
         }
-        return new String(buf);
+        var id = new String(buf);
+        if (ss != 0) {
+            buf[7] = (char)('0' + ss / 10);
+            buf[8] = (char)('0' + ss % 10);
+            id += new String(buf, 6, 3);
+        }
+        return id;
     }
 
     ///////////////////////////////////////////////////////////