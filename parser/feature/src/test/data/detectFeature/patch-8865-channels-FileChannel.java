@@ -1022,8 +1022,10 @@ public abstract MappedByteBuffer map(MapMode mode, long position, long size)
      *
      * @throws IllegalStateException
      *         If the {@code session} is not
-     *         {@linkplain MemorySession#isAlive() alive}, or if access occurs
-     *         from a thread other than the thread
+     *         {@linkplain MemorySession#isAlive() alive}.
+     *
+     * @throws WrongThreadException
+     *         If this method is called from a thread other than the thread
      *         {@linkplain MemorySession#ownerThread() owning} the
      *         {@code session}.
      *