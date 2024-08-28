@@ -305,7 +305,7 @@ public void testFillThread(Supplier<MemorySegment> segmentSupplier) throws Excep
     public void testFillEmpty() {
         MemorySegment.ofArray(new byte[] { }).fill((byte) 0xFF);
         MemorySegment.ofArray(new byte[2]).asSlice(0, 0).fill((byte) 0xFF);
-        MemorySegment.ofByteBuffer(ByteBuffer.allocateDirect(0)).fill((byte) 0xFF);
+        MemorySegment.ofBuffer(ByteBuffer.allocateDirect(0)).fill((byte) 0xFF);
     }
 
     @Test(dataProvider = "heapFactories")