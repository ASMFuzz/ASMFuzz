@@ -62,7 +62,7 @@ public void pendingPongTextClose(boolean last) throws Exception {
                 System.out.printf("begin cycle #%s at %s%n", i, start);
                 cfPong = webSocket.sendPong(data);
                 try {
-                    cfPong.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfPong.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -74,15 +74,20 @@ public void pendingPongTextClose(boolean last) throws Exception {
             assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
             assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
             cfText = webSocket.sendText("hello", last);
-            assertHangs(cfText);
             cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-            assertHangs(cfClose);
+            assertAllHang(cfText, cfClose);
             assertNotDone(cfPong);
+            webSocket.abort();
+            assertFails(IOE, cfPong);
+            assertFails(IOE, cfText);
+            assertFails(IOE, cfClose);
             return null;
         }, () -> cfPong.isDone());
-        webSocket.abort();
-        assertFails(IOE, cfPong);
-        assertFails(IOE, cfText);
-        assertFails(IOE, cfClose);
+    }
+
+    @Override
+    long initialWaitSec() {
+        // Some Windows machines increase buffer size after 1-2 seconds
+        return isWindows() ? 3 : 1;
     }
 }