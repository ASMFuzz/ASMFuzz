@@ -95,7 +95,7 @@ WatchKey register(final Path path,
          throws IOException
     {
         // check events - CCE will be thrown if there are invalid elements
-        final Set<WatchEvent.Kind<?>> eventSet = new HashSet<>(events.length);
+        final Set<WatchEvent.Kind<?>> eventSet = HashSet.newHashSet(events.length);
         for (WatchEvent.Kind<?> event: events) {
             // standard events
             if (event == StandardWatchEventKinds.ENTRY_CREATE ||