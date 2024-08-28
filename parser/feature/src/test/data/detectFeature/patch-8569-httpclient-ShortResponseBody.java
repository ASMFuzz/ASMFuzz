@@ -1,5 +1,5 @@
 /*
- * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
+ * Copyright (c) 2018, 2022, Oracle and/or its affiliates. All rights reserved.
  * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
  *
  * This code is free software; you can redistribute it and/or modify it
@@ -21,17 +21,6 @@
  * questions.
  */
 
-/*
- * @test
- * @bug 8216498
- * @summary Tests Exception detail message when too few response bytes are
- *          received before a socket exception or eof.
- * @library /test/lib
- * @build jdk.test.lib.net.SimpleSSLContext
- * @run testng/othervm
- *       -Djdk.httpclient.HttpClient.log=headers,errors,channel
- *       ShortResponseBody
- */
 
 import java.io.IOException;
 import java.io.InputStream;
@@ -44,12 +33,10 @@
 import java.net.URI;
 import java.net.http.HttpClient;
 import java.net.http.HttpRequest;
-import java.net.http.HttpRequest.BodyPublishers;
 import java.net.http.HttpResponse;
 import java.util.ArrayList;
 import java.util.Arrays;
 import java.util.List;
-import java.util.concurrent.ExecutionException;
 import java.util.concurrent.ExecutorService;
 import java.util.concurrent.Executors;
 import java.util.concurrent.ThreadFactory;
@@ -81,7 +68,7 @@
 import static org.testng.Assert.assertEquals;
 import static org.testng.Assert.fail;
 
