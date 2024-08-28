@@ -626,11 +626,13 @@ final int maxConcurrentServerInitiatedStreams() {
 
     void close() {
         Log.logTrace("Closing HTTP/2 connection: to {0}", connection.address());
-        GoAwayFrame f = new GoAwayFrame(0,
-                                        ErrorFrame.NO_ERROR,
-                                        "Requested by user".getBytes(UTF_8));
-        // TODO: set last stream. For now zero ok.
-        sendFrame(f);
+        if (connection.channel().isOpen()) {
+            GoAwayFrame f = new GoAwayFrame(0,
+                    ErrorFrame.NO_ERROR,
+                    "Requested by user".getBytes(UTF_8));
+            // TODO: set last stream. For now zero ok.
+            sendFrame(f);
+        }
     }
 
     long count;