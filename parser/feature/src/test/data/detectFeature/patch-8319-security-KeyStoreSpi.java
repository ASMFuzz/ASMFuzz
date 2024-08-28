@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1998, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -380,7 +380,7 @@ public abstract void engineLoad(InputStream stream, char[] password)
      * <p>
      * If {@code KeyStore.LoadStoreParameter} is {@code null} then
      * the password parameter will also be {@code null}.
-     * Otherwise the {@code KeyStore.ProtectionParameter} of
+     * Otherwise, the {@code KeyStore.ProtectionParameter} of
      * {@code KeyStore.LoadStoreParameter} must be either a
      * {@code KeyStore.PasswordProtection} or a
      * {@code KeyStore.CallbackHandlerProtection} that supports
@@ -415,7 +415,7 @@ void engineLoad(InputStream stream, KeyStore.LoadStoreParameter param)
                 CertificateException {
 
         if (param == null) {
-            engineLoad((InputStream)null, (char[])null);
+            engineLoad(null, (char[])null);
             return;
         }
 
@@ -444,7 +444,6 @@ void engineLoad(InputStream stream, KeyStore.LoadStoreParameter param)
                 + " be PasswordProtection or CallbackHandlerProtection");
         }
         engineLoad(stream, password);
-        return;
     }
 
     /**
@@ -610,8 +609,7 @@ public void engineSetEntry(String alias, KeyStore.Entry entry,
                 engineSetKeyEntry
                     (alias,
                     ((KeyStore.SecretKeyEntry)entry).getSecretKey(),
-                    pProtect.getPassword(),
-                    (Certificate[])null);
+                    pProtect.getPassword(), null);
                 return;
             }
         }