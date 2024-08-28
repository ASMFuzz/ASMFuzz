@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,6 +24,7 @@
 /**
  * @test
  * @bug 6870935
+ * @library /test/lib
  * @modules java.base/sun.net.www
  * @run main/othervm -Dhttp.auth.digest.reEnabledAlgorithms=MD5
  *                   -Dhttp.nonProxyHosts="" -Dhttp.auth.digest.validateProxy=true B6870935
@@ -36,6 +37,8 @@
 import java.util.*;
 import java.net.*;
 import java.security.*;
+
+import jdk.test.lib.net.HttpHeaderParser;
 import sun.net.www.*;
 
 /* This is one simple test of the RFC2617 digest authentication behavior
@@ -100,8 +103,9 @@ public void run () {
                 os = s1.getOutputStream ();
                 // is.read ();
                 // need to get the cnonce out of the response
-                MessageHeader header = new MessageHeader (is);
-                String raw = header.findValue ("Proxy-Authorization");
+                HttpHeaderParser header = new HttpHeaderParser (is);
+                String raw = header.getHeaderValue("Proxy-Authorization") != null ?
+                        header.getHeaderValue("Proxy-Authorization").get(0) : null;
                 HeaderParser parser = new HeaderParser (raw);
                 String cnonce = parser.findValue ("cnonce");
                 String cnstring = parser.findValue ("nc");