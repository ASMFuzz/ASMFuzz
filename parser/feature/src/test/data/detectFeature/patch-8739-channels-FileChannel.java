@@ -959,7 +959,8 @@ public String toString() {
      *         If the preconditions on the parameters do not hold
      *
      * @throws UnsupportedOperationException
-     *         If an unsupported map mode is specified
+     *         If an unsupported map mode is specified, or if the implementation
+     *         does not support memory-mapped files
      *
      * @throws IOException
      *         If some other I/O error occurs
@@ -997,6 +998,10 @@ public abstract MappedByteBuffer map(MapMode mode, long position, long size)
      *           of mapped memory associated with the returned mapped memory
      *           segment is unspecified and should not be relied upon.
      *
+     * @implSpec The {@code map(MapMode, long, long, MemorySession)} method of
+     *           {@code FileChannel} always throws an
+     *           {@code UnsupportedOperationException}.
+     *
      * @param mode
      *        The file mapping mode, see
      *        {@link FileChannel#map(FileChannel.MapMode, long, long)};
@@ -1042,7 +1047,8 @@ public abstract MappedByteBuffer map(MapMode mode, long position, long size)
      *         If some other I/O error occurs.
      *
      * @throws UnsupportedOperationException
-     *         If an unsupported map mode is specified.
+     *         If an unsupported map mode is specified, or if the implementation
+     *         does not support memory-mapped files
      *
      * @since 19
      */