@@ -61,12 +61,13 @@
 import java.util.List;
 import java.util.Map;
 import java.util.concurrent.CompletableFuture;
+import java.util.concurrent.CompletionException;
 import java.util.concurrent.ConcurrentHashMap;
 import java.util.concurrent.ConcurrentMap;
 import java.util.function.BiPredicate;
 
 import static java.nio.charset.StandardCharsets.UTF_8;
-import static org.testng.Assert.assertEquals;
+import static org.testng.Assert.*;
 
 public class PushPromiseContinuation {
 
@@ -97,7 +98,7 @@ public void setup() throws Exception {
 
         // Need to have a custom exchange supplier to manage the server's push
         // promise with continuation flow
-        server.setExchangeSupplier(Http2LPPTestExchangeImpl::new);
+        server.setExchangeSupplier(Http2PushPromiseContinuationExchangeImpl::new);
 
         System.err.println("PushPromiseContinuation: Server listening on port " + server.getAddress().getPort());
         server.start();
@@ -166,6 +167,31 @@ public void testThreeContinuations() {
         verify(resp);
     }
 
+    @Test
+    public void testSendHeadersOnPushPromiseStream() throws Exception {
+        // This test server sends a push promise that should be followed by a continuation but
+        // incorrectly sends on Response Headers while the client awaits the continuation.
+        Http2TestServer faultyServer = new Http2TestServer(false, 0);
+        faultyServer.addHandler(new ServerPushHandler(), "/");
+        faultyServer.setExchangeSupplier(Http2PushPromiseHeadersExchangeImpl::new);
+        System.err.println("PushPromiseContinuation: FaultyServer listening on port " + faultyServer.getAddress().getPort());
+        faultyServer.start();
+
+        int faultyPort = faultyServer.getAddress().getPort();
+        URI faultyUri = new URI("http://localhost:" + faultyPort + "/");
+
+        HttpClient client = HttpClient.newHttpClient();
+        // Server is making a request to an incorrect URI
+        HttpRequest hreq = HttpRequest.newBuilder(faultyUri).version(HttpClient.Version.HTTP_2).GET().build();
+        CompletableFuture<HttpResponse<String>> cf =
+                client.sendAsync(hreq, HttpResponse.BodyHandlers.ofString(UTF_8), pph);
+
+        CompletionException t = expectThrows(CompletionException.class, () -> cf.join());
+        assertEquals(t.getCause().getClass(), IOException.class, "Expected an IOException but got " + t.getCause());
+        System.err.println("Client received the following expected exception: " + t.getCause());
+        faultyServer.stop();
+    }
+
     private void verify(HttpResponse<String> resp) {
         assertEquals(resp.statusCode(), 200);
         assertEquals(resp.body(), mainResponseBody);
@@ -186,15 +212,46 @@ private void verify(HttpResponse<String> resp) {
         }
     }
 
-    static class Http2LPPTestExchangeImpl extends Http2TestExchangeImpl {
+    static class Http2PushPromiseHeadersExchangeImpl extends Http2TestExchangeImpl {
+
+        Http2PushPromiseHeadersExchangeImpl(int streamid, String method, HttpHeaders reqheaders, HttpHeadersBuilder rspheadersBuilder, URI uri, InputStream is, SSLSession sslSession, BodyOutputStream os, Http2TestServerConnection conn, boolean pushAllowed) {
+            super(streamid, method, reqheaders, rspheadersBuilder, uri, is, sslSession, os, conn, pushAllowed);
+        }
+
+
+        @Override
+        public void serverPush(URI uri, HttpHeaders headers, InputStream content) {
+            HttpHeadersBuilder headersBuilder = new HttpHeadersBuilder();
+            headersBuilder.setHeader(":method", "GET");
+            headersBuilder.setHeader(":scheme", uri.getScheme());
+            headersBuilder.setHeader(":authority", uri.getAuthority());
+            headersBuilder.setHeader(":path", uri.getPath());
+            for (Map.Entry<String,List<String>> entry : headers.map().entrySet()) {
+                for (String value : entry.getValue())
+                    headersBuilder.addHeader(entry.getKey(), value);
+            }
+            HttpHeaders combinedHeaders = headersBuilder.build();
+            OutgoingPushPromise pp = new OutgoingPushPromise(streamid, uri, combinedHeaders, content);
+            // Indicates to the client that a continuation should be expected
+            pp.setFlag(0x0);
+            try {
+                conn.outputQ.put(pp);
+                // writeLoop will spin up thread to read the InputStream
+            } catch (IOException ex) {
+                System.err.println("TestServer: pushPromise exception: " + ex);
+            }
+        }
+    }
+
+    static class Http2PushPromiseContinuationExchangeImpl extends Http2TestExchangeImpl {
 
         HttpHeadersBuilder pushPromiseHeadersBuilder;
         List<ContinuationFrame> cfs;
 
-        Http2LPPTestExchangeImpl(int streamid, String method, HttpHeaders reqheaders,
-                                 HttpHeadersBuilder rspheadersBuilder, URI uri, InputStream is,
-                                 SSLSession sslSession, BodyOutputStream os,
-                                 Http2TestServerConnection conn, boolean pushAllowed) {
+        Http2PushPromiseContinuationExchangeImpl(int streamid, String method, HttpHeaders reqheaders,
+                                                 HttpHeadersBuilder rspheadersBuilder, URI uri, InputStream is,
+                                                 SSLSession sslSession, BodyOutputStream os,
+                                                 Http2TestServerConnection conn, boolean pushAllowed) {
             super(streamid, method, reqheaders, rspheadersBuilder, uri, is, sslSession, os, conn, pushAllowed);
         }
 
@@ -248,18 +305,15 @@ public void serverPush(URI uri, HttpHeaders headers, InputStream content) {
             HttpHeaders pushPromiseHeaders = pushPromiseHeadersBuilder.build();
             testHeaders = testHeadersBuilder.build();
             // Create the Push Promise Frame
-            OutgoingPushPromise pp = new OutgoingPushPromise(streamid, uri, pushPromiseHeaders, content);
+            OutgoingPushPromise pp = new OutgoingPushPromise(streamid, uri, pushPromiseHeaders, content, cfs);
+
             // Indicates to the client that a continuation should be expected
             pp.setFlag(0x0);
 
             try {
                 // Schedule push promise and continuation for sending
                 conn.outputQ.put(pp);
                 System.err.println("Server: Scheduled a Push Promise to Send");
-                for (ContinuationFrame cf : cfs) {
-                    conn.outputQ.put(cf);
-                    System.err.println("Server: Scheduled a Continuation to Send");
-                }
             } catch (IOException ex) {
                 System.err.println("Server: pushPromise exception: " + ex);
             }