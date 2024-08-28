@@ -713,8 +713,12 @@ public void dumpStopped(WriteableUserPath userPath) throws IOException {
         synchronized (recorder) {
                 userPath.doPrivilegedIO(() -> {
                     try (ChunksChannel cc = new ChunksChannel(chunks); FileChannel fc = FileChannel.open(userPath.getReal(), StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
-                        cc.transferTo(fc);
-                        fc.force(true);
+                        long bytes = cc.transferTo(fc);
+                        Logger.log(LogTag.JFR, LogLevel.INFO, "Transferred " + bytes + " bytes from the disk repository");
+                        // No need to force if no data was transferred, which avoids IOException when device is /dev/null
+                        if (bytes != 0) {
+                            fc.force(true);
+                        }
                     }
                     return null;
                 });