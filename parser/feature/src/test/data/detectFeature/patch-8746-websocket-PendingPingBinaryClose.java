@@ -62,7 +62,7 @@ public void pendingPingBinaryClose(boolean last) throws Exception {
                 System.out.printf("begin cycle #%s at %s%n", i, start);
                 cfPing = webSocket.sendPing(data);
                 try {
-                    cfPing.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfPing.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -74,15 +74,20 @@ public void pendingPingBinaryClose(boolean last) throws Exception {
             assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
             assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
             cfBinary = webSocket.sendBinary(ByteBuffer.allocate(4), last);
-            assertHangs(cfBinary);
             cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-            assertHangs(cfClose);
+            assertAllHang(cfBinary, cfClose);
             assertNotDone(cfPing);
+            webSocket.abort();
+            assertFails(IOE, cfPing);
+            assertFails(IOE, cfBinary);
+            assertFails(IOE, cfClose);
             return null;
         }, () -> cfPing.isDone());
-        webSocket.abort();
-        assertFails(IOE, cfPing);
-        assertFails(IOE, cfBinary);
-        assertFails(IOE, cfClose);
+    }
+
+    @Override
+    long initialWaitSec() {
+        // Some Windows machines increase buffer size after 1-2 seconds
+        return isWindows() ? 3 : 1;
     }
 }