-public class ShortResponseBody {
+public abstract class ShortResponseBody {
 
     Server closeImmediatelyServer;
     Server closeImmediatelyHttpsServer;
@@ -98,10 +85,17 @@ public class ShortResponseBody {
     SSLContext sslContext;
     SSLParameters sslParameters;
 
+    static final long PAUSE_FOR_GC = 5; // 5ms to let gc work
+    static final long PAUSE_FOR_PEER = 5; // 5ms to let server react
+
     static final String EXPECTED_RESPONSE_BODY =
             "<html><body><h1>Heading</h1><p>Some Text</p></body></html>";
 
-    final static AtomicLong ids = new AtomicLong();
+    // A request number used to replace %reqnb% in URLs with a unique
+    // number for better log analysis
+    static final AtomicLong reqnb = new AtomicLong();
+
+    static final AtomicLong ids = new AtomicLong();
     final ThreadFactory factory = new ThreadFactory() {
         @Override
         public Thread newThread(Runnable r) {
@@ -125,6 +119,12 @@ static String name(ITestResult result) {
 
     @BeforeMethod
     void beforeMethod(ITestContext context) {
+        System.gc();
+        try {
+            Thread.sleep(PAUSE_FOR_GC);
+        } catch (InterruptedException x) {
+
+        }
         if (context.getFailedTests().size() > 0) {
             if (skiptests.get() == null) {
                 SkipException skip = new SkipException("some tests failed");
@@ -162,10 +162,16 @@ public Object[][] sanity() {
         };
     }
 
+    public static String uniqueURL(String url) {
+        return url.replace("%reqnb%", String.valueOf(reqnb.incrementAndGet()));
+    }
+
     @Test(dataProvider = "sanity")
     void sanity(String url) throws Exception {
         HttpClient client = newHttpClient();
+        url = uniqueURL(url);
         HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
+        out.println("Request: " + request);
         HttpResponse<String> response = client.send(request, ofString());
         String body = response.body();
         assertEquals(body, EXPECTED_RESPONSE_BODY);
@@ -263,59 +269,16 @@ HttpClient newHttpClient() {
                 .build();
     }
 
-    @Test(dataProvider = "uris")
-    void testSynchronousGET(String url, String expectedMsg, boolean sameClient)
-        throws Exception
-    {
-        checkSkip();
-        out.print("---\n");
-        HttpClient client = null;
-        for (int i=0; i< ITERATION_COUNT; i++) {
-            if (!sameClient || client == null)
-                client = newHttpClient();
-            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
-            try {
-                HttpResponse<String> response = client.send(request, ofString());
-                String body = response.body();
-                out.println(response + ": " + body);
-                fail("UNEXPECTED RESPONSE: " + response);
-            } catch (IOException ioe) {
-                out.println("Caught expected exception:" + ioe);
-                assertExpectedMessage(request, ioe, expectedMsg);
-                // synchronous API must have the send method on the stack
-                assertSendMethodOnStack(ioe);
-                assertNoConnectionExpiredException(ioe);
-            }
-        }
-    }
-
-    @Test(dataProvider = "uris")
-    void testAsynchronousGET(String url, String expectedMsg, boolean sameClient)
-        throws Exception
-    {
-        checkSkip();
-        out.print("---\n");
-        HttpClient client = null;
-        for (int i=0; i< ITERATION_COUNT; i++) {
-            if (!sameClient || client == null)
-                client = newHttpClient();
-            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build();
-            try {
-                HttpResponse<String> response = client.sendAsync(request, ofString()).get();
-                String body = response.body();
-                out.println(response + ": " + body);
-                fail("UNEXPECTED RESPONSE: " + response);
-            } catch (ExecutionException ee) {
-                if (ee.getCause() instanceof IOException) {
-                    IOException ioe = (IOException) ee.getCause();
-                    out.println("Caught expected exception:" + ioe);
-                    assertExpectedMessage(request, ioe, expectedMsg);
-                    assertNoConnectionExpiredException(ioe);
-                } else {
-                    throw ee;
-                }
+    HttpClient sharedClient = null;
+    HttpClient newHttpClient(boolean shared) {
+        if (shared) {
+            HttpClient sharedClient = this.sharedClient;
+            if (sharedClient == null) {
+                sharedClient = this.sharedClient = newHttpClient();
             }
+            return sharedClient;
         }
+        return newHttpClient();
     }
 
     // can be used to prolong request body publication
@@ -331,6 +294,11 @@ public int read() throws IOException {
                 k16++;
                 System.out.println("... 16K sent.");
                 count = count % (16 * 1024);
+                try {
+                    Thread.sleep(PAUSE_FOR_PEER);
+                } catch (InterruptedException x) {
+                    // ignore
+                }
             }
             if (k16 > 128) {
                 System.out.println("WARNING: InfiniteInputStream: " +
@@ -353,6 +321,11 @@ public int read(byte[] buf, int offset, int length) {
                 k16++;
                 System.out.println("... 16K sent.");
                 count = count % (16 * 1024);
+                try {
+                    Thread.sleep(PAUSE_FOR_PEER);
+                } catch (InterruptedException x) {
+                    // ignore
+                }
             }
             if (k16 > 128) {
                 System.out.println("WARNING: InfiniteInputStream: " +
@@ -364,86 +337,6 @@ public int read(byte[] buf, int offset, int length) {
         }
     }
 
-    // POST tests are racy in what may be received before writing may cause a
-    // broken pipe or reset exception, before all the received data can be read.
-    // Any message up to, and including, the "expected" error message can occur.
-    // Strictly ordered list, in order of possible occurrence.
-    static final List<String> MSGS_ORDER =
-            List.of("no bytes", "status line", "header");
-
-
-    @Test(dataProvider = "uris")
-    void testSynchronousPOST(String url, String expectedMsg, boolean sameClient)
-        throws Exception
-    {
-        checkSkip();
-        out.print("---\n");
-        HttpClient client = null;
-        for (int i=0; i< ITERATION_COUNT; i++) {
-            if (!sameClient || client == null)
-                client = newHttpClient();
-            HttpRequest request = HttpRequest.newBuilder(URI.create(url))
-                    .POST(BodyPublishers.ofInputStream(() -> new InfiniteInputStream()))
-                    .build();
-            try {
-                HttpResponse<String> response = client.send(request, ofString());
-                String body = response.body();
-                out.println(response + ": " + body);
-                fail("UNEXPECTED RESPONSE: " + response);
-            } catch (IOException ioe) {
-                out.println("Caught expected exception:" + ioe);
-
-                List<String> expectedMessages = new ArrayList<>();
-                expectedMessages.add(expectedMsg);
-                MSGS_ORDER.stream().takeWhile(s -> !s.equals(expectedMsg))
-                                   .forEach(expectedMessages::add);
-
-                assertExpectedMessage(request, ioe, expectedMessages);
-                // synchronous API must have the send method on the stack
-                assertSendMethodOnStack(ioe);
-                assertNoConnectionExpiredException(ioe);
-            }
-        }
-    }
-
-    @Test(dataProvider = "uris")
-    void testAsynchronousPOST(String url, String expectedMsg, boolean sameClient)
-        throws Exception
-    {
-        checkSkip();
-        out.print("---\n");
-        HttpClient client = null;
-        for (int i=0; i< ITERATION_COUNT; i++) {
-            if (!sameClient || client == null)
-                client = newHttpClient();
-            HttpRequest request = HttpRequest.newBuilder(URI.create(url))
-                    .POST(BodyPublishers.ofInputStream(() -> new InfiniteInputStream()))
-                    .build();
-            try {
-                HttpResponse<String> response = client.sendAsync(request, ofString()).get();
-                String body = response.body();
-                out.println(response + ": " + body);
-                fail("UNEXPECTED RESPONSE: " + response);
-            } catch (ExecutionException ee) {
-                if (ee.getCause() instanceof IOException) {
-                    IOException ioe = (IOException) ee.getCause();
-                    out.println("Caught expected exception:" + ioe);
-
-                    List<String> expectedMessages = new ArrayList<>();
-                    expectedMessages.add(expectedMsg);
-                    MSGS_ORDER.stream().takeWhile(s -> !s.equals(expectedMsg))
-                            .forEach(expectedMessages::add);
-
-                    assertExpectedMessage(request, ioe, expectedMessages);
-                    assertNoConnectionExpiredException(ioe);
-                } else {
-                    throw ee;
-                }
-            }
-        }
-    }
-
-
     void assertExpectedMessage(HttpRequest request, Throwable t, String expected) {
         if (request.uri().getScheme().equalsIgnoreCase("https")
                 && (t instanceof SSLHandshakeException)) {
@@ -758,27 +651,28 @@ public void setup() throws Exception {
 
         closeImmediatelyServer = new PlainCloseImmediatelyServer();
         httpURIClsImed = "http://" + serverAuthority(closeImmediatelyServer)
-                + "/http1/closeImmediately/foo";
+                + "/http1/closeImmediately/req=%reqnb%/foo";
 
         closeImmediatelyHttpsServer = new SSLCloseImmediatelyServer();
         httpsURIClsImed = "https://" + serverAuthority(closeImmediatelyHttpsServer)
-                + "/https1/closeImmediately/foo";
+                + "/https1/closeImmediately/req=%reqnb%/foo";
 
         variableLengthServer = new PlainVariableLengthServer();
         httpURIVarLen = "http://" + serverAuthority(variableLengthServer)
-                + "/http1/variable/bar";
+                + "/http1/variable/req=%reqnb%/bar";
 
         variableLengthHttpsServer = new SSLVariableLengthServer();
         httpsURIVarLen = "https://" + serverAuthority(variableLengthHttpsServer)
-                + "/https1/variable/bar";
+                + "/https1/variable/req=%reqnb%/bar";
 
         fixedLengthServer = new FixedLengthServer();
         httpURIFixLen = "http://" + serverAuthority(fixedLengthServer)
-                + "/http1/fixed/baz";
+                + "/http1/fixed/req=%reqnb%/baz";
     }
 
     @AfterTest
     public void teardown() throws Exception {
+        if (sharedClient != null) sharedClient = null;
         closeImmediatelyServer.close();
         closeImmediatelyHttpsServer.close();
         variableLengthServer.close();