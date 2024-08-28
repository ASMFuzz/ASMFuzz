@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2010, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2010, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,7 +28,6 @@
  * @summary Add support for HTTP_CONNECT proxy in Socket class.
  * This test uses the wildcard address and is susceptible to fail intermittently.
  * @key intermittent
- * @modules java.base/sun.net.www
  * @run main HttpProxy
  * @run main/othervm -Djava.net.preferIPv4Stack=true HttpProxy
  * @run main/othervm -Djava.net.preferIPv6Addresses=true HttpProxy
@@ -38,7 +37,6 @@
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.io.PrintWriter;
-import static java.lang.System.out;
 import java.net.InetAddress;
 import java.net.InetSocketAddress;
 import java.net.Proxy;
@@ -47,8 +45,10 @@
 import java.net.SocketAddress;
 import java.util.ArrayList;
 import java.util.List;
+
+import static java.lang.System.out;
+import jdk.test.lib.net.HttpHeaderParser;
 import jdk.test.lib.net.IPSupport;
-import sun.net.www.MessageHeader;
 
 public class HttpProxy {
     final String proxyHost;
@@ -244,8 +244,8 @@ public void close() throws Exception {
          * Processes the CONNECT request
          */
         private void processRequest(Socket clientSocket) throws Exception {
-            MessageHeader mheader = new MessageHeader(clientSocket.getInputStream());
-            String statusLine = mheader.getValue(0);
+            HttpHeaderParser mheader = new HttpHeaderParser(clientSocket.getInputStream());
+            String statusLine = mheader.getRequestDetails();
 
             if (!statusLine.startsWith("CONNECT")) {
                 out.println("proxy server: processes only "