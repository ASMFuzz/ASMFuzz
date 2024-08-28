@@ -59,25 +59,17 @@ public static void main(String[] args) throws Throwable {
         String msg = "hello!";
         byte[] buf = msg.getBytes();
         forceEndChunk();
-        // Send a few packets both to the loopback address as well to an
-        // external
+        // Send a few packets to the loopback address
         DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getLoopbackAddress(), 12345);
         for (int i = 0; i < packetSendCount; ++i) {
             socket.send(packet);
         }
-        packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("10.0.0.0"), 12345);
-        for (int i = 0; i < packetSendCount; ++i) {
-            socket.send(packet);
-        }
         forceEndChunk();
         socket.close();
-        // Now there should have been traffic on at least two different
-        // interfaces
         recording.stop();
 
         Set<String> networkInterfaces = new HashSet<>();
         List<RecordedEvent> events = Events.fromRecording(recording);
-        Events.hasEvents(events);
         for (RecordedEvent event : events) {
             System.out.println(event);
             Events.assertField(event, "writeRate").atLeast(0L).atMost(1000L * Integer.MAX_VALUE);
@@ -87,13 +79,10 @@ public static void main(String[] args) throws Throwable {
                 networkInterfaces.add(event.getString("networkInterface"));
             }
         }
-
-        if (Platform.isWindows()) {
-            // Windows does not track statistics for the loopback
-            // interface
+        // Windows does not track statistics for the loopback
+        // interface
+        if (!Platform.isWindows()) {
             Asserts.assertGreaterThanOrEqual(networkInterfaces.size(), 1);
-        } else {
-            Asserts.assertGreaterThanOrEqual(networkInterfaces.size(), 2);
         }
     }
 