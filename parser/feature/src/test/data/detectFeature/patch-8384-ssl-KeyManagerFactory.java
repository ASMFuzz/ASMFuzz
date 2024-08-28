@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1999, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -42,13 +42,13 @@
  */
 public class KeyManagerFactory {
     // The provider
-    private Provider provider;
+    private final Provider provider;
 
     // The provider implementation (delegate)
-    private KeyManagerFactorySpi factorySpi;
+    private final KeyManagerFactorySpi factorySpi;
 
     // The name of the key management algorithm.
-    private String algorithm;
+    private final String algorithm;
 
     /**
      * Obtains the default KeyManagerFactory algorithm name.
@@ -63,15 +63,10 @@ public class KeyManagerFactory {
      *          implementation-specific default if no such property exists.
      */
     @SuppressWarnings("removal")
-    public static final String getDefaultAlgorithm() {
+    public static String getDefaultAlgorithm() {
         String type;
-        type = AccessController.doPrivileged(new PrivilegedAction<>() {
-            @Override
-            public String run() {
-                return Security.getProperty(
-                    "ssl.KeyManagerFactory.algorithm");
-            }
-        });
+        type = AccessController.doPrivileged((PrivilegedAction<String>) () ->
+            Security.getProperty("ssl.KeyManagerFactory.algorithm"));
         if (type == null) {
             type = "SunX509";
         }
@@ -123,7 +118,7 @@ public final String getAlgorithm() {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the standard name of the requested algorithm.