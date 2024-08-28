@@ -41,10 +41,11 @@ public class PendingOperations {
     static final Class<IllegalStateException> ISE = IllegalStateException.class;
     static final Class<IOException> IOE = IOException.class;
     // Time after which we deem that the local send buffer and remote
-    // receive buffer must be full. This has been heuristically determined.
+    // receive buffer must be full.
     // At the time of writing, using anything <= 5s on Mac will make the
     // tests fail intermittently.
     static final long MAX_WAIT_SEC = 10; // seconds.
+    long waitSec;
 
     DummyWebSocketServer server;
     WebSocket webSocket;
@@ -63,6 +64,12 @@ public void cleanup() {
         webSocket.abort();
     }
 
+    /* shortcut */
+    static void assertAllHang(CompletableFuture<?> cf1,
+                              CompletableFuture<?> cf2) {
+        assertHangs(CompletableFuture.anyOf(cf1, cf2));
+    }
+
     /* shortcut */
     static void assertHangs(CompletionStage<?> stage) {
         Support.assertHangs(stage);
@@ -99,6 +106,11 @@ void repeatable(Callable<Void> callable,
         int iterations = 0;
         do {
             iterations++;
+            if (iterations == 1) {
+                waitSec = initialWaitSec();
+            } else {
+                waitSec = MAX_WAIT_SEC;
+            }
             System.out.println("--- iteration " + iterations + " ---");
             try {
                 callable.call();
@@ -125,4 +137,8 @@ void repeatable(Callable<Void> callable,
             }
         } while (iterations <= ITERATIONS);
     }
+
+    long initialWaitSec() {
+        return 1;
+    }
 }