@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1995, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -58,7 +58,7 @@ public abstract class AuthenticationInfo extends AuthCacheValue implements Clone
     @java.io.Serial
     static final long serialVersionUID = -2588378268010453259L;
 
-    // Constants saying what kind of authroization this is.  This determines
+    // Constants saying what kind of authorization this is.  This determines
     // the namespace in the hash table lookup.
     public static final char SERVER_AUTHENTICATION = 's';
     public static final char PROXY_AUTHENTICATION = 'p';
@@ -152,16 +152,10 @@ private static AuthenticationInfo requestAuthentication(String key, Function<Str
 
             // Otherwise, if no request is in progress, record this
             // thread as performing authentication and returns null.
-            Thread t, c;
-            c = Thread.currentThread();
-            if ((t = requests.get(key)) == null) {
-                requests.put (key, c);
-                assert cached == null;
-                return cached;
-            }
-            if (t == c) {
-                assert cached == null;
-                return cached;
+            Thread c = Thread.currentThread();
+            Thread t = requests.putIfAbsent(key, c);
+            if (t == null || t == c) {
+                return null;
             }
             // Otherwise, an other thread is currently performing authentication:
             // wait until it finishes.