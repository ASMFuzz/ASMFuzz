@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,6 +36,7 @@
 import javax.security.auth.RefreshFailedException;
 import javax.security.auth.DestroyFailedException;
 
+import sun.security.krb5.KrbException;
 import sun.security.util.HexDumpEncoder;
 
 /**
@@ -596,7 +597,6 @@ public void refresh() throws RefreshFailedException {
             throw new RefreshFailedException("This ticket is past "
                                            + "its last renewal time.");
         }
-        Throwable e = null;
         sun.security.krb5.Credentials krb5Creds = null;
 
         try {
@@ -616,13 +616,7 @@ public void refresh() throws RefreshFailedException {
                                                     renewTill,
                                                     clientAddresses);
             krb5Creds = krb5Creds.renew();
-        } catch (sun.security.krb5.KrbException krbException) {
-            e = krbException;
-        } catch (java.io.IOException ioException) {
-            e = ioException;
-        }
-
-        if (e != null) {
+        } catch (KrbException | IOException e) {
             RefreshFailedException rfException
                 = new RefreshFailedException("Failed to renew Kerberos Ticket "
                                              + "for client " + client