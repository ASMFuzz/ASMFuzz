@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2001, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -25,6 +25,7 @@
  * @test
  * @bug 4432213
  * @modules java.base/sun.net.www
+ * @library /test/lib
  * @run main/othervm -Dhttp.auth.digest.reEnabledAlgorithms=MD5
  *                   -Dhttp.auth.digest.validateServer=true DigestTest
  * @run main/othervm -Dhttp.auth.digest.reEnabledAlgorithms=MD5
@@ -44,7 +45,9 @@
 import java.util.*;
 import java.net.*;
 import java.security.*;
-import sun.net.www.*;
+import sun.net.www.HeaderParser;
+
+import jdk.test.lib.net.HttpHeaderParser;
 
 /* This is one simple test of the RFC2617 digest authentication behavior
  * It specifically tests that the client correctly checks the returned
@@ -99,8 +102,9 @@ public void run () {
                 os = s1.getOutputStream ();
                 //is.read ();
                 // need to get the cnonce out of the response
-                MessageHeader header = new MessageHeader (is);
-                String raw = header.findValue ("Authorization");
+                HttpHeaderParser header = new HttpHeaderParser (is);
+                String raw = header.getHeaderValue("Authorization") != null ?
+                        header.getHeaderValue("Authorization").get(0) : null;
                 HeaderParser parser = new HeaderParser (raw);
                 String cnonce = parser.findValue ("cnonce");
                 String cnstring = parser.findValue ("nc");