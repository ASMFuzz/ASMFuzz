@@ -166,15 +166,19 @@ static <Z extends Buffer> void checkBytes(MemorySegment base, SequenceLayout lay
             MemorySegment resizedSegment = base.asSlice(i * elemSize, limit * elemSize);
             ByteBuffer bb = resizedSegment.asByteBuffer();
             Z z = bufFactory.apply(bb);
+            MemorySegment segmentBufferView = MemorySegment.ofBuffer(z);
             for (long j = i ; j < limit ; j++) {
                 Object handleValue = handleExtractor.apply(resizedSegment, j - i);
                 Object bufferValue = bufferExtractor.apply(z);
+                Object handleViewValue = handleExtractor.apply(segmentBufferView, j - i);
                 if (handleValue instanceof Number) {
                     assertEquals(((Number)handleValue).longValue(), j);
                     assertEquals(((Number)bufferValue).longValue(), j);
+                    assertEquals(((Number)handleViewValue).longValue(), j);
                 } else {
                     assertEquals((long)(char)handleValue, j);
                     assertEquals((long)(char)bufferValue, j);
+                    assertEquals((long)(char)handleViewValue, j);
                 }
             }
         }
@@ -210,7 +214,7 @@ public void testChannel() throws Throwable {
         //write to channel
         try (FileChannel channel = FileChannel.open(f.toPath(), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
             withMappedBuffer(channel, FileChannel.MapMode.READ_WRITE, 0, tuples.byteSize(), mbb -> {
-                MemorySegment segment = MemorySegment.ofByteBuffer(mbb);
+                MemorySegment segment = MemorySegment.ofBuffer(mbb);
                 initTuples(segment, tuples.elementCount());
                 mbb.force();
             });
@@ -219,7 +223,7 @@ public void testChannel() throws Throwable {
         //read from channel
         try (FileChannel channel = FileChannel.open(f.toPath(), StandardOpenOption.READ)) {
             withMappedBuffer(channel, FileChannel.MapMode.READ_ONLY, 0, tuples.byteSize(), mbb -> {
-                MemorySegment segment = MemorySegment.ofByteBuffer(mbb);
+                MemorySegment segment = MemorySegment.ofBuffer(mbb);
                 checkTuples(segment, mbb, tuples.elementCount());
             });
         }
@@ -450,7 +454,7 @@ public void testResizeHeap(Consumer<MemorySegment> checker, Consumer<MemorySegme
     public void testResizeBuffer(Consumer<MemorySegment> checker, Consumer<MemorySegment> initializer, SequenceLayout seq) {
         checkByteArrayAlignment(seq.elementLayout());
         int capacity = (int)seq.byteSize();
-        MemorySegment base = MemorySegment.ofByteBuffer(ByteBuffer.wrap(new byte[capacity]));
+        MemorySegment base = MemorySegment.ofBuffer(ByteBuffer.wrap(new byte[capacity]));
         initializer.accept(base);
         checker.accept(base);
     }
@@ -462,7 +466,7 @@ public void testResizeRoundtripHeap(Consumer<MemorySegment> checker, Consumer<Me
         byte[] arr = new byte[capacity];
         MemorySegment segment = MemorySegment.ofArray(arr);
         initializer.accept(segment);
-        MemorySegment second = MemorySegment.ofByteBuffer(segment.asByteBuffer());
+        MemorySegment second = MemorySegment.ofBuffer(segment.asByteBuffer());
         checker.accept(second);
     }
 
@@ -471,7 +475,7 @@ public void testResizeRoundtripNative(Consumer<MemorySegment> checker, Consumer<
         try (MemorySession session = MemorySession.openConfined()) {
             MemorySegment segment = MemorySegment.allocateNative(seq, session);
             initializer.accept(segment);
-            MemorySegment second = MemorySegment.ofByteBuffer(segment.asByteBuffer());
+            MemorySegment second = MemorySegment.ofBuffer(segment.asByteBuffer());
             checker.accept(second);
         }
     }
@@ -607,21 +611,21 @@ public void testCopyNativeToHeap(Consumer<MemorySegment> checker, Consumer<Memor
     public void testDefaultAccessModesOfBuffer() {
         ByteBuffer rwBuffer = ByteBuffer.wrap(new byte[4]);
         {
-            MemorySegment segment = MemorySegment.ofByteBuffer(rwBuffer);
+            MemorySegment segment = MemorySegment.ofBuffer(rwBuffer);
             assertFalse(segment.isReadOnly());
         }
 
         {
             ByteBuffer roBuffer = rwBuffer.asReadOnlyBuffer();
-            MemorySegment segment = MemorySegment.ofByteBuffer(roBuffer);
+            MemorySegment segment = MemorySegment.ofBuffer(roBuffer);
             assertTrue(segment.isReadOnly());
         }
     }
 
     @Test
     public void testOfBufferScopeReachable() throws InterruptedException {
         ByteBuffer buffer = ByteBuffer.allocateDirect(1000);
-        MemorySegment segment = MemorySegment.ofByteBuffer(buffer);
+        MemorySegment segment = MemorySegment.ofBuffer(buffer);
         try {
             AtomicBoolean reachable = new AtomicBoolean(true);
             Cleaner.create().register(buffer, () -> {
@@ -642,13 +646,13 @@ public void testOfBufferScopeReachable() throws InterruptedException {
 
     @Test(dataProvider="bufferSources")
     public void testBufferToSegment(ByteBuffer bb, Predicate<MemorySegment> segmentChecker) {
-        MemorySegment segment = MemorySegment.ofByteBuffer(bb);
+        MemorySegment segment = MemorySegment.ofBuffer(bb);
         assertEquals(segment.isReadOnly(), bb.isReadOnly());
         assertTrue(segmentChecker.test(segment));
         assertTrue(segmentChecker.test(segment.asSlice(0, segment.byteSize())));
         assertEquals(bb.capacity(), segment.byteSize());
         //another round trip
-        segment = MemorySegment.ofByteBuffer(segment.asByteBuffer());
+        segment = MemorySegment.ofBuffer(segment.asByteBuffer());
         assertEquals(segment.isReadOnly(), bb.isReadOnly());
         assertTrue(segmentChecker.test(segment));
         assertTrue(segmentChecker.test(segment.asSlice(0, segment.byteSize())));
@@ -657,7 +661,7 @@ public void testBufferToSegment(ByteBuffer bb, Predicate<MemorySegment> segmentC
 
     @Test(dataProvider="bufferSources")
     public void bufferProperties(ByteBuffer bb, Predicate<MemorySegment> _unused) {
-        MemorySegment segment = MemorySegment.ofByteBuffer(bb);
+        MemorySegment segment = MemorySegment.ofBuffer(bb);
         ByteBuffer buffer = segment.asByteBuffer();
         assertEquals(buffer.position(), 0);
         assertEquals(buffer.capacity(), segment.byteSize());
@@ -669,15 +673,15 @@ public void testRoundTripAccess() {
         try (MemorySession session = MemorySession.openConfined()) {
             MemorySegment ms = MemorySegment.allocateNative(4, 1, session);
             MemorySegment msNoAccess = ms.asReadOnly();
-            MemorySegment msRoundTrip = MemorySegment.ofByteBuffer(msNoAccess.asByteBuffer());
+            MemorySegment msRoundTrip = MemorySegment.ofBuffer(msNoAccess.asByteBuffer());
             assertEquals(msNoAccess.isReadOnly(), msRoundTrip.isReadOnly());
         }
     }
 
     @Test(expectedExceptions = IllegalStateException.class)
     public void testDeadAccessOnClosedBufferSegment() {
         MemorySegment s1 = MemorySegment.allocateNative(JAVA_INT, MemorySession.openConfined());
-        MemorySegment s2 = MemorySegment.ofByteBuffer(s1.asByteBuffer());
+        MemorySegment s2 = MemorySegment.ofBuffer(s1.asByteBuffer());
 
         // memory freed
         s1.session().close();