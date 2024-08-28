@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2003, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -31,6 +31,7 @@
 import java.net.URL;
 
 public class Implies {
+
     public static void main(String[] args) throws Exception {
         URL thisURL = new URL("http", "localhost", "file");
         URL thatURL = new URL("http", null, "file");
@@ -51,14 +52,17 @@ public static void main(String[] args) throws Exception {
     }
 
     private static void testImplies(URL thisURL, URL thatURL, boolean result)
-        throws SecurityException
-    {
-        CodeSource thisCs =
-            new CodeSource(thisURL, (java.security.cert.Certificate[]) null);
-        CodeSource thatCs =
-            new CodeSource(thatURL, (java.security.cert.Certificate[]) null);
+            throws SecurityException {
+        CodeSource thisCs
+                = new CodeSource(thisURL, (java.security.cert.Certificate[]) null);
+        CodeSource thatCs
+                = new CodeSource(thatURL, (java.security.cert.Certificate[]) null);
         if (thisCs.implies(thatCs) != result) {
-            throw new SecurityException("test failed");
+            throw new SecurityException("CodeSource.implies() returned "
+                    + !result + " instead of " + result);
+        }
+        if (thisCs.getCodeSigners() != null && thatCs.getCodeSigners() != null) {
+            throw new SecurityException("Both getCodeSigners should be null");
         }
     }
 }