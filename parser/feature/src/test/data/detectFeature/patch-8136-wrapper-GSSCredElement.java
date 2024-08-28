@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
 package sun.security.jgss.wrapper;
 
 import org.ietf.jgss.*;
+import java.lang.ref.Cleaner;
 import java.security.Provider;
 import sun.security.jgss.GSSUtil;
 import sun.security.jgss.spi.GSSCredentialSpi;
@@ -37,11 +38,12 @@
  * @since 1.6
  */
 public class GSSCredElement implements GSSCredentialSpi {
+    private final Cleaner.Cleanable cleanable;
 
     private int usage;
-    long pCred; // Pointer to the gss_cred_id_t structure
+    final long pCred; // Pointer to the gss_cred_id_t structure
     private GSSNameElement name = null;
-    private GSSLibStub cStub;
+    private final GSSLibStub cStub;
 
     // Perform the necessary ServicePermission check on this cred
     @SuppressWarnings("removal")
@@ -69,6 +71,7 @@ void doServicePermCheck() throws GSSException {
         cStub = GSSLibStub.getInstance(mech);
         usage = GSSCredential.INITIATE_ONLY;
         name = srcName;
+        cleanable = Krb5Util.cleaner.register(this, disposerFor(cStub, pCred));
     }
 
     GSSCredElement(GSSNameElement name, int lifetime, int usage,
@@ -85,17 +88,23 @@ void doServicePermCheck() throws GSSException {
             this.name = new GSSNameElement(cStub.getCredName(pCred), cStub);
             doServicePermCheck();
         }
+
+        cleanable = Krb5Util.cleaner.register(this, disposerFor(cStub, pCred));
     }
 
     public Provider getProvider() {
         return SunNativeProvider.INSTANCE;
     }
 
-    public void dispose() throws GSSException {
+    public void dispose() {
         name = null;
-        if (pCred != 0) {
-            pCred = cStub.releaseCred(pCred);
-        }
+        cleanable.clean();
+    }
+
+    private static Runnable disposerFor(GSSLibStub stub, long pCredentials) {
+        return () -> {
+            stub.releaseCred(pCredentials);
+        };
     }
 
     public GSSNameElement getName() throws GSSException {
@@ -132,11 +141,6 @@ public String toString() {
         return "N/A";
     }
 
-    @SuppressWarnings("removal")
-    protected void finalize() throws Throwable {
-        dispose();
-    }
-
     @Override
     public GSSCredentialSpi impersonate(GSSNameSpi name) throws GSSException {
         throw new GSSException(GSSException.FAILURE, -1,