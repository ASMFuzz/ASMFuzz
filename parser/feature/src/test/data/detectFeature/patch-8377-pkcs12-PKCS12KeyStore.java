@@ -867,14 +867,14 @@ private SecretKey getPBEKey(char[] password) throws IOException
     {
         SecretKey skey = null;
 
+        PBEKeySpec keySpec = new PBEKeySpec(password);
         try {
-            PBEKeySpec keySpec = new PBEKeySpec(password);
             SecretKeyFactory skFac = SecretKeyFactory.getInstance("PBE");
             skey = skFac.generateSecret(keySpec);
-            keySpec.clearPassword();
         } catch (Exception e) {
-           throw new IOException("getSecretKey failed: " +
-                                 e.getMessage(), e);
+            throw new IOException("getSecretKey failed: " + e.getMessage(), e);
+        } finally {
+            keySpec.clearPassword();
         }
         return skey;
     }