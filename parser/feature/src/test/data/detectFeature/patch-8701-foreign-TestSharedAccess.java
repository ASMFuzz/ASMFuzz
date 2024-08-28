@@ -126,7 +126,7 @@ public void testOutsideConfinementThread() throws Throwable {
                 try {
                     ByteBuffer bb = s1.asByteBuffer();
 
-                    MemorySegment s2 = MemorySegment.ofByteBuffer(bb);
+                    MemorySegment s2 = MemorySegment.ofBuffer(bb);
                     a.countDown();
 
                     try {