@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,7 +25,6 @@
 
 package sun.security.pkcs11;
 
-import java.lang.ref.Cleaner;
 import java.math.BigInteger;
 
 import java.io.InputStream;
@@ -232,8 +231,7 @@ private static class PasswordCallbackHandler implements CallbackHandler {
         private PasswordCallbackHandler(char[] password) {
             if (password != null) {
                 this.password = password.clone();
-                Cleaner.create().register(this,
-                        () -> Arrays.fill(this.password, ' '));
+                P11Util.cleaner.register(this, releaserFor(this.password));
             }
         }
 
@@ -245,6 +243,12 @@ public void handle(Callback[] callbacks)
             PasswordCallback pc = (PasswordCallback)callbacks[0];
             pc.setPassword(password);  // this clones the password if not null
         }
+
+        private static Runnable releaserFor(char[] password) {
+            return () -> {
+                Arrays.fill(password, ' ');
+            };
+        }
     }
 
     /**