@@ -60,7 +60,7 @@ public void pendingBinaryPingClose(boolean last) throws Exception {
                 System.out.printf("begin cycle #%s at %s%n", i, start);
                 cfBinary = webSocket.sendBinary(data, last);
                 try {
-                    cfBinary.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfBinary.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -74,17 +74,16 @@ public void pendingBinaryPingClose(boolean last) throws Exception {
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), true));
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), false));
             cfPing = webSocket.sendPing(ByteBuffer.allocate(125));
-            assertHangs(cfPing);
             assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
             assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
             cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-            assertHangs(cfClose);
+            assertAllHang(cfPing, cfClose);
             assertNotDone(cfBinary);
+            webSocket.abort();
+            assertFails(IOE, cfBinary);
+            assertFails(IOE, cfPing);
+            assertFails(IOE, cfClose);
             return null;
         }, () -> cfBinary.isDone());
-        webSocket.abort();
-        assertFails(IOE, cfBinary);
-        assertFails(IOE, cfPing);
-        assertFails(IOE, cfClose);
     }
 }