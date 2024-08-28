@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2015, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -291,21 +291,19 @@ List<ByteBuffer> headers() {
         if (uri != null) {
             systemHeadersBuilder.setHeader("Host", hostString());
         }
-        if (requestPublisher == null) {
-            // Not a user request, or maybe a method, e.g. GET, with no body.
-            contentLength = 0;
-        } else {
-            contentLength = requestPublisher.contentLength();
-        }
 
-        if (contentLength == 0) {
-            systemHeadersBuilder.setHeader("Content-Length", "0");
-        } else if (contentLength > 0) {
-            systemHeadersBuilder.setHeader("Content-Length", Long.toString(contentLength));
-            streaming = false;
-        } else {
-            streaming = true;
-            systemHeadersBuilder.setHeader("Transfer-encoding", "chunked");
+        // GET, HEAD and DELETE with no request body should not set the Content-Length header
+        if (requestPublisher != null) {
+            contentLength = requestPublisher.contentLength();
+            if (contentLength == 0) {
+                systemHeadersBuilder.setHeader("Content-Length", "0");
+            } else if (contentLength > 0) {
+                systemHeadersBuilder.setHeader("Content-Length", Long.toString(contentLength));
+                streaming = false;
+            } else {
+                streaming = true;
+                systemHeadersBuilder.setHeader("Transfer-encoding", "chunked");
+            }
         }
         collectHeaders0(sb);
         String hs = sb.toString();