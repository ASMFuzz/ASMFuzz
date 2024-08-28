@@ -520,8 +520,8 @@ private boolean isToDisk() {
 
     private void takeNap(long duration) {
         try {
-            synchronized (JVM.FILE_DELTA_CHANGE) {
-                JVM.FILE_DELTA_CHANGE.wait(duration < 10 ? 10 : duration);
+            synchronized (JVM.CHUNK_ROTATION_MONITOR) {
+                JVM.CHUNK_ROTATION_MONITOR.wait(duration < 10 ? 10 : duration);
             }
         } catch (InterruptedException e) {
             // Ignore