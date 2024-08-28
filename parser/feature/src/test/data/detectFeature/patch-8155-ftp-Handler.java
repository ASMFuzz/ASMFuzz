@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 1994, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -30,6 +30,7 @@
 package sun.net.www.protocol.ftp;
 
 import java.io.IOException;
+import java.net.MalformedURLException;
 import java.net.URL;
 import java.net.Proxy;
 import java.util.Map;
@@ -58,6 +59,14 @@ protected java.net.URLConnection openConnection(URL u)
 
     protected java.net.URLConnection openConnection(URL u, Proxy p)
         throws IOException {
-        return new FtpURLConnection(u, p);
+        FtpURLConnection connection = null;
+        try {
+            connection = new FtpURLConnection(u, p);
+        } catch (IllegalArgumentException e) {
+            var mfue = new MalformedURLException(e.getMessage());
+            mfue.initCause(e);
+            throw mfue;
+        }
+        return connection;
     }
 }