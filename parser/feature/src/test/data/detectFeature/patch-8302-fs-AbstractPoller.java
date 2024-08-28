@@ -105,7 +105,7 @@ final WatchKey register(Path dir,
         // validate arguments before request to poller
         if (dir == null)
             throw new NullPointerException();
-        Set<WatchEvent.Kind<?>> eventSet = new HashSet<>(events.length);
+        Set<WatchEvent.Kind<?>> eventSet = HashSet.newHashSet(events.length);
         for (WatchEvent.Kind<?> event: events) {
             // standard events
             if (event == StandardWatchEventKinds.ENTRY_CREATE ||