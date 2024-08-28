@@ -29,6 +29,7 @@
 import java.io.UncheckedIOException;
 import java.lang.reflect.Array;
 import java.lang.invoke.MethodHandles;
+import java.nio.Buffer;
 import java.nio.ByteBuffer;
 import java.nio.ByteOrder;
 import java.nio.channels.FileChannel;
@@ -62,9 +63,9 @@
  * a file into main memory ({@code mmap}); the contents of a mapped memory segments can be {@linkplain #force() persisted} and
  * {@linkplain #load() loaded} to and from the underlying memory-mapped file;</li>
  *     <li>{@linkplain MemorySegment#ofArray(int[]) array segments}, wrapping an existing, heap-allocated Java array; and</li>
- *     <li>{@linkplain MemorySegment#ofByteBuffer(ByteBuffer) buffer segments}, wrapping an existing {@link ByteBuffer} instance;
+ *     <li>{@linkplain MemorySegment#ofBuffer(Buffer) buffer segments}, wrapping an existing {@link Buffer} instance;
  * buffer memory segments might be backed by either off-heap memory or on-heap memory, depending on the characteristics of the
- * wrapped byte buffer instance. For instance, a buffer memory segment obtained from a byte buffer created with the
+ * wrapped buffer instance. For instance, a buffer memory segment obtained from a byte buffer created with the
  * {@link ByteBuffer#allocateDirect(int)} method will be backed by off-heap memory.</li>
  * </ul>
  *
@@ -84,8 +85,11 @@
  * session; that is, if the segment is associated with a shared session, it can be accessed by multiple threads;
  * if it is associated with a confined session, it can only be accessed by the thread which owns the memory session.
  * <p>
- * Heap and buffer segments are always associated with a <em>global</em>, shared memory session. This session cannot be closed,
- * and segments associated with it can be considered as <em>always alive</em>.
+ * Heap segments are always associated with the {@linkplain MemorySession#global() global} memory session.
+ * This session cannot be closed, and segments associated with it can be considered as <em>always alive</em>.
+ * Buffer segments are typically associated with the global memory session, with one exception: buffer segments created
+ * from byte buffer instances obtained calling the {@link #asByteBuffer()} method on a memory segment {@code S}
+ * are associated with the same memory session as {@code S}.
  *
  * <h2><a id = "segment-deref">Dereferencing memory segments</a></h2>
  *
@@ -344,7 +348,7 @@ default MemorySegment asSlice(long offset) {
     /**
      * Returns {@code true} if this segment is a native segment. A native memory segment is
      * created using the {@link #allocateNative(long, MemorySession)} (and related) factory, or a buffer segment
-     * derived from a {@linkplain ByteBuffer#allocateDirect(int) direct byte buffer} using the {@link #ofByteBuffer(ByteBuffer)} factory,
+     * derived from a {@linkplain ByteBuffer#allocateDirect(int) direct byte buffer} using the {@link #ofBuffer(Buffer)} factory,
      * or if this is a {@linkplain #isMapped() mapped} segment.
      * @return {@code true} if this segment is native segment.
      */
@@ -353,7 +357,7 @@ default MemorySegment asSlice(long offset) {
     /**
      * Returns {@code true} if this segment is a mapped segment. A mapped memory segment is
      * created using the {@link FileChannel#map(FileChannel.MapMode, long, long, MemorySession)} factory, or a buffer segment
-     * derived from a {@link java.nio.MappedByteBuffer} using the {@link #ofByteBuffer(ByteBuffer)} factory.
+     * derived from a {@link java.nio.MappedByteBuffer} using the {@link #ofBuffer(Buffer)} factory.
      * @return {@code true} if this segment is a mapped segment.
      */
     boolean isMapped();
@@ -707,9 +711,8 @@ default void setUtf8String(long offset, String str) {
 
 
     /**
-     * Creates a buffer memory segment that models the memory associated with the given byte
-     * buffer. The segment starts relative to the buffer's position (inclusive)
-     * and ends relative to the buffer's limit (exclusive).
+     * Creates a buffer memory segment that models the memory associated with the given {@link Buffer} instance.
+     * The segment starts relative to the buffer's position (inclusive) and ends relative to the buffer's limit (exclusive).
      * <p>
      * If the buffer is {@linkplain ByteBuffer#isReadOnly() read-only}, the resulting segment will also be
      * {@linkplain ByteBuffer#isReadOnly() read-only}. The memory session associated with this segment can either be the
@@ -718,11 +721,11 @@ default void setUtf8String(long offset, String str) {
      * <p>
      * The resulting memory segment keeps a reference to the backing buffer, keeping it <em>reachable</em>.
      *
-     * @param bb the byte buffer backing the buffer memory segment.
+     * @param buffer the buffer instance backing the buffer memory segment.
      * @return a buffer memory segment.
      */
-    static MemorySegment ofByteBuffer(ByteBuffer bb) {
-        return AbstractMemorySegmentImpl.ofBuffer(bb);
+    static MemorySegment ofBuffer(Buffer buffer) {
+        return AbstractMemorySegmentImpl.ofBuffer(buffer);
     }
 
     /**