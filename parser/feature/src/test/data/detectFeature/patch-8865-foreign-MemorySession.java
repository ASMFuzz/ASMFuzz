@@ -60,7 +60,7 @@
  * they are assigned an {@linkplain #ownerThread() owner thread}, typically the thread which initiated the creation operation.
  * After creating a confined memory session, only the owner thread will be allowed to directly manipulate the resources
  * associated with this memory session. Any attempt to perform resource access from a thread other than the
- * owner thread will fail with {@link IllegalStateException}.
+ * owner thread will fail with {@link WrongThreadException}.
  * <p>
  * Shared memory sessions, on the other hand, have no owner thread; as such, resources associated with shared memory sessions
  * can be accessed by multiple threads. This might be useful when multiple threads need to access the same resource concurrently
@@ -157,8 +157,9 @@ public sealed interface MemorySession extends AutoCloseable, SegmentAllocator pe
      * @apiNote The provided action should not keep a strong reference to this memory session, so that implicitly
      * closed sessions can be handled correctly by a {@link Cleaner} instance.
      * @param runnable the custom cleanup action to be associated with this memory session.
-     * @throws IllegalStateException if this memory session is not {@linkplain #isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain #ownerThread() owning} this memory session.
+     * @throws IllegalStateException if this memory session is not {@linkplain #isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain #ownerThread() owning} this memory session.
      */
     void addCloseAction(Runnable runnable);
 
@@ -174,9 +175,10 @@ public sealed interface MemorySession extends AutoCloseable, SegmentAllocator pe
      *
      * @see MemorySession#isAlive()
      *
-     * @throws IllegalStateException if this memory session is not {@linkplain #isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain #ownerThread() owning} this memory session.
+     * @throws IllegalStateException if this memory session is not {@linkplain #isAlive() alive}.
      * @throws IllegalStateException if this session is {@linkplain #whileAlive(Runnable) kept alive} by another client.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain #ownerThread() owning} this memory session.
      * @throws UnsupportedOperationException if this memory session is not {@linkplain #isCloseable() closeable}.
      */
     void close();
@@ -215,8 +217,9 @@ public sealed interface MemorySession extends AutoCloseable, SegmentAllocator pe
      * MemorySegment.allocateNative(size, align, this);
      * }
      *
-     * @throws IllegalStateException if this memory session is not {@linkplain #isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain #ownerThread() owning} this memory session.
+     * @throws IllegalStateException if this memory session is not {@linkplain #isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain #ownerThread() owning} this memory session.
      * @return a new native segment, associated with this session.
      */
     @Override