@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -28,13 +28,20 @@
  * is accepted.
  * It is used by the regression test for the bug fixes: 4323990, 4413069
  */
-import java.io.*;
-import java.net.*;
-import javax.net.ssl.*;
-import javax.net.ServerSocketFactory;
-import sun.net.www.*;
+import java.io.IOException;
+import java.io.InputStream;
+import java.io.OutputStream;
+import java.io.PrintWriter;
+import java.net.InetAddress;
+import java.net.InetSocketAddress;
+import java.net.ServerSocket;
+import java.net.Socket;
 import java.util.Base64;
 
+import javax.net.ServerSocketFactory;
+
+import jdk.test.lib.net.HttpHeaderParser;
+
 public class ProxyTunnelServer extends Thread {
 
     private static ServerSocket ss = null;
@@ -113,15 +120,16 @@ public void run() {
     private void processRequests() throws Exception {
 
         InputStream in = clientSocket.getInputStream();
-        MessageHeader mheader = new MessageHeader(in);
-        String statusLine = mheader.getValue(0);
+        HttpHeaderParser mheader = new HttpHeaderParser(in);
+        String statusLine = mheader.getRequestDetails();
 
         if (statusLine.startsWith("CONNECT")) {
             // retrieve the host and port info from the status-line
             retrieveConnectInfo(statusLine);
             if (needAuth) {
                 String authInfo;
-                if ((authInfo = mheader.findValue("Proxy-Authorization"))
+                if ((authInfo = (mheader.getHeaderValue("Proxy-Authorization") != null) ?
+                        mheader.getHeaderValue("Proxy-Authorization").get(0) : null)
                                          != null) {
                    if (authenticate(authInfo)) {
                         needAuth = false;