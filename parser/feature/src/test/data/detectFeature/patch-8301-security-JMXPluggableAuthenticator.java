@@ -317,7 +317,7 @@ public FileLoginConfig(String passwordFile, String hashPasswords) {
 
         Map<String, String> options;
         if (passwordFile != null) {
-            options = new HashMap<String, String>(1);
+            options = HashMap.newHashMap(2);
             options.put(PASSWORD_FILE_OPTION, passwordFile);
             options.put(HASH_PASSWORDS, hashPasswords);
         } else {