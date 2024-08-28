@@ -149,25 +149,33 @@ private static void testOnEvent() throws Exception {
     }
 
     private static void testOnEventAfterStart() {
+        log("Entering testOnEventAfterStart()");
         try (RecordingStream r = new RecordingStream()) {
             EventProducer p = new EventProducer();
             p.start();
             Thread addHandler = new Thread(() ->  {
                 r.onEvent(e -> {
                     // Got event, close stream
+                    log("Executing onEvent");
                     r.close();
+                    log("RecordingStream closed");
                 });
             });
             r.onFlush(() ->  {
                 // Only add handler once
                 if (!"started".equals(addHandler.getName()))  {
                     addHandler.setName("started");
+                    log("About to start addHandler thread");
                     addHandler.start();
                 }
             });
+            log("About to start RecordingStream");
             r.start();
+            log("About to kill EventProducer");
             p.kill();
+            log("EventProducer killed");
         }
+        log("Leaving testOnEventAfterStart()");
     }
 
     // Starts recording stream and ensures stream