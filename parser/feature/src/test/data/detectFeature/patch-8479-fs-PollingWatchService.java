@@ -61,6 +61,11 @@
 class PollingWatchService
     extends AbstractWatchService
 {
+    // Wait between polling thread creation and first poll (seconds)
+    private static final int POLLING_INIT_DELAY = 1;
+    // Default time between polls (seconds)
+    private static final int DEFAULT_POLLING_INTERVAL = 2;
+
     // map of registrations
     private final Map<Object, PollingWatchKey> map = new HashMap<>();
 
@@ -115,7 +120,7 @@ WatchKey register(final Path path,
             throw new IllegalArgumentException("No events to register");
 
         // Extended modifiers may be used to specify the sensitivity level
-        int sensitivity = 10;
+        int sensitivity = DEFAULT_POLLING_INTERVAL;
         if (modifiers.length > 0) {
             for (WatchEvent.Modifier modifier: modifiers) {
                 if (modifier == null)
@@ -247,6 +252,7 @@ void update(long lastModified, int tickCount) {
      * directory and queue keys when entries are added, modified, or deleted.
      */
     private class PollingWatchKey extends AbstractWatchKey {
+
         private final Object fileKey;
 
         // current event set
@@ -305,10 +311,10 @@ void enable(Set<? extends WatchEvent.Kind<?>> events, long period) {
                 // update the events
                 this.events = events;
 
-                // create the periodic task
+                // create the periodic task with initialDelay set to the specified constant
                 Runnable thunk = new Runnable() { public void run() { poll(); }};
                 this.poller = scheduledExecutor
-                    .scheduleAtFixedRate(thunk, period, period, TimeUnit.SECONDS);
+                    .scheduleAtFixedRate(thunk, POLLING_INIT_DELAY, period, TimeUnit.SECONDS);
             }
         }
 