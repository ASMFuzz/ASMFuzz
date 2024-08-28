@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -36,7 +36,7 @@
 import java.net.*;
 import javax.net.ssl.*;
 import javax.net.ServerSocketFactory;
-import sun.net.www.MessageHeader;
+import jdk.test.lib.net.HttpHeaderParser;
 
 public class ProxyTunnelServer extends Thread {
 
@@ -82,8 +82,8 @@ public void run() {
     private void processRequests() throws Exception {
 
         InputStream in = clientSocket.getInputStream();
-        MessageHeader response = new MessageHeader(in);
-        String statusLine = response.getValue(0);
+        HttpHeaderParser response = new HttpHeaderParser(in);
+        String statusLine = response.getRequestDetails();
 
         if (statusLine.startsWith("CONNECT")) {
             // retrieve the host and port info from the response line