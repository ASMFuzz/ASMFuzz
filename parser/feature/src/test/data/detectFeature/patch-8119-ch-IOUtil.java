@@ -86,6 +86,8 @@ static int write(FileDescriptor fd, ByteBuffer src, long position,
         int lim = src.limit();
         assert (pos <= lim);
         int rem = (pos <= lim ? lim - pos : 0);
+        if(rem == 0)
+            return 0;
         ByteBuffer bb;
         if (directIO) {
             Util.checkRemainingBufferSizeAligned(rem, alignment);
@@ -126,9 +128,9 @@ private static int writeFromNativeBuffer(FileDescriptor fd, ByteBuffer bb,
             Util.checkRemainingBufferSizeAligned(rem, alignment);
         }
 
-        int written = 0;
         if (rem == 0)
             return 0;
+        int written = 0;
         var handle = acquireScope(bb, async);
         try {
             if (position != -1) {