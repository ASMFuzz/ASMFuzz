@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2002, 2019, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2002, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -29,12 +29,17 @@
  * It is used by the TunnelThroughProxy test.
  */
 
-import java.io.*;
-import java.net.*;
+import java.io.Closeable;
+import java.io.IOException;
+import java.io.InputStream;
+import java.io.OutputStream;
+import java.io.PrintWriter;
+import java.net.InetAddress;
+import java.net.ServerSocket;
+import java.net.Socket;
 import java.util.Base64;
-import javax.net.ssl.*;
-import javax.net.ServerSocketFactory;
-import sun.net.www.*;
+
+import jdk.test.lib.net.HttpHeaderParser;
 
 public class ProxyTunnelServer extends Thread {
 
@@ -129,8 +134,8 @@ public void run() {
      */
     private void processRequests(boolean makeTunnel) throws Exception {
         InputStream in = clientSocket.getInputStream();
-        MessageHeader mheader = new MessageHeader(in);
-        String statusLine = mheader.getValue(0);
+        HttpHeaderParser mheader = new HttpHeaderParser(in);
+        String statusLine = mheader.getRequestDetails();
 
         System.out.printf("Proxy: Processing request from '%s'%n", clientSocket);
 
@@ -139,8 +144,9 @@ private void processRequests(boolean makeTunnel) throws Exception {
             // retrieveConnectInfo(statusLine);
             if (needAuth) {
                 String authInfo;
-                if ((authInfo = mheader.findValue("Proxy-Authorization"))
-                                         != null) {
+                if ((authInfo = (mheader.getHeaderValue("Proxy-Authorization") != null ?
+                        mheader.getHeaderValue("Proxy-Authorization").get(0) : null))
+                        != null) {
                    if (authenticate(authInfo)) {
                         needAuth = false;
                         System.out.println(