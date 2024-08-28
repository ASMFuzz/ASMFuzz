@@ -55,7 +55,7 @@ public SunRsaSignEntries(Provider p) {
 
         // start populating content using the specified provider
         // common attribute map
-        HashMap<String, String> attrs = new HashMap<>(3);
+        HashMap<String, String> attrs = HashMap.newHashMap(1);
         attrs.put("SupportedKeyClasses",
                 "java.security.interfaces.RSAPublicKey" +
                 "|java.security.interfaces.RSAPrivateKey");