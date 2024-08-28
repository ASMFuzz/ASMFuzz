@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1996, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -109,7 +109,7 @@ public abstract class MessageDigest extends MessageDigestSpi {
     private static final boolean skipDebug =
         Debug.isOn("engine=") && !Debug.isOn("messagedigest");
 
-    private String algorithm;
+    private final String algorithm;
 
     // The state of this digest
     private static final int INITIAL = 0;
@@ -156,7 +156,7 @@ private MessageDigest(String algorithm, Provider p) {
      * {@code jdk.security.provider.preferred}
      * {@link Security#getProperty(String) Security} property to determine
      * the preferred provider order for the specified algorithm. This
-     * may be different than the order of providers returned by
+     * may be different from the order of providers returned by
      * {@link Security#getProviders() Security.getProviders()}.
      *
      * @param algorithm the name of the algorithm requested.
@@ -302,10 +302,8 @@ public static MessageDigest getInstance(String algorithm,
             md.provider = (Provider)objs[1];
             return md;
         } else {
-            MessageDigest delegate =
-                    Delegate.of((MessageDigestSpi)objs[0], algorithm,
-                    (Provider)objs[1]);
-            return delegate;
+            return Delegate.of((MessageDigestSpi)objs[0], algorithm,
+                (Provider)objs[1]);
         }
     }
 