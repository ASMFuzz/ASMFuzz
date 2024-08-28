@@ -1023,18 +1023,21 @@ void eventUpdated(AsyncEvent e) throws ClosedChannelException {
 
         // This returns immediately. So caller not allowed to send/receive
         // on connection.
-        synchronized void register(AsyncEvent e) {
-            if (closed) e.abort(selectorClosedException());
-            registrations.add(e);
-            selector.wakeup();
-        }
-
-        synchronized void cancel(SocketChannel e) {
-            SelectionKey key = e.keyFor(selector);
-            if (key != null) {
-                key.cancel();
+        void register(AsyncEvent e) {
+            var closed = this.closed;
+            if (!closed) {
+                synchronized (this) {
+                    closed = this.closed;
+                    if (!closed) {
+                        registrations.add(e);
+                    }
+                }
+            }
+            if (closed) {
+                e.abort(selectorClosedException());
+            } else {
+                selector.wakeup();
             }
-            selector.wakeup();
         }
 
         void wakeupSelector() {
@@ -1083,12 +1086,15 @@ void abort(Throwable t) {
             if (!inSelectorThread) selector.wakeup();
         }
 
-        synchronized void shutdown() {
-            Log.logTrace("{0}: shutting down", getName());
-            if (debug.on()) debug.log("SelectorManager shutting down");
-            closed = true;
+        // Only called by the selector manager thread
+        private void shutdown() {
             try {
-                selector.close();
+                synchronized (this) {
+                    Log.logTrace("{0}: shutting down", getName());
+                    if (debug.on()) debug.log("SelectorManager shutting down");
+                    closed = true;
+                    selector.close();
+                }
             } catch (IOException ignored) {
             } finally {
                 owner.stop();