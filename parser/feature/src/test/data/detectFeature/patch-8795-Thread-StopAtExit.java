@@ -72,7 +72,30 @@ public static void main(String[] args) {
                 usage();
             }
         }
+        test(timeMax);
+
+        // Fire-up deamon that just creates new threads. This generates contention on
+        // Threads_lock while worker tries to exit, creating more places where target
+        // can be seen as handshake safe.
+        Thread threadCreator = new Thread() {
+            @Override
+            public void run() {
+                while (true) {
+                    Thread dummyThread = new Thread(() -> {});
+                    dummyThread.start();
+                    try {
+                        dummyThread.join();
+                    } catch(InterruptedException ie) {
+                    }
+                }
+            }
+        };
+        threadCreator.setDaemon(true);
+        threadCreator.start();
+        test(timeMax);
+    }
 
+    public static void test(int timeMax) {
         System.out.println("About to execute for " + timeMax + " seconds.");
 
         long count = 0;