@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2000, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -71,10 +71,8 @@ public class GSSUtil {
             GetBooleanAction.privilegedGetProperty("sun.security.jgss.debug");
 
     static void debug(String message) {
-        if (DEBUG) {
-            assert(message != null);
-            System.out.println(message);
-        }
+        assert(message != null);
+        System.out.println(message);
     }
 
     // NOTE: this method is only for creating Oid objects with
@@ -84,7 +82,9 @@ public static Oid createOid(String oidStr) {
         try {
             return new Oid(oidStr);
         } catch (GSSException e) {
-            debug("Ignored invalid OID: " + oidStr);
+            if (DEBUG) {
+                debug("Ignored invalid OID: " + oidStr);
+            }
             return null;
         }
     }
@@ -138,7 +138,9 @@ public static Subject getSubject(GSSName name,
                 KerberosPrincipal krbPrinc = new KerberosPrincipal(krbName);
                 krb5Principals.add(krbPrinc);
             } catch (GSSException ge) {
-                debug("Skipped name " + name + " due to " + ge);
+                if (DEBUG) {
+                    debug("Skipped name " + name + " due to " + ge);
+                }
             }
         }
 
@@ -149,10 +151,12 @@ public static Subject getSubject(GSSName name,
         } else {
             privCredentials = new HashSet<Object>(); // empty Set
         }
-        debug("Created Subject with the following");
-        debug("principals=" + krb5Principals);
-        debug("public creds=" + pubCredentials);
-        debug("private creds=" + privCredentials);
+        if (DEBUG) {
+            debug("Created Subject with the following");
+            debug("principals=" + krb5Principals);
+            debug("public creds=" + pubCredentials);
+            debug("private creds=" + privCredentials);
+        }
 
         return new Subject(false, krb5Principals, pubCredentials,
                            privCredentials);
@@ -212,7 +216,9 @@ private static void populateCredentials(Set<Object> credentials,
                 credentials.add(cred);
             } else {
                 // Ignore non-KerberosTicket and non-KerberosKey elements
-                debug("Skipped cred element: " + cred);
+                if (DEBUG) {
+                    debug("Skipped cred element: " + cred);
+                }
             }
         }
     }
@@ -308,10 +314,12 @@ public static boolean useMSInterop() {
                           final Oid mech,
                           final boolean initiate,
                           final Class<? extends T> credCls) {
-        debug("Search Subject for " + getMechStr(mech) +
-              (initiate? " INIT" : " ACCEPT") + " cred (" +
-              (name == null? "<<DEF>>" : name.toString()) + ", " +
-              credCls.getName() + ")");
+        if (DEBUG) {
+            debug("Search Subject for " + getMechStr(mech) +
+                    (initiate ? " INIT" : " ACCEPT") + " cred (" +
+                    (name == null ? "<<DEF>>" : name.toString()) + ", " +
+                    credCls.getName() + ")");
+        }
         try {
             @SuppressWarnings("removal")
             Vector<T> creds =
@@ -327,30 +335,42 @@ public Vector<T> run() throws Exception {
                                 (GSSCredentialImpl.class).iterator();
                             while (iterator.hasNext()) {
                                 GSSCredentialImpl cred = iterator.next();
-                                debug("...Found cred" + cred);
+                                if (DEBUG) {
+                                    debug("...Found cred" + cred);
+                                }
                                 try {
                                     GSSCredentialSpi ce =
                                         cred.getElement(mech, initiate);
-                                    debug("......Found element: " + ce);
+                                    if (DEBUG) {
+                                        debug("......Found element: " + ce);
+                                    }
                                     if (ce.getClass().equals(credCls) &&
                                         (name == null ||
                                          name.equals((Object) ce.getName()))) {
                                         result.add(credCls.cast(ce));
                                     } else {
-                                        debug("......Discard element");
+                                        if (DEBUG) {
+                                            debug("......Discard element");
+                                        }
                                     }
                                 } catch (GSSException ge) {
-                                    debug("...Discard cred (" + ge + ")");
+                                    if (DEBUG) {
+                                        debug("...Discard cred (" + ge + ")");
+                                    }
                                 }
                             }
-                        } else debug("No Subject");
+                        } else if (DEBUG) {
+                            debug("No Subject");
+                        }
                         return result;
                     }
                 });
             return creds;
         } catch (PrivilegedActionException pae) {
-            debug("Unexpected exception when searching Subject:");
-            if (DEBUG) pae.printStackTrace();
+            if (DEBUG) {
+                debug("Unexpected exception when searching Subject:");
+                pae.printStackTrace();
+            }
             return null;
         }
     }