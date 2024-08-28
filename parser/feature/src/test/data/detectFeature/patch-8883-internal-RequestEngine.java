@@ -302,8 +302,8 @@ static void setFlushInterval(long millis) {
         boolean needNotify = interval < flushInterval;
         flushInterval = interval;
         if (needNotify) {
-            synchronized (JVM.FILE_DELTA_CHANGE) {
-                JVM.FILE_DELTA_CHANGE.notifyAll();
+            synchronized (JVM.CHUNK_ROTATION_MONITOR) {
+                JVM.CHUNK_ROTATION_MONITOR.notifyAll();
             }
         }
     }