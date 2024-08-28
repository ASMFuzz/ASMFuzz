@@ -541,9 +541,9 @@ public void force(boolean metaData) throws IOException {
     }
 
     // Assume at first that the underlying kernel supports sendfile();
-    // set this to true if we find out later that it doesn't
+    // set this to false if we find out later that it doesn't
     //
-    private static volatile boolean transferToNotSupported;
+    private static volatile boolean transferSupported = true;
 
     // Assume that the underlying kernel sendfile() will work if the target
     // fd is a pipe; set this to false if we find out later that it doesn't
@@ -587,7 +587,7 @@ private long transferToDirectlyInternal(long position, int icount,
             }
             if (n == IOStatus.UNSUPPORTED) {
                 // Don't bother trying again
-                transferToNotSupported = true;
+                transferSupported = false;
                 return IOStatus.UNSUPPORTED;
             }
             return IOStatus.normalize(n);
@@ -601,7 +601,7 @@ private long transferToDirectly(long position, int icount,
                                     WritableByteChannel target)
         throws IOException
     {
-        if (transferToNotSupported)
+        if (!transferSupported)
             return IOStatus.UNSUPPORTED;
 
         FileDescriptor targetFD = null;
@@ -646,9 +646,8 @@ private long transferToDirectly(long position, int icount,
     }
 
     // Size threshold above which to use a mapped buffer;
-    // transferToArbitraryChannel() and transferFromArbitraryChannel()
-    // are faster for smaller transfers
-    private static final long MAPPED_TRANSFER_THRESHOLD = 16L*1024L;
+    // transferToArbitraryChannel() is faster for smaller transfers
+    private static final long TRUSTED_TRANSFER_THRESHOLD = 16L*1024L;
 
     // Maximum size to map when using a mapped buffer
     private static final long MAPPED_TRANSFER_SIZE = 8L*1024L*1024L;
@@ -657,7 +656,7 @@ private long transferToTrustedChannel(long position, long count,
                                           WritableByteChannel target)
         throws IOException
     {
-        if (count < MAPPED_TRANSFER_THRESHOLD)
+        if (count < TRUSTED_TRANSFER_THRESHOLD)
             return IOStatus.UNSUPPORTED_CASE;
 
         boolean isSelChImpl = (target instanceof SelChImpl);
@@ -782,66 +781,12 @@ public long transferTo(long position, long count,
         return transferToArbitraryChannel(position, count, target);
     }
 
-    // Assume at first that the underlying kernel supports copy_file_range();
-    // set this to true if we find out later that it doesn't
-    //
-    private static volatile boolean transferFromNotSupported;
-
-    private long transferFromDirectlyInternal(FileDescriptor srcFD,
-                                              long position, long count)
-        throws IOException
-    {
-        long n = -1;
-        int ti = -1;
-        try {
-            beginBlocking();
-            ti = threads.add();
-            if (!isOpen())
-                return -1;
-            do {
-                long comp = Blocker.begin();
-                try {
-                    n = transferFrom0(srcFD, fd, position, count);
-                } finally {
-                    Blocker.end(comp);
-                }
-            } while ((n == IOStatus.INTERRUPTED) && isOpen());
-            if (n == IOStatus.UNSUPPORTED) {
-                // Don't bother trying again
-                transferFromNotSupported = true;
-                return IOStatus.UNSUPPORTED;
-            }
-            return IOStatus.normalize(n);
-        } finally {
-            threads.remove(ti);
-            end (n > -1);
-        }
-    }
-
-    private long transferFromDirectly(FileChannelImpl src,
-                                      long position, long count)
-        throws IOException
-    {
-        if (!src.readable)
-            throw new NonReadableChannelException();
-        if (transferFromNotSupported)
-            return IOStatus.UNSUPPORTED;
-        FileDescriptor srcFD = src.fd;
-        if (srcFD == null)
-            return IOStatus.UNSUPPORTED_CASE;
-
-        return transferFromDirectlyInternal(srcFD, position, count);
-    }
-
     private long transferFromFileChannel(FileChannelImpl src,
                                          long position, long count)
         throws IOException
     {
         if (!src.readable)
             throw new NonReadableChannelException();
-        if (count < MAPPED_TRANSFER_THRESHOLD)
-            return IOStatus.UNSUPPORTED_CASE;
-
         synchronized (src.positionLock) {
             long pos = src.position();
             long max = Math.min(count, src.size() - pos);
@@ -931,10 +876,8 @@ public long transferFrom(ReadableByteChannel src,
             return 0;
 
         if (src instanceof FileChannelImpl fci) {
-            long n;
-            if ((n = transferFromDirectly(fci, position, count)) >= 0)
-                return n;
-            if ((n = transferFromFileChannel(fci, position, count)) >= 0)
+            long n = transferFromFileChannel(fci, position, count);
+            if (n >= 0)
                 return n;
         }
 
@@ -1568,10 +1511,6 @@ private native long map0(int prot, long position, long length, boolean isSync)
     private static native long transferTo0(FileDescriptor src, long position,
                                            long count, FileDescriptor dst);
 
-    private static native long transferFrom0(FileDescriptor src,
-                                             FileDescriptor dst,
-                                             long position, long count);
-
     // Retrieves the maximum size of a transfer
     private static native int maxDirectTransferSize0();
 