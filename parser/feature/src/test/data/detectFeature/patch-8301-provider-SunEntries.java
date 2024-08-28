@@ -92,7 +92,7 @@ public final class SunEntries {
         // start populating content using the specified provider
 
         // common attribute map
-        HashMap<String, String> attrs = new HashMap<>(3);
+        HashMap<String, String> attrs = HashMap.newHashMap(3);
 
         /*
          * SecureRandom engines