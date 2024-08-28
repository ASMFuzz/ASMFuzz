@@ -942,7 +942,7 @@ public String toString() {
      *         The size of the region to be mapped; must be non-negative and
      *         no greater than {@link java.lang.Integer#MAX_VALUE}
      *
-     * @return  The mapped byte buffer
+     * @return The mapped byte buffer
      *
      * @throws NonReadableChannelException
      *         If the {@code mode} is {@link MapMode#READ_ONLY READ_ONLY} or
@@ -997,61 +997,60 @@ public abstract MappedByteBuffer map(MapMode mode, long position, long size)
      *           of mapped memory associated with the returned mapped memory
      *           segment is unspecified and should not be relied upon.
      *
-     * @param mode
-     *        The file mapping mode, see
-     *        {@link FileChannel#map(FileChannel.MapMode, long, long)};
-     *        the mapping mode might affect the behavior of the returned memory
-     *        mapped segment (see {@link MemorySegment#force()}).
+     * @param   mode
+     *          The file mapping mode, see
+     *          {@link FileChannel#map(FileChannel.MapMode, long, long)};
+     *          the mapping mode might affect the behavior of the returned
+     *          memory mapped segment (see {@link MemorySegment#force()}).
      *
-     * @param offset
-     *        The offset (expressed in bytes) within the file at which the
-     *        mapped segment is to start.
+     * @param   offset
+     *          The offset (expressed in bytes) within the file at which the
+     *          mapped segment is to start.
      *
-     * @param size
-     *        The size (in bytes) of the mapped memory backing the memory
-     *        segment.
-
-     * @param session
-     *        The segment memory session.
+     * @param   size
+     *          The size (in bytes) of the mapped memory backing the memory
+     *          segment.
      *
-     * @return A new mapped memory segment.
+     * @param   session
+     *          The segment memory session.
      *
-     * @throws IllegalArgumentException
-     *         If {@code offset < 0}, {@code size < 0} or
-     *         {@code offset + size} overflows the range of {@code long}.
+     * @return  A new mapped memory segment.
      *
-     * @throws IllegalStateException
-     *         If the {@code session} is not
-     *         {@linkplain MemorySession#isAlive() alive}.
+     * @throws  IllegalArgumentException
+     *          If {@code offset < 0}, {@code size < 0} or
+     *          {@code offset + size} overflows the range of {@code long}.
      *
-     * @throws WrongThreadException
-     *         If this method is called from a thread other than the thread
-     *         {@linkplain MemorySession#ownerThread() owning} the
-     *         {@code session}.
+     * @throws  IllegalStateException
+     *          If the {@code session} is not
+     *          {@linkplain MemorySession#isAlive() alive}.
      *
-     * @throws NonReadableChannelException
-     *         If the {@code mode} is {@link MapMode#READ_ONLY READ_ONLY} or
-     *         an implementation specific map mode requiring read access,
-     *         but this channel was not opened for reading.
+     * @throws  WrongThreadException
+     *          If this method is called from a thread other than the thread
+     *          {@linkplain MemorySession#ownerThread() owning} the
+     *          {@code session}.
      *
-     * @throws NonWritableChannelException
-     *         If the {@code mode} is {@link MapMode#READ_WRITE READ_WRITE},
-     *         {@link MapMode#PRIVATE PRIVATE} or an implementation specific
-     *         map mode requiring write access, but this channel was not
-     *         opened for both reading and writing.
+     * @throws  NonReadableChannelException
+     *          If the {@code mode} is {@link MapMode#READ_ONLY READ_ONLY} or
+     *          an implementation specific map mode requiring read access,
+     *          but this channel was not opened for reading.
      *
-     * @throws IOException
-     *         If some other I/O error occurs.
+     * @throws  NonWritableChannelException
+     *          If the {@code mode} is {@link MapMode#READ_WRITE READ_WRITE},
+     *          {@link MapMode#PRIVATE PRIVATE} or an implementation specific
+     *          map mode requiring write access, but this channel was not
+     *          opened for both reading and writing.
      *
-     * @throws UnsupportedOperationException
-     *         If an unsupported map mode is specified.
+     * @throws  IOException
+     *          If some other I/O error occurs.
+     *
+     * @throws  UnsupportedOperationException
+     *          If an unsupported map mode is specified.
      *
-     * @since 19
+     * @since   19
      */
     @PreviewFeature(feature=PreviewFeature.Feature.FOREIGN)
-    public MemorySegment map(MapMode mode, long offset, long size,
-                                      MemorySession session)
-            throws IOException
+    public MemorySegment map(MapMode mode, long offset, long size, MemorySession session)
+        throws IOException
     {
         throw new UnsupportedOperationException();
     }