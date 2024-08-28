@@ -340,12 +340,13 @@ public ClassReader(final String className) throws IOException {
       * @return the content of the given input stream.
       * @throws IOException if a problem occurs during reading.
       */
+    @SuppressWarnings("PMD.UseTryWithResources")
     private static byte[] readStream(final InputStream inputStream, final boolean close)
             throws IOException {
         if (inputStream == null) {
             throw new IOException("Class not found");
         }
-        int bufferSize = calculateBufferSize(inputStream);
+        int bufferSize = computeBufferSize(inputStream);
         try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
             byte[] data = new byte[bufferSize];
             int bytesRead;
@@ -366,13 +367,12 @@ private static byte[] readStream(final InputStream inputStream, final boolean cl
         }
     }
 
-    private static int calculateBufferSize(final InputStream inputStream) throws IOException {
+    private static int computeBufferSize(final InputStream inputStream) throws IOException {
         int expectedLength = inputStream.available();
         /*
-          * Some implementations can return 0 while holding available data
-          * (e.g. new FileInputStream("/proc/a_file"))
-          * Also in some pathological cases a very small number might be returned,
-          * and in this case we use default size
+          * Some implementations can return 0 while holding available data (e.g. new
+          * FileInputStream("/proc/a_file")). Also in some pathological cases a very small number might
+          * be returned, and in this case we use a default size.
           */
         if (expectedLength < 256) {
             return INPUT_STREAM_DATA_CHUNK_SIZE;
@@ -891,7 +891,7 @@ private void readModuleAttributes(
             currentOffset += 2;
         }
 
-        // Read the  'provides_count' and 'provides' fields.
+        // Read the 'provides_count' and 'provides' fields.
         int providesCount = readUnsignedShort(currentOffset);
         currentOffset += 2;
         while (providesCount-- > 0) {