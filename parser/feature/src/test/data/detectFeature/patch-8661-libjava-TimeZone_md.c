@@ -592,18 +592,31 @@ getGMTOffsetID()
 {
     time_t offset;
     char sign, buf[32];
-    offset = timezone;
+    struct tm localtm;
+    time_t clock;
+
+    clock = time(NULL);
+    if (localtime_r(&clock, &localtm) == NULL) {
+        return strdup("GMT");
+    }
+
+    struct tm gmt;
+
+    if (gmtime_r(&clock, &gmt) == NULL) {
+        return strdup("GMT");
+    }
+
+    offset = (localtm.tm_hour - gmt.tm_hour)*3600 + (localtm.tm_min - gmt.tm_min)*60;
 
     if (offset == 0) {
         return strdup("GMT");
     }
 
-    /* Note that the time offset direction is opposite. */
     if (offset > 0) {
-        sign = '-';
+        sign = '+';
     } else {
         offset = -offset;
-        sign = '+';
+        sign = '-';
     }
     sprintf(buf, (const char *)"GMT%c%02d:%02d",
             sign, (int)(offset/3600), (int)((offset%3600)/60));