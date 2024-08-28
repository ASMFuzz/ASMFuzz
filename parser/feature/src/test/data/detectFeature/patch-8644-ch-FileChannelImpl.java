@@ -536,9 +536,9 @@ public void force(boolean metaData) throws IOException {
     }
 
     // Assume at first that the underlying kernel supports sendfile();
-    // set this to false if we find out later that it doesn't
+    // set this to true if we find out later that it doesn't
     //
-    private static volatile boolean transferSupported = true;
+    private static volatile boolean transferToNotSupported;
 
     // Assume that the underlying kernel sendfile() will work if the target
     // fd is a pipe; set this to false if we find out later that it doesn't
@@ -582,7 +582,7 @@ private long transferToDirectlyInternal(long position, int icount,
             }
             if (n == IOStatus.UNSUPPORTED) {
                 // Don't bother trying again
-                transferSupported = false;
+                transferToNotSupported = true;
                 return IOStatus.UNSUPPORTED;
             }
             return IOStatus.normalize(n);
@@ -596,7 +596,7 @@ private long transferToDirectly(long position, int icount,
                                     WritableByteChannel target)
         throws IOException
     {
-        if (!transferSupported)
+        if (transferToNotSupported)
             return IOStatus.UNSUPPORTED;
 
         FileDescriptor targetFD = null;
@@ -641,8 +641,9 @@ private long transferToDirectly(long position, int icount,
     }
 
     // Size threshold above which to use a mapped buffer;
-    // transferToArbitraryChannel() is faster for smaller transfers
-    private static final long TRUSTED_TRANSFER_THRESHOLD = 16L*1024L;
+    // transferToArbitraryChannel() and transferFromArbitraryChannel()
+    // are faster for smaller transfers
+    private static final long MAPPED_TRANSFER_THRESHOLD = 16L*1024L;
 
     // Maximum size to map when using a mapped buffer
     private static final long MAPPED_TRANSFER_SIZE = 8L*1024L*1024L;
@@ -651,7 +652,7 @@ private long transferToTrustedChannel(long position, long count,
                                           WritableByteChannel target)
         throws IOException
     {
-        if (count < TRUSTED_TRANSFER_THRESHOLD)
+        if (count < MAPPED_TRANSFER_THRESHOLD)
             return IOStatus.UNSUPPORTED_CASE;
 
         boolean isSelChImpl = (target instanceof SelChImpl);
@@ -776,12 +777,66 @@ public long transferTo(long position, long count,
         return transferToArbitraryChannel(position, count, target);
     }
 
+    // Assume at first that the underlying kernel supports copy_file_range();
+    // set this to true if we find out later that it doesn't
+    //
+    private static volatile boolean transferFromNotSupported;
+
+    private long transferFromDirectlyInternal(FileDescriptor srcFD,
+                                              long position, long count)
+        throws IOException
+    {
+        long n = -1;
+        int ti = -1;
+        try {
+            beginBlocking();
+            ti = threads.add();
+            if (!isOpen())
+                return -1;
+            do {
+                long comp = Blocker.begin();
+                try {
+                    n = transferFrom0(srcFD, fd, position, count);
+                } finally {
+                    Blocker.end(comp);
+                }
+            } while ((n == IOStatus.INTERRUPTED) && isOpen());
+            if (n == IOStatus.UNSUPPORTED) {
+                // Don't bother trying again
+                transferFromNotSupported = true;
+                return IOStatus.UNSUPPORTED;
+            }
+            return IOStatus.normalize(n);
+        } finally {
+            threads.remove(ti);
+            end (n > -1);
+        }
+    }
+
+    private long transferFromDirectly(FileChannelImpl src,
+                                      long position, long count)
+        throws IOException
+    {
+        if (!src.readable)
+            throw new NonReadableChannelException();
+        if (transferFromNotSupported)
+            return IOStatus.UNSUPPORTED;
+        FileDescriptor srcFD = src.fd;
+        if (srcFD == null)
+            return IOStatus.UNSUPPORTED_CASE;
+
+        return transferFromDirectlyInternal(srcFD, position, count);
+    }
+
     private long transferFromFileChannel(FileChannelImpl src,
                                          long position, long count)
         throws IOException
     {
         if (!src.readable)
             throw new NonReadableChannelException();
+        if (count < MAPPED_TRANSFER_THRESHOLD)
+            return IOStatus.UNSUPPORTED_CASE;
+
         synchronized (src.positionLock) {
             long pos = src.position();
             long max = Math.min(count, src.size() - pos);
@@ -871,8 +926,10 @@ public long transferFrom(ReadableByteChannel src,
             return 0;
 
         if (src instanceof FileChannelImpl fci) {
-            long n = transferFromFileChannel(fci, position, count);
-            if (n >= 0)
+            long n;
+            if ((n = transferFromDirectly(fci, position, count)) >= 0)
+                return n;
+            if ((n = transferFromFileChannel(fci, position, count)) >= 0)
                 return n;
         }
 
@@ -1475,6 +1532,10 @@ private native long map0(int prot, long position, long length, boolean isSync)
     private static native long transferTo0(FileDescriptor src, long position,
                                            long count, FileDescriptor dst);
 
+    private static native long transferFrom0(FileDescriptor src,
+                                             FileDescriptor dst,
+                                             long position, long count);
+
     // Retrieves the maximum size of a transfer
     private static native int maxDirectTransferSize0();
 