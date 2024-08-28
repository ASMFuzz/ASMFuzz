@@ -65,39 +65,43 @@ public void pendingPingTextClose(boolean last) throws Exception {
                     if (debug) System.out.printf("begin cycle #%s at %s%n", i, start);
                     cfPing = webSocket.sendPing(data);
                     try {
-                        cfPing.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                        cfPing.get(waitSec, TimeUnit.SECONDS);
                         data.clear();
                     } catch (TimeoutException e) {
                         done = true;
                         System.out.printf("Got expected timeout after %d iterations%n", i);
                         break;
                     } finally {
                         long stop = System.currentTimeMillis();
-                        if (debug || done || (stop - start) > (MAX_WAIT_SEC * 1000L)/2L)
+                        if (debug || done || (stop - start) > (waitSec * 1000L)/2L)
                             System.out.printf("end cycle #%s at %s (%s ms)%n", i, stop, stop - start);
                     }
                 }
                 assertFails(ISE, webSocket.sendPing(ByteBuffer.allocate(125)));
                 assertFails(ISE, webSocket.sendPong(ByteBuffer.allocate(125)));
-                System.out.println("asserting that sendText hangs");
                 cfText = webSocket.sendText("hello", last);
-                assertHangs(cfText);
-                System.out.println("asserting that sendClose hangs");
                 cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-                assertHangs(cfClose);
+                System.out.println("asserting that sendText and sendClose hang");
+                assertAllHang(cfText, cfClose);
                 System.out.println("asserting that cfPing is not completed");
                 assertNotDone(cfPing);
                 System.out.println("finishing");
+                webSocket.abort();
+                assertFails(IOE, cfPing);
+                assertFails(IOE, cfText);
+                assertFails(IOE, cfClose);
                 return null;
             }, () -> cfPing.isDone()); // can't use method ref: cfPing not initialized
-            webSocket.abort();
-            assertFails(IOE, cfPing);
-            assertFails(IOE, cfText);
-            assertFails(IOE, cfClose);
         } catch (Throwable t) {
             System.err.printf("pendingPingTextClose(%s) failed: %s%n", last, t);
             t.printStackTrace();
             throw t;
         }
     }
+
+    @Override
+    long initialWaitSec() {
+        // Some Windows machines increase buffer size after 1-2 seconds
+        return isWindows() ? 3 : 1;
+    }
 }