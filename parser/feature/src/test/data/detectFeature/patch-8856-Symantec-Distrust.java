@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -54,15 +54,14 @@ public class Distrust {
     // Each of the roots have a test certificate chain stored in a file
     // named "<root>-chain.pem".
     private static String[] rootsToTest = new String[] {
-        "geotrustglobalca", "geotrustprimarycag2", "geotrustprimarycag3",
+        "geotrustprimarycag2", "geotrustprimarycag3",
         "geotrustuniversalca", "thawteprimaryrootca", "thawteprimaryrootcag2",
         "thawteprimaryrootcag3", "verisignclass3g3ca", "verisignclass3g4ca",
         "verisignclass3g5ca", "verisignuniversalrootca" };
 
     // Each of the subCAs with a delayed distrust date have a test certificate
     // chain stored in a file named "<subCA>-chain.pem".
-    private static String[] subCAsToTest = new String[] {
-        "appleistca2g1", "appleistca8g1" };
+    private static String[] subCAsToTest = new String[]{"appleistca8g1"};
 
     // A date that is after the restrictions take affect
     private static final Date APRIL_17_2019 =
@@ -180,13 +179,19 @@ private static void testTM(X509TrustManager xtm, X509Certificate[] chain,
                 throw new Exception("chain should be invalid");
             }
         } catch (CertificateException ce) {
+            // expired TLS certificates should not be treated as failure
+            if (expired(ce)) {
+                System.err.println("Test is N/A, chain is expired");
+                return;
+            }
             if (valid) {
                 throw new Exception("Unexpected exception, chain " +
                                     "should be valid", ce);
             }
             if (ce instanceof ValidatorException) {
                 ValidatorException ve = (ValidatorException)ce;
                 if (ve.getErrorType() != ValidatorException.T_UNTRUSTED_CERT) {
+                    ce.printStackTrace(System.err);
                     throw new Exception("Unexpected exception: " + ce);
                 }
             } else {
@@ -195,6 +200,21 @@ private static void testTM(X509TrustManager xtm, X509Certificate[] chain,
         }
     }
 
+    // check if a cause of exception is an expired cert
+    private static boolean expired(CertificateException ce) {
+        if (ce instanceof CertificateExpiredException) {
+            return true;
+        }
+        Throwable t = ce.getCause();
+        while (t != null) {
+            if (t instanceof CertificateExpiredException) {
+                return true;
+            }
+            t = t.getCause();
+        }
+        return false;
+    }
+
     private static X509Certificate[] loadCertificateChain(String name)
             throws Exception {
         try (InputStream in = new FileInputStream(TEST_SRC + File.separator +