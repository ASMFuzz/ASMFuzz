@@ -89,7 +89,12 @@ public static void main(String ... args) throws Throwable {
         String CSCSC  = "string" + s + "string" + s + "string";
         String SCSCS  = s + "string" + s + "string" + s;
         String SSCSS  = s + s + "string" + s + s;
-        String SSSSS  = s + s + s + s + s;
+        String S5     = s + s + s + s + s;
+        String S6     = s + s + s + s + s + s;
+        String S7     = s + s + s + s + s + s + s;
+        String S8     = s + s + s + s + s + s + s + s;
+        String S9     = s + s + s + s + s + s + s + s + s;
+        String S10    = s + s + s + s + s + s + s + s + s + s;
 
         String CI     = "string" + i;
         String IC     = i + "string";
@@ -100,6 +105,16 @@ public static void main(String ... args) throws Throwable {
         String CIC    = "string" + i + "string";
         String CICI   = "string" + i + "string" + i;
 
+        float f = 0.1f;
+        String CF     = "string" + f;
+        String CFS    = "string" + f + s;
+        String CSCF   = "string" + s + "string" + f;
+
+        char c = 'a';
+        String CC     = "string" + c;
+        String CCS    = "string" + c + s;
+        String CSCC   = "string" + s + "string" + c;
+
         long l = System.currentTimeMillis();
         String CJ     = "string" + l;
         String JC     = l + "string";
@@ -108,6 +123,8 @@ public static void main(String ... args) throws Throwable {
         String CJCJC  = "string" + l + "string" + l + "string";
         double d = i / 2.0;
         String CD     = "string" + d;
+        String CDS    = "string" + d + s;
+        String CSCD   = "string" + s + "string" + d;
 
         String newDate = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(
                 LocalDateTime.now(ZoneId.of("GMT")));