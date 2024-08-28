@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2016, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -24,6 +24,9 @@
 import java.io.InputStream;
 import java.net.URI;
 import java.net.http.HttpHeaders;
+import java.util.List;
+
+import jdk.internal.net.http.frame.ContinuationFrame;
 import jdk.internal.net.http.frame.Http2Frame;
 
 // will be converted to a PushPromiseFrame in the writeLoop
@@ -33,16 +36,29 @@ class OutgoingPushPromise extends Http2Frame {
     final URI uri;
     final InputStream is;
     final int parentStream; // not the pushed streamid
+    private final List<Http2Frame> continuations;
 
     public OutgoingPushPromise(int parentStream,
                                URI uri,
                                HttpHeaders headers,
                                InputStream is) {
+        this(parentStream, uri, headers, is, List.of());
+    }
+
+    public OutgoingPushPromise(int parentStream,
+                               URI uri,
+                               HttpHeaders headers,
+                               InputStream is,
+                               List<ContinuationFrame> continuations) {
         super(0,0);
         this.uri = uri;
         this.headers = headers;
         this.is = is;
         this.parentStream = parentStream;
+        this.continuations = List.copyOf(continuations);
     }
 
+    public List<Http2Frame> getContinuations() {
+        return continuations;
+    }
 }