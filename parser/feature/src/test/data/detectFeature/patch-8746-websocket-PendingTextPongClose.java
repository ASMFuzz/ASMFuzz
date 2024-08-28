@@ -61,7 +61,7 @@ public void pendingTextPongClose(boolean last) throws Exception {
                 System.out.printf("begin cycle #%s at %s%n", i, start);
                 cfText = webSocket.sendText(data, last);
                 try {
-                    cfText.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfText.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -75,17 +75,16 @@ public void pendingTextPongClose(boolean last) throws Exception {
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), true));
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), false));
             cfPong = webSocket.sendPong(ByteBuffer.allocate(125));
-            assertHangs(cfPong);
             assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
             assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
             cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-            assertHangs(cfClose);
+            assertAllHang(cfPong, cfClose);
             assertNotDone(cfText);
+            webSocket.abort();
+            assertFails(IOE, cfText);
+            assertFails(IOE, cfPong);
+            assertFails(IOE, cfClose);
             return null;
         }, () -> cfText.isDone());
-        webSocket.abort();
-        assertFails(IOE, cfText);
-        assertFails(IOE, cfPong);
-        assertFails(IOE, cfClose);
     }
 }