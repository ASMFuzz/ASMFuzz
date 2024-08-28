@@ -38,8 +38,6 @@
 import java.util.concurrent.CompletableFuture;
 import java.util.concurrent.TimeUnit;
 import java.util.concurrent.TimeoutException;
-import static java.net.http.HttpClient.Builder.NO_PROXY;
-import static java.net.http.HttpClient.newBuilder;
 
 public class PendingBinaryPongClose extends PendingOperations {
 
@@ -62,7 +60,7 @@ public void pendingBinaryPongClose(boolean last) throws Exception {
                 System.out.printf("begin cycle #%s at %s%n", i, start);
                 cfBinary = webSocket.sendBinary(data, last);
                 try {
-                    cfBinary.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfBinary.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -76,17 +74,16 @@ public void pendingBinaryPongClose(boolean last) throws Exception {
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), true));
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), false));
             cfPong = webSocket.sendPong(ByteBuffer.allocate(125));
-            assertHangs(cfPong);
             assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
             assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
             cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-            assertHangs(cfClose);
+            assertAllHang(cfPong, cfClose);
             assertNotDone(cfBinary);
+            webSocket.abort();
+            assertFails(IOE, cfBinary);
+            assertFails(IOE, cfPong);
+            assertFails(IOE, cfClose);
             return null;
         }, () -> cfBinary.isDone());
-        webSocket.abort();
-        assertFails(IOE, cfBinary);
-        assertFails(IOE, cfPong);
-        assertFails(IOE, cfClose);
     }
 }