@@ -142,7 +142,7 @@ public Void run() {
 
     void putEntries() {
         // reuse attribute map and reset before each reuse
-        HashMap<String, String> attrs = new HashMap<>(3);
+        HashMap<String, String> attrs = HashMap.newHashMap(3);
         attrs.put("SupportedModes", "ECB");
         attrs.put("SupportedPaddings", "NOPADDING|PKCS1PADDING|OAEPPADDING"
                 + "|OAEPWITHMD5ANDMGF1PADDING"