@@ -25,6 +25,7 @@
 
 package sun.security.pkcs11;
 
+import java.lang.ref.Cleaner;
 import java.math.BigInteger;
 
 import java.io.InputStream;
@@ -231,6 +232,8 @@ private static class PasswordCallbackHandler implements CallbackHandler {
         private PasswordCallbackHandler(char[] password) {
             if (password != null) {
                 this.password = password.clone();
+                Cleaner.create().register(this,
+                        () -> Arrays.fill(this.password, ' '));
             }
         }
 
@@ -242,14 +245,6 @@ public void handle(Callback[] callbacks)
             PasswordCallback pc = (PasswordCallback)callbacks[0];
             pc.setPassword(password);  // this clones the password if not null
         }
-
-        @SuppressWarnings("removal")
-        protected void finalize() throws Throwable {
-            if (password != null) {
-                Arrays.fill(password, ' ');
-            }
-            super.finalize();
-        }
     }
 
     /**