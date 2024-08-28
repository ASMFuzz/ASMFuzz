@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -26,6 +26,7 @@
 package sun.security.jgss.wrapper;
 
 import org.ietf.jgss.*;
+import java.lang.ref.Cleaner;
 import java.security.Provider;
 import java.security.Security;
 import java.io.IOException;
@@ -48,11 +49,12 @@
  */
 
 public class GSSNameElement implements GSSNameSpi {
+    private final Cleaner.Cleanable cleanable;
 
-    long pName = 0; // Pointer to the gss_name_t structure
+    final long pName; // Pointer to the gss_name_t structure
     private String printableName;
     private Oid printableType;
-    private GSSLibStub cStub;
+    final private GSSLibStub cStub;
 
     static final GSSNameElement DEF_ACCEPTOR = new GSSNameElement();
 
@@ -94,6 +96,9 @@ private static Oid getNativeNameType(Oid nameType, GSSLibStub stub) {
 
     private GSSNameElement() {
         printableName = "<DEFAULT ACCEPTOR>";
+        pName = 0;
+        cleanable = null;
+        cStub = null;
     }
 
     // Warning: called by NativeUtil.c
@@ -106,6 +111,8 @@ private GSSNameElement() {
         pName = pNativeName;
         cStub = stub;
         setPrintables();
+
+        cleanable = Krb5Util.cleaner.register(this, disposerFor(stub, pName));
     }
 
     GSSNameElement(byte[] nameBytes, Oid nameType, GSSLibStub stub)
@@ -151,6 +158,8 @@ private GSSNameElement() {
             }
         }
         pName = cStub.importName(name, nameType);
+        cleanable = Krb5Util.cleaner.register(this, disposerFor(stub, pName));
+
         setPrintables();
 
         @SuppressWarnings("removal")
@@ -284,14 +293,14 @@ public boolean isAnonymousName() {
     }
 
     public void dispose() {
-        if (pName != 0) {
-            cStub.releaseName(pName);
-            pName = 0;
+        if (cleanable != null) {
+            cleanable.clean();
         }
     }
 
-    @SuppressWarnings("removal")
-    protected void finalize() throws Throwable {
-        dispose();
+    private static Runnable disposerFor(GSSLibStub stub, long pName) {
+        return () -> {
+            stub.releaseName(pName);
+        };
     }
 }