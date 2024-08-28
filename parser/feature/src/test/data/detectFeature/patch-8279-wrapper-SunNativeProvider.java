@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2005, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,6 +30,7 @@
 import java.security.AccessController;
 import java.security.PrivilegedAction;
 import org.ietf.jgss.Oid;
+import sun.security.action.GetBooleanAction;
 import sun.security.action.PutAllAction;
 import static sun.security.util.SecurityConstants.PROVIDER_VER;
 
@@ -51,32 +52,32 @@ public final class SunNativeProvider extends Provider {
     private static final String INFO = "Sun Native GSS provider";
     private static final String MF_CLASS =
         "sun.security.jgss.wrapper.NativeGSSFactory";
-    static boolean DEBUG;
+    private static final boolean DEBUG =
+        GetBooleanAction.privilegedGetProperty("sun.security.nativegss.debug");
+
     static void debug(String message) {
-        if (DEBUG) {
-            if (message == null) {
-                throw new NullPointerException();
-            }
-            System.out.println(NAME + ": " + message);
+        if (message == null) {
+            throw new NullPointerException();
         }
+        System.out.println(NAME + ": " + message);
     }
 
     @SuppressWarnings("removal")
     private static final HashMap<String, String> MECH_MAP =
             AccessController.doPrivileged(
                 new PrivilegedAction<>() {
                     public HashMap<String, String> run() {
-                        DEBUG = Boolean.parseBoolean(
-                            System.getProperty("sun.security.nativegss.debug"));
                         try {
                             // Ensure the InetAddress class is loaded before
                             // loading j2gss. The library will access this class
                             // and a deadlock might happen. See JDK-8210373.
                             Class.forName("java.net.InetAddress");
                             System.loadLibrary("j2gss");
                         } catch (ClassNotFoundException | Error err) {
-                            debug("No j2gss library found!");
-                            if (DEBUG) err.printStackTrace();
+                            if (DEBUG) {
+                                debug("No j2gss library found!");
+                                err.printStackTrace();
+                            }
                             return null;
                         }
                         String[] gssLibs;
@@ -107,11 +108,15 @@ public HashMap<String, String> run() {
                         }
                         for (String libName: gssLibs) {
                             if (GSSLibStub.init(libName, DEBUG)) {
-                                debug("Loaded GSS library: " + libName);
+                                if (DEBUG) {
+                                    debug("Loaded GSS library: " + libName);
+                                }
                                 Oid[] mechs = GSSLibStub.indicateMechs();
                                 HashMap<String,String> map = new HashMap<>();
                                 for (int i = 0; i < mechs.length; i++) {
-                                    debug("Native MF for " + mechs[i]);
+                                    if (DEBUG) {
+                                        debug("Native MF for " + mechs[i]);
+                                    }
                                     map.put("GssApiMechanism." + mechs[i],
                                             MF_CLASS);
                                 }