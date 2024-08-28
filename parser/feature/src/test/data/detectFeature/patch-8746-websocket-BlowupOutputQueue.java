@@ -57,10 +57,10 @@ public class BlowupOutputQueue extends PendingOperations {
      * utilized and then make sure there won't be any errors caused by that.
      *
      * First, fill the queue with Text messages. Once done, send a Ping message.
-     * At this stage, there are at least 2 messages are in queue. Now, start
+     * At this stage, there are at least 2 messages in queue. Now, start
      * receiving. Received Ping messages will cause automatic Pong replies. When
      * all done, there will be at least 3 messages in the queue. (As at least
-     * the a single Ping has to be replied). Then send a Close message. Now
+     * a single Ping has to be replied). Then send a Close message. Now
      * there are at least 4 messages in the queue. Finally, receive the last
      * message which is a Close message. This will cause an automatic reply with
      * a Close message from the client side. All in all there should be at least
@@ -111,7 +111,7 @@ protected CompletionStage<?> onPing0(WebSocket webSocket,
                 System.out.printf("begin cycle #%s at %s%n", i, start);
                 cfText = webSocket.sendText(data, true);
                 try {
-                    cfText.get(MAX_WAIT_SEC, TimeUnit.SECONDS);
+                    cfText.get(waitSec, TimeUnit.SECONDS);
                     data.clear();
                 } catch (TimeoutException e) {
                     break;
@@ -124,14 +124,14 @@ protected CompletionStage<?> onPing0(WebSocket webSocket,
             webSocket.request(N);
             allButCloseReceived.await();
             webSocket.request(1); // Receive the last message: Close
+            List<MockListener.Invocation> invocations = listener.invocations();
+            cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
+
+            assertFalse(invocations.contains(new MockListener.OnError(webSocket, IOException.class)));
+            assertFalse(cfText.isDone());
+            assertFalse(cfPing.isDone());
+            assertFalse(cfClose.isDone());
             return null;
         }, () -> cfText.isDone());
-        List<MockListener.Invocation> invocations = listener.invocations();
-        cfClose = webSocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
-
-        assertFalse(invocations.contains(new MockListener.OnError(webSocket, IOException.class)));
-        assertFalse(cfText.isDone());
-        assertFalse(cfPing.isDone());
-        assertFalse(cfClose.isDone());
     }
 }