@@ -346,8 +346,9 @@ default MemorySegment allocate(long bytesSize) {
      *
      * @param session the memory session associated with the segments allocated by the arena-based allocator.
      * @return a new unbounded arena-based allocator
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static SegmentAllocator newNativeArena(MemorySession session) {
         return newNativeArena(Long.MAX_VALUE, ArenaAllocator.DEFAULT_BLOCK_SIZE, session);
@@ -365,8 +366,9 @@ static SegmentAllocator newNativeArena(MemorySession session) {
      * @param session the memory session associated with the segments allocated by the arena-based allocator.
      * @return a new unbounded arena-based allocator
      * @throws IllegalArgumentException if {@code arenaSize <= 0}.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static SegmentAllocator newNativeArena(long arenaSize, MemorySession session) {
         return newNativeArena(arenaSize, arenaSize, session);
@@ -401,8 +403,9 @@ static SegmentAllocator newNativeArena(long arenaSize, MemorySession session) {
      * @param session the memory session associated with the segments returned by the arena-based allocator.
      * @return a new unbounded arena-based allocator
      * @throws IllegalArgumentException if {@code blockSize <= 0}, if {@code arenaSize <= 0} or if {@code arenaSize < blockSize}.
-     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}, or if access occurs from
-     * a thread other than the thread {@linkplain MemorySession#ownerThread() owning} {@code session}.
+     * @throws IllegalStateException if {@code session} is not {@linkplain MemorySession#isAlive() alive}.
+     * @throws WrongThreadException if this method is called from a thread other than the thread
+     * {@linkplain MemorySession#ownerThread() owning} {@code session}.
      */
     static SegmentAllocator newNativeArena(long arenaSize, long blockSize, MemorySession session) {
         Objects.requireNonNull(session);