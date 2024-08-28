@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2021, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,7 +24,6 @@
 /*
  * @test
  * @bug 8270290
- * @modules java.base/sun.net.www
  * @library /test/lib
  * @run main/othervm NTLMHeadTest SERVER
  * @run main/othervm NTLMHeadTest PROXY
@@ -52,7 +51,8 @@
 import java.net.*;
 import java.io.*;
 import java.util.*;
-import sun.net.www.MessageHeader;
+
+import jdk.test.lib.net.HttpHeaderParser;
 import jdk.test.lib.net.URIBuilder;
 
 public class NTLMHeadTest {
@@ -264,36 +264,36 @@ static String generateBody(int length) {
 
     static void doServer(InputStream is, OutputStream os, boolean doing2ndStageNTLM) throws IOException {
         if (!doing2ndStageNTLM) {
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_SERVER_AUTH.getBytes("ASCII"));
         } else {
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_SERVER_NTLM.getBytes("ASCII"));
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_SERVER_OR_PROXY_DEST.getBytes("ASCII"));
         }
     }
 
     static void doProxy(InputStream is, OutputStream os, boolean doing2ndStageNTLM) throws IOException {
         if (!doing2ndStageNTLM) {
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_PROXY_AUTH.getBytes("ASCII"));
         } else {
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_PROXY_NTLM.getBytes("ASCII"));
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_SERVER_OR_PROXY_DEST.getBytes("ASCII"));
         }
     }
 
     static void doTunnel(InputStream is, OutputStream os, boolean doing2ndStageNTLM) throws IOException {
         if (!doing2ndStageNTLM) {
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_TUNNEL_AUTH.getBytes("ASCII"));
         } else {
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_TUNNEL_NTLM.getBytes("ASCII"));
-            new MessageHeader(is);
+            new HttpHeaderParser(is);
             os.write(RESP_TUNNEL_ESTABLISHED.getBytes("ASCII"));
         }
     }