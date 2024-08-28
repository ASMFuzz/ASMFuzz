@@ -313,7 +313,7 @@ private void processControlQueue() {
      * Task to process events from pollset and dispatch to the channel's
      * onEvent handler.
      *
-     * Events are retreived from pollset in batch and offered to a BlockingQueue
+     * Events are retrieved from pollset in batch and offered to a BlockingQueue
      * where they are consumed by handler threads. A special "NEED_TO_POLL"
      * event is used to signal one consumer to re-poll when all events have
      * been consumed.
@@ -432,7 +432,7 @@ public void run() {
                         continue;
                     }
 
-                    // contine after we processed a control event
+                    // continue after we processed a control event
                     if (ev == CONTINUE_AFTER_CTL_EVENT) {
                         continue;
                     }