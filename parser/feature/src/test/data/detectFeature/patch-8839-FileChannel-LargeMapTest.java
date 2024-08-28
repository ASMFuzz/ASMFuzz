@@ -61,7 +61,7 @@ public static void main(String[] args) throws IOException {
         ByteBuffer bb = ByteBuffer.allocateDirect(BUFSIZ);
 
         try (FileChannel fc = FileChannel.open(p, READ, WRITE);) {
-            MemorySegment mbb = MemorySegment.ofByteBuffer(bb);
+            MemorySegment mbb = MemorySegment.ofBuffer(bb);
             MemorySegment mappedMemorySegment =
                 fc.map(FileChannel.MapMode.READ_WRITE, 0, p.toFile().length(),
                        MemorySession.openImplicit());