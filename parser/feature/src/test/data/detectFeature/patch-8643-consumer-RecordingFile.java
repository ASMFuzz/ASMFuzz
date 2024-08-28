@@ -231,6 +231,8 @@ public void close() throws IOException {
      * @throws SecurityException if a security manager exists and its
      *                           {@code checkWrite} method denies write access to the
      *                           file
+     *
+     * @since 19
      */
     public void write(Path destination, Predicate<RecordedEvent> filter) throws IOException {
         Objects.requireNonNull(destination, "destination");