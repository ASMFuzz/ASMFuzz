@@ -1239,7 +1239,7 @@ private Unmapper mapInternal(MapMode mode, long position, long size, int prot, b
                 mapSize = size + pagePosition;
                 try {
                     // If map0 did not throw an exception, the address is valid
-                    addr = map0(prot, mapPosition, mapSize, isSync);
+                    addr = map0(fd, prot, mapPosition, mapSize, isSync);
                 } catch (OutOfMemoryError x) {
                     // An OutOfMemoryError may indicate that we've exhausted
                     // memory so force gc and re-attempt map
@@ -1250,7 +1250,7 @@ private Unmapper mapInternal(MapMode mode, long position, long size, int prot, b
                         Thread.currentThread().interrupt();
                     }
                     try {
-                        addr = map0(prot, mapPosition, mapSize, isSync);
+                        addr = map0(fd, prot, mapPosition, mapSize, isSync);
                     } catch (OutOfMemoryError y) {
                         // After a second OOME, fail
                         throw new IOException("Map failed", y);
@@ -1500,7 +1500,8 @@ void release(FileLockImpl fli) throws IOException {
     // -- Native methods --
 
     // Creates a new mapping
-    private native long map0(int prot, long position, long length, boolean isSync)
+    private native long map0(FileDescriptor fd, int prot, long position,
+                             long length, boolean isSync)
         throws IOException;
 
     // Removes an existing mapping
@@ -1514,12 +1515,12 @@ private static native long transferTo0(FileDescriptor src, long position,
     // Retrieves the maximum size of a transfer
     private static native int maxDirectTransferSize0();
 
-    // Caches fieldIDs
-    private static native long initIDs();
+    // Retrieves allocation granularity
+    private static native long allocationGranularity0();
 
     static {
         IOUtil.load();
-        allocationGranularity = initIDs();
+        allocationGranularity = allocationGranularity0();
         MAX_DIRECT_TRANSFER_SIZE = maxDirectTransferSize0();
     }
 }