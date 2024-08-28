@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,8 +24,7 @@
 /*
  * @test
  * @bug 8163561
- * @modules java.base/sun.net.www
- *          java.net.http
+ * @library /test/lib
  * @summary Verify that Proxy-Authenticate header is correctly handled
  * @run main/othervm ProxyAuthTest
  */
@@ -52,7 +51,8 @@
 import java.net.http.HttpResponse.BodyHandlers;
 import java.util.Base64;
 import java.util.List;
-import sun.net.www.MessageHeader;
+
+import jdk.test.lib.net.HttpHeaderParser;
 
 public class ProxyAuthTest {
     private static final String AUTH_USER = "user";
@@ -156,10 +156,11 @@ public void run() {
                      BufferedWriter writer = new BufferedWriter(
                              new OutputStreamWriter(os));
                      PrintWriter out = new PrintWriter(writer);) {
-                    MessageHeader headers = new MessageHeader(in);
+                    HttpHeaderParser headers = new HttpHeaderParser(in);
                     System.out.println("Proxy: received " + headers);
 
-                    String authInfo = headers.findValue("Proxy-Authorization");
+                    String authInfo = headers.getHeaderValue("Proxy-Authorization") != null ?
+                            headers.getHeaderValue("Proxy-Authorization").get(0) : null;
                     if (authInfo != null) {
                         authenticate(authInfo);
                         out.print("HTTP/1.1 404 Not found\r\n");