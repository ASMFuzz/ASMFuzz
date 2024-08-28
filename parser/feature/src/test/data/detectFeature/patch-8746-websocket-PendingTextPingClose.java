@@ -62,7 +62,7 @@ public void pendingTextPingClose(boolean last) throws Exception {
                 cfText = webSocket.sendText(data, last);
                 try {
                     if (!cfText.isDone()) System.gc();
-                    cfText.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfText.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -76,17 +76,16 @@ public void pendingTextPingClose(boolean last) throws Exception {
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), true));
             assertFails(ISE, webSocket.sendBinary(ByteBuffer.allocate(0), false));
             cfPing = webSocket.sendPing(ByteBuffer.allocate(125));
-            assertHangs(cfPing);
             assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
             assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
             cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-            assertHangs(cfClose);
+            assertAllHang(cfPing, cfClose);
             assertNotDone(cfText);
+            webSocket.abort();
+            assertFails(IOE, cfText);
+            assertFails(IOE, cfPing);
+            assertFails(IOE, cfClose);
             return null;
         }, () -> cfText.isDone());
-        webSocket.abort();
-        assertFails(IOE, cfText);
-        assertFails(IOE, cfPing);
-        assertFails(IOE, cfClose);
     }
 }